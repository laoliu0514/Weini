package cn.com.weini.task;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import cn.com.dl.expressnum.pojo.EcmYwJkfOrderMain;
import cn.com.dl.expressnum.pojo.EcmYwJkfOrderStatus;
import cn.com.dl.expressnum.service.EcmYwJkfOrderMainDataService;
import cn.com.dl.expressnum.service.EcmYwJkfOrderStatusDataService;
import cn.com.dl.expressnum.utils.JsonUtils;
import cn.com.weini.commons.WeiNiPostResult;

@Component("dlGetOrdersTask")
public class DlGetOrdersTask {

	// 获取订单主表
	@Autowired
	private EcmYwJkfOrderMainDataService ecmYwJkfOrderMainDataService;

	// 获取订单状态表信息
	@Autowired
	private EcmYwJkfOrderStatusDataService ecmYwJkfOrderStatusDataService;

	@Scheduled(cron = "*/10 * *  * * ?")
	public void getOrderFromWeiNi() {
		System.out.println("开始从数据库中查找待发货订单...");
		// shop_id_ 店铺id adfee792411c4068ac3efb80a979fb38
		// platform_id_ 来源平台id 14a408b4f2f04428bff0bfff5403a6ed
		// 1. 从订单主表中查询数据
		List<EcmYwJkfOrderMain> orderMainDataList = ecmYwJkfOrderMainDataService.getEcmYwJkfOrderMainDataList(
				"e331eba145ef487cbda0d1cc528d3eb2", "14a408b4f2f04428bff0bfff5403a6ed", "2017-04-23 00:00:00",
				"2017-08-23 23:59:59");
		if (orderMainDataList == null) {
			System.out.println("请求参数错误");
			return;
		}

		// 保存未反馈平台的 id
		List<EcmYwJkfOrderStatus> arrayList = new ArrayList<>();
		// 2. 从订单状态表中查询数据
		for (EcmYwJkfOrderMain ecmYwJkfOrderMain : orderMainDataList) {
			EcmYwJkfOrderStatus ecmYwJkfOrderStatus = ecmYwJkfOrderStatusDataService
					.getEcmYwJkfOrderStatusData(ecmYwJkfOrderMain.getId(), 0);
			if (ecmYwJkfOrderStatus == null) {
				continue;
			}
			if (ecmYwJkfOrderStatus.getCallBackFlag4().equals(0)
					|| ecmYwJkfOrderStatus.getCallBackFlag4().equals("0")) {
				// 判断是否已经反馈过平台, 如果没有反馈, 则加入数组
				arrayList.add(ecmYwJkfOrderStatus);
			}
		}

		// 3. 保存快递单号
		List<Map<String, String>> result = new ArrayList<>();
		for (EcmYwJkfOrderStatus orderStatus : arrayList) {
			// 从订单主表中查找快递单号
			for (EcmYwJkfOrderMain ecmYwJkfOrderMain : orderMainDataList) {
				if (orderStatus.getId().equals(ecmYwJkfOrderMain.getId())) {
					// 来源订单编号 + 快递公司 + 快递单号 source_order_no_
					Map<String, String> map = new HashMap<>();
					map.put("id", ecmYwJkfOrderMain.getId());
					map.put("source_order_no", ecmYwJkfOrderMain.getSourceOrderNo());
					map.put("tms_code", ecmYwJkfOrderMain.getTmsServiceCode());
					map.put("express_no", ecmYwJkfOrderMain.getWayBill());
					result.add(map);
				}
			}
		}

		// 4. 返回结果
		getResultStatus("success", result.size(), result);
		
		for (Map<String, String> map : result) {
			// 转换快递公司名称
			String tmsCode = map.get("tms_code");
			String oTmsCode = null;
			if (tmsCode.equals("STO")) {
				oTmsCode = "申通快递";
			} else if (tmsCode.equals("BSHT")) {
				oTmsCode = "百世汇通";
			} else if (tmsCode.equals("ZTO")) {
				oTmsCode = "中通快递";
			} else {
				oTmsCode = tmsCode;
			}
			Boolean isSuccess = sendBackToWeiNi(map.get("source_order_no"), oTmsCode, map.get("express_no"));
			if (isSuccess == true) {
				// 更新订单状态数据库 "1" 表示已经发送平台 "0" 表示未发送
				ecmYwJkfOrderStatusDataService.updateEcmYwJkfOrderStatus(map.get("id"), 0, "1",
						new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				System.out.println("反馈成功!!");
			} else {
				System.out.println("反馈失败!!");
			}
		}
		
		System.out.println("查找订单结束...");
	}

	/**
	 * 运单号反馈接口
	 * @param orderNo		订单编号
	 * @param logisticName	物流公司名称
	 * @param postId		快递单号
	 * return 				是否成功反馈平台
	 */
	public Boolean sendBackToWeiNi(String orderNo, String logisticName, String postId) {
		Map<String, Object> map = new HashMap<>();
		// 订单编号
		map.put("OrderNo", orderNo);
		// 物流公司
		map.put("LogisticName", logisticName);
		// 物流单号
		map.put("PostId", postId);

		Map<String, Object> map1 = new HashMap<>();
		map1.put("Delivery", map);

		CloseableHttpResponse response = getHttpResponse("/api/sup/orderDelivery.shtml", "orderDelivery", map1);
		Boolean isSuccess = false;
		if (response != null) {
			HttpEntity entity = response.getEntity();
			try {
				String string = EntityUtils.toString(entity, "utf-8");
				WeiNiPostResult weiNiPostResult = JsonUtils.jsonToPojo(string, WeiNiPostResult.class);
				isSuccess = weiNiPostResult.getSuccess();
			} catch (ParseException e) {
				e.printStackTrace();
				isSuccess = false;
			} catch (IOException e) {
				e.printStackTrace();
				isSuccess = false;
			}
		}
		return isSuccess;
	}

	/**
	 * 创建json字符串
	 * 
	 * @param msg
	 *            错误/成功信息
	 * @param totalCount
	 *            快递单总数
	 * @param result
	 *            结果
	 * @return
	 */
	private String getResultStatus(String msg, int totalCount, Object result) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", msg);
		map.put("total_count", totalCount);
		map.put("result", JsonUtils.objectToJson(result));
		return JsonUtils.objectToJson(map);
	}

	/**
	 * 返回post请求的 响应结果
	 * 
	 * @param url
	 *            请求的url
	 * @param interfacename
	 *            请求的接口名称
	 * @param map
	 *            请求参数, Map<String, Object>
	 * @return
	 */
	public CloseableHttpResponse getHttpResponse(String url, String interfacename, Map<String, Object> map) {
		String parenter = "2227";
		// 要发送的json内容即各接口的请求数据
		String content = JsonUtils.objectToJson(map);
		System.out.println(content);
		// token=md5(key+date+interfacename+content) date: 当前日期(格式为yyyy-MM-dd)
		// key:由唯妮供应链平台分配的密钥 content:消息体
		String currentTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String key = "0e30200492d011e78d5900163e00073b" + currentTime + interfacename + content;
		System.out.println(key);
		String token = DigestUtils.md5DigestAsHex(key.getBytes());
		System.out.println(token);
		// 创建默认httpClient
		CloseableHttpClient client = HttpClients.createDefault();
		// 拼接uri
		URI uri = null;
		try {
			uri = new URIBuilder().setScheme("http").setHost("121.41.84.251").setPort(9090).setPath(url).build();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		HttpPost post = new HttpPost(uri);
		// 设置请求头
		post.setHeader("interfacename", interfacename);
		post.setHeader("parenter", parenter);
		post.setHeader("token", token);
		// 设置请求体
		StringEntity stringEntity = new StringEntity(content, "utf-8");
		post.setEntity(stringEntity);

		System.out.println(post.getURI());
		CloseableHttpResponse response = null;
		try {
			response = client.execute(post);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

}

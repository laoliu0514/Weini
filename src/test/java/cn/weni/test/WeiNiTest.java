package cn.weni.test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
import org.junit.Test;
import org.springframework.util.DigestUtils;

import cn.com.weini.commons.WeiNiPostResult;
import cn.com.weini.commons.pojo.GetNiSuOrderPostDeliveryPO;
import cn.com.weini.commons.pojo.GetNiSuOrderResultPO;
import cn.com.weini.utils.JsonUtils;

public class WeiNiTest {
	/**
	 * 测试环境：121.41.84.251:9090 生产环境：http://vip.nysochina.com
	 * 
	 * 测试环境账号信息 parenter: 2227_866 key: 0e30200492d011e78d5900163e00073b
	 * 
	 * 仓库id：1775edd8a5334471ad93d40e861dad95
	 * warehouseOperatorId：34d982d35f034367bce10b527610ca0c 
	 * curr_code: 142
	 * 
	 */
	
	/**
	 * 返回post请求的 响应结果
	 * @param url				请求的url
	 * @param interfacename		请求的接口名称
	 * @param map				请求参数, Map<String, Object>
	 * @return
	 */
	
	
	public CloseableHttpResponse getHttpResponse(String url, String interfacename, Map<String, Object> map) {
		String parenter = "8554";
		// 要发送的json内容即各接口的请求数据
		String content = JsonUtils.objectToJson(map);
		System.out.println(content);
		// token=md5(key+date+interfacename+content) date: 当前日期(格式为yyyy-MM-dd)
		// key:由唯妮供应链平台分配的密钥 content:消息体
		String currentTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String key = "15508819da004b8d8e7af91915b086e6" + currentTime + interfacename + content;
		 System.out.println(key);
		String token = DigestUtils.md5DigestAsHex(key.getBytes());
		 System.out.println(token);
		// 创建默认httpClient
		CloseableHttpClient client = HttpClients.createDefault();
		// 拼接uri
		URI uri = null;
		try {
//			uri = new URIBuilder().setScheme("http").setHost("121.41.84.251").setPort(9090)
					uri = new URIBuilder().setScheme("http").setHost("vip.nysochina.com")
					.setPath(url).build();
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
	
	
	
	
	
	// 获取订单
	@Test
	public void test01() {
		Map<String, Object> map = new HashMap<>();
		// 查询修改开始时间(修改时间跨度不能大于一天)。格式:yyyy-MM-dd HH:mm:ss
		map.put("StartModified", "2017-11-27 16:20:00");
		// 查询修改结束时间，必须大于修改开始时间(修改时间跨度不能大于一天)，格式:yyyy-MM-dd HH:mm:ss。
		map.put("EndModified", "2017-11-27 16:40:59");
		// 交易状态，默认查询所有交易状态的数据，除了默认值外每次只能查询一种状态。
		// TRADE_STATUS_DELIVERY_WAIT 待发货
		// TRADE_STATUS_DELIVERY_FINISHED 已发货
		// TRADE_STATUS_FINISHED 已完成
		map.put("Status", "TRADE_STATUS_DELIVERY_WAIT");
//		map.put("Status", "TRADE_STATUS_DELIVERY_FINISHED");
		// 页码：供调起方分页查询。为防止漏单页码需按倒序获取数据
		map.put("PageNo", 1);
		// 每页条数:最大100
		map.put("PageNum", 100);
		// 是否返回总订单数，为提高效率建议每个时间点的第一次访问才设置为true
		map.put("IfReturnTotal", true);
		CloseableHttpResponse response = getHttpResponse("/api/sup/searchOrder.shtml", "searchOrder", map);
		
		if(response != null) {
			HttpEntity entity = response.getEntity();
			try {
				String result=EntityUtils.toString(entity, "utf-8");
				System.out.println("----"+result);
				GetNiSuOrderResultPO weiNiPostResult = JsonUtils.jsonToPojo(result, GetNiSuOrderResultPO.class);
				System.out.println(weiNiPostResult);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	// 订单发货 /api/sup/orderDelivery.shtml
	@Test
	public void test02() {
		Map<String, Object> map = new HashMap<>();
		// 订单编号
		map.put("orderNo", "NS-170731610966792227");
		// 物流公司
		map.put("LogisticName", "圆通快递");
		// 物流单号
		map.put("PostId", "809667677218");
		GetNiSuOrderPostDeliveryPO deliveryPO=new GetNiSuOrderPostDeliveryPO();
		deliveryPO.setOrderNo("NS-170731610966792227");
		deliveryPO.setLogisticName("圆通快递");
		deliveryPO.setPostId("809667677218");
		
		
		Map<String, Object> map1 = new HashMap<>();
		map1.put("Delivery", deliveryPO);
		
		CloseableHttpResponse response = getHttpResponse("/api/sup/orderDelivery.shtml", "orderDelivery", map1);
		if (response != null) {
			HttpEntity entity = response.getEntity();
			try {
				String string = EntityUtils.toString(entity, "utf-8");
				System.out.println(string);
				WeiNiPostResult weiNiPostResult = JsonUtils.jsonToPojo(string, WeiNiPostResult.class);
				
				System.out.println(weiNiPostResult);
				System.out.println(weiNiPostResult.getSuccess());
				System.out.println(weiNiPostResult.getResult());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 库存同步
	@Test
	public void test03() {
		Map<String, Object> map = new HashMap<>();
		// 商品编码
		map.put("SupGoodsNo", "SSUNT001");
		// 商品库存
		map.put("StockQty", 1000);
		
		// 库存同步数据
		Map<String, Object> map1 = new HashMap<>();
		map1.put("StockSyn", map);
		
		CloseableHttpResponse response = getHttpResponse("/api/sup/supStockSynchro.shtml", "supStockSynchro", map1);
		if (response != null) {
			HttpEntity entity = response.getEntity();
			try {
				System.out.println(EntityUtils.toString(entity, "utf-8"));
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace(); 
			}
		}
	}
}

package cn.weni.test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
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
import org.joda.time.DateTime;
import org.json.JSONObject;
import org.junit.Test;

import cn.com.weini.commons.pojo.GetNiSuOrderResultPO;
import cn.com.weini.utils.JsonUtils;

public class MaiBaoTest {
	private static String partner = "MD_GUANGHUIMAOYI";
    private static String key = "e0ae3b9bca594c97aa37caf1d5bcc100";
    

	
	
	
	@Test
	public void test01(){
		    Map<String, Object> params = new HashMap<>();
	        params.put("startTime","2017-11-19 23:30:00");
	        params.put("endTime","2017-11-20 23:30:00");
	        params.put("status",2);

	        Map<String, Object> reqData = new HashMap<>();
	        reqData.put("partner", partner);
	        reqData.put("timestamp", DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
	        reqData.put("params", params);
	        
	        String sign = DigestUtils.md5Hex(key + JsonUtils.objectToJson(reqData) + key).toUpperCase();
	        System.out.println(sign);
	        
	     // 创建默认httpClient
			CloseableHttpClient client = HttpClients.createDefault();
			// 拼接uri
			URI uri = null;
			try {
//				uri = new URIBuilder().setScheme("http").setHost("121.41.84.251").setPort(9090)
						uri = new URIBuilder().setScheme("http").setHost("openapi.gegejia.com:8902/api/")
						.setPath("/order/findOrders").build();
						System.out.println("---------");
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}

			HttpPost post = new HttpPost(uri);
			// 设置请求头
			
			post.setHeader("sign", sign);
			// 设置请求体
			StringEntity stringEntity = new StringEntity(JsonUtils.objectToJson(reqData), "utf-8");
			post.setEntity(stringEntity);

			
			System.out.println(post.getURI());
			CloseableHttpResponse response = null;
			try {
				System.out.println("====");
				response = client.execute(post);
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(response != null) {
				HttpEntity entity = response.getEntity();
				try {
					String result=EntityUtils.toString(entity, "utf-8");
					System.out.println("----"+result);
									
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	
	
	
	@Test
	public void test02(){
		 Map<String, Object> params = new HashMap<>();
	        

	        Map<String, Object> reqData = new HashMap<>();
	        reqData.put("partner", partner);
	        reqData.put("timestamp", DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
	        reqData.put("params", params);
	        
	        String sign = DigestUtils.md5Hex(key + JsonUtils.objectToJson(reqData) + key).toUpperCase();
	        System.out.println(sign);
	        
	     // 创建默认httpClient
			CloseableHttpClient client = HttpClients.createDefault();
			// 拼接uri
			URI uri = null;
			try {
//				uri = new URIBuilder().setScheme("http").setHost("121.41.84.251").setPort(9090)
						uri = new URIBuilder().setScheme("http").setHost("openapi.gegejia.com:8902/api/")
						.setPath("/express/names").build();
						System.out.println("---------");
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}

			HttpPost post = new HttpPost(uri);
			// 设置请求头
			
			post.setHeader("sign", sign);
			// 设置请求体
			StringEntity stringEntity = new StringEntity(JsonUtils.objectToJson(reqData), "utf-8");
			post.setEntity(stringEntity);

			
			System.out.println(post.getURI());
			CloseableHttpResponse response = null;
			try {
				System.out.println("====");
				response = client.execute(post);
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(response != null) {
				HttpEntity entity = response.getEntity();
				try {
					String result=EntityUtils.toString(entity, "utf-8");
					System.out.println("----"+result);
									
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	
	@Test
	public void test03(){
		 Map<String, Object> params = new HashMap<>();
//	        params.put("startTime","2017-11-19 23:30:00");
//	        params.put("endTime","2017-11-20 23:30:00");
//	        params.put("status",2);
		 
		    params.put("type","1");
	        params.put("orderNumber","161110010675245");
	        params.put("expressName","圆通速递");
	        params.put("expressName","516588912");

	        Map<String, Object> reqData = new HashMap<>();
	        reqData.put("partner", partner);
	        reqData.put("timestamp", DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
	        reqData.put("params", params);
	        
	        String sign = DigestUtils.md5Hex(key + JsonUtils.objectToJson(reqData) + key).toUpperCase();
	        System.out.println(sign);
	        
	     // 创建默认httpClient
			CloseableHttpClient client = HttpClients.createDefault();
			// 拼接uri
			URI uri = null;
			try {
//				uri = new URIBuilder().setScheme("http").setHost("121.41.84.251").setPort(9090)
						uri = new URIBuilder().setScheme("http").setHost("openapi.gegejia.com:8902/api/")
						.setPath("/order/sendOrder").build();
						System.out.println("---------");
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}

			HttpPost post = new HttpPost(uri);
			// 设置请求头
			
			post.setHeader("sign", sign);
			// 设置请求体
			StringEntity stringEntity = new StringEntity(JsonUtils.objectToJson(reqData), "utf-8");
			post.setEntity(stringEntity);

			
			System.out.println(post.getURI());
			CloseableHttpResponse response = null;
			try {
				System.out.println("====");
				response = client.execute(post);
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(response != null) {
				HttpEntity entity = response.getEntity();
				try {
					String result=EntityUtils.toString(entity, "utf-8");
					System.out.println("----"+result);
									
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
}

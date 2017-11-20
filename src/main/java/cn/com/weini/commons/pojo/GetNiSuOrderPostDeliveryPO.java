package cn.com.weini.commons.pojo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetNiSuOrderPostDeliveryPO implements Serializable{
	@JsonProperty("OrderNo")
	private String OrderNo;
	@JsonProperty("LogisticName")
	private String LogisticName;
	@JsonProperty("PostId")
	private String PostId;
	public String getOrderNo() {
		return OrderNo;
	}
	public void setOrderNo(String orderNo) {
		OrderNo = orderNo;
	}
	public String getLogisticName() {
		return LogisticName;
	}
	public void setLogisticName(String logisticName) {
		LogisticName = logisticName;
	}
	public String getPostId() {
		return PostId;
	}
	public void setPostId(String postId) {
		PostId = postId;
	}
	@Override
	public String toString() {
		return "GetNiSuOrderPostDeliveryPO [OrderNo=" + OrderNo + ", LogisticName=" + LogisticName + ", PostId="
				+ PostId + "]";
	}
	
	
}

package cn.com.weini.commons.pojo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class GetNiSuOrderResultDetailPO implements Serializable{
	
	@JsonProperty("Orders")
	private List<GetNiSuOrderPO> Orders;
	@JsonProperty("TotalResults")
	private Double TotalResults;
	
	
	public List<GetNiSuOrderPO> getOrders() {
		return Orders;
	}
	public void setOrders(List<GetNiSuOrderPO> Orders) {
		this.Orders = Orders;
	}
	public Double getTotalResults() {
		return TotalResults;
	}
	public void setTotalResults(Double TotalResults) {
		this.TotalResults = TotalResults;
	}
	@Override
	public String toString() {
		return "GetNiSuOrderResultDetailPO [Orders=" + Orders + ", TotalResults=" + TotalResults + "]";
	}

	
	
	
}

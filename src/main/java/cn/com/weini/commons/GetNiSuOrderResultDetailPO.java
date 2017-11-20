package cn.com.weini.commons;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//@JsonIgnoreProperties(ignoreUnknown = true)
public class GetNiSuOrderResultDetailPO implements Serializable{
	
	private List<WeiNiOrder> Orders;
	private int TotalResults;
	
	
	public List<WeiNiOrder> getOrders() {
		return Orders;
	}
	public void setOrders(List<WeiNiOrder> Orders) {
		this.Orders = Orders;
	}
	public int getTotalResults() {
		return TotalResults;
	}
	public void setTotalResults(int TotalResults) {
		this.TotalResults = TotalResults;
	}
	@Override
	public String toString() {
		return "GetNiSuOrderResultDetailPO [Orders=" + Orders + ", TotalResults=" + TotalResults + "]";
	}
	
	
	
}

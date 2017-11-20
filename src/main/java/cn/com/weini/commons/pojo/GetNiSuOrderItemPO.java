package cn.com.weini.commons.pojo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import cn.com.dl.expressnum.utils.JsonUtils;

public class GetNiSuOrderItemPO implements Serializable{
	
	public static void main(String[] args) {
		String result=JsonUtils.objectToJson(new GetNiSuOrderItemPO());
		System.out.println(result);
	}
	/**
	 * 购买数量
	 */
	@JsonProperty("BuyQty")
	private Number BuyQty;
	
	/**
	 * 购买单价(含税)
	 */
	@JsonProperty("BuyPrice")
	private Number BuyPrice;
	
	/**
	 * 供应商商品编码
	 */
	@JsonProperty("SupGoodsNo")
	private String SupGoodsNo;
	
	@JsonProperty("SettlePrice")
	private Number SettlePrice;
	
	
	
	public Number getSettlePrice() {
		return SettlePrice;
	}

	public void setSettlePrice(Number settlePrice) {
		SettlePrice = settlePrice;
	}

	public Number getBuyQty() {
		return BuyQty;
	}

	public void setBuyQty(Number buyQty) {
		BuyQty = buyQty;
	}

	public Number getBuyPrice() {
		return BuyPrice;
	}

	public void setBuyPrice(Number buyPrice) {
		BuyPrice = buyPrice;
	}

	public String getSupGoodsNo() {
		return SupGoodsNo;
	}

	public void setSupGoodsNo(String supGoodsNo) {
		SupGoodsNo = supGoodsNo;
	}

	@Override
	public String toString() {
		return "OrderItem [BuyQty=" + BuyQty + ", BuyPrice=" + BuyPrice + ", SupGoodsNo=" + SupGoodsNo + "]";
	}
}

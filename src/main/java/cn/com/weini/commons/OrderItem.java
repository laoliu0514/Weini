package cn.com.weini.commons;

public class OrderItem {
	/**
	 * 购买数量
	 */
	private Number BuyQty;
	
	/**
	 * 购买单价(含税)
	 */
	private Number BuyPrice;
	
	/**
	 * 供应商商品编码
	 */
	private String SupGoodsNo;

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

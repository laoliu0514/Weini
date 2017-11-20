package cn.com.weini.commons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class WeiNiOrder implements Serializable{
	/**
	 * 订单时间
	 */
	private Date OrderTime;
	
	/**
	 * 支付人(支付人为空时显示收货人)
	 */
	private String Payer;
	
	/**
	 * 收货人
	 */
	private String ConsigneeName;
	
	/**
	 * 联系电话
	 */
	private String ConsigneeNumber;
	
	/**
	 * 身份证号
	 */
	private String IdCard;
	
	/**
	 * 省
	 */
	private String Province;
	
	/**
	 * 市
	 */
	private String City;
	
	/**
	 * 区
	 */
	private String District;
	
	/**
	 * 详细地址
	 */
	private String DetailedAddres;
	
	/**
	 * 备注信息
	 */
	private String Remark;
	
	/**
	 * 邮费(单位：元)
	 */
	private Number PostalTotal;
	
	/**
	 * 订单总价(单位：元)
	 */
	private Number OrderTotal;
	
	/**
	 * 结算金额(单位：元)
	 */
	private Number SettleTotal;
	
	/**
	 * 优惠金额(单位：元)
	 */
	private Number DiscountTotal;
	
	/**
	 * 总税额(单位：元)
	 */
	private Number TaxFee;
	
	/**
	 * 供应商仓库名称
	 */
	private String WmsName;
	
	/**
	 * 订单状态
	 */
	private String OrderStatus;
	
	/**
	 * 运单单号
	 */
	private String PostId;
	
	/**
	 * 物流方式
	 */
	private String LogisticName;
	
	/**
	 * 发货时间
	 */
	private Date SendTime;
	
	/**
	 * 订单商品明细
	 */
	private ArrayList<OrderItem> OrderItems;

	public Date getOrderTime() {
		return OrderTime;
	}

	public void setOrderTime(Date orderTime) {
		OrderTime = orderTime;
	}

	public String getPayer() {
		return Payer;
	}

	public void setPayer(String payer) {
		Payer = payer;
	}

	public String getConsigneeName() {
		return ConsigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		ConsigneeName = consigneeName;
	}

	public String getConsigneeNumber() {
		return ConsigneeNumber;
	}

	public void setConsigneeNumber(String consigneeNumber) {
		ConsigneeNumber = consigneeNumber;
	}

	public String getIdCard() {
		return IdCard;
	}

	public void setIdCard(String idCard) {
		IdCard = idCard;
	}

	public String getProvince() {
		return Province;
	}

	public void setProvince(String province) {
		Province = province;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getDistrict() {
		return District;
	}

	public void setDistrict(String district) {
		District = district;
	}

	public String getDetailedAddres() {
		return DetailedAddres;
	}

	public void setDetailedAddres(String detailedAddres) {
		DetailedAddres = detailedAddres;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		Remark = remark;
	}

	public Number getPostalTotal() {
		return PostalTotal;
	}

	public void setPostalTotal(Number postalTotal) {
		PostalTotal = postalTotal;
	}

	public Number getOrderTotal() {
		return OrderTotal;
	}

	public void setOrderTotal(Number orderTotal) {
		OrderTotal = orderTotal;
	}

	public Number getSettleTotal() {
		return SettleTotal;
	}

	public void setSettleTotal(Number settleTotal) {
		SettleTotal = settleTotal;
	}

	public Number getDiscountTotal() {
		return DiscountTotal;
	}

	public void setDiscountTotal(Number discountTotal) {
		DiscountTotal = discountTotal;
	}

	public Number getTaxFee() {
		return TaxFee;
	}

	public void setTaxFee(Number taxFee) {
		TaxFee = taxFee;
	}

	public String getWmsName() {
		return WmsName;
	}

	public void setWmsName(String wmsName) {
		WmsName = wmsName;
	}

	public String getOrderStatus() {
		return OrderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		OrderStatus = orderStatus;
	}

	public String getPostId() {
		return PostId;
	}

	public void setPostId(String postId) {
		PostId = postId;
	}

	public String getLogisticName() {
		return LogisticName;
	}

	public void setLogisticName(String logisticName) {
		LogisticName = logisticName;
	}

	public Date getSendTime() {
		return SendTime;
	}

	public void setSendTime(Date sendTime) {
		SendTime = sendTime;
	}

	public ArrayList<OrderItem> getOrderItems() {
		return OrderItems;
	}

	public void setOrderItems(ArrayList<OrderItem> orderItems) {
		OrderItems = orderItems;
	}

	@Override
	public String toString() {
		return "WeiNiOrder [OrderTime=" + OrderTime + ", Payer=" + Payer + ", ConsigneeName=" + ConsigneeName
				+ ", ConsigneeNumber=" + ConsigneeNumber + ", IdCard=" + IdCard + ", Province=" + Province + ", City="
				+ City + ", District=" + District + ", DetailedAddres=" + DetailedAddres + ", Remark=" + Remark
				+ ", PostalTotal=" + PostalTotal + ", OrderTotal=" + OrderTotal + ", SettleTotal=" + SettleTotal
				+ ", DiscountTotal=" + DiscountTotal + ", TaxFee=" + TaxFee + ", WmsName=" + WmsName + ", OrderStatus="
				+ OrderStatus + ", PostId=" + PostId + ", LogisticName=" + LogisticName + ", SendTime=" + SendTime
				+ ", OrderItems=" + OrderItems + "]";
	}
}

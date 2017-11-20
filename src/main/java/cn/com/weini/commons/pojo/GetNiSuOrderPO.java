package cn.com.weini.commons.pojo;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetNiSuOrderPO implements Serializable{
	
	    @JsonProperty("SsId")
	    private String SsId;
		public String getSsId() {
			return SsId;
		}

		public void setSsId(String ssId) {
			SsId = ssId;
		}

		/**
		 * 订单编号
		 */
	    @JsonProperty("OrderNo")
	    private String OrderNo;
		/**
		 * 订单时间
		 */
	    @JsonProperty("OrderTime")
		private String OrderTime;
		
		/**
		 * 支付人(支付人为空时显示收货人)
		 */
	    
	    @JsonProperty("Payer")
		private String Payer;
		
		/**
		 * 收货人
		 */
	    @JsonProperty("ConsigneeName")
		private String ConsigneeName;
		
		/**
		 * 联系电话
		 */
	    @JsonProperty("ConsigneeNumber")
		private String ConsigneeNumber;
		
		/**
		 * 身份证号
		 */
	    @JsonProperty("IdCard")
		private String IdCard;
		
		/**
		 * 省
		 */
	    @JsonProperty("Province")
		private String Province;
		
		/**
		 * 市
		 */
	    @JsonProperty("City")
		private String City;
		
		/**
		 * 区
		 */
	    @JsonProperty("District")
		private String District;
		
		/**
		 * 详细地址
		 */
	    @JsonProperty("DetailedAddres")
		private String DetailedAddres;
		
		/**
		 * 备注信息
		 */
	    @JsonProperty("Remark")
		private String Remark;
		
		/**
		 * 邮费(单位：元)
		 */
	    @JsonProperty("PostalTotal")
		private Number PostalTotal;
		
		/**
		 * 订单总价(单位：元)
		 */
	    @JsonProperty("OrderTotal")
		private Number OrderTotal;
		
		/**
		 * 结算金额(单位：元)
		 */
	    @JsonProperty("SettleTotal")
		private Number SettleTotal;
		
		/**
		 * 优惠金额(单位：元)
		 */
	    @JsonProperty("DiscountTotal")
		private Number DiscountTotal;
		
		/**
		 * 总税额(单位：元)
		 */
	    @JsonProperty("TaxFee")
		private Number TaxFee;
		
		/**
		 * 供应商仓库名称
		 */
	    @JsonProperty("WmsName")
		private String WmsName;
		
		/**
		 * 订单状态
		 */
	    @JsonProperty("OrderStatus")
		private String OrderStatus;
		
		/**
		 * 运单单号
		 */
	    @JsonProperty("PostId")
		private String PostId;
		
		/**
		 * 物流方式
		 */
	    @JsonProperty("LogisticName")
		private String LogisticName;
		
		/**
		 * 发货时间
		 */
	    @JsonProperty("SendTime")
		private String SendTime;
		
		/**
		 * 订单商品明细
		 */
	    @JsonProperty("OrderItems")
		private ArrayList<GetNiSuOrderItemPO> OrderItems;

		public String getOrderTime() {
			return OrderTime;
		}

		public void setOrderTime(String orderTime) {
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

		public String getSendTime() {
			return SendTime;
		}

		public void setSendTime(String sendTime) {
			SendTime = sendTime;
		}

		public ArrayList<GetNiSuOrderItemPO> getOrderItems() {
			return OrderItems;
		}

		public void setOrderItems(ArrayList<GetNiSuOrderItemPO> orderItems) {
			OrderItems = orderItems;
		}
		
		
		public String getOrderNo() {
			return OrderNo;
		}

		public void setOrderNo(String orderNo) {
			OrderNo = orderNo;
		}

		@Override
		public String toString() {
			return "GetNiSuOrderPO [OrderNo=" + OrderNo + ", OrderTime=" + OrderTime + ", Payer=" + Payer
					+ ", ConsigneeName=" + ConsigneeName + ", ConsigneeNumber=" + ConsigneeNumber + ", IdCard=" + IdCard
					+ ", Province=" + Province + ", City=" + City + ", District=" + District + ", DetailedAddres="
					+ DetailedAddres + ", Remark=" + Remark + ", PostalTotal=" + PostalTotal + ", OrderTotal="
					+ OrderTotal + ", SettleTotal=" + SettleTotal + ", DiscountTotal=" + DiscountTotal + ", TaxFee="
					+ TaxFee + ", WmsName=" + WmsName + ", OrderStatus=" + OrderStatus + ", PostId=" + PostId
					+ ", LogisticName=" + LogisticName + ", SendTime=" + SendTime + ", OrderItems=" + OrderItems + "]";
		}

		
		
	}


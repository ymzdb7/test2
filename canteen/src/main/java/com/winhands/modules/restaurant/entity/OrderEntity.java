package com.winhands.modules.restaurant.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderEntity implements Serializable{

	/**
	 * 订单管理
	 */
	private static final long serialVersionUID = 1L;
	private Long id;//订单id
	private Date orderTime;//订单时间
	private String orderState;//订单状态1未付款2已付款待提货3已提货4退货5订单取消6其它
	private String orderPhone;//订单电话
	private String orConsignee;//订单收货 人
	private Integer userId;//用户id
	private String address;//属地
	private String orderNumber;//订单号
	private BigDecimal allPrice;
	private List<OrderAdDishesHeEntity> orderAdDishesHe;
	
	public BigDecimal getAllPrice() {
		return allPrice;
	}
	public void setAllPrice(BigDecimal allPrice) {
		this.allPrice = allPrice;
	}
	public List<OrderAdDishesHeEntity> getOrderAdDishesHe() {
		return orderAdDishesHe;
	}
	public void setOrderAdDishesHe(List<OrderAdDishesHeEntity> orderAdDishesHe) {
		this.orderAdDishesHe = orderAdDishesHe;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	public String getOrderPhone() {
		return orderPhone;
	}
	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}
	public String getOrConsignee() {
		return orConsignee;
	}
	public void setOrConsignee(String orConsignee) {
		this.orConsignee = orConsignee;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	


}

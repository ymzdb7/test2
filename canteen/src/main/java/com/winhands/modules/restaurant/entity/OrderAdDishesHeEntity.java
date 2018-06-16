package com.winhands.modules.restaurant.entity;


import java.io.Serializable;
import java.math.BigDecimal;
/**
 * 菜品管理
 */
public class OrderAdDishesHeEntity implements Serializable{
	/**
	 * 订单商品关联信息
	 */
	private static final long serialVersionUID = 1L;
	private String advanceDishes;//商品名
	private Integer advDishesCount;//数量 
	private BigDecimal advDishesPrice;//商品销售当时价格
	private BigDecimal totalPrice;
	
	public void setTotalPrice() {
		if(advDishesPrice!=null) {
		this.totalPrice = advDishesPrice.multiply(new BigDecimal(advDishesCount));
		}
	}

	public BigDecimal getTotalPrice() {
		BigDecimal aa=null;
		if(advDishesPrice!=null) {
			aa=advDishesPrice.multiply(new BigDecimal(advDishesCount));
		}
		return  aa;
		
	}

	public String getAdvanceDishes() {
		return advanceDishes;
	}

	public void setAdvanceDishes(String advanceDishes) {
		this.advanceDishes = advanceDishes;
	}

	public Integer getAdvDishesCount() {
		return advDishesCount;
	}

	public void setAdvDishesCount(Integer advDishesCount) {
		this.advDishesCount = advDishesCount;
	}

	public BigDecimal getAdvDishesPrice() {
		return advDishesPrice;
	}

	public void setAdvDishesPrice(BigDecimal advDishesPrice) {
		this.advDishesPrice = advDishesPrice;
	}
	


}

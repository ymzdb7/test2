package com.winhands.modules.restaurant.entity;


import java.io.Serializable;
import java.math.BigDecimal;
/**
 * 菜品管理
 */
public class AdDishesHeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id; // ID
	private String advanceDishes;//预定菜名
	private BigDecimal advDishesPrice;//预定菜品价格
	private Integer count;//预定菜品数量
	private Integer counts;//库存数量
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAdvanceDishes() {
		return advanceDishes;
	}
	public void setAdvanceDishes(String advanceDishes) {
		this.advanceDishes = advanceDishes;
	}
	public BigDecimal getAdvDishesPrice() {
		return advDishesPrice;
	}
	public void setAdvDishesPrice(BigDecimal advDishesPrice) {
		this.advDishesPrice = advDishesPrice;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getCounts() {
		return counts;
	}
	public void setCounts(Integer counts) {
		this.counts = counts;
	}
	
	
	
}

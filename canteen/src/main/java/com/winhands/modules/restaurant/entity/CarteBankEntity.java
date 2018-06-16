package com.winhands.modules.restaurant.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * 菜单库管理
 */
public class CarteBankEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * ID
	 */
	private Long id;

	/**
	 * 菜单标题
	 */
	private String title;

	/**
	 * 日期
	 */
	
	private Date createDate;

	
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}




	
}

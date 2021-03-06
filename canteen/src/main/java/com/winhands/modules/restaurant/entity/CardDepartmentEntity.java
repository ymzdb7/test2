package com.winhands.modules.restaurant.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * 招待卡管理
 */
public class CardDepartmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * ID
	 */
	private Long id;

	/**
	 * 招待卡管理
	 */
	private String cardNo;
	
	private String department;
	

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	


	
}

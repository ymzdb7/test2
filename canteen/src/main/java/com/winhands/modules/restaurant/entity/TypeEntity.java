package com.winhands.modules.restaurant.entity;
import java.io.Serializable;
import java.util.List;
/**
 * 菜品类型单管理
 */
public class TypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * ID
	 */
	private Long id;

	/**
	 * 菜品类型
	 */
	private String typeName;
	
	private List<CarteTypeDishesEntity> cartdishList;
	


	public List<CarteTypeDishesEntity> getCartdishList() {
		return cartdishList;
	}

	public void setCartdishList(List<CarteTypeDishesEntity> cartdishList) {
		this.cartdishList = cartdishList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
}

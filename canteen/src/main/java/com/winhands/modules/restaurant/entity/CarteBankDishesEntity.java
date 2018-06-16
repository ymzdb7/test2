package com.winhands.modules.restaurant.entity;
import java.io.Serializable;
import java.util.List;
/**
 * 菜单库菜品关联信息管理
 */
public class CarteBankDishesEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * ID
	 */
	private Long id;

	/**
	 * 菜单id
	 */
	private Long carteBankId;
	/**
	 * 菜单idList
	 */
	private List<Long> idList;
	/**
	 * 菜品种类id
	 */
	private Long typeId;
	
	
	/**
	 * 菜品id
	 */
	private Long dishesId;

	
	/**
	 * 菜品名
	 */
	
	private String dishes;
	/**
	 * 菜品种类
	 */
	
	private String typeName;
	
	/**
	 * 菜品图片路径
	 */
	private String dishesPicPath;
	/**
	 * 菜品文件名
	 */
	private String dishesPicName;
	/**
	 * html路径
	 */
	private String detailHtml;
	/**
	 * 菜品详情
	 */
	private String	dishesDetail;
	/**
	 * 创建人id
	 */
	private String	createUserId;
	/**
	 * 属地
	 */	
	
	private  String	address;
	
	
	public String getDishesPicPath() {
		return dishesPicPath;
	}

	public void setDishesPicPath(String dishesPicPath) {
		this.dishesPicPath = dishesPicPath;
	}

	public String getDishesPicName() {
		return dishesPicName;
	}

	public void setDishesPicName(String dishesPicName) {
		this.dishesPicName = dishesPicName;
	}

	public String getDetailHtml() {
		return detailHtml;
	}

	public void setDetailHtml(String detailHtml) {
		this.detailHtml = detailHtml;
	}

	public String getDishesDetail() {
		return dishesDetail;
	}

	public void setDishesDetail(String dishesDetail) {
		this.dishesDetail = dishesDetail;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getDishes() {
		return dishes;
	}

	public void setDishes(String dishes) {
		this.dishes = dishes;
	}

	public List<Long> getIdList() {
		return idList;
	}

	public void setIdList(List<Long> idList) {
		this.idList = idList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Long getCarteBankId() {
		return carteBankId;
	}

	public void setCarteBankId(Long carteBankId) {
		this.carteBankId = carteBankId;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public Long getDishesId() {
		return dishesId;
	}

	public void setDishesId(Long dishesId) {
		this.dishesId = dishesId;
	}
	
	
}

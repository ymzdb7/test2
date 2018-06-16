package com.winhands.modules.restaurant.entity;

import java.io.Serializable;
import java.sql.Timestamp;


public class DinnerOrdersEntity implements Serializable{
private static final long serialVersionUID = 1L;
	
private Integer id;//编号
private String userName;//订餐用户姓名
private String mobile;//用户手机号
private String address;//订餐属地
/*private Date createTime;//订餐时间
*/
private Timestamp createTime;//订餐时间
private String department;//部门名称
private String status;


public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}


public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}

public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Timestamp getCreateTime() {
	return createTime;
}
public void setCreateTime(Timestamp createTime) {
	this.createTime = createTime;
}

}

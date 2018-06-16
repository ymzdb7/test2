package com.winhands.modules.restaurant.service;

import java.util.List;
import java.util.Map;

import com.winhands.modules.restaurant.entity.DinnerOrdersEntity;
import com.winhands.modules.restaurant.entity.DishesEntity;

/**
 * 晚餐预定管理
 * 
 */
public interface DinnerOrdersService {
	
	List<DinnerOrdersEntity> queryList(Map<String, Object> map);
	List<DinnerOrdersEntity> queryList1(Map<String, Object> map);
	
	List<DinnerOrdersEntity> querySelList(Map<String, Object> map);
	List<DinnerOrdersEntity> queryDateList(Map<String, Object> map);
	List<DinnerOrdersEntity> queryListDu(Map<String, Object> map);
	
	
	int queryTotal(Map<String, Object> map);
	int queryTotal1(int departmentId);
	int queryTotal2(Map<String, Object> map);
	int querySelTotal(Map<String, Object> map);
	
	/**
	 * 保存订单信息
	 */
	void save(DinnerOrdersEntity orders);
	
	/**
	 * 修改订单信息	 */
	void update(DinnerOrdersEntity orders);
	
	/**
	 * 删除订单信息
	 */
	void deleteBatch(Long[] ids);
	
	void updateState(Long[] ids);
	
	/**
	 * 查询订单信息
	 */
	DinnerOrdersEntity queryObject(Long id);
}

package com.winhands.modules.restaurant.service;

import java.util.List;
import java.util.Map;

import com.winhands.modules.restaurant.entity.AdDishesHeEntity;
import com.winhands.modules.restaurant.entity.OrderAdvanceDishesEntity;

/**
 *订单预定菜品管理
 * 
 */

public interface OrderAdvanceDishesService {
	List<OrderAdvanceDishesEntity> queryList(Map<String, Object> map);
	int queryTotal(Map<String, Object> map);
	OrderAdvanceDishesEntity queryObject(Map<String, Object> map);
	List<AdDishesHeEntity> queryListG(Map<String, Object> map);
	
	/**
	 * 保存
	 */
	void save(OrderAdvanceDishesEntity orderAdvanceDishes);
	
	/**
	 * 修改
	 * */
	void update(OrderAdvanceDishesEntity orderAdvanceDishes);
	
	/**
	 * 删除
	 */
	void deleteBatch(Long[] ids);
	
	/**
	 * 查询
	 */
	OrderAdvanceDishesEntity queryObject(Long id);
		
}

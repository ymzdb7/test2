package com.winhands.modules.restaurant.service;

import java.util.List;
import java.util.Map;

import com.winhands.modules.restaurant.entity.AdDishesHeeEntity;

/**
 *菜品统计管理
 * 
 */

public interface AdDishesCountsService {
	List<AdDishesHeeEntity> queryList(Map<String, Object> map);
	int queryTotal(Map<String, Object> map);
	AdDishesHeeEntity queryObject(Map<String, Object> map);
	List<AdDishesHeeEntity> queryListYes(Map<String, Object> map);
	
	/**
	 * 保存菜品类型
	 */
	void save(AdDishesHeeEntity adDishesHee);
	
	/**
	 * 修改菜品类型
	 * */
	void update(AdDishesHeeEntity adDishesHee);
	
	/**
	 * 删除菜品类型
	 */
	void deleteBatch(Long[] ids);
	
	/**
	 * 查询菜品类型
	 */
	AdDishesHeeEntity queryObject(Long id);
		
}

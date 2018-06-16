package com.winhands.modules.restaurant.service;

import java.util.List;
import java.util.Map;

import com.winhands.modules.restaurant.entity.DishesEntity;

/**
 * 菜品管理
 * 
 */
public interface DishesService {
	
	List<DishesEntity> queryList(Map<String, Object> map);
	
	List<DishesEntity> querySelList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	int querySelTotal(Map<String, Object> map);
	List<DishesEntity> typeDish(String[] typeS);
	
	/**
	 * 保存菜品
	 */
	void save(DishesEntity dishes);
	
	/**
	 * 修改菜品	 */
	void update(DishesEntity dishes);
	
	/**
	 * 删除菜品 
	 */
	void deleteBatch(Long[] ids);
	
	/**
	 * 查询菜单
	 */
	DishesEntity queryObject(Long id);
}

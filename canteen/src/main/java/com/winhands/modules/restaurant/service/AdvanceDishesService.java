package com.winhands.modules.restaurant.service;

import java.util.List;
import java.util.Map;

import com.winhands.modules.restaurant.entity.AdvanceDishesEntity;
import com.winhands.modules.restaurant.entity.DishesEntity;

/**
 * 菜品管理
 * 
 */
public interface AdvanceDishesService {
	
	List<AdvanceDishesEntity> queryList(Map<String, Object> map);
	
	List<AdvanceDishesEntity> querySelList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	int querySelTotal(Map<String, Object> map);
	List<AdvanceDishesEntity> typeDish(String[] typeS);
	
	/**
	 * 修改预定菜品库存数量  
	 */
	void updateO(AdvanceDishesEntity advanceDishes);
	void updateBatch(Object[] ids);
	
	/**
	 * 保存菜品
	 */
	void save(AdvanceDishesEntity advanceDishes);
	
	/**
	 * 修改菜品	 */
	void update(AdvanceDishesEntity advanceDishes);
	
	/**
	 * 删除菜品 
	 */
	void deleteBatch(Long[] ids);
	
	/**
	 * 查询菜单
	 */
	AdvanceDishesEntity queryObject(Long id);
}

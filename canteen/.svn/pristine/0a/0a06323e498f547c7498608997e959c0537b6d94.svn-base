package com.winhands.modules.restaurant.service;

import java.util.List;
import java.util.Map;

import com.winhands.modules.restaurant.entity.CarteTypeDishesEntity;

/**
 *菜品管理
 * 
 */

public interface CarteTypeDishesService {
	List<CarteTypeDishesEntity> queryList(Map<String, Object> map);
	int queryTotal(Map<String, Object> map);
	CarteTypeDishesEntity queryObject(Map<String, Object> map);
	
	/**
	 * 保存菜品类型
	 */
	void save(CarteTypeDishesEntity carteTypeDishes);
	
	/**
	 * 修改菜品类型
	 * */
	void update(CarteTypeDishesEntity carteTypeDishes);
	
	/**
	 * 删除菜品类型
	 */
	void deleteBatch(Long[] ids);
	
	
	/**
	 * 删除disheId
	 */
	void deleteBatchDishesId(Long[] ids);
	
	void delete(Long id);


	/**
	 * 查询菜品类型
	 */
	CarteTypeDishesEntity queryObject(Long id);
	
	/**
	 * 根据菜单查菜品，去丛
	 * */
	List<CarteTypeDishesEntity> queryListByDishes(Map<String, Object> map);
		
}

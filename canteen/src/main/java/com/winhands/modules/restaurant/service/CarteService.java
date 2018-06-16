package com.winhands.modules.restaurant.service;


import java.util.List;
import java.util.Map;

import com.winhands.modules.restaurant.entity.CarteEntity;
import com.winhands.modules.restaurant.entity.DishesCarteEntity;
import com.winhands.modules.restaurant.entity.DishesEntity;
import com.winhands.modules.restaurant.entity.TypeEntity;

/**
 * 菜品管理
 * 
 */
public interface CarteService {
	
	
	/**
	 * 保存菜单
	 */
	void save(CarteEntity carte);
	
	/**
	 * 修改菜品	 */
	void update(CarteEntity carte);
	
	List<CarteEntity> queryList(Map<String, Object> map);
	List<String> queryaddressList();
	
	/**
	 * 删除菜品 
	 */
	void deleteBatch(Long[] id);
	void delete(Long id);
	int queryTotal(Map<String, Object> map);
	CarteEntity queryObject(Long id);
	CarteEntity queryNew();
	
	
}

package com.winhands.modules.restaurant.service;

import java.util.List;
import java.util.Map;

import com.winhands.modules.restaurant.entity.CarteBankDishesEntity;
import com.winhands.modules.restaurant.entity.CarteTypeDishesEntity;

/**
 *菜品管理
 * 
 */

public interface CarteBankDishesService {
	List<CarteBankDishesEntity> queryList(Map<String, Object> map);
	int queryTotal(Map<String, Object> map);
	CarteBankDishesEntity queryObject(Map<String, Object> map);
	
	/**
	 * 保存菜品类型
	 */
	void save(CarteBankDishesEntity carteBankDishes);
	
	/**
	 * 修改菜品类型
	 * */
	void update(CarteBankDishesEntity carteBankDishes);
	
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
	CarteBankDishesEntity queryObject(Long id);
		
}

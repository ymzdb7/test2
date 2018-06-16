package com.winhands.modules.restaurant.service;


import java.util.List;
import java.util.Map;

import com.winhands.modules.restaurant.entity.CarteBankEntity;
import com.winhands.modules.restaurant.entity.CarteEntity;
import com.winhands.modules.restaurant.entity.DishesCarteEntity;
import com.winhands.modules.restaurant.entity.DishesEntity;
import com.winhands.modules.restaurant.entity.TypeEntity;

/**
 * 菜单库管理
 * 
 */
public interface CarteBankService {
	/**
	 * 保存菜单
	 */
	void save(CarteBankEntity carteBank);
	/**
	 * 修改菜单	 */
	void update(CarteBankEntity carteBank);
	List<CarteBankEntity> queryList(Map<String, Object> map);
	CarteBankEntity queryNew();
	/**
	 * 删除菜单 
	 */
	void deleteBatch(Long[] id);

	void delete(Long id);
	int queryTotal(Map<String, Object> map);
	CarteBankEntity queryObject(Long id);
	
}

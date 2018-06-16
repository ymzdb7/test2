package com.winhands.modules.restaurant.service;

import java.util.List;
import java.util.Map;
import com.winhands.modules.restaurant.entity.TypeEntity;

/**
 *菜品管理
 * 
 */

public interface TypeService {
	List<TypeEntity> queryList(Map<String, Object> map);
	int queryTotal(Map<String, Object> map);
	TypeEntity queryObject(Map<String, Object> map);
	List<TypeEntity> queryListYes(Map<String, Object> map);
	
	/**
	 * 保存菜品类型
	 */
	void save(TypeEntity type);
	
	/**
	 * 修改菜品类型
	 * */
	void update(TypeEntity type);
	
	/**
	 * 删除菜品类型
	 */
	void deleteBatch(Long[] ids);
	
	/**
	 * 查询菜品类型
	 */
	TypeEntity queryObject(Long id);
		
}

package com.winhands.modules.restaurant.service;

import java.util.List;
import java.util.Map;

import com.winhands.modules.restaurant.entity.AdTypeEntity;

/**
 *预定菜品管理
 * 
 */

public interface AdTypeService {
	List<AdTypeEntity> queryList(Map<String, Object> map);
	int queryTotal(Map<String, Object> map);
	AdTypeEntity queryObject(Map<String, Object> map);
	List<AdTypeEntity> queryListYes(Map<String, Object> map);
	
	/**
	 * 保存预定菜品类型
	 */
	void save(AdTypeEntity adType);
	
	/**
	 * 修改预定菜品类型
	 * */
	void update(AdTypeEntity adType);
	
	/**
	 * 删除预定菜品类型
	 */
	void deleteBatch(Long[] ids);
	
	/**
	 * 查询预定菜品类型
	 */
	AdTypeEntity queryObject(Long id);
		
}

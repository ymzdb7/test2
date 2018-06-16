package com.winhands.modules.restaurant.service;

import java.util.List;
import java.util.Map;

import com.winhands.modules.restaurant.entity.EnviroTalkEntity;

/**
 *菜品管理
 * 
 */

public interface EnviroTalkService {
	List<EnviroTalkEntity> queryList(Map<String, Object> map);
	int queryTotal(Map<String, Object> map);
	EnviroTalkEntity queryObject(Map<String, Object> map);
	
	/**
	 * 保存菜品类型
	 */
	void save(EnviroTalkEntity enviroTalk);
	
	/**
	 * 修改菜品类型
	 * */
	void update(EnviroTalkEntity enviroTalk);
	
	/**
	 * 删除菜品类型
	 */
	void deleteBatch(Long[] ids);
	
	/**
	 * 查询菜品类型
	 */
	EnviroTalkEntity queryObject(Long id);
		
}

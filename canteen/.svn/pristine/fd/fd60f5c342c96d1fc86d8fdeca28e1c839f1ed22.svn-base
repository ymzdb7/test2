package com.winhands.modules.restaurant.service;

import java.util.List;
import java.util.Map;

import com.winhands.modules.restaurant.entity.CardDepartmentEntity;
import com.winhands.modules.restaurant.entity.CardDepartmentHeEntity;
import com.winhands.modules.restaurant.entity.TypeEntity;

/**
 *招待卡管理
 * 
 */

public interface CardDepartmentService {
	List<CardDepartmentEntity> queryList(Map<String, Object> map);
	List<CardDepartmentHeEntity> queryListOo(Map<String, Object> map);
	int queryTotal(Map<String, Object> map);
	CardDepartmentEntity queryObject(Map<String, Object> map);
	List<CardDepartmentEntity> queryListYes(Map<String, Object> map);
	
	/**
	 * 保存
	 */
	void save(CardDepartmentEntity cardDepartment);
	
	/**
	 * 修改
	 * */
	void update(CardDepartmentEntity cardDepartment);
	
	/**
	 * 删除
	 */
	void deleteBatch(Long[] ids);
	
	/**
	 * 查询
	 */
	CardDepartmentEntity queryObject(Long id);
		
}

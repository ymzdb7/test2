package com.winhands.modules.restaurant.service;

import java.util.List;
import java.util.Map;
import com.winhands.modules.restaurant.entity.EvaluateEntity;

/**
 *评价管理
 * 
 */

public interface EvaluateService {

	
	List<EvaluateEntity> queryList(Map<String, Object> map);
	
	List<EvaluateEntity> querySelList(Map<String, Object> map);
	int queryTotal(Map<String, Object> map);
	int querySelTotal(Map<String, Object> map);
	EvaluateEntity queryObject(Map<String, Object> map);
	
	/**
	 * 保存评价
	 */
	void save(EvaluateEntity evaluates);
	
	/**
	 * 修改评价	 */
	void update(EvaluateEntity evaluates);
	
	/**
	 * 删除评价
	 */
	void deleteBatch(Long[] ids);
	
	/**
	 * 查询评价
	 */
	EvaluateEntity queryObject(Long id);
	
	
	
	
}

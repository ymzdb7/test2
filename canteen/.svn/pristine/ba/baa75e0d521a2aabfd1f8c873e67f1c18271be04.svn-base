package com.winhands.modules.restaurant.service;

import java.util.List;
import java.util.Map;

import com.winhands.modules.restaurant.entity.DinnerPlanEntity;

/**
 * 预定计划管理
 * 
 */
public interface DinnerPlanService {
	
	List<DinnerPlanEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	/**
	 * 保存计划
	 */
	void save(DinnerPlanEntity dishes);
	
	/**
	 * 修改计划
	 */
	void update(DinnerPlanEntity dishes);
	
	/**
	 * 删除计划 
	 */
	void deleteBatch(Long[] ids);
	
	/**
	 * 查询计划
	 */
	DinnerPlanEntity queryObject(Long id);
}

package com.winhands.modules.restaurant.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhands.modules.restaurant.dao.DinnerPlanDao;
import com.winhands.modules.restaurant.entity.DinnerPlanEntity;
import com.winhands.modules.restaurant.service.DinnerPlanService;



/**
 * 预定计划管理
 */
@Service("dinnerPlanService")
public class DinnerPlanServiceImpl implements DinnerPlanService {
	@Autowired
	private DinnerPlanDao dinnerPlanDao;

	@Override
	public List<DinnerPlanEntity> queryList(Map<String, Object> map) {
		return dinnerPlanDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return dinnerPlanDao.queryTotal();
	}

	@Override
	public void save(DinnerPlanEntity dishes) {
		dinnerPlanDao.save(dishes);
	}

	@Override
	public void update(DinnerPlanEntity dishes) {
		dinnerPlanDao.update(dishes);
	}

	@Override
	public void deleteBatch(Long[] ids) {
		dinnerPlanDao.deleteBatch(ids);
	}

	@Override
	public DinnerPlanEntity queryObject(Long id) {
		return dinnerPlanDao.queryObject(id);
	}

	
}

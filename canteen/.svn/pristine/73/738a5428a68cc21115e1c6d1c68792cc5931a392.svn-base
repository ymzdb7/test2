package com.winhands.modules.restaurant.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhands.modules.restaurant.dao.EvaluateDao;

import com.winhands.modules.restaurant.entity.EvaluateEntity;
import com.winhands.modules.restaurant.service.EvaluateService;


	

/**
 * 菜品管理
 */
@Service("evaluateService")
public class EvaluateServiceImpl implements EvaluateService {
	@Autowired
	private EvaluateDao evaluateDao;

	@Override
	public List<EvaluateEntity> queryList(Map<String, Object> map) {
		return evaluateDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return evaluateDao.queryTotal();
	}

	@Override
	public void save(EvaluateEntity evaluates) {
		evaluateDao.save(evaluates);
	}

	@Override
	public void update(EvaluateEntity evaluates) {
		evaluateDao.update(evaluates);
	}

	@Override
	public void deleteBatch(Long[] ids) {
		evaluateDao.deleteBatch(ids);
	}

	@Override
	public EvaluateEntity queryObject(Long id) {
		return evaluateDao.queryObject(id);
	}

	@Override
	public List<EvaluateEntity> querySelList(Map<String, Object> map) {
		return evaluateDao.querySelList(map);
	}

	@Override
	public int querySelTotal(Map<String, Object> map) {
		return evaluateDao.querySelTotal(map);
	}

	@Override
	public EvaluateEntity queryObject(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return evaluateDao.queryObject(map);
	}

	
}

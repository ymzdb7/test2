package com.winhands.modules.restaurant.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhands.modules.restaurant.dao.CalculateDao;
import com.winhands.modules.restaurant.entity.CalculateEntity;
import com.winhands.modules.restaurant.service.CalculateService;



/**
 * 预定菜品计量单位管理
 */
@Service("CalculateService")
public class CalculateServiceImpl implements CalculateService {
	@Autowired
	private CalculateDao calculateDao;

	@Override
	public List<CalculateEntity> queryList(Map<String, Object> map) {
		return calculateDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return calculateDao.queryTotal(map);
	}

	@Override
	public void save(CalculateEntity calculate) {
		calculateDao.save(calculate);
	}

	@Override
	public void update(CalculateEntity calculate) {
		calculateDao.update(calculate);
	}

	@Override
	public void deleteBatch(Long[] ids) {
		calculateDao.deleteBatch(ids);
	}

	@Override
	public CalculateEntity queryObject(Long id) {
		return calculateDao.queryObject(id);
	}

	@Override
	public List<CalculateEntity> querySelList(Map<String, Object> map) {
		return calculateDao.querySelList(map);
	}

	@Override
	public int querySelTotal(Map<String, Object> map) {
		return calculateDao.querySelTotal(map);
	}

	
}

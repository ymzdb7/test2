package com.winhands.modules.restaurant.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhands.modules.restaurant.dao.AdDishesCountsDao;
import com.winhands.modules.restaurant.dao.TypeDao;
import com.winhands.modules.restaurant.entity.AdDishesHeeEntity;
import com.winhands.modules.restaurant.entity.TypeEntity;
import com.winhands.modules.restaurant.service.AdDishesCountsService;
import com.winhands.modules.restaurant.service.TypeService;

/**
 * 菜品统计管理
 */
@Service("AdDishesCountsService")
public class AdDishesCountsServiceImpl implements AdDishesCountsService {
	@Autowired
	private AdDishesCountsDao adDishesCountsDao;

	@Override
	public List<AdDishesHeeEntity> queryList(Map<String, Object> map) {
		return adDishesCountsDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return adDishesCountsDao.queryTotal(map);
	}

	@Override
	public void save(AdDishesHeeEntity adDishesHee) {
		adDishesCountsDao.save(adDishesHee);
	}

	@Override
	public void update(AdDishesHeeEntity adDishesHee) {
		adDishesCountsDao.update(adDishesHee);
	}

	@Override
	public void deleteBatch(Long[] ids) {
		adDishesCountsDao.deleteBatch(ids);
	}

	@Override
	public AdDishesHeeEntity queryObject(Long id) {
		return adDishesCountsDao.queryObject(id);
	}



	@Override
	public AdDishesHeeEntity queryObject(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return adDishesCountsDao.queryObject(map);
	}

	@Override
	public List<AdDishesHeeEntity> queryListYes(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return adDishesCountsDao.queryListYes(map);
	}

	
}

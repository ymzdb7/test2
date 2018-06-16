package com.winhands.modules.restaurant.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhands.modules.restaurant.dao.DinnerOrdersDao;

import com.winhands.modules.restaurant.entity.DinnerOrdersEntity;
import com.winhands.modules.restaurant.entity.DishesEntity;
import com.winhands.modules.restaurant.service.DinnerOrdersService;



	

/**
 * 菜品管理
 */
@Service("dinnerOrdersService")
public class DinnerOrdersServiceImpl implements DinnerOrdersService {
	@Autowired
	private DinnerOrdersDao dinnerOrdersDao;

	@Override
	public List<DinnerOrdersEntity> queryList(Map<String, Object> map) {
		return dinnerOrdersDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return dinnerOrdersDao.queryTotal(map);
	}

	@Override
	public void save(DinnerOrdersEntity orders) {
		dinnerOrdersDao.save(orders);
	}

	@Override
	public void update(DinnerOrdersEntity orders) {
		dinnerOrdersDao.update(orders);
	}

	@Override
	public void deleteBatch(Long[] ids) {
		dinnerOrdersDao.deleteBatch(ids);
	}


	@Override
	public List<DinnerOrdersEntity> querySelList(Map<String, Object> map) {
		return dinnerOrdersDao.querySelList(map);
	}

	@Override
	public int querySelTotal(Map<String, Object> map) {
		return dinnerOrdersDao.querySelTotal(map);
	}

	@Override
	public DinnerOrdersEntity queryObject(Long id) {
		// TODO Auto-generated method stub
		return dinnerOrdersDao.queryObject(id);
	}

	@Override
	public List<DinnerOrdersEntity> queryDateList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dinnerOrdersDao.queryDateList(map);
	}

	@Override
	public int queryTotal1(int departmentId) {
		// TODO Auto-generated method stub
		return dinnerOrdersDao.queryTotal1(departmentId);
	}

	@Override
	public List<DinnerOrdersEntity> queryList1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dinnerOrdersDao.queryList1(map);
	}

	@Override
	public int queryTotal2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dinnerOrdersDao.queryTotal2(map);
	}

	@Override
	public List<DinnerOrdersEntity> queryListDu(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return dinnerOrdersDao.queryListDu(map);
	}

	@Override
	public void updateState(Long[] ids) {
		// TODO Auto-generated method stub
		
		dinnerOrdersDao.updateState(ids);;
	}

	
}

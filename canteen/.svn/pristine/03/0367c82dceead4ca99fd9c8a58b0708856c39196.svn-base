package com.winhands.modules.restaurant.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.winhands.modules.restaurant.dao.DishesDao;
import com.winhands.modules.restaurant.entity.DishesEntity;
import com.winhands.modules.restaurant.service.DishesService;



/**
 * 菜品管理
 */
@Service("dishesService")
public class DishesServiceImpl implements DishesService {
	@Autowired
	private DishesDao dishesDao;

	@Override
	public List<DishesEntity> queryList(Map<String, Object> map) {
		return dishesDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return dishesDao.queryTotal();
	}

	@Override
	public void save(DishesEntity dishes) {
		dishesDao.save(dishes);
	}

	@Override
	public void update(DishesEntity dishes) {
		dishesDao.update(dishes);
	}

	@Override
	public void deleteBatch(Long[] ids) {
		dishesDao.deleteBatch(ids);
	}

	@Override
	public DishesEntity queryObject(Long id) {
		return dishesDao.queryObject(id);
	}

	@Override
	public List<DishesEntity> querySelList(Map<String, Object> map) {
		return dishesDao.querySelList(map);
	}

	@Override
	public int querySelTotal(Map<String, Object> map) {
		return dishesDao.querySelTotal(map);
	}

	@Override
	public List<DishesEntity> typeDish(String[] typeS) {
		// TODO Auto-generated method stub
		return dishesDao.typeDish(typeS);
	}

	
}

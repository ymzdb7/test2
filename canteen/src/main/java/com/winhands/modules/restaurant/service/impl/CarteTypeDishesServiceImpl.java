package com.winhands.modules.restaurant.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhands.modules.restaurant.dao.CarteTypeDishesDao;
import com.winhands.modules.restaurant.dao.TypeDao;
import com.winhands.modules.restaurant.entity.CarteTypeDishesEntity;
import com.winhands.modules.restaurant.entity.TypeEntity;
import com.winhands.modules.restaurant.service.CarteTypeDishesService;
import com.winhands.modules.restaurant.service.TypeService;

/**
 * 菜品类型管理
 */
@Service("CarteTypeDishesService")
public class CarteTypeDishesServiceImpl implements CarteTypeDishesService {
	@Autowired
	private CarteTypeDishesDao carteTypeDishesDao;

	@Override
	public List<CarteTypeDishesEntity> queryList(Map<String, Object> map) {
		return carteTypeDishesDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return carteTypeDishesDao.queryTotal(map);
	}

	@Override
	public void save(CarteTypeDishesEntity carteTypeDishes) {
		carteTypeDishesDao.save(carteTypeDishes);
	}

	@Override
	public void update(CarteTypeDishesEntity carteTypeDishes) {
		carteTypeDishesDao.update(carteTypeDishes);
	}

	@Override
	public void deleteBatch(Long[] ids) {
		carteTypeDishesDao.deleteBatch(ids);
	}

	@Override
	public CarteTypeDishesEntity queryObject(Long id) {
		return carteTypeDishesDao.queryObject(id);
	}



	@Override
	public CarteTypeDishesEntity queryObject(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return carteTypeDishesDao.queryObject(map);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		carteTypeDishesDao.delete(id);
	}

	@Override
	public List<CarteTypeDishesEntity> queryListByDishes(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return carteTypeDishesDao.queryListByDishes(map);
	}
	
	@Override
	public void deleteBatchDishesId(Long[] ids) {
		carteTypeDishesDao.deleteBatchDishesId(ids);
	}
}

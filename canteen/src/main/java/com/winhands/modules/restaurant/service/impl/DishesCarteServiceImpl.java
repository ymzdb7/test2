package com.winhands.modules.restaurant.service.impl;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhands.modules.restaurant.dao.DishesCarteDao;
import com.winhands.modules.restaurant.service.DishesCarteService;

/**
 * 菜品管理
 */
@Service("dishesCarteService")
public class DishesCarteServiceImpl implements DishesCarteService {
	@Autowired
	private DishesCarteDao dishesCarteDao;

	@Override
	public int queryTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dishesCarteDao.queryTotal(map);
	}


}

package com.winhands.modules.restaurant.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhands.modules.restaurant.dao.CarteBankDishesDao;
import com.winhands.modules.restaurant.dao.CarteTypeDishesDao;
import com.winhands.modules.restaurant.dao.TypeDao;
import com.winhands.modules.restaurant.entity.CarteBankDishesEntity;
import com.winhands.modules.restaurant.entity.CarteTypeDishesEntity;
import com.winhands.modules.restaurant.entity.TypeEntity;
import com.winhands.modules.restaurant.service.CarteBankDishesService;
import com.winhands.modules.restaurant.service.CarteTypeDishesService;
import com.winhands.modules.restaurant.service.TypeService;

/**
 * 菜品类型管理
 */
@Service("CarteBankDishesService")
public class CarteBankDishesServiceImpl implements CarteBankDishesService {
	@Autowired
	private CarteBankDishesDao carteBankDishesDao;

	@Override
	public List<CarteBankDishesEntity> queryList(Map<String, Object> map) {
		return carteBankDishesDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return carteBankDishesDao.queryTotal();
	}

	@Override
	public void save(CarteBankDishesEntity carteBankDishes) {
		carteBankDishesDao.save(carteBankDishes);
	}

	@Override
	public void update(CarteBankDishesEntity carteBankDishes) {
		carteBankDishesDao.update(carteBankDishes);
	}

	@Override
	public void deleteBatch(Long[] ids) {
		carteBankDishesDao.deleteBatch(ids);
	}

	@Override
	public CarteBankDishesEntity queryObject(Long id) {
		return carteBankDishesDao.queryObject(id);
	}



	@Override
	public CarteBankDishesEntity queryObject(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return carteBankDishesDao.queryObject(map);
	}

	

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		carteBankDishesDao.delete(id);
	}
	
	@Override
	public void deleteBatchDishesId(Long[] ids) {
		carteBankDishesDao.deleteBatchDishesId(ids);
	}
	
}

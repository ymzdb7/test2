package com.winhands.modules.restaurant.service.impl;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhands.modules.restaurant.dao.CarteBankDao;

import com.winhands.modules.restaurant.entity.CarteBankEntity;

import com.winhands.modules.restaurant.service.CarteBankService;

/**
 * 菜单库管理
 */
@Service("carteBankService")
public class CarteBankServiceImpl implements CarteBankService {
	@Autowired
	private CarteBankDao carteBankDao;

	@Override
	public List<CarteBankEntity> queryList(Map<String, Object> map) {
		return carteBankDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return carteBankDao.queryTotal(map);
	}

	@Override
	public void save(CarteBankEntity carteBank) {
		carteBankDao.save(carteBank);
	}

	@Override
	public void update(CarteBankEntity carteBank) {
		carteBankDao.update(carteBank);
	}

	@Override
	public void deleteBatch(Long[] ids) {
		carteBankDao.deleteBatch(ids);
	}

	@Override
	public CarteBankEntity queryObject(Long id) {
		return carteBankDao.queryObject(id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		carteBankDao.delete(id);
	}

	@Override
	public CarteBankEntity queryNew() {
		// TODO Auto-generated method stub
		return carteBankDao.queryNew();
	}
	

	
}



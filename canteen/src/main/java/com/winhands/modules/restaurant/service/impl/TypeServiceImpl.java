package com.winhands.modules.restaurant.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhands.modules.restaurant.dao.TypeDao;
import com.winhands.modules.restaurant.entity.TypeEntity;
import com.winhands.modules.restaurant.service.TypeService;

/**
 * 菜品类型管理
 */
@Service("TypeService")
public class TypeServiceImpl implements TypeService {
	@Autowired
	private TypeDao typeDao;

	@Override
	public List<TypeEntity> queryList(Map<String, Object> map) {
		return typeDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return typeDao.queryTotal(map);
	}

	@Override
	public void save(TypeEntity type) {
		typeDao.save(type);
	}

	@Override
	public void update(TypeEntity type) {
		typeDao.update(type);
	}

	@Override
	public void deleteBatch(Long[] ids) {
		typeDao.deleteBatch(ids);
	}

	@Override
	public TypeEntity queryObject(Long id) {
		return typeDao.queryObject(id);
	}



	@Override
	public TypeEntity queryObject(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return typeDao.queryObject(map);
	}

	@Override
	public List<TypeEntity> queryListYes(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return typeDao.queryListYes(map);
	}

	
}
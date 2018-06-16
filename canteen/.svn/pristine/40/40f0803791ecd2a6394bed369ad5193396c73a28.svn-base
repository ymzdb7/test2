package com.winhands.modules.restaurant.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhands.modules.restaurant.dao.AdTypeDao;
import com.winhands.modules.restaurant.entity.AdTypeEntity;
import com.winhands.modules.restaurant.service.AdTypeService;

/**
 *预定菜品类型管理
 */
@Service("AdTypeService")
public class AdTypeServiceImpl implements AdTypeService {
	@Autowired
	private AdTypeDao adTypeDao;

	@Override
	public List<AdTypeEntity> queryList(Map<String, Object> map) {
		return adTypeDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return adTypeDao.queryTotal();
	}

	@Override
	public void save(AdTypeEntity adType) {
		adTypeDao.save(adType);
	}

	@Override
	public void update(AdTypeEntity adType) {
		adTypeDao.update(adType);
	}

	@Override
	public void deleteBatch(Long[] ids) {
		adTypeDao.deleteBatch(ids);
	}

	@Override
	public AdTypeEntity queryObject(Long id) {
		return adTypeDao.queryObject(id);
	}



	@Override
	public AdTypeEntity queryObject(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return adTypeDao.queryObject(map);
	}

	@Override
	public List<AdTypeEntity> queryListYes(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return adTypeDao.queryListYes(map);
	}

	
}

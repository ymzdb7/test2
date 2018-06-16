package com.winhands.modules.restaurant.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhands.modules.restaurant.dao.EnviroTalkDao;
import com.winhands.modules.restaurant.dao.TypeDao;
import com.winhands.modules.restaurant.entity.EnviroTalkEntity;
import com.winhands.modules.restaurant.entity.TypeEntity;
import com.winhands.modules.restaurant.service.EnviroTalkService;
import com.winhands.modules.restaurant.service.TypeService;

/**
 *环境评价管理
 */
@Service("EnviroTalkService")
public class EnviroTalkServiceImpl implements EnviroTalkService {
	@Autowired
	private EnviroTalkDao enviroTalkDao;

	@Override
	public List<EnviroTalkEntity> queryList(Map<String, Object> map) {
		return enviroTalkDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return enviroTalkDao.queryTotal();
	}

	@Override
	public void save(EnviroTalkEntity type) {
		enviroTalkDao.save(type);
	}

	@Override
	public void update(EnviroTalkEntity type) {
		enviroTalkDao.update(type);
	}

	@Override
	public void deleteBatch(Long[] ids) {
		enviroTalkDao.deleteBatch(ids);
	}

	@Override
	public EnviroTalkEntity queryObject(Long id) {
		return enviroTalkDao.queryObject(id);
	}

	@Override
	public EnviroTalkEntity queryObject(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return enviroTalkDao.queryObject(map);
	}

	
}

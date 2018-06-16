package com.winhands.modules.restaurant.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.winhands.modules.restaurant.dao.OneCardDao;
import com.winhands.modules.restaurant.entity.EmMoneyCountsEntity;
import com.winhands.modules.restaurant.entity.OneCardEntity;
import com.winhands.modules.restaurant.service.OneCardService;



/**
 * 菜品管理
 */
@Service("oneCardService")
public class OneCardServiceImpl implements OneCardService {
	@Autowired
	private OneCardDao oneCardDao;

	@Override
	public List<OneCardEntity> queryList(Map<String, Object> map) {
		return oneCardDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return oneCardDao.queryTotal();
	}

	@Override
	public void save(OneCardEntity oneCard) {
		oneCardDao.save(oneCard);
	}

	@Override
	public void update(OneCardEntity oneCard) {
		oneCardDao.update(oneCard);
	}

	@Override
	public void deleteBatch(Long[] ids) {
		oneCardDao.deleteBatch(ids);
	}

	@Override
	public OneCardEntity queryObject(Long id) {
		return oneCardDao.queryObject(id);
	}

	@Override
	public List<OneCardEntity> querySelList(Map<String, Object> map) {
		return oneCardDao.querySelList(map);
	}

	@Override
	public int querySelTotal(Map<String, Object> map) {
		return oneCardDao.querySelTotal(map);
	}

	@Override
	public List<EmMoneyCountsEntity> queryListEmMoCou(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return oneCardDao.queryListEmMoCou(map);
	}

	@Override
	public int queryTotalEmMoCou(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return oneCardDao.queryTotalEmMoCou(map);
	}

	
}

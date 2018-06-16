package com.winhands.modules.restaurant.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhands.modules.restaurant.dao.CardDeviceDao;
import com.winhands.modules.restaurant.entity.CardDeviceEntity;
import com.winhands.modules.restaurant.entity.ExpenseCountsEntity;
import com.winhands.modules.restaurant.service.CardDeviceService;

/**
 * 特殊交易设备管理
 */
@Service("CardDeviceService")
public class CardDeviceServiceImpl implements CardDeviceService {
	@Autowired
	private CardDeviceDao cardDeviceDao;

	@Override
	public List<CardDeviceEntity> queryList(Map<String, Object> map) {
		return cardDeviceDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return cardDeviceDao.queryTotal(map);
	}

	@Override
	public void save(CardDeviceEntity cardDevice) {
		cardDeviceDao.save(cardDevice);
	}

	@Override
	public void update(CardDeviceEntity cardDevice) {
		cardDeviceDao.update(cardDevice);
	}

	@Override
	public void deleteBatch(Long[] ids) {
		cardDeviceDao.deleteBatch(ids);
	}

	@Override
	public CardDeviceEntity queryObject(Long id) {
		return cardDeviceDao.queryObject(id);
	}



	@Override
	public CardDeviceEntity queryObject(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return cardDeviceDao.queryObject(map);
	}

	@Override
	public List<CardDeviceEntity> queryListYes(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return cardDeviceDao.queryListYes(map);
	}

	@Override
	public List<ExpenseCountsEntity> queryListExCou(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return cardDeviceDao.queryListExCou(map);
	}

	
}

package com.winhands.modules.restaurant.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhands.modules.restaurant.dao.CardDepartmentDao;
import com.winhands.modules.restaurant.entity.CardDepartmentEntity;
import com.winhands.modules.restaurant.entity.CardDepartmentHeEntity;
import com.winhands.modules.restaurant.service.CardDepartmentService;

/**
 *招待卡管理
 */
@Service("CardDepartmentService")
public class CardDepartmentServiceImpl implements CardDepartmentService {
	@Autowired
	private CardDepartmentDao cardDepartmentDao;

	@Override
	public List<CardDepartmentEntity> queryList(Map<String, Object> map) {
		return cardDepartmentDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return cardDepartmentDao.queryTotal(map);
	}

	@Override
	public void save(CardDepartmentEntity cardDepartment) {
		cardDepartmentDao.save(cardDepartment);
	}

	@Override
	public void update(CardDepartmentEntity cardDepartment) {
		cardDepartmentDao.update(cardDepartment);
	}

	@Override
	public void deleteBatch(Long[] ids) {
		cardDepartmentDao.deleteBatch(ids);
	}

	@Override
	public CardDepartmentEntity queryObject(Long id) {
		return cardDepartmentDao.queryObject(id);
	}



	@Override
	public CardDepartmentEntity queryObject(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return cardDepartmentDao.queryObject(map);
	}

	@Override
	public List<CardDepartmentEntity> queryListYes(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return cardDepartmentDao.queryListYes(map);
	}

	@Override
	public List<CardDepartmentHeEntity> queryListOo(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return cardDepartmentDao.queryListOo(map);
	}

	
}

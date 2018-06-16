package com.winhands.modules.restaurant.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.winhands.modules.restaurant.entity.DishesEntity;
import com.winhands.modules.restaurant.entity.EmMoneyCountsEntity;
import com.winhands.modules.restaurant.entity.OneCardEntity;
import com.winhands.modules.sys.dao.BaseDao;

/**
 * 系统用户
 */
@Mapper
public interface OneCardDao extends BaseDao<OneCardEntity> {
	List<OneCardEntity> querySelList(Map<String, Object> map);
	List<OneCardEntity> queryList(Map<String, Object> map);
	List<EmMoneyCountsEntity> queryListEmMoCou(Map<String, Object> map);
	int queryTotalEmMoCou(Map<String, Object> map);

	List<OneCardEntity> queryDishList(Long carteId);
	
	int querySelTotal(Map<String, Object> map);
}

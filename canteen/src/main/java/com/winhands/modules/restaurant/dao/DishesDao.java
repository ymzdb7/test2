package com.winhands.modules.restaurant.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.winhands.modules.restaurant.entity.DishesEntity;
import com.winhands.modules.sys.dao.BaseDao;

/**
 * 系统用户
 */
@Mapper
public interface DishesDao extends BaseDao<DishesEntity> {
	List<DishesEntity> querySelList(Map<String, Object> map);
	List<DishesEntity> queryList(Map<String, Object> map);
	/*List<DishesEntity> queryDishList(Long carteId);*/
	List<DishesEntity> queryDishList(Map<String, Object> map);
	
	int querySelTotal(Map<String, Object> map);
	
	List<DishesEntity> typeDish(String[] typeS);
	
	
}

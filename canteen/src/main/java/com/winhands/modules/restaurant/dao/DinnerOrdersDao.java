package com.winhands.modules.restaurant.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.winhands.modules.restaurant.entity.DinnerOrdersEntity;
import com.winhands.modules.restaurant.entity.DishesEntity;
import com.winhands.modules.sys.dao.BaseDao;

/**
 * 系统用户
 */
@Mapper
public interface DinnerOrdersDao extends BaseDao<DinnerOrdersEntity> {
	List<DinnerOrdersEntity> querySelList(Map<String, Object> map);
	List<DinnerOrdersEntity> queryList(Map<String, Object> map);
	List<DinnerOrdersEntity> queryList1(Map<String, Object> map);
	List<DinnerOrdersEntity> queryListDu(Map<String,Object> map);
	
	List<DinnerOrdersEntity> queryDishList(Long carteId);
	List<DinnerOrdersEntity> queryDateList(Map<String, Object> map);
	int queryTotal1(int departmentId);
	int queryTotal2(Map<String, Object> map);
	
	int querySelTotal(Map<String, Object> map);
	void updateState(Object[] id);
	
}

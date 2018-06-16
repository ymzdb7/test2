package com.winhands.modules.restaurant.dao;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.winhands.modules.restaurant.entity.AdDishesHeEntity;
import com.winhands.modules.restaurant.entity.AdvanceDishesEntity;
import com.winhands.modules.restaurant.entity.OrderAdvanceDishesEntity;
import com.winhands.modules.sys.dao.BaseDao;

/**
 * 订单预定菜品关联表
 */
@Mapper
public interface OrderAdvanceDishesDao extends BaseDao<OrderAdvanceDishesEntity> {
	List<OrderAdvanceDishesEntity> queryList(Map<String, Object> map);
	OrderAdvanceDishesEntity queryObject(Map<String, Object> map);
	List<AdDishesHeEntity> queryListG(Map<String, Object> map);
}
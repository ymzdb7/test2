package com.winhands.modules.restaurant.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

import com.winhands.modules.restaurant.entity.AdDishesHeeEntity;
import com.winhands.modules.restaurant.entity.EmMoneyCountsEntity;
import com.winhands.modules.restaurant.entity.OrderAdDishesHeEntity;
import com.winhands.modules.restaurant.entity.OrderEntity;
import com.winhands.modules.sys.dao.BaseDao;

/**
 * 系统用户
 */
@Mapper
public interface OrderDao extends BaseDao<OrderEntity> {
	List<OrderEntity> querySelList(Map<String, Object> map);
	List<OrderEntity> queryList(Map<String, Object> map);

	int querySelTotal(Map<String, Object> map);
	Map<String,Object> getObject(int id);
	OrderEntity queryObjectW(Object id);
//	OrderEntity queryNew();//查询最新产生的订单 
	OrderEntity queryObjectMa(Map<String,Object> map);
	List<OrderAdDishesHeEntity> queryListO(Map<String, Object> map);
	List<AdDishesHeeEntity> queryListOo();//订单管理中的商品统计
}

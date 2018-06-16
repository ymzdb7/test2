package com.winhands.modules.restaurant.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhands.modules.restaurant.dao.AdvanceDishesDao;
import com.winhands.modules.restaurant.dao.OrderAdvanceDishesDao;
import com.winhands.modules.restaurant.dao.OrderDao;
import com.winhands.modules.restaurant.entity.AdDishesHeeEntity;
import com.winhands.modules.restaurant.entity.AdvanceDishesEntity;
import com.winhands.modules.restaurant.entity.OrderAdDishesHeEntity;
import com.winhands.modules.restaurant.entity.OrderAdvanceDishesEntity;
import com.winhands.modules.restaurant.entity.OrderEntity;
import com.winhands.modules.restaurant.service.OrderService;
import com.winhands.modules.sys.entity.SysUserEntity;

/**
 * 订单管理
 */
@Service("OrderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private AdvanceDishesDao advanceDishesDao;
	@Autowired
	private OrderAdvanceDishesDao orderAdvanceDishesDao;
	
	@Override
	public List<OrderEntity> queryList(Map<String, Object> map) {
		return orderDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return orderDao.queryTotal(map);
	}

	@Override
	public void save(OrderEntity orders) {
		orderDao.save(orders);
	}
	

	

	@Override
	public void update(OrderEntity orders) {
		orderDao.update(orders);
	}

	@Override
	public void deleteBatch(Long[] ids) {
		orderDao.deleteBatch(ids);
	}

	@Override
	public OrderEntity queryObject(Long id) {
		return orderDao.queryObject(id);
	}

	@Override
	public List<OrderEntity> querySelList(Map<String, Object> map) {
		return orderDao.querySelList(map);
	}

	@Override
	public int querySelTotal(Map<String, Object> map) {
		return orderDao.querySelTotal(map);
	}

	@Override
	public Map<String, Object> getObject(int id) {
		// TODO Auto-generated method stub
		return orderDao.getObject(id);
	}

	@Override
	@Transactional
	public OrderEntity queryObjectW(Object id) {
		// TODO Auto-generated method stub
		return orderDao.queryObjectW(id);
	}

	@Override
	public OrderEntity queryObjectMa(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return orderDao.queryObjectMa(map);
	}


	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		orderDao.delete(id);
	}

	//订单保存用事务
		@Override
		@Transactional
		public Long saveOo(Long[] ids,Long[] counts,String[] advDishesPrice,SysUserEntity user,String  uuid,Long id) {
		
			OrderEntity order=new OrderEntity();
			order.setUserId(new Long(user.getUserId()).intValue());
			order.setOrConsignee(user.getUsername());
			order.setOrderPhone(user.getMobile());
			order.setOrderNumber(uuid);
			String dd=user.getAddress();
			order.setAddress(user.getAddress());
			order.setOrderState("预定成功");
			order.setOrderTime(Timestamp.valueOf(DateTime.now().toString("yyyy-MM-dd HH:mm:ss")));
			orderDao.save(order);
			OrderAdvanceDishesEntity orderAdvanceDishes=new OrderAdvanceDishesEntity();
			id=order.getId();
			for (int i = 0; i < ids.length; i++) {
				AdvanceDishesEntity advanceDishes=advanceDishesDao.queryObject(ids[i]);
				orderAdvanceDishes.setAdvanceDishesId(ids[i]);
				orderAdvanceDishes.setCount(new Long(counts[i]).intValue());
				orderAdvanceDishes.setOrderId(id);
				orderAdvanceDishes.setAdvDishesPrice(new BigDecimal(advDishesPrice[i]));
				orderAdvanceDishesDao.save(orderAdvanceDishes);
				int cc=advanceDishes.getCounts()-new Long(counts[i]).intValue();
				advanceDishes.setCounts(cc);
				advanceDishesDao.update(advanceDishes);
				}
			return id;
		
		}

		@Override
		public List<OrderAdDishesHeEntity> queryListO(Map<String, Object> map) {
			// TODO Auto-generated method stub
			return orderDao.queryListO(map);
		}

		@Override
		@Transactional
		public List<AdDishesHeeEntity> queryListOo() {
			// TODO Auto-generated method stub
			return orderDao.queryListOo();
		}
		
}

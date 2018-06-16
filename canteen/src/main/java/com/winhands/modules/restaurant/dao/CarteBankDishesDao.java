package com.winhands.modules.restaurant.dao;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.winhands.modules.restaurant.entity.CarteBankDishesEntity;
import com.winhands.modules.restaurant.entity.CarteTypeDishesEntity;
import com.winhands.modules.sys.dao.BaseDao;

/**
 * 菜单库菜品关联
 */
@Mapper
public interface CarteBankDishesDao extends BaseDao<CarteBankDishesEntity> {
	List<CarteBankDishesEntity> queryList(Map<String, Object> map);
	CarteBankDishesEntity queryObject(Map<String, Object> map);
	int deleteBatchDishesId(Object[] id);//删除dishesId所在记录

	
}

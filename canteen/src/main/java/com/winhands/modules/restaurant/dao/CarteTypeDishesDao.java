package com.winhands.modules.restaurant.dao;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.winhands.modules.restaurant.entity.CarteTypeDishesEntity;
import com.winhands.modules.sys.dao.BaseDao;

/**
 * 菜品类型
 */
@Mapper
public interface CarteTypeDishesDao extends BaseDao<CarteTypeDishesEntity> {
	List<CarteTypeDishesEntity> queryList(Map<String, Object> map);
	CarteTypeDishesEntity queryObject(Map<String, Object> map);
	
	List<CarteTypeDishesEntity> queryListByDishes(Map<String, Object> map);
	int deleteBatchDishesId(Object[] id);//删除dishesId所在记录

}

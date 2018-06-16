package com.winhands.modules.restaurant.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.winhands.modules.restaurant.entity.CarteBankEntity;
import com.winhands.modules.restaurant.entity.CarteEntity;
import com.winhands.modules.restaurant.entity.TypeEntity;
import com.winhands.modules.sys.dao.BaseDao;

/**
 * 当天菜单更新的属地管理
 */
@Mapper
public interface CarteDao extends BaseDao<CarteEntity> {
	CarteEntity queryObject(Map<String, Object> map);
	List<String> queryaddressList();
	CarteEntity queryNew();
	
	
}

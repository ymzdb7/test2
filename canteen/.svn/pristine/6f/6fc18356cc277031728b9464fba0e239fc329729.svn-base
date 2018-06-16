package com.winhands.modules.restaurant.dao;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.winhands.modules.restaurant.entity.CardDeviceEntity;
import com.winhands.modules.restaurant.entity.ExpenseCountsEntity;
import com.winhands.modules.sys.dao.BaseDao;

/**
 * 特殊交易设备管理
 */
@Mapper
public interface CardDeviceDao extends BaseDao<CardDeviceEntity> {
	List<CardDeviceEntity> queryList(Map<String, Object> map);
	List<ExpenseCountsEntity> queryListExCou(Map<String, Object> map);//招待费汇总
	CardDeviceEntity queryObject(Map<String, Object> map);
	List<CardDeviceEntity> queryListYes(Map<String, Object> map);
}

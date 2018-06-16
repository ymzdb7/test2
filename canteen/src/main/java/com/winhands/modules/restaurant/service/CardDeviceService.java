package com.winhands.modules.restaurant.service;

import java.util.List;
import java.util.Map;

import com.winhands.modules.restaurant.entity.CardDeviceEntity;
import com.winhands.modules.restaurant.entity.ExpenseCountsEntity;

/**
 *特殊交易设备管理
 * 
 */

public interface CardDeviceService {
	List<CardDeviceEntity> queryList(Map<String, Object> map);
	List<ExpenseCountsEntity> queryListExCou(Map<String, Object> map);
	int queryTotal(Map<String, Object> map);
	CardDeviceEntity queryObject(Map<String, Object> map);
	List<CardDeviceEntity> queryListYes(Map<String, Object> map);
	
	/**
	 * 保存
	 */
	void save(CardDeviceEntity cardDevice);
	
	/**
	 * 修改
	 * */
	void update(CardDeviceEntity cardDevice);
	
	/**
	 * 删除
	 */
	void deleteBatch(Long[] ids);
	
	/**
	 * 查询
	 */
	CardDeviceEntity queryObject(Long id);
		
}

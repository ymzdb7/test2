package com.winhands.modules.restaurant.service;

import java.util.List;
import java.util.Map;

import com.winhands.modules.restaurant.entity.DishesEntity;
import com.winhands.modules.restaurant.entity.EmMoneyCountsEntity;
import com.winhands.modules.restaurant.entity.OneCardEntity;

/**
 * 菜品管理
 * 
 */
public interface OneCardService {
	
	List<OneCardEntity> queryList(Map<String, Object> map);
	List<EmMoneyCountsEntity> queryListEmMoCou(Map<String, Object> map);
	
	List<OneCardEntity> querySelList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	int queryTotalEmMoCou(Map<String, Object> map);

	
	int querySelTotal(Map<String, Object> map);
	
	/**
	 * 保存
	 */
	void save(OneCardEntity oneCard);
	
	/**
	 * 修改	 */
	void update(OneCardEntity oneCard);
	
	/**
	 * 删除 
	 */
	void deleteBatch(Long[] ids);
	
	/**
	 * 查询
	 */
	OneCardEntity queryObject(Long id);
}

package com.winhands.modules.restaurant.service;


import java.util.List;
import java.util.Map;

import com.winhands.modules.restaurant.entity.ThumbsEntity;

/**
 * 管理
 * 
 */
public interface ThumbsService {
	
	
	/**
	 * 保存
	 */
	void save(ThumbsEntity thumbs);
	
	/**
	 * 修改	 */
	void update(ThumbsEntity thumbs);
	
	ThumbsEntity queryObject(Map<String, Object> map);
	
	
	/**
	 * 删除
	 */
	void deleteBatch(Long[] id);
	
	
}

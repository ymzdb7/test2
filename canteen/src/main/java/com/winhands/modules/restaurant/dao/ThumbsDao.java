package com.winhands.modules.restaurant.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.winhands.modules.restaurant.entity.ThumbsEntity;
import com.winhands.modules.sys.dao.BaseDao;

/**
 * 系统用户
 */
@Mapper
public interface ThumbsDao extends BaseDao<ThumbsEntity> {
	ThumbsEntity queryObject(Map<String, Object> map);
}

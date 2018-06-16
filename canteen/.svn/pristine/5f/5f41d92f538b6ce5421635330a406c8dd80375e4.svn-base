package com.winhands.modules.restaurant.dao;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.winhands.modules.restaurant.entity.AdTypeEntity;
import com.winhands.modules.restaurant.entity.EvaluateEntity;
import com.winhands.modules.restaurant.entity.TypeEntity;
import com.winhands.modules.sys.dao.BaseDao;

/**
 * 预定菜品类型
 */
@Mapper
public interface AdTypeDao extends BaseDao<AdTypeEntity> {
	List<AdTypeEntity> queryList(Map<String, Object> map);
	AdTypeEntity queryObject(Map<String, Object> map);
	List<AdTypeEntity> queryListYes(Map<String, Object> map);
}

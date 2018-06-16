package com.winhands.modules.restaurant.dao;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.winhands.modules.restaurant.entity.CardDepartmentEntity;
import com.winhands.modules.restaurant.entity.CardDepartmentHeEntity;
import com.winhands.modules.sys.dao.BaseDao;

/**
 * 招待卡管理
 */
@Mapper
public interface CardDepartmentDao extends BaseDao<CardDepartmentEntity> {
	List<CardDepartmentEntity> queryList(Map<String, Object> map);
	List<CardDepartmentHeEntity> queryListOo(Map<String, Object> map);
	CardDepartmentEntity queryObject(Map<String, Object> map);
	List<CardDepartmentEntity> queryListYes(Map<String, Object> map);
}

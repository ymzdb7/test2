package com.winhands.modules.restaurant.dao;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;



import com.winhands.modules.restaurant.entity.EvaluateEntity;
import com.winhands.modules.sys.dao.BaseDao;

/**
 * 评价
 */
@Mapper
public interface EvaluateDao extends BaseDao<EvaluateEntity> {
	List<EvaluateEntity> querySelList(Map<String, Object> map);
	List<EvaluateEntity> queryList(Map<String, Object> map);
	List<EvaluateEntity> queryDishList(Long carteId);
	EvaluateEntity queryObject(Map<String, Object> map);
	int querySelTotal(Map<String, Object> map);
	
	

}

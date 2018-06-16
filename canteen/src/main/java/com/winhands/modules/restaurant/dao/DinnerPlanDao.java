package com.winhands.modules.restaurant.dao;

import org.apache.ibatis.annotations.Mapper;

import com.winhands.modules.restaurant.entity.DinnerPlanEntity;
import com.winhands.modules.sys.dao.BaseDao;

/**
 * 晚饭预定计划
 */
@Mapper
public interface DinnerPlanDao extends BaseDao<DinnerPlanEntity> {
}

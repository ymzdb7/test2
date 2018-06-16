package com.winhands.modules.restaurant.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.winhands.common.annotation.SysLog;
import com.winhands.common.utils.PageUtils;
import com.winhands.common.utils.Query;
import com.winhands.common.utils.R;
import com.winhands.common.validator.ValidatorUtils;
import com.winhands.common.validator.group.AddGroup;
import com.winhands.modules.restaurant.entity.DinnerPlanEntity;
import com.winhands.modules.restaurant.service.DinnerPlanService;
import com.winhands.modules.sys.controller.AbstractController;

/**
 * 预定计划管理
 * 
 */
@RestController
@RequestMapping("/restaurant/dinnerPlan")
public class DinnerPlanController extends AbstractController {
	@Autowired
	private DinnerPlanService dinnerPlanService;
	
	/**
	 * 所有预定计划列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("restaurant:dinnerPlan:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		List<DinnerPlanEntity> dishList = dinnerPlanService.queryList(query);
		int total = dinnerPlanService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(dishList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	/**
	 * 保存预定计划
	 */
	@SysLog("保存预定计划")
	@RequestMapping("/save")
	@RequiresPermissions("restaurant:dinnerPlan:save")
	public R save(@RequestBody DinnerPlanEntity dinnerPlan){
		ValidatorUtils.validateEntity(dinnerPlan, AddGroup.class);
		
		dinnerPlan.setCreateUserId(getUserId());
		dinnerPlanService.save(dinnerPlan);
		
		return R.ok();
	}
	
	/**
	 * 修改预定计划
	 */
	@SysLog("修改预定计划")
	@RequestMapping("/update")
	@RequiresPermissions("restaurant:dinnerPlan:update")
	public R update(@RequestBody DinnerPlanEntity dinnerPlan){
		ValidatorUtils.validateEntity(dinnerPlan, AddGroup.class);
		dinnerPlan.setCreateUserId(getUserId());
		dinnerPlanService.update(dinnerPlan);
		
		return R.ok();
	}
	
	/**
	 * 预定计划信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("restaurant:dinnerPlan:info")
	public R info(@PathVariable("id") Long id){
		DinnerPlanEntity dinnerPlan = dinnerPlanService.queryObject(id);
		return R.ok().put("dinnerPlan", dinnerPlan);
	}
	/**
	 * 删除预定计划
	 */
	@SysLog("删除预定计划")
	@RequestMapping("/delete")
	@RequiresPermissions("restaurant:dinnerPlan:delete")
	public R delete(@RequestBody Long[] ids){
		dinnerPlanService.deleteBatch(ids);
		
		return R.ok();
	}
	
}

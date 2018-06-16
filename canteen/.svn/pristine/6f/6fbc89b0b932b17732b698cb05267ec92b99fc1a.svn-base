package com.winhands.modules.restaurant.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.winhands.common.utils.PageUtils;
import com.winhands.common.utils.Query;
import com.winhands.common.utils.R;

import com.winhands.common.validator.ValidatorUtils;
import com.winhands.common.validator.group.AddGroup;
import com.winhands.modules.restaurant.entity.AdTypeEntity;
import com.winhands.modules.restaurant.service.AdTypeService;
import com.winhands.modules.sys.controller.AbstractController;


/**
 * 预定菜品类型管理
 * 
 */

@RestController
@RequestMapping("/restaurant/adType")
public class AdTypeController  extends AbstractController{
	
	//日志
	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private AdTypeService adTypeService;
	//获取预定菜品类型列表

	@ResponseBody
	@RequestMapping("/list")	
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
		logger.info("进入展示预定菜品类型列表的方法list");
		Query query = new Query(params);
		List<AdTypeEntity> adTypeList = adTypeService.queryList(query);
		int total = adTypeService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(adTypeList, total, query.getLimit(), query.getPage());
		logger.info("离开展示预定菜品类型列表的方法list");
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 保存预定菜品类型
	 */
	@ResponseBody
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public R save(AdTypeEntity adType){
		logger.info("进入保存预定菜品类型的方法save");
		ValidatorUtils.validateEntity(adType, AddGroup.class);
		adTypeService.save(adType);
		logger.info("离开保存预定菜品类型的方法save");
		return R.ok();
	}
	
	/**
	 * 预定菜品类型信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Long id){
		logger.info("进入根据id查询对应预定菜品类型Entity的方法info");
		AdTypeEntity adType =adTypeService.queryObject(id);
		logger.info("离开根据id查询对应预定菜品类型Entity的方法info");
		return R.ok().put("adType", adType);
	}
	
	
	/**
	 * 修改预定菜品类型
	 */
	@ResponseBody
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public R update(AdTypeEntity adType){
		logger.info("进入修改预定菜品类型的方法update");
		ValidatorUtils.validateEntity(adType, AddGroup.class);
		adTypeService.update(adType);
		logger.info("离开修改预定菜品类型的方法update");
		return R.ok();
	}
	
	
	/**
	 * 删除菜品种类
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] ids){
		logger.info("进入删除预定菜品类型的方法delete");
		adTypeService.deleteBatch(ids);
		logger.info("离开删除预定菜品类型的方法delete");
		return R.ok();
	}
	
/**
	 * 获取预定菜品类型
	 */
	@ResponseBody
	@RequestMapping(value="/adDishsType" , method = RequestMethod.POST)
	public R adDishsType( ){
		logger.info("进入获取预定菜品类型的集合的方法adDishsType");
		Map<String, Object> map=new HashMap<>();
		List<AdTypeEntity> adTypeList=adTypeService.queryList(map);
		 logger.info("离开获取预定菜品类型的集合的方法adDishsType");
		return R.ok().put("adType", adTypeList);
	}

}

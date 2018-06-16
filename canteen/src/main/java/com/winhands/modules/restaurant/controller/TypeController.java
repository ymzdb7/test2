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
import com.winhands.modules.restaurant.entity.TypeEntity;
import com.winhands.modules.restaurant.service.TypeService;
import com.winhands.modules.sys.controller.AbstractController;


/**
 * 菜品类型管理
 * 
 */

@RestController
@RequestMapping("/restaurant/type")
public class TypeController  extends AbstractController{
	//日志
	private Logger logger=Logger.getLogger(this.getClass());
	@Autowired
	private TypeService typeService;
	//获取菜品种类列表

	@ResponseBody
	@RequestMapping("/list")	
	public R list(@RequestParam Map<String, Object> params){
		logger.info("进入获取菜品种类列表的方法list");
		//查询列表数据
		Query query = new Query(params);
		List<TypeEntity> typeList = typeService.queryList(query);
		int total = typeService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(typeList, total, query.getLimit(), query.getPage());
		logger.info("离开获取菜品种类列表的方法list");
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 保存菜品类型
	 */
	@ResponseBody
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public R save(TypeEntity type){
		logger.info("进入保存菜品类型的方法save");
		ValidatorUtils.validateEntity(type, AddGroup.class);
		typeService.save(type);
		logger.info("离开保存菜品类型的方法save");
		return R.ok();
	}
	
	/**
	 * 菜品种类信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Long id){
		logger.info("进入获取菜品种类信息的方法info");
		TypeEntity type =typeService.queryObject(id);
		return R.ok().put("type", type);
	}
	
	
	/**
	 * 修改菜品种类
	 */
	@ResponseBody
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public R update( TypeEntity type){
		logger.info("进入修改菜品种类的方法update");
		ValidatorUtils.validateEntity(type, AddGroup.class);
		typeService.update(type);
		return R.ok();
	}
	
	
	/**
	 * 删除菜品种类
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] ids){
		logger.info("进入删除菜品种类的方法delete");
		typeService.deleteBatch(ids);
		
		return R.ok();
	}
	
/**
	 * 获取菜品类型
	 */
	@ResponseBody
	@RequestMapping(value="/dishType" , method = RequestMethod.POST)
	public R dishType( ){
		logger.info("进入获取菜品类型的方法dishType");
		Map<String, Object> map=new HashMap<>();
		 List<TypeEntity> typeList=typeService.queryList(map);
	//	 System.out.println("________________________________________"+typeList);
		return R.ok().put("type", typeList);
	}

}
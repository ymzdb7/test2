package com.winhands.modules.restaurant.controller;

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
import com.winhands.modules.restaurant.entity.CalculateEntity;
import com.winhands.modules.restaurant.service.CalculateService;
import com.winhands.modules.sys.controller.AbstractController;


/**
 * 计量单位管理
 * 
 */
@RestController
@RequestMapping("/restaurant/calculate")
public class CalculateController extends AbstractController {
	//日志
	private Logger logger=Logger.getLogger(this.getClass());
	@Autowired
	private CalculateService calculateService;
	/**
	 * 所有计量单位列表
	 */

	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		logger.info("进入展示所有计量单位列表的方法list");
		Query query = new Query(params);
		List<CalculateEntity> calculateList = calculateService.queryList(query);
		int total = calculateService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(calculateList, total, query.getLimit(), query.getPage());
		logger.info("离开展示所有计量单位列表的方法list");

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 保存计量单位
	 */
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public R save(CalculateEntity calculate){
		logger.info("进入保存计量单位的方法save");
		ValidatorUtils.validateEntity(calculate, AddGroup.class);
		calculateService.save(calculate);
		logger.info("离开保存计量单位的方法save");
		return R.ok();
	}
	
	/**
	 * 修改计量单位
	 */
	@ResponseBody
	@RequestMapping(value="/update" , method=RequestMethod.POST)
	public R update(CalculateEntity calculate){
		logger.info("进入修改计量单位的方法update");
		ValidatorUtils.validateEntity(calculate, AddGroup.class);
		calculateService.update(calculate);
		logger.info("离开修改计量单位的方法update");
		return R.ok();
	}
	
	/**
	 * 根据id获取单个计量单位信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id")Long id){
		logger.info("进入根据id获取单个计量单位信息的方法info");
		CalculateEntity calculate = calculateService.queryObject(id);
		logger.info("离开根据id获取单个计量单位信息的方法info");
		return R.ok().put("calculate", calculate);
	}
	/**
	 * 删除计量单位
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] ids){
		logger.info("进入删除计量单位的方法delete");
		calculateService.deleteBatch(ids);
		logger.info("离开删除计量单位的方法delete");
		return R.ok();
	}
	
	
}
	


package com.winhands.modules.restaurant.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.winhands.modules.restaurant.entity.CardDeviceEntity;
import com.winhands.modules.restaurant.entity.ExpenseCountsEntity;
import com.winhands.modules.restaurant.entity.TypeEntity;
import com.winhands.modules.restaurant.service.CardDeviceService;
import com.winhands.modules.sys.controller.AbstractController;


/**
 * 特殊交易设备管理
 * 
 */

@RestController
@RequestMapping("/restaurant/cardDevice")
public class CardDeviceController  extends AbstractController{
	
	//日志
	private Logger logger=Logger.getLogger(this.getClass());
	@Autowired
	private CardDeviceService cardDeviceService;
	//获取特殊交易设备列表

	@ResponseBody
	@RequestMapping("/list")	
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
		logger.info("进入展示特殊交易设备列表的方法list");
		String a=(String)params.get("terminalNo");
		if(a!=null&&!a.trim().equals("")) {
			params.put("terminalNo", a.trim());
		}
		Query query = new Query(params);
		List<CardDeviceEntity> cardDeviceList = cardDeviceService.queryList(query);
		int total = cardDeviceService.queryTotal(query);
				
		PageUtils pageUtil = new PageUtils(cardDeviceList, total, query.getLimit(), query.getPage());
		logger.info("离开展示特殊交易设备列表的方法list");
		return R.ok().put("page", pageUtil);
		
	}
	
	
	/**
	 * 根据卡号、部门查询招待费月汇总
	 */
	@ResponseBody
	@RequestMapping("/exCoulist")	
	public R exCoulist(@RequestParam Map<String, Object> params){
		//查询列表数据
		logger.info("进入展示根据卡号、部门查询招待费月汇总的方法exCoulist");
		SimpleDateFormat sdf=new SimpleDateFormat("yy-MM");
		if(params.get("transTime")==null) {
			params.put("transTime", sdf.format(new Date()));
		}
		Query query = new Query(params);
		List<ExpenseCountsEntity> exCouList = cardDeviceService.queryListExCou(query);
		int total = cardDeviceService.queryTotal(query);
		PageUtils pageUtil = new PageUtils(exCouList, total, query.getLimit(), query.getPage());
		logger.info("离开展示根据卡号、部门查询招待费月汇总的方法exCoulist");
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 保存特殊交易设备
	 */
	@ResponseBody
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public R save(CardDeviceEntity cardDevice){
		logger.info("进入保存特殊交易设备的方法save");
		ValidatorUtils.validateEntity(cardDevice, AddGroup.class);
		cardDeviceService.save(cardDevice);
		logger.info("离开保存特殊交易设备的方法save");
		return R.ok();
	}

}

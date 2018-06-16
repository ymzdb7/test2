package com.winhands.modules.restaurant.controller;

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
import com.winhands.modules.restaurant.entity.CardDepartmentEntity;
import com.winhands.modules.restaurant.entity.CardDepartmentHeEntity;
import com.winhands.modules.restaurant.entity.TypeEntity;
import com.winhands.modules.restaurant.service.CardDepartmentService;
import com.winhands.modules.sys.controller.AbstractController;


/**
 * 招待卡管理
 * 
 */

@RestController
@RequestMapping("/restaurant/cardDepartment")
public class CardDepartmentController  extends AbstractController{
	//日志
	private Logger logger=Logger.getLogger(this.getClass());
	@Autowired
	private CardDepartmentService cardDepartmentService;
	//获取招待卡列表

	@ResponseBody
	@RequestMapping("/list")	
	public R list(@RequestParam Map<String, Object> params){
		logger.info("进入展示招待卡列表的方法list");
		//查询列表数据
		String a=(String)params.get("cardNo");
		if(a!=null&&!a.trim().equals("")) {
			params.put("cardNo", a.trim());
		}
		Query query = new Query(params);
		List<CardDepartmentEntity> cardDeparHeList = cardDepartmentService.queryList(query);
		int total =cardDepartmentService.queryTotal(query);
		PageUtils pageUtil = new PageUtils(cardDeparHeList, total, query.getLimit(), query.getPage());
		logger.info("离开展示招待卡列表的方法list");
		return R.ok().put("page", pageUtil);
	}
	
	/**
	 * 保存招待卡
	 */
	@ResponseBody
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public R save(CardDepartmentEntity cardDepartment){
		logger.info("进入保存招待卡的方法save");
		ValidatorUtils.validateEntity(cardDepartment, AddGroup.class);
		cardDepartmentService.save(cardDepartment);
		logger.info("离开保存招待卡的方法save");
		return R.ok();
	}
	

}

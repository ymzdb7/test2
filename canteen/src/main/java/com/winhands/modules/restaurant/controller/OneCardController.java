package com.winhands.modules.restaurant.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.winhands.common.annotation.SysLog;
import com.winhands.common.utils.PageUtils;
import com.winhands.common.utils.Query;
import com.winhands.common.utils.R;
import com.winhands.modules.restaurant.entity.EmMoneyCountsEntity;
import com.winhands.modules.restaurant.entity.OneCardEntity;
import com.winhands.modules.restaurant.service.OneCardService;
import com.winhands.modules.sys.controller.AbstractController;

/**
 * 一卡通查询管理
 * 
 */
@RestController
@RequestMapping("/restaurant/oneCard")
public class OneCardController extends AbstractController {
	//日志
	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private OneCardService oneCardService;
	@ResponseBody
	@RequestMapping("/list")	
	public R list(@RequestParam Map<String, Object> params){
		logger.info("进入展示一卡通列表的方法list");
		//查询列表数据
		String a=(String)params.get("employeeNo");
		if(a!=null&&!a.trim().equals("")) {
			params.put("employeeNo", a.trim());
		}
		
		Query query = new Query(params);
		List<OneCardEntity> oneCardList = oneCardService.queryList(query);
		int total = oneCardService.queryTotal(query);
		PageUtils pageUtil = new PageUtils(oneCardList, total, query.getLimit(), query.getPage());
		logger.info("离开展示一卡通列表的方法list");
		return R.ok().put("page", pageUtil);
	}
	//员工月消费汇总表
	@RequestMapping("/emclist")	
	public R emclist(@RequestParam Map<String, Object> params){
		logger.info("进入员工月消费汇总表的方法emclist");
		//查询列表数据
		SimpleDateFormat sdf=new SimpleDateFormat("yy-MM");
		if(params.get("transTime")==null) {
			params.put("transTime", sdf.format(new Date()));
		}
		Query query = new Query(params);
		List<EmMoneyCountsEntity> emMoCouList = oneCardService.queryListEmMoCou(query);
		int total = oneCardService.queryTotalEmMoCou(query);
		PageUtils pageUtil = new PageUtils(emMoCouList, total, query.getLimit(), query.getPage());
		logger.info("离开员工月消费汇总表的方法emclist");
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 删除一卡通帐户交易信息
	 */
	@SysLog("删除一卡通帐户交易信息")
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] ids){
		logger.info("进入删除一卡通帐户交易信息的方法delete");
		oneCardService.deleteBatch(ids);
		logger.info("离开删除一卡通帐户交易信息的方法delete");
		return R.ok();
	}
	
	/**
	 * 客户端获取个人消费流水列表
	 */
	@RequestMapping(value="/oneCardTransList" , method = RequestMethod.POST)
	public R oneCardTransList(String startTime,String endTime,String account){
		logger.info("进入客户端获取个人消费流水列表的方法oneCardTransList");
		List<List> oneCardTransList = new ArrayList<List>();
		//查询列表数据
		Map <String ,Object> map =null;
		map =  new HashMap<String ,Object>();
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		Date date = sdf.parse(createTime);*/
			map.put("startTime", startTime);
			map.put("endTime",endTime);
			map.put("account", account);
			
			List<OneCardEntity> oneCardList=oneCardService.queryList(map);
			if(null==oneCardList||oneCardList.size()==0) {
			}else {
				oneCardTransList.add(oneCardList);
			}
			logger.info("离开客户端获取个人消费流水列表的方法oneCardTransList");
	return R.ok().put("oneCardTransList", oneCardTransList);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

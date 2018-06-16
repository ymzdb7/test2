package com.winhands.modules.restaurant.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.winhands.common.utils.PageUtils;
import com.winhands.common.utils.Query;
import com.winhands.common.utils.R;
import com.winhands.modules.restaurant.entity.EnviroTalkEntity;
import com.winhands.modules.restaurant.service.EnviroTalkService;
import com.winhands.modules.sys.controller.AbstractController;


/**
 * 环境评价管理
 * 
 */

@RestController
@RequestMapping("/restaurant/enviroTalk")
public class EnviroTalkController  extends AbstractController{
	
	//日志
			private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private EnviroTalkService enviroTalkService;
	//获取环境评价列表

	@ResponseBody
	@RequestMapping("/list")	
	public R list(@RequestParam Map<String, Object> params){
		logger.info("进入获取环境评价列表的方法list");
		//查询列表数据
	/*	if(getUser().getAddress()!=null) {
			if(!StringUtil.isNull(getUser().getAddress().trim())) {
				params.put("address", getUser().getAddress().trim());
			}
		}*/
			
		Query query = new Query(params);
		List<EnviroTalkEntity> enTalkList = enviroTalkService.queryList(query);
		int total = enviroTalkService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(enTalkList, total, query.getLimit(), query.getPage());
		logger.info("离开获取环境评价列表的方法list");
		return R.ok().put("page", pageUtil);
	}
	

	/**
	 * 删除环境评价
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] ids){
		logger.info("进入删除环境评价的方法delete");
		enviroTalkService.deleteBatch(ids);
		logger.info("离开删除环境评价的方法delete");
		return R.ok();
	}
	
	
	
}

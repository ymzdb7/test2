package com.winhands.modules.restaurant.controller;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
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
import com.winhands.modules.restaurant.entity.EnviroTalkEntity;
import com.winhands.modules.restaurant.entity.EvaluateEntity;
import com.winhands.modules.restaurant.service.EnviroTalkService;
import com.winhands.modules.restaurant.service.EvaluateService;
import com.winhands.modules.sys.controller.AbstractController;
import com.winhands.modules.sys.entity.SysUserEntity;


/**
 * 评价管理
 * 
 */

@RestController
@RequestMapping("/restaurant/evaluates")
public class EvaluateController  extends AbstractController{
	//日志
	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private EvaluateService evaluateService;
	@Autowired
	private EnviroTalkService enviroTalkService;
	@ResponseBody
	@RequestMapping("/list")	
	public R list(@RequestParam Map<String, Object> params){
		logger.info("进入评价管理列表的方法list");
		//查询列表数据
		Query query = new Query(params);
		List<EvaluateEntity> evaluateList = evaluateService.queryList(query);
		int total = evaluateService.queryTotal(query);
		PageUtils pageUtil = new PageUtils(evaluateList, total, query.getLimit(), query.getPage());
		logger.info("离开评价管理列表的方法list");
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 删除菜品
	 */
	@SysLog("删除评论")
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] ids){
		logger.info("进入删除评论的方法delete");
		evaluateService.deleteBatch(ids);
		logger.info("离开删除评论的方法delete");
		return R.ok();
	}
	
	/**
	 * 客户端获取菜单评价状态
	 */
	@ResponseBody
	@RequestMapping(value="/dishEvaluateSave" , method = RequestMethod.POST)
	public R dishEvaluateSave(EvaluateEntity evaluate){
		logger.info("进入客户端获取菜单评价状态的方法dishEvaluateSave");
		try {
			evaluate.setParentId(0);
			//evaluate.setCreateUserId(getUser().getUserId().toString());
			evaluate.setCreateTime(new Date());
			evaluate.setType(2);
			evaluateService.save(evaluate);
		} catch (Exception e) {
			logger.error("增加失败"+e.getMessage());
			return R.ok("增加失败!");
		}
		logger.info("离开客户端获取菜单评价状态的方法dishEvaluateSave");
		return R.ok("增加成功");
	}

	/**
	 * 客户端获取环境评价状态
	 */
	@ResponseBody
	@RequestMapping(value="/environmentEvaluateSave",  method = RequestMethod.POST)
	
	public R  environmentEvaluateSave(String content,String address,String startEvaluate,String startNum) {
	logger.info("进入客户端获取环境评价状态的方法environmentEvaluateSave");
		EnviroTalkEntity enviroTalk=new EnviroTalkEntity();
/*
		try {*/
	
			SysUserEntity user=getUser();
				if(user.getUsername()!=null&&!user.getUsername().trim().equals("")) {
			enviroTalk.setUserName(getUser().getUsername());
			}
				enviroTalk.setCreateTime(Timestamp.valueOf(DateTime.now().toString("yyyy-MM-dd HH:mm:ss")));
				enviroTalk.setStartEvaluate(startEvaluate);//星级评价附带文字内容
				enviroTalk.setContent(content);//评论内容
				enviroTalk.setAddress(address);
				enviroTalk.setStartNum(Integer.parseInt(startNum));//几颗星
			enviroTalkService.save(enviroTalk);
	/*	} catch (Exception e) {
			return R.ok("评论失败!");
		}*/
			logger.info("离开客户端获取环境评价状态的方法environmentEvaluateSave");
			return R.ok("评价成功!");
	
	}
	
	

	/**
	 * 客户端获取用户是否评论状态
	 */
	@ResponseBody
	@RequestMapping(value="/isNoEvaluate",  method = RequestMethod.POST)
	public  R isNoEvaluate(String createUserId,String dishId,String carteId) {
		logger.info("进入客户端获取用户是否评论状态的方法isNoEvaluate");
		logger.info("进入客户端获取用户是否评论状态的方法isNoEvaluate");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(new Date());
		Map <String ,Object> map =  new HashMap<String ,Object>();
		map.put("createUserId", createUserId);
		map.put("dishId",Integer.parseInt(dishId) );
		map.put("carteId",Integer.parseInt(carteId));
		map.put("createTime",date);
		EvaluateEntity  evaluate=evaluateService.queryObject(map);
	if(evaluate==null) {
			return  R.ok("0");
		}
	logger.info("离开客户端获取用户是否评论状态的方法isNoEvaluate");

			return R.ok("1");
	}

}

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

import com.winhands.modules.restaurant.entity.CarteBankEntity;
import com.winhands.modules.restaurant.entity.CarteTypeDishesEntity;
import com.winhands.modules.restaurant.service.CarteBankService;
import com.winhands.modules.restaurant.service.CarteTypeDishesService;
import com.winhands.modules.sys.controller.AbstractController;


/**
 * 菜单、菜品、菜品类型关联信息管理
 * 
 */

@RestController
@RequestMapping("/restaurant/carteTypeDishes")
public class CarteTypeDishesController  extends AbstractController{
	
	//日志
	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private CarteTypeDishesService carteTypeDishesService;
	@Autowired
	private CarteBankService carteBankService;
	//获取菜单、菜品、菜品类型关联信息列表
	@ResponseBody
	@RequestMapping("/list/{id}")	
	public R list(@PathVariable("id") Long id,@RequestParam Map<String, Object> params){
		logger.info("进入展示菜单、菜品、菜品类型管理关联信息的方法list");
		//查询列表数据
		params.put("carteId", id);
		Query query = new Query(params);
		List<CarteTypeDishesEntity> carteTypeDishesList = carteTypeDishesService.queryList(query);
		int total = carteTypeDishesService.queryTotal(query);
		PageUtils pageUtil = new PageUtils(carteTypeDishesList, total, query.getLimit(), query.getPage());
		logger.info("离开展示菜单、菜品、菜品类型管理关联信息的方法list");
		return R.ok().put("page", pageUtil);
	}

	/**
	 * 保存菜单、菜品、菜品类型关联信息
	 */
	@ResponseBody
	@RequestMapping(value="/save/{id}", method=RequestMethod.POST)
	public R save(@PathVariable("id") Long id,@RequestBody Long[] ides){
		logger.info("进入保存菜单、菜品、菜品类型关联信息的方法save");
		carteTypeDishesService.delete(id);
		CarteTypeDishesEntity carteTypeDishes=new CarteTypeDishesEntity();
		for (int i = 0; i < ides.length; i++) {
		carteTypeDishes.setCarteId(id);
		carteTypeDishes.setDishesId(ides[i]);
		carteTypeDishesService.save(carteTypeDishes);
	}
		logger.info("离开保存菜单、菜品、菜品类型关联信息的方法save");
		return R.ok();
	}
	
	
	/**
	 * 删除菜品种类
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] ids){
		logger.info("进入删除菜品种类的方法delete");
		carteTypeDishesService.deleteBatch(ids);
		logger.info("离开删除菜品种类的方法delete");
		return R.ok();
	}
	
	/**
	 * 获取所有菜单库信息
	 */
	@RequestMapping("/infooo")
	public R infooo(){
		logger.info("进入获取所有菜单库信息的方法infooo");
		Map<String,Object> map=new HashMap<String,Object>();
		List<CarteBankEntity> carteBankList =carteBankService.queryList(map);
		logger.info("离开获取所有菜单库信息的方法infooo");
		return R.ok().put("carteBankList", carteBankList);
	}
	
	
	
	/**
	 * 根据菜单id获取该菜单下所有菜品信息
	 */
	@ResponseBody
	@RequestMapping(value="/getDishesByIdinfo/{id}", method=RequestMethod.POST)
	public R getDishesByIdinfo(@PathVariable("id") Long id ){
		logger.info("进入根据菜单id获取该菜单下所有菜品信息的方法getDishesByIdinfo");
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("carteId", id);
		List<CarteTypeDishesEntity> carteTypeDishes=carteTypeDishesService.queryListByDishes(map);
		logger.info("离开根据菜单id获取该菜单下所有菜品信息的方法getDishesByIdinfo");
		return R.ok().put("carteTypeDishes", carteTypeDishes);
	}
	
	
	
	

}

package com.winhands.modules.restaurant.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
import com.winhands.modules.restaurant.entity.CarteBankDishesEntity;
import com.winhands.modules.restaurant.entity.CarteTypeDishesEntity;
import com.winhands.modules.restaurant.service.CarteBankDishesService;
import com.winhands.modules.sys.controller.AbstractController;


/**
 * 菜品类型管理
 * 
 */

@RestController
@RequestMapping("/restaurant/carteBankDishes")
public class CarteBankDishesController  extends AbstractController{
	@Autowired
	private CarteBankDishesService carteBankDishesService;
	//获取菜品种类列表
	@ResponseBody
	@RequestMapping("/list/{id}")	
	public R list(@PathVariable("id") Long id,@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("carteBankId", id);
		Query query = new Query(params);
		List<CarteBankDishesEntity> carteBankDishesList = carteBankDishesService.queryList(query);
		int total = carteBankDishesService.queryTotal(query);
		PageUtils pageUtil = new PageUtils(carteBankDishesList, total, query.getLimit(), query.getPage());
		return R.ok().put("page", pageUtil);
	}

	/**
	 * 保存菜品类型
	 */
	@ResponseBody
	@RequestMapping(value="/save/{id}", method=RequestMethod.POST)
	public R save(@PathVariable("id") Long id,@RequestBody Long[] ides){
			carteBankDishesService.delete(id);
			
		
		CarteBankDishesEntity carteBankDishes=new CarteBankDishesEntity();
		for (int i = 0; i < ides.length; i++) {
			carteBankDishes.setCarteBankId(id);
			carteBankDishes.setDishesId(ides[i]);
			carteBankDishesService.save(carteBankDishes);
			
		}
		
	
		return R.ok();
	}

	
	/**
	 * 删除菜品种类
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] ids){
		carteBankDishesService.deleteBatch(ids);
		
		return R.ok();
	}
	
	/**
	 * 菜品种类信息
	 */
	@ResponseBody
	@RequestMapping(value="/getDishesByIdinfo/{id}", method=RequestMethod.POST)
	public R getDishesByIdinfo(@PathVariable("id") Long id ){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("carteBankId", id);
		List<CarteBankDishesEntity> carteBankDishes=carteBankDishesService.queryList(map);
		return R.ok().put("carteBankDishes", carteBankDishes);
	}
	
	
}

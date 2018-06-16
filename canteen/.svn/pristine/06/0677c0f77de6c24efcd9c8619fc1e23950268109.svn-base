package com.winhands.modules.restaurant.controller;
import java.util.ArrayList;
import java.util.Date;
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
import com.winhands.modules.restaurant.entity.CarteBankDishesEntity;
import com.winhands.modules.restaurant.entity.CarteBankEntity;
import com.winhands.modules.restaurant.service.CarteBankDishesService;
import com.winhands.modules.restaurant.service.CarteBankService;
import com.winhands.modules.sys.controller.AbstractController;
/**
 * 菜单库管理
 * 
 */
@RestController
@RequestMapping("/restaurant/carteBank")
public class CarteBankController extends AbstractController {
	//日志
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private CarteBankService carteBankService;
	@Autowired
	private CarteBankDishesService carteBankDishesService;
	//获取菜品种类列表

	@ResponseBody
	@RequestMapping("/list")	
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
		logger.info("--");
		List<Map> carteBankList = new ArrayList<Map>();
		Map<String,List> map=new HashMap<String,List>();
		Query query = new Query(params);
		List<CarteBankEntity> carteBaList = carteBankService.queryList(query);
		
		map.put("carteBaList", carteBaList);
		carteBankList.add(map);
		int total = carteBankService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(carteBankList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 保存菜单
	 */
	@ResponseBody
	@RequestMapping(value="/save/{ides}", method=RequestMethod.POST)
	public R save(@PathVariable("ides") Long[] ides,CarteBankEntity carteBank){
		ValidatorUtils.validateEntity(carteBank, AddGroup.class);
		carteBank.setCreateDate(new Date());
		carteBankService.save(carteBank);
		
		CarteBankEntity carteBank1=carteBankService.queryNew();
		CarteBankDishesEntity carteBankDishes=new CarteBankDishesEntity();
		
	for (int i = 0; i < ides.length; i++) {
		carteBankDishes.setCarteBankId(carteBank1.getId());;
		carteBankDishes.setDishesId(ides[i]);
		carteBankDishesService.save(carteBankDishes);
		
	}
		
		
		return R.ok();
	}
	
	
	/**
	 * 菜单信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Long id){
		CarteBankEntity carteBank =carteBankService.queryObject(id);
	
		return R.ok().put("carteBank", carteBank);
	}
	/**
	 * 修改菜品种类
	 */
	@ResponseBody
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public R update(CarteBankEntity carteBank){
	
		carteBankService.update(carteBank);
		return R.ok();
	}
	
	/**
	 * 删除菜单信息
	 */
	@RequestMapping("/deletee")
	public R deletee(@RequestBody Long id){
		carteBankService.delete(id);
		carteBankDishesService.delete(id);
		return R.ok();
	}
	
	

	
}

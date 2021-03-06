package com.winhands.modules.restaurant.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.tools.extcheck.Main;
import com.winhands.modules.restaurant.dao.CarteDao;
import com.winhands.modules.restaurant.dao.CarteTypeDishesDao;
import com.winhands.modules.restaurant.dao.DishesCarteDao;
import com.winhands.modules.restaurant.dao.DishesDao;
import com.winhands.modules.restaurant.dao.TypeDao;
import com.winhands.modules.restaurant.entity.CarteBankEntity;
import com.winhands.modules.restaurant.entity.CarteEntity;
import com.winhands.modules.restaurant.entity.CarteTypeDishesEntity;
import com.winhands.modules.restaurant.entity.DishesCarteEntity;
import com.winhands.modules.restaurant.entity.DishesEntity;
import com.winhands.modules.restaurant.entity.TypeEntity;
import com.winhands.modules.restaurant.service.CarteService;



/**
 * 菜品管理
 */
@Service("carteService")
public class CarteServiceImpl implements CarteService {
	@Autowired
	private CarteDao carteDao;
	@Autowired
	private DishesCarteDao dishesCarteDao;
	@Autowired
	private DishesDao dishesDao;
	@Autowired
	private TypeDao typeDao;
	
	@Autowired
	private CarteTypeDishesDao carteTypeDishesDao;
	

	@Override
/*	@Transactional*/
	public void save(CarteEntity carte) {
		carteDao.save(carte);
	/*	if(carte.getCartdishList()!=null&&carte.getCartdishList().size()!=0) {
			for(int i=0;i<carte.getCartdishList().size();i++) {
				DishesCarteEntity temp = carte.getCartdishList().get(i);
				temp.setIsRecom(1);//选中
				temp.setCarteId(carte.getId());
				dishesCarteDao.save(temp);
			}
		}*/
		
	}

	@Override
	public List<CarteEntity> queryList(Map<String, Object> map) {
		List <CarteEntity> carteList = carteDao.queryList(map);
		
		if(null!=carteList&&carteList.size()!=0) {
			for(int i=0;i<carteList.size();i++) {
				List<TypeEntity> typeList=typeDao.queryList(map);
			map.put("carteId", carteList.get(i).getId());
		
			List<CarteTypeDishesEntity>	carteTypeDishes=carteTypeDishesDao.queryList(map);
				for (int j = 0; j < typeList.size(); j++) {
					List<CarteTypeDishesEntity> list = new ArrayList<CarteTypeDishesEntity>();
					for (int j2 = 0; j2 < carteTypeDishes.size(); j2++) {
						if(carteTypeDishes.get(j2).getTypeName()!=null&&typeList.get(j).getTypeName().compareTo(carteTypeDishes.get(j2).getTypeName())==0){			
							list.add(carteTypeDishes.get(j2));
						}
						}
					
					typeList.get(j).setCartdishList(list);
					
				}
			
				carteList.get(i).setTypeCartList(typeList);
			}
		}
		
		
		
		
		
		
		
		
		/*	if(null!=carteList&&carteList.size()!=0) {
			
			for(int i=0;i<carteList.size();i++) {
				
				List<TypeEntity> typeList=typeDao.queryList(map);
				carteList.get(i).setTypeCartList(typeList);
				
				String foodList=carteList.get(i).getFoodsList();
				
				String[] str = foodList.split(";");
				String typeName="";
				String typeStr="";
				//String typeStr="";
				for (int j = 0; j < str.length; j++) {
					
					String st=str[j];
					System.out.println(j+"+++++"+st);
					String[] strs=st.split(":");
					if(strs.length>1) {
						typeName=strs[0];
						typeStr=strs[1];	
					}
										
					String typeS[] = typeStr.split("、");
					List<DishesEntity> dishesList=dishesDao.typeDish(typeS);
				
					for (int k = 0; k < typeList.size(); k++) {
						if(typeList.get(k).getTypeName().compareTo(typeName.trim())==0) {
						typeList.get(k).setCartdishList(dishesList);
						}
					}
				}
				*/
			
				
			/*	
				List <DishesEntity> dishList=new ArrayList<>();
				for (int j = 0; j < typeList.size(); j++) {
					
					
					Map<String, Object>		mapN=new HashMap<String,Object>();
					mapN.put("typeName",typeList.get(j).getTypeName());
					mapN.put("carteId", carteList.get(i).getId());
				 dishList = dishesDao.queryDishList(mapN);	
				 typeList.get(j).setCartdishList(dishList);
				}*/
				
				
			/*	List <DishesEntity> dishList = dishesDao.queryDishList(mapN);	*/
			/*	List <DishesEntity> dishList = dishesDao.queryDishList(carteList.get(i).getId());*/
				
			/*	String disheNames = "";
				if(null!=dishList&&dishList.size()!=0) {
					for(int j=0;j<dishList.size();j++) {
						disheNames +=dishList.get(j).getDishes()+",";
					}
					disheNames=disheNames.substring(0, disheNames.length()-1);
				}
				carteList.get(i).setFoodsList(disheNames);*/
				
				/*carteList.get(i).setDishesCartList(dishList);*/
		/*	}*/
		/*}*/
		return carteList;
	}

	@Override
	public void deleteBatch(Long[] id) {
		//先删除菜单菜品关系表数据
		dishesCarteDao.deleteBatch(id);
		carteDao.deleteBatch(id);
	}

	@Override
	public void update(CarteEntity carte) {
		//先删除原先菜品菜单关系信息再保存
		Long [] id = new Long [1];
		id[0] = carte.getId();
		dishesCarteDao.deleteBatch(id);
		if(carte.getCartdishList()!=null&&carte.getCartdishList().size()!=0) {
			for(int i=0;i<carte.getCartdishList().size();i++) {
				DishesCarteEntity temp = carte.getCartdishList().get(i);
				temp.setCarteId(carte.getId());
				temp.setIsRecom(1);//选中
				dishesCarteDao.save(temp);
			}
		}
		carteDao.update(carte);
	}

	
	@Override
	public int queryTotal(Map<String, Object> map) {
		return carteDao.queryTotal(map);
	}

	@Override
	public CarteEntity queryObject(Long id) {
		return carteDao.queryObject(id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		carteDao.delete(id);
	}
	

	@Override
	public CarteEntity queryNew() {
		// TODO Auto-generated method stub
		return carteDao.queryNew();
	}

	@Override
	public List<String> queryaddressList() {
		// TODO Auto-generated method stub
		return carteDao.queryaddressList();
	}
	
	
}

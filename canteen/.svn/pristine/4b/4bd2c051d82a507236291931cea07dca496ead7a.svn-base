package com.winhands.modules.restaurant.service.impl;


import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.winhands.modules.restaurant.dao.ThumbsDao;
import com.winhands.modules.restaurant.entity.ThumbsEntity;
import com.winhands.modules.restaurant.service.ThumbsService;



/**
 * 管理
 */
@Service("thumbsService")
public class ThumbsServiceImpl implements ThumbsService {
	@Autowired
	private ThumbsDao thumbsDao;
	

	@Override
	public void save(ThumbsEntity thumbs) {
		thumbsDao.save(thumbs);
	}


	@Override
	public void deleteBatch(Long[] id) {
		//先删除菜单菜品关系表数据
		thumbsDao.deleteBatch(id);
	}

	@Override
	public void update(ThumbsEntity thumbs) {
	
		thumbsDao.update(thumbs);
	}


	@Override
	public ThumbsEntity queryObject(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return thumbsDao.queryObject(map);
	}


}

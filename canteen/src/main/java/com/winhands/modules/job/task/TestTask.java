package com.winhands.modules.job.task;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.winhands.common.utils.HttpUtils;
import com.winhands.modules.sys.entity.SysUserEntity;
import com.winhands.modules.sys.service.SysUserService;

/**
 * 测试定时任务(演示Demo，可删除)
 * 
 * testTask为spring bean的名称
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月30日 下午1:34:24
 */
@Component("testTask")
public class TestTask {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private SysUserService sysUserService;
	
	public void test(String params){
		logger.info("我是带参数的test方法，正在被执行，参数为：" + params);
		
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		SysUserEntity user = sysUserService.queryObject(1L);
		System.out.println(ToStringBuilder.reflectionToString(user));
		
	}
	
	
	public void test2(){
		logger.info("我是不带参数的test2方法，正在被执行");
	}
	
	
	public void push(){
		logger.info("推送》》》》》》》》》》》》》");
		HttpUtils h=new HttpUtils();
		List<String> list=h.getAddressList();
		/*if(list!=null&& list.size()>0) {
			list.add("工程测试属地");
			pushService.pushCarte(list);
		}*/

	}
}

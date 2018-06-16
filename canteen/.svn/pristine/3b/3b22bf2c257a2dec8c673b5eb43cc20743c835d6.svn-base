package com.winhands.modules.restaurant.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
import com.winhands.modules.restaurant.entity.DinnerOrdersEntity;
import com.winhands.modules.restaurant.service.DinnerOrdersService;
import com.winhands.modules.sys.controller.AbstractController;
import com.winhands.modules.sys.entity.SysUserEntity;


/**
 * 订单管理
 * 
 */
@RestController
@RequestMapping("/restaurant/dinnerOrders")
public class DinnerOrdersController extends AbstractController {
	
	
	//日志
		private Logger logger = Logger.getLogger(this.getClass());
	/*@Autowired
	private SysUserRoleService sysUserRoleService;*/
	/*@Autowired
	private SysRoleService sysRoleService;*/
	@Autowired
	private DinnerOrdersService dinnerOrdersService;
	@ResponseBody
	@RequestMapping("/listNo")	
	public R listNo(@RequestParam Map<String, Object> params){
		//查询已审核列表数据
		/*sysRoleService.queryObject(sysUserRoleService.queryObject(getUser().getUserId()).getRoleId()).getRoleName();*/
		/*sysRoleService.queryObject(getUser().getRoleIdList().get(0)).getRoleName()*/
		/*
		if(getUser().getUsername().equals("admin")) {
			params.put("status", "已审核");
		}else {
			params.put("status", "未审核");
		}*/
		
		String timeNo=(String) params.get("timeNo");
		if(timeNo==null) {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date date=new Date();
			String time1=sdf.format(date);
			params.put("timeNo", time1);
		}else {
			
			params.put("timeNo", timeNo);
		}
			Query query = new Query(params);
			List<DinnerOrdersEntity> dinnerOrdersList = dinnerOrdersService.queryList(query);
			int total = dinnerOrdersService.queryTotal(query);
			PageUtils pageUtil = new PageUtils(dinnerOrdersList, total, query.getLimit(), query.getPage());
			return R.ok().put("page", pageUtil);	
			
		}
		
		
		
	
	
	
	
	@ResponseBody
	@RequestMapping("/list")	
	public R list(@RequestParam Map<String, Object> params)  {
		logger.info("进入展示晚餐预定列表的方法list");
		//查询已审核列表数据
		/*sysRoleService.queryObject(sysUserRoleService.queryObject(getUser().getUserId()).getRoleId()).getRoleName();*/
		/*sysRoleService.queryObject(getUser().getRoleIdList().get(0)).getRoleName()*/
		if(getUser().getUsername().equals("admin")) {
			params.put("status", "已审核");
		}
		String time=(String) params.get("time");
		if(time==null) {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date date=new Date();
			String time1=sdf.format(date);
			params.put("time", time1);
		}else {
			params.put("time", time);
		}
			Query query = new Query(params);
		List<DinnerOrdersEntity> dinnerOrdersList = dinnerOrdersService.queryList1(query);
		int total = dinnerOrdersService.queryTotal2(query);
		PageUtils pageUtil = new PageUtils(dinnerOrdersList, total, query.getLimit(), query.getPage());
		logger.info("离开展示晚餐预定列表的方法list");
		return R.ok().put("page", pageUtil);
		}
	
	
	
	
	
	/**
	 * 删除订单
	 */
	@SysLog("删除订单")
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] ids){
		logger.info("进入删除订单的方法delete");
		dinnerOrdersService.deleteBatch(ids);
		logger.info("离开删除订单的方法delete");
		return R.ok();
	}
	
	
	
	/**
	 * 审核通过
	 */

	@RequestMapping("/statusPass")
	public R statusPass(@RequestBody Long[] ids){
		DinnerOrdersEntity dy=new DinnerOrdersEntity();
		for (int i = 0; i < ids.length; i++) {
		dy=dinnerOrdersService.queryObject(ids[i]);
		dy.setStatus("已审核");
		dinnerOrdersService.update(dy);
			}
		return R.ok();
	}
	

	
	
	/**
	 * 客户端获取订单状态预定接口
	 */
	@ResponseBody
	@RequestMapping(value="/dinnerOrdersSave", method=RequestMethod.POST)
	public R  dinnerOrdersSave() {
		logger.info("进入客户端获取订单状态预定接口的方法dinnerOrdersSave");
	DinnerOrdersEntity order= new DinnerOrdersEntity();
	SysUserEntity user=getUser();
		try {
			order.setCreateTime(Timestamp.valueOf(DateTime.now().toString("yyyy-MM-dd HH:mm:ss")));
			order.setUserName(user.getUsername());
			order.setAddress(user.getAddress());
			order.setMobile(user.getMobile());
			order.setDepartment(user.getDepartment());
			order.setStatus("未审核");
			dinnerOrdersService.save(order);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return R.ok("晚餐预定失败!");
		}
		logger.info("离开客户端获取订单状态预定接口的方法dinnerOrdersSave");
		return R.ok("晚餐预定成功!");
	}
	
	/**
	 * 客户端获取订单情况
	 */
	
	@RequestMapping(value="/dinnerOrdersList" , method = RequestMethod.POST)
	public R dinnerOrdersList(String createTime){
		logger.info("进入客户端获取订单情况的方法dinnerOrdersList");
		List<List> dinnerOrdersList = new ArrayList<List>();
		//查询列表数据
		Map <String ,Object> map=  new HashMap<String ,Object>();
	
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		Date date = sdf.parse(createTime);*/
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		String time=sdf.format(date);
		
			map.put("createTime", createTime);
			
			List<DinnerOrdersEntity> ordersList=dinnerOrdersService.queryDateList(map);
			if(null==ordersList||ordersList.size()==0) {
			}else {
				dinnerOrdersList.add(ordersList);
			}
		
			logger.info("离开客户端获取订单情况的方法dinnerOrdersList");
			return R.ok1().put("dinnerOrdersList", dinnerOrdersList);
	}
	
	/**
	 * 客户端获取订餐用户名列表
	 */
	@RequestMapping(value="/dinnerOrdersUserList" , method = RequestMethod.POST)
	public R dinnerOrdersUserList(String department){
		logger.info("进入客户端获取订餐用户名列表的方法dinnerOrdersList");
		List<List> dinnerOrdersList=new ArrayList<List>();
	Map<String, Object> map=new HashMap<String,Object>();
	Map<String, Object> dinnerOrdersMap=new HashMap<String,Object>();
	
		map.put("department",department);
	
	
			
			int total=dinnerOrdersService.queryTotal(map);
			List<DinnerOrdersEntity> ordersList=dinnerOrdersService.queryList(map);

			if(null==ordersList||ordersList.size()==0) { 
			}else {
				dinnerOrdersList.add(ordersList);
				
			}
	
		dinnerOrdersMap.put("total", total);
		dinnerOrdersMap.put("dinnerOrdersList", dinnerOrdersList);
		logger.info("离开客户端获取订餐用户名列表的方法dinnerOrdersList");
	return R.ok().put("dinnerOrdersMap", dinnerOrdersMap);
	}
	
	/**
	 * 客户端获取订餐部门人数
	 */
	
	@RequestMapping(value="/dinnerOrdersCountList" , method = RequestMethod.POST)
	public R msList(String departmentId){
		logger.info("进入客户端获取订餐部门人数的方法msList");
	Map<String, Object> map=new HashMap<String,Object>();
	Map<String, Object> dinnerOrdersMap=new HashMap<String,Object>();
	map.put("departmentId",Integer.parseInt(departmentId));
			int total=dinnerOrdersService.queryTotal(map);
			dinnerOrdersMap.put("total", total);
			logger.info("离开客户端获取订餐部门人数的方法msList");
	return R.ok().put("dinnerOrdersMap", dinnerOrdersMap);
	}
	
	
	/**
	 * 客户端获取服务器时间
	 */
	
	@RequestMapping(value="/dinnerOrdersTime" , method = RequestMethod.POST)
	public R dinnerOrdersTime(String token){
		logger.info("进入客户端获取服务器时间的方法dinnerOrdersTime");
	Map<String, Object> orderMap=new HashMap<String,Object>();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date=new Date();
	String time=sdf.format(date);
	orderMap.put("orderTime", time);
	logger.info("离开客户端获取服务器时间的方法dinnerOrdersTime");
	return R.ok().put("orderMap", orderMap);
	}
	/**
	 * 导出根据时间查询的订单的Excel
	 */
	@ResponseBody
	@RequestMapping(value="/poiExpExcel" , method = RequestMethod.POST)	
	public R poiExpExcel(@RequestParam String time,HttpServletRequest request, HttpServletResponse response)  {
		logger.info("进入导出根据时间查询的订单的Excel的方法poiExpExcel");
		Map<String, Object> map=new HashMap<String,Object>();
		if(time!=null){
		map.put("time", time);
		}else {
			map.put("time", "");
		}
			List<DinnerOrdersEntity> dyList= dinnerOrdersService.queryListDu(map);
	
		
	String[] title={"姓名","部门id","属地","下单时间","状态"};
		//创建Excel工作薄
		HSSFWorkbook  workbook=new HSSFWorkbook();
		//创建一个工作表
		HSSFSheet sheet=workbook.createSheet();
		//创建第一行
		HSSFRow row=sheet.createRow(0);
		HSSFCell cell=null;
		//插入第一行数据id,name,sex
		for (int i = 0; i < title.length; i++) {
			cell=row.createCell(i);
			cell.setCellValue(title[i]);
		}
		//追加数据
		for (int i = 1; i <=dyList.size(); i++) {
			HSSFRow nextrow=sheet.createRow(i);
			HSSFCell cell2=nextrow.createCell(0);
			
			if(dyList.get(i-1).getUserName()==null) {
				cell2.setCellValue("");
			}else {
				cell2.setCellValue(dyList.get(i-1).getUserName());
			}
			
			cell2=nextrow.createCell(1);
			if(dyList.get(i-1).getDepartment()==null) {
				cell2.setCellValue("");
			}else {
				cell2.setCellValue(dyList.get(i-1).getDepartment());
			}
			
			cell2=nextrow.createCell(2);
			if(dyList.get(i-1).getAddress()==null) {
				cell2.setCellValue("");
			}else {
				cell2.setCellValue(dyList.get(i-1).getAddress());
			}
		
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
			cell2=nextrow.createCell(3);
			if(dyList.get(i-1).getCreateTime()==null) {
				cell2.setCellValue("");
			}else {
				cell2.setCellValue(sdf.format(dyList.get(i-1).getCreateTime()));
			}
			
			cell2=nextrow.createCell(4);
			if(dyList.get(i-1).getStatus()==null) {
				cell2.setCellValue("");
			}else {
				cell2.setCellValue(dyList.get(i-1).getStatus());
			}
		
		}
		
		//创建一个文件
		
		try {
		/*File file=new File("d:/department.xls");
		//			System.out.println("--+++_______IIIIIOOOOOOOOOOOOOOOOOOOOOOOOOOOO"+InetAddress.getLocalHost().getHostAddress());
					file.createNewFile();
					//将Excell内容存盘
					FileOutputStream stream=FileUtils.openOutputStream(file);
					String path="d:/department.xls";
					 String fileName = path.substring(path.lastIndexOf("/")+1);
		            response.reset();  
		            response.setContentType("application/json");
		            response.setHeader("Content-disposition", "attachment; filename="+fileName);  
		            workbook.write(stream);*/
			
				/*	String path="d:/department.xls";
					 String fileName = path.substring(path.lastIndexOf("/")+1);
						response.setContentType("application/json;charset=utf-8");
						response.setHeader("Content-Disposition", "attachment;filename="
						+ URLEncoder.encode(fileName, "UTF-8"));
						OutputStream out = response.getOutputStream();
						InputStream fis = new BufferedInputStream(new FileInputStream("d://"+fileName));
						byte[] buffer = new byte[fis.available()];
						fis.read(buffer);
						fis.close();
						out.write(buffer);
						out.flush();
						out.close();	*/
			
						File file=new File("d:/department.xls");
			//			System.out.println("--+++_______IIIIIOOOOOOOOOOOOOOOOOOOOOOOOOOOO"+InetAddress.getLocalHost().getHostAddress());
						file.createNewFile();
						//将Excell内容存盘
						FileOutputStream stream=FileUtils.openOutputStream(file);	
						workbook.write(stream);
						stream.close();
						
						
						 OutputStream out = response.getOutputStream();    
					            String fileName = "enroll.xls";// 文件名    
					            response.setContentType("application/x-msdownload");    
					            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));    
					            workbook.write(out);    					
						
/*		String filePath="d:/department.xls";
      	   if (file.exists()) {
			FileInputStream inputStream = new FileInputStream(filePath);  
			int i = inputStream.available();  
			//byte数组用于存放图片字节数据  
			byte[] buff = new byte[i];  
			inputStream.read(buff);  
			//记得关闭输入流  
			inputStream.close();  
			//设置发送到客户端的响应内容类型  
			response.setContentType("application/json;charset=utf-8");  
			OutputStream out = response.getOutputStream();  
			out.write(buff);  
			//关闭响应输出流  
			out.close();		
      	   }*/
				} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}
		
		logger.info("离开导出根据时间查询的订单的Excel的方法poiExpExcel");

			return R.ok();
		
		}
	
	
	
	
	
	
	
	
	
	
	/**
	 * 客户端获取部门主管提交状态
	 */
	@ResponseBody
	@RequestMapping(value="/submitState", method=RequestMethod.POST)
	public R  submitState(Long[] ids) {
		logger.info("进入客户端获取部门主管提交状态的方法submitState");
		try {
			dinnerOrdersService.updateState(ids);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("提交失败"+e.getMessage());
			return R.ok("提交失败!");
		}
		logger.info("离开客户端获取部门主管提交状态的方法submitState");

			return R.ok("提交成功!");
	}
	
	

	
	
	
	
}

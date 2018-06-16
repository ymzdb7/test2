package com.winhands.modules.restaurant.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.winhands.common.annotation.SysLog;
import com.winhands.common.utils.Constant;
import com.winhands.common.utils.DateUtil;
import com.winhands.common.utils.PageUtils;
import com.winhands.common.utils.Query;
import com.winhands.common.utils.R;
import com.winhands.common.utils.StringUtil;
import com.winhands.common.validator.ValidatorUtils;
import com.winhands.common.validator.group.AddGroup;
import com.winhands.modules.restaurant.entity.DishesEntity;
import com.winhands.modules.restaurant.service.CarteBankDishesService;
import com.winhands.modules.restaurant.service.CarteTypeDishesService;
import com.winhands.modules.restaurant.service.DishesService;
import com.winhands.modules.sys.controller.AbstractController;

/**
 * 菜品管理
 * 
 */
@RestController
@RequestMapping("/restaurant/dishes")
public class DishesController extends AbstractController {
	//日志
	private Logger logger = Logger.getLogger(this.getClass());

	
	@Autowired
	private DishesService dishesService;
	@Autowired
	private CarteTypeDishesService carteTypeDishesService;
	@Autowired
	private CarteBankDishesService carteBankDishesService;
	/**
	 * 所有菜品列表
	 */
	@RequestMapping("/list")
	/*@RequiresPermissions("restaurant:dishes:list")*/
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据

		if(null==getUser().getAddress()||getUser().getAddress().equals("")) {
		}else {
			params.put("address", getUser().getAddress());
		}
		Query query = new Query(params);
		List<DishesEntity> dishList = dishesService.queryList(query);
		int total = dishesService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(dishList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	/**
	 * 保存菜品
	 */
	@SysLog("保存菜品")
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public R save(DishesEntity dishes, @RequestParam("pic") MultipartFile pic,HttpServletRequest request){
		ValidatorUtils.validateEntity(dishes, AddGroup.class);
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("dishess", dishes.getDishes());
		map.put("typeName", dishes.getTypeName());
	List<DishesEntity> dishList	=dishesService.queryList(map);
	if(dishList!=null&&dishList.size()!=0) {
		return R.ok("该菜品已存在!");
	}else {
		
		String filePath = "";
		String uuid = StringUtil.getUUIDString();
		String type = "";
		File file = null;
		String result = "";
		String htmlPath = Constant.HTMLUploadPath+ DateUtil.getCurrentMonth() + "/dishes/";
		dishes.setCreateUserId(getUserId());
		dishes.setAddress(StringUtil.isNull(getUser().getAddress())?"":getUser().getAddress());
		dishes.setDetailHtml(Constant.HTMLUploadPath+ DateUtil.getCurrentMonth() + "/dishes/");
		String fileName = pic.getOriginalFilename();
		if (pic!= null &&!StringUtil.isNull(fileName)) { 
			filePath = Constant.IMAGEUPLOADPATH+ DateUtil.getCurrentMonth() + "/dishesPic/";//菜品图片
			type = pic.getOriginalFilename().substring(fileName.indexOf(".") + 1, fileName.length()); 
			fileName = uuid+"." +type;
			dishes.setDishesPicName(pic.getOriginalFilename());
			dishes.setDishesPicPath(Constant.IMAGEUPLOADPATH+ DateUtil.getCurrentMonth() + "/dishesPic/"+fileName);
		    result = copyFile(request, filePath, fileName, pic);
      	} 
		if(!StringUtil.isNull(getUser().getAddress())) {
			dishes.setAddress(getUser().getAddress());
		}
		dishesService.save(dishes);
		saveAsHtmlAndTxt(request, dishes.getId(), htmlPath, dishes);
		
		
		
		return R.ok("操作成功！");
	}
	}
	
	/**
	 * 修改菜品
	 */
	@SysLog("修改菜品")
	@RequestMapping(value="/update" , method=RequestMethod.POST)
	public R update( DishesEntity dishes, @RequestParam("pic") MultipartFile pic,HttpServletRequest request){
		ValidatorUtils.validateEntity(dishes, AddGroup.class);
		//判断是否有新图片
		String fileName = pic.getOriginalFilename();
		String filePath = "";
		String uuid = StringUtil.getUUIDString();
		String type = "";
		File file = null;
		String result = "";
		//
		DishesEntity dishTemp = dishesService.queryObject(dishes.getId());
		if (pic!= null &&!StringUtil.isNull(fileName)) { 
			//先删除原照片文件
			if(dishTemp.getDishesPicPath()!=null) {
			File f = new File(dishTemp.getDishesPicPath());
			if(f.exists())  f.delete();
			}
			//保存新图片
			filePath = Constant.IMAGEUPLOADPATH+ DateUtil.getCurrentMonth() + "/dishesPic/";//菜品图片
			type = pic.getOriginalFilename().substring(fileName.indexOf(".") + 1, fileName.length()); 
			fileName = uuid+"." +type;
			dishes.setDishesPicName(pic.getOriginalFilename());
			dishes.setDishesPicPath(Constant.IMAGEUPLOADPATH+ DateUtil.getCurrentMonth() + "/dishesPic/"+fileName);
		    result = copyFile(request, filePath, fileName, pic);
      	}else {
      		
      	}
		dishes.setCreateUserId(getUserId());
		
		//删除原先html文件
		File f = new File(dishTemp.getDetailHtml()+dishes.getId()+".html");
		if(f.exists()) f.delete();
		dishesService.update(dishes);
		saveAsHtmlAndTxt(request, dishes.getId(), dishTemp.getDetailHtml(), dishes);
		
		return R.ok("操作成功！");
	}
	
	/**
	 * 菜单信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Long id){
		DishesEntity dishes = dishesService.queryObject(id);
		return R.ok().put("dishes", dishes);
	}
	/**
	 * 删除菜品
	 */
	@SysLog("删除菜品")
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] ids){
		dishesService.deleteBatch(ids);
		carteBankDishesService.deleteBatchDishesId(ids);
		carteTypeDishesService.deleteBatchDishesId(ids);
		
		return R.ok();
	}
	
	private String saveAsHtmlAndTxt(HttpServletRequest request, long news_id,
			String htmlPath, DishesEntity dishes) {
		String path = request.getContextPath();
		String jsPath = request.getServerName();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
				+ "/";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		File dirFile = new File(htmlPath);
		if (!dirFile.isDirectory()) {// 目录月份目录不存在
			dirFile.mkdirs();// 创建目录
		}

		// 生成静态网页 区分两种，第一种html展示
		StringBuffer newContentStr = new StringBuffer();
		newContentStr
				.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">")
				.append("<html xmlns=\"http://www.w3.org/1999/xhtml\">").append("<head>")
				.append("<meta http-equiv=Content-Type content=\'text/html;charset=utf-8;\'/>")
				.append("<meta id='viewport' name='viewport' content='width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1;\'/>")
				.append("<script src='" + basePath + "js/jquery-1.10.2.min.js'></script>").append("<title>")
				.append(dishes.getDishes()).append("</title>").append("</head>").append("<style>")
				.append("img{width='100%';height=''}").append("</style>")
				.append("<body  style='padding-left:10px;padding-right:10px;>'");
		// 拼接正文
		newContentStr.append("<div id='content'>");
		newContentStr.append(dishes.getDishesDetail()).append("</div>");
		// $('video').click(function(){
		newContentStr.append("<div class=\"clear\"></div>").append("</body>").append("<script type='text/javascript'>")
				.append("window.onload=function(){ ")
				.append("var imgs=document.getElementsByTagName('img');").append("for(var i=0;i<imgs.length;i++){")
				.append("var imgTh=imgs[i];").append("imgTh.style.width='100%';").append("imgTh.style.height='100%';")
				.append("} ").append("} ")

				.append("</script>").append("</html>");
		byte[] buff = new byte[] {};
		String htmlName = news_id + ".html";
		FileOutputStream outputStream = null;
		try {
			buff = newContentStr.toString().getBytes("UTF-8");
			outputStream = new FileOutputStream(htmlPath + "/" + htmlName);
			outputStream.write(buff, 0, buff.length);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "error";
		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					System.out.println("outputStream关闭失败");
					e.printStackTrace();
				}
			}
		}
		return "success";
	}
	
	
	private String copyFile(HttpServletRequest request, String realpath, String saveName, MultipartFile file) {
		// 数据流方式上传文件
		FileOutputStream fos = null;
		FileInputStream fis = null;
		try {
			logger.debug("上传路径.."+realpath);
			File dirFile = new File(realpath);
			if (!dirFile.isDirectory()) {// 目录月份目录不存在
				dirFile.mkdirs();// 创建目录
			}
			// 建立文件输出流 
			fos = new FileOutputStream(realpath + "/" + saveName);
			// 建立文件上传流
			try {
				fis =(FileInputStream) file.getInputStream();
			} catch (Exception e) {
				e.printStackTrace();
			}
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
		} catch (Exception e) {
			logger.error("文件上传失败");
			e.printStackTrace();
			return "error";
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					logger.error("FileInputStream关闭失败");
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					logger.error("FileOutputStream关闭失败");
					e.printStackTrace();
				}
			}
		}
		return "success";
	}
	
}

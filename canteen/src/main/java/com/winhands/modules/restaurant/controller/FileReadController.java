package com.winhands.modules.restaurant.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.winhands.modules.sys.controller.AbstractController;

/**
 * 上传方法
 * 
 */
@RestController
@RequestMapping("/file/read")
public class FileReadController extends AbstractController {
	@RequestMapping("/readImg")
	public void readImg(@RequestParam("filePath") String filePath,HttpServletRequest request, HttpServletResponse response) {  
		 //读取本地图片输入流  
	        try {
	        	 File file = new File(filePath);
	        	   if (file.exists()) {
				FileInputStream inputStream = new FileInputStream(filePath);  
				int i = inputStream.available();  
				//byte数组用于存放图片字节数据  
				byte[] buff = new byte[i];  
				inputStream.read(buff);  
				//记得关闭输入流  
				inputStream.close();  
				//设置发送到客户端的响应内容类型  
				response.setContentType("image/*");  
				OutputStream out = response.getOutputStream();  
				out.write(buff);  
				//关闭响应输出流  
				out.close();
	        	   }
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}  
	    }  
	@RequestMapping("/readHtml")
	public void readHtml(@RequestParam("filePath") String filePath,
			@RequestParam("fileName") String fileName,
			HttpServletRequest request, HttpServletResponse response) {  
		response.setContentType("multipart/form-data");  
        response.setCharacterEncoding("UTF-8");  
        response.setContentType("text/html");  
        // 2.设置文件头：最后一个参数是设置下载文件名  
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);  
        ServletOutputStream out;  
        // 通过文件路径获得File对象  
        filePath = filePath.replace("\\", "/");  
        File html_file = new File(filePath);  
        try {
			FileInputStream inputStream = new FileInputStream(html_file);  

			// 3.通过response获取ServletOutputStream对象(out)  
			out = response.getOutputStream();  

			int b = 0;  
			byte[] buffer = new byte[1024];  
			while ((b = inputStream.read(buffer)) != -1) {  
			    // 4.写到输出流(out)中  
			    out.write(buffer, 0, b);  
			}  
			inputStream.close();  
			out.flush();  
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  

	    }  
	
}

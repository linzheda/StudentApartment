package com.zd.util;

import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.servlet.jsp.PageContext;
import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;

public class FileUploadUtil {
	public static String PATH="image/photo";  //保存上传图片的文件夹
	private static final String ALLOWED="gif,jpg,png,jpeg,txt,xls";  //可以上传的文件类型
	private static final String DENIED="exe,bat,jsp,html,htm";  //不可以上传的文件类型
	private static final int MAXFILESIZE=10*1024*1024;  //单个文件最大为100M
	private static final int TOTALMAXFILESIZE=100*1024*1024; //一次性总共能上传的文件大小 10M
	
	
	public Map<String ,String> fileUpload(PageContext pageContext){
		Map<String,String> map=new HashMap<String,String>();
		//新建一个SmartUpload对象
		SmartUpload su=new SmartUpload();
		
		
		try {
			//初始化su对象
			su.initialize(pageContext);
			//文件上限制
			//限制文件的大小
			su.setMaxFileSize(MAXFILESIZE);
			
			//限制文件总长度
			su.setTotalMaxFileSize(TOTALMAXFILESIZE);
			//设置允许上传的文件类型（通过拓展名）
			su.setAllowedFilesList(ALLOWED);
			//设置禁止上传的文件类型
			su.setDeniedFilesList(DENIED);
			//设置编码
			su.setCharset("UTF-8");
			//上传文件
			su.upload();
			//将上传文件保存到定制目录
			Request request=su.getRequest();
			
			Enumeration<String> names=request.getParameterNames();
			
			//根据元素名取出表单数据
			String key;
			
			
			while(names.hasMoreElements()){
				key=names.nextElement();
				map.put(key, request.getParameter(key));
			}
			//处理上传的图片
			Files files=su.getFiles();
			
			String fieldName="photo";//上传文件的那个文本框的name属性的属性值
			
			//说明用户有文件要上传
			if(files!=null&&files.getCount()>0){
																//获取真实路径
				String filePath=pageContext.getServletContext().getRealPath("/")+PATH;
				
				java.io.File f=new java.io.File(filePath);
				if(!f.exists()){
					f.mkdirs();
				}
				
				Collection<File> collection=files.getCollection();
				String fileName="";
				String picPath="";
				
				for(File fl:collection){//注意：此时也是smartupload中的file
					if(!fl.isMissing()){
						//将上传文件重命名
						//fileName=new Date().getTime()+""+new Random().nextInt(9999)+"."+fl.getFileExt();
						fileName=fl.getFilePathName();
						//用户上传文件保存到服务器
						fl.saveAs(filePath+"/"+fileName);
						//将保存到服务器的文件的相对于项目的路径保存到数据库
						picPath+=PATH+"/"+fileName+",";
					}
					fieldName=fl.getFieldName();
				}
				if(picPath.contains(",")){//说明有文件上传
					picPath=picPath.substring(0,picPath.lastIndexOf(","));
				}
				map.put(fieldName, picPath);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return map;
	}

}

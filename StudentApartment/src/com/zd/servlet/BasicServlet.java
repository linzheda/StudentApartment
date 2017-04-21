package com.zd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class BasicServlet
 * @param <T>
 */

public abstract class BasicServlet<T> extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected String op;
	
	protected void outJson(Object obj,HttpServletResponse response) throws IOException{

		Gson gson=new Gson();
		String jsonString=gson.toJson(obj);
		//response.setContentType("text/json;charset=utf-8");
		response.setContentType("application/json");
		PrintWriter out=response.getWriter();
		out.println(jsonString);
		out.close();

	}
	

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		arg0.setCharacterEncoding("utf-8");
		op=arg0.getParameter("op");
		super.service(arg0, arg1);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected  T parseRequest(HttpServletRequest request,Class<T> c){
		T t=null;

		Map<String, String[]> map= request.getParameterMap();
		Set<String> methodNames =getMethodName(map.keySet());

		Method[] ms=c.getMethods();

		try {
			t = (T) c.newInstance(); //创建反射类的实例化对象Product 
			//循环所有的方法，查到 与methodNames 中的相同的方法
			for ( Method method: ms ){
				for( String mn : methodNames ){	  //setResadmin 
					if( method.getName().equals(mn)){
						//激活这个method   用invoke 
						String keyname = mn.substring(3,4).toLowerCase()+mn.substring(4);

						String typeName = method.getParameterTypes()[0].getName();
						String[] value=map.get(keyname);

						if( "java.lang.Integer".equals(typeName)  ||  "int".equals(typeName) ){
							method.invoke(t , Integer.parseInt(value[0] ));
						}else if( "java.lang.Double".equals(typeName)  ||  "double".equals(typeName) ){
							method.invoke(t , Double.parseDouble(value[0] ));
						}else if( "java.lang.Float".equals(typeName)  ||  "float".equals(typeName) ){
							method.invoke(t , Float.parseFloat(value[0] ));
						}else if( "java.lang.Long".equals(typeName)  ||  "long".equals(typeName) ){
							method.invoke(t , Long.parseLong(value[0]));
						}else {
							method.invoke(t , value[0].toString() );
						}
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 

		return t;

	}

	private Set<String> getMethodName(Set<String> keys) {
		Set<String> result = new HashSet<String>();
		for( String key:keys ){
			String newName = key.substring(0,1).toUpperCase()+key.substring(1);
			result.add("set" + newName );
		}
		return result ;
	}
	protected void out(HttpServletResponse response,String status){
		PrintWriter out=null;
		try {
			out=response.getWriter();
			out.print(status);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}
	
	/**
	 * 返回单个对象
	 * @param response
	 * @param obj
	 */
	protected void out(HttpServletResponse response,Object obj){
		PrintWriter out=null;
		try {
			Gson gson=new Gson();
			out=response.getWriter();
			out.print(gson.toJson(obj));
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}
	/**
	 * 返回一个集合对象
	 * @param <T>
	 * @param response
	 * @param objs
	 */
	protected <T> void out(HttpServletResponse response,List<T> objs){
		response.setContentType("application/json");
		PrintWriter out=null;
		try {
			Gson gson=new Gson();
			out=response.getWriter();
			out.print(gson.toJson(objs));
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}
	/**
	 * 返回多个集合对象
	 * @param <T>
	 * @param <T>
	 * @param response
	 * @param map
	 */
	protected <T> void out(HttpServletResponse response,Map<String,List<T> >map){
		response.setContentType("application/json");
		PrintWriter out=null;
		try {
			Gson gson=new Gson();
			out=response.getWriter();
			out.print(gson.toJson(map));
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}
	
	/**
	 * 针对easyui中的分页请求
	 * @param response
	 * @param map
	 */
	protected void outPage(HttpServletResponse response,Map<String,Object >map){
		response.setContentType("application/json");
		PrintWriter out=null;
		try {
			Gson gson=new Gson();
			out=response.getWriter();
			out.print(gson.toJson(map));
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}

}

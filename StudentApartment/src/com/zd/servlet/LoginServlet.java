package com.zd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zd.bean.Admin;
import com.zd.bean.Student;
import com.zd.bean.SuperAdmin;
import com.zd.biz.AdminBiz;
import com.zd.biz.StudentBiz;
import com.zd.biz.SuperAdminBiz;
import com.zd.biz.impl.AdminBizImpl;
import com.zd.biz.impl.StudentBizImpl;
import com.zd.biz.impl.SuperAdminBizImpl;

public class LoginServlet extends BasicServlet{
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if("login".equals(op)){
			try {
				LoginOp(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}

	private void LoginOp(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, NumberFormatException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String rlue=request.getParameter("rlue");
		String valcode=request.getParameter("valcode"); 
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		
		
		HttpSession session=request.getSession();
		String validateCode=(String) session.getAttribute("validateCode");
		PrintWriter out=response.getWriter();
		if(!validateCode.equalsIgnoreCase(valcode)){//验证码
			out.print("<script>alert('validateCode is not right');window.location.href='login.jsp'</script>");
			return;
		}
		if(uname==null||"".equals(uname)){
			out.print("<script>alert('uname is empty');window.location.href='login.jsp'</script>");
			return;
		}
		if(pwd==null||"".equals(pwd)){
			out.print("<script>alert('password is empty');window.location.href='login.jsp'</script>");
			return;
		}
		
		if("student".equals(rlue)){//如果是学生
			StudentBiz sb=new StudentBizImpl();
			List<Student> list=sb.login(Integer.parseInt(uname), pwd);
			if(list.size()==1){
				session.setAttribute("uname", uname);
				response.sendRedirect("student/student.jsp");
			}
		}
		if("admind".equals(rlue)){//如果是管理员
			AdminBiz ab=new AdminBizImpl();
			List<Admin> list=ab.login(uname, pwd);
			if(list.size()==1){
				session.setAttribute("isSuper","no");
				session.setAttribute("aid",uname);
				response.sendRedirect("back/admin.jsp");
			}
		}
		if("superadmind".equals(rlue)){//如果是超级管理员
			SuperAdminBiz sab=new SuperAdminBizImpl();
			List<SuperAdmin> list=sab.login(uname, pwd);
			if(list.size()==1){
				session.setAttribute("isSuper","yes");
				response.sendRedirect("back/admin.jsp");
			}
		}
		
		
		
		
		
	}
	

}

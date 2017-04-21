package com.zd.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zd.bean.Admin;
import com.zd.bean.Student;
import com.zd.biz.AdminBiz;
import com.zd.biz.ApartmentBiz;
import com.zd.biz.BedroomBiz;
import com.zd.biz.StudentBiz;
import com.zd.biz.impl.AdminBizImpl;
import com.zd.biz.impl.ApartmentBizImpl;
import com.zd.biz.impl.BedroomBizImpl;
import com.zd.biz.impl.StudentBizImpl;
import com.zd.util.MailUtil;
import com.zd.web.model.JsonModel;

public class StudentServlet extends BasicServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if("stuInfo".equals(op)){//学生信息的显示
			try {
				stuInfoOP(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("updatePwd".equals(op)){//修改密码
			try {
				updatePwdOP(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("finMoney".equals(op)){//查询财产金额
			try {
				finMoneyOP(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("stuLeave".equals(op)){//离校办理
			try {
				stuLeaveOP(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("publicReport".equals(op)){//公共设施报修
			try {
				publicReportOP(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("bedroomReport".equals(op)){
			try {
				bedroomReportOP(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("findAdmin".equals(op)){
			try {
				findAdminOP(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("sendMail".equals(op)){
			try {
				sendMailOP(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("finStuPs".equals(op)){
			try {
				finStuPsOP(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("updateStuPs".equals(op)){
			try {
				updateStuPsOP(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	
	
	}
	private void updateStuPsOP(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		String uname=(String) session.getAttribute("uname");
		String content=request.getParameter("content");
		StudentBiz sb=new StudentBizImpl();
		int result=sb.updatePs(uname,content);
		JsonModel jm=new JsonModel();
		if(result>0){
			jm.setCode(1);
		}else{
			jm.setCode(0);
			jm.setErrorMsg("身份过期,请重新登录");
		}
		super.outJson(jm, response);
		
		
	}
	private void finStuPsOP(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		String uname=(String) session.getAttribute("uname");
		StudentBiz sb=new StudentBizImpl();
		String obj =sb.findPs(uname);
		JsonModel jm=new JsonModel();
		jm.setCode(1);
		jm.setObj(obj);
		super.outJson(jm, response);
	}
	private void sendMailOP(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String mail=request.getParameter("mail");
		String mainTitle=request.getParameter("mainTilte");
		String content=request.getParameter("content");
		MailUtil mu=new MailUtil();
		int result=mu.sendMail(mail, mainTitle, content);
		JsonModel jm=new JsonModel();
		if(result>0){
			jm.setCode(1);
		}else{
			jm.setCode(0);
			jm.setErrorMsg("出错了");
		}
		super.outJson(jm, response);
		
	}
	private void findAdminOP(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AdminBiz ab=new AdminBizImpl();
		List<Admin> list=ab.findAdmin();
		JsonModel jm=new JsonModel();
		if(list.size()>0){
			jm.setCode(1);
			jm.setObj(list);
		}else{
			jm.setCode(0);
			jm.setErrorMsg("身份过期,请重新登录");
		}
		super.outJson(jm, response);
	}
	private void bedroomReportOP(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		String uname=(String) session.getAttribute("uname");
		String content=request.getParameter("content")+"申请报修";
		StudentBiz sb=new StudentBizImpl();
		List<Student> list =sb.finInfo(uname);
		int bid=list.get(0).getBid();
		BedroomBiz bb=new BedroomBizImpl();
		int result=bb.updatePs(bid, content);
		JsonModel jm=new JsonModel();
		if(result>0){
			jm.setCode(1);
		}else{
			jm.setCode(0);
			jm.setErrorMsg("身份过期,请重新登录");
		}
		super.outJson(jm, response);
	}
	private void publicReportOP(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		String uname=(String) session.getAttribute("uname");
		String content=request.getParameter("content")+"申请报修";
		StudentBiz sb=new StudentBizImpl();
		String apid=sb.finApid(uname);
		ApartmentBiz ab=new ApartmentBizImpl();
		int result=ab.publicReport(apid, content);
		JsonModel jm=new JsonModel();
		if(result>0){
			jm.setCode(1);
		}else{
			jm.setCode(0);
			jm.setErrorMsg("身份过期,请重新登录");
		}
		super.outJson(jm, response);
		
		
		
	}
	private void stuLeaveOP(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		String uname=(String) session.getAttribute("uname");
		StudentBiz sb=new StudentBizImpl();
		int result=sb.leave(uname);
		JsonModel jm=new JsonModel();
		if(result>0){
			jm.setCode(1);
		}else{
			jm.setCode(0);
			jm.setErrorMsg("身份过期,请重新登录");
		}
		super.outJson(jm, response);
		
		
	}
	private void finMoneyOP(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		String uname=(String) session.getAttribute("uname");
		
		StudentBiz sb=new StudentBizImpl();
		List<Student> list =sb.finMoney(uname);
		JsonModel jm=new JsonModel();
		if(list.size()>0){
			jm.setCode(1);
			Student s=new Student();
			s=list.get(0);
			jm.setObj(s.getMoney());
		}else{
			jm.setCode(0);
			jm.setErrorMsg("身份过期,请重新登录");
		}
		super.outJson(jm, response);
		
	}
	private void updatePwdOP(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		String uname=(String) session.getAttribute("uname");
		String pwd=request.getParameter("pwd");
		StudentBiz sb=new StudentBizImpl();
		int result=sb.udaptePwd(uname,pwd);
		JsonModel jm=new JsonModel();
		if(result>0){
			jm.setCode(1);
		}else{
			jm.setCode(0);
			jm.setErrorMsg("身份过期,请重新登录");
		}
		super.outJson(jm, response);
		
		
	}
	private void stuInfoOP(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		HttpSession session=request.getSession();
		String uname=(String) session.getAttribute("uname");
		StudentBiz sb=new StudentBizImpl();
		List<Student> list =sb.finInfo(uname);
		JsonModel jm=new JsonModel();
		if(list.size()>0){
			jm.setCode(1);
			Student s=new Student();
			s=list.get(0);
			jm.setObj(s);
		}else{
			jm.setCode(0);
			jm.setErrorMsg("身份过期,请重新登录");
		}
		super.outJson(jm, response);
		
	}
	
}

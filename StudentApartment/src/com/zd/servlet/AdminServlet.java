package com.zd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.zd.bean.Apartment;
import com.zd.bean.Bedroom;
import com.zd.bean.Student;
import com.zd.bean.Visitor;
import com.zd.biz.AdminBiz;
import com.zd.biz.ApartmentBiz;
import com.zd.biz.BedroomBiz;
import com.zd.biz.StudentBiz;
import com.zd.biz.VisitorBiz;
import com.zd.biz.impl.AdminBizImpl;
import com.zd.biz.impl.ApartmentBizImpl;
import com.zd.biz.impl.BedroomBizImpl;
import com.zd.biz.impl.StudentBizImpl;
import com.zd.biz.impl.VisitorBizImpl;
import com.zd.util.FileUploadUtil;
import com.zd.web.model.JsonModel;

public class AdminServlet extends BasicServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if("registerStu".equals(op)){//注册
				registerStuOP(request,response);
			}else if("findStuInfosss".equals(op)){//管理学员那里的信息显示
				findStuInfoOP(request,response);
			}else if("findInfo".equals(op)){//点击修改时的信息显示
				findInfoOP(request,response);
			}else if("update_Stuinfo".equals(op)){//修改学员信息
				update_StuinfoOP(request,response);
			}else if("findAparment".equals(op)){//查看公寓管理信息
				findAparmentOP(request,response);
			}else if("updateApartmentDetail".equals(op)){//修改公寓状态
				updateApartmentDetailOP(request,response);
			}else if("findBedroom".equals(op)){//查找公寓信息
				findBedroom(request,response);
			}else if("updateBedroomBps".equals(op)){
				updateBedroomBps(request,response);
			}else if("visitorRegister".equals(op)){//来访登记
				visitorRegister(request,response);
			}else if("findVisitorInfo".equals(op)){//来访管理
				findVisitorInfoOP(request,response);
			}else if("updateVisitor".equals(op)){//离开操作
				updateVisitorOP(request,response);
			}else if("makeReport".equals(op)){//生成报表
				makeReport(request,response);
			}else if("message_find".equals(op)){//留言查看
				messageFind(request,response);
			}else if("answerMessage".equals(op)){//回复留言
				answerMessage(request,response);
			}else if("findBedroomName".equals(op)){
				findBedroomName(request,response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}


	}
	private void findBedroomName(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BedroomBiz bb=new BedroomBizImpl();
		List<Map<String, Object>> list= bb.finBedroom();
		JsonModel jm=new JsonModel();
		if(list.size()!=0){
			jm.setCode(1);
			jm.setObj(list);
		}else{
			jm.setCode(0);
		}
		super.outJson(jm, response);
		
	}
	private void answerMessage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String sid=request.getParameter("sid");
		String content=request.getParameter("content");
		content="回复:"+content;
		StudentBiz sb=new StudentBizImpl();
		int result=sb.updatePs(sid, content);
		JsonModel jm=new JsonModel();
		if(result!=0){
			jm.setCode(1);
		}else{
			jm.setCode(0);
			jm.setErrorMsg("身份过期,请重新登录");
		}
		super.outJson(jm, response);
		
		
	}
	private void messageFind(HttpServletRequest request, HttpServletResponse response) {
		Integer page=Integer.parseInt(request.getParameter("page"));
		Integer rows=Integer.parseInt(request.getParameter("rows"));
		HttpSession session=request.getSession();
		String isSuper=(String) session.getAttribute("isSuper");
		StudentBiz sb=new StudentBizImpl();
		if(isSuper.equals("no")){
			String uname=(String) session.getAttribute("aid");
			try {
				List<Student> list=sb.adminfinInfo(uname,page-1,rows);
				Map<String , Object> map=new HashMap<String,Object>();
				map.put("total",sb.getTotal(uname));
				map.put("rows",list);
				this.outJson(map, response);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		}else if(isSuper.equals("yes")){
			try {
				List<Student> list=sb.superAdminfinInfo(page-1,rows);
				Map<String , Object> map=new HashMap<String,Object>();
				map.put("total",sb.getTotal());
				map.put("rows",list);
				this.outJson(map, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else {
			this.out(response, "出错了....");
		}
		
	}
	private void makeReport(HttpServletRequest request, HttpServletResponse response) {
		String dateStart=request.getParameter("dateStart");
		String dateEnd=request.getParameter("dateEnd");
		VisitorBiz bb=new VisitorBizImpl();
		List<Map<String, Object>> list=bb.makeReport(dateStart, dateEnd);
		this.out(response, list);
		
	}
	private void updateVisitorOP(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String vid=request.getParameter("vid");
		VisitorBiz bb=new VisitorBizImpl();
		int result=bb.updateLave(vid);
		JsonModel jm=new JsonModel();
		if(result!=0){
			jm.setCode(1);
		}else{
			jm.setCode(0);
			jm.setErrorMsg("身份过期,请重新登录");
		}
		super.outJson(jm, response);
		
		
	}
	private void findVisitorInfoOP(HttpServletRequest request, HttpServletResponse response) {
		Integer page=Integer.parseInt(request.getParameter("page"));
		Integer rows=Integer.parseInt(request.getParameter("rows"));
		HttpSession session=request.getSession();
		String isSuper=(String) session.getAttribute("isSuper");
		VisitorBiz vb=new VisitorBizImpl();
		if(isSuper.equals("no")){
			String uname=(String) session.getAttribute("aid");
			try {
				List<Visitor> list=vb.finVisitor(uname,page-1,rows);
				Map<String , Object> map=new HashMap<String,Object>();
				map.put("total",vb.getTotal(uname));
				map.put("rows",list);
				this.outJson(map, response);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		}else if(isSuper.equals("yes")){
			try {
				List<Visitor> list=vb.superAdminfinVisitorInfo(page-1,rows);
				Map<String , Object> map=new HashMap<String,Object>();
				map.put("total",vb.getTotal());
				map.put("rows",list);
				this.outJson(map, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else {
			this.out(response, "出错了....");
		}
		
		
		
	}
	private void visitorRegister(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String vname=request.getParameter("vname");
		String vsex=request.getParameter("vsex");
		String vtel=request.getParameter("vtel");
		String clause=request.getParameter("clause");
		String ps=request.getParameter("ps");
		String bid=request.getParameter("bid");
		VisitorBiz vb=new VisitorBizImpl();
		int result=vb.register(vname,vsex,vtel,clause,ps,bid);
		PrintWriter out=response.getWriter();
		if(result!=0){
			out.print("<script>alert('success...');window.location.href='back/admin.jsp'</script>");
			return;
		}else{
			out.print("<script>alert('fail...');window.location.href='back/admin.jsp'</script>");
			return;
		
		}
	}
	private void updateBedroomBps(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String bid=request.getParameter("bid");
		BedroomBiz bb=new BedroomBizImpl();
		int result=bb.updateBps(bid);
		JsonModel jm=new JsonModel();
		if(result!=0){
			jm.setCode(1);
		}else{
			jm.setCode(0);
			jm.setErrorMsg("身份过期,请重新登录");
		}
		super.outJson(jm, response);
		
		
	}
	private void findBedroom(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Integer page=Integer.parseInt(request.getParameter("page"));
		Integer rows=Integer.parseInt(request.getParameter("rows"));
		HttpSession session=request.getSession();
		String isSuper=(String) session.getAttribute("isSuper");
		BedroomBiz bb=new BedroomBizImpl();
		if(isSuper.equals("no")){
			String uname=(String) session.getAttribute("aid");
			try {
				List<Bedroom> list=bb.finBedroom(uname,page-1,rows);
				Map<String , Object> map=new HashMap<String,Object>();
				map.put("total",bb.getTotal(uname));
				map.put("rows",list);
				this.outJson(map, response);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		}else if(isSuper.equals("yes")){
			try {
				List<Bedroom> list=bb.superAdminfinBedroomInfo(page-1,rows);
				Map<String , Object> map=new HashMap<String,Object>();
				map.put("total",bb.getTotal());
				map.put("rows",list);
				this.outJson(map, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else {
			this.out(response, "出错了....");
		}
		
		
	}
	private void updateApartmentDetailOP(HttpServletRequest request, HttpServletResponse response)  throws Exception{
		String apid=request.getParameter("apid");
		ApartmentBiz ab=new ApartmentBizImpl();
		int result=ab.updateDetial(apid);
		JsonModel jm=new JsonModel();
		if(result!=0){
			jm.setCode(1);
		}else{
			jm.setCode(0);
			jm.setErrorMsg("身份过期,请重新登录");
		}
		super.outJson(jm, response);
		
		
	}
	private void findAparmentOP(HttpServletRequest request, HttpServletResponse response)  throws Exception{
		Integer page=Integer.parseInt(request.getParameter("page"));
		Integer rows=Integer.parseInt(request.getParameter("rows"));
		HttpSession session=request.getSession();
		String isSuper=(String) session.getAttribute("isSuper");
		ApartmentBiz ab=new ApartmentBizImpl();
		if(isSuper.equals("no")){
			String uname=(String) session.getAttribute("aid");
			try {
				List<Apartment> list=ab.adminfinApartmentInfo(uname,page-1,rows);
				Map<String , Object> map=new HashMap<String,Object>();
				map.put("total",ab.getTotal(uname));
				map.put("rows",list);
				this.outJson(map, response);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		}else if(isSuper.equals("yes")){
			try {
				List<Apartment> list=ab.superAdminfinApartmentInfo(page-1,rows);
				Map<String , Object> map=new HashMap<String,Object>();
				map.put("total",ab.getTotal());
				map.put("rows",list);
				this.outJson(map, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else {
			this.out(response, "出错了....");
		}
		
	}
	private void update_StuinfoOP(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String sid=request.getParameter("update_sid");
		String sname=request.getParameter("update_name");
		String sex=request.getParameter("sex");
		String bid=request.getParameter("update_bid");
		String dept=request.getParameter("update_dept");
		String major=request.getParameter("update_major");
		String photo=request.getParameter("myphoto");
		String money=request.getParameter("update_money");
		String year=request.getParameter("update_year");
		String status=request.getParameter("update_status");
		StudentBiz sb=new StudentBizImpl();
		int result=sb.updateInfo(sid,sname,sex,bid,dept,major,photo,money,year,status);
		if(result!=0){
			response.sendRedirect("back/admin.jsp");
		}else{
			response.sendRedirect("back/admin.jsp");
		}
	}
	private void findInfoOP(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String sid=request.getParameter("sid");
		StudentBiz sb=new StudentBizImpl();
		List<Student> list=sb.finInfo(sid);
		JsonModel jm=new JsonModel();
		if(list!=null){
			jm.setCode(1);
			jm.setObj(list.get(0));
		}else{
			jm.setCode(0);
		}
		super.outJson(jm, response);
		
	}
	private void findStuInfoOP(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer page=Integer.parseInt(request.getParameter("page"));
		Integer rows=Integer.parseInt(request.getParameter("rows"));
		HttpSession session=request.getSession();
		String isSuper=(String) session.getAttribute("isSuper");
		
		StudentBiz sb=new StudentBizImpl();
		if(isSuper.equals("no")){
			String uname=(String) session.getAttribute("aid");
			try {
				List<Student> list=sb.adminfinInfo(uname,page-1,rows);
				Map<String , Object> map=new HashMap<String,Object>();
				map.put("total",sb.getTotal(uname));
				map.put("rows",list);
				this.outJson(map, response);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		}else if(isSuper.equals("yes")){
			try {
				List<Student> list=sb.superAdminfinInfo(page-1,rows);
				Map<String , Object> map=new HashMap<String,Object>();
				map.put("total",sb.getTotal());
				map.put("rows",list);
				this.outJson(map, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else {
			this.out(response, "出错了....");
		}
	}
	private void registerStuOP(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/json");
		FileUploadUtil upload=new FileUploadUtil();
		PageContext pageContext=JspFactory.getDefaultFactory().getPageContext(this,request,response,null,true,1024,true);
		Map<String ,String> map=upload.fileUpload(pageContext);
		String uname=map.get("uname");
		String sex=map.get("sex");
		String pwd=map.get("pwd");
		String major=map.get("major");
		String dept=map.get("dept");
		String year=map.get("year");
		int bid=Integer.parseInt(map.get("bid"));
		String photo=request.getParameter("photo");
		AdminBiz ab=new AdminBizImpl();
		int result=ab.register(uname,sex,pwd,major,dept,year,bid,photo);
		JsonModel jm=new JsonModel();
		if(result!=0){
			jm.setCode(1);
		}else{
			jm.setCode(0);
			jm.setErrorMsg("身份过期,请重新登录");
		}
		super.outJson(jm, response);
	}

}

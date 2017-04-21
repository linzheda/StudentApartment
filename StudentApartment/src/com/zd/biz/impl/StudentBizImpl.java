package com.zd.biz.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.zd.bean.Student;
import com.zd.biz.StudentBiz;
import com.zd.dao.DBHelper;

public class StudentBizImpl implements StudentBiz{
	private DBHelper db=new DBHelper();
	@Override
	public List<Student> login(int uname, String pwd) throws NumberFormatException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String sql="select * from student where sid=? and spwd=?";
		List<Object> params=new ArrayList<Object>();
		params.add(uname);
		params.add(pwd);
		return db.find(sql,Student.class , params);
	}
	@Override
	public List<Student> finInfo(String uname) throws NumberFormatException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String sql="select s.*,apname,bname from student s,bedroom b,apartment a where s.bid=b.bid and a.apid=b.apid and sid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(uname);
		return db.find(sql,Student.class , params);
	}
	@Override
	public int udaptePwd(String uname,String pwd) {
		String sql="update student set spwd=? where sid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(pwd);
		params.add(uname);
		return db.update(sql, params);
	}
	@Override
	public List<Student> finMoney(String uname) throws Exception{
		String sql="select money from student where sid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(uname);
		return db.find(sql,Student.class , params);
	}
	@Override
	public int leave(String uname) {
		String sql="update student set status=0 where sid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(uname);
		return db.update(sql, params);
	}
	@Override
	public String finApid(String uname) {
		String sql="select apid from student,bedroom where student.bid=bedroom.bid and sid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(uname);
		List<String>list= db.find(sql, params);
		return list.get(0);
	}
	@Override
	public String findPs(String uname) {
		String sql="select sps from student where sid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(uname);
		List<String>list= db.find(sql, params);
		return list.get(0);
	}
	@Override
	public int updatePs(String uname ,String content) {
		String sql="update student set sps=? where sid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(content);
		params.add(uname);
		return db.update(sql, params);
	}
	@Override
	public List<Student> adminfinInfo(String uname,Integer page, Integer rows) throws Exception{//管理员查看学生信息
		String sql=" select s.* from student s,bedroom b,admin a where s.bid=b.bid and a.apid=b.apid and a.aid=? limit ?,? ";
		List<Object> params=new ArrayList<Object>();
		params.add(uname);
		params.add(page);
		params.add(rows);
		return db.find(sql, Student.class, params);
	}
	@Override
	public int getTotal() {
		String sql="select count(sid) from student";
		List<String>list=db.find(sql);
		int result=Integer.parseInt(list.get(0));
		return  result;
	}
	@Override
	public int getTotal(String uname) {
		String sql="select count(sid) from student s,bedroom b,admin a where s.bid=b.bid and a.apid=b.apid and a.aid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(uname);
		List<String>list=db.find(sql, params);
		int result=Integer.parseInt(list.get(0));
		return  result;
	}
	@Override
	public List<Student> superAdminfinInfo(Integer page, Integer rows) throws Exception{
		String sql="select * from student limit ?,?  ";
		List<Object> params=new ArrayList<Object>();
		params.add(page);
		params.add(rows);
		return db.find(sql, Student.class, params);
	}
	@Override
	public int updateInfo(String sid, String sname, String sex, String bid, String dept, String major, String photo,
			String money, String year, String status) {
		String sql="update student set sname=?,sex=?,bid=?,major=?,dept=?,photo=?,money=?,year=?,status=? where sid=?  ";
		List<Object> params=new ArrayList<Object>();
		params.add(sname);
		params.add(sex);
		params.add(bid);
		params.add(major);
		params.add(dept);
		params.add(photo);
		params.add(money);
		params.add(year);
		params.add(status);
		params.add(sid);
		return db.update(sql, params);
	}
	
	

}

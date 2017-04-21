package com.zd.biz.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.zd.bean.Admin;
import com.zd.biz.AdminBiz;
import com.zd.dao.DBHelper;

public class AdminBizImpl implements AdminBiz{
	private DBHelper db=new DBHelper();
	@Override
	public List<Admin> login(String uname, String pwd) throws NumberFormatException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String sql="select * from admin where aid=? and apwd=?";
		List<Object> params=new ArrayList<Object>();
		params.add(uname);
		params.add(pwd);
		return db.find(sql,Admin.class , params);
	}
	@Override
	public List<Admin> findAdmin() throws Exception {
		String sql="select * from admin";
		return db.find(sql, Admin.class);
	}
	@Override
	public int register(String uname, String sex, String pwd, String major, String dept, String year, int bid,String photo) {
		String sql="insert into student(sname,sex,major,dept,bid,year,status,photo,money,sps,spwd) "
				+ "values(?,?,?,?,?,?,1,?,0,null,?) ";
		List<Object> params=new ArrayList<Object>();
		params.add(uname);
		params.add(sex);
		params.add(major);
		params.add(dept);
		params.add(bid);
		params.add(year);
		params.add(photo);
		params.add(pwd);
		int result=db.update(sql, params);
		return result;
	}

}

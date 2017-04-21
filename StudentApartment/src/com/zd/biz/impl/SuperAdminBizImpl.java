package com.zd.biz.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.zd.bean.Admin;
import com.zd.bean.SuperAdmin;
import com.zd.biz.SuperAdminBiz;
import com.zd.dao.DBHelper;

public class SuperAdminBizImpl implements SuperAdminBiz{
	private DBHelper db=new DBHelper();
	@Override
	public List<SuperAdmin> login(String uname, String pwd) throws NumberFormatException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String sql="select * from superadmin where said=? and sapwd=?";
		List<Object> params=new ArrayList<Object>();
		params.add(uname);
		params.add(pwd);
		return db.find(sql,SuperAdmin.class , params);
	}
	
}

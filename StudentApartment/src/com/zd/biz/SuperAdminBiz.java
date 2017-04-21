package com.zd.biz;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.zd.bean.SuperAdmin;


public interface SuperAdminBiz {
	public List<SuperAdmin> login(String uname,String pwd) throws NumberFormatException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}

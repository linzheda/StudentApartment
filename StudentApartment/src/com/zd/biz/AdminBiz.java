package com.zd.biz;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.zd.bean.Admin;

public interface AdminBiz {
	public List<Admin> login(String uname,String pwd) throws NumberFormatException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<Admin> findAdmin() throws Exception;
	public int register(String uname, String sex, String pwd, String major, String dept, String year, int bid,String photo);

}

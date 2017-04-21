package com.zd.biz;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.zd.bean.Student;

public interface StudentBiz {
	public List<Student> login(int uname,String pwd) throws NumberFormatException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;

	public List<Student> finInfo(String uname) throws NumberFormatException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;

	public int udaptePwd(String uname, String pwd);

	public List<Student> finMoney(String uname) throws Exception;

	public int leave(String uname);

	public String finApid(String uname);

	public String findPs(String uname);

	public int updatePs(String uname,String content);

	public int getTotal();

	public int getTotal(String uname);

	public List<Student> adminfinInfo(String uname, Integer page, Integer rows) throws Exception;


	public List<Student> superAdminfinInfo(Integer page, Integer rows) throws Exception;

	public int updateInfo(String sid, String sname, String sex, String bid, String dept, String major, String photo,
			String money, String year, String status);
}

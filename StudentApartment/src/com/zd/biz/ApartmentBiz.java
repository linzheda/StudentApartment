package com.zd.biz;

import java.util.List;

import com.zd.bean.Apartment;
import com.zd.bean.Student;

public interface ApartmentBiz {
	public int publicReport(String apid, String content);

	public List<Apartment> adminfinApartmentInfo(String uname, int i, Integer rows) throws Exception;

	public int getTotal(String uname);

	public int getTotal();

	public List<Apartment> superAdminfinApartmentInfo(int i, Integer rows) throws Exception;

	public int updateDetial(String apid);
}

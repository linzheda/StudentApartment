package com.zd.biz.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.zd.bean.Apartment;
import com.zd.biz.ApartmentBiz;
import com.zd.dao.DBHelper;

public class ApartmentBizImpl implements  ApartmentBiz{
	private DBHelper db=new DBHelper();
	@Override
	public int publicReport(String apid,String content) {
		String sql="update apartment set apdetail=? where apid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(content);
		params.add(apid);
		return db.update(sql, params);
	}
	@Override
	public List<Apartment> adminfinApartmentInfo(String uname, int page, Integer rows) throws Exception{
		String sql="select ap.* from apartment ap,admin a where a.apid=ap.apid and a.apid=? limit ?,? ";
		List<Object> params=new ArrayList<Object>();
		params.add(uname);
		params.add(page);
		params.add(rows);
		return db.find(sql, Apartment.class, params);
	}
	@Override
	public int getTotal(String uname) {
		String sql="select count(ap.apid) from apartment ap,admin a where a.apid=ap.apid and a.apid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(uname);
		List<String>list=db.find(sql, params);
		int result=Integer.parseInt(list.get(0));
		return  result;
	}
	@Override
	public int getTotal() {
		String sql="select count(apid) from apartment";
		List<String>list=db.find(sql);
		int result=Integer.parseInt(list.get(0));
		return  result;
	}
	@Override
	public List<Apartment> superAdminfinApartmentInfo(int page, Integer rows) throws Exception{
		String sql="select * from apartment limit ?,? ";
		List<Object> params=new ArrayList<Object>();
		params.add(page);
		params.add(rows);
		return db.find(sql, Apartment.class, params);
	}
	@Override
	public int updateDetial(String apid) {
		String sql="update apartment set apdetail='一切设备完整' where apid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(apid);
		return db.update(sql, params);
	}

}

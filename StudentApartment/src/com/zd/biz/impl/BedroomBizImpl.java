package com.zd.biz.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zd.bean.Bedroom;
import com.zd.biz.BedroomBiz;
import com.zd.dao.DBHelper;

public class BedroomBizImpl implements BedroomBiz{
	private DBHelper db=new DBHelper();
	@Override
	public int updatePs(int bid, String content) {
		String sql="update bedroom set bps=? where apid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(content);
		params.add(bid);
		return db.update(sql, params);
	}
	@Override
	public List<Bedroom> finBedroom(String uname, int page, Integer rows) throws Exception{
		String sql="select b.* from bedroom b,admin a where a.apid=b.apid and a.apid=? limit ?,? ";
		List<Object> params=new ArrayList<Object>();
		params.add(uname);
		params.add(page);
		params.add(rows);
		return db.find(sql, Bedroom.class, params);
	}
	@Override
	public int getTotal(String uname) {
		String sql="select count(b.bid) from bedroom b,admin a where a.apid=b.apid and a.apid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(uname);
		List<String>list=db.find(sql, params);
		int result=Integer.parseInt(list.get(0));
		return  result;
	}
	@Override
	public List<Bedroom> superAdminfinBedroomInfo(int page, Integer rows) throws Exception{
		String sql="select * from bedroom limit ?,? ";
		List<Object> params=new ArrayList<Object>();
		params.add(page);
		params.add(rows);
		return db.find(sql, Bedroom.class, params);
	}
	@Override
	public int getTotal() {
		String sql="select count(bid) from bedroom";
		List<String>list=db.find(sql);
		int result=Integer.parseInt(list.get(0));
		return  result;
	}
	@Override
	public int updateBps(String bid) {
		String sql="update bedroom set bps='一切设备完整' where bid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(bid);
		return db.update(sql, params);
	}
	@Override
	public List<Map<String, Object>> finBedroom() {
		String sql="select bid,bname from bedroom  ";
		List<Map<String, Object>> list=db.finds(sql);
		
		return list;
	}

}

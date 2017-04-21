package com.zd.biz.impl;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.zd.bean.Bedroom;
import com.zd.bean.Visitor;
import com.zd.biz.VisitorBiz;
import com.zd.dao.DBHelper;

public class VisitorBizImpl implements VisitorBiz{
	private DBHelper db=new DBHelper();
	@Override
	public int register(String vname, String vsex, String vtel, String clause, String ps, String bid) {
		String sql="insert into visitor(vname,vsex,vtel,clause,ps,bid,startdate,overdate,vstatus) "
				+ "values(?,?,?,?,?,?,?,null,0) ";
		List<Object> params=new ArrayList<Object>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String d=sdf.format(new Date());
		params.add(vname);
		params.add(vsex);
		params.add(vtel);
		params.add(clause);
		params.add(ps);
		params.add(bid);
		params.add(d);
		int result=db.update(sql, params);
		return result;
	}
	@Override
	public List<Visitor> finVisitor(String uname, int page, Integer rows) throws Exception{
		String sql="select v.* from bedroom b,admin a,visitor v where a.apid=b.apid and v.bid=b.bid and  a.apid=? limit ?,? ";
		List<Object> params=new ArrayList<Object>();
		params.add(uname);
		params.add(page);
		params.add(rows);
		return db.find(sql, Visitor.class, params);
	}
	@Override
	public int getTotal(String uname) {
		String sql="select count(v.vid) from bedroom b,admin a ,visitor v where a.apid=b.apid and v.bid=b.bid and a.apid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(uname);
		List<String>list=db.find(sql, params);
		int result=Integer.parseInt(list.get(0));
		return  result;
	}
	@Override
	public List<Visitor> superAdminfinVisitorInfo(int page, Integer rows) throws Exception{
		String sql="select * from visitor limit ?,? ";
		List<Object> params=new ArrayList<Object>();
		params.add(page);
		params.add(rows);
		return db.find(sql, Visitor.class, params);
	}
	@Override
	public int getTotal() {
		String sql="select count(vid) from visitor";
		List<String>list=db.find(sql);
		int result=Integer.parseInt(list.get(0));
		return  result;
	}
	@Override
	public int updateLave(String vid) {
		String sql="update visitor set vstatus=1,overdate=? where vid=?";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String overdate=sdf.format(new Date());
		List<Object> params=new ArrayList<Object>();
		params.add(overdate);
		params.add(vid);
		return db.update(sql, params);
	}
	@Override
	public List<Map<String, Object>> makeReport(String dateStart, String dateEnd) {

		String sql="select ap.apname as name,count(v.vid) as num from apartment ap,visitor v,bedroom b where b.bid=v.bid and b.apid=ap.apid and str_to_date( v.startdate,'%Y-%m-%d') between str_to_date(?,'%Y-%m-%d') and str_to_date(?,'%Y-%m-%d') group by ap.apid  ";
		List<Object> params=new ArrayList<Object>();
		params.add(dateStart);
		params.add(dateEnd);
		List<Map<String, Object>> list=db.finds(sql, params);
		return list;
	}

}

package com.zd.biz;

import java.util.List;
import java.util.Map;

import com.zd.bean.Visitor;

public interface VisitorBiz {

	public int register(String vname, String vsex, String vtel, String clause, String ps, String bid);

	public List<Visitor> finVisitor(String uname, int page, Integer rows) throws Exception;

	public int getTotal(String uname);

	public List<Visitor> superAdminfinVisitorInfo(int i, Integer rows) throws Exception;

	public int getTotal();

	public int updateLave(String vid);

	public List<Map<String, Object>> makeReport(String dateStart, String dateEnd);

}

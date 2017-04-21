package com.zd.biz;

import java.util.List;
import java.util.Map;

import com.zd.bean.Bedroom;

public interface BedroomBiz {
	public int updatePs(int bid,String content);

	public List<Bedroom> finBedroom(String uname, int page, Integer rows) throws Exception;

	public int getTotal(String uname);

	public List<Bedroom> superAdminfinBedroomInfo(int page, Integer rows) throws Exception;

	public int getTotal();

	public int updateBps(String bid);

	public List<Map<String, Object>> finBedroom();
}

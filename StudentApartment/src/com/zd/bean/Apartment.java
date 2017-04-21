package com.zd.bean;

public class Apartment {
	private int apid;//公寓id
	private String apname;//公寓名
	private String apdetail;//信息
	public int getApid() {
		return apid;
	}
	public void setApid(int apid) {
		this.apid = apid;
	}
	public String getApname() {
		return apname;
	}
	public void setApname(String apname) {
		this.apname = apname;
	}
	public String getApdetail() {
		return apdetail;
	}
	public void setApdetail(String apdetail) {
		this.apdetail = apdetail;
	}
	@Override
	public String toString() {
		return "Apartment [apid=" + apid + ", apname=" + apname + ", apdetail=" + apdetail + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apdetail == null) ? 0 : apdetail.hashCode());
		result = prime * result + apid;
		result = prime * result + ((apname == null) ? 0 : apname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apartment other = (Apartment) obj;
		if (apdetail == null) {
			if (other.apdetail != null)
				return false;
		} else if (!apdetail.equals(other.apdetail))
			return false;
		if (apid != other.apid)
			return false;
		if (apname == null) {
			if (other.apname != null)
				return false;
		} else if (!apname.equals(other.apname))
			return false;
		return true;
	}
	public Apartment(int apid, String apname, String apdetail) {
		super();
		this.apid = apid;
		this.apname = apname;
		this.apdetail = apdetail;
	}
	public Apartment() {
		super();
	}

	
	
	
	
}

package com.zd.bean;

public class Bedroom {
	private int bid;//寝室id
	private String bname;//寝室名
	private String btype;//寝室类型
	private int apid;//公寓id
	private int bstatus;//寝室状态
	private String bps;//
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBtype() {
		return btype;
	}
	public void setBtype(String btype) {
		this.btype = btype;
	}
	public int getApid() {
		return apid;
	}
	public void setApid(int apid) {
		this.apid = apid;
	}
	public int getBstatus() {
		return bstatus;
	}
	public void setBstatus(int bstatus) {
		this.bstatus = bstatus;
	}
	
	
	
	
	public String getBps() {
		return bps;
	}
	public void setBps(String bps) {
		this.bps = bps;
	}
	
	@Override
	public String toString() {
		return "Bedroom [bid=" + bid + ", bname=" + bname + ", btype=" + btype + ", apid=" + apid + ", bstatus="
				+ bstatus + ", bps=" + bps + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + apid;
		result = prime * result + bid;
		result = prime * result + ((bname == null) ? 0 : bname.hashCode());
		result = prime * result + ((bps == null) ? 0 : bps.hashCode());
		result = prime * result + bstatus;
		result = prime * result + ((btype == null) ? 0 : btype.hashCode());
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
		Bedroom other = (Bedroom) obj;
		if (apid != other.apid)
			return false;
		if (bid != other.bid)
			return false;
		if (bname == null) {
			if (other.bname != null)
				return false;
		} else if (!bname.equals(other.bname))
			return false;
		if (bps == null) {
			if (other.bps != null)
				return false;
		} else if (!bps.equals(other.bps))
			return false;
		if (bstatus != other.bstatus)
			return false;
		if (btype == null) {
			if (other.btype != null)
				return false;
		} else if (!btype.equals(other.btype))
			return false;
		return true;
	}
	
	public Bedroom(int bid, String bname, String btype, int apid, int bstatus, String bps) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.btype = btype;
		this.apid = apid;
		this.bstatus = bstatus;
		this.bps = bps;
	}
	public Bedroom() {
		super();
	}
	
	
	

}

package com.zd.bean;

import java.io.Serializable;

public class Visitor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private int vid;//编号
	private String vname;//名字
	private String vsex;//性别
	private int vstatus;//状态
	private String vtel;//电话
	private String ps;//补充
	private String clause;//来访原因
	private String startdate;//来访时间
	private String overdate;//来访结束时间
	private int bid;//到访的寝室
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getVsex() {
		return vsex;
	}
	public void setVsex(String vsex) {
		this.vsex = vsex;
	}
	public int getVstatus() {
		return vstatus;
	}
	public void setVstatus(int vstatus) {
		this.vstatus = vstatus;
	}
	public String getVtel() {
		return vtel;
	}
	public void setVtel(String vtel) {
		this.vtel = vtel;
	}
	public String getPs() {
		return ps;
	}
	public void setPs(String ps) {
		this.ps = ps;
	}
	public String getClause() {
		return clause;
	}
	public void setClause(String clause) {
		this.clause = clause;
	}
	public String getOverdate() {
		return overdate;
	}
	public void setOverdate(String overdate) {
		this.overdate = overdate;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	@Override
	public String toString() {
		return "Visitor [vid=" + vid + ", vname=" + vname + ", vsex=" + vsex + ", vstatus=" + vstatus + ", vtel=" + vtel
				+ ", ps=" + ps + ", clause=" + clause + ", startdate=" + startdate + ", overdate=" + overdate + ", bid="
				+ bid + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bid;
		result = prime * result + ((clause == null) ? 0 : clause.hashCode());
		result = prime * result + ((overdate == null) ? 0 : overdate.hashCode());
		result = prime * result + ((ps == null) ? 0 : ps.hashCode());
		result = prime * result + ((startdate == null) ? 0 : startdate.hashCode());
		result = prime * result + vid;
		result = prime * result + ((vname == null) ? 0 : vname.hashCode());
		result = prime * result + ((vsex == null) ? 0 : vsex.hashCode());
		result = prime * result + vstatus;
		result = prime * result + ((vtel == null) ? 0 : vtel.hashCode());
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
		Visitor other = (Visitor) obj;
		if (bid != other.bid)
			return false;
		if (clause == null) {
			if (other.clause != null)
				return false;
		} else if (!clause.equals(other.clause))
			return false;
		if (overdate == null) {
			if (other.overdate != null)
				return false;
		} else if (!overdate.equals(other.overdate))
			return false;
		if (ps == null) {
			if (other.ps != null)
				return false;
		} else if (!ps.equals(other.ps))
			return false;
		if (startdate == null) {
			if (other.startdate != null)
				return false;
		} else if (!startdate.equals(other.startdate))
			return false;
		if (vid != other.vid)
			return false;
		if (vname == null) {
			if (other.vname != null)
				return false;
		} else if (!vname.equals(other.vname))
			return false;
		if (vsex == null) {
			if (other.vsex != null)
				return false;
		} else if (!vsex.equals(other.vsex))
			return false;
		if (vstatus != other.vstatus)
			return false;
		if (vtel == null) {
			if (other.vtel != null)
				return false;
		} else if (!vtel.equals(other.vtel))
			return false;
		return true;
	}
	public Visitor(int vid, String vname, String vsex, int vstatus, String vtel, String ps, String clause,
			String startdate, String overdate, int bid) {
		super();
		this.vid = vid;
		this.vname = vname;
		this.vsex = vsex;
		this.vstatus = vstatus;
		this.vtel = vtel;
		this.ps = ps;
		this.clause = clause;
		this.startdate = startdate;
		this.overdate = overdate;
		this.bid = bid;
	}
	public Visitor() {
		super();
	}
	
	
	

}

package com.zd.bean;

import java.io.Serializable;

public class Admin implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int aid;//教工编号
	private String aname;//姓名
	private String asex;//性别
	private String atel;//电话
	private String amail;//邮箱
	private int apid;//公寓id
	private String apwd;
	
	
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAsex() {
		return asex;
	}
	public void setAsex(String asex) {
		this.asex = asex;
	}
	public String getAtel() {
		return atel;
	}
	public void setAtel(String atel) {
		this.atel = atel;
	}
	public String getAmail() {
		return amail;
	}
	public void setAmail(String amail) {
		this.amail = amail;
	}
	public int getApid() {
		return apid;
	}
	public void setApid(int apid) {
		this.apid = apid;
	}
	
	public String getApwd() {
		return apwd;
	}
	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
	
	
	
	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", aname=" + aname + ", asex=" + asex + ", atel=" + atel + ", amail=" + amail
				+ ", apid=" + apid + ", apwd=" + apwd + "]";
	}
	
	public Admin(int aid, String aname, String asex, String atel, String amail, int apid, String apwd) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.asex = asex;
		this.atel = atel;
		this.amail = amail;
		this.apid = apid;
		this.apwd = apwd;
	}
	public Admin() {
		super();
	}
	
	

}

package com.zd.bean;

import java.io.Serializable;

public class SuperAdmin implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private int said;//教工编号
	private String saname;//姓名
	private String sasex;//性别
	private String satel;//电话
	private String samail;//邮箱
	private String sapwd;//密码
	
	
	public int getSaid() {
		return said;
	}
	public void setSaid(int said) {
		this.said = said;
	}
	public String getSaname() {
		return saname;
	}
	public void setSaname(String saname) {
		this.saname = saname;
	}
	public String getSasex() {
		return sasex;
	}
	public void setSasex(String sasex) {
		this.sasex = sasex;
	}
	public String getSatel() {
		return satel;
	}
	public void setSatel(String satel) {
		this.satel = satel;
	}
	public String getSamail() {
		return samail;
	}
	public void setSamail(String samail) {
		this.samail = samail;
	}
	
	public String getSapwd() {
		return sapwd;
	}
	public void setSapwd(String sapwd) {
		this.sapwd = sapwd;
	}
	
	
	
	@Override
	public String toString() {
		return "SuperAdmin [said=" + said + ", saname=" + saname + ", sasex=" + sasex + ", satel=" + satel + ", samail="
				+ samail + ", sapwd=" + sapwd + "]";
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + said;
		result = prime * result + ((samail == null) ? 0 : samail.hashCode());
		result = prime * result + ((saname == null) ? 0 : saname.hashCode());
		result = prime * result + ((sapwd == null) ? 0 : sapwd.hashCode());
		result = prime * result + ((sasex == null) ? 0 : sasex.hashCode());
		result = prime * result + ((satel == null) ? 0 : satel.hashCode());
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
		SuperAdmin other = (SuperAdmin) obj;
		if (said != other.said)
			return false;
		if (samail == null) {
			if (other.samail != null)
				return false;
		} else if (!samail.equals(other.samail))
			return false;
		if (saname == null) {
			if (other.saname != null)
				return false;
		} else if (!saname.equals(other.saname))
			return false;
		if (sapwd == null) {
			if (other.sapwd != null)
				return false;
		} else if (!sapwd.equals(other.sapwd))
			return false;
		if (sasex == null) {
			if (other.sasex != null)
				return false;
		} else if (!sasex.equals(other.sasex))
			return false;
		if (satel == null) {
			if (other.satel != null)
				return false;
		} else if (!satel.equals(other.satel))
			return false;
		return true;
	}
	
	
	
	public SuperAdmin(int said, String saname, String sasex, String satel, String samail, String sapwd) {
		super();
		this.said = said;
		this.saname = saname;
		this.sasex = sasex;
		this.satel = satel;
		this.samail = samail;
		this.sapwd = sapwd;
	}
	public SuperAdmin() {
		super();
	}
	
	
	

}

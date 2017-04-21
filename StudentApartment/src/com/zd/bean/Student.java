package com.zd.bean;

import java.io.Serializable;

public class Student implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private int sid;//学号
	private String sname;//姓名
	private String photo;//图片存储路径
	private String sex;//性别
	private String major;//专业
	private String dept;//院系
	private int bid;//寝室号
	private int year;//入学年份
	private int status;//状态
	private int money;//财产金额
	private String spwd;//密码
	private String sps;//备注：用来留言
	
	private String apname;//公寓名
	private String bname;//寝室名
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	public String getSpwd() {
		return spwd;
	}
	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}
	
	public String getApname() {
		return apname;
	}
	public void setApname(String apname) {
		this.apname = apname;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	
	public String getSps() {
		return sps;
	}
	public void setSps(String sps) {
		this.sps = sps;
	}
	
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", photo=" + photo + ", sex=" + sex + ", major=" + major
				+ ", dept=" + dept + ", bid=" + bid + ", year=" + year + ", status=" + status + ", money=" + money
				+ ", spwd=" + spwd + ", sps=" + sps + ", apname=" + apname + ", bname=" + bname + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apname == null) ? 0 : apname.hashCode());
		result = prime * result + bid;
		result = prime * result + ((bname == null) ? 0 : bname.hashCode());
		result = prime * result + ((dept == null) ? 0 : dept.hashCode());
		result = prime * result + ((major == null) ? 0 : major.hashCode());
		result = prime * result + money;
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + sid;
		result = prime * result + ((sname == null) ? 0 : sname.hashCode());
		result = prime * result + ((sps == null) ? 0 : sps.hashCode());
		result = prime * result + ((spwd == null) ? 0 : spwd.hashCode());
		result = prime * result + status;
		result = prime * result + year;
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
		Student other = (Student) obj;
		if (apname == null) {
			if (other.apname != null)
				return false;
		} else if (!apname.equals(other.apname))
			return false;
		if (bid != other.bid)
			return false;
		if (bname == null) {
			if (other.bname != null)
				return false;
		} else if (!bname.equals(other.bname))
			return false;
		if (dept == null) {
			if (other.dept != null)
				return false;
		} else if (!dept.equals(other.dept))
			return false;
		if (major == null) {
			if (other.major != null)
				return false;
		} else if (!major.equals(other.major))
			return false;
		if (money != other.money)
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (sid != other.sid)
			return false;
		if (sname == null) {
			if (other.sname != null)
				return false;
		} else if (!sname.equals(other.sname))
			return false;
		if (sps == null) {
			if (other.sps != null)
				return false;
		} else if (!sps.equals(other.sps))
			return false;
		if (spwd == null) {
			if (other.spwd != null)
				return false;
		} else if (!spwd.equals(other.spwd))
			return false;
		if (status != other.status)
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
	public Student(int sid, String sname, String photo, String sex, String major, String dept, int bid, int year,
			int status, int money, String spwd, String sps, String apname, String bname) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.photo = photo;
		this.sex = sex;
		this.major = major;
		this.dept = dept;
		this.bid = bid;
		this.year = year;
		this.status = status;
		this.money = money;
		this.spwd = spwd;
		this.sps = sps;
		this.apname = apname;
		this.bname = bname;
	}
	public Student() {
		super();
	}
}

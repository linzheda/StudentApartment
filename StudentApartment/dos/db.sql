drop database stuapartment;
create database stuapartment character set utf8;

use stuapartment;



--公寓表     ：  主键id 公寓名  信息
create table apartment(
	apid int primary key auto_increment,
	apname varchar(50),
	apdetail varchar(50)
)
--寝室表     ：  主键id 寝室名   寝室类型    公寓id  状态
create table bedroom(
	bid int primary key auto_increment,
	bname varchar(50),
	btype varchar(50),
	bps varchar(50),
	apid int,
	bstatus int,
	constraint fk_tbl_b foreign key(apid) references apartment(apid)
)
--超级管理员表： 主键id 姓名 性别 电话 邮箱 
create table superadmin(
	said int primary key auto_increment,
	saname varchar(50),
	sasex varchar(50),
	satel varchar(50),
	samail varchar(50),
	sapwd varchar(50),
)
-- 管理员表： 主键id 姓名 性别 电话 邮箱 公寓编号
create table admin(
	aid int primary key auto_increment,
	aname varchar(50),
	asex varchar(50),
	atel varchar(50),
	amail varchar(50),
	apwd varchar(50),
	apid int ,
	constraint fk_tbl_a foreign key(apid) references apartment(apid)
)
--学生表 ： 主键id 姓名 性别  专业  院系  公寓id 寝室id 入学年份  状态   图片路径
create table student(
	sid int primary key auto_increment,
	sname varchar(50),
	sex varchar(50),
	major varchar(50),
	dept varchar(50),
	bid int,
	year int,
	status int,
	photo varchar(50),
	money int,
	spwd varchar(50),
	sps varchar(80)
	constraint fk_tbl_s foreign key(bid) references bedroom(bid)
)
--来访人员表 ： 主键id 姓名 性别  电话  备注 来访原因   来访日期  离开日期   寝室id  状态 
create table visitor(
	vid int primary key auto_increment,
	vname varchar(50),
	vsex varchar(50),
	vtel varchar(50),
	ps varchar(50),
	clause varchar(50),
	startdate varchar(50),
	overdate varchar(50),
	bid int,
	vstatus int,
	constraint fk_tbl_v foreign key(bid) references bedroom(bid)
)







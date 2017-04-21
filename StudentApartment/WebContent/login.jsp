<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	*{
		padding: 0px;
		margin: 0 auto;
		font-family: "微软雅黑";
	}
	body{
		width: 100%;
		height: 100%;
		background: url(image/loginbg.png) no-repeat 0 -25px;
		background-size: 100% 100%;
		background-attachment:fixed;
	}
	#myform{
		margin-top:120px;
		margin-left:880px;
		border:1px solid #ccc;
		width:280px;
		padding-left:30px;
		padding-bottom:20px;
		padding-top:15px;
	}
	#uname,#pwd{
		margin-top:10px;
		margin-buttom:30px;
		width:220px;
		height:18px;
		padding:10px;
		border-radius:10px;
		border:1px solid #ccc;
	}
	.rlue{
		margin-top:20px;
		
	}
	.label{
		font-size:12px;
		padding-left:5px;
	}
	.yzm{
		width:80px;
		height:25px;
		boeder:1px solid #ccc;
	}
	#loginbtn{
		margin-top:20px;
		width:240px;
		height:35px;
		border-radius:14px;
		border:0;
		background:url(image/log.ico) #08A3DB;
		
	}
	

</style>

<title>学生公寓管理系统登录</title>
<link rel="shortcut icon" href="image/1.jpg">
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
</head>
<body>
	<div id="myform">
		<form  id="loginform" action="login.action">
			<input type="hidden" name="op" value="login" >
			<input type="text" placeholder="请输入登入号"  name="uname" id="uname"><br>
			<input type="password" placeholder="请输入密码"  name="pwd" id="pwd"><br>
			<span class="label">角色：</span>
			<input type="radio" value="student" name="rlue" class="rlue" checked="checked" ><span class="label">学生</span>
			<input type="radio" value="admind" name="rlue" class="rlue"><span class="label">管理员</span>
			<input type="radio" value="superadmind" name="rlue" class="rlue"><span class="label">超级管理员</span><br>
			<span class="label">验证码:</span>
			<input type="text" class="yzm" name="valcode" id="yzm" placeholder="请输入验证码" />	
			<img id="yzm_img" style="margin-top:5px;height:20px;"><br>
			<input type="submit" value="登     录" name="loginbtn" id="loginbtn" >
		</form>
	</div>
</body>
<script type="text/javascript">
$(function(){
	$("#yzm_img").attr("src","verifyCode.action?"+new Date().getTime());
	$("#yzm_img").click(function(){//点击验证码刷新
		$(this).attr("src","verifyCode.action?"+new Date().getTime());
	});
});
</script>
</html>
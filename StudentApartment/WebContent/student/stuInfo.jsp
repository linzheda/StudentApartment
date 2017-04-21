<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<form style="margin-top:20px;margin-left:400px;border:1px solid #ccc;width:230px;padding:20px;">
		<table>
			<tr>
				<td>证件照：</td>
				<td><img id="stuInfo_photo" style="width:50px;height:80px;"></td>
			</tr>
			<tr>
				<td>姓 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
				<td><span id="stuInfo_uname"></span></td>
			</tr>
			<tr>
				<td>性 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
				<td> <span id="stuInfo_sex"></span></td>
			</tr>
			<tr>
				<td>学 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</td>
				<td><span id="stuInfo_sid"></span></td>
			</tr>
			<tr>
				<td>入学年份：</td>
				<td><span id="stuInfo_year"></span></td>
			</tr>
			<tr>
				<td>专 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业：</td>
				<td><span id="stuInfo_major"></span></td>
				<td>院 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;系：</td>
				<td><span id="stuInfo_dept"></span></td>
			</tr>
			<tr>
				<td>公 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;寓：</td>
				<td><span id="stuInfo_ap"></span></td>
				<td>寝 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;室：</td>
				<td><span id="stuInfo_b"></span></td>
			</tr>
			<tr>
				<td>状 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态：</td>
				<td> <span id="stuInfo_status"></span></td>
			</tr>
		</table>
		<input type="button"  value="修改信息"  onclick="updateInfo()" >
		<input type="button"  value="修改密码" onclick="updatePwd()" >
	</form>




</div>


<div id="stuInfo_update_pwd" class="easyui-dialog"
	data-options="iconCls:'icon-add',resizable:true,fit:true,closed:true">
	<form style="padding:20px;margin-left:200px;">
		<input type="password"  id="stuInfo_pwd_1"><label>--请输入密码</label><br><br>
		<input type="password"  id="stuInfo_pwd_2"><label>--请再次输入密码确认</label><br>
		<label id="stuInfo_pwd_3"></label><br>
		<input type="button" value="确认修改" onclick="upwd()">
	</form>

</div>
<script>
	$(function(){
		$.ajax({
			url:"../student.action",
			data:"op=stuInfo",
			type:"POST",
			dataType:"json",
			success:function(data){
				if(data.code==0){
					alert(  "服务器错误,"+ data.msg);
				}else{
					showinfo(data.obj);
				}
			}	
		});
	});
function showinfo(index){
	var obj=index;
	$("#stuInfo_uname").html(obj.sname);
	$("#stuInfo_sex").html(obj.sex);
	$("#stuInfo_sid").html(obj.sid);
	$("#stuInfo_year").html(obj.year);
	$("#stuInfo_major").html(obj.major);
	$("#stuInfo_dept").html(obj.dept);
	$("#stuInfo_ap").html(obj.apname);
	$("#stuInfo_b").html(obj.bname);
	$("#stuInfo_status").html(obj.status);
	$("#stuInfo_photo").attr('src',obj.photo); 
}
function updateInfo(){
	alert("个人信息不可随意修改，若有错误，请于管理员联系");
}
function updatePwd(){
	$("#stuInfo_update_pwd").dialog({title:'修改个人密码',closed:false,iconCls:'icon-edit'});
}
function upwd(){
	var pwd1= $("#stuInfo_pwd_1").val();
	var pwd2= $("#stuInfo_pwd_2").val();
	if(pwd1==pwd2){
		$.ajax({
			url:"../student.action",
			data:"op=updatePwd&pwd="+pwd2,
			type:"POST",
			dataType:"json",
			success:function(data){
				if(data.code==0){
					alert(  "服务器错误,"+ data.msg);
				}else{
					alert("修改成功....")
				}
			}	
		});
	}else{
		alert("前后密码不一致");
	}
	
	
}






</script>
	
	



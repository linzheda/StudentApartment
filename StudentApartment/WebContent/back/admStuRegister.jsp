<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="margin-left:250px;margin-top:30px;">
	<form>
		<table>
			<tr>
				<td>用户名：</td>
				<td>
					<input type="text" placeholder="请输入用户名" name="register_name" id="register_name">
					<span>只能输入字母或数字，4-16字符</span>
				</td>
			</tr>
			<tr>
				<td>密     码：</td>
				<td>
					<input type="password" placeholder="请输入密码" name="register_pwd" id="register_pwd">
					<span>密码长度6-12位</span>
				</td>
			</tr>
			<tr>
				<td>性别：</td>
				<td>
					<input type="radio" name="sex"  class="sex" value="男" checked="checked">男 &nbsp;&nbsp;
					<input type="radio" name="sex"  class="sex" value="女">女
				</td>
			</tr>
			<tr>
				<td>寝室id：</td>
				<td>
					<select name="register_bid" id="register_bid">
						<option>--选择寝室--</option>
					</select>
				
				
				
				</td>
			</tr>
			<tr>
				<td>专业：</td>
				<td>
					<input type="text" placeholder="请输入专业" name="register_major" id="register_major">
				</td>
			</tr>
			<tr>
				<td>证件照：</td>
				<td>
					<input type="file" name="photo" id="myphoto" multiple="multiple" onchange="previewMultipleImage(this,'add_showpic')" >
					<div id="add_showpic" style="width:80px;height:50px;" ></div>
				</td>
			</tr>
			<tr>
				<td>院系：</td>
				<td>
					<input type="text" placeholder="请输入院系" name="register_dept" id="register_dept">
				</td>
			</tr>
			<tr>
				<td>入学年份：</td>
				<td>
					<input type="text" placeholder="请输入入学年份" name="register_year" id="register_year">
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="button" value="同意以下协议条款并提交" class="btn" id="btn">
				</td>
			</tr>
			
		</table>
		<div style="width:400px; height:80px;border: solid 2px black;">
			从前有做山，山里有座庙，庙里有个小和尚和一个老和尚，老和尚对小和尚说从前有做山，山里有座庙，庙里有个小和尚和一个老和尚，老和尚对小和尚说...
			欢迎来到公寓管理系统
		</div>
	</form>
</div>
<script>
$.ajax({
	url:"../admin.action",
	data:"op=findBedroomName",
	type:"POST",
	dataType:"json",
	success:function(data){
		if(data.code==0){
			alert(  "服务器错误,"+ data.msg);
		}else{
			for(var i=0;i<data.obj.length;i++){
				$("#register_bid").append("<option value="+data.obj[i].bid+">"+data.obj[i].bname+"</option>");
			}
			
			
			
		}
	}	
});



	$("#btn").click(function(){
		var uname=$("#register_name").val();
		var sex=$(".sex").val();
		var pwd=$("#register_pwd").val();
		var bid=$("#register_bid").val();
		var major=$("#register_major").val();
		var dept=$("#register_dept").val();
		var year=$("#register_year").val();
		var photo=$("#myphoto").val();
		$.ajaxFileUpload({
			url:"../admin.action?op=registerStu&photo="+photo,
			secureuri:false,
			fileElementId:"myphoto",
			data:{"uname":uname,"sex":sex,"pwd":pwd,"bid":bid,"major":major,"dept":dept,"year":year},
			dataType:"JSON",
			success:function(data){
				alert("注册成功....");
			},
			error:function(data){
				alert("出错了,请详细检查个人信息");
			}
		});
		
		
		
	});




</script>
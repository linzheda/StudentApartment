<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<form>
		<span>我们采用匿名投诉，请大家积极建议。邮件将由系统发送个各个管理员</span><br>
		<label>收件人：</label>
		<select id="receivePeople">
			<option>--请选择收件人--</option>
		</select><br><br>
		<label>主&nbsp;&nbsp;&nbsp;题：</label>
		<input type="text" name="MainTitle" id="MainTitle"><br><br>
		<label>内容：</label><br>
		<textarea rows="10" cols="60" id="content"></textarea><br>
		<input type="button" value="提交" onclick="sendMail()">
	</form>
</div>
<script>
	$(function(){
		$.ajax({
			url:"../student.action",
			data:"op=findAdmin",
			type:"POST",
			dataType:"json",
			success:function(data){
				if(data.code==0){
					alert(  "服务器错误,"+ data.msg);
				}else{
					showadmin(data.obj);
				}
			}	
		});
	});
	function showadmin(index){
		var obj=index;
		for(var i=0;i<obj.length;i++){
			$("#receivePeople").append("<option value='"+obj[i].amail+"'>"+obj[i].aname+"</option>");
		}
	}
	function sendMail(){
		$.ajax({
			url:"../student.action",
			data:"op=sendMail&mail="+$("#receivePeople").val()+"&mainTilte="+$("#MainTitle").val()+"&content="+$("#content").html(),
			type:"POST",
			dataType:"json",
			success:function(data){
				if(data.code==0){
					alert(  "服务器错误,"+ data.msg);
				}else{
					alert("发送成功");
				}
			}	
		});
	}




</script>






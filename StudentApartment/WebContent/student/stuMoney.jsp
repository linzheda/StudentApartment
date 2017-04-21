<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="margin-top:50px;margin-left:200px;border:1px solid #ccc; padding:20px;width:100px;">
	<label>已经登记了的资产金额：</label>
	<span id="stuMoney_money"></span>
	<br><br>
	<input type="button" value="申请" onclick="updateMoney()" >
</div>
<script>
	$(function (){
		$.ajax({
			url:"../student.action",
			data:"op=finMoney",
			type:"POST",
			dataType:"json",
			success:function(data){
				if(data.code==0){
					alert(  "服务器错误,"+ data.msg);
				}else{
					$("#stuMoney_money").html(data.obj);
				}
			}	
		});
	});
	function updateMoney(){
		alert("请提交相关资产证明复印件给管理员");
	}


</script>
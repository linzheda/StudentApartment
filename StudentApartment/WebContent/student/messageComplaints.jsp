<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<h1>留言区</h1><br>
	<form>
		<label>留言板：</label><br>
		<textarea rows="5" cols="80" id="history"></textarea><br>
		<label>内容：</label><br>
		<textarea rows="5" cols="50" id="mc_content"></textarea><br>
		<input type="button" value="提交" onclick="submitmessage()">
	</form>
</div>
<script type="text/javascript">
	$(function(){
		$.ajax({
			url:"../student.action",
			data:"op=finStuPs",
			type:"POST",
			dataType:"json",
			success:function(data){
				if(data.code==0){
					alert(  "服务器错误,"+ data.msg);
				}else{
					$("#history").html(data.obj);
				}
			}	
		});
		
	});
	function submitmessage(){
		$.ajax({
			url:"../student.action",
			data:"op=updateStuPs&content="+$("#mc_content").val(),
			type:"POST",
			dataType:"json",
			success:function(data){
				if(data.code==0){
					alert(  "服务器错误,"+ data.msg);
				}else{
					window.location.reload();
				}
			}	
		});
	}

</script>







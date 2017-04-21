<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<form>
		<label>离校办理</label><br>
		<span>请选择离校原因:</span><br>
		<input type="radio" name="clause"  checked="checked">正常离校<br>
		<input type="radio" name="clause" >退学<br>
		<input type="radio" name="clause" >参军,保留学籍<br>
		<input type="radio" name="clause" >其它<br>
		<input type="button" value="申请" onclick="leave()">
	</form>
</div>
<script type="text/javascript">
function leave(){
	$.ajax({
		url:"../student.action",
		data:"op=stuLeave",
		type:"POST",
		dataType:"json",
		success:function(data){
			if(data.code==0){
				alert(  "服务器错误,"+ data.msg);
			}else{
				alert("修改成功,请整理好寝室卫生并将钥匙交于管理员处");
			}
		}	
	});
}
</script>






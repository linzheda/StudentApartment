<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<label>公共设施维护</label>
	<select id="pr_select">
		<option>--选择公共设施--</option>
		<option value="饮水设备">1.饮水设备</option>
		<option value="照明设备">2.照明设备</option>
		<option value="清洁设备">3.清洁设备</option>
		<option value="监控设备">4.监控设备</option>
		<option value="灭火设备">5.灭火设备</option>
		<option value="其它">6.其它</option>
	</select>
	<input type="text" name="ps" placeholder="备注" id="pr_ps" >
	<input type="button" value="提交" onclick="publicreport()">

</div>
<script>
	function publicreport(){
		$.ajax({
			url:"../student.action",
			data:"op=publicReport&content="+$("#pr_select").val()+$("#pr_ps").val(),
			type:"POST",
			dataType:"json",
			success:function(data){
				if(data.code==0){
					alert(  "服务器错误,"+ data.msg);
				}else{
					alert("感谢你的提醒,我们会尽快处");
				}
			}	
		});
	}


</script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<label>寝室设施维护</label>
	<select id="br_select">
		<option>--选择公共设施--</option>
		<option value="桌椅">1.桌椅</option>
		<option value="床柜">2.床柜</option>
		<option value="灯具">3.灯具</option>
		<option value="热水">4.热水</option>
		<option value="空调">5.空调</option>
		<option value="其它">6.其它</option>
	</select>
	<input type="text" name="ps" placeholder="备注" id="br_ps" >
	<input type="button" value="提交" onclick="publicreport()">

</div>
<script>
	function publicreport(){
		$.ajax({
			url:"../student.action",
			data:"op=bedroomReport&content="+$("#br_select").val()+$("#br_ps").val(),
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
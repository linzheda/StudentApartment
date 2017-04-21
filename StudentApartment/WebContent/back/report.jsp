<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="ChartDirector.*"%>

<p style="margin-left:480px; margin-top:20px;">来访统计报表</p>
<div style="margin-left:300px; margin-top:20px;border:1px solid #ccc;width:500px;padding:20px;">
	<div>
		<input class="Wdate" type="text" onClick="WdatePicker()"
			id="date_start"> <label>~</label> <input class="Wdate"
			type="text" onClick="WdatePicker()" id="date_end"> <select
			id="report_type_select">
			<option value="zhexian">折线图</option>
			<option value="zhuzhuang">柱状图</option>
			<option value="bing">饼图</option>
		</select> <input type="button" value="生成报表" onclick="makeReport()">
	</div>

	<div id="chartcontainer">
	</div>    
  
</div>
<script>

	function makeReport() {
		var dateStart = $("#date_start").val();
		var dateEnd = $("#date_end").val(); 
		var reportType = $("#report_type_select").val();
		$.ajax({
			url : "../admin.action",
			data : "op=makeReport&reportType=" + reportType + "&dateStart="
					+ dateStart + "&dateEnd=" + dateEnd,
			type : "POST",
			dataType : "JSON",
			success : function(data) {
				if(reportType=='zhexian'){
					zhexian(data);
				}else if(reportType=='zhuzhuang'){
					zhuzhuang(data);
				}else if(reportType=='bing'){
					bing(data);
				}
				
			}
		});

	}
</script>

<script type="text/javascript">    
function zhexian(data){
	var myData = new Array();    
	for(var i=0;i<data.length;i++){
		myData[i]=[data[i].name,parseInt(data[i].num)];
	}
	var myChart = new JSChart('chartcontainer', 'line'); 
	myChart.setDataArray(myData);    
	myChart.draw()
}
function zhuzhuang(data){
	var myData = new Array();    
	for(var i=0;i<data.length;i++){
		myData[i]=[data[i].name,parseInt(data[i].num)];
	}
	console.info(myData);
	var myChart = new JSChart('chartcontainer', 'bar');
	myChart.setDataArray(myData);    
	myChart.draw()
}	
function bing(data){
	var myData = new Array();    
	for(var i=0;i<data.length;i++){
		myData[i]=[data[i].name,parseInt(data[i].num)];
	}
	console.info(myData);
	var myChart = new JSChart('chartcontainer', 'pie');
	myChart.setDataArray(myData);    
	myChart.draw()
}	
	
</script>  



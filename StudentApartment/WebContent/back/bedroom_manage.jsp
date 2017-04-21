<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table id="show_bedroom_info" data-options="fit:true"></table>
<script>
$('#show_bedroom_info').datagrid({    
    url:'../admin.action',  
    fitColumns:true,
    loadMsg:'数据加载中....',
    queryParams:{op:'findBedroom'},
    pagination:true,//显示分页栏
    striped:true,
    nowrap:true,
    rownumbers:true,            
    pageSize:5,
    pageList:[5,10,20,30,40,50],
    sortName:'bid',
    remoteSort:false,
    columns:[[    
		{field:'bid',title:'寝室id',width:100,align:'center',sortable:true},  
        {field:'bname',title:'寝室名',width:100,align:'center',sortable:true},    
        {field:'btype',title:'寝室类型',width:200,align:'center'},    
        {field:'bstatus',title:'寝室状态',width:200,align:'center'},    
        {field:'bps',title:'寝室报修',width:200,align:'center'},    
        {field:'kj',title:'操作',width:200,align:'center',formatter:formatOper},    
    ]]
});
function formatOper(val,row,index){
	var bid=row.bid;
	return '<input type="button" onclick="sslookitem('+bid+')" value="修改报修信息" >';
}
function sslookitem(bid){
	$.ajax({
		url:"../admin.action",
		data:"op=updateBedroomBps&bid="+bid,
		type:"POST",
		dataType:"json",
		success:function(data){
			if(data.code==0){
				alert(  "服务器错误,"+ data.msg);
			}else{
				alert("修改成功");
			}
		}	
	});
}


</script>
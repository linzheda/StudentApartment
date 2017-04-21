<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table id="show_apartment_info" data-options="fit:true"></table>
<script>
$('#show_apartment_info').datagrid({    
    url:'../admin.action',  
    fitColumns:true,
    loadMsg:'数据加载中....',
    queryParams:{op:'findAparment'},
    pagination:true,//显示分页栏
    striped:true,
    nowrap:true,
    rownumbers:true,            
    pageSize:5,
    pageList:[5,10,20,30,40,50],
    sortName:'apid',
    remoteSort:false,
    columns:[[    
		{field:'apid',title:'公寓id',width:100,align:'center',sortable:true},  
        {field:'apname',title:'公寓名',width:100,align:'center',sortable:true},    
        {field:'apdetail',title:'公寓报修信息',width:200,align:'center'},    
        {field:'kj',title:'操作',width:200,align:'center',formatter:formatOper},    
    ]]
});
function formatOper(val,row,index){
	var apid=row.apid;
	return '<input type="button" onclick="lookitems('+apid+')" value="修改报修信息" >';
}
function lookitems(apid){
	$.ajax({
		url:"../admin.action",
		data:"op=updateApartmentDetail&apid="+apid,
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
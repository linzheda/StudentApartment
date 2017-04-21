<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table id="shows_visitors_info" data-options="fit:true"></table>





<script type="text/javascript">
$('#shows_visitors_info').datagrid({    
    url:'../admin.action',  
    fitColumns:true,
    loadMsg:'数据加载中....',
    queryParams:{op:'findVisitorInfo'},
    pagination:true,//显示分页栏
    striped:true,
    nowrap:true,
    rownumbers:true,            
    pageSize:5,
    pageList:[5,10,20,30,40,50],
    sortName:'vstatus',
    remoteSort:false,
    columns:[[    
		{field:'vid',title:'编号',width:100,align:'center',sortable:true},  
        {field:'vname',title:'姓名',width:100,align:'center',sortable:true},    
        {field:'vsex',title:'性别',width:200,align:'center'},    
        {field:'vtel',title:'电话',width:100,align:'center'},
        {field:'clause',title:'来访原因',width:200,align:'center'},   
        {field:'ps',title:'备注',width:100,align:'center'},    
        {field:'startdate',title:'到访时间',width:200,align:'center',sortable:true},   
        {field:'overdate',title:'离去时间',width:200,align:'center',sortable:true},   
        {field:'bid',title:'到访寝室id',width:200,align:'center'},   
        {field:'vstatus',title:'状态',width:200,align:'center',sortable:true},   
        {field:'kj',title:'操作',width:200,align:'center',formatter:formatOper},    
    ]]
});

function formatOper(val,row,index){
	var vid=row.vid;
	return '<input type="button" onclick="updateitem('+vid+')" value="状态修改" >';
}
function updateitem(vid){
	$.ajax({
		url:"../admin.action",
		data:"op=updateVisitor&vid="+vid,
		type:"POST",
		dataType:"json",
		success:function(data){
			if(data.code==0){
				alert(  "服务器错误,"+ data.msg);
			}else{
				alert("操作成功");
			}
		}	
	});
}


</script>








<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table id="show_message_info" data-options="fit:true"></table>
<div id="show_message_answer" class="easyui-dialog"
	data-options="iconCls:'icon-add',resizable:true,fit:true,closed:true">
	<div>
		 <script id="editor" type="text/plain" ></script>
	</div>
	<input type="hidden" id="hidden_sid">
	<input type="button" value="回复" onclick="answerMessage()" >
<script type="text/javascript">
var ue = UE.getEditor('editor');
</script>
</div>
<script>
$('#show_message_info').datagrid({    
    url:'../admin.action',  
    fitColumns:true,
    loadMsg:'数据加载中....',
    queryParams:{op:'message_find'},
    pagination:true,//显示分页栏
    striped:true,
    nowrap:true,
    rownumbers:true,            
    pageSize:5,
    pageList:[5,10,20,30,40,50],
    sortName:'sid',
    remoteSort:false,
    columns:[[    
		{field:'sid',title:'学号',width:100,align:'center',sortable:true},  
		{field:'bid',title:'寝室id',width:100,align:'center',sortable:true},  
        {field:'sname',title:'姓名',width:100,align:'center',sortable:true},    
        {field:'sex',title:'性别',width:200,align:'center'},    
        {field:'major',title:'专业',width:200,align:'center'},    
        {field:'dept',title:'院系',width:200,align:'center'},    
        {field:'sps',title:'留言',width:500,align:'center'},    
        {field:'kj',title:'操作',width:200,align:'center',formatter:formatOper},    
    ]]
});
function formatOper(val,row,index){
	var sid=row.sid;
	return '<input type="button" onclick="sslookitem('+sid+')" value="回复留言" >';
}
function sslookitem(bid){
	$("#show_message_answer").dialog({title:'回复留言',closed:false,iconCls:'icon-edit'});
	$("#hidden_sid").val(bid);
}
function answerMessage(){
	var content=ue.getContent();
	$.ajax({
		url : "../admin.action",
		data : "op=answerMessage&content="+content+"&sid="+$("#hidden_sid").val(),
		type : "POST",
		dataType : "JSON",
		success : function(data) {
			alert("回复成功");			
		}
	});
}

</script>
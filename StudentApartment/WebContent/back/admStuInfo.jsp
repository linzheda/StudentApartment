<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<table id="show_student_info" data-options="fit:true"></table>

<div id="show_student_item_infos" class="easyui-dialog"
	data-options="iconCls:'icon-add',resizable:true,fit:true,closed:true">
	<form action="../admin.action?op=update_Stuinfo" method="post">
	<input type="hidden" name="update_sid" id="update_sid">
	<table>
			<tr>
				<td>用户名：</td>
				<td>
					<input type="text" placeholder="请输入用户名" name="update_name" id="update_name">
					<span>只能输入字母或数字，4-16字符</span>
				</td>
			</tr>
			
			<tr>
				<td>性别：</td>
				<td>
					<input type="radio" name="sex"  class="sex" value="男" id="boy" >男 &nbsp;&nbsp;
					<input type="radio" name="sex"  class="sex" value="女" id="gril" >女
				</td>
			</tr>
			<tr>
				<td>寝室id：</td>
				<td>
					<input type="text" placeholder="请输入寝室id" name="update_bid" id="update_bid">
				</td>
			</tr>
			<tr>
				<td>专业：</td>
				<td>
					<input type="text" placeholder="请输入专业" name="update_major" id="update_major">
				</td>
			</tr>
			<tr>
				<td>证件照：</td>
				<td>
					<input type="file" name="myphoto" id="myphoto" multiple="multiple" onchange="previewMultipleImage(this,'add_showpic')" >
					<div id="add_showpic" style="width:80px;height:50px;" ></div>
				</td>
			</tr>
			<tr>
				<td>院系：</td>
				<td>
					<input type="text" placeholder="请输入院系" name="update_dept" id="update_dept">
				</td>
			</tr>
			<tr>
				<td>登记的财产金额：</td>
				<td>
					<input type="text" placeholder="请输入金额" name="update_money" id="update_money">
				</td>
			</tr>
			<tr>
				<td>入学年份：</td>
				<td>
					<input type="text" placeholder="请输入入学年份" name="update_year" id="update_year">
				</td>
			</tr>
			<tr>
				<td>状态：</td>
				<td>
					<select id="update_status" name="update_status">
						<option value="0">0-离校</option>
						<option value="1">1-在校</option>
					</select>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="提交" class="btn" >
				</td>
			</tr>
			
		</table>

</form>
</div>
<script type="text/javascript">
$('#show_student_info').datagrid({    
    url:'../admin.action',  
    fitColumns:true,
    loadMsg:'数据加载中....',
    queryParams:{op:'findStuInfosss'},
    pagination:true,//显示分页栏
    striped:true,
    nowrap:true,
    rownumbers:true,            
    pageSize:5,
    pageList:[5,10,20,30,40,50],
    sortName:'sid',
    remoteSort:false,
    columns:[[    
		{field:'photo',title:'图片',width:100,align:'center',formatter: function(value,row,index){
	        	var picStr="";
				if (value.indexOf(",")>0){
					value=value.split(",");
					
					for(var i=0;i<value.length;i++){
						picStr+="<img src='../image/photo/"+value[i]+"' width='100px' height='100px' />";
					}
					
				} else if(value!=""){
					picStr+="<img src='../image/photo/"+value+"' width='100px' height='100px' />";
				}else{
					picStr+="<img src='../image/zwtp.png' width='100px' height='100px' />";
				}
				return picStr;
		}},   
		{field:'sid',title:'学号',width:100,align:'center',sortable:true},  
        {field:'sname',title:'姓名',width:100,align:'center',sortable:true},    
        {field:'sex',title:'性别',width:200,align:'center'},    
        {field:'major',title:'专业',width:100,align:'center'},
        {field:'dept',title:'院系',width:100,align:'center'},    
        {field:'bid',title:'寝室id',width:200,align:'center'},   
        {field:'year',title:'入学年份',width:200,align:'center'},   
        {field:'money',title:'登记财产金额',width:200,align:'center'},   
        {field:'status',title:'状态',width:200,align:'center'},   
        {field:'kj',title:'操作',width:200,align:'center',formatter:formatOper},    
    ]]
});



function formatOper(val,row,index){
	var sid=row.sid;
	return '<input type="button" onclick="lookitem('+sid+')" value="修改" >';
}
function lookitem(sid){
	$("#show_student_item_infos").dialog({title:'修改学员信息',closed:false,iconCls:'icon-edit'});
	$.ajax({
		url:"../admin.action",
		data:"op=findInfo&sid="+sid,
		type:"POST",
		dataType:"json",
		success:function(data){
			if(data.code==0){
				alert(  "服务器错误,"+ data.msg);
			}else{
				$("#update_sid").val(sid);
				$("#update_name").val(data.obj.sname);
				$("#update_bid").val(data.obj.bid);
				$("#update_major").val(data.obj.major);
				$("#update_dept").val(data.obj.dept);
				$("#update_year").val(data.obj.year);
				$("#update_money").val(data.obj.money);
				if(data.obj.sex=="男"){
					$("#boy").attr("checked",true);
				}else{
					$("#gril").attr("checked",true);
				}
				if(data.obj.status==1){
					$("#update_status").val(1);
				}else{
					$("#update_status").val(0);;
				}
				
				
			}
		}	
	});
	
}



</script>
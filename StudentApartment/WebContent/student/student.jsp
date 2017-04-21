<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生专区</title>
<link rel="shortcut icon" href="../image/xiaohui.jpg">
<link rel="stylesheet" type="text/css" href="../easyui/css/easyui.css">
<link rel="stylesheet" type="text/css" href="../easyui/css/icon.css">
<link rel="stylesheet" type="text/css" href="../easyui/css/demo.css">
<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="../js/jscharts.js"></script>
<script type="text/javascript" src="../easyui/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../easyui/js/easyui-lang-zh_CN.js"></script>
<script language="javascript" type="text/javascript" src="../datetool/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../easyui/js/student.js"></script>



<script type="text/javascript" src="../js/showpic.js"></script>
<script type="text/javascript" src="../js/ajaxfileupload.js"></script>
<script type="text/javascript" charset="utf-8"
	src="../ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="../ueditor/ueditor.all.min.js"> </script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8"
	src="../ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',split:true" style="height: 80px;background: #E6EDF4; background-position:center;" >
		 <img src="../image/headers.png" style="width:100%;height:100%">
	</div>
	<div data-options="region:'west',split:true,title:'导航'" 
		style="width:200px;">
		<div id="student_menu" class="easyui-accordion" data-options="fit:true" style="height:400px;" >
			<div title="学生信息管理"  data-options="iconCls:'icon-menupic',selected:true" fit:true style="overflow: auto;">
				<ul id="student_menu_ui1" class="easyui-tree">  
					<li id="student_info_1" >  
                       		<span>学员信息 </span> 
                    </li>  
                    <li id="student_info_2" >  
                       		<span>财务登记</span> 
                    </li>  
                    <li id="student_info_3" >  
                       		<span>离校办理</span> 
                    </li>  
				</ul>
			</div>
			<div title="申请报修" fit:true data-options="iconCls:'icon-menupic'" >
				<ul id="student_menu_ui2" class="easyui-tree">  
					 <li id="student_repair_1">  
                        <span>公共设施报修</span>  
                    </li>  
                    <li id="student_repair_2">  
                        <span>寝室设施报修</span>  
                    </li>  
				</ul>
			</div>
			<div title="阳光服务平台" fit:true data-options="iconCls:'icon-menupic',selected:false" >
				<ul id="student_menu_ui3" class="easyui-tree">  
					 <li id="student_serve_1">  
                        <span>留言投诉</span>  
                    </li>
                     <li id="student_serve_2">  
                        <span>邮件投诉</span>  
                    </li>    
				</ul>
			
			</div>
		</div>
	</div>
	<div data-options="region:'east',split:true,collapsed:true,title:'帮助'"
		style="width: 100px; padding: 10px;">帮助区</div>
	<div data-options="region:'south',split:true" style="height: 50px; background: #9FDAEC; padding: 10px;padding-left:50px;">
			Copyright &copy; 2016 StudentApartment Incorporated Company. All rights reserved.<br />
				
	</div>
	<div
		data-options="region:'center',title:'操作',tools:[{
		iconCls:'icon-full',
		handler:function(){
			full();
		}
	},{
		iconCls:'icon-unfull',
		handler:function(){
			unFull();
		}
	}]">
		<div id="student_content_info" class="easyui-tabs"
			data-options="fit:true"></div>

	</div>
</body>
</html>

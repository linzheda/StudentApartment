$(function(){
	$('#admin_content_info').tabs('add',{    
		title:"公寓系统",    
		href:'zd.html',
		fit:true,
		closable:true,    
	});
	$('#admin_menu_ui1').tree({
		onClick: function(node){
			var id=node.id;//获取点击的节点id
			var title="公寓系统";
			var href="zd.html";
			var tabObj=$('#admin_content_info');
			if(id=="admin_info_1"){//学员信息注册
				if(tabObj.tabs('exists','学员信息注册')){
					tabObj.tabs('select','学员信息注册');
					return;
				}else{
					title="学员信息注册";
					href='admStuRegister.jsp';
				}

			}else if(id=="admin_info_2"){//学员信息管理
				if(tabObj.tabs('exists','学员信息管理')){
					tabObj.tabs('select','学员信息管理');
					return;
				}else{
					title="学员信息管理";
					href='admStuInfo.jsp';
				}
			}
			tabObj.tabs('add',{    
				title:title,    
				href:href,
				fit:true,
				closable:true,    
			});
		}
	});
	$('#admin_menu_ui2').tree({
		onClick: function(node){
			var id=node.id;//获取点击的节点id
			var title="公寓系统";
			var href="zd.html";
			var tabObj=$('#admin_content_info');
			if(id=="admin_repair_1"){//公共设施报修管理
				if(tabObj.tabs('exists','公寓管理')){
					tabObj.tabs('select','公寓管理');
					return;
				}else{
					title="公寓管理";
					href='apartment_manage.jsp';
				}
			}else if(id=="admin_repair_2"){
				if(tabObj.tabs('exists','寝室管理')){
					tabObj.tabs('select','寝室管理');
					return;
				}else{
					title="寝室管理";
					href='bedroom_manage.jsp';
				}
			}
			tabObj.tabs('add',{    
				title:title,    
				href:href,
				fit:true,
				closable:true,    
			});
		}
	});
	$('#admin_menu_ui3').tree({
		onClick: function(node){
			var id=node.id;//获取点击的节点id
			var title="公寓系统";
			var href="zd.html";
			var tabObj=$('#admin_content_info');
			if(id=="admin_serve_1"){//留言投诉
				if(tabObj.tabs('exists','留言回复')){
					tabObj.tabs('select','留言回复');
					return;
				}else{
					title="留言回复";
					href='message_manage.jsp';
				}
			}
			tabObj.tabs('add',{    
				title:title,    
				href:href,
				fit:true,
				closable:true,    
			});
		}
	});
	$('#admin_menu_ui4').tree({
		onClick: function(node){
			var id=node.id;//获取点击的节点id
			var title="公寓系统";
			var href="zd.html";
			var tabObj=$('#admin_content_info');
			if(id=="admin_visitor_1"){//来访登记
				if(tabObj.tabs('exists','来访登记')){
					tabObj.tabs('select','来访登记');
					return;
				}else{
					title="来访登记";
					href='visitor_register.jsp';
				}
			}else if(id=="admin_visitor_2"){
				if(tabObj.tabs('exists','来访信息管理')){
					tabObj.tabs('select','来访信息管理');
					return;
				}else{
					title="来访信息管理";
					href='visitor_manage.jsp';
				}
			}else if(id=="admin_visitor_3"){
				if(tabObj.tabs('exists','报表统计')){
					tabObj.tabs('select','报表统计');
					return;
				}else{
					title="报表统计";
					href='report.jsp';
				}
			}
			tabObj.tabs('add',{    
				title:title,    
				href:href,
				fit:true,
				closable:true,    
			});
		}
	});



})
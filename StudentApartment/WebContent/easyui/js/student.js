$(function(){
	$('#student_content_info').tabs('add',{    
		title:"公寓系统",    
		href:'zd.html',
		fit:true,
		closable:true,    
	});
	$('#student_menu_ui1').tree({
		onClick: function(node){
			var id=node.id;//获取点击的节点id
			var title="公寓系统";
			var href="zd.html";
			var tabObj=$('#student_content_info');
			if(id=="student_info_1"){//学员信息
				if(tabObj.tabs('exists','学员信息')){
					tabObj.tabs('select','学员信息');
					return;
				}else{
					title="学员信息";
					href='stuInfo.jsp';
				}

			}else if(id=="student_info_2"){//财务登记<
				if(tabObj.tabs('exists','财务登记')){
					tabObj.tabs('select','财务登记');
					return;
				}else{
					title="财务登记";
					href='stuMoney.jsp';
				}
			}else if(id=="student_info_3"){//离校办理
				if(tabObj.tabs('exists','离校办理')){
					tabObj.tabs('select','离校办理');
					return;
				}else{
					title="离校办理";
					href='stuLeave.jsp';
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
	$('#student_menu_ui2').tree({
		onClick: function(node){
			var id=node.id;//获取点击的节点id
			var title="公寓系统";
			var href="zd.html";
			var tabObj=$('#student_content_info');
			if(id=="student_repair_1"){//公共设施报修
				if(tabObj.tabs('exists','公共设施报修')){
					tabObj.tabs('select','公共设施报修');
					return;
				}else{
					title="公共设施报修";
					href='publicReport.jsp';
				}
			}else if(id=="student_repair_2"){
				if(tabObj.tabs('exists','寝室设施报修')){
					tabObj.tabs('select','寝室设施报修');
					return;
				}else{
					title="寝室设施报修";
					href='bedroomReport.jsp';
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
	$('#student_menu_ui3').tree({
		onClick: function(node){
			var id=node.id;//获取点击的节点id
			var title="公寓系统";
			var href="zd.html";
			var tabObj=$('#student_content_info');
			if(id=="student_serve_1"){//留言投诉
				if(tabObj.tabs('exists','留言投诉')){
					tabObj.tabs('select','留言投诉');
					return;
				}else{
					title="留言投诉";
					href='messageComplaints.jsp';
				}
			}else if(id=="student_serve_2"){//邮件投诉
				if(tabObj.tabs('exists','邮件投诉')){
					tabObj.tabs('select','邮件投诉');
					return;
				}else{
					title="邮件投诉";
					href='mailComplaints.jsp';
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
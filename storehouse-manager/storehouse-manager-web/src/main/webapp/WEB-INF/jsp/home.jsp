<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>仓储管理系统</title>
<%@ include file="/WEB-INF/jsp/easyui.jsp"%>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/clock.css" media="screen" type="text/css" />
 <script type="text/javascript"
	src="${pageContext.request.contextPath}/js/clock.js"></script>
<style type="text/css">
*{
padding:0;
margin:0;}
ul{
	list-style: none;
	
}
ul li{
}
table { border-collapse:separate; border-spacing:10px 20px; }

.but{
 width: 150px;  
        padding:8px;  
        background-color: #428bca;  
        border-color: #357ebd;  
        color: #fff;  
        -moz-border-radius: 10px;  
        -webkit-border-radius: 10px;  
        border-radius: 10px; /* future proofing */  
        -khtml-border-radius: 10px; /* for old Konqueror browsers */  
        text-align: center;  
        vertical-align: middle;  
        border: 1px solid transparent;  
        font-weight: 900;  
        font-size:125% 
font-style: oblique;
overflow: hidden;
}
.but:hover
{
    -moz-border-radius: 10px;
    -webkit-border-radius: 10px;
    border-radius: 10px;
    background-color: blue;
    color: white;
}
</style>
<script type="text/javascript">

function addTab(title, url){
	if ($('#layout_center_tabs').tabs('exists', title)){
		$('#layout_center_tabs').tabs('select', title);
	} else {
		var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
		$('#layout_center_tabs').tabs('add',{
			title:title,
			content:content,
			closable:true,
			loadingMessage: '正在加载...',
		    tools:[{
				iconCls:'icon-mini-refresh',
				handler:function(){
				
					layout_center_refreshTab(title);
				}
		    }],
		});
	}
}
function layout_center_refreshTab(title) {
	$('#layout_center_tabs').tabs('getTab', title).panel('refresh');
}
$(function() {	
	
	
	$('#layout_center_tabsMenu').menu({
		onClick : function(item) {
			var curTabTitle = $(this).data('tabTitle');
			var type = $(item.target).attr('type');

			if (type === 'refresh') {
				layout_center_refreshTab(curTabTitle);
				return;
			}

			if (type === 'close') {
				var t = $('#layout_center_tabs').tabs('getTab', curTabTitle);
				if (t.panel('options').closable) {
					$('#layout_center_tabs').tabs('close', curTabTitle);
				}
				return;
			}

			var allTabs = $('#layout_center_tabs').tabs('tabs');
			var closeTabsTitle = [];

			$.each(allTabs, function() {
				var opt = $(this).panel('options');
				if (opt.closable && opt.title != curTabTitle && type === 'closeOther') {
					closeTabsTitle.push(opt.title);
				} else if (opt.closable && type === 'closeAll') {
					closeTabsTitle.push(opt.title);
				}
			});

			for ( var i = 0; i < closeTabsTitle.length; i++) {
				$('#layout_center_tabs').tabs('close', closeTabsTitle[i]);
			}
		}
	});

	$('#layout_center_tabs').tabs({
		fit : true,
		border : false,
		onContextMenu : function(e, title) {
			e.preventDefault();
			$('#layout_center_tabsMenu').menu('show', {
				left : e.pageX,
				top : e.pageY
			}).data('tabTitle', title);
		},
		tools : [ {
			iconCls : 'icon-reload',
			handler : function() {
				var href = $('#layout_center_tabs').tabs('getSelected').panel('options').href;
				if (href) {/*说明tab是以href方式引入的目标页面*/
					var index = $('#layout_center_tabs').tabs('getTabIndex', $('#layout_center_tabs').tabs('getSelected'));
					$('#layout_center_tabs').tabs('getTab', index).panel('refresh');
				} else {/*说明tab是以content方式引入的目标页面*/
					var panel = $('#layout_center_tabs').tabs('getSelected').panel('panel');
					var frame = panel.find('iframe');
					try {
						if (frame.length > 0) {
							for ( var i = 0; i < frame.length; i++) {
								frame[i].contentWindow.document.write('');
								frame[i].contentWindow.close();
								frame[i].src = frame[i].src;
							}
							if ($.browser.msie) {
								CollectGarbage();
							}
						}
					} catch (e) {
					}
				}
			}
		}, {
			iconCls : 'icon-cancel',
			handler : function() {
				var index = $('#layout_center_tabs').tabs('getTabIndex', $('#layout_center_tabs').tabs('getSelected'));
				var tab = $('#layout_center_tabs').tabs('getTab', index);
				if (tab.panel('options').closable) {
					$('#layout_center_tabs').tabs('close', index);
				} else {
					$.messager.alert('提示', '[' + tab.panel('options').title + ']不可以被关闭', 'error');
				}
			}
		} ]
	});
	
	
	$(".but").on("click",function(){
	
		if($(this).text()=='仓库管理')
		{
		addTab($(this).text(),'${pageContext.request.contextPath}/storeManager/list.action');
		}else if($(this).text()=='货架管理'){
			addTab($(this).text(),'${pageContext.request.contextPath}/rackManager/list.action');
		}else if($(this).text()=='计费方式管理'){
			addTab($(this).text(),'${pageContext.request.contextPath}/calculateManager/list.action');
		}else if($(this).text()=='仓库类型管理'){
			addTab($(this).text(),'${pageContext.request.contextPath}/storeTypeManager/list.action');
		}else if($(this).text()=='规格参数'){
			addTab($(this).text(),'${pageContext.request.contextPath}/itemCatManager/list.action');
		}else if($(this).text()=='供应商'){
			addTab($(this).text(),'${pageContext.request.contextPath}/supplierManager/list.action');
		}else if($(this).text()=='客户'){
			addTab($(this).text(),'${pageContext.request.contextPath}/customerManager/list.action');
		}else if($(this).text()=='物品入库'){
			addTab($(this).text(),'${pageContext.request.contextPath}/inItemManager/list.action');
		}else if($(this).text()=='物品出库'){
			addTab($(this).text(),'${pageContext.request.contextPath}/outItemManager/list.action');
		}else if($(this).text()=='管理员管理'){
			addTab($(this).text(),'${pageContext.request.contextPath}/userManager/list.action');
		}else if($(this).text()=='权限管理'){
			addTab($(this).text(),'${pageContext.request.contextPath}/permissionManager/list.action');
		}else if($(this).text()=='角色管理'){
			addTab($(this).text(),'${pageContext.request.contextPath}/roleManager/list.action');
		}else if($(this).text()=='Druid监控'){
			addTab($(this).text(),'${pageContext.request.contextPath}/druid/list.action');
		}else if($(this).text()=='计量单位'){
			addTab($(this).text(),'${pageContext.request.contextPath}/measureunitManager/list.action');
		}else if($(this).text()=='产品入库统计表'){
			addTab($(this).text(),'${pageContext.request.contextPath}/echarts/inEchart.action');
		}else if($(this).text()=='产品出库统计表'){
			addTab($(this).text(),'${pageContext.request.contextPath}/echarts/outEchart.action');
		}else if($(this).text()=='产品移库统计表'){
			addTab($(this).text(),'${pageContext.request.contextPath}/echarts/moveEchart.action');
		}
		
		
		
	})

});

 changeTheme = function(themeName){  
	
	 var $easyuiTheme = $('#easyuiTheme');
	 
	
		var url = $easyuiTheme.attr('href');
	
		var href = url.substring(0, url.indexOf('themes')) + 'themes/' + themeName + '/easyui.css';
		$easyuiTheme.attr('href', href);
		
		var $iframe = $('iframe');
		if ($iframe.length > 0) {
			for ( var i = 0; i < $iframe.length; i++) {
				var ifr = $iframe[i];
				$(ifr).contents().find('#easyuiTheme').attr('href', href);
			}
		}

		$.cookie('easyuiThemeName', themeName, {
			expires : 7
		});
	}; 
//退出系统方法
function logout() {
	
	$.messager.confirm('询问', '您确定要删除退出？', function(b) {				 
		 
		if (b) {
			location.href = '${pageContext.request.contextPath}/logout.action';
		}
	});
}
	

</script>

</head>

<body class="easyui-layout" style="overflow-y: hidden;">

	<div style='background: repeat-x center 50% #EEEEEE; height: 30px; color: blue; line-height: 20px; overflow: hidden; font-family: Verdana, 微软雅黑, 黑体;'
		border="false" split="true" region="north">
		
		
		<SPAN style="padding-right: 20px; float: right;" class="head">
			欢迎当前用户：${activeUser.username}&nbsp;&nbsp;
			
			<A  class="easyui-menubutton" menu="#layout_north_pfMenu" iconCls="icon-ok">更换皮肤</A>
			<A class="easyui-linkbutton" >使用帮助</A>
			&nbsp;&nbsp;
			<A class="easyui-linkbutton" >修改密码</A>
			
			&nbsp;&nbsp;
			<A  class="easyui-linkbutton"  href=javascript:logout()>退出系统</A>

		</SPAN> 
		
		
		<SPAN style="padding-left: 10px; font-size: 16px;"><IMG
			align="absmiddle" src="images/blocks.gif" width="20" height="20">
			仓储管理系统</SPAN> <SPAN style="padding-left: 15px;" id="News"></SPAN>
	
		
		</div>
	
	<div data-options="region:'east',title:'东部',split:true"
		style="width: 20%">
		
	<div class="easyui-calendar" style="width:100%;height:100%;"></div>
		
		</div>
	<div data-options="region:'west',title:'功能导航',split:true"
		style="width: 16%">

		<div class="easyui-accordion" data-options="fit:true,border:false">
			
			<div title="仓库管理">
				<ul >
					
					<li><div class="but" ><a>仓库管理</a></div></li>					
					<li><div class="but"><a>物品入库</a></div></li>
					<li><div class="but"><a>物品出库</a></div></li>
					<li><div class="but"><a>计费方式管理</a></div></li>
					<li><div class="but"><a>货架管理</a></div></li>
					<li><div class="but"><a>仓库类型管理</a></div></li>
					<li><div class="but" id="param"><a>规格参数</a></div></li>
				</ul>
			</div>
			<div title="报表系统">
				<ul id="layout_west_tree3">
					<li><div class="but"><a>产品入库统计表</a></div></li>
					<li><div class="but"><a>产品出库统计表</a></div></li>
					<li><div class="but"><a>产品移库统计表</a></div></li>
				
				</ul>
			</div> 
			<div title="货物单位管理">
				<ul id="layout_west_tree4">
					<li><div class="but"><a>计量单位</a></div></li>
				</ul>
			</div>
			<div title="管理员管理">
				<ul id="layout_west_tree5">
				<li><div class="but"><a>管理员管理</a></div></li>
				<li><div class="but"><a>权限管理</a></div></li>
				<li><div class="but"><a>角色管理</a></div></li>
				</ul>
			</div>
			<!-- <div title="盘点">
				<ul id="layout_west_tree6">
					
					<li><div class="but"><a>月盘点</a></div></li>
					<li><div class="but"><a>年度盘点</a></div></li>
				</ul>
			</div> -->
			<div title="往来单位">
				<ul >
					<li><div class="but"><a>供应商</a></div></li>					
					<li><div class="but"><a>客户</a></div></li>
				</ul>
			</div>
			<div title="系统基本设置">
				
				
				<ul >
					<li><div class="but"><a>Druid监控</a></div></li>
				</ul>
			</div>
		</div>
		
		
	</div>
	<div id="layout_center_tabs" class="easyui-tabs" data-options="region:'center',fit:false "
		style="background: #eee;">
		
		<div title="首页" data-options="fit:true,border:false" href="${pageContext.request.contextPath}/portal.action" style="overflow: hidden;"></div>
		
		</div>
<div id="layout_center_tabsMenu" style="width: 120px;display:none;">
	<div type="refresh">刷新</div>
	<div class="menu-sep"></div>
	<div type="close">关闭</div>
	<div type="closeOther">关闭其他</div>
	<div type="closeAll">关闭所有</div>
</div>
<div id="layout_north_pfMenu" style="width: 120px; display: none;">
	<div onclick="changeTheme('default');">default</div>
	<div onclick="changeTheme('gray');">gray</div>
	<div onclick="changeTheme('cupertino');">cupertino</div>
	<div onclick="changeTheme('dark-hive');">dark-hive</div>
	<div onclick="changeTheme('pepper-grinder');">pepper-grinder</div>
	<div onclick="changeTheme('sunny');">sunny</div>
	<div onclick="changeTheme('metro');">metro</div>
	<div onclick="changeTheme('bootstrap');">bootstrap</div>
	<div onclick="changeTheme('black');">black</div>
	<div onclick="changeTheme('metro-blue');">metro-blue</div>
</div>
</body>

</html>
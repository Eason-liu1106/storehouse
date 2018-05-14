<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<!DOCTYPE HTML >
<html>
<head>
<%@ include file="/WEB-INF/jsp/easyui.jsp"%>
<script type="text/javascript" charset="utf-8">
	var user_searchForm;
	
	var user_datagrid; 
	$(function() {
		user_searchForm = $('#user_searchForm').form();
		
		user_datagrid = $('#user_datagrid').datagrid({
	
			url : '${pageContext.request.contextPath}/user/list.action',
			title : '管理员列表',
			fit : true,
			fitColumns : false,
			border : false,
			pagination : true,
			idField : 'id',
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			sortName : 'name',
			sortOrder : 'desc',
		
			nowrap : true,
			frozenColumns : [ [ {
				field : 'id',
				title : '编号',
				width : 150,
				checkbox : true
			}, {
				field : 'username',
				title : '登录名称',
				width : 100,
				sortable : true
			} ] ],
			columns : [ [ {
				field : 'password',
				title : '密码',
				width : 60,
				formatter : function(value, row, index) {
					return '******';
				}
			}, {
				field : 'salt',
				title : '备注',
				width : 100,
				sortable : true
			} ,{
				field : 'roleIds',
				title : '拥有角色ID',
				width : 150,
				hidden : true
			}, {
				field : 'roleNames',
				title : '拥有角色',
				width : 150,
			},{
				field : 'locked',
				title : '状态',
				width : 100,
				sortable : true
			} ] ],
				//列表结束			
				//工具条
				
				toolbar : [ {
					text : '增加',
					iconCls : 'icon-add',
					handler : function() {
						//parent.add();
						user_add();
					}
				}, '-', {
					text : '删除',
					iconCls : 'icon-remove',
					handler : function() {
						user_del();
					}
				}, '-', {
					text : '修改',
					iconCls : 'icon-edit',
					handler : function() {
						user_edit();
					}
				}, '-', {
					text : '保存',
					iconCls : 'icon-save',
					handler : function() {
						if (editRow != undefined) {
							user_datagrid.datagrid('endEdit', editRow);
						}
					}
				},
				 
				'-', {
					text : '取消编辑',
					iconCls : 'icon-undo',
					handler : function() {
						user_datagrid.datagrid('unselectAll');
						user_datagrid.datagrid.datagrid('rejectChanges');
						editRow = undefined;
					}
				},  '-', {
					text : '查看',
					iconCls : 'icon-search',
					handler : function() {
						edit();
					}
				},'-', {
					text : '取消选中',
					iconCls : 'icon-undo',
					handler : function() {
						user_datagrid.datagrid('unselectAll');
					}
				},
			],
		//工具条结束
			//方法
		onLoadSuccess:function(data){  
            $(".tip").tooltip({  
                onShow: function(){  
                    $(this).tooltip('tip').css({   
                        width:'300',          
                        boxShadow: '1px 1px 3px #292929'                          
                    });  
                }  
            });  
		},
		
		});	
		
	});
	function user_del(){
		var rows = user_datagrid.datagrid('getSelections');
		var ids = [];
		var copyRows = [];
       
		 if (rows == null) {  
		        $.messager.show("提示", "请选择要删除的行！");  
		    } else{
		    	for ( var j= 0; j < rows.length; j++) {
		            ids.push(rows[j].id);
		            }
		    	$.messager.confirm('询问', '您确定要删除【' + rows.length + '】个管理员', function(b) {				 
			 
		    		if (b) {
						$.ajax({
							url : '${pageContext.request.contextPath}/user/delete.action?ids='+ids+'',
							
							cache : false,
							dataType : 'JSON',
							success : function(r) {
								if (r.status='200') {
									
									 for ( var j= 0; j < rows.length; j++) {
									        copyRows.push(rows[j]);
									        						}
									     for(var i =0;i<copyRows.length;i++){    
									            var index = user_datagrid.datagrid('getRowIndex',copyRows[i]);
									            user_datagrid.datagrid('deleteRow',index); 
									        }
									     user_datagrid.datagrid('reload');
									user_datagrid.datagrid('clearSelections'); //清空选中的行 
									$.messager.show({
										msg : r.msg,
										title : '提示'
									});
								}else if(r.status='404')
									{
									$.messager.show({
										msg : r.msg,
										title : '提示'
									});
									}
								
							}
						});
					}
		    	
		    	});
			 
		    }
	}

	function user_edit() {
		
		var rows = user_datagrid.datagrid('getSelections');
		
		
		if (rows.length >1) {
			var names = [];
			for ( var i = 0; i < rows.length; i++) {
				names.push(rows[i].name);
			}
			$.messager.show({
				msg : '只能择一个管理员进行编辑！您已经选择了【' + rows.length + '】个管理员',
				title : '提示'
			});
		} else if (rows.length == 1) {
			var node = user_datagrid.datagrid('getSelected');
			var d=$('<div/>').dialog({
				href : '${pageContext.request.contextPath}/userManager/edit.action',
				width : 500,
				height : 380,
				modal : true,
				title : '编辑管理员',
				loadingMessage: '正在加载...',  
				buttons : [ {
					text : '确定',
					iconCls : 'icon-edit',
					handler : function() {
						
						$('#editUser').form('submit', {
							url : '${pageContext.request.contextPath}/user/edit.action',
							success : function(result) {
								
									var r = $.parseJSON(result);
									
									if(r.status='200') 
									{
										
										$.messager.show({
											title : '提示',
											msg : r.msg
										});
										user_datagrid.datagrid('reload');
										d.dialog('destroy');
									}
									
									else if(r.status='404'){
										$.messager.alert({
											title : '警告',
											msg : r.msg
										});
									}else{
										$.messager.show({
											title : '提示',
											msg : '服务器正忙,请稍后修改'
										});
									}
								
							}
						});
					}
				
				} ],
				onClose : function() {
					d.dialog("destroy");
				},
				onLoad : function() {
					$('#editUser').form('load', node);
				}
			});
			
		}else{
			$.messager.show({
				msg : '请选择一个管理员进行编辑!',
				title : '提示'
			});
		}
	}
	function user_add() {
		
		
		var d=$('<div/>').dialog({
			href : '${pageContext.request.contextPath}/userManager/add.action',
			width : 500,
			height : 380,
			modal : true,
			title : '添加管理员',
			loadingMessage: '正在加载...',  
			buttons : [ {
				text : '增加',
				iconCls : 'icon-ok',
				handler : function() {
							
					$('#addUser').form('submit', {
						url : '${pageContext.request.contextPath}/user/add.action',
						success : function(result) {
							
								var r = $.parseJSON(result);
								
								if(r.status='200')
								{
									
									$.messager.show({
										title : '提示',
										msg : r.msg
									});
									user_datagrid.datagrid('reload');
									d.dialog('destroy');
								}
								
								else if(r.status='404'){
									$.messager.alert({
										title : '警告',
										msg : r.msg
									});
								}else{
									$.messager.show({
										title : '提示',
										msg : '服务器正忙,请稍后添加'
									});
								}
							
						}
					});
				}
			} ],
			onClose : function() {
				d.dialog("destroy");
			}
		});
	}
	function user_search() {
		user_datagrid.datagrid('load',  serializeObject(user_searchForm));
	}
	function user_cleanSearch() {
		user_datagrid.datagrid('load', {});
		user_searchForm.find('input').val('');
	}
	
	serializeObject = function(form) {
		var o = {};
		$.each(form.serializeArray(), function(index) {
			if (o[this['name']]) {
				o[this['name']] = o[this['name']] + "," + this['value'];
			} else {
				o[this['name']] = this['value'];
			}
		});
		return o;
	};
var	formatterdate = function(value){
	
		 var date = new Date(value);
        var y = date.getFullYear();
        var M = date.getMonth() + 1;
        var d = date.getDate();
        var h = date.getHours();//hour 
        var m = date.getMinutes(); //minute 
        var s = date.getSeconds(); //second 
        return y + '-' +M + '-' + d+ ' ' + h+ ':' + m+ ':' + s;
	 
};

</script>
</head>

<body class="easyui-layout">
	<div region="north" border="false" title="过滤条件" style="height: 110px;overflow: hidden;" align="left">
		<form id="user_searchForm">
			<table class="tableForm datagrid-toolbar" style="width: 100%;height: 100%;">
				<tr>
					<th>管理员名</th>
					<td><input name="name" style="width:315px;" /></td>
				</tr>
				<tr>
					<th>创建时间</th>
					<td><input name="createdatetimeStart" class="easyui-datetimebox" editable="false" style="width: 155px;" />至<input name="createdatetimeEnd" class="easyui-datetimebox" editable="false" style="width: 155px;" /></td>
				</tr>
				<tr>
					<th>最后修改时间</th>
					<td><input name="modifydatetimeStart" class="easyui-datetimebox" editable="false" style="width: 155px;" />至<input name="modifydatetimeEnd" class="easyui-datetimebox" editable="false" style="width: 155px;" /><a href="javascript:void(0);" class="easyui-linkbutton" onclick="user_search();">过滤</a><a href="javascript:void(0);" class="easyui-linkbutton" onclick="user_cleanSearch();">取消</a></td>
				</tr>
			</table>
		</form>
	</div>
	<div region="center" border="false">
		<table id="user_datagrid"></table>
	</div> 

</body>
</html>
		


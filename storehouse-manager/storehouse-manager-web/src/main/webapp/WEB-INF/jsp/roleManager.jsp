<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/jsp/easyui.jsp"%>
<script type="text/javascript" charset="utf-8">
var role_searchForm;
var role_datagrid; 
$(function() {
	role_searchForm = $('#role_searchForm').form();
	
	role_datagrid = $('#role_datagrid').datagrid({

		url : '${pageContext.request.contextPath}/role/list.action',
		title : '角色列表',
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
			field : 'name',
			title : '角色名称',
			width : 100,
			sortable : true
		} ] ],
		columns : [ [  {
			field : 'permissionNames',
			title : '拥有权限',
			width : 250,
			formatter:function(value,row){  
		        var description = '<li title="' + value + '" class="tip">' + value + '</li>';  
		        return description;  
		        }  ,
		},{
			field : 'available',
			title : '是否有效',
			width : 150,
			formatter : function(value, row, index) {
				if(value!=null)
					{ 
						if(value='1')
							return '有效';
						else
							return '无效'
					}
			
			}
		}, ] ],
			//列表结束
			
			
		//方法
	onRowContextMenu : function(e, rowIndex, rowData) {
				e.preventDefault();
				$(this).datagrid('unselectAll');
				$(this).datagrid('selectRow', rowIndex);
				$('#menu').menu('show', {
					left : e.pageX,
					top : e.pageY
				});
			},
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
			
			
			
			//工具条
			
			toolbar : [ {
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					
					role_add();
				}
			}, '-', {
				text : '删除',
				iconCls : 'icon-remove',
				handler : function() {
					role_del();
				}
			}, '-', {
				text : '修改',
				iconCls : 'icon-edit',
				handler : function() {
					role_edit();
				}
			}, '-', {
				text : '保存',
				iconCls : 'icon-save',
				handler : function() {
					if (editRow != undefined) {
						role_datagrid.datagrid('endEdit', editRow);
					}
				}
			},
			 
			'-', {
				text : '取消编辑',
				iconCls : 'icon-undo',
				handler : function() {
					role_datagrid.datagrid('unselectAll');
					role_datagrid.datagrid.datagrid('rejectChanges');
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
					role_datagrid.datagrid('unselectAll');
				}
			},
		],
	//工具条结束
	
	
	});	
	
});
function role_del(){
	var rows = role_datagrid.datagrid('getSelections');
	var ids = [];
	var copyRows = [];
   
	 if (rows == null) {  
	        $.messager.show("提示", "请选择要删除的行！");  
	    } else{
	    	for ( var j= 0; j < rows.length; j++) {
	            ids.push(rows[j].id);
	            }
	    	$.messager.confirm('询问', '您确定要删除【' + rows.length + '】个角色', function(b) {				 
		 
	    		if (b) {
					$.ajax({
						url : '${pageContext.request.contextPath}/role/delete.action?ids='+ids+'',
						
						cache : false,
						dataType : 'JSON',
						success : function(r) {
							if (r.status='200') {
								
								 for ( var j= 0; j < rows.length; j++) {
								        copyRows.push(rows[j]);
								        						}
								     for(var i =0;i<copyRows.length;i++){    
								            var index = role_datagrid.datagrid('getRowIndex',copyRows[i]);
								            role_datagrid.datagrid('deleteRow',index); 
								        }
								     role_datagrid.datagrid('reload');
								//role_datagrid.datagrid('clearSelections'); //清空选中的行 
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

function role_edit() {
	
	var rows = role_datagrid.datagrid('getSelections');
	
	
	if (rows.length >1) {
		var names = [];
		for ( var i = 0; i < rows.length; i++) {
			names.push(rows[i].name);
		}
		$.messager.show({
			msg : '只能择一个角色进行编辑！您已经选择了【' + names.join(',') + '】' + rows.length + '个角色',
			title : '提示'
		});
	} else if (rows.length == 1) {
		var node = role_datagrid.datagrid('getSelected');
		var d=$('<div/>').dialog({
			href : '${pageContext.request.contextPath}/roleManager/edit.action',
			width : 500,
			height : 380,
			modal : true,
			title : '编辑角色',
			loadingMessage: '正在加载...',  
			buttons : [ {
				text : '确定',
				iconCls : 'icon-edit',
				handler : function() {
					
					$('#editRole').form('submit', {
						url : '${pageContext.request.contextPath}/role/edit.action',
						success : function(result) {
							
								var r = $.parseJSON(result);
								
								if(r.status='200') 
								{
									
									$.messager.show({
										title : '提示',
										msg : r.msg
									});
									role_datagrid.datagrid('reload');
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
				$('#editRole').form('load', node);
			}
		});
		
	}else{
		$.messager.show({
			msg : '请选择一个角色进行编辑!',
			title : '提示'
		});
	}
}
function role_add() {
	
	
	var d=$('<div/>').dialog({
		href : '${pageContext.request.contextPath}/roleManager/add.action',
		width : 500,
		height : 380,
		modal : true,
		title : '添加角色',
		loadingMessage: '正在加载...',  
		buttons : [ {
			text : '增加',
			iconCls : 'icon-ok',
			handler : function() {
				//$(this).closest('.window-body').dialog("close");
				//var d = $(this).closest('.window-body');					
				$('#addRole').form('submit', {
					url : '${pageContext.request.contextPath}/role/add.action',
					success : function(result) {
						
							var r = $.parseJSON(result);
							
							if(r.status='200')
							{
								
								$.messager.show({
									title : '提示',
									msg : r.msg
								});
								role_datagrid.datagrid('reload');
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
function role_search() {
	role_datagrid.datagrid('load',  serializeObject(role_searchForm));
}
function role_cleanSearch() {
	role_datagrid.datagrid('load', {});
	role_searchForm.find('input').val('');
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
	<form id="role_searchForm">
		<table class="tableForm datagrid-toolbar" style="width: 100%;height: 100%;">
			<tr>
				<th>角色名</th>
				<td><input name="name" style="width:315px;" /></td>
			</tr>
			<tr>
				<th>创建时间</th>
				<td><input name="createdatetimeStart" class="easyui-datetimebox" editable="false" style="width: 155px;" />至<input name="createdatetimeEnd" class="easyui-datetimebox" editable="false" style="width: 155px;" /></td>
			</tr>
			<tr>
				<th>最后修改时间</th>
				<td><input name="modifydatetimeStart" class="easyui-datetimebox" editable="false" style="width: 155px;" />至<input name="modifydatetimeEnd" class="easyui-datetimebox" editable="false" style="width: 155px;" /><a href="javascript:void(0);" class="easyui-linkbutton" onclick="role_search();">过滤</a><a href="javascript:void(0);" class="easyui-linkbutton" onclick="role_cleanSearch();">取消</a></td>
			</tr>
		</table>
	</form>
</div>
<div region="center" border="false">
	<table id="role_datagrid"></table>
</div> 

	<div id="menu" class="easyui-menu" style="width:120px;display: none;">
		<div onclick="role_add();" iconCls="icon-add">增加</div>
		<div onclick="role_del();" iconCls="icon-remove">删除</div>
		<div onclick="role_edit();" iconCls="icon-edit">编辑</div>
	</div>
</body>
</html>
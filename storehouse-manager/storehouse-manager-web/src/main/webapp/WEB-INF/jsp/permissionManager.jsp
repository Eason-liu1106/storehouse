<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/jsp/easyui.jsp"%>
<script type="text/javascript" charset="utf-8">
var editRow;
var editType;/*add or edit or undefined*/
var treegrid;
$(function() {

	treegrid = $('#treegrid').treegrid({
		url : '${pageContext.request.contextPath}/permission/tree.action',		
		
		title : '',
		iconCls : 'icon-save',
		fit : true,
		fitColumns : false,
		nowrap : false,
		animate : false,
		border : false,
		idField : 'id',
		treeField : 'name',
		frozenColumns : [ [ {
			title : 'id',
			field : 'id',
			width : 150,
			hidden : true
		}, {
			field : 'name',
			title : '权限名称',
			width : 200,
			editor : {
				type : 'validatebox',
				options : {
					required : true
				}
			},
			
		} ] ],
		columns : [ [  {
			field : 'url',
			title : '地址',
			width : 200,
			editor : {
				type : 'text'
			},
			
		}, {
			field : 'percode',
			title : '权限说明',
			width : 150,
			editor : {
				type : 'validatebox',
				options : {
					required : true
				}
			},
			
		},{
			field : 'type',
			title : '类型',
			width : 150,
			editor : {
				type : 'validatebox',
				options : {
					required : true
				}
			},
			
		},{
			field : 'parentid',
			title : '父id',
			width : 150,
			hidden : true
		
		},{
			field : 'available',
			title : '是否有效',
			width : 150,
			editor : {
				type : 'validatebox',
				options : {
					required : true
				}
			},
			formatter : function(value) {
				if (value) {
					if(value=="1")
					{
						return "有效";
					}else{
						return "无效"
					}
				}
			}
			
		}, ] ],
		
		
		//开始了
		onDblClickRow : function(row) {
				if (editRow != undefined) {
					treegrid.treegrid('endEdit', editRow.id);
				}

				if (editRow == undefined) {
					treegrid.treegrid('beginEdit', row.id);
					editRow = row;
					editType = 'edit';
					treegrid.treegrid('unselectAll');
				}
			},
			onAfterEdit : function(row, changes) {
				if (editType == undefined) {
					editRow = undefined;
					treegrid.treegrid('unselectAll');
					return;
				}

				var url = '';
				if (editType == 'add') {
					url = '${pageContext.request.contextPath}/permission/add.action';
				}
				if (editType == 'edit') {
					url = '${pageContext.request.contextPath}/permission/edit.action';
				}

				$.ajax({
					url : url,
					data : row,
					dataType : 'json',
					success : function(r) {
						if (r.success) {
							treegrid.treegrid('reload');

							$.messager.show({
								msg : r.msg,
								title : '成功'
							});
							editRow = undefined;
							editType = undefined;
						} else {
							/*datagrid.datagrid('rejectChanges');*/
							treegrid.treegrid('beginEdit', editRow.id);
							$.messager.alert('错误', r.msg, 'error');
						}
						treegrid.treegrid('unselectAll');
					}
				});

			},
			
			
			
			//toolbar
			
			toolbar : [ {
				text : '展开',
				iconCls : 'icon-redo',
				handler : function() {
					var node = treegrid.treegrid('getSelected');
					if (node) {
						treegrid.treegrid('expandAll', node.id);
					} else {
						treegrid.treegrid('expandAll');
					}
				}
			}, '-', {
				text : '折叠',
				iconCls : 'icon-undo',
				handler : function() {
					var node = treegrid.treegrid('getSelected');
					if (node) {
						treegrid.treegrid('collapseAll', node.id);
					} else {
						treegrid.treegrid('collapseAll');
					}
				}
			}, '-', {
				text : '刷新',
				iconCls : 'icon-reload',
				handler : function() {
					editRow = undefined;
					editType = undefined;
					treegrid.treegrid('reload');
				}
			}, '-', {
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					append();
				}
			}, '-', {
				text : '删除',
				iconCls : 'icon-remove',
				handler : function() {
					remove();
				}
			}, '-', {
				text : '编辑',
				iconCls : 'icon-edit',
				handler : function() {
					edit();
				}
			}, '-', {
				text : '保存',
				iconCls : 'icon-save',
				handler : function() {
					if (editRow != undefined) {
						treegrid.treegrid('endEdit', editRow.id);
					}
				}
			}, '-', {
				text : '取消编辑',
				iconCls : 'icon-undo',
				handler : function() {
					if (editRow) {
						treegrid.treegrid('cancelEdit', editRow.id);
						var p = treegrid.treegrid('getParent', editRow.id);
						if (p) {
							treegrid.treegrid('reload', p.id);
						} else {
							treegrid.treegrid('reload');
						}
						editRow = undefined;
						editType = undefined;
					}
				}
			}, '-', {
				text : '取消选中',
				iconCls : 'icon-undo',
				handler : function() {
					treegrid.treegrid('unselectAll');
				}
			}, '-' ],
			onContextMenu : function(e, row) {
				e.preventDefault();
				$(this).treegrid('unselectAll');
				$(this).treegrid('select', row.id);
				$('#menu').menu('show', {
					left : e.pageX,
					top : e.pageY
				});
			},
			onLoadSuccess : function(row, data) {
				/*var t = $(this);
				if (data) {
					$(data).each(function(index, d) {
						if (this.state == 'closed') {
							t.treegrid('expandAll');
						}
					});
				}*/
			},
			onExpand : function(row) {
				treegrid.treegrid('unselectAll');
			},
			onCollapse : function(row) {
				treegrid.treegrid('unselectAll');
			}
		
	});

});





function edit() {
	var node = treegrid.treegrid('getSelected');
	if (node && node.id) {
		if (editRow != undefined) {
			treegrid.treegrid('endEdit', editRow.id);
		}

		if (editRow == undefined) {
			treegrid.treegrid('beginEdit', node.id);
			editRow = node;
			editType = 'edit';
		}
	} else {
		$.messager.show({
			msg : '请选择一项进行修改！',
			title : '错误'
		});
	}
}
function append() {
	if (editRow != undefined) {
		treegrid.treegrid('endEdit', editRow.id);
	}

	if (editRow == undefined) {
		var node = treegrid.treegrid('getSelected');
		var row = [ {
			id : sy.UUID(),
			name : '权限名称',
			url : '',
			cseq : 10,
			cdesc : '描述信息',
			parentid : node == null ? '' : node.id
		} ];
		treegrid.treegrid('append', {
			parent : node == null ? '' : node.id,
			data : row
		});

		editRow = row[0];
		editType = 'add';
		treegrid.treegrid('select', editRow.id);
		treegrid.treegrid('beginEdit', editRow.id);
	}
}
function remove() {
	var node = treegrid.treegrid('getSelected');
	if (node) {
		$.messager.confirm('询问', '您确定要删除【' + node.name + '】？', function(b) {
			if (b) {
				$.ajax({
					url : '${pageContext.request.contextPath}/permission/delete.action',
					data : {
						id : node.id
					},
					cache : false,
					dataType : "json",
					success : function(r) {
						if (r.status='200') {
							
							$.messager.show({
								msg : r.msg,
								title : '提示'
							});
							treegrid.treegrid('reload');
							editRow = undefined;
						} else {
							$.messager.show({
								msg : '删除失败!',
								title : '提示'
							});
						}
					}
				});
			}
		});
	}
}
</script>
</head>
<body class="easyui-layout" fit="true">
<div region="center" border="false" style="overflow: hidden;">
	<table id="treegrid"></table>
</div>

<div id="menu" class="easyui-menu" style="width:120px;display: none;">
	<div onclick="append();" iconCls="icon-add">增加</div>
	<div onclick="remove();" iconCls="icon-remove">删除</div>
	<div onclick="edit();" iconCls="icon-edit">编辑</div>
</div>
</body>
</html>
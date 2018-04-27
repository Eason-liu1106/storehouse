<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<!DOCTYPE HTML >
<html>
<head>
<%@ include file="/WEB-INF/jsp/easyui.jsp"%>
<script type="text/javascript" charset="utf-8">
	var rack_searchForm;
	var editRow = undefined;
	var rack_datagrid; 
	
	
	$(function() {
		
		rack_searchForm = $('#rack_searchForm').form();
			
		rack_datagrid = $('#rack_datagrid').datagrid({
	
			url : '${pageContext.request.contextPath}/rack/list.action',
			title : '货架列表',
			iconCls : 'icon-save',
			pagination : true,
			pagePosition : 'bottom',
			pageSize : 10,
			pageList : [ 10, 20, 30, 40 ],
			fit : true,
			fitColumns : false,
			nowrap : true,
			border : false,
			idField : 'id',
			sortName : 'name',
			sortOrder : 'desc',
			
			//列表
			frozenColumns : [ [ {
				title : '编号',
				field : 'id',
				width : 120,
				sortable : true,
				checkbox : true
			}, {
				title : '货架名',
				field : 'name',
				width : 100,
				sortable : true,
				
			} ] ],
			columns : [ [ 
			{ 
				title : '货架参数',
				field : 'parm',
				width : 200,
				formatter:function(value,row){  
			        var parm = '<li title="' + value + '" class="tip">' + value + '</li>';  
			        return parm;  
			        }  ,
				
			},
			{
				title : '创建时间',
				field : 'createdatetime', 
				sortable : true,
				width : 150,
				formatter : function(value){ 
					 return formatterdate(value);
				 }
			}, {
				title : '最后修改时间',
				field : 'modifydatetime',
				sortable : true,
				width : 150,
				 formatter : function(value){ 
					 return formatterdate(value);
				 }
			}
				] ],
				//列表结束
				
				
				//工具条
				
				toolbar : [ {
					text : '增加',
					iconCls : 'icon-add',
					handler : function() {
						//parent.add();
						rack_add();
					}
				}, '-', {
					text : '删除',
					iconCls : 'icon-remove',
					handler : function() {
						rack_del();
					}
				}, '-', {
					text : '修改',
					iconCls : 'icon-edit',
					handler : function() {
						rack_edit();
					}
				}, '-', {
					text : '保存',
					iconCls : 'icon-save',
					handler : function() {
						if (editRow != undefined) {
							rack_datagrid.datagrid('endEdit', editRow);
						}
					}
				},
				 
				'-', {
					text : '取消编辑',
					iconCls : 'icon-undo',
					handler : function() {
						rack_datagrid.datagrid('unselectAll');
						rack_datagrid.datagrid.datagrid('rejectChanges');
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
						rack_datagrid.datagrid('unselectAll');
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
	function rack_del(){
		var rows = rack_datagrid.datagrid('getSelections');
		var ids = [];
		var copyRows = [];
       
		 if (rows == null) {  
		        $.messager.show("提示", "请选择要删除的行！");  
		    } else{
		    	for ( var j= 0; j < rows.length; j++) {
		            ids.push(rows[j].id);
		            }
		    	$.messager.confirm('询问', '您确定要删除【' + rows.length + '】？个货架', function(b) {				 
			 
		    		if (b) {
						$.ajax({
							url : '${pageContext.request.contextPath}/rack/delete.action?ids='+ids+'',
							
							cache : false,
							dataType : 'JSON',
							success : function(r) {
								if (r.status='200') {
									
									 for ( var j= 0; j < rows.length; j++) {
									        copyRows.push(rows[j]);
									        						}
									     for(var i =0;i<copyRows.length;i++){    
									            var index = rack_datagrid.datagrid('getRowIndex',copyRows[i]);
									            rack_datagrid.datagrid('deleteRow',index); 
									        }
									     rack_datagrid.datagrid('reload');
									//rack_datagrid.datagrid('clearSelections'); //清空选中的行 
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

	function rack_edit() {
		
		var rows = rack_datagrid.datagrid('getSelections');
		
		
		if (rows.length >1) {
			var names = [];
			for ( var i = 0; i < rows.length; i++) {
				names.push(rows[i].name);
			}
			$.messager.show({
				msg : '只能择一个货架进行编辑！您已经选择了【' + names.join(',') + '】' + rows.length + '个货架',
				title : '提示'
			});
		} else if (rows.length == 1) {
			var node = rack_datagrid.datagrid('getSelected');
			var d=$('<div/>').dialog({
				href : '${pageContext.request.contextPath}/rackManager/edit.action',
				width : 500,
				height : 380,
				modal : true,
				title : '编辑货架',
				loadingMessage: '正在加载...',  
				buttons : [ {
					text : '确定',
					iconCls : 'icon-edit',
					handler : function() {
						
						$('#editRack').form('submit', {
							url : '${pageContext.request.contextPath}/rack/edit.action',
							success : function(result) {
								
									var r = $.parseJSON(result);
									
									if(r.status='200') 
									{
										
										$.messager.show({
											title : '提示',
											msg : r.msg
										});
										rack_datagrid.datagrid('reload');
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
					$('#editRack').form('load', node);
				}
			});
			
		}else{
			$.messager.show({
				msg : '请选择一个货架进行编辑!',
				title : '提示'
			});
		}
	}
	function rack_add() {
		
		
		var d=$('<div/>').dialog({
			href : '${pageContext.request.contextPath}/rackManager/add.action',
			width : 500,
			height : 380,
			modal : true,
			title : '添加货架',
			loadingMessage: '正在加载...',  
			buttons : [ {
				text : '增加',
				iconCls : 'icon-ok',
				handler : function() {
					//$(this).closest('.window-body').dialog("close");
					//var d = $(this).closest('.window-body');					
					$('#addRack').form('submit', {
						url : '${pageContext.request.contextPath}/rack/add.action',
						success : function(result) {
							
								var r = $.parseJSON(result);
								
								if(r.status='200')
								{
									
									$.messager.show({
										title : '提示',
										msg : r.msg
									});
									rack_datagrid.datagrid('appendRow',r.data);
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
	function rack_search() {
		rack_datagrid.datagrid('load',  serializeObject(rack_searchForm));
	}
	function rack_cleanSearch() {
		rack_datagrid.datagrid('load', {});
		rack_searchForm.find('input').val('');
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
		<form id="rack_searchForm">
			<table class="tableForm datagrid-toolbar" style="width: 100%;height: 100%;">
				<tr>
					<th>租金名</th>
					<td><input name="name" style="width:315px;" /></td>
				</tr>
				<tr>
					<th>创建时间</th>
					<td><input name="createdatetimeStart" class="easyui-datetimebox" editable="false" style="width: 155px;" />至<input name="createdatetimeEnd" class="easyui-datetimebox" editable="false" style="width: 155px;" /></td>
				</tr>
				<tr>
					<th>最后修改时间</th>
					<td><input name="modifydatetimeStart" class="easyui-datetimebox" editable="false" style="width: 155px;" />至<input name="modifydatetimeEnd" class="easyui-datetimebox" editable="false" style="width: 155px;" /><a href="javascript:void(0);" class="easyui-linkbutton" onclick="rack_search();">过滤</a><a href="javascript:void(0);" class="easyui-linkbutton" onclick="rack_cleanSearch();">取消</a></td>
				</tr>
			</table>
		</form>
	</div>
	<div region="center" border="false">
		<table id="rack_datagrid"></table>
	</div>
	
	
</body>
</html>
	

		


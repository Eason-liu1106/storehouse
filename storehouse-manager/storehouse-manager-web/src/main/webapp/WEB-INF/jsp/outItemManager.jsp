<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<!DOCTYPE HTML >
<html>
<head>
<%@ include file="/WEB-INF/jsp/easyui.jsp"%>
<script type="text/javascript" charset="utf-8">
	var outItem_searchForm;
	var d;
	var outItem_datagrid; 
	$(function() {
		outItem_searchForm = $('#outItem_searchForm').form();		
		outItem_datagrid = $('#outItem_datagrid').datagrid({
	
			url : '${pageContext.request.contextPath}/outItem/list.action',
			title : '商品出库列表',
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
			}] ],
			columns : [ [ {
				title : '出库仓库',
				field : 'outStoreName',
				width : 100,
				
			},
			{
				title : '商品类目',
				field : 'itemCatName',
				width : 100,
				
			},
			{
				title : '客户',
				field : 'customerName',
				width : 100,
				
			},
			{ 
				title : '出库负责人',
				field : 'outUserName',
				width : 100,				
			},
			{ 
				title : '出库数量',
				field : 'num',
				width : 100,				
			},
			{ 
				title : '品牌',
				field : 'brand',
				width : 100,				
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
				
				toolbar : [
					//<
					// {
					//text : '增加',
					//iconCls : 'icon-add',
					//handler : function() {
						//parent.add();
						//outItem_add();
					//}
					//}, '-', 
					//{
					//text : '删除',
					//iconCls : 'icon-remove',
					//handler : function() {
						//outItem_del();
					//}
				//}, 
				//'-', {
					//text : '修改',
					//iconCls : 'icon-edit',
					//handler : function() {
						//outItem_edit();
					//}
				//}, 
				 
				//'-', 
				//{
					//text : '取消编辑',
					//iconCls : 'icon-undo',
					//handler : function() {
					//	outItem_datagrid.datagrid('unselectAll');
					//	outItem_datagrid.datagrid.datagrid('rejectChanges');
					//	editRow = undefined;
					//}
				//},  '-', 
				{
					text : '查看',
					iconCls : 'icon-search',
					handler : function() {
						outItem_detail();
					}
				},'-', {
					text : '取消选中',
					iconCls : 'icon-undo',
					handler : function() {
						outItem_datagrid.datagrid('unselectAll');
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

	
function outItem_out() {
		
		var rows = outItem_datagrid.datagrid('getSelections');
		
		
		if (rows.length >1) {
			var names = [];
			for ( var i = 0; i < rows.length; i++) {
				names.push(rows[i].name);
			}
			$.messager.show({
				msg : '只能择一个商品进行出库！您已经选择了【' + names.join(',') + '】' + rows.length + '个商品出库',
				title : '提示'
			});
		} else if (rows.length == 1) {
			var node = outItem_datagrid.datagrid('getSelected');
			var d=$('<div/>').dialog({
				href : '${pageContext.request.contextPath}/outItemManager/add.action',
				width : 500,
				height : 380,
				modal : true,
				title : '商品出库',
				loadingMessage: '正在加载...',  
				buttons : [ {
					text : '确定',
					iconCls : 'icon-ok',
					handler : function() {
						
						$.messager.confirm('确认', '您确定开始商品出库？', function(r) {
							if (r) {
							
								$('#addOutItem').form('submit', {
									url : '${pageContext.request.contextPath}/outItem/add.action',
									success : function(result) {
										
											var r = $.parseJSON(result);
											
											if(r.status='200') 
											{
												
												$.messager.show({
													title : '提示',
													msg : r.msg
												});
												outItem_datagrid.datagrid('reload');
												d.dialog('destroy');
											}
											
											else if(r.status='404'){
												$.messager.alert("警告", r.msg,"warning");
											}else{
												$.messager.show({
													title : '提示',
													msg : '服务器正忙,请稍后移动'
												});
											}
										
									}
								});
								
							}
							});
				
					
					}
				
				} ],
				onClose : function() {
					d.dialog("destroy");
				},
				onLoad : function() {
					$('#addOutItem').form('load','${pageContext.request.contextPath}/outItemDetail.action/'+node.id);
				}
			});
			
		}else{
			$.messager.show({
				msg : '请选择一个商品进行出库!',
				title : '提示'
			});
		}
	}
	
	
	
	
function outItem_detail() {		
		var rows = outItem_datagrid.datagrid('getSelections');		
		if (rows.length >1) {
			var names = [];
			for ( var i = 0; i < rows.length; i++) {
				names.push(rows[i].name);
			}
			$.messager.show({
				msg : '只能择一个商品出库进行查看！您已经选择了【' + names.join(',') + '】' + rows.length + '个商品',
				title : '提示'
			});
		} else if (rows.length == 1) {
			var node = outItem_datagrid.datagrid('getSelected');
			var d=$('<div/>').dialog({
				href : '${pageContext.request.contextPath}/detailOutItem.action',
				width : 500,
				height : 380,
				modal : true,
				title : '商品详情',
				loadingMessage: '正在加载...',  
				
				onClose : function() {
					d.dialog("destroy");
				},
				onLoad : function() {
					$('#detailoutItem').form('load','${pageContext.request.contextPath}/outItemDetail.action/'+node.id);
				}
			});
			
		}else{
			$.messager.show({
				msg : '请选择一个商品出库进行编辑!',
				title : '提示'
			});
		}
	}
	
	
	
	
	
	
function outItem_move() {
		
		var rows = outItem_datagrid.datagrid('getSelections');
		
		
		if (rows.length >1) {
			var names = [];
			for ( var i = 0; i < rows.length; i++) {
				names.push(rows[i].name);
			}
			$.messager.show({
				msg : '只能择一个商品进行移库！您已经选择了【' + names.join(',') + '】' + rows.length + '个商品移库',
				title : '提示'
			});
		} else if (rows.length == 1) {
			var node = outItem_datagrid.datagrid('getSelected');
			var d=$('<div/>').dialog({
				href : '${pageContext.request.contextPath}/moveoutItem.action',
				width : 500,
				height : 380,
				modal : true,
				title : '商品移库',
				loadingMessage: '正在加载...',  
				buttons : [ {
					text : '确定',
					iconCls : 'icon-ok',
					handler : function() {
						var move=$('#moveoutItem').find('[name=storeId]').val();
						var store=$('#moveoutItem').find('[name=moveStoreId]').val();
					
						if(move==store){
							 $.messager.alert("警告", "不能移动到同一仓库！","warning");
							return ;
						}
						$.messager.confirm('确认', '您确定开始商品移库？', function(r) {
							if (r) {
							
								$('#moveoutItem').form('submit', {
									url : '${pageContext.request.contextPath}/outItem/move.action',
									success : function(result) {
										
											var r = $.parseJSON(result);
											
											if(r.status='200') 
											{
												
												$.messager.show({
													title : '提示',
													msg : r.msg
												});
												outItem_datagrid.datagrid('reload');
												d.dialog('destroy');
											}
											
											else if(r.status='404'){
												$.messager.alert("警告", r.msg,"warning");
											}else{
												$.messager.show({
													title : '提示',
													msg : '服务器正忙,请稍后移动'
												});
											}
										
									}
								});
								
							}
							});
				
					
					}
				
				} ],
				onClose : function() {
					d.dialog("destroy");
				},
				onLoad : function() {
					$('#moveoutItem').form('load','${pageContext.request.contextPath}/outItemDetail.action/'+node.id);
				}
			});
			
		}else{
			$.messager.show({
				msg : '请选择一个商品进行移库!',
				title : '提示'
			});
		}
	}

	
	
	
	
	function outItem_del(){
		var rows = outItem_datagrid.datagrid('getSelections');
		var ids = [];
		var copyRows = [];
       
		 if (rows == null) {  
		        $.messager.show("提示", "请选择要删除的行！");  
		    } else{
		    	for ( var j= 0; j < rows.length; j++) {
		            ids.push(rows[j].id);
		            }
		    	$.messager.confirm('询问', '您确定要删除【' + rows.length + '】个商品入库', function(b) {				 
			 
		    		if (b) {
						$.ajax({
							url : '${pageContext.request.contextPath}/outItem/delete.action?ids='+ids+'',
							
							cache : false,
							dataType : 'JSON',
							success : function(r) {
								if (r.status='200') {
									
									 for ( var j= 0; j < rows.length; j++) {
									        copyRows.push(rows[j]);
									        						}
									     for(var i =0;i<copyRows.length;i++){    
									            var index = outItem_datagrid.datagrid('getRowIndex',copyRows[i]);
									            outItem_datagrid.datagrid('deleteRow',index); 
									        }
									     outItem_datagrid.datagrid('reload');
									//outItem_datagrid.datagrid('clearSelections'); //清空选中的行 
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

	function outItem_edit() {
		
		var rows = outItem_datagrid.datagrid('getSelections');
		
		
		if (rows.length >1) {
			var names = [];
			for ( var i = 0; i < rows.length; i++) {
				names.push(rows[i].name);
			}
			$.messager.show({
				msg : '只能择一个商品入库进行编辑！您已经选择了【' + names.join(',') + '】' + rows.length + '个商品入库',
				title : '提示'
			});
		} else if (rows.length == 1) {
			var node = outItem_datagrid.datagrid('getSelected');
			var d=$('<div/>').dialog({
				href : '${pageContext.request.contextPath}/jsp/editoutItem.jsp',
				width : 500,
				height : 380,
				modal : true,
				title : '编辑商品出库',
				loadingMessage: '正在加载...',  
				buttons : [ {
					text : '确定',
					iconCls : 'icon-edit',
					handler : function() {
						
						$('#editoutItem').form('submit', {
							url : '${pageContext.request.contextPath}/outItem/edit.action',
							success : function(result) {
								
									var r = $.parseJSON(result);
									
									if(r.status='200') 
									{
										
										$.messager.show({
											title : '提示',
											msg : r.msg
										});
										outItem_datagrid.datagrid('reload');
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
					$('#editoutItem').form('load','${pageContext.request.contextPath}/outItemDetail.action/'+node.id);
				}
			});
			
		}else{
			$.messager.show({
				msg : '请选择一个商品入库进行编辑!',
				title : '提示'
			});
		}
	}

	function outItem_add() {
		
		
		d=$('<div/>').dialog({
			href : '${pageContext.request.contextPath}/outItemManager/add.action',
			width : 550,
			height : 400,
			//modal : true,
			title : '添加商品出库',
			loadingMessage: '正在加载...',  
			buttons : [ {
				text : '增加',
				iconCls : 'icon-ok',
				handler : function() {
					submitForm();
					
				}
			} ],
			onClose : function() {
				d.dialog("destroy");
			}
		});
	}
	function outItem_search() {
		outItem_datagrid.datagrid('load',  serializeObject(outItem_searchForm));
	}
	function outItem_cleanSearch() {
		outItem_datagrid.datagrid('load', {});
		outItem_searchForm.find('input').val('');
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
		<form id="outItem_searchForm">
			<table class="tableForm datagrid-toolbar" style="width: 100%;height: 100%;">
				<tr>
					<th>商品名</th>
					<td><input name="name" style="width:315px;" /></td>
				</tr>
				<tr>
					<th>创建时间</th>
					<td><input name="createdatetimeStart" class="easyui-datetimebox" editable="false" style="width: 155px;" />至<input name="createdatetimeEnd" class="easyui-datetimebox" editable="false" style="width: 155px;" /></td>
				</tr>
				<tr>
					<th>最后修改时间</th>
					<td><input name="modifydatetimeStart" class="easyui-datetimebox" editable="false" style="width: 155px;" />至<input name="modifydatetimeEnd" class="easyui-datetimebox" editable="false" style="width: 155px;" /><a href="javascript:void(0);" class="easyui-linkbutton" onclick="outItem_search();">过滤</a><a href="javascript:void(0);" class="easyui-linkbutton" onclick="outItem_cleanSearch();">取消</a></td>
				</tr>
			</table>
		</form>
	</div>
	<div region="center" border="false">
		<table id="outItem_datagrid"></table>
	</div>
	
	
</body>
</html>
	

		


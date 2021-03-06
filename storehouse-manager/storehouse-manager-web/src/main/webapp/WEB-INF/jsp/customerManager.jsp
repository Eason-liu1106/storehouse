<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<!DOCTYPE HTML >
<html>
<head>
<%@ include file="/WEB-INF/jsp/easyui.jsp"%>
<script type="text/javascript" charset="utf-8">
	var customer_searchForm;
	var editRow = undefined;
	var customer_datagrid; 
	$(function() {
		customer_searchForm = $('#customer_searchForm').form();
			
		customer_datagrid = $('#customer_datagrid').datagrid({
	
			url : '${pageContext.request.contextPath}/customer/list.action',
			title : '客户列表',
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
				title : '单位名称',
				field : 'name',
				width : 200,
				sortable : true,
				
			} ] ],
			columns : [ [ 
			{ 
				title : '地址',
				field : 'address',
				width : 200,			
				
			},
			{ 
				title : '邮编',
				field : 'postcode',
				width : 100,			
				
			},
			
			{ 
				title : '电话',
				field : 'phone',
				width : 150,			
				
			},
			
			{ 
				title : '网址',
				field : 'www',
				width : 150,			
				
			},
			
			{ 
				title : '营业执照号',
				field : 'licence',
				width : 150,			
				
			},
			{ 
				title : '开户银行',
				field : 'bank',
				width : 150,			
				
			},
			{ 
				title : '银行帐号',
				field : 'account',
				width : 150,			
				
			},
			{ 
				title : '负责人',
				field : 'answerMan',
				width : 150,			
				
			},
			{ 
				title : '联系人',
				field : 'contactMan',
				width : 150,			
				
			},
			{ 
				title : '备注',
				field : 'remark',
				width : 200,			
				
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
						customer_add();
					}
				}, '-', {
					text : '删除',
					iconCls : 'icon-remove',
					handler : function() {
						customer_del();
					}
				}, '-', {
					text : '修改',
					iconCls : 'icon-edit',
					handler : function() {
						customer_edit();
					}
				}, '-', {
					text : '保存',
					iconCls : 'icon-save',
					handler : function() {
						if (editRow != undefined) {
							customer_datagrid.datagrid('endEdit', editRow);
						}
					}
				},
				 
				'-', {
					text : '取消编辑',
					iconCls : 'icon-undo',
					handler : function() {
						customer_datagrid.datagrid('unselectAll');
						customer_datagrid.datagrid.datagrid('rejectChanges');
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
						customer_datagrid.datagrid('unselectAll');
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
	function customer_del(){
		var rows = customer_datagrid.datagrid('getSelections');
		var ids = [];
		var copyRows = [];
       
		 if (rows == null) {  
		        $.messager.show("提示", "请选择要删除的行！");  
		    } else{
		    	for ( var j= 0; j < rows.length; j++) {
		            ids.push(rows[j].id);
		            }
		    	$.messager.confirm('询问', '您确定要删除【' + rows.length + '】个客户?', function(b) {				 
			 
		    		if (b) {
						$.ajax({
							url : '${pageContext.request.contextPath}/customer/delete.action?ids='+ids+'',
							
							cache : false,
							dataType : 'JSON',
							success : function(r) {
								if (r.status='200') {
									
									 for ( var j= 0; j < rows.length; j++) {
									        copyRows.push(rows[j]);
									        						}
									     for(var i =0;i<copyRows.length;i++){    
									            var index = customer_datagrid.datagrid('getRowIndex',copyRows[i]);
									            customer_datagrid.datagrid('deleteRow',index); 
									        }
									     customer_datagrid.datagrid('reload');
									//customer_datagrid.datagrid('clearSelections'); //清空选中的行 
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

	function customer_edit() {
		
		var rows = customer_datagrid.datagrid('getSelections');
		
		
		if (rows.length >1) {
			var names = [];
			for ( var i = 0; i < rows.length; i++) {
				names.push(rows[i].name);
			}
			$.messager.show({
				msg : '只能择一个客户进行编辑！您已经选择了【' + names.join(',') + '】' + rows.length + '个客户',
				title : '提示'
			});
		} else if (rows.length == 1) {
			var node = customer_datagrid.datagrid('getSelected');
			var d=$('<div/>').dialog({
				href : '${pageContext.request.contextPath}/customerManager/edit.action',
				width : 500,
				height : 380,
				modal : true,
				title : '编辑客户',
				loadingMessage: '正在加载...',  
				buttons : [ {
					text : '确定',
					iconCls : 'icon-edit',
					handler : function() {
						
						$('#editCustomer').form('submit', {
							url : '${pageContext.request.contextPath}/customer/edit.action',
							success : function(result) {
								
									var r = $.parseJSON(result);
									
									if(r.status='200') 
									{
										
										$.messager.show({
											title : '提示',
											msg : r.msg
										});
										customer_datagrid.datagrid('reload');
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
					$('#editCustomer').form('load', node);
				}
			});
			
		}else{
			$.messager.show({
				msg : '请选择一个客户类型进行编辑!',
				title : '提示'
			});
		}
	}
	function customer_add() {
		
		
		var d=$('<div/>').dialog({
			href : '${pageContext.request.contextPath}/customerManager/add.action',
			width : 500,
			height : 380,
			modal : true,
			title : '添加客户',
			loadingMessage: '正在加载...',  
			buttons : [ {
				text : '增加',
				iconCls : 'icon-ok',
				handler : function() {
					//$(this).closest('.window-body').dialog("close");
					//var d = $(this).closest('.window-body');					
					$('#addCustomer').form('submit', {
						url : '${pageContext.request.contextPath}/customer/add.action',
						success : function(result) {
							
								var r = $.parseJSON(result);
						 		
								if(r.status='200')
								{
									
									$.messager.show({
										title : '提示',
										msg : r.msg
									});
									//customer_datagrid.datagrid('appendRow',r.data);
									customer_datagrid.datagrid('load',{});
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
	function customer_search() {
		customer_datagrid.datagrid('load',  serializeObject(customer_searchForm));
	}
	function customer_cleanSearch() {
		customer_datagrid.datagrid('load', {});
		customer_searchForm.find('input').val('');
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
		<form id="customer_searchForm">
			<table class="tableForm datagrid-toolbar" style="width: 100%;height: 100%;">
				<tr>
					<th>客户名</th>
					<td><input name="name" style="width:315px;" /></td>
				</tr>
				<tr>
					<th>创建时间</th>
					<td><input name="createdatetimeStart" class="easyui-datetimebox" editable="false" style="width: 155px;" />至<input name="createdatetimeEnd" class="easyui-datetimebox" editable="false" style="width: 155px;" /></td>
				</tr>
				<tr>
					<th>最后修改时间</th>
					<td><input name="modifydatetimeStart" class="easyui-datetimebox" editable="false" style="width: 155px;" />至<input name="modifydatetimeEnd" class="easyui-datetimebox" editable="false" style="width: 155px;" /><a href="javascript:void(0);" class="easyui-linkbutton" onclick="customer_search();">过滤</a><a href="javascript:void(0);" class="easyui-linkbutton" onclick="customer_cleanSearch();">取消</a></td>
				</tr>
			</table>
		</form>
	</div>
	<div region="center" border="false">
		<table id="customer_datagrid"></table>
	</div>
	
	
</body>
</html>
	

		


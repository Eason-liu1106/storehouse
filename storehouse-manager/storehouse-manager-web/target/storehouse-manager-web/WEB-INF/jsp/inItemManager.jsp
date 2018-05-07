<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<!DOCTYPE HTML >
<html>
<head>
<%@ include file="/WEB-INF/jsp/easyui.jsp"%>
<script type="text/javascript" charset="utf-8">
	var inItem_searchForm;
	var d;
	var inItem_datagrid; 
	$(function() {
		inItem_searchForm = $('#inItem_searchForm').form();
		
		inItem_datagrid = $('#inItem_datagrid').datagrid({
	
			url : '${pageContext.request.contextPath}/inItem/list.action',
			title : '商品入库列表',
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
			}
			//, 
			//{
			//	title : '商品名称',
			//	field : 'name',
			//	width : 100,
			//	sortable : true,
				
			//}
			] ],
			columns : [ [ {
				title : '入库仓库',
				field : 'storeName',
				width : 100,
				
			},
			{
				title : '商品类目',
				field : 'itemCatName',
				width : 100,
				
			},
			{
				title : '供应商',
				field : 'supplierName',
				width : 100,
				
			},
			{ 
				title : '入库负责人',
				field : 'inUserName',
				width : 100,				
			},
			{ 
				title : '入库数量',
				field : 'num',
				width : 100,				
			},
			{ 
				title : '租金',
				field : 'rental',
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
				
				toolbar : [ {
					text : '增加',
					iconCls : 'icon-add',
					handler : function() {
						//parent.add();
						inItem_add();
					}
				}, '-', {
					text : '删除',
					iconCls : 'icon-remove',
					handler : function() {
						inItem_del();
					}
				}, '-', {
					text : '修改',
					iconCls : 'icon-edit',
					handler : function() {
						inItem_edit();
					}
				}, '-', {
					text : '出库',
					iconCls : 'icon-edit',
					handler : function() {
						inItem_out();
					}
				}, '-',{
					text : '移库',
					iconCls : 'icon-edit',
					handler : function() {
						inItem_move();
					}
				}, '-',{
					text : '保存',
					iconCls : 'icon-save',
					handler : function() {
						if (editRow != undefined) {
							inItem_datagrid.datagrid('endEdit', editRow);
						}
					}
				},
				 
				'-', {
					text : '取消编辑',
					iconCls : 'icon-undo',
					handler : function() {
						inItem_datagrid.datagrid('unselectAll');
						inItem_datagrid.datagrid.datagrid('rejectChanges');
						editRow = undefined;
					}
				},  '-', {
					text : '查看',
					iconCls : 'icon-search',
					handler : function() {
						inItem_detail();
					}
				},'-', {
					text : '取消选中',
					iconCls : 'icon-undo',
					handler : function() {
						inItem_datagrid.datagrid('unselectAll');
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

	
function inItem_out() {
		
		var rows = inItem_datagrid.datagrid('getSelections');
		
		
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
			var node = inItem_datagrid.datagrid('getSelected');
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
												inItem_datagrid.datagrid('reload');
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
					$('#addOutItem').form('load','${pageContext.request.contextPath}/inItemDetail.action?itemId='+node.id);
				}
			});
			
		}else{
			$.messager.show({
				msg : '请选择一个商品进行移库!',
				title : '提示'
			});
		}
	}
	
	
	
	
function inItem_detail() {		
		var rows = inItem_datagrid.datagrid('getSelections');		
		if (rows.length >1) {
			var names = [];
			for ( var i = 0; i < rows.length; i++) {
				names.push(rows[i].name);
			}
			$.messager.show({
				msg : '只能择一个商品入库进行查看！您已经选择了【' + names.join(',') + '】' + rows.length + '个商品',
				title : '提示'
			});
		} else if (rows.length == 1) {
			var node = inItem_datagrid.datagrid('getSelected');
			var d=$('<div/>').dialog({
				href : '${pageContext.request.contextPath}/inItemManager/detail.action',
				width : 500,
				height : 380,
				modal : true,
				title : '商品详情',
				loadingMessage: '正在加载...',  
				
				onClose : function() {
					d.dialog("destroy");
				},
				onLoad : function() {
					$('#detailInItem').form('load','${pageContext.request.contextPath}/inItemDetail.action?itemId'+node.id);
				}
			});
			
		}else{
			$.messager.show({
				msg : '请选择一个商品入库进行编辑!',
				title : '提示'
			});
		}
	}
	
	
	
	
	
	
function inItem_move() {
		
		var rows = inItem_datagrid.datagrid('getSelections');
		
		
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
			var node = inItem_datagrid.datagrid('getSelected');
			var d=$('<div/>').dialog({
				href : '${pageContext.request.contextPath}/inItemManager/move.action',
				width : 500,
				height : 380,
				modal : true,
				title : '商品移库',
				loadingMessage: '正在加载...',  
				buttons : [ {
					text : '确定',
					iconCls : 'icon-ok',
					handler : function() {
						var move=$('#moveInItem').find('[name=storeId]').val();
						var store=$('#moveInItem').find('[name=moveStoreId]').val();
					
						if(move==store){
							 $.messager.alert("警告", "不能移动到同一仓库！","warning");
							return ;
						}
						$.messager.confirm('确认', '您确定开始商品移库？', function(r) {
							if (r) {
							
								$('#moveInItem').form('submit', {
									url : '${pageContext.request.contextPath}/inItem/move.action',
									success : function(result) {
										
											var r = $.parseJSON(result);
											
											if(r.status='200') 
											{
												
												$.messager.show({
													title : '提示',
													msg : r.msg
												});
												inItem_datagrid.datagrid('reload');
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
					$('#moveInItem').form('load','${pageContext.request.contextPath}/inItemDetail.action?itemId='+node.id);
				}
			});
			
		}else{
			$.messager.show({
				msg : '请选择一个商品进行移库!',
				title : '提示'
			});
		}
	}

	
	
	
	
	function inItem_del(){
		var rows = inItem_datagrid.datagrid('getSelections');
		var ids = [];
		var copyRows = [];
       
		 if (rows == null) {  
		        $.messager.show("提示", "请选择要删除的行！");  
		    } else{
		    	for ( var j= 0; j < rows.length; j++) {
		            ids.push(rows[j].id);
		            }
		    	$.messager.confirm('询问', '您确定要删除【' + rows.length + '】个入库商品', function(b) {				 
			 
		    		if (b) {
						$.ajax({
							url : '${pageContext.request.contextPath}/inItem/delete.action?ids='+ids+'',
							
							cache : false,
							dataType : 'JSON',
							success : function(r) {
								if (r.status='200') {
									
									 for ( var j= 0; j < rows.length; j++) {
									        copyRows.push(rows[j]);
									        						}
									     for(var i =0;i<copyRows.length;i++){    
									            var index = inItem_datagrid.datagrid('getRowIndex',copyRows[i]);
									            inItem_datagrid.datagrid('deleteRow',index); 
									        }
									     inItem_datagrid.datagrid('reload');
									//inItem_datagrid.datagrid('clearSelections'); //清空选中的行 
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

	function inItem_edit() {
		
		var rows = inItem_datagrid.datagrid('getSelections');
		
		
		if (rows.length >1) {
			var names = [];
			for ( var i = 0; i < rows.length; i++) {
				names.push(rows[i].name);
			}
			$.messager.show({
				msg : '只能择一个入库商品进行编辑！您已经选择了【' + names.join(',') + '】' + rows.length + '个入库商品',
				title : '提示'
			});
		} else if (rows.length == 1) {
			var node = inItem_datagrid.datagrid('getSelected');
			var d=$('<div/>').dialog({
				href : '${pageContext.request.contextPath}/inItemManager/edit.action',
				width : 500,
				height : 380,
				modal : true,
				title : '编辑商品入库',
				loadingMessage: '正在加载...',  
				buttons : [ {
					text : '确定',
					iconCls : 'icon-edit',
					handler : function() {
						$.ajax( {
							url : '${pageContext.request.contextPath}/inItem/edit.action',
							data: $('#editInItem').serialize(),
							dataType : 'JSON',
							type: "POST",
							success : function(result) {
								
									var r = result;
									
									if(r.status='200') 
									{
										$.messager.show({
											title : '提示',
											msg : r.msg
										});
										inItem_datagrid.datagrid('reload');
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
					$('#editInItem').form('load','${pageContext.request.contextPath}/inItemDetail.action?itemId='+node.id);
				}
			});
			
		}else{
			$.messager.show({
				msg : '请选择一个入库商品进行编辑!',
				title : '提示'
			});
		}
	}

	function inItem_add() {
		
		
		d=$('<div/>').dialog({
			href : '${pageContext.request.contextPath}/inItemManager/add.action',
			width : 550,
			height : 400,
			//modal : true,
			title : '添加商品入库',
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
	function inItem_search() {
		inItem_datagrid.datagrid('load',  serializeObject(inItem_searchForm));
	}
	function inItem_cleanSearch() {
		inItem_datagrid.datagrid('load', {});
		inItem_searchForm.find('input').val('');
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
//提交表单
function submitForm(){
	//有效性验证
	if(!$('#addInItem').form('validate')){
		$.messager.alert('提示','表单还未填写完成!');
		return ;
	}
	//取商品价格，单位为“分”
	//$("#addInItem [name=price]").val(eval($("#addInItem [name=priceView]").val()) * 100);
	//同步文本框中的商品描述
	
	//取商品的规格
	var paramJson = [];
	$("#addInItem .params li").each(function(i,e){
		var trs = $(e).find("tr");
		var group = trs.eq(0).text();
		var ps = [];
		for(var i = 1;i<trs.length;i++){
			var tr = trs.eq(i);
			ps.push({
				"k" : $.trim(tr.find("td").eq(0).find("span").text()),
				"v" : $.trim(tr.find("input").val())
			});
		}
		paramJson.push({
			"group" : group,
			"params": ps
		});
	});
	//把json对象转换成字符串
	paramJson = JSON.stringify(paramJson);
	$("#addInItem [name=itemParams]").val(paramJson);
	
	//ajax的post方式提交表单
	//$("#addInItem").serialize()将表单序列号为key-value形式的字符串
	$.post("${pageContext.request.contextPath}/inItem/add.action",$("#addInItem").serialize(), function(data){
		
		if(data.status == 200){
			$.messager.alert('提示','新增商品成功!');
			inItem_datagrid.datagrid('reload');
			d.dialog("destroy");
		}if(data.status == 404){
			$.messager.alert('提示',data.msg);
			inItem_datagrid.datagrid('reload');
			d.dialog("destroy");
		}
	});
	
	$.post("${pageContext.request.contextPath}/inItem/edit.action",$("#editInItem").serialize(), function(data){
		
		if(data.status == 200){
			$.messager.alert('提示','入库商品修改成功!');
			inItem_datagrid.datagrid('reload');
			d.dialog("destroy");
		}if(data.status == 404){
			$.messager.alert('提示',data.msg);
			inItem_datagrid.datagrid('reload');
			d.dialog("destroy");
		}
	});
}
</script>
</head>
<body class="easyui-layout">
	<div region="north" border="false" title="过滤条件" style="height: 110px;overflow: hidden;" align="left">
		<form id="inItem_searchForm">
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
					<td><input name="modifydatetimeStart" class="easyui-datetimebox" editable="false" style="width: 155px;" />至<input name="modifydatetimeEnd" class="easyui-datetimebox" editable="false" style="width: 155px;" /><a href="javascript:void(0);" class="easyui-linkbutton" onclick="inItem_search();">过滤</a><a href="javascript:void(0);" class="easyui-linkbutton" onclick="inItem_cleanSearch();">取消</a></td>
				</tr>
			</table>
		</form>
	</div>
	<div region="center" border="false">
		<table id="inItem_datagrid"></table>
	</div>
	
	
</body>
</html>
	

		


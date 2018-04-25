	<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>   
            
            
  
<script type="text/javascript" charset="utf-8">        
var store_typeDatagrid= $('#store_typeDatagrid').combogrid({
	loadMsg : '数据加载中....',
	panelWidth : 440,
	panelHeight : 180,
	required : true,
	fitColumns : true,
	value : '',
	valueField:'id',
	idField : 'id',
	textField : 'name',
	mode : 'remote',
	url : '${pageContext.request.contextPath}/storeType/list.action',
	pagination : true,
	pageSize : 5,
	pageList : [ 5, 10 ],
    onSelect: function (rowIndex, rowData){  
    	$('input[name="storeTypeId"]').val(rowData.id);
       
        }  ,
	columns : [ [ {
		field : 'id',
		title : '编号',
		width : 60,
		hidden : true
	}, {
		field : 'name',
		title : '仓库类型名',
		width : 100,
		sortable : true
	}, {
		field : 'createdatetime',
		title : '创建时间',
		width : 150,
		sortable : true,
		formatter : function(value){ 
			 return formatterdate(value);
		 }
		
	}, {
		field : 'modifydatetime',
		title : '最后修改时间',
		width : 150,
		sortable : true,
		formatter : function(value){ 
			 return formatterdate(value);
		 }
	} ] ],
	delay : 500
});
var calculateDatagrid= $('#calculateDatagrid').combogrid({
	loadMsg : '数据加载中....',
	panelWidth : 440,
	panelHeight : 180,
	required : true,
	fitColumns : true,
	value : '',
	idField : 'id',
	textField : 'name',
	mode : 'remote',
	url : '${pageContext.request.contextPath}/calculate/list.action',
	pagination : true,
	pageSize : 5,
	
	pageList : [ 5, 10 ],
	 onSelect: function (rowIndex, rowData){  
	    	$('input[name="calculateId"]').val(rowData.id);
	       
	        }  ,
	columns : [ [ {
		field : 'id',
		title : '编号',
		width : 60,
		hidden : true
	}, {
		field : 'name',
		title : '租金方式名称',
		width : 100,
		sortable : true
	}, {
		field : 'createdatetime',
		title : '创建时间',
		width : 150,
		sortable : true,
		formatter : function(value){ 
			 return formatterdate(value);
		 }
	}, {
		field : 'modifydatetime',
		title : '最后修改时间',
		width : 150,
		sortable : true,
		formatter : function(value){ 
			 return formatterdate(value);
		 }
	} ] ],
	delay : 500
});	

var rackDatagrid= $('#rackDatagrid').combogrid({
	loadMsg : '数据加载中....',
	panelWidth : 440,
	panelHeight : 180,
	required : true,
	fitColumns : true,
	value : '',
	idField : 'id',
	textField : 'name',
	mode : 'remote',
	url : '${pageContext.request.contextPath}/rack/list.action',
	pagination : true,
	pageSize : 5,
	pageList : [ 5, 10 ],
	 onSelect: function (rowIndex, rowData){  
	    	$('input[name="rackId"]').val(rowData.id);
	       
	        }  ,
	columns : [ [ {
		field : 'id',
		title : '编号',
		width : 60,
		hidden : true
	}, {
		field : 'parm',
		title : '货架参数',
		width : 150,
		sortable : true
	},  {
		field : 'name',
		title : '货架名字',
		width : 100,
		sortable : true
	},{
		field : 'createdatetime',
		title : '创建时间',
		width : 150,
		sortable : true,
		formatter : function(value){ 
			 return formatterdate(value);
		 }
	}, {
		field : 'modifydatetime',
		title : '最后修改时间',
		width : 150,
		sortable : true,
		formatter : function(value){ 
			 return formatterdate(value);
		 }
	} ] ],
	delay : 1000
});	
</script>
 <div style="padding:10px 60px 20px 60px">  
     <form id="addStore" method="post">  
         <table cellpadding="10">  
             <tr>  
                 <td>仓库名:</td>  
                 <td><input class="easyui-textbox" type="text" name="name" missingMessage="请填写仓库名称" data-options="required:true"></input></td>  
             </tr>  	

              <tr>  
                <td>计费方式:</td> 
                 <td><input id="calculateDatagrid"  style="width: 156px;" class="easyui-validatebox" name="calculateId" missingMessage="请选择仓库计费方式" data-options="required:true" ></input></td>  
             </tr>  
             <tr>  
                   <td>货架方式:</td> 
                 <td><input id="rackDatagrid" style="width: 156px;" class="easyui-validatebox" name="rackId" missingMessage="请选择" data-options="required:true" ></input></td>    
             </tr>   
             
             <tr>  
                 <td>仓库类型名:</td>  
                 <td><input  id="store_typeDatagrid" name="storeTypeId" missingMessage="请填选择仓库类型" data-options="required:true"></input></td>  
             </tr>
               <tr>  
                 <td>最大库存:</td>  
                 <td><input class="easyui-textbox" type="text" name="bigstock" missingMessage="请填写最大库存" data-options="required:true"></input></td>  
             </tr>
            <!--  <tr>  
                 <td>最小库存:</td>  
                 <td><input class="easyui-textbox" type="text" name="smallstock" missingMessage="请填写最小库存" data-options="required:true"></input></td>  
             </tr>
             <tr>  
                 <td>现有库存:</td>  
                 <td><input class="easyui-textbox" type="text" name="stock" missingMessage="请填写当前库存" data-options="required:true"></input></td>  
             </tr> -->
              <tr>  
                 <td>描述:</td>  
                 <td><textarea name="description" rows="8" cols="24"></textarea></td>  
             </tr>    
            
         </table>  
     </form>  
    
 </div>  





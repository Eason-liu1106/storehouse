	<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>   
            
  <div style="padding:10px 60px 20px 60px">  
     <form id="editInItem" method="post">  
         <table cellpadding="10">       
             <tr>  
                   
                 <td><input hidden="true" style="width: 156px;" name="storeName" data-options="required:true"></input></td>                  
                 <td><input hidden="true" style="width: 156px;" class="easyui-validatebox" name="measureunitName"  data-options="required:true" ></input></td>                    
                 <td><input hidden="true" style="width: 156px;" class="easyui-validatebox" name="supplierName"  data-options="required:true" ></input></td> 
                 <td>
                 	<input hidden="true" name="id" data-options="required:true"></input> 
                 	<input hidden="true"  name="inUserId" data-options="required:true">
                 </td>
             </tr>   
             <tr>
	            <td>商品类目:</td>
	            <td>
	            	<a href="javascript:void(0)" class="easyui-linkbutton selectItemCat">选择类目</a>
	            	<input type="hidden" name="itemCatId" style="width: 280px;"></input>
	            	<input type="text" readonly="readonly" name="itemCatName"></input>
	            </td>
	        </tr>	  
            <tr>
            <tr>
	            <td>商品入库仓库:</td>
	            <td><input class="easyui-textbox" name="storeId" ></input></td>
	        </tr>
	        <tr>
	            <td>商品品牌:</td>
	            <td><input class="easyui-textbox" name="brand" ></input></td>
	        </tr>
	         
	         
	        <tr>
	            <td>商品租期:</td>
	            <td><input class="easyui-textbox" name="time" ></input></td>
	        </tr>
	        <tr>
	            <td>商品货架位置:</td>
	            <td><input class="easyui-textbox" name="position" ></input></td>
	        </tr>
	         <tr>
	            <td>商品计量单位:</td>
	            <td><input class="easyui-textbox" name="measureunitId"></input></td>
	        </tr>
	         <tr>
	            <td>商品供应商:</td>
	            <td><input class="easyui-textbox" name="supplierId" ></input></td>
	        </tr>
	      
	         <tr>
	            <td>商品大小:</td>
	            <td><input class="easyui-textbox" name="bulk" ></input></td>
	        </tr>
	        <tr>
	            <td>商品价格:</td>
	            <td><input class="easyui-numberbox" type="text" name="money" data-options="min:1,max:99999999,precision:2,required:true" />
	            	<input type="hidden" name="price"/>
	            </td>
	        </tr>
	         <tr>
	            <td>商品实付金额:</td>
	            <td><input class="easyui-textbox" name="pay" ></input></td>
	        </tr>
	        <tr>
	            <td>库存数量:</td>
	            <td><input class="easyui-numberbox" type="text" name="num" data-options="min:1,max:99999999,precision:0,required:true" /></td>
	        </tr>
	         
	        
              <tr>  
                 <td>描述:</td>  
                 <td><textarea name="description" rows="8" cols="24"></textarea></td>  
             </tr>    
             <tr class="params hide">
	        	<td>商品规格:</td>
	        	<td>
	        		
	        	</td>
	        </tr>
	       
         </table> 
  		<input type="hidden" name="itemParams"/>
     </form>  
     <div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	</div>
    
 </div>  
<script type="text/javascript" charset="utf-8">        
var store_Datagrid= $('input[name="storeId"]').combogrid({
	loadMsg : '数据加载中....',
	panelWidth : 440,
	panelHeight : 180,
	required : true,
	fitColumns : true,
	value : '',
	valueField:'name',
	idField : 'id',
	textField : 'name',
	mode : 'remote',
	url : '${pageContext.request.contextPath}/store/list.action',
	pagination : true,
	pageSize : 5,
	pageList : [ 5, 10 ],
    onSelect: function (rowIndex, rowData){  
    
    	$('input[name="storeName"]').val(rowData.name);
        }  ,
	columns : [ [ {
		field : 'id',
		title : '编号',
		width : 60,
		hidden : true
	}, {
		field : 'name',
		title : '仓库名',
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
var supplier_Datagrid= $('input[name="supplierId"]').combogrid({
	loadMsg : '数据加载中....',
	panelWidth : 440,
	panelHeight : 180,
	required : true,
	fitColumns : true,
	value : '',
	valueField:'name',
	idField : 'id',
	textField : 'name',
	mode : 'remote',
	url : '${pageContext.request.contextPath}/supplier/list.action',
	pagination : true,
	pageSize : 5,
	pageList : [ 5, 10 ],
    onSelect: function (rowIndex, rowData){  
    
    	$('input[name="supplierName"]').val(rowData.name);
        }  ,
	columns : [ [ {
		field : 'id',
		title : '编号',
		width : 60,
		hidden : true
	}, {
		field : 'name',
		title : '供应商名',
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
var measureunit_Datagrid= $('input[name="measureunitId"]').combogrid({
	loadMsg : '数据加载中....',
	panelWidth : 440,
	panelHeight : 180,
	required : true,
	fitColumns : true,
	value : '',
	valueField:'name',
	idField : 'id',
	textField : 'name',
	mode : 'remote',
	url : '${pageContext.request.contextPath}/measureunit/list.action',
	pagination : true,
	pageSize : 5,
	pageList : [ 5, 10 ],
    onSelect: function (rowIndex, rowData){  
    
    	$('input[name="measureunitName"]').val(rowData.name);
        }  ,
	columns : [ [ {
		field : 'id',
		title : '编号',
		width : 60,
		hidden : true
	}, {
		field : 'name',
		title : '计量单位名',
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
function Re(){
	$("<div>").css({padding:"5px"}).html("<ul>")
	.window({
		width:'800',
	    height:"450",
	    modal:true,
	    closed:true,
	    iconCls:'icon-save',
	    title:'选择类目',
	    onOpen : function(){
	    	var _win = this;
	    	$("ul",_win).tree({
	    		url:'${pageContext.request.contextPath}/item/cat/list.action',
	    		animate:true,
	    		onClick : function(node){
	    			if($(this).tree("isLeaf",node.target)){	    				
	    				  $.getJSON("${pageContext.request.contextPath}/item/param/query/itemcatid.action?itemCatId=" + node.id,function(data){
	        				  if(data.status == 200 && data.data){
	        					  changeItemParam(node, "addInItem");
	        					  $('#addInItem').find('[name=itemCatId]').val(node.id);
	        				    	$('#addInItem').find('[name=itemCatName]').val(node.text);
	        					  return ;
	        				  }else{
	        					  $.messager.alert("提示", "该类目无规格参数,请选择其他类目。", undefined, function(){
	        						  
	         						 $("#itemParamAddTable .selectItemCat").click();
	         					  });
	        				    	
	        				  }
	        				 
	        			  });	    					  			    			 
	    				$(_win).window('close');
	    				if(data && data.fun){
	    					data.fun.call(this,node);
	    				}
	    			}
	    		}
	    	});
	    },
	    onClose : function(){
	    	$(this).window("destroy");
	    }
	}).window('open');


	}
 function changeItemParam(node,formId){
	
	$.getJSON("/item/param/query/itemcatid.action/" + node.id,function(data){
		  if(data.status == 200 && data.data){
			
			 $("#"+formId+" .params").show();
			 var paramData = JSON.parse(data.data.paramData);
			 var html = "<ul>";
			 for(var i in paramData){
				 var pd = paramData[i];
				 html+="<li><table>";
				 html+="<tr><td colspan=\"2\" class=\"group\">"+pd.group+"</td></tr>";
				 
				 for(var j in pd.params){
					 var ps = pd.params[j];
					 html+="<tr><td class=\"param\"><span>"+ps+"</span>: </td><td><input autocomplete=\"off\" type=\"text\"/></td></tr>";
				 }
				 
				 html+="</li></table>";
			 }
			 html+= "</ul>";
			 $("#"+formId+" .params td").eq(1).html(html);
		  }else{
			 $("#"+formId+" .params").hide();
			 $("#"+formId+" .params td").eq(1).empty();
		  }
	  });
}
 
 $(".selectItemCat").on("click",function(){
 	 Re(); 	
 });

</script>





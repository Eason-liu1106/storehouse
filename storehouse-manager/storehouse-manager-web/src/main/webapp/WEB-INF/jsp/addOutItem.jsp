	<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>   
     
     <script type="text/javascript" charset="utf-8">
     
     var supplier_Datagrid= $('input[name="customerId"]').combogrid({
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
    		url : '${pageContext.request.contextPath}/customer/list.action',
    		pagination : true,
    		pageSize : 5,
    		pageList : [ 5, 10 ],
    		columns : [ [ {
    			field : 'id',
    			title : '编号',
    			width : 60,
    			hidden : true
    		}, {
    			field : 'name',
    			title : '客户名',
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
     
     </script>       
  <div style="padding:10px 60px 20px 60px">  
     <form id="addOutItem" method="post">  
         <table cellpadding="10">       
              
             <tr>
	            <td>商品类目:</td>
	            <td>		           	
	            	<input  class="easyui-textbox" disabled="disabled" name="itemCatName"></input>
	            </td>
	        </tr>	  
            <tr>
            <tr>
	            <td>商品入库仓库:</td>
	            
	            <td><input class="easyui-textbox" disabled="disabled" name="storeName" ></input>
	            <input  type="hidden" name="id" style="width: 280px;"></input>
	            <input  type="hidden" name="storeId" style="width: 280px;"></input> 	          
	            </td>
	        </tr>
	        <tr>
	            <td>商品品牌:</td>
	            <td><input class="easyui-textbox"  disabled="disabled" name="brand" ></input></td>
	        </tr>
	        <tr>
	            <td>商品货架位置:</td>
	            <td><input class="easyui-textbox"  disabled="disabled" name="position" ></input></td>
	        </tr>        
	         <tr>
	            <td>商品供应商:</td>
	            <td><input class="easyui-textbox" disabled="disabled" name="supplierName" ></input></td>
	        </tr>
	      
	         <tr>
	            <td>商品大小:</td>
	            <td><input class="easyui-textbox" disabled="disabled" name="bulk" ></input></td>
	        </tr>
	        <tr>
	            <td>商品价格:</td>
	            <td><input class="easyui-numberbox" type="text" disabled="disabled"  name="money" data-options="min:1,max:99999999,precision:2,required:true" />
	            	<input type="hidden" name="price"/>
	            </td>
	        </tr>
	         <tr>
	            <td>商品实付金额:</td>
	            <td><input class="easyui-textbox" disabled="disabled" name="pay" ></input></td>
	        </tr>
	        <tr>
	            <td>库存数量:</td>
	            <td><input class="easyui-numberbox" type="text" disabled="disabled" name="num" data-options="min:1,max:99999999,precision:0,required:true" /></td>
	        </tr>
	        
	       <!--  <tr>
	            <td>商品供应商:</td>
	            <td><input class="easyui-textbox" disabled="disabled" name="customerName" ></input></td>
	        </tr> -->
	        
	         <tr>
	            <td>客户:</td>
	            <td><input class="easyui-textbox"  name="customerId" data-options="required:true"  ></input></td>
	        </tr>
	        <tr>
	            <td>出库数量:</td>
	            <td><input class="easyui-numberbox" type="text"  name="outnum" data-options="min:1,max:99999999,precision:0,required:true" /></td>
	        </tr>           
	       <tr>  
                 <td>描述:</td>  
                 <td><textarea name="description"  rows="8" cols="24"></textarea></td>  
            </tr> 
            
         </table> 
  		
     </form>  
 </div>  
  





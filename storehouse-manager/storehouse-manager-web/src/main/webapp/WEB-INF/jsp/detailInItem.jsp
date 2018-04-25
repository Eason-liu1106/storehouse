	<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>   
            
  <div style="padding:10px 60px 20px 60px">  
     <form id="detailInItem" method="post">  
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
	       <tr>  
                 <td>描述:</td>  
                 <td><textarea name="description" disabled="disabled" rows="8" cols="24"></textarea></td>  
            </tr> 
             <tr>
	            <td>出库数量:</td>
	            <td><input class="easyui-numberbox" type="text" disabled="disabled" name="outnum" data-options="min:1,max:99999999,precision:0,required:true" /></td>
	        </tr> 
         </table> 
  		
     </form>  
 </div>  
    





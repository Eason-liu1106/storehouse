	<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>   
            
            
  
<script type="text/javascript" charset="utf-8">        

</script>
 <div style="padding:10px 60px 20px 60px">  
     <form id="addSupplier" method="post" >  
		 <table cellpadding="10">  
		<tr>
			<td>单位名称</td>
			<td><input name="name"  class="easyui-textbox" required="true" style="width:200px"></input></td>
			
		</tr>
		<tr>
			<td>地址</td>
			<td ><textarea name="address" rows="8" cols="24"></textarea></td>
		</tr>
		<tr>
			<td>邮编</td>
			<td><input name="postcode" class="easyui-textbox" style="width:200px"></input></td>
			
		</tr>
		<tr>
		<td>电话</td>
			<td><input name="phone" class="easyui-textbox" style="width:200px"></input></td>
		</tr>
		<tr>
			<td>传真</td>
			<td><input name="fax" class="easyui-textbox" style="width:200px"></input></td>
			
		</tr>
		<tr>
		<td>网址</td>
			<td><input name="www"  class="easyui-textbox" style="width:200px"></input></td>
		</tr>
		<tr>
			<td>电子邮箱</td>
			<td><input name="email" class="easyui-textbox" data-options="required:true"  
                            missingMessage="邮箱不能为空" invalidMessage="请输入正确的邮箱" validType="email" style="width:200px"></input></td>
			
		</tr>
		<tr>
			<td>负责人</td>
			<td><input name="answerMan" class="easyui-textbox" style="width:200px"></input></td>		
		</tr>
		<tr>
			<td>联系人</td>
			<td><input name="contactMan" class="easyui-textbox" style="width:200px"></input></td>
			
		</tr>
		<tr>
			<td>营业执照号</td>
			<td><input name="licence"  class="easyui-textbox"  style="width:200px"></input></td>
		
		</tr>
		<tr>
			<td>开户银行</td>
			<td><input name="bank" class="easyui-textbox" style="width:200px"></input></td>
			
		</tr>
		<tr>
		
			<td>税务编码</td>
			<td><input name="taxCode"  class="easyui-textbox" style="width:200px"></input></td>
		</tr>
		<tr>
			<td>银行帐号</td>
			<td><input name="account" class="easyui-textbox" style="width:200px"></input></td>
			
		</tr>
		<tr>
			<td>助记码</td>
			<td><input name="help" class="easyui-textbox" style="width:200px"></input></td>
		</tr>
		<tr>
			<td>备注</td>
			<td > <textarea rows="8" cols="24" name="remark" ></textarea> </td>
		</tr>
	</table>
     </form>  
    
 </div>  





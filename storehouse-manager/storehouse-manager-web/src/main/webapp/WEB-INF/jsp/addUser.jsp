	<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>   
<script type="text/javascript" charset="utf-8">        
var roleDatagrid= $('#roleDatagrid').combogrid({
	multiple : true,
	loadMsg : '数据加载中....',
	panelWidth : 440,
	panelHeight : 180,
	required : true,
	fitColumns : true,
	valueField:'id',
	idField : 'id',
	textField : 'name',
	mode : 'remote',
	url : '${pageContext.request.contextPath}/role/list.action',
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
		title : '角色名称',
		width : 100,
		sortable : true
	},  {
		title : '可访问资源',
		field : 'permissionNames',
		width : 300,
		
	}] ],
	delay : 500
});

</script>
 <div style="padding:10px 60px 20px 60px">  
     <form id="addUser" method="post">  
         <table cellpadding="10">  
             <tr>  
                 <td>用户名:</td>  
                 <td><input class="easyui-textbox" type="text" name="username" missingMessage="请填写用户名" data-options="required:true"></input></td>  
             </tr>
             <tr>  
                 <td>登陆名:</td>  
                 <td><input class="easyui-textbox" type="text" name="usercode" missingMessage="请填写用户名" data-options="required:true"></input></td>  
             </tr>
             <tr>  
                 <td>密码:</td>  
                 <td><input class="easyui-textbox" type="text" name="password" missingMessage="请填写密码" data-options="required:true"></input></td>  
             </tr> 
             <tr>  
                 <td>确认密码:</td>  
                 <td><input class="easyui-textbox" type="text" name="repassword" missingMessage="请确认密码" data-options="required:true"></input></td>  
             </tr>                
                   
             <tr>  
                 <td>角色选择:</td>  
                 <td><input id="roleDatagrid" name="roleIds" missingMessage="请选择角色" data-options="required:true" ></input></td>    
             </tr>                
         </table>  
     </form>  
    
 </div>  





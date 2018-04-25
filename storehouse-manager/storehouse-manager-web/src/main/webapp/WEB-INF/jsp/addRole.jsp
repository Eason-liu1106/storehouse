	<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>   
<script type="text/javascript" charset="utf-8">        
var permissionDatagrid= $('#permissionDatagrid').combogrid({
	multiple : true,
	loadMsg : '数据加载中....',
	panelWidth : 440,
	panelHeight : 180,
	required : true,
	fitColumns : true,
	rownumbers: true,
	idField : 'id',
	textField : 'name',
	mode : 'remote',
	url : '${pageContext.request.contextPath}/permission/list.action',
	pagination : true,
	pageSize : 5,
	pageList : [ 5, 10,20,30,40],
	columns : [ [ {
		field : 'id',
		title : '编号',
		width : 60,
	
		
	}, {
		field : 'name',
		title : '角色名称',
		width : 150,
		sortable : true
	},  {
		title : 'available',
		field : '是否有效',
		width : 150,
		formatter : function(value, row, index) {
			if(value!=null)
				{ 
					if(value='1')
						return '有效';
					else
						return '无效'
				}
		
		}
		
	}] ],
	delay : 500
});

</script>
 <div style="padding:10px 60px 20px 60px">  
     <form id="addRole" method="post">  
         <table cellpadding="10">  
            
             <tr>  
                 <td>角色名:</td>  
                 <td><input class="easyui-textbox" type="text" name="name" missingMessage="请填写角色名" data-options="required:true"></input></td>  
             </tr>
                                          
             <tr>  
                 <td>权限选择:</td>  
                 <td><input id="permissionDatagrid" name="permissionIds" missingMessage="请选择权限" data-options="required:true" ></input></td>    
             </tr>                
         </table>  
     </form>  
    
 </div>  





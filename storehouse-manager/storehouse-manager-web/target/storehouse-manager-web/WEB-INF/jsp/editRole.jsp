	<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>   
<script type="text/javascript" charset="utf-8">        
var permissionDatagrid= $('#permissionDatagrid').combogrid({
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
	url : '${pageContext.request.contextPath}/permission/list.action',
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
		title : '权限名称',
		width : 150,
		sortable : true
	},  {	
		field : 'available',
		title : '是否有效',
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
     <form id="editRole" method="post">  
         <table cellpadding="10">  
            
             <tr>  
                 <td>角色名:</td>  
                 <td><input class="easyui-textbox" type="text" name="name" missingMessage="请填写角色名" data-options="required:true"></input></td>  
             </tr>
                                          
             <tr>  
                 <td>权限选择:</td>  
             	<td><input   hidden="true"  type="text" name="id"  data-options="required:true"></input><input id="permissionDatagrid" name="permissionIds" missingMessage="请选择权限" data-options="required:true" ></input></td>
             </tr>                
         </table>  
     </form>  
    
 </div>  





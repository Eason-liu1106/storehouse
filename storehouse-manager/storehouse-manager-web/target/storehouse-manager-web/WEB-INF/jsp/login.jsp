<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<!DOCTYPE HTML >
<html>
<head>
<%@ include file="/WEB-INF/jsp/easyui.jsp"%>
<script type="text/javascript" charset="utf-8">
	$(function() {
	$('#win').window('open')
	});
	function dologin(){
		
		$('#login').submit();
		
	}
	</script>
<body>
<div id="win" class="easyui-window" title="请先登录" data-options="closed:false,iconCls:'Lockgo',closable:false,minimizable:false" style="width:400px;padding:20px 70px 20px 70px;">  
        <form id="login" method="post" action="${pageContext.request.contextPath}/validate.action">       
            <div style="margin-bottom:10px">  
                <input class="easyui-textbox" id="username" value="root" name="usercode" style="width:100%;height:30px;padding:12px" data-options="prompt:'登录名',iconCls:'icon-man',iconWidth:38">  
            </div>  
            <div style="margin-bottom:20px">  
                <input class="easyui-textbox" id="password" value="root" type="password" name="password" style="width:100%;height:30px;padding:12px" data-options="prompt:'登录密码',iconCls:'icon-lock',iconWidth:38">  
            </div>  
            ${message}
            <!-- <div style="margin-bottom:20px">  
                <input class="easyui-textbox" type="text" id="logyzm" style="width:50%;height:30px;padding:12px" data-options="prompt:'验证码'"> 
                <img
								 
								width="56" height="20" align='absMiddle' /> <a
								href=javascript:randomcode_refresh()>刷新</a> 
            </div>   -->
            <div style="margin-bottom:20px">  
                <input type="checkbox" checked="checked" id="logrem">  
                <span>Remember me</span>  
            </div>  
           
            <div>  
                <a href="javascript:;" onclick="dologin()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="padding:5px 0px;width:100%;">  
                    <span style="font-size:14px;">登录</span>  
                </a>  
            </div>  
            
         </form>              
 </div>  
        
</body>

</html>
		


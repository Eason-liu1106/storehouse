<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE HTML >
<html>
<head>
<%@ include file="/WEB-INF/jsp/easyui.jsp"%>
<style type="text/css">

ul{
	list-style: none;
}

.hide{
	display: none;
}

.itemParam ul{
	padding-left: 0px;
}
.itemParam li{
	line-height: 25px;
}

</style>
</head>
<body >	

<table cellpadding="5" style="margin-left: 30px" id="itemParamAddTable" class="itemParam">
	<tr>
		<td>商品类目:</td>
		<td><a href="javascript:void(0)" class="easyui-linkbutton selectItemCat">选择类目</a> 
			<input type="hidden" name="cid" style="width: 280px;"></input>
			<input type="text" readonly="readonly" name="name"></input>
		</td>
	</tr>
	<tr class="hide addGroupTr">
		<td>规格参数:</td>
		<td>
			<ul>
				<li><a href="javascript:void(0)" class="easyui-linkbutton addGroup">添加分组</a></li>
			</ul>
		</td>
	</tr>
	<tr>
		<td></td>
		<td>
			<a href="javascript:void(0)" class="easyui-linkbutton submit">提交</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton close">关闭</a>
		</td>
	</tr>
</table>
<div  class="itemParamAddTemplate" style="display: none;">
	<li class="param">
		<ul>
			<li>
				<input class="easyui-textbox" style="width: 150px;" name="group"/>&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton addParam"  title="添加参数" data-options="plain:true,iconCls:'icon-add'"></a>
			</li>
			<li>
				<span>|-------</span><input  style="width: 150px;" class="easyui-textbox" name="param"/>&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton delParam" title="删除" data-options="plain:true,iconCls:'icon-cancel'"></a>						
			</li>
		</ul>
	</li>
</div>


<div id="d">
<ul id="tt"></ul>	
</div>
</body>
<script type="text/javascript" charset="utf-8">
var node=null;
function Re(){
$("<div>").css({padding:"5px"}).html("<ul>")
.window({
	width:'600',
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
    				$(".addGroupTr").hide().find(".param").remove();
    		    	
    				//  判断选择的类目是否已经添加过规格
    			  $.getJSON("${pageContext.request.contextPath}/item/param/query/itemcatid.action?itemCatId=" + node.id,function(data){
    				  if(data.status == 200 && data.data){
    					  $.messager.alert("提示", "该类目已经添加，请选择其他类目。", undefined, function(){
    						  
    						 $("#itemParamAddTable .selectItemCat").click();
    					  });
    					  return ;
    				  }else{
    					  $('#itemParamAddTable').find('[name=cid]').val(node.id);
    				    	$('#itemParamAddTable').find('[name=name]').val(node.text);
    				    	 $(".addGroupTr").show();
    				    	
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



$(".selectItemCat").on("click",function(){
	 Re();

	
});
$(".addGroup").click(function(){
	  var temple = $(".itemParamAddTemplate li").eq(0).clone();
	  $(this).parent().parent().append(temple);
	  temple.find(".addParam").click(function(){
		  var li = $(".itemParamAddTemplate li").eq(2).clone();
		  li.find(".delParam").click(function(){
			  $(this).parent().remove();
		  });
		  li.appendTo($(this).parentsUntil("ul").parent());
	  });
	  temple.find(".delParam").click(function(){
		  $(this).parent().remove();
	  });
});

$("#itemParamAddTable .close").click(function(){
	$(".panel-tool-close").click();
});

$("#itemParamAddTable .submit").click(function(){
	var params = [];
	var groups = $("#itemParamAddTable [name=group]");
	groups.each(function(i,e){
		var p = $(e).parentsUntil("ul").parent().find("[name=param]");
		var _ps = [];
		p.each(function(_i,_e){
			var _val = $(_e).siblings("input").val();
			if($.trim(_val).length>0){
				_ps.push(_val);						
			}
		});
		var _val = $(e).siblings("input").val();
		if($.trim(_val).length>0 && _ps.length > 0){
			params.push({
				"group":_val,
				"params":_ps
			});					
		}
	});
	var url = "${pageContext.request.contextPath}/item/param/save.action?cid="+$("#itemParamAddTable [name=cid]").val();
	$.post(url,{"paramData":JSON.stringify(params)},function(data){
		if(data.status == 200){
			$.messager.alert('提示','新增商品规格成功!',undefined,function(){
				$(".addGroupTr").hide();
				$('#itemParamAddTable').find('[name=cid]').val('');
				$('#itemParamAddTable').find('[name=name]').val('');
				$(".addGroupTr").hide().find(".param").remove();
				
				//$(".panel-tool-close").click();
				//$("#itemParamList").datagrid("reload");
			
			});
		}
	});
});

</script>
</html>
	

		


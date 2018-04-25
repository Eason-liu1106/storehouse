<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE HTML >
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="../js/jquery-easyui-1.4.1/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="../js/jquery-easyui-1.4.1/themes/icon.css" />
<script type="text/javascript"
	src="../js/jquery-easyui-1.4.1/jquery.min.js"></script>
<script type="text/javascript"
	src="../js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="../js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
 
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
<div style="padding:10px 10px 10px 10px">
	<form id="itemAddForm" class="itemForm" method="post">
	    <table cellpadding="5">
	        <tr>
	            <td>商品类目:</td>
	            <td>
	            	<a href="javascript:void(0)" class="easyui-linkbutton selectItemCat">选择类目</a>
	            	<input type="hidden" name="cid" style="width: 280px;"></input>
	            	<input type="text" readonly="readonly" name="name"></input>
	            </td>
	        </tr>	      
	        <tr>
	            <td>商品品牌:</td>
	            <td><input class="easyui-textbox" name="brand" ></input></td>
	        </tr>
	       
	        <tr>
	            <td>商品入库仓库:</td>
	            <td><input class="easyui-textbox" name="store_id" ></input></td>
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
	            <td><input class="easyui-textbox" name=" measureunit_id" ></input></td>
	        </tr>
	         <tr>
	            <td>商品供应商:</td>
	            <td><input class="easyui-textbox" name="supplier_id" ></input></td>
	        </tr>
	      
	         <tr>
	            <td>商品大小:</td>
	            <td><input class="easyui-textbox" name="bluk" ></input></td>
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
	            <td>商品描述:</td>
	            <td>
	                <textarea style="width:800px;height:300px;" name="description"></textarea>
	            </td>
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
</body>
<script type="text/javascript">
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
	    		url:'/item/cat/list',
	    		animate:true,
	    		onClick : function(node){
	    			if($(this).tree("isLeaf",node.target)){
	    				
	    				
	    				  $.getJSON("/item/param/query/itemcatid/" + node.id,function(data){
	        				  if(data.status == 200 && data.data){
	        					  changeItemParam(node, "itemAddForm");
	        					  $('#itemAddForm').find('[name=cid]').val(node.id);
	        				    	$('#itemAddForm').find('[name=name]').val(node.text);
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
	
	$.getJSON("/item/param/query/itemcatid/" + node.id,function(data){
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
//提交表单
	function submitForm(){
		//有效性验证
		if(!$('#itemAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//取商品价格，单位为“分”
		$("#itemAddForm [name=price]").val(eval($("#itemAddForm [name=priceView]").val()) * 100);
		//同步文本框中的商品描述
		
		//取商品的规格
		var paramJson = [];
		$("#itemAddForm .params li").each(function(i,e){
			var trs = $(e).find("tr");
			var group = trs.eq(0).text();
			var ps = [];
			for(var i = 1;i<trs.length;i++){
				var tr = trs.eq(i);
				ps.push({
					"k" : $.trim(tr.find("td").eq(0).find("span").text()),
					"v" : $.trim(tr.find("input").val())
				});
			}
			paramJson.push({
				"group" : group,
				"params": ps
			});
		});
		//把json对象转换成字符串
		paramJson = JSON.stringify(paramJson);
		$("#itemAddForm [name=itemParams]").val(paramJson);
		
		//ajax的post方式提交表单
		//$("#itemAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("/inItem/save",$("#itemAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增商品成功!');
			}
		});
	}
</script>
</html>
	

		


<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript" charset="utf-8">
	var portal;
	var panels;
	$(function() {
		$(function(){
			$('#pp').portal({
				border:false,
				fit:true
			});
			add("2018");
		});
		function add(x){
			for(var i=0; i<4; i++){
				var p = $('<div/>').appendTo('#layout_center_tabs');
				p.panel({
					title:'Title'+i,
					content:'<div style="padding:5px;">毕业设计'+x+'</div>',
					height:200,
					closable:true,
					collapsible:true
				});
				$('#pp').portal('add', {
					panel:p,
					columnIndex:i
				});
			}
			$('#pp').portal('resize');
		}
		function remove(){
			$('#pp').portal('remove',$('#pgrid'));
			$('#pp').portal('resize');
		}
	});
</script>

		<div id="pp" style="position:relative">
			<div style="width:50%;">
			 <div title="clock" collapsible="true" closable="true" width="300px" >
			    	      <iframe frameborder="0" scrolling="no" src="${pageContext.request.contextPath}/jsp/clock.jsp"  height="300px"></iframe>
			    </div>
							  
			</div>
			
			<div style="width:50%;">
				<div title="Searching" iconCls="icon-search" closable="true" style="height:80px;padding:10px;">
					<input class="easyui-searchbox">
				</div>
				<div title="Graph" closable="true" style="height:200px;text-align:center;">
					
				</div>
			</div>
		</div>


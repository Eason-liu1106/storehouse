<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE HTML >
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
<style type="text/css">

.a_demo_two {
	background-color:#3bb3e0;
	padding:10px;
	position:relative;
	font-family: 'Open Sans', sans-serif;
	font-size:12px;
	text-decoration:none;
	color:#fff;
	background-image: linear-gradient(bottom, rgb(44,160,202) 0%, rgb(62,184,229) 100%);
	background-image: -o-linear-gradient(bottom, rgb(44,160,202) 0%, rgb(62,184,229) 100%);
	background-image: -moz-linear-gradient(bottom, rgb(44,160,202) 0%, rgb(62,184,229) 100%);
	background-image: -webkit-linear-gradient(bottom, rgb(44,160,202) 0%, rgb(62,184,229) 100%);
	background-image: -ms-linear-gradient(bottom, rgb(44,160,202) 0%, rgb(62,184,229) 100%);
	background-image: -webkit-gradient(
	linear,
	left bottom,
	left top,
	color-stop(0, rgb(44,160,202)),
	color-stop(1, rgb(62,184,229))
	);
	-webkit-box-shadow: inset 0px 1px 0px #7fd2f1, 0px 6px 0px #156785;
	-moz-box-shadow: inset 0px 1px 0px #7fd2f1, 0px 6px 0px #156785;
	-o-box-shadow: inset 0px 1px 0px #7fd2f1, 0px 6px 0px #156785;
	box-shadow: inset 0px 1px 0px #7fd2f1, 0px 6px 0px #156785;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	-o-border-radius: 5px;
	border-radius: 5px;
}

.a_demo_two::before {
	background-color:#072239;
	content:"";
	display:block;
	position:absolute;
	width:100%;
	height:100%;
	padding-left:2px;
	padding-right:2px;
	padding-bottom:4px;
	left:-2px;
	top:5px;
	z-index:-1;
	-webkit-border-radius: 6px;
	-moz-border-radius: 6px;
	-o-border-radius: 6px;
	border-radius: 6px;
	-webkit-box-shadow: 0px 1px 0px #fff;
	-moz-box-shadow: 0px 1px 0px #fff;
	-o-box-shadow: 0px 1px 0px #fff;
	box-shadow: 0px 1px 0px #fff;
}

.a_demo_two:active {
	color:#156785;
	text-shadow: 0px 1px 1px rgba(255,255,255,0.3);
	background:rgb(44,160,202);
	-webkit-box-shadow: inset 0px 1px 0px #7fd2f1, inset 0px -1px 0px #156785;
	-moz-box-shadow: inset 0px 1px 0px #7fd2f1, inset 0px -1px 0px #156785;
	-o-box-shadow: inset 0px 1px 0px #7fd2f1, inset 0px -1px 0px #156785;
	box-shadow: inset 0px 1px 0px #7fd2f1, inset 0px -1px 0px #156785;
	top:7px;
}

.a_demo_two:active::before {
	top:-2px;
}
#div_Old{
   	width:400px;
	height:50px;
	border:0px solid #000	

}



</style>
</head>

	
<body>
 

<div >
<div id="div_Old"></div>
<div id="list"></div>
</div> 
<div id="chartmain" style="width:600px; height: 400px;"></div> 

</body>


<script type="text/javascript"> 


//指定图标的配置和数据

var pagecurrent=1;

	   

var option3 = {
        title:{
            text:'ECharts 数据统计'
        },
        tooltip : {
	        trigger: 'axis'
	    },
        legend:{
            data: '访问量'
        },
      
        calculable : true,
        xAxis:{
            data:["Android","IOS","PC","Other"]
        },
        yAxis : [
     	        {
     	            type : 'value'
     	        }
     	    ],
        toolbox: {
	        show : true,
	        feature : {
	            mark : {show: true},
	            dataView : {show: true, readOnly: false},
	            magicType : {show: true, type: ['line', 'bar']},
	            restore : {show: true},
	            saveAsImage : {show: true}
	        }
	    },
        yAxis:{},
        series:[

        
        {
            name:'用户量',
            type:'bar',
            data:[125,330,230,60],
          //顶部数字展示pzr  
            itemStyle: {  
                normal: {  
                    label: {  
                        show: true,//是否展示  
                        textStyle: {  
                            fontWeight:'bolder',  
                            fontSize : '12',  
                            fontFamily : '微软雅黑',  
                        }  
                    }  
                }  
            },  
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        
        }
        ]
    };

//初始化echarts实例
var e=document.getElementById('chartmain');

var myChart = echarts.init(e);

//使用制定的配置项和数据显示图表
myChart.setOption(option3);  
//var store = document.getElementsByClassName('a_demo_two');
//function js_method(a){
	
	//doAjax($(a).text());
//}
function js_method(a){
	var mess = parseInt($(a).text().replace(/[^0-9]/ig,""));//截取数字
	if($(a).text().indexOf("末页")>-1){
		pagecurrent=mess;
		doAjax(pagecurrent);
	}else if($(a).text().indexOf("首页")>-1){
		pagecurrent=1;
		doAjax(pagecurrent);
	}else if($(a).text().indexOf("上一页")>-1){
		
		pagecurrent=parseInt(pagecurrent)-1;
		doAjax(pagecurrent);
	}else if($(a).text().indexOf("下一页")>-1){
		
		pagecurrent=parseInt(pagecurrent)+1;
		doAjax(pagecurrent);
	}else{
		pagecurrent=$(a).text();
		doAjax(pagecurrent);
	}
	
	
}
function doAjax(p)
{
	$("#div_Old").empty();
	$("#list").empty();
$.ajax({
	url : '${pageContext.request.contextPath}/echarts/storename.action',
	data: {page:p},
	cache : false,
	dataType : 'JSON',
	success : function(r) {
			 for ( var j= 0; j < r.data.length; j++) {				
					 var temp=r.data[j];
					 $("#div_Old").append("<a  class='a_demo_two'><span hidden='true'>"+temp[1]+"</span>"+temp[0]+"</a>");
					 
			 }
			
			 //$("#list").append("<a>"+r.total+"</a>");
			// $("#list").append("<a href='javascript:void(0);'>上一页</a>");
			 //$("#list").append("<a href='javascript:void(0);' onclick='js_method(this)'>1</a>");
			 //$("#list").append("<a href='javascript:void(0);' onclick='js_method(this)'>2</a>");
			 //$("#list").append("<a href='javascript:void(0);' onclick='js_method(this)'>3</a>");
			// $("#list").append("<a href='javascript:void(0);'>下一页</a>");
			if(pagecurrent>1){
				$("#list").append("<a href='javascript:void(0);' onclick='js_method(this)'>首页</a>");
				$("#list").append("<a href='javascript:void(0);' onclick='js_method(this)'>上一页</a>");
			}
			for(var k=1;k<=Math.ceil(r.total/5);k++){
				$("#list").append("<a href='javascript:void(0);' onclick='js_method(this)'>"+k+"</a>");
			}
			if(pagecurrent<Math.ceil(r.total/5)){
				$("#list").append("<a href='javascript:void(0);' onclick='js_method(this)'>下一页</a>");
				$("#list").append("<a href='javascript:void(0);' onclick='js_method(this)'>末页<span style='display:none'>"+Math.ceil(r.total/5)+"</span></a>");
			}
			 $(".a_demo_two").on("click",function(){
				 $.ajax({
					 url:'${pageContext.request.contextPath}/echarts/InItem/storeId.action',
					 data: {id:$(this).find('span').text()},
					 cache : false,
					 dataType : 'JSON',
					 success : function(r) {
						 myChart.setOption({
							 
							 title : {
							        text: '仓库入库统计',
							        subtext: r.text
							    },
							    xAxis:{
						            data:r.data
						        },
						        series:
							        {
							            name:'仓储数量',
							            type:'bar',
							            data:r.name
							        }
						        
						 })
						
					 }
				 });
				
				});
	}
});
}
doAjax(1);
</script>
</html>
	

		


/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-04-10 14:39:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class outEchart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML >\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/echarts.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery-1.8.0.min.js\"></script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write(".a_demo_two {\r\n");
      out.write("\tbackground-color:#3bb3e0;\r\n");
      out.write("\tpadding:10px;\r\n");
      out.write("\tposition:relative;\r\n");
      out.write("\tfont-family: 'Open Sans', sans-serif;\r\n");
      out.write("\tfont-size:12px;\r\n");
      out.write("\ttext-decoration:none;\r\n");
      out.write("\tcolor:#fff;\r\n");
      out.write("\tbackground-image: linear-gradient(bottom, rgb(44,160,202) 0%, rgb(62,184,229) 100%);\r\n");
      out.write("\tbackground-image: -o-linear-gradient(bottom, rgb(44,160,202) 0%, rgb(62,184,229) 100%);\r\n");
      out.write("\tbackground-image: -moz-linear-gradient(bottom, rgb(44,160,202) 0%, rgb(62,184,229) 100%);\r\n");
      out.write("\tbackground-image: -webkit-linear-gradient(bottom, rgb(44,160,202) 0%, rgb(62,184,229) 100%);\r\n");
      out.write("\tbackground-image: -ms-linear-gradient(bottom, rgb(44,160,202) 0%, rgb(62,184,229) 100%);\r\n");
      out.write("\tbackground-image: -webkit-gradient(\r\n");
      out.write("\tlinear,\r\n");
      out.write("\tleft bottom,\r\n");
      out.write("\tleft top,\r\n");
      out.write("\tcolor-stop(0, rgb(44,160,202)),\r\n");
      out.write("\tcolor-stop(1, rgb(62,184,229))\r\n");
      out.write("\t);\r\n");
      out.write("\t-webkit-box-shadow: inset 0px 1px 0px #7fd2f1, 0px 6px 0px #156785;\r\n");
      out.write("\t-moz-box-shadow: inset 0px 1px 0px #7fd2f1, 0px 6px 0px #156785;\r\n");
      out.write("\t-o-box-shadow: inset 0px 1px 0px #7fd2f1, 0px 6px 0px #156785;\r\n");
      out.write("\tbox-shadow: inset 0px 1px 0px #7fd2f1, 0px 6px 0px #156785;\r\n");
      out.write("\t-webkit-border-radius: 5px;\r\n");
      out.write("\t-moz-border-radius: 5px;\r\n");
      out.write("\t-o-border-radius: 5px;\r\n");
      out.write("\tborder-radius: 5px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".a_demo_two::before {\r\n");
      out.write("\tbackground-color:#072239;\r\n");
      out.write("\tcontent:\"\";\r\n");
      out.write("\tdisplay:block;\r\n");
      out.write("\tposition:absolute;\r\n");
      out.write("\twidth:100%;\r\n");
      out.write("\theight:100%;\r\n");
      out.write("\tpadding-left:2px;\r\n");
      out.write("\tpadding-right:2px;\r\n");
      out.write("\tpadding-bottom:4px;\r\n");
      out.write("\tleft:-2px;\r\n");
      out.write("\ttop:5px;\r\n");
      out.write("\tz-index:-1;\r\n");
      out.write("\t-webkit-border-radius: 6px;\r\n");
      out.write("\t-moz-border-radius: 6px;\r\n");
      out.write("\t-o-border-radius: 6px;\r\n");
      out.write("\tborder-radius: 6px;\r\n");
      out.write("\t-webkit-box-shadow: 0px 1px 0px #fff;\r\n");
      out.write("\t-moz-box-shadow: 0px 1px 0px #fff;\r\n");
      out.write("\t-o-box-shadow: 0px 1px 0px #fff;\r\n");
      out.write("\tbox-shadow: 0px 1px 0px #fff;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".a_demo_two:active {\r\n");
      out.write("\tcolor:#156785;\r\n");
      out.write("\ttext-shadow: 0px 1px 1px rgba(255,255,255,0.3);\r\n");
      out.write("\tbackground:rgb(44,160,202);\r\n");
      out.write("\t-webkit-box-shadow: inset 0px 1px 0px #7fd2f1, inset 0px -1px 0px #156785;\r\n");
      out.write("\t-moz-box-shadow: inset 0px 1px 0px #7fd2f1, inset 0px -1px 0px #156785;\r\n");
      out.write("\t-o-box-shadow: inset 0px 1px 0px #7fd2f1, inset 0px -1px 0px #156785;\r\n");
      out.write("\tbox-shadow: inset 0px 1px 0px #7fd2f1, inset 0px -1px 0px #156785;\r\n");
      out.write("\ttop:7px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".a_demo_two:active::before {\r\n");
      out.write("\ttop:-2px;\r\n");
      out.write("}\r\n");
      out.write("#div_Old{\r\n");
      out.write("   \twidth:400px;\r\n");
      out.write("\theight:50px;\r\n");
      out.write("\tborder:0px solid #000\t\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("<body>\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("<div >\r\n");
      out.write("<div id=\"div_Old\"></div>\r\n");
      out.write("<div id=\"list\"></div>\r\n");
      out.write("</div> \r\n");
      out.write("<div id=\"chartmain\" style=\"width:600px; height: 400px;\"></div> \r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\"> \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("//指定图标的配置和数据\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("var pagecurrent=1;\r\n");
      out.write("\t   \r\n");
      out.write("\r\n");
      out.write("var option3 = {\r\n");
      out.write("        title:{\r\n");
      out.write("            text:'ECharts 数据统计'\r\n");
      out.write("        },\r\n");
      out.write("        tooltip : {\r\n");
      out.write("\t        trigger: 'axis'\r\n");
      out.write("\t    },\r\n");
      out.write("        legend:{\r\n");
      out.write("            data: '访问量'\r\n");
      out.write("        },\r\n");
      out.write("      \r\n");
      out.write("        calculable : true,\r\n");
      out.write("        xAxis:{\r\n");
      out.write("            data:[\"Android\",\"IOS\",\"PC\",\"Other\"]\r\n");
      out.write("        },\r\n");
      out.write("        yAxis : [\r\n");
      out.write("     \t        {\r\n");
      out.write("     \t            type : 'value'\r\n");
      out.write("     \t        }\r\n");
      out.write("     \t    ],\r\n");
      out.write("        toolbox: {\r\n");
      out.write("\t        show : true,\r\n");
      out.write("\t        feature : {\r\n");
      out.write("\t            mark : {show: true},\r\n");
      out.write("\t            dataView : {show: true, readOnly: false},\r\n");
      out.write("\t            magicType : {show: true, type: ['line', 'bar']},\r\n");
      out.write("\t            restore : {show: true},\r\n");
      out.write("\t            saveAsImage : {show: true}\r\n");
      out.write("\t        }\r\n");
      out.write("\t    },\r\n");
      out.write("        yAxis:{},\r\n");
      out.write("        series:[\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        {\r\n");
      out.write("            name:'用户量',\r\n");
      out.write("            type:'bar',\r\n");
      out.write("            data:[125,330,230,60],\r\n");
      out.write("          //顶部数字展示pzr  \r\n");
      out.write("            itemStyle: {  \r\n");
      out.write("                normal: {  \r\n");
      out.write("                    label: {  \r\n");
      out.write("                        show: true,//是否展示  \r\n");
      out.write("                        textStyle: {  \r\n");
      out.write("                            fontWeight:'bolder',  \r\n");
      out.write("                            fontSize : '12',  \r\n");
      out.write("                            fontFamily : '微软雅黑',  \r\n");
      out.write("                        }  \r\n");
      out.write("                    }  \r\n");
      out.write("                }  \r\n");
      out.write("            },  \r\n");
      out.write("            markPoint : {\r\n");
      out.write("                data : [\r\n");
      out.write("                    {type : 'max', name: '最大值'},\r\n");
      out.write("                    {type : 'min', name: '最小值'}\r\n");
      out.write("                ]\r\n");
      out.write("            },\r\n");
      out.write("            markLine : {\r\n");
      out.write("                data : [\r\n");
      out.write("                    {type : 'average', name: '平均值'}\r\n");
      out.write("                ]\r\n");
      out.write("            }\r\n");
      out.write("        \r\n");
      out.write("        }\r\n");
      out.write("        ]\r\n");
      out.write("    };\r\n");
      out.write("\r\n");
      out.write("//初始化echarts实例\r\n");
      out.write("var e=document.getElementById('chartmain');\r\n");
      out.write("\r\n");
      out.write("var myChart = echarts.init(e);\r\n");
      out.write("\r\n");
      out.write("//使用制定的配置项和数据显示图表\r\n");
      out.write("myChart.setOption(option3);  \r\n");
      out.write("//var store = document.getElementsByClassName('a_demo_two');\r\n");
      out.write("//function js_method(a){\r\n");
      out.write("\t\r\n");
      out.write("//\tdoAjax($(a).text());\r\n");
      out.write("//}\r\n");
      out.write("function js_method(a){\r\n");
      out.write("\tvar mess = parseInt($(a).text().replace(/[^0-9]/ig,\"\"));//截取数字\r\n");
      out.write("\tif($(a).text().indexOf(\"末页\")>-1){\r\n");
      out.write("\t\tpagecurrent=mess;\r\n");
      out.write("\t\tdoAjax(pagecurrent);\r\n");
      out.write("\t}else if($(a).text().indexOf(\"首页\")>-1){\r\n");
      out.write("\t\tpagecurrent=1;\r\n");
      out.write("\t\tdoAjax(pagecurrent);\r\n");
      out.write("\t}else if($(a).text().indexOf(\"上一页\")>-1){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tpagecurrent=parseInt(pagecurrent)-1;\r\n");
      out.write("\t\tdoAjax(pagecurrent);\r\n");
      out.write("\t}else if($(a).text().indexOf(\"下一页\")>-1){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tpagecurrent=parseInt(pagecurrent)+1;\r\n");
      out.write("\t\tdoAjax(pagecurrent);\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\tpagecurrent=$(a).text();\r\n");
      out.write("\t\tdoAjax(pagecurrent);\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("function doAjax(p)\r\n");
      out.write("{\r\n");
      out.write("\t$(\"#div_Old\").empty();\r\n");
      out.write("\t$(\"#list\").empty();\r\n");
      out.write("$.ajax({\r\n");
      out.write("\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/echarts/storename.action',\r\n");
      out.write("\tdata: {page:p},\r\n");
      out.write("\tcache : false,\r\n");
      out.write("\tdataType : 'JSON',\r\n");
      out.write("\tsuccess : function(r) {\r\n");
      out.write("\t\t\t for ( var j= 0; j < r.data.length; j++) {\t\t\t\t\r\n");
      out.write("\t\t\t\t\t var temp=r.data[j];\r\n");
      out.write("\t\t\t\t\t $(\"#div_Old\").append(\"<a  class='a_demo_two'><span hidden='true'>\"+temp[1]+\"</span>\"+temp[0]+\"</a>\");\r\n");
      out.write("\t\t\t\t\t \r\n");
      out.write("\t\t\t }\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t //$(\"#list\").append(\"<a>\"+r.total+\"</a>\");\r\n");
      out.write("\t\t\t// $(\"#list\").append(\"<a href='javascript:void(0);'>上一页</a>\");\r\n");
      out.write("\t\t\t// $(\"#list\").append(\"<a href='javascript:void(0);' onclick='js_method(this)'>1</a>\");\r\n");
      out.write("\t\t\t// $(\"#list\").append(\"<a href='javascript:void(0);' onclick='js_method(this)'>2</a>\");\r\n");
      out.write("\t\t\t //$(\"#list\").append(\"<a href='javascript:void(0);' onclick='js_method(this)'>3</a>\");\r\n");
      out.write("\t\t\t// $(\"#list\").append(\"<a href='javascript:void(0);'>下一页</a>\");\r\n");
      out.write("\t\t\tif(pagecurrent>1){\r\n");
      out.write("\t\t\t\t$(\"#list\").append(\"<a href='javascript:void(0);' onclick='js_method(this)'>首页</a>\");\r\n");
      out.write("\t\t\t\t$(\"#list\").append(\"<a href='javascript:void(0);' onclick='js_method(this)'>上一页</a>\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tfor(var k=1;k<=Math.ceil(r.total/5);k++){\r\n");
      out.write("\t\t\t\t$(\"#list\").append(\"<a href='javascript:void(0);' onclick='js_method(this)'>\"+k+\"</a>\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(pagecurrent<Math.ceil(r.total/5)){\r\n");
      out.write("\t\t\t\t$(\"#list\").append(\"<a href='javascript:void(0);' onclick='js_method(this)'>下一页</a>\");\r\n");
      out.write("\t\t\t\t$(\"#list\").append(\"<a href='javascript:void(0);' onclick='js_method(this)'>末页<span style='display:none'>\"+Math.ceil(r.total/5)+\"</span></a>\");\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t $(\".a_demo_two\").on(\"click\",function(){\r\n");
      out.write("\t\t\t\t $.ajax({\r\n");
      out.write("\t\t\t\t\t url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/echarts/OutItem/storeId.action',\r\n");
      out.write("\t\t\t\t\t data: {id:$(this).find('span').text()},\r\n");
      out.write("\t\t\t\t\t cache : false,\r\n");
      out.write("\t\t\t\t\t dataType : 'JSON',\r\n");
      out.write("\t\t\t\t\t success : function(r) {\r\n");
      out.write("\t\t\t\t\t\t myChart.setOption({\r\n");
      out.write("\t\t\t\t\t\t\t \r\n");
      out.write("\t\t\t\t\t\t\t title : {\r\n");
      out.write("\t\t\t\t\t\t\t        text: '仓库出库统计',\r\n");
      out.write("\t\t\t\t\t\t\t        subtext: r.text\r\n");
      out.write("\t\t\t\t\t\t\t    },\r\n");
      out.write("\t\t\t\t\t\t\t    xAxis:{\r\n");
      out.write("\t\t\t\t\t\t            data:r.data\r\n");
      out.write("\t\t\t\t\t\t        },\r\n");
      out.write("\t\t\t\t\t\t        series:\r\n");
      out.write("\t\t\t\t\t\t\t        {\r\n");
      out.write("\t\t\t\t\t\t\t            name:'仓储数量',\r\n");
      out.write("\t\t\t\t\t\t\t            type:'bar',\r\n");
      out.write("\t\t\t\t\t\t\t            data:r.name\r\n");
      out.write("\t\t\t\t\t\t\t        }\r\n");
      out.write("\t\t\t\t\t\t        \r\n");
      out.write("\t\t\t\t\t\t })\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t }\r\n");
      out.write("\t\t\t\t });\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("});\r\n");
      out.write("}\r\n");
      out.write("doAjax(1);\r\n");
      out.write("</script>\r\n");
      out.write("</html>\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

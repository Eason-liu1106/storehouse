/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-05-14 09:42:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class customerManager_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/jsp/easyui.jsp", Long.valueOf(1525675866001L));
  }

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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" id=\"easyuiTheme\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery-easyui-1.4.1/themes/metro-blue/easyui.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery-easyui-1.4.1/themes/icon.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery-easyui-portal/portal.css\" />\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery-easyui-1.4.1/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery-easyui-1.4.1/jquery.easyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery-easyui-portal/jquery.portal.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.cookie.js\"></script>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\">\r\n");
      out.write("\tvar customer_searchForm;\r\n");
      out.write("\tvar editRow = undefined;\r\n");
      out.write("\tvar customer_datagrid; \r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\tcustomer_searchForm = $('#customer_searchForm').form();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\tcustomer_datagrid = $('#customer_datagrid').datagrid({\r\n");
      out.write("\t\r\n");
      out.write("\t\t\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/customer/list.action',\r\n");
      out.write("\t\t\ttitle : '客户列表',\r\n");
      out.write("\t\t\ticonCls : 'icon-save',\r\n");
      out.write("\t\t\tpagination : true,\r\n");
      out.write("\t\t\tpagePosition : 'bottom',\r\n");
      out.write("\t\t\tpageSize : 10,\r\n");
      out.write("\t\t\tpageList : [ 10, 20, 30, 40 ],\r\n");
      out.write("\t\t\tfit : true,\r\n");
      out.write("\t\t\tfitColumns : false,\r\n");
      out.write("\t\t\tnowrap : true,\r\n");
      out.write("\t\t\tborder : false,\r\n");
      out.write("\t\t\tidField : 'id',\r\n");
      out.write("\t\t\tsortName : 'name',\r\n");
      out.write("\t\t\tsortOrder : 'desc',\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t//列表\r\n");
      out.write("\t\t\tfrozenColumns : [ [ {\r\n");
      out.write("\t\t\t\ttitle : '编号',\r\n");
      out.write("\t\t\t\tfield : 'id',\r\n");
      out.write("\t\t\t\twidth : 120,\r\n");
      out.write("\t\t\t\tsortable : true,\r\n");
      out.write("\t\t\t\tcheckbox : true\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\ttitle : '单位名称',\r\n");
      out.write("\t\t\t\tfield : 'name',\r\n");
      out.write("\t\t\t\twidth : 200,\r\n");
      out.write("\t\t\t\tsortable : true,\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t} ] ],\r\n");
      out.write("\t\t\tcolumns : [ [ \r\n");
      out.write("\t\t\t{ \r\n");
      out.write("\t\t\t\ttitle : '地址',\r\n");
      out.write("\t\t\t\tfield : 'address',\r\n");
      out.write("\t\t\t\twidth : 200,\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\t{ \r\n");
      out.write("\t\t\t\ttitle : '邮编',\r\n");
      out.write("\t\t\t\tfield : 'postcode',\r\n");
      out.write("\t\t\t\twidth : 100,\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t{ \r\n");
      out.write("\t\t\t\ttitle : '电话',\r\n");
      out.write("\t\t\t\tfield : 'phone',\r\n");
      out.write("\t\t\t\twidth : 150,\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t{ \r\n");
      out.write("\t\t\t\ttitle : '网址',\r\n");
      out.write("\t\t\t\tfield : 'www',\r\n");
      out.write("\t\t\t\twidth : 150,\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t{ \r\n");
      out.write("\t\t\t\ttitle : '营业执照号',\r\n");
      out.write("\t\t\t\tfield : 'licence',\r\n");
      out.write("\t\t\t\twidth : 150,\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\t{ \r\n");
      out.write("\t\t\t\ttitle : '开户银行',\r\n");
      out.write("\t\t\t\tfield : 'bank',\r\n");
      out.write("\t\t\t\twidth : 150,\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\t{ \r\n");
      out.write("\t\t\t\ttitle : '银行帐号',\r\n");
      out.write("\t\t\t\tfield : 'account',\r\n");
      out.write("\t\t\t\twidth : 150,\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\t{ \r\n");
      out.write("\t\t\t\ttitle : '负责人',\r\n");
      out.write("\t\t\t\tfield : 'answerMan',\r\n");
      out.write("\t\t\t\twidth : 150,\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\t{ \r\n");
      out.write("\t\t\t\ttitle : '联系人',\r\n");
      out.write("\t\t\t\tfield : 'contactMan',\r\n");
      out.write("\t\t\t\twidth : 150,\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\t{ \r\n");
      out.write("\t\t\t\ttitle : '备注',\r\n");
      out.write("\t\t\t\tfield : 'remark',\r\n");
      out.write("\t\t\t\twidth : 200,\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\ttitle : '创建时间',\r\n");
      out.write("\t\t\t\tfield : 'createdatetime', \r\n");
      out.write("\t\t\t\tsortable : true,\r\n");
      out.write("\t\t\t\twidth : 150,\r\n");
      out.write("\t\t\t\tformatter : function(value){ \r\n");
      out.write("\t\t\t\t\t return formatterdate(value);\r\n");
      out.write("\t\t\t\t }\r\n");
      out.write("\t\t\t}, {\r\n");
      out.write("\t\t\t\ttitle : '最后修改时间',\r\n");
      out.write("\t\t\t\tfield : 'modifydatetime',\r\n");
      out.write("\t\t\t\tsortable : true,\r\n");
      out.write("\t\t\t\twidth : 150,\r\n");
      out.write("\t\t\t\t formatter : function(value){ \r\n");
      out.write("\t\t\t\t\t return formatterdate(value);\r\n");
      out.write("\t\t\t\t }\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\t] ],\r\n");
      out.write("\t\t\t\t//列表结束\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t//工具条\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\ttoolbar : [ {\r\n");
      out.write("\t\t\t\t\ttext : '增加',\r\n");
      out.write("\t\t\t\t\ticonCls : 'icon-add',\r\n");
      out.write("\t\t\t\t\thandler : function() {\r\n");
      out.write("\t\t\t\t\t\t//parent.add();\r\n");
      out.write("\t\t\t\t\t\tcustomer_add();\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}, '-', {\r\n");
      out.write("\t\t\t\t\ttext : '删除',\r\n");
      out.write("\t\t\t\t\ticonCls : 'icon-remove',\r\n");
      out.write("\t\t\t\t\thandler : function() {\r\n");
      out.write("\t\t\t\t\t\tcustomer_del();\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}, '-', {\r\n");
      out.write("\t\t\t\t\ttext : '修改',\r\n");
      out.write("\t\t\t\t\ticonCls : 'icon-edit',\r\n");
      out.write("\t\t\t\t\thandler : function() {\r\n");
      out.write("\t\t\t\t\t\tcustomer_edit();\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}, '-', {\r\n");
      out.write("\t\t\t\t\ttext : '保存',\r\n");
      out.write("\t\t\t\t\ticonCls : 'icon-save',\r\n");
      out.write("\t\t\t\t\thandler : function() {\r\n");
      out.write("\t\t\t\t\t\tif (editRow != undefined) {\r\n");
      out.write("\t\t\t\t\t\t\tcustomer_datagrid.datagrid('endEdit', editRow);\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t\t'-', {\r\n");
      out.write("\t\t\t\t\ttext : '取消编辑',\r\n");
      out.write("\t\t\t\t\ticonCls : 'icon-undo',\r\n");
      out.write("\t\t\t\t\thandler : function() {\r\n");
      out.write("\t\t\t\t\t\tcustomer_datagrid.datagrid('unselectAll');\r\n");
      out.write("\t\t\t\t\t\tcustomer_datagrid.datagrid.datagrid('rejectChanges');\r\n");
      out.write("\t\t\t\t\t\teditRow = undefined;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t},  '-', {\r\n");
      out.write("\t\t\t\t\ttext : '查看',\r\n");
      out.write("\t\t\t\t\ticonCls : 'icon-search',\r\n");
      out.write("\t\t\t\t\thandler : function() {\r\n");
      out.write("\t\t\t\t\t\tedit();\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t},'-', {\r\n");
      out.write("\t\t\t\t\ttext : '取消选中',\r\n");
      out.write("\t\t\t\t\ticonCls : 'icon-undo',\r\n");
      out.write("\t\t\t\t\thandler : function() {\r\n");
      out.write("\t\t\t\t\t\tcustomer_datagrid.datagrid('unselectAll');\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t],\r\n");
      out.write("\t\t//工具条结束\r\n");
      out.write("\t\t\t//方法\r\n");
      out.write("\t\tonLoadSuccess:function(data){  \r\n");
      out.write("            $(\".tip\").tooltip({  \r\n");
      out.write("                onShow: function(){  \r\n");
      out.write("                    $(this).tooltip('tip').css({   \r\n");
      out.write("                        width:'300',          \r\n");
      out.write("                        boxShadow: '1px 1px 3px #292929'                          \r\n");
      out.write("                    });  \r\n");
      out.write("                }  \r\n");
      out.write("            });  \r\n");
      out.write("\t\t},\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t});\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t});\r\n");
      out.write("\tfunction customer_del(){\r\n");
      out.write("\t\tvar rows = customer_datagrid.datagrid('getSelections');\r\n");
      out.write("\t\tvar ids = [];\r\n");
      out.write("\t\tvar copyRows = [];\r\n");
      out.write("       \r\n");
      out.write("\t\t if (rows == null) {  \r\n");
      out.write("\t\t        $.messager.show(\"提示\", \"请选择要删除的行！\");  \r\n");
      out.write("\t\t    } else{\r\n");
      out.write("\t\t    \tfor ( var j= 0; j < rows.length; j++) {\r\n");
      out.write("\t\t            ids.push(rows[j].id);\r\n");
      out.write("\t\t            }\r\n");
      out.write("\t\t    \t$.messager.confirm('询问', '您确定要删除【' + rows.length + '】个客户?', function(b) {\t\t\t\t \r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t    \t\tif (b) {\r\n");
      out.write("\t\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\t\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/customer/delete.action?ids='+ids+'',\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\tcache : false,\r\n");
      out.write("\t\t\t\t\t\t\tdataType : 'JSON',\r\n");
      out.write("\t\t\t\t\t\t\tsuccess : function(r) {\r\n");
      out.write("\t\t\t\t\t\t\t\tif (r.status='200') {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t for ( var j= 0; j < rows.length; j++) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t        copyRows.push(rows[j]);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t        \t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t     for(var i =0;i<copyRows.length;i++){    \r\n");
      out.write("\t\t\t\t\t\t\t\t\t            var index = customer_datagrid.datagrid('getRowIndex',copyRows[i]);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t            customer_datagrid.datagrid('deleteRow',index); \r\n");
      out.write("\t\t\t\t\t\t\t\t\t        }\r\n");
      out.write("\t\t\t\t\t\t\t\t\t     customer_datagrid.datagrid('reload');\r\n");
      out.write("\t\t\t\t\t\t\t\t\t//customer_datagrid.datagrid('clearSelections'); //清空选中的行 \r\n");
      out.write("\t\t\t\t\t\t\t\t\t$.messager.show({\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmsg : r.msg,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\ttitle : '提示'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t\t}else if(r.status='404')\r\n");
      out.write("\t\t\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$.messager.show({\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmsg : r.msg,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\ttitle : '提示'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t    \t\r\n");
      out.write("\t\t    \t});\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t    }\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction customer_edit() {\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar rows = customer_datagrid.datagrid('getSelections');\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif (rows.length >1) {\r\n");
      out.write("\t\t\tvar names = [];\r\n");
      out.write("\t\t\tfor ( var i = 0; i < rows.length; i++) {\r\n");
      out.write("\t\t\t\tnames.push(rows[i].name);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t$.messager.show({\r\n");
      out.write("\t\t\t\tmsg : '只能择一个客户进行编辑！您已经选择了【' + names.join(',') + '】' + rows.length + '个客户',\r\n");
      out.write("\t\t\t\ttitle : '提示'\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t} else if (rows.length == 1) {\r\n");
      out.write("\t\t\tvar node = customer_datagrid.datagrid('getSelected');\r\n");
      out.write("\t\t\tvar d=$('<div/>').dialog({\r\n");
      out.write("\t\t\t\thref : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/customerManager/edit.action',\r\n");
      out.write("\t\t\t\twidth : 500,\r\n");
      out.write("\t\t\t\theight : 380,\r\n");
      out.write("\t\t\t\tmodal : true,\r\n");
      out.write("\t\t\t\ttitle : '编辑客户',\r\n");
      out.write("\t\t\t\tloadingMessage: '正在加载...',  \r\n");
      out.write("\t\t\t\tbuttons : [ {\r\n");
      out.write("\t\t\t\t\ttext : '确定',\r\n");
      out.write("\t\t\t\t\ticonCls : 'icon-edit',\r\n");
      out.write("\t\t\t\t\thandler : function() {\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t$('#editCustomer').form('submit', {\r\n");
      out.write("\t\t\t\t\t\t\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/customer/edit.action',\r\n");
      out.write("\t\t\t\t\t\t\tsuccess : function(result) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\tvar r = $.parseJSON(result);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\tif(r.status='200') \r\n");
      out.write("\t\t\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t$.messager.show({\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttitle : '提示',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tmsg : r.msg\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tcustomer_datagrid.datagrid('reload');\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\td.dialog('destroy');\r\n");
      out.write("\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\telse if(r.status='404'){\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t$.messager.alert({\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttitle : '警告',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tmsg : r.msg\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t$.messager.show({\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttitle : '提示',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tmsg : '服务器正忙,请稍后修改'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t} ],\r\n");
      out.write("\t\t\t\tonClose : function() {\r\n");
      out.write("\t\t\t\t\td.dialog(\"destroy\");\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tonLoad : function() {\r\n");
      out.write("\t\t\t\t\t$('#editCustomer').form('load', node);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\t$.messager.show({\r\n");
      out.write("\t\t\t\tmsg : '请选择一个客户类型进行编辑!',\r\n");
      out.write("\t\t\t\ttitle : '提示'\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction customer_add() {\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar d=$('<div/>').dialog({\r\n");
      out.write("\t\t\thref : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/customerManager/add.action',\r\n");
      out.write("\t\t\twidth : 500,\r\n");
      out.write("\t\t\theight : 380,\r\n");
      out.write("\t\t\tmodal : true,\r\n");
      out.write("\t\t\ttitle : '添加客户',\r\n");
      out.write("\t\t\tloadingMessage: '正在加载...',  \r\n");
      out.write("\t\t\tbuttons : [ {\r\n");
      out.write("\t\t\t\ttext : '增加',\r\n");
      out.write("\t\t\t\ticonCls : 'icon-ok',\r\n");
      out.write("\t\t\t\thandler : function() {\r\n");
      out.write("\t\t\t\t\t//$(this).closest('.window-body').dialog(\"close\");\r\n");
      out.write("\t\t\t\t\t//var d = $(this).closest('.window-body');\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t$('#addCustomer').form('submit', {\r\n");
      out.write("\t\t\t\t\t\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/customer/add.action',\r\n");
      out.write("\t\t\t\t\t\tsuccess : function(result) {\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\tvar r = $.parseJSON(result);\r\n");
      out.write("\t\t\t\t\t\t \t\t\r\n");
      out.write("\t\t\t\t\t\t\t\tif(r.status='200')\r\n");
      out.write("\t\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$.messager.show({\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\ttitle : '提示',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmsg : r.msg\r\n");
      out.write("\t\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t\t\t//customer_datagrid.datagrid('appendRow',r.data);\r\n");
      out.write("\t\t\t\t\t\t\t\t\tcustomer_datagrid.datagrid('load',{});\r\n");
      out.write("\t\t\t\t\t\t\t\t\td.dialog('destroy');\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\telse if(r.status='404'){\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$.messager.alert({\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\ttitle : '警告',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmsg : r.msg\r\n");
      out.write("\t\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$.messager.show({\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\ttitle : '提示',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmsg : '服务器正忙,请稍后添加'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t} ],\r\n");
      out.write("\t\t\tonClose : function() {\r\n");
      out.write("\t\t\t\td.dialog(\"destroy\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction customer_search() {\r\n");
      out.write("\t\tcustomer_datagrid.datagrid('load',  serializeObject(customer_searchForm));\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction customer_cleanSearch() {\r\n");
      out.write("\t\tcustomer_datagrid.datagrid('load', {});\r\n");
      out.write("\t\tcustomer_searchForm.find('input').val('');\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tserializeObject = function(form) {\r\n");
      out.write("\t\tvar o = {};\r\n");
      out.write("\t\t$.each(form.serializeArray(), function(index) {\r\n");
      out.write("\t\t\tif (o[this['name']]) {\r\n");
      out.write("\t\t\t\to[this['name']] = o[this['name']] + \",\" + this['value'];\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\to[this['name']] = this['value'];\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\treturn o;\r\n");
      out.write("\t};\r\n");
      out.write("var\tformatterdate = function(value){\r\n");
      out.write("\t\r\n");
      out.write("\t\t var date = new Date(value);\r\n");
      out.write("        var y = date.getFullYear();\r\n");
      out.write("        var M = date.getMonth() + 1;\r\n");
      out.write("        var d = date.getDate();\r\n");
      out.write("        var h = date.getHours();//hour \r\n");
      out.write("        var m = date.getMinutes(); //minute \r\n");
      out.write("        var s = date.getSeconds(); //second \r\n");
      out.write("        return y + '-' +M + '-' + d+ ' ' + h+ ':' + m+ ':' + s;\r\n");
      out.write("\t \r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"easyui-layout\">\r\n");
      out.write("\t<div region=\"north\" border=\"false\" title=\"过滤条件\" style=\"height: 110px;overflow: hidden;\" align=\"left\">\r\n");
      out.write("\t\t<form id=\"customer_searchForm\">\r\n");
      out.write("\t\t\t<table class=\"tableForm datagrid-toolbar\" style=\"width: 100%;height: 100%;\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th>客户名</th>\r\n");
      out.write("\t\t\t\t\t<td><input name=\"name\" style=\"width:315px;\" /></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th>创建时间</th>\r\n");
      out.write("\t\t\t\t\t<td><input name=\"createdatetimeStart\" class=\"easyui-datetimebox\" editable=\"false\" style=\"width: 155px;\" />至<input name=\"createdatetimeEnd\" class=\"easyui-datetimebox\" editable=\"false\" style=\"width: 155px;\" /></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th>最后修改时间</th>\r\n");
      out.write("\t\t\t\t\t<td><input name=\"modifydatetimeStart\" class=\"easyui-datetimebox\" editable=\"false\" style=\"width: 155px;\" />至<input name=\"modifydatetimeEnd\" class=\"easyui-datetimebox\" editable=\"false\" style=\"width: 155px;\" /><a href=\"javascript:void(0);\" class=\"easyui-linkbutton\" onclick=\"customer_search();\">过滤</a><a href=\"javascript:void(0);\" class=\"easyui-linkbutton\" onclick=\"customer_cleanSearch();\">取消</a></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div region=\"center\" border=\"false\">\r\n");
      out.write("\t\t<table id=\"customer_datagrid\"></table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");
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

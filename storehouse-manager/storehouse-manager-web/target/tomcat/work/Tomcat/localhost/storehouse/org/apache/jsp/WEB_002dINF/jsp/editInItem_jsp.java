/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-05-14 09:22:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class editInItem_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\t   \r\n");
      out.write("            \r\n");
      out.write("  <div style=\"padding:10px 60px 20px 60px\">  \r\n");
      out.write("     <form id=\"editInItem\" method=\"post\">  \r\n");
      out.write("         <table cellpadding=\"10\">       \r\n");
      out.write("             <tr>  \r\n");
      out.write("                   \r\n");
      out.write("                 <td><input hidden=\"true\" style=\"width: 156px;\" name=\"storeName\" data-options=\"required:true\"></input></td>                  \r\n");
      out.write("                 <td><input hidden=\"true\" style=\"width: 156px;\" class=\"easyui-validatebox\" name=\"measureunitName\"  data-options=\"required:true\" ></input></td>                    \r\n");
      out.write("                 <td><input hidden=\"true\" style=\"width: 156px;\" class=\"easyui-validatebox\" name=\"supplierName\"  data-options=\"required:true\" ></input></td> \r\n");
      out.write("                 \r\n");
      out.write("\t        \t <td>\r\n");
      out.write("\t        \t \t<input hidden=\"true\" name=\"itemCatId\" style=\"width: 280px;\"></input>\r\n");
      out.write("\t            \t<input hidden=\"true\" readonly=\"readonly\" name=\"itemCatName\"></input>\r\n");
      out.write("\t        \t \t<input hidden=\"true\"  name=\"storeId\" data-options=\"required:true\"></input>\r\n");
      out.write("\t        \t \t<input id=\"editRack\" hidden=\"true\"  name=\"position\"></input>\r\n");
      out.write("\t        \t \t<input hidden=\"true\" name=\"id\" data-options=\"required:true\"></input> \r\n");
      out.write("                 \t<input hidden=\"true\"  name=\"inUserId\" data-options=\"required:true\"/>\r\n");
      out.write("\t        \t \t<input  hidden=\"true\" name=\"inUserName\" ></input>\r\n");
      out.write("\t        \t \t<input  hidden=\"true\" type=\"text\" name=\"num\" data-options=\"min:1,max:99999999,precision:0,required:true\" />\r\n");
      out.write("\t        \t </td>\r\n");
      out.write("             </tr>   \r\n");
      out.write("            <!--  <tr>\r\n");
      out.write("\t            <td>商品类目:</td>\r\n");
      out.write("\t            <td>\r\n");
      out.write("\t            \t<a href=\"javascript:void(0)\" class=\"easyui-linkbutton selectItemCat\">选择类目</a>\r\n");
      out.write("\t            \t<input type=\"hidden\" name=\"itemCatId\" style=\"width: 280px;\"></input>\r\n");
      out.write("\t            \t<input type=\"text\" readonly=\"readonly\" name=\"itemCatName\"></input>\r\n");
      out.write("\t            </td>\r\n");
      out.write("\t        </tr>\t -->  \r\n");
      out.write("         \r\n");
      out.write("            <!-- \r\n");
      out.write("            <tr>\r\n");
      out.write("\t            <td>商品入库仓库:</td>\r\n");
      out.write("\t            <td><input class=\"easyui-textbox\"  name=\"storeId\" data-options=\"required:true\"></input></td>\r\n");
      out.write("\t        </tr> -->\r\n");
      out.write("\t        <tr>\r\n");
      out.write("\t            <td>商品品牌:</td>\r\n");
      out.write("\t            <td><input class=\"easyui-textbox\" name=\"brand\" ></input></td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t         \r\n");
      out.write("\t         \r\n");
      out.write("\t        <tr>\r\n");
      out.write("\t            <td>商品租期(月):</td>\r\n");
      out.write("\t            <td><input class=\"easyui-textbox\" name=\"time\" ></input></td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t        <!--  <tr>\r\n");
      out.write("\t            <td>商品货架位置:</td>\r\n");
      out.write("\t            <td><input class=\"easyui-textbox\" name=\"position\" ></input></td>\r\n");
      out.write("\t        </tr>-->\r\n");
      out.write("\t       <!--  <tr>\r\n");
      out.write("\t            <td>商品货架位置:</td>\r\n");
      out.write("\t            <td><input id=\"editRack\" class=\"easyui-combobox\"  name=\"position\"></input></td>\r\n");
      out.write("\t        </tr> -->\r\n");
      out.write("\t         <tr>\r\n");
      out.write("\t            <td>商品计量单位:</td>\r\n");
      out.write("\t            <td><input class=\"easyui-textbox\" name=\"measureunitId\"></input></td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t         <tr>\r\n");
      out.write("\t            <td>商品供应商:</td>\r\n");
      out.write("\t            <td><input class=\"easyui-textbox\" name=\"supplierId\" ></input></td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t      \t\r\n");
      out.write("\t         <tr>\r\n");
      out.write("\t            <td>商品大小:</td>\r\n");
      out.write("\t            <td><input class=\"easyui-textbox\" name=\"bulk\" ></input></td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t        <tr>\r\n");
      out.write("\t            <td>商品价格:</td>\r\n");
      out.write("\t            <td><input class=\"easyui-numberbox\" type=\"text\" name=\"money\" data-options=\"min:1,max:99999999,precision:2,required:true\" />\r\n");
      out.write("\t            \t<input type=\"hidden\" name=\"price\"/>\r\n");
      out.write("\t            </td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t         <tr>\r\n");
      out.write("\t            <td>商品实付金额:</td>\r\n");
      out.write("\t            <td><input class=\"easyui-textbox\" name=\"pay\" ></input></td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t      <!--   <tr>\r\n");
      out.write("\t            <td>入库负责人:</td>\r\n");
      out.write("\t            <td><input class=\"easyui-textbox\" hidden=\"true\" name=\"inUserName\" ></input></td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t        <tr>\r\n");
      out.write("\t            <td>库存数量:</td>\r\n");
      out.write("\t            <td><input class=\"easyui-numberbox\" hidden=\"true\" type=\"text\" name=\"num\" data-options=\"min:1,max:99999999,precision:0,required:true\" /></td>\r\n");
      out.write("\t        </tr> -->\r\n");
      out.write("\t       \r\n");
      out.write("              <tr>  \r\n");
      out.write("                 <td>描述:</td>  \r\n");
      out.write("                 <td><textarea name=\"description\" rows=\"8\" cols=\"24\"></textarea></td>  \r\n");
      out.write("             </tr>    \r\n");
      out.write("             <tr class=\"params hide\">\r\n");
      out.write("\t        \t<td>商品规格:</td>\r\n");
      out.write("\t        \t<td>\r\n");
      out.write("\t        \t\t\r\n");
      out.write("\t        \t</td>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t       \r\n");
      out.write("         </table> \r\n");
      out.write("  \t\t<input type=\"hidden\" name=\"itemParams\"/>\r\n");
      out.write("     </form>  \r\n");
      out.write("     <div style=\"padding:5px\">\r\n");
      out.write("\t    <a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" onclick=\"submitForm()\">提交</a>\r\n");
      out.write("\t    <a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" onclick=\"clearForm()\">重置</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("    \r\n");
      out.write(" </div>  \r\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\">        \r\n");
      out.write("/*var store_Datagrid= $('input[name=\"storeId\"]').combogrid({\r\n");
      out.write("\tloadMsg : '数据加载中....',\r\n");
      out.write("\tpanelWidth : 440,\r\n");
      out.write("\tpanelHeight : 180,\r\n");
      out.write("\trequired : true,\r\n");
      out.write("\tfitColumns : true,\r\n");
      out.write("\tvalue : '',\r\n");
      out.write("\tvalueField:'name',\r\n");
      out.write("\tidField : 'id',\r\n");
      out.write("\ttextField : 'name',\r\n");
      out.write("\tmode : 'remote',\r\n");
      out.write("\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/store/list.action',\r\n");
      out.write("\tpagination : true,\r\n");
      out.write("\tpageSize : 5,\r\n");
      out.write("\tpageList : [ 5, 10 ],\r\n");
      out.write("    //onSelect: function (rowIndex, rowData){  \r\n");
      out.write("    \r\n");
      out.write("    \t//$('input[name=\"storeName\"]').val(rowData.name);\r\n");
      out.write("        //}  ,\r\n");
      out.write("    onSelect: function (rowIndex, rowData){  \r\n");
      out.write("    \t\r\n");
      out.write("    \tvar url = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/rack/combox.action?id='+rowData.id;\r\n");
      out.write("    \t$('#editRack').combobox({\r\n");
      out.write("    \t    url:url,\r\n");
      out.write("    \t    valueField:'position',\r\n");
      out.write("    \t    textField:'position'\r\n");
      out.write("    \t});\r\n");
      out.write("    \t$('input[name=\"storeName\"]').val(rowData.name);\r\n");
      out.write("    \t//$('input[name=\"position\"]').combobox('reload', url);\r\n");
      out.write("        }  ,\r\n");
      out.write("\tcolumns : [ [ {\r\n");
      out.write("\t\tfield : 'id',\r\n");
      out.write("\t\ttitle : '编号',\r\n");
      out.write("\t\twidth : 60,\r\n");
      out.write("\t\thidden : true\r\n");
      out.write("\t}, {\r\n");
      out.write("\t\tfield : 'name',\r\n");
      out.write("\t\ttitle : '仓库名',\r\n");
      out.write("\t\twidth : 100,\r\n");
      out.write("\t\tsortable : true\r\n");
      out.write("\t}, {\r\n");
      out.write("\t\tfield : 'createdatetime',\r\n");
      out.write("\t\ttitle : '创建时间',\r\n");
      out.write("\t\twidth : 150,\r\n");
      out.write("\t\tsortable : true,\r\n");
      out.write("\t\tformatter : function(value){ \r\n");
      out.write("\t\t\t return formatterdate(value);\r\n");
      out.write("\t\t }\r\n");
      out.write("\t\t\r\n");
      out.write("\t}, {\r\n");
      out.write("\t\tfield : 'modifydatetime',\r\n");
      out.write("\t\ttitle : '最后修改时间',\r\n");
      out.write("\t\twidth : 150,\r\n");
      out.write("\t\tsortable : true,\r\n");
      out.write("\t\tformatter : function(value){ \r\n");
      out.write("\t\t\t return formatterdate(value);\r\n");
      out.write("\t\t }\r\n");
      out.write("\t} ] ],\r\n");
      out.write("\tdelay : 500\r\n");
      out.write("});*/\r\n");
      out.write("var supplier_Datagrid= $('input[name=\"supplierId\"]').combogrid({\r\n");
      out.write("\tloadMsg : '数据加载中....',\r\n");
      out.write("\tpanelWidth : 440,\r\n");
      out.write("\tpanelHeight : 180,\r\n");
      out.write("\trequired : true,\r\n");
      out.write("\tfitColumns : true,\r\n");
      out.write("\tvalue : '',\r\n");
      out.write("\tvalueField:'name',\r\n");
      out.write("\tidField : 'id',\r\n");
      out.write("\ttextField : 'name',\r\n");
      out.write("\tmode : 'remote',\r\n");
      out.write("\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/supplier/list.action',\r\n");
      out.write("\tpagination : true,\r\n");
      out.write("\tpageSize : 5,\r\n");
      out.write("\tpageList : [ 5, 10 ],\r\n");
      out.write("    onSelect: function (rowIndex, rowData){  \r\n");
      out.write("    \r\n");
      out.write("    \t$('input[name=\"supplierName\"]').val(rowData.name);\r\n");
      out.write("        }  ,\r\n");
      out.write("\tcolumns : [ [ {\r\n");
      out.write("\t\tfield : 'id',\r\n");
      out.write("\t\ttitle : '编号',\r\n");
      out.write("\t\twidth : 60,\r\n");
      out.write("\t\thidden : true\r\n");
      out.write("\t}, {\r\n");
      out.write("\t\tfield : 'name',\r\n");
      out.write("\t\ttitle : '供应商名',\r\n");
      out.write("\t\twidth : 100,\r\n");
      out.write("\t\tsortable : true\r\n");
      out.write("\t}, {\r\n");
      out.write("\t\tfield : 'createdatetime',\r\n");
      out.write("\t\ttitle : '创建时间',\r\n");
      out.write("\t\twidth : 150,\r\n");
      out.write("\t\tsortable : true,\r\n");
      out.write("\t\tformatter : function(value){ \r\n");
      out.write("\t\t\t return formatterdate(value);\r\n");
      out.write("\t\t }\r\n");
      out.write("\t\t\r\n");
      out.write("\t}, {\r\n");
      out.write("\t\tfield : 'modifydatetime',\r\n");
      out.write("\t\ttitle : '最后修改时间',\r\n");
      out.write("\t\twidth : 150,\r\n");
      out.write("\t\tsortable : true,\r\n");
      out.write("\t\tformatter : function(value){ \r\n");
      out.write("\t\t\t return formatterdate(value);\r\n");
      out.write("\t\t }\r\n");
      out.write("\t} ] ],\r\n");
      out.write("\tdelay : 500\r\n");
      out.write("});\r\n");
      out.write("var measureunit_Datagrid= $('input[name=\"measureunitId\"]').combogrid({\r\n");
      out.write("\tloadMsg : '数据加载中....',\r\n");
      out.write("\tpanelWidth : 440,\r\n");
      out.write("\tpanelHeight : 180,\r\n");
      out.write("\trequired : true,\r\n");
      out.write("\tfitColumns : true,\r\n");
      out.write("\tvalue : '',\r\n");
      out.write("\tvalueField:'name',\r\n");
      out.write("\tidField : 'id',\r\n");
      out.write("\ttextField : 'name',\r\n");
      out.write("\tmode : 'remote',\r\n");
      out.write("\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/measureunit/list.action',\r\n");
      out.write("\tpagination : true,\r\n");
      out.write("\tpageSize : 5,\r\n");
      out.write("\tpageList : [ 5, 10 ],\r\n");
      out.write("    onSelect: function (rowIndex, rowData){  \r\n");
      out.write("    \r\n");
      out.write("    \t$('input[name=\"measureunitName\"]').val(rowData.name);\r\n");
      out.write("        }  ,\r\n");
      out.write("\tcolumns : [ [ {\r\n");
      out.write("\t\tfield : 'id',\r\n");
      out.write("\t\ttitle : '编号',\r\n");
      out.write("\t\twidth : 60,\r\n");
      out.write("\t\thidden : true\r\n");
      out.write("\t}, {\r\n");
      out.write("\t\tfield : 'name',\r\n");
      out.write("\t\ttitle : '计量单位名',\r\n");
      out.write("\t\twidth : 100,\r\n");
      out.write("\t\tsortable : true\r\n");
      out.write("\t}, {\r\n");
      out.write("\t\tfield : 'createdatetime',\r\n");
      out.write("\t\ttitle : '创建时间',\r\n");
      out.write("\t\twidth : 150,\r\n");
      out.write("\t\tsortable : true,\r\n");
      out.write("\t\tformatter : function(value){ \r\n");
      out.write("\t\t\t return formatterdate(value);\r\n");
      out.write("\t\t }\r\n");
      out.write("\t\t\r\n");
      out.write("\t}, {\r\n");
      out.write("\t\tfield : 'modifydatetime',\r\n");
      out.write("\t\ttitle : '最后修改时间',\r\n");
      out.write("\t\twidth : 150,\r\n");
      out.write("\t\tsortable : true,\r\n");
      out.write("\t\tformatter : function(value){ \r\n");
      out.write("\t\t\t return formatterdate(value);\r\n");
      out.write("\t\t }\r\n");
      out.write("\t} ] ],\r\n");
      out.write("\tdelay : 500\r\n");
      out.write("});\r\n");
      out.write("/*function Re(){\r\n");
      out.write("\t$(\"<div>\").css({padding:\"5px\"}).html(\"<ul>\")\r\n");
      out.write("\t.window({\r\n");
      out.write("\t\twidth:'800',\r\n");
      out.write("\t    height:\"450\",\r\n");
      out.write("\t    modal:true,\r\n");
      out.write("\t    closed:true,\r\n");
      out.write("\t    iconCls:'icon-save',\r\n");
      out.write("\t    title:'选择类目',\r\n");
      out.write("\t    onOpen : function(){\r\n");
      out.write("\t    \tvar _win = this;\r\n");
      out.write("\t    \t$(\"ul\",_win).tree({\r\n");
      out.write("\t    \t\turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/item/cat/list.action',\r\n");
      out.write("\t    \t\tanimate:true,\r\n");
      out.write("\t    \t\tonClick : function(node){\r\n");
      out.write("\t    \t\t\tif($(this).tree(\"isLeaf\",node.target)){\t    \t\t\t\t\r\n");
      out.write("\t    \t\t\t\t  $.getJSON(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/item/param/query/itemcatid.action?itemCatId=\" + node.id,function(data){\r\n");
      out.write("\t        \t\t\t\t  if(data.status == 200 && data.data){\r\n");
      out.write("\t        \t\t\t\t\t  changeItemParam(node, \"addInItem\");\r\n");
      out.write("\t        \t\t\t\t\t  $('#addInItem').find('[name=itemCatId]').val(node.id);\r\n");
      out.write("\t        \t\t\t\t    \t$('#addInItem').find('[name=itemCatName]').val(node.text);\r\n");
      out.write("\t        \t\t\t\t\t  return ;\r\n");
      out.write("\t        \t\t\t\t  }else{\r\n");
      out.write("\t        \t\t\t\t\t  $.messager.alert(\"提示\", \"该类目无规格参数,请选择其他类目。\", undefined, function(){\r\n");
      out.write("\t        \t\t\t\t\t\t  \r\n");
      out.write("\t         \t\t\t\t\t\t $(\"#itemParamAddTable .selectItemCat\").click();\r\n");
      out.write("\t         \t\t\t\t\t  });\r\n");
      out.write("\t        \t\t\t\t    \t\r\n");
      out.write("\t        \t\t\t\t  }\r\n");
      out.write("\t        \t\t\t\t \r\n");
      out.write("\t        \t\t\t  });\t    \t\t\t\t\t  \t\t\t    \t\t\t \r\n");
      out.write("\t    \t\t\t\t$(_win).window('close');\r\n");
      out.write("\t    \t\t\t\tif(data && data.fun){\r\n");
      out.write("\t    \t\t\t\t\tdata.fun.call(this,node);\r\n");
      out.write("\t    \t\t\t\t}\r\n");
      out.write("\t    \t\t\t}\r\n");
      out.write("\t    \t\t}\r\n");
      out.write("\t    \t});\r\n");
      out.write("\t    },\r\n");
      out.write("\t    onClose : function(){\r\n");
      out.write("\t    \t$(this).window(\"destroy\");\r\n");
      out.write("\t    }\r\n");
      out.write("\t}).window('open');\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t}*/\r\n");
      out.write(" function changeItemParam(node,formId){\r\n");
      out.write("\t\r\n");
      out.write("\t$.getJSON(\"/item/param/query/itemcatid.action/\" + node.id,function(data){\r\n");
      out.write("\t\t  if(data.status == 200 && data.data){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t $(\"#\"+formId+\" .params\").show();\r\n");
      out.write("\t\t\t var paramData = JSON.parse(data.data.paramData);\r\n");
      out.write("\t\t\t var html = \"<ul>\";\r\n");
      out.write("\t\t\t for(var i in paramData){\r\n");
      out.write("\t\t\t\t var pd = paramData[i];\r\n");
      out.write("\t\t\t\t html+=\"<li><table>\";\r\n");
      out.write("\t\t\t\t html+=\"<tr><td colspan=\\\"2\\\" class=\\\"group\\\">\"+pd.group+\"</td></tr>\";\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t\t for(var j in pd.params){\r\n");
      out.write("\t\t\t\t\t var ps = pd.params[j];\r\n");
      out.write("\t\t\t\t\t html+=\"<tr><td class=\\\"param\\\"><span>\"+ps+\"</span>: </td><td><input autocomplete=\\\"off\\\" type=\\\"text\\\"/></td></tr>\";\r\n");
      out.write("\t\t\t\t }\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t\t html+=\"</li></table>\";\r\n");
      out.write("\t\t\t }\r\n");
      out.write("\t\t\t html+= \"</ul>\";\r\n");
      out.write("\t\t\t $(\"#\"+formId+\" .params td\").eq(1).html(html);\r\n");
      out.write("\t\t  }else{\r\n");
      out.write("\t\t\t $(\"#\"+formId+\" .params\").hide();\r\n");
      out.write("\t\t\t $(\"#\"+formId+\" .params td\").eq(1).empty();\r\n");
      out.write("\t\t  }\r\n");
      out.write("\t  });\r\n");
      out.write("}\r\n");
      out.write(" \r\n");
      out.write(" /*$(\".selectItemCat\").on(\"click\",function(){\r\n");
      out.write(" \t Re(); \t\r\n");
      out.write(" });*/\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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

/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-04-13 10:32:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addCustomer_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("  \r\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\">        \r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write(" <div style=\"padding:10px 60px 20px 60px\">  \r\n");
      out.write("     <form id=\"addCustomer\" method=\"post\" >  \r\n");
      out.write("\t\t <table cellpadding=\"10\">  \r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>单位名称</td>\r\n");
      out.write("\t\t\t<td><input name=\"name\"  class=\"easyui-textbox\" required=\"true\" style=\"width:200px\"></input></td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>地址</td>\r\n");
      out.write("\t\t\t<td ><textarea name=\"address\" rows=\"8\" cols=\"24\"></textarea></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>邮编</td>\r\n");
      out.write("\t\t\t<td><input name=\"postcode\" class=\"easyui-textbox\" style=\"width:200px\"></input></td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t<td>电话</td>\r\n");
      out.write("\t\t\t<td><input name=\"phone\" class=\"easyui-textbox\" style=\"width:200px\"></input></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>传真</td>\r\n");
      out.write("\t\t\t<td><input name=\"fax\" class=\"easyui-textbox\" style=\"width:200px\"></input></td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t<td>网址</td>\r\n");
      out.write("\t\t\t<td><input name=\"www\"  class=\"easyui-textbox\" style=\"width:200px\"></input></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>电子邮箱</td>\r\n");
      out.write("\t\t\t<td><input name=\"email\" class=\"easyui-textbox\" data-options=\"required:true\"  \r\n");
      out.write("                            missingMessage=\"邮箱不能为空\" invalidMessage=\"请输入正确的邮箱\" validType=\"email\" style=\"width:200px\"></input></td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>负责人</td>\r\n");
      out.write("\t\t\t<td><input name=\"answerMan\" class=\"easyui-textbox\" style=\"width:200px\"></input></td>\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>联系人</td>\r\n");
      out.write("\t\t\t<td><input name=\"contactMan\" class=\"easyui-textbox\" style=\"width:200px\"></input></td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>营业执照号</td>\r\n");
      out.write("\t\t\t<td><input name=\"licence\"  class=\"easyui-textbox\"  style=\"width:200px\"></input></td>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>开户银行</td>\r\n");
      out.write("\t\t\t<td><input name=\"bank\" class=\"easyui-textbox\" style=\"width:200px\"></input></td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<td>税务编码</td>\r\n");
      out.write("\t\t\t<td><input name=\"taxCode\"  class=\"easyui-textbox\" style=\"width:200px\"></input></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>银行帐号</td>\r\n");
      out.write("\t\t\t<td><input name=\"account\" class=\"easyui-textbox\" style=\"width:200px\"></input></td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>助记码</td>\r\n");
      out.write("\t\t\t<td><input name=\"help\" class=\"easyui-textbox\" style=\"width:200px\"></input></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>备注</td>\r\n");
      out.write("\t\t\t<td > <textarea rows=\"8\" cols=\"24\" name=\"remark\" ></textarea> </td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("     </form>  \r\n");
      out.write("    \r\n");
      out.write(" </div>  \r\n");
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

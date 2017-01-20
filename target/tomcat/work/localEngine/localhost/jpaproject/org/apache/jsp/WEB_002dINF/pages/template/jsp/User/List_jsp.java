package org.apache.jsp.WEB_002dINF.pages.template.jsp.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class List_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div data-ng-controller=\"userController\" data-ng-init=\"userList()\">\n");
      out.write("\t<div class=\"panel panel-default\">\n");
      out.write("\t\t<div class=\"panel-heading\">\n");
      out.write("\t\t\t<!-- \t\t\t<ol class=\"breadcrumb\"> -->\n");
      out.write("\t\t\t");
      out.write("\n");
      out.write("\t\t\t<!-- \t\t\t\t<li class=\"active\">User List</li> -->\n");
      out.write("\t\t\t<!-- \t\t\t</ol> -->\n");
      out.write("\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t<div class=\"col-sm-3\">\n");
      out.write("\t\t\t\t\t<input type=\"text\" class=\"form-control input-group-lg reg_name\"\n");
      out.write("\t\t\t\t\t\tdata-ng-value=\"\" data-ng-model=\"name\"\n");
      out.write("\t\t\t\t\t\tname=\"name\" >\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"col-sm-3\">\n");
      out.write("\t\t\t\t\t<button class=\"btn btn-info\"\n");
      out.write("\t\t\t\t\t\tdata-ng-click=\"findUserRepeat(name)\">Search</button>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<br />\n");
      out.write("\t\t<div class=\"panel-body\">\n");
      out.write("\t\t\t<table class=\"table\">\n");
      out.write("\t\t\t\t<thead>\n");
      out.write("\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t<th>Username</th>\n");
      out.write("\t\t\t\t\t\t<th>Name</th>\n");
      out.write("\t\t\t\t\t\t<th>Role</th>\n");
      out.write("\t\t\t\t\t\t<th>Active</th>\n");
      out.write("\t\t\t\t\t\t<th>Delete</th>\n");
      out.write("\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t</thead>\n");
      out.write("\t\t\t\t<tr data-ng-repeat=\"user in userList\">\n");
      out.write("\t\t\t\t\t<td ><a data-ng-bind=\"user.username\" data-ng-click=\"saveUserName(user.username)\" data-ng-href=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\"></a></td>\n");
      out.write("\t\t\t\t\t<td data-ng-bind=\"user.name\"></td>\n");
      out.write("\t\t\t\t\t<td data-ng-bind=\"user.role.description\"></td>\n");
      out.write("\t\t\t\t\t<td data-ng-bind=\"user.status\"></td>\n");
      out.write("\t\t\t\t\t<td data-ng-show=\"user.role.description!='Admin'\"><button  class=\"btn btn-info\" data-ng-click=\"deleteUser(user.username)\" data-ng-disabled=\"myForm.$invalid\">Delete</button>\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tbody>\n");
      out.write("\t\t\t\t</tbody>\n");
      out.write("\t\t\t</table>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005furl_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent(null);
    // /WEB-INF/pages/template/jsp/User/List.jsp(39,100) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/User/editView");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }
}

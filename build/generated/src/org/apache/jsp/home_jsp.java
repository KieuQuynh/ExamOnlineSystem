package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"zxx\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <title>KQ Examination Online System</title>\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <meta charset=\"utf-8\" />\n");
      out.write("    <meta name=\"keywords\" content=\"Alphabet Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, \n");
      out.write("\tSmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design\" />\n");
      out.write("    <script>\n");
      out.write("        addEventListener(\"load\", function () {\n");
      out.write("            setTimeout(hideURLbar, 0);\n");
      out.write("        }, false);\n");
      out.write("\n");
      out.write("        function hideURLbar() {\n");
      out.write("            window.scrollTo(0, 1);\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("    <!-- Custom Theme files -->\n");
      out.write("       <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n");
      out.write("    <!-- portfolio -->\n");
      out.write("    <link href=\"css/gallery.css\" type=\"text/css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("    <!-- testimonials -->\n");
      out.write("    <link href=\"css/testimonials.css\" type=\"text/css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("    <link href=\"Style/style_front.css\" type=\"text/css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("    <!-- font-awesome icons -->\n");
      out.write("    <link href=\"css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("    <!-- //Custom Theme files -->\n");
      out.write("    <!-- online-fonts -->\n");
      out.write("    <link href=\"//fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i\" rel=\"stylesheet\">\n");
      out.write("    <!-- //online-fonts -->\n");
      out.write("    \n");
      out.write("      <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <!-- Popper.JS -->\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js\" integrity=\"sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <!-- Bootstrap JS -->\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js\" integrity=\"sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm\" crossorigin=\"anonymous\"></script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <script src='//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js'></script>\n");
      out.write("    <script src=\"//m.servedby-buysellads.com/monetization.js\" type=\"text/javascript\"></script>\n");
      out.write("    \n");
      out.write("\n");
      out.write("\n");
      out.write("    <!-- banner -->\n");
      out.write("    <div id=\"home\" class=\"position-relative\">\n");
      out.write("        <div class=\"header-main\">\n");
      out.write("            <div class=\"d-sm-flex justify-content-between\">\n");
      out.write("                <h1>\n");
      out.write("                    <a class=\"navbar-brand\" href=\"index.html\">\n");
      out.write("                        Ki<span>e</span>u<span>Qu</span>y<span>n</span>h\n");
      out.write("                    </a>\n");
      out.write("                </h1>\n");
      out.write("                <div class=\"hearder-right-w3_pvt d-flex justify-content-sm-end align-items-center  mt-sm-0 mt-4\">\n");
      out.write("                    <ul class=\"d-flex header-w3_pvt\">\n");
      out.write("                        <li><a href=\"student/register.jsp\"><button type=\"button\" class=\"btn w3ls-btn d-block\" data-toggle=\"modal\" aria-pressed=\"false\"\n");
      out.write("                                data-target=\"#exampleModal1\">\n");
      out.write("                                <span class=\"fa fa-sign-in\"></span>Register\n");
      out.write("                                </button></a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"login\"><button type=\"button\" class=\"btn w3ls-btn btn-2  d-block\" data-toggle=\"modal\" aria-pressed=\"false\"\n");
      out.write("                                data-target=\"#exampleModal\">\n");
      out.write("                                <span class=\"fa fa-lock\"></span> Sign in\n");
      out.write("                                </button></a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("   \n");
      out.write("    <div id=\"carouselExampleSlidesOnly\" class=\"carousel slide\" data-ride=\"carousel\">\n");
      out.write("  <div class=\"carousel-inner\">\n");
      out.write("    <div class=\"carousel-item active\">\n");
      out.write("     \n");
      out.write("                <div class=\"container-fluid px-0\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-3 col-sm-6 px-0 bg-theme1 banner-left-grid\">\n");
      out.write("                            <div class=\"banner-text h-100\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-9 col-sm-6 banner banner1 banner-text\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"slider-info\">\n");
      out.write("                            \n");
      out.write("                            <h3>Examination <span>Online</span> System</h3>\n");
      out.write("                            <p class=\"text-white\">Our website will provide you to give online examination \n");
      out.write("                                and view your result immediately that will reduce students anxiety.\n");
      out.write("                                By the help of giving such type of examination students can save a lot of their time.\n");
      out.write("                                They can check their abilities and improve them.Students can give exams of their selected subjects.\n");
      out.write("                            </p>\n");
      out.write("                           \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("       \n");
      out.write("    </div>\n");
      out.write("    <div class=\"carousel-item\">\n");
      out.write("       \n");
      out.write("                <div class=\"container-fluid px-0\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-3 col-sm-6 px-0 bg-theme2 banner-left-grid\">\n");
      out.write("                            <div class=\"banner-text h-100\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-9 col-sm-6 banner banner2 banner-text\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"slider-info\">\n");
      out.write("                              \n");
      out.write("                            <h3>Examination <span>Online</span> System</h3>\n");
      out.write("                            <p class=\"text-white\">Our website will provide you to give online examination \n");
      out.write("                                and view your result immediately that will reduce students anxiety.\n");
      out.write("                                By the help of giving such type of examination students can save a lot of their time.\n");
      out.write("                                They can check their abilities and improve them.Students can give exams of their selected subjects.\n");
      out.write("                            </p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("         \n");
      out.write("    </div>\n");
      out.write("    <div class=\"carousel-item\">\n");
      out.write("    \n");
      out.write("                <div class=\"container-fluid px-0\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-3 col-sm-6 px-0 bg-theme3 banner-left-grid\">\n");
      out.write("                            <div class=\"banner-text h-100\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-9 col-sm-6 banner banner3 banner-text\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"slider-info\">\n");
      out.write("                               \n");
      out.write("                            <h3>Examination <span>Online</span> System</h3>\n");
      out.write("                            <p class=\"text-white\">Our website will provide you to give online examination \n");
      out.write("                                and view your result immediately that will reduce students anxiety.\n");
      out.write("                                By the help of giving such type of examination students can save a lot of their time.\n");
      out.write("                                They can check their abilities and improve them.Students can give exams of their selected subjects.\n");
      out.write("                            </p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("       \n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("</div>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

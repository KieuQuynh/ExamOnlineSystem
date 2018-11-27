<%-- 
    Document   : showQuestion
    Created on : Oct 30, 2018, 10:35:15 PM
    Author     : Admin
--%>

<%@page import="Gui.Component.Pagger"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="../Style/style_backend.css">
        
        <!-- jQuery CDN - Slim version (=without AJAX) -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <!-- Popper.JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
        <!-- Bootstrap JS -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
     <%
         
          int pageIndex = (Integer) request.getAttribute("pageIndex");
          int maxPage=( Integer) request.getAttribute("maxPage");
          int courseID= ( Integer) request.getAttribute("courseID");
        %>
    </head>
    <body>

        <div class="wrapper">
            <!-- Sidebar Holder -->
            <nav id="sidebar">
                <div class="sidebar-background ">
                    <h2 class="logo-tex">
                        Online Examination System
                    </h2>
                    <div class="left-menu">
                        <a  href="adminPage.jsp?pgprt=0"><h2>Profile</h2></a>
                        <a  href="adminPage.jsp?pgprt=2"><h2>Courses</h2></a>
                        <a href="adminPage.jsp?pgprt=3" class="active"><h2>Questions</h2></a>
                        <a href="account?pgprt=1"><h2>Accounts</h2></a>
                    </div>
                </div>
            </nav>

            <!-- Page Content Holder -->
            <div id="content">

                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container-fluid">

                        <button type="button" id="sidebarCollapse" class="navbar-btn">
                            <span></span>
                            <span></span>
                            <span></span>
                        </button>

                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                             <ul class="nav navbar-nav ml-auto">
                                  Admin Panel
                            </ul>
                            <ul class="nav navbar-nav ml-auto">
                                <a href="../logout">   <button class="btn btn-sm btn-dark">Log out</button></a>
                            </ul>
                        </div>
                    </div>
                </nav>

                <!-- CONTENT AREA -->
                <div class="content-are  container">

                    <div class="row ml-auto mr-auto">
                     
                          
                                <c:if test="${param.coursename !=null}"  >
                           
                                    <c:forEach items="${requestScope.question}" var="s" varStatus ="loop" >
                                        <div class="question-panel">
                                            <div class="question" >
                                                <label class="question-label">${loop.index +1}</label>
                                                <c:out  value ="${s.getQuestion()}"/>	
                                                <a href="deletequestion?qid=${s.getId()}&courseID=${requestScope.courseID}" 
                                                   onclick="return confirm('Are you sure you want to delete this ?');" >
                                                    <div class="delete-btn" style="position: absolute;right: 10px;top: -20px;">delete</div></a>
                                            </div>
                                            <div class="answer">
                                                <label class="show">${s.getOpt1()}</label>
                                                <label class="show">${s.getOpt2()}</label>
                                                <label class="show">${s.getOpt3()}</label>
                                                <label class="show">${s.getOpt4()}</label>
                                                <label class="show-correct">${s.getCorrect()}</label>
                                            </div>
                                        </div>


                                    </c:forEach>    
                                         <%= Pagger.generate(pageIndex, 2, maxPage, "",courseID)%>
                                </c:if>


                        
                        </div>
                    
                </div>
            </div>

            <script type="text/javascript">
                $(document).ready(function () {
                    $('#sidebarCollapse').on('click', function () {
                        $('#sidebar').toggleClass('active');
                        $(this).toggleClass('active');
                    });
                });
            </script>


    </body>
</html>

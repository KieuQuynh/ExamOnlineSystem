<%-- 
    Document   : course.jsp
    Created on : Oct 14, 2018, 4:14:52 PM
    Author     : Admin
--%>

<%@page import="model.Course"%>
<%@page import="java.util.ArrayList"%>
<%@page import="db.CourseDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
       <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="../Style/style_backend.css">
      <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
                                <!-- Popper.JS -->
                                <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
                                <!-- Bootstrap JS -->
                                <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
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
                                         <a  href="studentPage.jsp?pgprt=0&userID=${sessionScope.userID}"><h2>Profile</h2></a>
                                            <a  class="active"href="startExam?userID=${sessionScope.userID}"><h2>Exams</h2></a>
                                            <a href="showAll?userID=${sessionScope.userID}"><h2>Results</h2></a>
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
                                            Hello ${sessionScope.username}
                                           </ul>
                             <ul class="nav navbar-nav ml-auto">
                                <a href="../logout">   <button class="btn btn-sm btn-dark">Log out</button></a>
                            </ul>
                        </div>
                    </div>
                </nav>

                <!-- CONTENT AREA -->
                <div class="content-are  container">

                    <div class="row">
                        <div class="panel" style="float: left;max-width: 900px">
           <div class="title">Result of Recent Exam</div>
           <div class="profile">
               <span class="tag">Exam Date</span><span class="val">${requestScope.result.getDate() }</span><br/>
               <span class="tag">Start Time</span><span class="val">${requestScope.result.getStartTime() }</span><br/>
               <span class="tag">End Time</span><span class="val">${requestScope.result.getEndTime() }</span><br/>
               <span class="tag">Course Name</span><span class="val">${requestScope.course.getName() }</span><br/>
               <span class="tag">Obt Marks</span><span class="val">${requestScope.result.getObtMark() }</span><br/>
               <span class="tag">Total Marks</span><span class="val">${requestScope.result.getTotalMark() }</span><br/>
               <span class="tag">Result</span><span class="val">${requestScope.result.getStatus() }</span></h2>
           </div>
          
           </div>
                </div> <!--end col-9-->
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

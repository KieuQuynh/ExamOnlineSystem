<%-- 
    Document   : course.jsp
    Created on : Oct 14, 2018, 4:14:52 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Course"%>
<%@page import="java.util.ArrayList"%>
<%@page import="db.CourseDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="../Style/style_backend.css">

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
                        <a  href="studentPage.jsp?pgprt=0&userID=${sessionScope.id}"><h2>Profile</h2></a>
                        <a  class="active"href="startExam?userID=${sessionScope.id}"><h2>Exams</h2></a>
                        <a href="showAll?userID=${sessionScope.id}"><h2>Results</h2></a>
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
                                Hello  ${sessionScope.username}
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
                        <span id="remainingTime" style="top:102px;left: 267px;font-size: 16px;background: rgba(255,0,77,0.38);border-radius: 5px;padding: 10px;box-shadow: 2px -2px 6px 0px;">

                        </span>

                        <script>
                            var time = ${requestScope.remain};
                            time--;
                            var sec = 60;
                    if(    time >=0 )   document.getElementById("remainingTime").innerHTML = time + " : " + sec;
                            //it calls fuction after specific time again and again                  
                            var x = window.setInterval(timerFunction, 1000);
                            function timerFunction() {
                                sec--;
                                // Display the result in the element with id="demo"


                                if (time < 0) {
                                    clearInterval(x);
                             //       document.getElementById("remainingTime").innerHTML = "00 : 00";
                                    document.getElementById("myform").submit();
                                }
                           if(    time >=0 )          document.getElementById("remainingTime").innerHTML = time + " : " + sec;
                                if (sec == 0) {
                                    sec = 60;
                                    time--;

                                }
                            }
                        </script>
                        <div>
                            
                            
                        </div>
                        <form id="myform" action="result" method="POST">
                             <input type="hidden" name="size" value="${requestScope.question.size()}">
                             <input type="hidden" name="courseID" value="${requestScope.courseID}">
                                <input type="hidden" name="examID" value="${requestScope.examID}">
                         
                            <c:forEach  items="${requestScope.question}" var ="s" varStatus="loop">
                                                <div class="question-panel">
                                    <div class="question" >
                                        <label class="question-label">${loop.index +1}</label>
                                        ${s.getQuestion()}
                                    </div>
                                    <div class="answer">
                                        <input type="radio" id="c1${loop.index}" name="ans${loop.index}" value="${s.getOpt1()}"/>
                                        <label for="c1${loop.index}">${s.getOpt1()}</label>
                                        <input type="radio" id="c2${loop.index}" name="ans${loop.index}" value="${s.getOpt2()}" />
                                        <label for="c2${loop.index}">${s.getOpt2()}</label>
                                        <input type="radio" id="c3${loop.index}" name="ans${loop.index}" value="${s.getOpt3()}" />
                                        <label for="c3${loop.index}">${s.getOpt3()}</label>
                                        <input type="radio"  id="c4${loop.index}" name="ans${loop.index}" value="${s.getOpt4()}"/>
                                        <label for="c4${loop.index}" >${s.getOpt4()}</label>

                                    </div>
                                </div>
                                 <input type="hidden" name="question${loop.index}" value="${s.getQuestion()}">
                                <input type="hidden" name="qid${loop.index}" value="${s.getId()}">

                                
                            </c:forEach>
                                <input type="submit" class="add-btn btn" value="Done">
                     
                
                                </form>




                                </div> <!--end col-9-->
                                </div>
                                </div>

                                <!-- jQuery CDN - Slim version (=without AJAX) -->
                                <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
                                <!-- Popper.JS -->
                                <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
                                <!-- Bootstrap JS -->
                                <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

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

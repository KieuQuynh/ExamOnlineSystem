<%-- 
    Document   : course.jsp
    Created on : Oct 14, 2018, 4:14:52 PM
    Author     : Admin
--%>

<%@page import="model.Course"%>
<%@page import="java.util.ArrayList"%>
<%@page import="db.CourseDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

        <%
            CourseDAO db = new CourseDAO();
            ArrayList<Course> list = db.allCourse();

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
                                         <a class="active" href="adminPage.jsp?pgprt=2"><h2>Courses</h2></a>
                                         <a href="adminPage.jsp?pgprt=3"><h2>Questions</h2></a>
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

                    <div class="row">
                        <div class=" col-sm-6 col-md-6 col-lg-6">
                            <div  class="panel form-style-6 ml-5"  >
                                <div class="title">
                                    Add New Course
                                </div>
                                <center>
                                    <form action="course"  method="POST">
                                        <br>
                                        <table class="table" >
                                            <tr>
                                                <td><label>Course Name</label></td>
                                                <td> <input type="text" name="coursename" class="text form-control" placeholder="Course Name"  ></td>
                                            </tr>
                                            <tr>
                                                <td><label>Total Marks</label></td>
                                                <td><input type="text" name="totalmarks" class="text form-control" placeholder="Total Marks" ></td>
                                            </tr>
                                            <tr>
                                                <td><label>Exam Time</label></td>
                                                <td>
                                                    <input type="text" name="time" class="text form-control" placeholder="MM"  >
                                                </td>

                                            </tr>
                                            <tr>
                                                <td colspan="2"><input type="hidden" name="page" value="courses">
                                                    <input type="hidden" name="operation" value="addnew">
                                            <center><input type="submit" class="form-button" value="Add" name="submit"></center></td>
                                            </tr>
                                        </table>

                                    </form>
                                </center>

                            </div>
                        </div> <!-- end col-6-->

                        <div class="col-sm-6 col-md-6 col-lg-6">
                            <div class="panel form-style-6" >
                                <div class="title">
                                    All Courses
                                </div>
                                <table id="one-column-emphasis" class="table mt-3" >
                                   
                                    <thead>
                                        <tr>
                                            <th scope="col">Courses</th>

                                            <th scope="col">T.Marks</th>
                                            <th scope="col">Action</th>

                                        </tr>
                                    </thead>


                                    <%  for (Course e : list) {%>
                                    <tr>
                                        <td><%=e.getName()%></td>
                                        <td><%= e.getMark()%></td>
                                        <td ><a  href="deletecourse?id=<%=e.getId()%>" 
                                                 onclick="return confirm('Are you sure you want to delete this ?');" class="del">
                                                <div class="delete-btn" >X</div>
                                            </a></td>
                                    </tr>
                                    <%
                                        }
                                    %>
                                </table>
                            </div>
                        </div>
                    </div>





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

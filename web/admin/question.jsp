<%-- 
    Document   : question.jsp
    Created on : Oct 15, 2018, 9:24:06 PM
    Author     : Admin
--%>

<%@page import="model.Course"%>
<%@page import="db.CourseDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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

                    <div class="row">
                         <div class="content-are ">
                    <div class="row">
                        <div class="col-sm-4 col-md-4 col-lg-4">
                            <div class="panel form-style-6" >
                                <form action="showall" method="GET" >
                                    <div class="title">Show All Questions </div>
                                    <br><br>
                                    <label>Select Course</label>
                                    <select name="coursename" class="text">
                                        <%
                                            for (int i = 0; i < list.size(); i++) {
                                        %>
                                        <option value="<%=list.get(i).getId()%>"><%=list.get(i).getName()%></option>
                                        <%
                                            }
                                        %>
                                    </select>
                                    <input type="submit" value="Show" class="form-button">
                                </form>
                            </div>
                        </div> <!-- end col-3-->

                        <div class="col-sm-8 col-md-8 col-lg-8">
                           
                                <div class="panel form-style-6" >   
                                    <form action="addquestion" method="POST">
                                        <div class="title">Add New Question</div>
                                        <table class="table">
                                            <tr>
                                                <td><label>Course Name</label></td>
                                                <td colspan="3"> 
                                                    <select name="courseID" class="text">
                                                        <%
                                                            for (int i = 0; i < list.size(); i++) {
                                                        %>
                                                        <option value="<%=list.get(i).getId()%>"><%=list.get(i).getName()%></option>
                                                        <%
                                                            }
                                                        %>
                                                    </select>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td><label>Your Question:</label></td>
                                                <td colspan="4"><input type="text" name="question" class="form-control" placeholder="Type your question here" ></td><br>
                                            </tr>
                                            <tr>
                                                <td><label>Options</label></td>
                                                <td><input type="text" name="opt1" class="form-control" placeholder=" Option 1" ></td>
                                                <td><input type="text" name="opt2" class="form-control" placeholder="Option 2" ></td>
                                                <td><input type="text" name="opt3" class="form-control" placeholder="Option 3"  ></td>
                                                <td><input type="text" name="opt4" class="form-control" placeholder="Option 4"></td>
                                            </tr>
                                            <tr>
                                                <td><label>Correct Answer</label></td>
                                                <td colspan="4"><center><input type="text" name="correct" class="text" placeholder="Correct Option" style="width: 130px;" ></center></td>
                                            <tr>
                                                <td colspan="5">
                                                    
                                            <center><input type="submit" class="form-button" value="Add" name="submit"></center></td>

                                            </tr>
                                        </table>

                                    </form>


                            
                           
                        </div> <!-- end col-7-->
                        </div>
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

<%-- 
    Document   : profile
    Created on : Oct 14, 2018, 1:33:23 PM
    Author     : Admin
--%>

<%@page import="db.UserDAO"%>
<%@page import="model.UserModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <%
            String id = request.getSession().getAttribute("userID").toString();
            UserModel ob = null;
            if (id == null) {
                response.sendRedirect("login");
            } else {
                int userID = Integer.parseInt(id);
                UserDAO db = new UserDAO();
                ob = db.getById(userID);
            }


        %>
    </head>
    <body>
      

        <%             if (ob.getType().equals("admin")) {
        %>

        <div class="wrapper">
            <!-- Sidebar Holder -->
            <nav id="sidebar">
                <div class="sidebar-background ">
                    <h2 class="logo-tex">
                        Online Examination System
                    </h2>


                    <div class="left-menu">
                        <a  class="active"  href="adminPage.jsp?pgprt=0"><h2>Profile</h2></a>
                        <a href="adminPage.jsp?pgprt=2"><h2>Courses</h2></a>
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

                    <div class="panel " style="float: left;max-width: 600px">

                        <%} else {
                        %>

                        <div class="wrapper">
                            <!-- Sidebar Holder -->
                            <nav id="sidebar">
                                <div class="sidebar-background ">
                                    <h2 class="logo-tex">
                                        Online Examination System
                                    </h2>


                                    <div class="left-menu">
                                        <div class="left-menu">
                                            <a class="active" href="studentPage.jsp?pgprt=0&userID=<%=id%>"><h2>Profile</h2></a>
                                            <a href="startExam"><h2>Exams</h2></a>
                                            <a href="showAll?userID=<%=id%>"><h2>Results</h2></a>
                                        </div>
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

                    <div class="panel " style="float: left;max-width: 600px">    

           <% }%>
                        <!-- Edit Form!>    -->


            <% if(request.getParameter("pedt")==null){
                        %>
                        <div class="title">Profile</div>
                        <div class="profile ">
                            <h2><span class="tag">Your Name</span><span class="val"><%=ob.getFirstName() + " "%><%=ob.getLastName()%></span><br/>
                                <span class="tag">Email</span><span class="val"><%=ob.getEmail()%></span><br/>
                                <span class="tag">Contact No</span><span class="val"><%=ob.getContact()%></span><br/>
                                <span class="tag">City</span><span class="val"><%=ob.getCity()%></span><br/>
                                <span class="tag">Address</span><span class="val"><%=ob.getAddress()%></span></h2>
                        </div>
                        <%
                            if (ob.getType().equals("admin")) {
                        %>
                        <br/>
                        <a href="adminPage.jsp?pgprt=0&pedt=1&userID=<%=id%>"><span class="add-btn">Edit Profile</span></a>
                        <%
                        } else {
                        %><br/>
                        <a href="studentPage.jsp?pgprt=0&pedt=1&userID=<%=id%>"><span class="add-btn">Edit Profile</span></a>
                        <%
                            }
                        %>

                        <%
                            }

               
                                else{
                        %>

                        <!-- Start of Edit Form --->
                        <div class="title">Edit Profile</div>
                        <div class="central-div form-style-6" style="position:inherit;margin-top: 70px;" >
                            <form action="../edit" method="POST">
                                <input type="hidden" name="userID" value=<%=id%>> 
                                <input type="hidden" name="utype" value="<%=ob.getType()%>">
                                <table>

                                    <tr>
                                        <td>
                                            <label>First Name</label>
                                        </td>
                                        <td>
                                            <input type="text" name="fname" value="<%=ob.getFirstName()%>" class="text" placeholder="First Name">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label>Last Name</label>
                                        </td>
                                        <td>
                                            <input type="text"  name="lname" value="<%=ob.getLastName()%>" class="text" placeholder="Last Name">
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <label>User Name</label>
                                        </td>
                                        <td>
                                            <input type="text" name="uname" value="<%=ob.getUserName()%>" class="text" placeholder="User Name">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label>Email</label>
                                        </td>
                                        <td>
                                            <input type="email" name="email" value="<%=ob.getEmail()%>" class="text" placeholder="Email">
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>
                                            <label>Password</label>
                                        </td>
                                        <td>
                                            <input type="password" value="<%=ob.getPassword()%>" name="pass"  class="text" placeholder="Password">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label>Contact No</label>
                                        </td>
                                        <td>
                                            <input type="text" name="contactno" value="<%=ob.getContact()%>" class="text" placeholder="Contact No">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label>City</label>
                                        </td>
                                        <td>
                                            <input type="text" name="city" value="<%=ob.getCity()%>" class="text" placeholder="City">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label>Address</label>
                                        </td>
                                        <td>
                                            <input type="text" name="address" value="<%=ob.getAddress()%>" class="text" placeholder="Address">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        </td>
                                        <td>
                                    <center>

                                        <input type="submit" value="Done" class="button">
                                    </center>
                                    </td>
                                    </tr>
                                </table>
                            </form>
                        </div>

                                    </div>

                                        <%
                                            }
                                        %>





















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

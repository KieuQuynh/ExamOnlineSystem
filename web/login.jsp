<%-- 
    Document   : login.jsp
    Created on : Oct 14, 2018, 12:25:07 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./Style/style.css">
        <link href="//fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i" rel="stylesheet">
        <title>JSP Page</title>
        <%
            String s=(String)request.getAttribute("error");
            
            %>
    </head>
    <body style="background-image: url(./IMG/login.jpg) ">
    <center>
        <div class="central-div">
            <form method='POST' action="./login">
                <table>
                    <tr>
                        <td colspan="2">
                    <center><h2>Login Form</h2></center>
                    </td>
                    </tr>
                    <tr>
                        <td>
                            <label>User Name</label>
                        </td>
                        <td>
                            <input type="text" class="text" placeholder="User Name" name="username">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Password</label>
                        </td>
                        <td>
                            <input type="password" class="text" placeholder="Password" name="password">
                        </td>
                    </tr>
                    <tr>
                        <td>

                        </td>
                        <td>
                        

                            <span><%= (s!=null)? s:""%></span></td>
                    </tr>
                    <tr>
                        <td>
                        </td>
                        <td>
                    <center>
                        <input type="submit" value="Login" class="button">
                    </center>
                    </td>
                    </tr>
                </table>
            </form>
        </div>
    </center>
</body>
</html>

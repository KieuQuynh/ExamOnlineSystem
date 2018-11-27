<%-- 
    Document   : register
    Created on : Nov 7, 2018, 3:29:14 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <link rel="stylesheet" type="text/css" href="../Style/style.css">
    </head>
    <body>
    <center>
        <div class="central-div fadeInDown " style="top:5%">
            <form action="register" method="POST">
                <input type="hidden" name="page" value="register" class="fadeIn first"> 
                <table>
                    <tr>
                        <td colspan="2">
                    <center><h2>Register New User</h2></center>
                    </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="fadeIn second">First Name</label>
                        </td>
                        <td>
                            <input type="text" name="fname" class="text fadeIn second" placeholder="First Name" >
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="fadeIn third">Last Name</label>
                        </td>
                        <td>
                            <input type="text"  name="lname" class="text fadeIn third" placeholder="Last Name">
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label class="fadeIn fourth">User Name</label>
                        </td>
                        <td>
                            <input type="text" name="uname" class="text fadeIn fourth" placeholder="User Name">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="fadeIn fourth">Email</label>
                        </td>
                        <td>
                            <input type="email" name="email" class="text fadeIn fourth" placeholder="Email">
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label class="fadeIn fourth">Password</label>
                        </td>
                        <td>
                            <input type="password" name="pass" class="text fadeIn fourth" placeholder="Password">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="fadeIn fourth">Contact No</label>
                        </td>
                        <td>
                            <input type="text" name="contactno" class="text fadeIn fourth" placeholder="Contact No">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="fadeIn fourth">City</label>
                        </td>
                        <td>
                            <input type="text" name="city" class="text fadeIn fourth" placeholder="City">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="fadeIn fourth">Address</label>
                        </td>
                        <td>
                            <input type="text" name="address" class="text fadeIn fourth" placeholder="Address">
                        </td>
                    </tr>
                    <tr>
                        <td>
                        </td>
                        <td>
                    <center>

                        <input type="submit" value="Register Now" class="button fadeIn fourth">
                    </center>
                    </td>
                    </tr>
                </table>
            </form>
        </div>
    </center>
</body>
</html>
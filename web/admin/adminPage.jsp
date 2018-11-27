<%-- 
    Document   : adminPage
    Created on : Oct 14, 2018, 12:23:35 PM
    Author     : Admin
--%>

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
    
    </head>
    <body>
        <c:if  test="${sessionScope.userID !=null}">
        <% if(request.getParameter("pgprt")==null || request.getParameter("pgprt").equals("0")  ) {%>
         <jsp:include page="../profile.jsp"/>
         
         <% } else if(request.getParameter("pgprt").equals("2")){%>
             <jsp:include page="course.jsp"/>
        <%} else if(request.getParameter("pgprt").equals("3")){%>
            <jsp:include page="question.jsp"/>
            
          <%} else if(request.getParameter("pgprt").equals("1")){%>
            <jsp:include page="accounts.jsp"/>
            
          <%}%>
        </c:if  >
        <c:if test="${sessionScope.userID ==null}">
            <c:redirect url="../login">
                
            </c:redirect>
         </c:if>
    </body>
</html>

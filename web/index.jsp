<%-- 
    Document   : index
    Created on : May 3, 2023, 2:35:21 PM
    Author     : pc asus
--%>

<%@page import="controller.BookControllerServlet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>CRUD Book Management</h1>
        Go to<a href="BookControllerServlet">Book Controller</a>
        <%
            BookControllerServlet temp = new BookControllerServlet();
            temp.init(getServletConfig());
            temp.service(request,response);
        %>
    </body>
</html>

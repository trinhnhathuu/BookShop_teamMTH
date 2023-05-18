<%-- 
    Document   : admin
    Created on : May 17, 2023, 8:44:08 PM
    Author     : TGDD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    </head>
    <body>
    </button>

    <table class="table">
        <input type="submit" value="Add Book"
               onclick="window.location.href = 'add-book.jsp';
                           return
                           false;"
               class="add-book-button"/>
        <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Ảnh</th>
                <th scope="col">Tên Sách</th>
                <th scope="col">Tên Tác Giả</th>
                <th scope="col">Giá</th>
                <th scope="col">action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="tempBook" items="${booklist}">
                <c:url var="updateLink" value="AdminController">
                    <c:param name="command" value="LOAD"
                             ></c:param>
                    <c:param name="bookid" value="${tempBook.id}"
                             ></c:param>

                </c:url>
                <c:url var="deleteLink" value="AdminController">
                    <c:param name="command" value="DELETE"
                             ></c:param>
                    <c:param name="BookId" value="${tempBook.id}"
                             ></c:param>

                </c:url>
                <tr>
                    <th scope="col">${tempBook.id}</th>
                    <td><img  src="img/${tempBook.image}"width="50px" height="50px"/></td>
                    <td>${tempBook.title}</td>
                    <td>${tempBook.author}</td>
                    <td>${tempBook.price}</td>

                    <td><div class="row ml-1 "><button class="col-lg-4 mb-4 border-0 mx-1 bg-info"><a href="${updateLink}">Update</a></button> 
                            
                            <button class="col-lg-4 mb-4 border-0 bg-danger"> <a href="${deleteLink}"
                                                                                 onclick="if (!(confirm('Sure?')))
                                               return false"

                                                                                 >Delete</a></button></div></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js" integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js" integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ" crossorigin="anonymous"></script>
</body>
</html>

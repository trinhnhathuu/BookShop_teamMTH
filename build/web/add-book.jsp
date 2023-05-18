<%-- 
    Document   : add-book
    Created on : May 17, 2023, 8:45:10 PM
    Author     : TGDD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1>add-magazine-form</h1>
        <form action="AdminController" method="GET">
            <input type="hidden" name="command" value="ADD" />

            <table border="0">
                <tbody>
                    
                  
                    <tr>
                        <td><label>Tên Sách </label> </td>
                        <td><input type="text" name="title" value="" /></td>
                    </tr>
                    <tr>
                        <td><label>Tác Giả </label> </td>
                        <td><input type="text" name="author" value="" /></td>
                    </tr>
                    <tr>
                        <td><label>thời gian </label> </td>
                        <td><input type="text" name="publisherDate" value="" /></td>
                    </tr>
                    <tr>
                        <td><label>thể loại </label> </td>
                        <td><input type="text" name="category" value="" /></td>
                    </tr>
                    <tr>
                        <td><label>chi tiết </label> </td>
                        <td><input type="text" name="description" value="" /></td>
                    </tr>
                    <tr>
                        <td><label>Price: </label> </td>
                        <td><input type="text" name="price" value="" /></td>
                    </tr>
                      <tr>
                        <td><label>Image </label></td>
                        <td><input type="text" name="image" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Save" class="save" /></td>
                    </tr>
                </tbody>
            </table>
        </form>

        <p>
            <a href="AdminController"> Back to the List</a>
        </p>
    </body>
</html>

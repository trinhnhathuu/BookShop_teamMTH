<%-- 
    Document   : cart
    Created on : May 14, 2023, 8:08:40 AM
    Author     : pc asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet"> 

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <c:set var="cartlist" value="${cartlist}" />
        <jsp:include page="header.jsp"></jsp:include>

            <!-- Page Header Start -->
            <div class="container-fluid bg-secondary mb-5">
                <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 300px">
                    <h1 class="font-weight-semi-bold text-uppercase mb-3">Shopping Cart</h1>
                    <div class="d-inline-flex">
                        <p class="m-0"><a href="">Home</a></p>
                        <p class="m-0 px-2">-</p>
                        <p class="m-0">Shopping Cart</p>
                    </div>
                </div>
            </div>
            <!-- Page Header End -->


            <!-- Cart Start -->
            <div class="container-fluid pt-5">
                <div class="row px-xl-5">
                    <div class="col-lg-8 table-responsive mb-5">
                        <table class="table table-bordered text-center mb-0">
                            <thead class="bg-secondary text-dark">
                                <tr>
                                    <th>Products</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th>Remove</th>
                                </tr>
                            </thead>
                            <tbody class="align-middle">
                            <c:forEach var="tempBook" items="${cartlist}">
                                <tr>
                                    <td class="align-middle"><img src="img/${tempBook.image}" alt="" style="width: 100px;">${tempBook.title}</td>
                                    <td class="align-middle">${tempBook.price}$</td>
                                    <td class="align-middle">
                                        <div class="row">
                                            <a class="btn btn-sm btn-decre" href="QuantityControllerServlet?action=dec&id=${tempBook.id}"><i class="fas fa-minus-square"></i></a>
                                            <input type="text" name="quantity" class="form-control"  value="${tempBook.quantity}" readonly> 
                                            <a class="btn bnt-sm btn-incre" href="QuantityControllerServlet?action=inc&id=${tempBook.id}"><i class="fas fa-plus-square"></i></a> 
                                            
                                        </div>
                                    </td>
                                    <td class="align-middle">${tempBook.price}$</td>
                                    <td class="align-middle"><a href="RemoveFromCartServlet?id=${tempBook.id}"><button class="btn btn-sm btn-primary"><i class="fa fa-times"></i></button></a></td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>
                <div class="col-lg-4">
                    <form class="mb-5" action="">
                        <div class="input-group">
                            <input type="text" class="form-control p-4" placeholder="Coupon Code">
                            <div class="input-group-append">
                                <button class="btn btn-primary">Apply Coupon</button>
                            </div>
                        </div>
                    </form>
                    <div class="card border-secondary mb-5">
                        <div class="card-header bg-secondary border-0">
                            <h4 class="font-weight-semi-bold m-0">Cart Summary</h4>
                        </div>
                        <div class="card-footer border-secondary bg-transparent">
                            <div class="d-flex justify-content-between mt-2">
                                <h5 class="font-weight-bold">Total</h5>
                                <h5 class="font-weight-bold">${totalprice}$</h5>
                            </div>
                            <button class="btn btn-block btn-primary my-3 py-3"><a href="CheckOutServlet">Proceed To Checkout</a></button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Cart End -->

        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>

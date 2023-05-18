/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cart;
import model.Order;
import model.OrderDAO;

/**
 *
 * @author pc asus
 */
public class CheckOutServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try ( PrintWriter out = response.getWriter()) {
            LocalDateTime now = LocalDateTime.now();
            ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
            if (cart_list != null) {
                for (Cart c : cart_list) {
                    OrderDAO oDao = new OrderDAO();
                    Order order = new Order();
                    order.setUserId("minhdaide");
                    order.setBookId(c.getId());
                    order.setQuantity(c.getQuantity());
                    order.setOrderDate(LocalDate.of(now.getYear(), now.getMonth(), now.getDayOfMonth()));
                    order.setShippingAddress("123 ABC Street");
                    double priceBook = oDao.findPriceBookById(c.getId());
                    System.out.println("price:");
                    System.out.println(priceBook);
                    System.out.println("so luong:");
                    System.out.println(c.getQuantity());
                    order.setTotalAmount(priceBook * c.getQuantity());
                    
                    boolean result = oDao.addOrder(order);
                    if (!result) {
                        break;
                    }
                }
                cart_list.clear();
                
                int currentItemCount = 0;
                if (request.getSession().getAttribute("cartItemCount") != null) {
                    currentItemCount = (int) request.getSession().getAttribute("cartItemCount");
                }
                request.getSession().setAttribute("cartItemCount", cart_list.size());

                
                response.sendRedirect("BookControllerServlet");
            } else {
                response.sendRedirect("CartControllerServlet");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

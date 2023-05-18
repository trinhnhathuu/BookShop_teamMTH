/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BookDAO;
import model.Cart;

/**
 *
 * @author pc asus
 */
public class CartControllerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        try {
            String theCommand = request.getParameter("command");
            if (theCommand == null) {
                theCommand = "LIST";
            }
            switch (theCommand) {
                case "LIST":
                    listCarts(request, response);
                    break;
//                case "ADD":
//                    addMagazine(request, response);
//                    break;
//                case "UPDATE":
//                    updateMagazine(request, response);
//                    break;
//                case "DELETE":
//                    deleteMagazine(request, response);
//                    break;
                default:
                    listCarts(request, response);
            }

        } catch (Exception ex) {

            Logger.getLogger(CartControllerServlet.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void listCarts(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
        if (cart_list != null) {
            List<Cart> cartBook = null;
            BookDAO bookDAO = new BookDAO();
            cartBook = bookDAO.getCartBooks(cart_list);
            double totalPrice = bookDAO.getTotalCartPrice(cart_list);
            request.setAttribute("cartlist", cartBook);
            request.setAttribute("totalprice", totalPrice);
            System.out.println(cart_list);
        }

        request.getRequestDispatcher("/cart.jsp").forward(request, response);

    }

    

}

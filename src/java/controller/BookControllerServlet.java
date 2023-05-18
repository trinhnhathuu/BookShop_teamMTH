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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Book;
import model.BookDAO;
import model.Cart;

/**
 *
 * @author pc asus
 */
public class BookControllerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        BookDAO bookDAO = new BookDAO();
        List<Book> list = bookDAO.getBooks();

        request.setAttribute("booklist", list);

        request.getRequestDispatcher("list-book.jsp").forward(request, response);
    }

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
                    listBooks(request, response);
                    break;
//                case "ADD":
//                    addMagazine(request, response);
//                    break;
                case "LOAD":
                    loadBook(request, response);
                    break;
//                case "UPDATE":
//                    updateMagazine(request, response);
//                    break;
//                case "DELETE":
//                    deleteMagazine(request, response);
//                    break;
                default:
                    listBooks(request, response);
            }

        } catch (Exception ex) {

            Logger.getLogger(BookControllerServlet.class.getName()).log(Level.SEVERE,
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void listBooks(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        BookDAO bookDAO = new BookDAO();
        List<Book> list = bookDAO.getBooks();

        request.setAttribute("booklist", list);
        System.out.println(list);

        request.getRequestDispatcher("list-book.jsp").forward(request, response);

    }

    

    private void loadBook(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        String bookId = request.getParameter("bookId");

        List<Book> list = new BookDAO().findBookById(bookId);

        request.setAttribute("THE_BOOK", list);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("detail-book.jsp");
        dispatcher.forward(request, response);
    }

}

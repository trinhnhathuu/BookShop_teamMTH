/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dbcontext.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc asus
 */
public class OrderDAO {
    public boolean addOrder(Order order) {
        String sql = "INSERT INTO Orders (UserName, BookId, Quantity, OrderDate, ShippingAddress, TotalAmount) \n"
                + "VALUES (?, ?, ?, ?, ?, ?);";
        ConnectDB db = ConnectDB.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
        boolean result = false;
        try {
            con = db.openConnection();
            statement = con.prepareStatement(sql);
            statement.setString(1, order.getUserId());
            statement.setInt(2, order.getBookId());
            statement.setInt(3, order.getQuantity());
            statement.setObject(4, java.sql.Date.valueOf(order.getOrderDate()));
            statement.setString(5, order.getShippingAddress());
            statement.setDouble(6, order.getTotalAmount());
            // khi insert se dung execute
            statement.execute();
            result = true;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                statement.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return result;
    }
    public double findPriceBookById(int id) {
        double sum = 0;
        ConnectDB db = ConnectDB.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            con = db.openConnection();
            String sql = "Select Price from Book where Id = ?";
            // execute cau lenh sql
            statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                sum = rs.getDouble("Price");
            }
            return sum;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                statement.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return sum;
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

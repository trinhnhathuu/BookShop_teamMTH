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
public class BookDAO {

    public List<Book> getBooks() {
        List<Book> sl = new ArrayList<>();
        ConnectDB db = ConnectDB.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            con = db.openConnection();
            String sql = "Select * from Book order by Id";
            // execute cau lenh sql
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2).trim();
                String author = rs.getString(3).trim();
                LocalDate publicationDate = rs.getDate("PublicationDate").toLocalDate();
                String category = rs.getString(5).trim();
                double price = rs.getDouble(6);
                String description = rs.getString(7);
                String image = rs.getString(8);
                Book tempBook = new Book(id, title, author, publicationDate, category, price, description, image);
                sl.add(tempBook);
            }
            return sl;
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
        return sl;
    }

    public List<Cart> getCartBooks(ArrayList<Cart> cartList) {
        List<Cart> sl = new ArrayList<>();
        ConnectDB db = ConnectDB.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            if (!cartList.isEmpty()) {
                for (Cart cart : cartList) {
                    con = db.openConnection();
                    String sql = "Select * from Book where Id = ?";
                    // execute cau lenh sql
                    statement = con.prepareStatement(sql);
                    statement.setInt(1, cart.getId());
                    rs = statement.executeQuery();
                    while (rs.next()) {
                        Cart row = new Cart();
                        row.setId(rs.getInt("Id"));
                        row.setTitle(rs.getNString("Title"));
                        row.setPrice(rs.getDouble("Price"));
                        row.setQuantity(cart.getQuantity());
                        row.setImage(rs.getString("Image"));
                        sl.add(row);
                    }
                }
            }
            return sl;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return sl;
    }

    public void addBook(Book book) {
        String sql = "INSERT INTO Book (Title, Author, PublicationDate, Category, Price, [Description], [Image])\n"
                + "VALUES (?, ?, ?, ?, ?, ?, ?);";
        ConnectDB db = ConnectDB.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
        try {

            con = db.openConnection();
            statement = con.prepareStatement(sql);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setObject(3, java.sql.Date.valueOf(book.getPublisherDate()));
            statement.setString(4, book.getCategory());
            statement.setDouble(5, book.getPrice());
            statement.setString(6, book.getDescription());
            statement.setString(7, book.getImage());
            // khi insert se dung execute
            statement.execute();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                statement.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void updateBook(Book book) {
        String sql = "UPDATE Book \n"
                + "SET Title = ?, Author = ?, PublicationDate = ?, Category = ?, Price = ?, [Description] = ?, [Image] = ? \n"
                + "WHERE Id = ?;";
        ConnectDB db = ConnectDB.getInstance();
        Connection con = null;
        PreparedStatement statement = null;

        try {
            con = db.openConnection();
            statement = con.prepareStatement(sql);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setObject(3, java.sql.Date.valueOf(book.getPublisherDate()));
            statement.setString(4, book.getCategory());
            statement.setDouble(5, book.getPrice());
            statement.setString(6, book.getDescription());
            statement.setString(7, book.getImage());
            statement.setInt(8, book.getId());
            statement.execute();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                statement.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        } // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void deleteBook(String idd) {
        String sql = "DELETE FROM Book WHERE Id =?";
        ConnectDB db = ConnectDB.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
        try {

            con = db.openConnection();
            statement = con.prepareStatement(sql);
            // Convert String idd to int id
            int id = Integer.parseInt(idd);
            // set paramenter in the sql
            statement.setInt(1, id);
            statement.execute();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                statement.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Book> findBookById(String idd) {
        List<Book> sl = new ArrayList<>();
        ConnectDB db = ConnectDB.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            con = db.openConnection();
            String sql = "Select * from Book\n"
                    + "WHERE Id = ?;";
            // execute cau lenh sql
            statement = con.prepareStatement(sql);
            int id = Integer.parseInt(idd);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                int id1 = rs.getInt(1);
                String title = rs.getString(2).trim();
                String author = rs.getString(3).trim();
                LocalDate publicationDate = rs.getDate("PublicationDate").toLocalDate();
                String category = rs.getString(5).trim();
                double price = rs.getDouble(6);
                String description = rs.getString(7);
                String image = rs.getString(8);
                Book tempBook = new Book(id1, title, author, publicationDate, category, price, description, image);
                sl.add(tempBook);
            }
            return sl;
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
        return sl;
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public double getTotalCartPrice(ArrayList<Cart> cartList) {
        double sum = 0;
        ConnectDB db = ConnectDB.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            con = db.openConnection();
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    String sql = "Select Price from Book where Id = ?";
                    // execute cau lenh sql
                    statement = con.prepareStatement(sql);
                    statement.setInt(1, item.getId());
                    rs = statement.executeQuery();
                    while (rs.next()) {
                        sum += rs.getDouble("Price") * item.getQuantity();
                    }
                }
            }

            return sum;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return sum;

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import dbcontext.ConnectDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author TGDD
 */
public class UserDao {
    ConnectDB db = ConnectDB.getInstance();
    private String sql = "SELECT * FROM UserAccount WHERE UserName = ? AND Password = ?";
    private PreparedStatement pst;
    private ResultSet rs;

    public User userLogin(String username, String password) throws ClassNotFoundException {
        User user = null;
        try {
            Connection con = db.openConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password); 
            rs = pst.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("Id"));
                user.setUsername(rs.getString("UserName"));
                user.setPassword(rs.getString("Password"));
                user.setRoleadmin(rs.getBoolean("RoleAdmin"));
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return user;
    }
}


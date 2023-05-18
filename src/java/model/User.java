/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author TGDD
 */
public class User {
        private int id;
	private String username;
	private String password;
        private Boolean roleadmin;

    public User() {
    }
        

    public User(int id, String username, String password, Boolean roleadmin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roleadmin = roleadmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getRoleadmin() {
        return roleadmin;
    }

    public void setRoleadmin(Boolean roleadmin) {
        this.roleadmin = roleadmin;
    }
    
    
}

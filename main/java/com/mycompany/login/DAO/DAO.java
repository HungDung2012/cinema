/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login.DAO;
import java.sql.*;
/**
 *
 * @author admin
 */
public class DAO {
    protected Connection con;
    
    public DAO() {
        String url = "jdbc:mysql://localhost:3306/rapchieuphim";
        String user = "root";
        String password = "A11dungchu@";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        }
        catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Khong the ket noi den database", e);
        }
    } 
}

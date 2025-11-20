/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mycompany.login.Model.Phim;

/**
 *
 * @author admin
 */
public class PhimDao extends DAO {
    public PhimDao() {
        super();
    }

    public boolean updatePhim(Phim phim){
        try {
            String sql = "INSERT INTO tblPhim (tenPhim, theLoai, thoiLuong, moTa) VALUES (?, ?, ?, ?)";
            int maPhim = 0;
            
            try (PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, phim.getTenPhim());
                ps.setString(2, phim.getTheLoai());
                ps.setInt(3, phim.getThoiLuong());
                ps.setString(4, phim.getMoTa());
                
                return ps.executeUpdate() > 0;
            }
        }
        catch (Exception e){
            System.err.println("Loi khi them phim moi: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}

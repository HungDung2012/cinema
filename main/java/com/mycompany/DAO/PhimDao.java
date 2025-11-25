/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.Model.Phim;

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
            
            try (PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, phim.getTenPhim());
                ps.setString(2, phim.getTheLoai());
                ps.setInt(3, phim.getThoiLuong());
                ps.setString(4, phim.getMoTa());
                
                return ps.executeUpdate() > 0;
            }
        }
        catch (Exception e){
            System.err.println("Loi them phim moi: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean editPhim(Phim phim) {
        try {
            String sql = "UPDATE tblPhim SET tenPhim = ?, theLoai = ?, thoiLuong = ?, moTa = ? WHERE maPhim = ?";
            
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, phim.getTenPhim());
                ps.setString(2, phim.getTheLoai());
                ps.setInt(3, phim.getThoiLuong());
                ps.setString(4, phim.getMoTa());
                ps.setInt(5, phim.getMaPhim());

                return ps.executeUpdate() > 0;
            } catch(SQLException e){
                System.err.println("Loi 1 sua thong tin phim: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("Loi 2 sua thong tin phim: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
        return false;
    } 
    
    public boolean deletePhim(int maPhim) {
        try {   
            String sqlDeleteLichChieu = "DELETE FROM tbllichchieuphim WHERE phim_id = ?";
            try (PreparedStatement ps = con.prepareStatement(sqlDeleteLichChieu)) {
                ps.setInt(1, maPhim);
                ps.executeUpdate();
            }
            
            String sqlDeletePhim = "DELETE FROM tblPhim WHERE maPhim = ?";
            try (PreparedStatement ps = con.prepareStatement(sqlDeletePhim)) {
                ps.setInt(1, maPhim);
                return ps.executeUpdate() > 0;
            }
            
        } catch (Exception e) {
            System.err.println("Loi xoa phim: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public List<Phim> getDanhsachphim() {
        List<Phim> danhSachPhim = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tblPhim ORDER BY maPhim ASC";
            try (PreparedStatement ps = con.prepareStatement(sql)){
                try (ResultSet rs = ps.executeQuery()) {
                    while(rs.next()) {
                        int maPhim = rs.getInt("maPhim");
                        String tenPhim = rs.getString("tenPhim");
                        String theLoai = rs.getString("theLoai");
                        int thoiLuong = rs.getInt("thoiLuong");
                        String moTa = rs.getString("moTa");
                        
                        danhSachPhim.add(new Phim(maPhim, tenPhim, theLoai, thoiLuong, moTa));
                    }
                } catch (SQLException e) {
                    System.err.println("Loi 1 truy van lay tat ca phim: " + e.getMessage());
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                System.err.println("Loi 2 truy van lay tat ca phim: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("Loi lay tat ca phim: " + e.getMessage());
            e.printStackTrace();
        }
        return danhSachPhim;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login.DAO;

import com.mycompany.login.Model.NhanVien;
import com.mycompany.login.Model.NhanVienQuanLy;
import com.mycompany.login.Model.NhanVienQuayVe;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class NhanVienDao extends DAO {
    public NhanVienDao(){
        super();
    }
    
    public NhanVien checkLogin(String tenDangnhap, String matKhau) {
        String sql = "SELECT * FROM tblnhanvien WHERE tenDangnhap=? AND matKhau=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, tenDangnhap);
            ps.setString(2, matKhau);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()) {
                    int id = rs.getInt("id");
                    String tenDangNhap = rs.getString("tenDangnhap");
                    String matKhau1 = rs.getString("matKhau");
                    String hoTen = rs.getString("hoTen");
                    Date ngaySinh = rs.getDate("ngaySinh");
                    String diaChi = rs.getString("diaChi");
                    String email = rs.getString("email");
                    String sdt = rs.getString("sdt");
                    
                    String sqlQuanLy = "SELECT viTri FROM tblnhanvienquanly WHERE maNhanVien=?";
                    try (PreparedStatement psQuanLy = con.prepareStatement(sqlQuanLy)) {
                        psQuanLy.setInt(1, id);
                        try (ResultSet rsQuanLy = psQuanLy.executeQuery()) {
                            if (rsQuanLy.next()) {
                                String viTri = rsQuanLy.getString("viTri");
                                return new NhanVienQuanLy(id, tenDangNhap, matKhau1, hoTen, ngaySinh, diaChi, email, sdt, id, viTri);
                            }
                        }
                    }
                    
                    String sqlQuayVe = "SELECT viTri FROM tblnhanvienquayve WHERE maNhanVien=?";
                    try (PreparedStatement psQuayVe = con.prepareStatement(sqlQuayVe)) {
                        psQuayVe.setInt(1, id);
                        try (ResultSet rsQuayVe = psQuayVe.executeQuery()) {
                            if (rsQuayVe.next()) {
                                String viTri = rsQuayVe.getString("viTri");
                                return new NhanVienQuayVe(id, tenDangNhap, matKhau1, hoTen, ngaySinh, diaChi, email, sdt, id, viTri);
                            }
                        }
                    }
                }
            } 
        }catch (SQLException e) {
            System.err.println("Lỗi khi đăng nhập: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    

    public boolean register(NhanVien nv, String viTri){
        try {
            String sql= "INSERT INTO tblnhanvien (tenDangnhap, matKhau, hoTen, ngaySinh, diaChi, email, sdt) VALUES (?, ?, ?, ?, ?, ?, ?)";
            int maNhanVien = 0;
            
            try (PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){
                ps.setString(1, nv.getTenDangnhap());
                ps.setString(2, nv.getMatKhau());
                ps.setString(3, nv.getHoTen());
                ps.setDate(4, nv.getNgaySinh());
                ps.setString(5, nv.getDiaChi());
                ps.setString(6, nv.getEmail());
                ps.setString(7, nv.getSdt());
                
                ps.executeUpdate();

                try (ResultSet key = ps.getGeneratedKeys()) {
                    if (key.next()) {
                        maNhanVien = key.getInt(1);
                    } 
                } catch (SQLException e){
                    System.err.println("Loi khi lay ma nhan vien: " + e.getMessage());
                    e.printStackTrace();
                    return false;
                }
            }
            String sqlQuanLy = "";
            if(viTri.equalsIgnoreCase("QuanLy")){
                sqlQuanLy = "INSERT INTO tblnhanvienquanly (maNhanVien, viTri) VALUES (?, ?)";
            } else if(viTri.equalsIgnoreCase("QuayVe")){
                sqlQuanLy = "INSERT INTO tblnhanvienquayve (maNhanVien, viTri) VALUES (?, ?)";

            }
            try (PreparedStatement ps = con.prepareStatement(sqlQuanLy)) {
                ps.setInt(1, maNhanVien);
                ps.setString(2, viTri);
                return ps.executeUpdate() > 0;
            } catch (SQLException e){
                System.err.println("Loi khi them nhan vien theo vi tri: " + e.getMessage());
                e.printStackTrace();
                return false;
            }
            
        }
        catch (SQLException e){
            System.err.println("Loi khi dang ki: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}

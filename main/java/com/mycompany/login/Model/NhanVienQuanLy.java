/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login.Model;

import java.sql.Date;

/**
 *
 * @author admin
 */
public class NhanVienQuanLy extends NhanVien {
    private int maNhanVien; 
    private String viTri;
    public NhanVienQuanLy(int id, String tenDangNhap, String matKhau, String hoTen, Date ngaySinh, String diaChi, String email, String sdt, int maNhanVien, String viTri) {
        super(id, tenDangNhap, matKhau, hoTen, ngaySinh, diaChi, email, sdt);
        this.maNhanVien = id;
        this.viTri = viTri;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    @Override
    public String getViTri() {
        return this.viTri; 
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Model;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author admin
 */
public class Lichchieuphim {
    private int maLichChieu;
    private Date ngayChieuPhim;
    private Time gioChieu;
    private String moTa;
    private Phim phim;
    private Phongchieuphim phong;

    public Lichchieuphim(int maLichChieu, Date ngayChieuPhim, Time gioChieu, String moTa, Phim phim, Phongchieuphim phong) {
        this.maLichChieu = maLichChieu;
        this.ngayChieuPhim = ngayChieuPhim;
        this.gioChieu = gioChieu;
        this.moTa = moTa;
        this.phim = phim;
        this.phong = phong;
    }

    public int getMaLichChieu() {
        return maLichChieu;
    }

    public void setMaLichChieu(int maLichChieu) {
        this.maLichChieu = maLichChieu;
    }

    public Date getNgayChieuPhim() {
        return ngayChieuPhim;
    }

    public void setNgayChieuPhim(Date ngayChieuPhim) {
        this.ngayChieuPhim = ngayChieuPhim;
    }

    public Time getGioChieu() {
        return gioChieu;
    }

    public void setGioChieu(Time gioChieu) {
        this.gioChieu = gioChieu;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Phim getPhim() {
        return phim;
    }

    public void setPhim(Phim phim) {
        this.phim = phim;
    }

    public Phongchieuphim getPhong() {
        return phong;
    }

    public void setPhong(Phongchieuphim phong) {
        this.phong = phong;
    }

    
}

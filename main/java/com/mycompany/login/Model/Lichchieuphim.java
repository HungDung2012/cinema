/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login.Model;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author admin
 */
public class Lichchieuphim {
    private int maLichChieu;
    private Date ngaychieuphim;
    private Time gioChieu;

    public Lichchieuphim(int maLichChieu, Date ngaychieuphim, Time gioChieu) {
        this.maLichChieu = maLichChieu;
        this.ngaychieuphim = ngaychieuphim;
        this.gioChieu = gioChieu;
    }

    public int getMaLichChieu() {
        return maLichChieu;
    }

    public void setMaLichChieu(int maLichChieu) {
        this.maLichChieu = maLichChieu;
    }

    public Date getNgaychieuphim() {
        return ngaychieuphim;
    }

    public void setNgaychieuphim(Date ngaychieuphim) {
        this.ngaychieuphim = ngaychieuphim;
    }

    public Time getGioChieu() {
        return gioChieu;
    }

    public void setGioChieu(Time gioChieu) {
        this.gioChieu = gioChieu;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Model;

/**
 *
 * @author admin
 */
public class Phongchieuphim {
    private int maPhong;
    private String ten;
    private int soGhengoi;
    private String moTa;
    private Rapchieuphim rap;

    public Phongchieuphim(int maPhong, String ten, int soGhengoi, String moTa, Rapchieuphim rap) {
        this.maPhong = maPhong;
        this.ten = ten;
        this.soGhengoi = soGhengoi;
        this.moTa = moTa;
        this.rap = rap;
    }

    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int maPhong) {
        this.maPhong = maPhong;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSoGhengoi() {
        return soGhengoi;
    }

    public void setSoGhengoi(int soGhengoi) {
        this.soGhengoi = soGhengoi;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Rapchieuphim getRap() {
        return rap;
    }

    public void setRap(Rapchieuphim rap) {
        this.rap = rap;
    }

    
}

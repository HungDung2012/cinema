/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Model;

/**
 *
 * @author admin
 */
public class Rapchieuphim {
    private int maRap;
    private String ten;
    private String moTa;
    private Khuvuc khuvuc;

    public Rapchieuphim(int maRap, String ten, String moTa, Khuvuc khuvuc) {
        this.maRap = maRap;
        this.ten = ten;
        this.moTa = moTa;
        this.khuvuc = khuvuc;
    }

    public int getMaRap() {
        return maRap;
    }

    public void setMaRap(int maRap) {
        this.maRap = maRap;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Khuvuc getKhuvuc() {
        return khuvuc;
    }

    public void setKhuvuc(Khuvuc khuvuc) {
        this.khuvuc = khuvuc;
    }

}

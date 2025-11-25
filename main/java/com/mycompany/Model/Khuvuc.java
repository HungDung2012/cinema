/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Model;

/**
 *
 * @author admin
 */
public class Khuvuc {
    private int maKhuvuc;
    private String ten;
    private String moTa;
    private String diaChi;

    public Khuvuc(int maKhuvuc, String ten, String moTa, String diaChi) {
        this.maKhuvuc = maKhuvuc;
        this.ten = ten;
        this.moTa = moTa;
        this.diaChi = diaChi;
    }

    public int getMaKhuvuc() {
        return maKhuvuc;
    }

    public void setMaKhuvuc(int maKhuvuc) {
        this.maKhuvuc = maKhuvuc;
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}

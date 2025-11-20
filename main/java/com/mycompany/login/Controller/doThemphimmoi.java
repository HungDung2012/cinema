/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login.Controller;

import java.io.IOException;
import java.sql.SQLException;

import com.mycompany.login.DAO.PhimDao;
import com.mycompany.login.Model.Phim;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(urlPatterns = {"/addmovie-submit"})
public class doThemphimmoi extends HttpServlet{
    private PhimDao phimDao;
    @Override
    public void init(){
        phimDao = new PhimDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String path = req.getServletPath();
            switch (path){
                case "/addmovie-submit":
                    addMovie(req, resp);
                    break;
            }
        } catch (Exception e) {
            System.err.println("Loi switch case phim: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void addMovie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String tenPhim = req.getParameter("tenPhim");
        String theLoai = req.getParameter("theLoai");
        int thoiLuong = Integer.parseInt(req.getParameter("thoiLuong"));
        String moTa = req.getParameter("moTa");

        boolean success = phimDao.updatePhim(new Phim(0, tenPhim, theLoai, thoiLuong, moTa));

        if(success){
            req.getSession().setAttribute("successMessage", "Thêm phim thành công");
            resp.sendRedirect(req.getContextPath() + "/Quanlyphim.jsp");
            return;
        } else {
            req.getSession().setAttribute("errorMessage", "Thêm phim thất bại");
            resp.sendRedirect(req.getContextPath() + "/Themphimmoi.jsp");
            return;
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.mycompany.DAO.PhimDao;
import com.mycompany.Model.Phim;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(urlPatterns = {"/addmovie-submit", "/gettt-submit", "/edit-movie", "/delete-movie", "/search-movie"})
public class doQlphim extends HttpServlet{
    private PhimDao pDao;
    @Override
    public void init(){
        pDao = new PhimDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String path = req.getServletPath();
            switch (path){
                case "/addmovie-submit":
                    addMovie(req, resp);
                    break;
                case "/gettt-submit":
                    getMovie(req, resp);
                    break;
                case "/edit-movie":
                    editMovie(req, resp);
                    break;
                case "/delete-movie":
                    deleteMovie(req, resp);
                    break;
                case "/search-movie":
                    searchMovie(req, resp);
                    break;
            }
        } catch (Exception e) {
            System.err.println("Loi switch case phim: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private void getMovie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException{
        List<Phim> danhSachPhim = pDao.getDanhsachphim();
        if(danhSachPhim != null && !danhSachPhim.isEmpty()){
            req.getSession().setAttribute("danhSachPhim", danhSachPhim);
            resp.sendRedirect(req.getContextPath() + "/Xemthongtinphim.jsp");
        }else {
            req.getSession().setAttribute("errorMessage", "khong lay duoc danh sach phim");
            resp.sendRedirect(req.getContextPath() + "/Quanlyphim.jsp");
        }
    } 

    private void addMovie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String tenPhim = req.getParameter("tenPhim");
        String theLoai = req.getParameter("theLoai");
        int thoiLuong = Integer.parseInt(req.getParameter("thoiLuong"));
        String moTa = req.getParameter("moTa");

        boolean success = pDao.updatePhim(new Phim(0, tenPhim, theLoai, thoiLuong, moTa));

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

    private void editMovie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        int maPhim = Integer.parseInt(req.getParameter("maPhim"));
        String tenPhim = req.getParameter("tenPhim");
        String theLoai = req.getParameter("theLoai");
        int thoiLuong = Integer.parseInt(req.getParameter("thoiLuong"));
        String moTa = req.getParameter("moTa");

        boolean success = pDao.editPhim(new Phim(maPhim, tenPhim, theLoai, thoiLuong, moTa));
        
        List<Phim> danhSachPhim = pDao.getDanhsachphim();
        req.getSession().setAttribute("danhSachPhim", danhSachPhim);
        
        if(success){
            req.getSession().setAttribute("successMessage", "Sửa phim thành công");
            resp.sendRedirect(req.getContextPath() + "/Xemthongtinphim.jsp");
            return;
        } else {
            req.getSession().setAttribute("errorMessage", "Sửa phim thất bại");
            resp.sendRedirect(req.getContextPath() + "/Xemthongtinphim.jsp");
            return;
        }
    }

    private void deleteMovie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String maPhimStr = req.getParameter("maPhim");

        boolean success = pDao.deletePhim(Integer.parseInt(maPhimStr));
        
        List<Phim> danhSachPhim = pDao.getDanhsachphim();
        req.getSession().setAttribute("danhSachPhim", danhSachPhim);
        
        if(success){
            req.getSession().setAttribute("successMessage", "Xóa phim thành công");
            resp.sendRedirect(req.getContextPath() + "/Xemthongtinphim.jsp");
            return;
        } else {
            req.getSession().setAttribute("errorMessage", "Xóa phim thất bại");
            resp.sendRedirect(req.getContextPath() + "/Xemthongtinphim.jsp");
            return;
        }
    }
    
    private void searchMovie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String keyword = req.getParameter("keyword");
        
        if (keyword == null || keyword.trim().isEmpty()) {
            List<Phim> danhSachPhim = pDao.getDanhsachphim();
            req.getSession().setAttribute("danhSachPhim", danhSachPhim);
        } else {
            List<Phim> danhSachPhim = pDao.timKiemPhim(keyword.trim());
            req.getSession().setAttribute("danhSachPhim", danhSachPhim);
        }
        
        resp.sendRedirect(req.getContextPath() + "/Xemthongtinphim.jsp");
    }
}

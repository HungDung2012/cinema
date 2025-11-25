/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Controller;

import com.mycompany.DAO.NhanVienDao;
import com.mycompany.Model.NhanVien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author admin
 */

@WebServlet(urlPatterns = {"/login-submit", "/register-submit"})
public class doLogin extends HttpServlet{
    private NhanVienDao nvDao;
    @Override
    public void init(){
        nvDao = new NhanVienDao();
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String path = req.getServletPath();
            switch (path){
                case "/login-submit":
                    login(req, resp);
                    break;
                case "/register-submit":
                    register(req, resp);
                    break;
            }
        } catch (SQLException e){
            resp.sendRedirect(req.getContextPath() + "/Dangnhap.jsp");
            System.err.println("Loi switch case dang nhap, dang ki: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String tenDangnhap = req.getParameter("tendangnhap");
        String matKhau = req.getParameter("matkhau");
        
        NhanVien nv = nvDao.checkLogin(tenDangnhap, matKhau);
        if(nv != null){
            HttpSession session = req.getSession();
            session.setAttribute("nhanVien", nv);
            resp.sendRedirect(req.getContextPath() + "/TrangChuQuanLy.jsp");
        }else {
            req.getSession().setAttribute("errorMessage", "Sai tên đăng nhập hoặc mật khẩu");
            resp.sendRedirect(req.getContextPath() + "/Dangnhap.jsp");
        }
    }
    
    private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String tenDangnhap = req.getParameter("tendangnhap");
        String matKhau = req.getParameter("matkhau");
        String hoTen = req.getParameter("hoten");
        String ngaySinh = req.getParameter("ngaysinh");
        String diaChi = req.getParameter("diachi");
        String email = req.getParameter("email");
        String sdt = req.getParameter("sdt");
        String viTri = req.getParameter("vitri");
        
        boolean success = nvDao.register(new NhanVien( 0, tenDangnhap, matKhau, hoTen, java.sql.Date.valueOf(ngaySinh), diaChi, email, sdt) {
            @Override
            public String getViTri() {
                return viTri;
            }
        }, viTri);

        if (!success) {
            req.getSession().setAttribute("errorMessage", "Đăng ký thất bại. Vui lòng thử lại.");
            resp.sendRedirect(req.getContextPath() + "/Dangki.jsp");
            return;
        }else {
            req.getSession().setAttribute("successMessage", "Đăng ký thành công! Vui lòng đăng nhập.");
            resp.sendRedirect(req.getContextPath() + "/Dangnhap.jsp");
            return;
        }
        
    }
}

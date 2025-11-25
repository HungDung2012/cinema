/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Controller;

import java.io.IOException;
import java.sql.SQLException;

import com.mycompany.DAO.LichchieuDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(urlPatterns = {"/addschedule-submit", "/addschedule-pre"})
public class doLaplich extends HttpServlet{
    private LichchieuDao lichchieuDao;
    @Override
    public void init(){
        lichchieuDao = new LichchieuDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        try {
            String path = req.getServletPath();
            switch (path){
                case "/addschedule-submit":
                    updateSchedule(req, resp);
                    break;
                case "/addschedule-pre":
                    getSchedule(req, resp);
                    break;
            }
        } catch (Exception e) {
            System.err.println("Loi switch case lich chieu: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void getSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException{
        // LichchieuDao lc = lichchieuDao.getLichChieu();
        // if(lc != null){
        //     req.getSession().setAttribute("lichchieu", lc);
        //     resp.sendRedirect(req.getContextPath() + "/Laplichchieuphim.jsp");
        // }else {
        //     req.getSession().setAttribute("errorMessage", "khong lay duoc lich chieu");
        //     resp.sendRedirect(req.getContextPath() + "/Quanlylichchieu.jsp");
        // }
    }
    
    private void updateSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, SQLException, IOException{
      
    }
}

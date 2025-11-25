<%-- 
    Document   : Suaphim
    Created on : Nov 21, 2025, 6:05:11 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.Model.Phim"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sửa Phim</title>
        <style>
            body {
                display: flex;
                justify-content: center;
                align-items: center;
            }
            h1 {
                padding-bottom: 10px;
                margin-bottom: 30px;
            }
            .form-group {
                margin-bottom: 20px;
            }
            label {
                display: block;
                margin-bottom: 5px;
            }
            input, textarea {
                width: 100%;
                padding: 10px;
                box-sizing: border-box;
            }
            .submit-btn {
                width: 45%;
                padding: 10px;
                margin-bottom: 20px;
                margin-right: 5px;
            }
        </style>
    </head>
    <body>
        <%
            if (session.getAttribute("nhanVien") == null) {
                response.sendRedirect(request.getContextPath() + "/Dangnhap.jsp");
                return;
            }
            
            List<Phim> danhSachPhim = (List<Phim>) session.getAttribute("danhSachPhim");
            String maPhimStr = request.getParameter("maPhim");
            Phim phim = null;
            
            if (danhSachPhim != null && maPhimStr != null) {
                int maPhim = Integer.parseInt(maPhimStr);
                for (Phim p : danhSachPhim) {
                    if (p.getMaPhim() == maPhim) {
                        phim = p;
                        break;
                    }
                }
            }
            
            if (phim == null) {
                response.sendRedirect(request.getContextPath() + "/Xemthongtinphim.jsp");
                return;
            }
        %>

        <div class="container">
            <h1>Chỉnh Sửa Phim</h1>
            <form class="submit-form" method="post" action="${pageContext.request.contextPath}/edit-movie">
                <input 
                    type="hidden" 
                    name="maPhim" 
                    value="<%= phim.getMaPhim() %>"
                >
                
                <div class="form-group">
                    <label for="tenPhim">Tên Phim</label>
                    <input 
                        type="text" 
                        id="tenPhim" 
                        name="tenPhim" 
                        value="<%= phim.getTenPhim() %>" 
                        required
                    >
                </div>
                
                <div class="form-group">
                    <label for="theLoai">Thể Loại</label>
                    <input 
                        type="text" 
                        id="theLoai" 
                        name="theLoai" 
                        value="<%= phim.getTheLoai() %>" 
                        required
                    >
                </div>
                
                <div class="form-group">
                    <label for="thoiLuong">Thời Lượng (phút)</label>
                    <input 
                        type="number" 
                        id="thoiLuong" 
                        name="thoiLuong" 
                        value="<%= phim.getThoiLuong() %>" 
                        required 
                        min="1"
                    >
                </div>
                
                <div class="form-group">
                    <label for="moTa">Mô Tả</label>
                    <textarea 
                        id="moTa" 
                        name="moTa" 
                        rows="4"
                    ><%= phim.getMoTa() != null ? phim.getMoTa() : "" %></textarea>
                </div>
                
                <div class="button-group">
                    <button type="submit" class="submit-btn">Lưu</button>
                    <button type="button" class="submit-btn" onclick="window.location.href='${pageContext.request.contextPath}/Xemthongtinphim.jsp'">Hủy</button>
                </div>
            </form>
        </div>
    </body>
</html>

<%-- 
    Document   : Quanlyphim
    Created on : Nov 19, 2025, 3:12:18 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quan ly phim</title>
        <style>
            body{
                display: flex;
                justify-content: center;
                align-items: center;
            }
            .container {
                max-width: 800px;
                margin: 0 auto;
                padding: 30px;
            }
            h1 {
                padding-bottom: 10px;
                margin-bottom: 30px;
            }
            .info-section {
                padding: 20px;
            }
            .info-row {
                display: flex;
                margin-bottom: 15px;
                align-items: center;
            }
            .info-label {
                font-weight: bold;
                width: 150px;
                margin-right: 15px;
            }
            .info-value {
                font-size: 16px;
            }
            .submit-btn {
                width: 100%;
                padding: 20px;
                margin-bottom: 20px;
            }
        </style>
    </head>
    <body>
        <%
            if (session.getAttribute("nhanVien") == null) {
                response.sendRedirect(request.getContextPath() + "/Dangnhap.jsp");
                return;
            }
            
            com.mycompany.Model.NhanVien nv = 
                (com.mycompany.Model.NhanVien) session.getAttribute("nhanVien");
        %>

        <div class="container">
            <h1>Quản Lý Phim</h1>

            <div class="info-section">
                <div class="info-row">
                    <div class="info-label">Mã Nhân Viên:</div>
                    <div class="info-value"><%= nv.getId() %></div>
                </div>
                
                <div class="info-row">
                    <div class="info-label">Họ Tên:</div>
                    <div class="info-value"><%= nv.getHoTen() %></div>
                </div>
                
                <div class="info-row">
                    <div class="info-label">Vị Trí:</div>
                    <div class="info-value"><%= nv.getViTri() != null ? nv.getViTri() : "Chưa phân công" %></div>
                </div>
            </div>
            
            <div>
                <form method="post" action="${pageContext.request.contextPath}/gettt-submit">
                    <button type="submit" class="submit-btn">Xem Thông Tin Phim</button>
                </form>
            </div>
            
            <div>
                <a href="${pageContext.request.contextPath}/Themphimmoi.jsp">
                    <button type="submit" class="submit-btn">Thêm Phim Mới</button>
                </a>
            </div>
        </div>

        <% 
            String successMessage = (String) session.getAttribute("successMessage");
            if (successMessage != null) {
        %>
            <script>
                alert("<%= successMessage %>");
            </script>
        <%
                session.removeAttribute("successMessage");
            }
        %>

        <% 
            String errorMessage = (String) session.getAttribute("errorMessage");
            if (errorMessage != null) {
        %>
            <script>
                alert("<%= errorMessage %>");
            </script>
        <%
                session.removeAttribute("errorMessage");
            }
        %>
    </body>
</html>

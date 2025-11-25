<%-- 
    Document   : TrangChuQuanLy
    Created on : Nov 13, 2025, 11:36:38 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang Chủ Quản Lý</title>
        <style>
            body {
                display: flex;
                justify-content: center;
                align-content: center;
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
            <h1>Trang Chủ Quản Lý</h1>
            
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

            <%
                String viTri = nv.getViTri();
                if (viTri != null && viTri.contains("Nhân Viên Quầy Vé")) {
            %>
                <div>
                    <a href="${pageContext.request.contextPath}/Banvetaiquay.jsp">
                        <button type="submit" class="submit-btn">Bán Vé Tại Quầy</button>
                    </a>
                </div>
            <%
                } else {
            %>
                <div>
                    <a href="${pageContext.request.contextPath}/Quanlyphim.jsp">
                        <button type="submit" class="submit-btn">Quản Lý Phim</button>
                    </a>
                </div>
                
                <div>
                    <a href="${pageContext.request.contextPath}/Quanlylichchieu.jsp">
                        <button type="submit" class="submit-btn">Quản Lý Lịch Chiếu</button>
                    </a>
                </div>
            <%
                }
            %>
        </div> 
    </body>
</html>
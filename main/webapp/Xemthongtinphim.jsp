<%-- 
    Document   : Xemthongtinphim
    Created on : Nov 19, 2025, 3:44:22 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.Model.Phim"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh Sách Phim</title>
        <style>
            body {
                background-color: #f5f5f5;
            }
            .container {
                max-width: 1200px;
                margin: 0 auto;   
                padding: 30px;
            }
            h1 {
                color: #333;
                padding-bottom: 10px;
                margin-bottom: 30px;
            }
            table {
                width: 100%;
                border-collapse: collapse;
                margin-bottom: 20px;
            }
            th {
                color: black;
                padding: 12px;
                text-align: left;
                font-weight: bold;
            }
            td {
                padding: 12px;
                border-bottom: 1px solid #ddd;
            }
            .action-btn {
                padding: 6px 12px;
                margin-bottom: 3px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                font-size: 14px;
            }
            .back-btn {
                color: black;
                padding: 10px 20px;
                border: none;
                cursor: pointer;
                font-size: 16px;
                text-decoration: none;
                display: inline-block;
                margin-top: 20px;
            }
            .empty-message {
                text-align: center;
                padding: 40px;
                font-size: 18px;
            }
            .search-box {
                margin-bottom: 20px;
                display: flex;
                gap: 10px;
            }
            #searchInput {
                flex: 1;
                padding: 12px 20px;
                font-size: 16px;
                border: 2px solid #ddd;
                border-radius: 4px;
                box-sizing: border-box;
                transition: border-color 0.3s;
            }
            .search-btn {
                padding: 12px 30px;
                color: black;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                font-size: 16px;
                transition: background-color 0.3s;
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
        %>

        <div class="container">
            <h1>Danh Sách Phim</h1>
            
            <form method="post" action="${pageContext.request.contextPath}/search-movie" class="search-box">
                <input type="text" name="keyword" id="searchInput" placeholder="Tìm kiếm phim theo tên, thể loại..." value="<%= request.getParameter("keyword") != null ? request.getParameter("keyword") : "" %>">
                <button type="submit" class="search-btn">Tìm kiếm</button>
            </form>
            
            <% if (danhSachPhim != null && !danhSachPhim.isEmpty()) { %>
                <table>
                    <thead>
                        <tr>
                            <th>Mã Phim</th>
                            <th>Tên Phim</th>
                            <th>Thể Loại</th>
                            <th>Thời Lượng (phút)</th>
                            <th>Mô Tả</th>
                            <th>Thao Tác</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Phim phim : danhSachPhim) { %>
                            <tr>
                                <td><%= phim.getMaPhim() %></td>
                                <td><%= phim.getTenPhim() %></td>
                                <td><%= phim.getTheLoai() %></td>
                                <td><%= phim.getThoiLuong() %></td>
                                <td><%= phim.getMoTa() != null ? phim.getMoTa() : "" %></td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/Suaphim.jsp?maPhim=<%= phim.getMaPhim() %>">
                                        <button type="button" class="action-btn edit-btn">Sửa</button>
                                    </a>
                                    <form method="post" action="${pageContext.request.contextPath}/delete-movie" onsubmit="return confirm('Bạn có chắc chắn muốn xóa phim <%= phim.getTenPhim() %>?');">
                                        <input type="hidden" name="maPhim" value="<%= phim.getMaPhim() %>">
                                        <button type="submit" class="action-btn delete-btn">Xóa</button>
                                    </form>
                                </td>
                            </tr>
                        <% } %>
                    </tbody>
                </table>
            <% } else { %>
                <div class="empty-message">
                    <p>Chưa có phim nào trong hệ thống.</p>
                </div>
            <% } %>
            
            <a href="${pageContext.request.contextPath}/Quanlyphim.jsp" class="back-btn">Quay Lại</a>
            
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
        </div>
    </body>
</html>

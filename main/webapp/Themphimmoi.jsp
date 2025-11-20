<%-- 
    Document   : Themphimmoi
    Created on : Nov 19, 2025, 3:44:32 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Them Phim Moi</title>
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
        %>

        <div class="container">
            <h1>Thêm Phim Mới</h1>
            <form class="submit-form" method="post" action="${pageContext.request.contextPath}/addmovie-submit">
                <div class="form-group">
                    <label for="tenPhim">Tên Phim</label>
                    <input
                        type="text"
                        id="tenPhim"
                        name="tenPhim"
                        placeholder="Vui lòng nhập tên phim"
                        required
                    />
                </div>
                <div class="form-group">
                    <label for="theLoai">Thể Loại</label>
                    <input
                        type="text"
                        id="theLoai"
                        name="theLoai"
                        placeholder="Vui lòng nhập thể loại"
                        required
                    />
                </div>
                <div class="form-group">
                    <label for="thoiLuong">Thời Lượng (phút)</label>
                    <input
                        type="number"
                        id="thoiLuong"
                        name="thoiLuong"
                        placeholder="Vui lòng nhập thời lượng"
                        required
                    />
                </div>
                <div class="form-group">
                    <label for="moTa">Mô Tả</label>
                    <textarea
                        id="moTa"
                        name="moTa"
                        placeholder="Vui lòng nhập mô tả"
                        required
                    ></textarea>
                </div>
                <button type="submit" class="submit-btn">Thêm Phim</button>
            </form>
        </div>

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

<%-- 
    Document   : Dangnhap
    Created on : Nov 13, 2025, 11:42:39 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dang Nhap</title>
        <style>
            body {
                display: flex;
                justify-content: center;
                align-items: center;
                margin: 0;
            }
            .login-container {
                width: 400px;
            }
            h1 {
                text-align: center;
                margin-bottom: 30px;
            }
            .form-group {
                margin-bottom: 20px;
            }
            label {
                display: block;
                margin-bottom: 5px;
            }
            input {
                width: 100%;
                padding: 10px;
                box-sizing: border-box;
            }
            .submit-btn {
                width: 100%;
                padding: 10px;
                font-size: 16px;
            }
            .register-link {
                display: block;
                text-align: center;
                padding: 20px;
                text-decoration: none;
                color: black;
                font-size: 16px;
            }
            
        </style>
    </head>
    <body>
        <div class="login-container">
            <h1>Đăng Nhập</h1>
            <form class="login-form" method="post" action="${pageContext.request.contextPath}/login-submit">
                <div class="form-group">
                    <label for="tendangnhap">Tên Đăng Nhập</label>
                    <div class="tendangnhap">
                        <input
                            type="text"
                            id="tendangnhap"
                            name="tendangnhap"
                            placeholder="Vui Lòng nhập tên đăng nhập"
                            required
                        />
                    </div>
                </div>
                <div class="form-group">
                    <label for="matkhau">Mật Khẩu</label>
                    <div class="matkhau">
                        <input
                            type="password"
                            id="matkhau"
                            name="matkhau"
                            placeholder="Vui Lòng nhập mật khẩu"
                            required
                        />
                    </div>
                </div>

         
                <button type="submit" class="submit-btn">Đăng Nhập</button>

            </form>
            <a href="${pageContext.request.contextPath}/Dangki.jsp" class="register-link">Đăng Ký</a>
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
    </body>
</html>
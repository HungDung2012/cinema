<%-- 
    Document   : Dangki
    Created on : Nov 16, 2025, 9:27:19 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dang Ki</title>
        <style>
            body {
                display: flex;
                justify-content: center;
                align-items: center;
                margin: 0;
            }
            .register-container {
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
            input, select {
                width: 100%;
                padding: 10px;
                box-sizing: border-box;
            }
            .submit-btn {
                width: 100%;
                padding: 10px;
                font-size: 16px;
            }
        </style>
    </head>
    <body>
        <div class="register-container">
            <h1>Đăng Kí</h1>
            <form class="register-form" method="post" action="${pageContext.request.contextPath}/register-submit">
                <div class="form-group">
                    <label for="tendangnhap">Tên Đăng Nhập</label>
                    <div class="tendangnhap">
                        <input
                            type="text"
                            id="tendangnhap"
                            name="tendangnhap"
                            placeholder="Vui lòng nhập tên đăng nhập"
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
                            placeholder="Vui lòng nhập mật khẩu"
                            required
                        />
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="hoten">Họ và Tên</label>
                    <div class="hoten">
                        <input
                            type="text"
                            id="hoten"
                            name="hoten"
                            placeholder="Vui lòng nhập họ và tên"
                            required
                        />
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="ngaysinh">Ngày Sinh</label>
                    <div class="ngaysinh">
                        <input
                            type="date"
                            id="ngaysinh"
                            name="ngaysinh"
                            required
                        />
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="diachi">Địa Chỉ</label>
                    <div class="diachi">
                        <input
                            type="text"
                            id="diachi"
                            name="diachi"
                            placeholder="Vui lòng nhập địa chỉ"
                            required
                        />
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="email">Email</label>
                    <div class="email">
                        <input
                            type="email"
                            id="email"
                            name="email"
                            placeholder="Vui lòng nhập email"
                            required
                        />
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="sdt">Số Điện Thoại</label>
                    <div class="sdt">
                        <input
                            type="number"
                            id="sdt"
                            name="sdt"
                            placeholder="Vui lòng nhập số điện thoại"
                            required
                        />
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="vitri">Vị Trí</label>
                    <div class="vitri">
                        <select id="vitri" name="vitri" required>
                            <option value="">-- Chọn loại nhân viên --</option>
                            <option value="QuanLy">Nhân Viên Quản Lý</option>
                            <option value="QuayVe">Nhân Viên Quầy Vé</option>
                        </select>
                    </div>
                </div>
                
                <button type="submit" class="submit-btn">Đăng Ký</button>
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

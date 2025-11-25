<%-- 
    Document   : Laplichchieuphim
    Created on : Nov 19, 2025, 3:54:18 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lap Lich Chieu Phim</title>
    </head>
    <body>
        <%
            if (session.getAttribute("nhanVien") == null) {
                response.sendRedirect(request.getContextPath() + "/Dangnhap.jsp");
                return;
            }

            com.mycompany.Model.Lichchieuphim lc = 
                (com.mycompany.Model.Lichchieuphim) session.getAttribute("lichchieu");
        %>
        <div>
            <h1>Lập Lịch Chiếu Phim</h1>
            <form class="submit-form" method="post" action="${pageContext.request.contextPath}/addschedule-submit">
                <div class="form-group">
                    <label for="tenPhim">Tên Phim</label>
                    <input
                        type="text"
                        id="tenPhim"
                        name="tenPhim"
                        placeholder="Vui lòng nhập tên phim"
                        required
                    >
                    
                </div>
            </form>
        </div>
    </body>
</html>

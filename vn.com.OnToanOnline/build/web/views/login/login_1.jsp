<%-- 
    Document   : login
    Created on : Dec 7, 2017, 2:52:37 PM
    Author     : TienNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng nhập</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="<c:url value='/node_modules/bootstrap/dist/css/bootstrap.css'/>">
        <script src="<c:url value='/node_modules/jquery/dist/jquery.js'/>"></script>
        <script src="<c:url value='/node_modules/bootstrap/dist/js/bootstrap.js'/>"></script>
        <link rel="stylesheet" type="text/css" href="<c:url value='/fa-icon/web-fonts-with-css/css/fontawesome-all.css'/>">
        <script type="text/javascript" src="<c:url value='/fa-icon/svg-with-js/js/fontawesome-all.js'/>"></script>
        
        <link rel="stylesheet" type="text/css" href=" <c:url value = '/css/header.css'/>">
        <link rel="stylesheet" type="text/css" href=" <c:url value = '/css/login_1.css'/>">
        <script src="<c:url value = '/js/1.js'/>" type="text/javascript"></script>
    </head>
    <body>
        <jsp:include page="/views/header.jsp"></jsp:include>
            <section style="padding: 80px;">
                <div class="container">
                    <div class="row">
                        <div class="col-md-7 col-lg-7 col-sm-12 col-xs-12">
                            <form method="Post" action="<%=request.getContextPath()%>/login">
                                <h1>Đăng nhập</h1>
                                <p style="color: red">${errorRegistry}</p>
                                <p style="color: red">${errorString}</p>
                            <table border = "0">
                                <tr>
                                    <td>Tài Khoản : </td>
                                    <td><input type="text" name="username"></td>
                                </tr>
                                <tr>
                                    <td>Mật Khẩu</td>
                                    <td><input type="password" name="password"></td>
                                </tr>
                                <tr>
                                    <td>

                                    </td>
                                    <td colspan = "2">
                                        <input type="submit" value="Đăng Nhập" class="btn btn-primary">
                                        <a href="<%=request.getContextPath()%>/home" class="btn btn-danger">Hủy</a>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                    <div class="col-md-5 col-lg-5 col-sm-12 col-xs-12">
                        <div class="dky">
                            
                            <h2>Chưa có tài khoản ư ?</h2>
                            <h3>Đăng kí ngay với 1 bước duy nhất</h3>
                            <a href="<%=request.getContextPath()%>/${registryHref}" class="btn btn-primary">Đăng ký</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <%--<jsp:include page="/views/footer.jsp"></jsp:include>--%>
    </body>
</html>

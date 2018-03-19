<%-- 
    Document   : registry
    Created on : Feb 28, 2018, 2:07:31 PM
    Author     : TienNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng Ký</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="<c:url value='/node_modules/bootstrap/dist/css/bootstrap.css'/>">
        <script src="<c:url value='/node_modules/jquery/dist/jquery.js'/>"></script>
        <script src="<c:url value='/node_modules/bootstrap/dist/js/bootstrap.js'/>"></script>
        <link rel="stylesheet" type="text/css" href="<c:url value='/fa-icon/web-fonts-with-css/css/fontawesome-all.css'/>">
        <script type="text/javascript" src="<c:url value='/fa-icon/svg-with-js/js/fontawesome-all.js'/>"></script>

        <link rel="stylesheet" type="text/css" href=" <c:url value = '/css/header.css'/>">
        <link rel="stylesheet" type="text/css" href=" <c:url value = '/css/registry.css'/>">

    </head>
    <body>
        <jsp:include page="/views/header.jsp"></jsp:include>
            <section id="section_login">
                <div class="container">
                    <div class="container-fluid">
                        <div class="col-md-6 col-lg-6 col-sm-12 col-xs-12">
                            <p style="color: red">${errorString}</p>
                            <p style="color: red">${errorRegistry}</p>
                        <!-- đăng ký -->
                        </form>
                        <form action="<%=request.getContextPath()%>/Registry" method="POST" role="form" class="form_DangKy">
                            <div class="form_div_dangKy" id="form_dangKy">
                                <legend>Đăng Ký Thành Viên</legend>
                                <div class="form-group">
                                    <label for="">Họ Tên</label>
                                    <input type="text" class="form-control" name="fullName" placeholder="Nhập họ tên..." required>
                                </div>
                                <div class="form-group">
                                    <label for="">Ngày Sinh</label>
                                    <input type="date" class="form-control" name="birthday" required>
                                </div>
                                <div class="gioiTinh">
                                    <label>Giới Tính</label>
                                    <input type="radio" name="sex" value="Nam"><span>Nam</span> 
                                    <input type="radio" name="sex" value="Nữ"><span>Nữ</span>
                                </div>
                                <div class="form-group">
                                    <label for="">Trường học</label>
                                    <input type="text" class="form-control" name="school" placeholder="Nhập trường học..." required>
                                </div>
                                <div class="form-group">
                                    <label for="">Địa Chỉ</label>
                                    <input type="text" class="form-control" name="address" placeholder="Nhập địa chỉ..." required>
                                </div>
                                <div class="form-group">
                                    <label for="">Tài Khoản</label>
                                    <input type="text" class="form-control" name="username" placeholder="Nhập tài khoản..." required>
                                </div>
                                <div class="form-group">
                                    <label for="">Mật Khẩu</label>
                                    <input type="password" class="form-control" name="password" placeholder="Nhập mật khẩu..." required>
                                </div>
                                <div class="form-group">
                                    <label for="">Số điện thoại</label>
                                    <input type="text" class="form-control" name="phone" placeholder="Nhập số điện thoại..." required>
                                </div>
                                <div class="form-group">
                                    <label for="">Email</label>
                                    <input type="email" class="form-control" name="email" placeholder="Nhập email..." required>
                                </div>
                                <button type="submit" class="btn btn-primary">Đăng Ký</button>
                                <a href="<%=request.getContextPath()%>/login" class="btn btn-danger">Hủy</a>
                            </div>
                        </form>
                    </div>
                    <div class="col-md-6 col-lg-6 col-sm-12 col-xs-12">
                    </div>
                </div>
            </div>
        </section>
        <script src="<c:url value = '/js/1.js'/>" type="text/javascript"></script>
    </body>
</html>

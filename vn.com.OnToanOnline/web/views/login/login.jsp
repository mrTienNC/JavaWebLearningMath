<%-- 
    Document   : login
    Created on : Feb 25, 2018, 11:30:36 PM
    Author     : TienNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hệ Thống</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="<c:url value='/node_modules/bootstrap/dist/css/bootstrap.css'/>">
        <script src="<c:url value='/node_modules/jquery/dist/jquery.js'/>"></script>
        <script src="<c:url value='/node_modules/bootstrap/dist/js/bootstrap.js'/>"></script>
        <link rel="stylesheet" type="text/css" href="<c:url value='/fa-icon/web-fonts-with-css/css/fontawesome-all.css'/>">
        <script type="text/javascript" src="<c:url value='/fa-icon/svg-with-js/js/fontawesome-all.js'/>"></script>

        <link href="https://fonts.googleapis.com/css?family=Alegreya|Josefin+Sans|Open+Sans" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href=" <c:url value = './css/header.css'/>">
        <link rel="stylesheet" type="text/css" href=" <c:url value = './css/login.css'/>">
        <link rel="stylesheet" type="text/css" href=" <c:url value = './css/footer.css'/>">
        <script src="<c:url value='/js/1.js'/>" type="text/javascript"></script>
    </head>
    <body>
        <jsp:include page="/views/header.jsp"></jsp:include>
            <section id="section_login">
                <div class="container">
                    <div class="container-fluid">
                        <div class="col-md-6 col-lg-6 col-sm-12 col-xs-12">
                            <p style="color: red">${errorString}</p>
                            <form action="login" method="POST" role="form" class="form_DangNhap">
                                <legend>
                                    <h4 onclick="ClickDangNhap()" id="h4_DN">Đăng Nhập</h4>
                                    <h4 onclick="ClickDangKy()" id="h4_DK">Đăng Ký</h4>
                                </legend>
                                <!-- đăng nhập -->
                                <div class="form_div_dangNhap" id="form_dangNhap">
                                    <div class="form-group">
                                        <label for="">Tài Khoản
                                            <span>
                                                <input type="text" name="username" class="form-control" id="" placeholder="Username" required>
                                            </span>
                                        </label>
                                    </div>
                                    <div class="form-group">
                                        <label for="">Mật Khẩu
                                            <span>
                                                <input type="text" name="password" class="form-control" id="" placeholder="Password" required>
                                            </span>
                                        </label>
                                    </div>
                                    <button type="submit" class="btn btn-primary">Đăng Nhập</button>
                                    <a href="home" class="btn btn-warning">Cancel</a>
                                </div>
                                <!-- đăng ký -->
                            </form>
                            <form action="Registry" method="POST" role="form" class="form_DangKy">
                                <div class="form_div_dangKy" id="form_dangKy">
                                    <div class="form-group">
                                        <label for="">Họ Tên</label>
                                        <input type="text" class="form-control" id="dangKy_name" placeholder="Nhập họ tên..." required>
                                    </div>
                                    <div class="form-group">
                                        <label for="">Ngày Sinh</label>
                                        <input type="date" class="form-control" id="dangKy_date" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="">Trường học</label>
                                        <input type="text" class="form-control" id="dangKy_school" placeholder="Nhập trường học..." required>
                                    </div>
                                    <div class="form-group">
                                        <label for="">Địa Chỉ</label>
                                        <input type="text" class="form-control" id="dangKy_adress" placeholder="Nhập địa chỉ..." required>
                                    </div>
                                    <div class="form-group">
                                        <label for="">Tài Khoản</label>
                                        <input type="text" class="form-control" id="dangKy_username" placeholder="Nhập tài khoản..." required>
                                    </div>
                                    <div class="form-group">
                                        <label for="">Mật Khẩu</label>
                                        <input type="text" class="form-control" id="dangKy_password" placeholder="Nhập mật khẩu..." required>
                                    </div>
                                    <div class="form-group">
                                        <label for="">Số điện thoại / Email</label>
                                        <input type="text" class="form-control" id="dangKy_contact" placeholder="Nhập số điện thoại hoặc email..." required>
                                    </div>
                                    <button type="submit" class="btn btn-primary">Đăng Ký</button>
                                    <a href="#" class="btn btn-danger">Hủy</a>
                                </div>
                            </form>
                        </div>
                        <div class="col-md-6 col-lg-6 col-sm-12 col-xs-12">
                        </div>
                    </div>
                </div>
            </section>
        <jsp:include page="/views/footer.jsp"></jsp:include>
        <script type="text/javascript">
            var dangNhap = document.getElementById("form_dangNhap");
            var dangKy = document.getElementById("form_dangKy");
            var dangNhapH4 = document.getElementById("h4_DN");
            var dangKyH4 = document.getElementById("h4_DK");
            function ClickDangNhap() {
                dangNhapH4.style.backgroundColor = '#25CCF7';
                dangNhap.style.display = 'block';

                dangKy.style.display = 'none';
                dangKyH4.style.backgroundColor = '#FC427B';

            }
            function ClickDangKy() {
                dangKyH4.style.backgroundColor = "#25CCF7";
                dangNhapH4.style.backgroundColor = "#FC427B";
                dangKy.style.display = 'block';
                dangNhap.style.display = 'none';

            }

        </script>
    </body>
</html>

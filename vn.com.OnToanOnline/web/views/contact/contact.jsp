<%-- 
    Document   : contact
    Created on : Feb 28, 2018, 3:55:23 PM
    Author     : TienNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liên Hệ</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="<c:url value='/node_modules/bootstrap/dist/css/bootstrap.css'/>">
        <script src="<c:url value='/node_modules/jquery/dist/jquery.js'/>"></script>
        <script src="<c:url value='/node_modules/bootstrap/dist/js/bootstrap.js'/>"></script>
        <link rel="stylesheet" type="text/css" href="<c:url value='/fa-icon/web-fonts-with-css/css/fontawesome-all.css'/>">
        <script type="text/javascript" src="<c:url value='/fa-icon/svg-with-js/js/fontawesome-all.js'/>"></script>

        <link rel="stylesheet" type="text/css" href=" <c:url value = '/css/contact.css'/>">
        <link rel="stylesheet" type="text/css" href=" <c:url value = '/css/login_1.css'/>">
    </head>
    <body>
        <jsp:include page="/views/header.jsp"></jsp:include>
        
        <section id="section_contact">
            <div class="container">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-5 col-lg-5 col-sm-12 col-xs-12">
                            <div class="contact_info">
                                <div class="contact_image">
                                    <img src="images/ava.jpg" class="img-responsive">
                                </div>
                                <div class="contact_true_info">
                                    <p class="job">
                                        <span><i class="fas fa-code"></i>Coder</span>
                                        <span><i class="fas fa-laptop"></i>Developer</span>
                                    </p>
                                    <h3>Nguyễn Chí Tiến</h3>
                                    <h4>
                                        <span><i class="far fa-envelope"></i></span> Contact Me :
                                        <span><a href="#"><i class="fab fa-facebook-square"></i></a>
                                        </span>
                                        <span><a href="#"><i class="fab fa-google-plus"></i></a>
                                        </span>
                                    </h4>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-7 col-lg-7 col-sm-12 col-xs-12">
                            <div class="form_contact">
                                <form action="<%=request.getContextPath()%>/Contact" method="POST" role="form">
                                    <p style="color: red">${errorString}</p>
                                    <legend>Liên hệ</legend>
                                    <div class="form-group">
                                        <label for="">Họ Tên</label>
                                        <input type="text" name="fullName" class="form-control" id="" placeholder="Input field" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="">Số điện thoại</label>
                                        <input type="text" name="phone" class="form-control" id="" placeholder="Input field" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="">Email</label>
                                        <input type="email" name="email" class="form-control" id="" placeholder="Input field" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="">Nội dung</label>
                                        <input type="text" name="content" class="form-control" id="" placeholder="Input field" required>
                                    </div>
                                    <button type="submit" class="btn btn-primary"><span><i class="fas fa-location-arrow"></i></span>Gửi</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <script src="<c:url value = '/js/1.js'/>" type="text/javascript"></script>
    </body>
</html>

<%-- 
    Document   : header
    Created on : Feb 25, 2018, 9:19:59 PM
    Author     : TienNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="<c:url value='/node_modules/bootstrap/dist/css/bootstrap.css'/>">
        <script src="<c:url value='/node_modules/jquery/dist/jquery.js'/>"></script>
        <script src="<c:url value='/node_modules/bootstrap/dist/js/bootstrap.js'/>"></script>
        <link rel="stylesheet" type="text/css" href="<c:url value='/fa-icon/web-fonts-with-css/css/fontawesome-all.css'/>">
        <script type="text/javascript" src="<c:url value='/fa-icon/svg-with-js/js/fontawesome-all.js'/>"></script>

        <link href="https://fonts.googleapis.com/css?family=Alegreya|Josefin+Sans|Open+Sans" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/header.css' />">
        <script type="text/javascript" src="<c:url value='/js/1.js'/>"></script>
    </head>
    <body>
        <section id="section_menu" style="top: 0">
            <div id="div_menu">
                <nav class="navbar navbar-default" role="navigation">
                    <div class="container-fluid">
                        <!-- Brand and toggle get grouped for better mobile display -->
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand logo" href="home">
                                <img src="images/logo.png" class="img-responsive img-circle">
                            </a>
                            <a href="home" class="header_TN">Trắc nghiệm Toán Học</a>
                        </div>

                        <!-- Collect the nav links, forms, and other content for toggling -->
                        <div class="collapse navbar-collapse navbar-ex1-collapse">
                            <ul class="nav navbar-nav navbar-right">
                                <li><a href="rank">
                                        <span class="rank_Item"><img src="images/rank.png" class="img-rounded img-circle"></span>Bảng Xếp Hạng
                                    </a></li>
                                <li class="dropdown vaoThi">
                                    <a href="#" class="dropdown-toggle item_vaoThi" data-toggle="dropdown">
                                        <span class="thi_Item"><img src="images/star_1.png"></span>
                                        Luyện Tập<b class="caret"></b></a>
                                    <ul class="dropdown-menu drop_VaoThi">
                                        <li><a href="lop1"><img src="images/1.png">Toán Lớp 1</a></li>
                                        <li><a href="lop2"><img src="images/2.png">Toán Lớp 2</a></li>
                                        <li><a href="lop3"><img src="images/3.png">Toán Lớp 3</a></li>
                                        <li><a href="lop4"><img src="images/4.png">Toán Lớp 4</a></li>
                                        <li><a href="lop5"><img src="images/5.png">Toán Lớp 5</a></li>
                                        <li><a href="lop6"><img src="images/6.png">Tổng Hợp</a></li>
                                    </ul>
                                </li>
                                <li class="dropdown li_tacVu">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                        <span class="tacVu_Item"><img src="images/home2.png"></span>
                                        ${tacVu}<b class="caret"></b></a>
                                    <ul class="dropdown-menu tacvu">
                                        <li><a href="${loginHref}" class="dangNhap"><img src="images/person.png">${login}</a></li>
                                        <li><a href="${contactHref}" class="gopY"><img src="images/contact.png">${contact}</a></li>
                                        <li><a href="${presentHref}" class="gioiThieu"><img src="images/present.png">${present}</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div><!-- /.navbar-collapse -->
                    </div>
                </nav>
            </div>
        </section>
    </body>
</html>

<%-- 
    Document   : admin
    Created on : Mar 7, 2018, 11:49:14 PM
    Author     : TienNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="<c:url value='/node_modules/bootstrap/dist/css/bootstrap.css'/>">
        <script src="<c:url value='/node_modules/jquery/dist/jquery.js'/>"></script>
        <script src="<c:url value='/node_modules/bootstrap/dist/js/bootstrap.js'/>"></script>
        <link rel="stylesheet" type="text/css" href="<c:url value='/fa-icon/web-fonts-with-css/css/fontawesome-all.css'/>">
        <script type="text/javascript" src="<c:url value='/fa-icon/svg-with-js/js/fontawesome-all.js'/>"></script>
        <link rel="stylesheet" type="text/css" href="<c:url value='/node_modules/wow/css/animate.css'/>">

        <link href="https://fonts.googleapis.com/css?family=Alegreya|Josefin+Sans|Open+Sans|Roboto" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/admin.css'/>">
    </head>
    <body>
        <section id="section_main">
            <div class="row">
                <div class="col-md-2 col-lg-2 col-sm-12 col-12">
                    <div class="dashboard_admin wow bounceInLeft">
                        <div class="admin_ava">
                            <img src="images/ava.jpg" class="img img-responsive img-rounded img-circle img-thumbnail">
                            <p>Username</p>
                        </div>
                        <div class="admin_menu">
                            <ul>
                                <li class="active">
                                    <a href="#listed_number" id="dashboard"><span><i class="fas fa-chart-area"></i></span>Dashboard</a>
                                </li>
                                <li>
                                    <a href="#profile" id="profile"><span><i class="fas fa-user-circle"></i></span>Profile</a>
                                </li>
                                <li>
                                    <a href="#tableList" id="tableList"><span><i class="far fa-list-alt"></i></span>Table List</a>
                                </li>
                                <li>
                                    <a href="#feedback" id="feedback"><span><i class="fas fa-comment-alt"></i></span>Feedback</a>
                                </li>
                                <li>
                                    <a href="#activities" id="activities"><span><i class=></i></span>Activities</a>
                                </li>
                                <li>
                                    <a href="#notification" id="notification"><span><i class="far fa-bell"></i></span>Notification</a>
                                </li>
                            </ul>
                        </div>
                        <div class="admin_footer">
                            <footer>
                                <p>Design by <span><a href="https://www.facebook.com/tienptit" target="_blank">Tien NC</a></span></p>
                            </footer>
                        </div>
                    </div>
                </div>
                <div class="col-md-10 col-lg-10 col-sm-12 col-xs-12">
                    <div class="dashboard_navbar wow bounceInDown">
                        <div class="dashboard_navbar_left">
                            <p><span><i class="fab fa-audible"></i></span>Dashboard Admin</p>
                        </div>
                        <div class="dashboard_navbar_right">
                            <ul>
                                <li><a href="#"><i class="far fa-envelope"></i></a></li>
                                <li><a href="#"><i class="far fa-bell"></i></a></li>
                                <li class="dropdown">
                                    <a href="#" class="dropbtn"><i class="fas fa-user-circle"></i></a>
                                    <div class="dropdown_content">
                                        <a href="#">Password</a>
                                        <a href="<%=request.getContextPath()%>/LogOut">Log Out</a>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <!--Dashboard-->  
                    <section id="listed_number" class="wow bounceInUp">
                        <div class="container">
                            <div class="container-fluid">
                                <div class="row" id="rowList">
                                    <div class="col-md-3 col-lg-3 col-sm-12 col-xs-12">
                                        <div class="listed1">
                                            <div class="listed_info">
                                                <h3 class="name"><span><i class="far fa-user"></i></span>	<span>Members</span></h3>
                                                <h3 class="number">1000</h3>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-3 col-lg-3 col-sm-12 col-xs-12">
                                        <div class="listed2">
                                            <div class="listed_info">
                                                <h3 class="name"><span><i class="far fa-user"></i></span>	<span>Members</span></h3>
                                                <h3 class="number">1000</h3>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-3 col-lg-3 col-sm-12 col-xs-12">
                                        <div class="listed3">
                                            <div class="listed_info">
                                                <h3 class="name"><span><i class="far fa-user"></i></span>	<span>Members</span></h3>
                                                <h3 class="number">1000</h3>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-3 col-lg-3 col-sm-12 col-xs-12">
                                        <div class="listed4">
                                            <div class="listed_info">
                                                <h3 class="name"><span><i class="far fa-user"></i></span>	<span>Members</span></h3>
                                                <h3 class="number">1000</h3>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
<!--                    End Dashboard- 
                    Profile Layout -->
                    <section id="profile" class="margin hidden wow bounceInUp">
                        <div class="container">
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-md-3 col-lg-3 col-sm-12 col-xs-12">
                                        <div class="profile_ava">
                                            <div class="img img-responsive img-thumbnail personal_img">
                                                <img src="images/ava.jpg">
                                            </div>
                                            <input type="file" name="file">
                                        </div>
                                        <p>ID : <span>01</span></p>
                                    </div>
                                    <div class="col-md-8 col-lg-8 col-sm-12 col-xs-12">
                                        <div class="profile_info">
                                            <form action="#" method="POST">
                                                <legend>Profile</legend>
                                                <table border="0">
                                                    <tr>
                                                        <td>Full Name : </td>
                                                        <td>
                                                            <input type="text" name="fullname">
                                                        </td>
                                                        <td>Birthday : </td>
                                                        <td>
                                                            <input type="date" name="birthday">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Sex : </td>
                                                        <td colspan="2">
                                                            <input type="radio" name="sex" value="Name" checked><span>Male</span>
                                                            <input type="radio" name="sex" value="Nữ"><span>Female</span>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Phone : </td>
                                                        <td>
                                                            <input type="text" name="phone">
                                                        </td>
                                                        <td>Email :</td>
                                                        <td>
                                                            <input type="email" name="email">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>ID Card:</td>
                                                        <td>
                                                            <input type="text" name="idcard">
                                                        </td>
                                                        <td>Adress :</td>
                                                        <td>
                                                            <input type="text" name="address">
                                                        </td>
                                                    </tr>
                                                </table>
                                                <button type="submit" class="btn btn-primary">Update</button>
                                                <button type="reset" class="btn btn-info">Reset</button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
<!--                    End Profile Layout 
                    Table List -->
                    <section id="tableList" class="margin hidden">
                        <div class="container">
                            <div class="container-fluid">
                                <div class="row">
                                    <h1>Đang trong giai đoạn bảo trì</h1>
                                </div>
                            </div>
                        </div>
                    </section>
<!--                    End table List 
                    Feedback Layout -->
                    <section id="feedback" class="margin hidden wow bounceInUp">
                        <div class="container">
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="feedback_info">
                                        <form action="#" method="POST">
                                            <legend>Feedback</legend>
                                            <table border="1">
                                                <tr>
                                                    <th>STT</th>
                                                    <th>Full Name</th>
                                                    <th>Email</th>
                                                    <th>Phone</th>
                                                    <th>Date</th>
                                                    <th>Content</th>
                                                    <th>Delete</th>
                                                </tr>
                                                <tr>
                                                    <td>1</td>
                                                    <td>Nguyễn CHí Tiến</td>
                                                    <td>tienptit123@gmail.com</td>
                                                    <td>0123456789</td>
                                                    <td>05/03/2018</td>
                                                    <td>Tôi rất thích website này</td>
                                                    <td>
                                                        <input type="button" name="delete" value="Delete" class="btn btn-danger">
                                                    </td>
                                                </tr>
                                            </table>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                    <!--Activities Layout--> 
                    <section id="activities" class="margin hidden wow bounceInUp">
                        <div class="container">
                            <div class="container-fluid">
                                <div class="row">
                                    <h1>Đang trong giai đoạn bảo trì</h1>
                                </div>
                            </div>
                        </div>
                    </section>
                    <!--Notification Layout--> 
                    <section id="notification" class="margin hidden wow bounceInUp">
                        <div class="container">
                            <div class="container-fluid">
                                <div class="row">
                                    <h1>Đang trong giai đoạn bảo trì</h1>
                                </div>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
        </section>
        <%--<jsp:include page="/view/admin/admin"></jsp:include>--%>

<!--        <script type="text/javascript" src="<c:url value='/js/admin.js'/>"></script>-->
        <script type="text/javascript" src="<c:url value='/node_modules/wow/wow.js'/>"></script>
        <script type="text/javascript">
            $(document).ready(function () {


                $("ul li").click(function () {
                    $("ul li").removeClass("active");
                    $(this).addClass("active");
                });


                $("a#dashboard").click(function (e) {
                    $("section#listed_number").show();
                    $("section#profile").hide();
                    $("section#feedback").hide();
                    $("section#activities").hide();
                    $("section#notification").hide();
                    $("section#tableList").hide();

                    e.preventDefault();
                });
                $("a#profile").click(function (e) {
                    $("section#listed_number").hide();
                    $("section#profile").show();
                    $("section#feedback").hide();
                    $("section#activities").hide();
                    $("section#notification").hide();
                    $("section#tableList").hide();

//                    e.preventDefault();
                });
                $("a#tableList").click(function (e) {
                    $("section#listed_number").hide();
                    $("section#profile").hide();
                    $("section#feedback").hide();
                    $("section#activities").hide();
                    $("section#notification").hide();
                    $("section#tableList").show();

//                    e.preventDefault();
                });
                $("a#feedback").click(function (e) {
                    $("section#listed_number").hide();
                    $("section#profile").hide();
                    $("section#feedback").show();
                    $("section#activities").hide();
                    $("section#notification").hide();
                    $("section#tableList").hide();

//                    e.preventDefault();
                });
                $("a#activities").click(function (e) {
                    $("section#listed_number").hide();
                    $("section#profile").hide();
                    $("section#feedback").hide();
                    $("section#activities").show();
                    $("section#notification").hide();
                    $("section#tableList").hide();

//                    e.preventDefault();
                });
                $("a#notification").click(function (e) {
                    $("section#listed_number").hide();
                    $("section#profile").hide();
                    $("section#feedback").hide();
                    $("section#activities").hide();
                    $("section#notification").show();
                    $("section#tableList").hide();

//                    e.preventDefault();
                });
                new WOW().init();
            });
        </script>
    </body>
</html>

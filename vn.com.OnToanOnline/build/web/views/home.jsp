<%-- 
    Document   : home
    Created on : Feb 25, 2018, 12:26:47 AM
    Author     : TienNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Trang Chủ</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="<c:url value='/node_modules/bootstrap/dist/css/bootstrap.css'/>">
        <script src="<c:url value='/node_modules/jquery/dist/jquery.js'/>"></script>
        <script src="<c:url value='/node_modules/bootstrap/dist/js/bootstrap.js'/>"></script>
        <link rel="stylesheet" type="text/css" href="<c:url value='/fa-icon/web-fonts-with-css/css/fontawesome-all.css'/>">
        <script type="text/javascript" src="<c:url value='/fa-icon/svg-with-js/js/fontawesome-all.js'/>"></script>
        <link rel="stylesheet" type="text/css" href="<c:url value='/node_modules/wow/css/animate.css'/>">

        <link href="https://fonts.googleapis.com/css?family=Alegreya|Josefin+Sans|Open+Sans" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/1.css'/>">

    </head>
    <body>
        <!-- Menu bar -->
        <section id="section_menu">
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
                                        <li><a href="<%=request.getContextPath()%>/lop1"><img src="images/1.png">Toán Lớp 1</a></li>
                                        <li><a href="<%=request.getContextPath()%>/lop2"><img src="images/2.png">Toán Lớp 2</a></li>
                                        <li><a href="<%=request.getContextPath()%>/lop3"><img src="images/3.png">Toán Lớp 3</a></li>
                                        <li><a href="<%=request.getContextPath()%>/lop4"><img src="images/4.png">Toán Lớp 4</a></li>
                                        <li><a href="<%=request.getContextPath()%>/lop5"><img src="images/5.png">Toán Lớp 5</a></li>
                                        <li><a href="<%=request.getContextPath()%>/lop6"><img src="images/6.png">Tổng Hợp</a></li>
                                    </ul>
                                </li>
                                <li class="dropdown li_tacVu">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" id="btnTacVu">
                                        <span class="tacVu_Item"><img src="images/home2.png"></span>
                                        ${tacVu}<b class="caret"></b></a>
                                    <ul class="dropdown-menu tacvu">
                                        <li><a href="<%=request.getContextPath()%>/${loginHref}" id="btnLogin" class="dangNhap"><img src="images/person.png">${login}</a></li>
                                        <li><a href="<%=request.getContextPath()%>/${contactHref}" id="btnContact" class="gopY"><img src="images/contact.png">${contact}</a></li>
                                        <li><a href="<%=request.getContextPath()%>/${presentHref}" id="btnPresent" class="gioiThieu"><img src="images/present.png">${present}</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div><!-- /.navbar-collapse -->
                    </div>
                </nav>
            </div>
        </section>
        <!-- Header layout -->
        <section id="section_header">
            <div class="container ">
                <div class="container-fluid">
                    <div class="col-md-6 col-lg-6 col-sm-12 col-xs-12">
                        <div class="div_header wow bounceInLeft">
                            <div class="info_header">
                                <h4>
                                    ${info1}
                                    <h1>${info2}</h1>
                                </h4>

                            </div>
                            <div class="div_Btn">
                                <a href="<%=request.getContextPath()%>/${registryHref}" class="btn btn-primary btnDangKy" id="btnDangKy">${registry}</a>
                                <!--                                <a href="onTap" style="display: none" class="btn btn-info btnDangNhap" id="btnOnTap">Ôn Tập</a>-->
                            </div>
                        </div>
                    </div>
                </div>
                <div class="div_header_footer">
                    <i class="fas fa-arrow-circle-down"></i>
                </div>
            </div>
        </section>
        <section id="section_information">
            <div class="container">
                <div class="container-fluid">
                    <div class="col-md-6 col-lg-6 col-sm-12 col-xs-12">
                        <div class="true_info wow bounceInUp">
                            <h1>Bạn được gì ?</h1>
                            <hr>
                            <ul>
                                <li>Củng cố kiến thức với những bài toán chất lượng</li>
                                <li>Các câu hỏi ở dạng trắc nghiệm , dễ dàng cho các em</li>
                                <li>Thường xuyên cập nhật các câu hỏi, để không bị nhàm chán</li>
                                <li>Đánh giá chung lượng kiến thức sau mỗi lần làm bài ôn tập</li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-6 col-sm-12 col-xs-12">
                        <div class="image_info wow fadeInUp">

                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- Rank area -->
        <section id="section_rank">
            <div class="container">
                <div class="container-fluid">
                    <div class="col-md-8 col-lg-8 col-sm-12 col-xs-12">
                        <div class="div_rank wow slideInLeft">
                            <h2>Bảng xếp hạng Top 10</h2>
                            <hr style="margin-bottom: 1em;">
                            <!--                        <form action="#" method="POST" role="form">
                                                        <div class="form-group">
                                                            <label for="">Tìm kiếm : </label>
                                                            <input type="text" class="form-control" id="" placeholder="Nhập Họ Tên">
                                                            <button type="submit" class="btn btn-primary btn_Submit"><span><img src="images/search.png"></span>Search</button>
                                                        </div>
                                                    </form>-->
                            <div class="rank_info">
                                <table border="1">
                                    <tr>
                                        <th>Thứ Hạng</th>
                                        <th>Họ Tên</th>
                                        <th>Giới Tính</th>
                                        <th>Trường</th>
                                        <th>Điểm</th>
                                    </tr>
                                    <% int i = 0;%>
                                    <c:forEach items="${lst}" var="tv">
                                        <tr>
                                            <td><%= ++i%></td>
                                            <td>${tv.hoTen}</td>
                                            <td>${tv.gioiTinh}</td>
                                            <td>${tv.truongHoc}</td>
                                            <td>${tv.point}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 col-lg-4 col-sm-12 col-xs-12">
                        <div class="person_info wow slideInRight">
                            <div class="person_image">
                                <img src="${images}" class="img-responsive img-thumbnail">
                            </div>
                            <div class="person_detail">
                                <h2>Thong tin top 1</h2>
                                <hr>
                                <div class="person_true_detail">
                                    <h3>${nameTop1}</h3>
                                    <p>Ngay Sinh : <span>${birthday}</span></p>
                                    <p>Truong : <span>${school}</span></p>
                                    <p>Tinh cach : ${tinhCach}</p>
                                    <p>So thich : <span>${soThich}</span></p>
                                    <p>Diem : <span>${point}</span></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- Footer  -->
        <section id="section_footer">
            <footer>
                <div class="container">
                    <div class="container-fluid">
                        <div class="footer_info wow bounceInUp">
                            <p>CopyRight 2017 <a href="">Nguyễn Chí Tiến</a></p>
                        </div>
                    </div>
                </div>
            </footer>
        </section>
        
        <script type="text/javascript" src="<c:url value='/js/1.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/node_modules/wow/wow.js'/>"></script>
        <script type="text/javascript">
            new WOW().init();
            //Logined
//            var btnDky = document.getElementById("btnDangKy");
//            var btnOnTap = document.getElementById("btnOnTap");
//            var btnTacVu = document.getElementById("btnTacVu");
//            var content = $("a #btnTacVu").text();
//            
//            var strTacVu = "Tác Vụ";
//            var btnLogin = document.getElementById("btnLogin");
//            var btnContact = document.getElementById("btnContact");
//            var btnPresent = document.getElementById("btnPresent");
//
//
//            if (btnTacVu.textContent !== null) {
//                if (btnTacVu.textContent === strTacVu) {
//                    btnDky.style.display = "block";
//                    btnOnTap.style.display = "none";
//
//                    btnLogin.textContent = "Đăng Nhập";
//                    btnContact.textContent = "Góp Ý";
//                    btnPresent.textContent = "Giới Thiệu";
//                } else {
//
//                    btnDky.style.display = "none";
//                    btnOnTap.style.display = "block";
//
//                    //set link cá nhân
//                    btnLogin.textContent = "Cá Nhân";
//                    btnLogin.href = "Personal";
//
//                    //set link Thống kê
//                    btnContact.textContent = "Thống Kê";
//                    btnContact.href = "ThongKe";
//
//                    //set link đăng xuất
//
//                    btnPresent.textContent = "Đăng Xuất";
//                    btnPresent.href = "LogOut";
//
//                }
//            }
//            });
//            });
        </script>
    </body>
</html>

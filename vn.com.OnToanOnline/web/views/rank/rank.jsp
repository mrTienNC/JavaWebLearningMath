<%-- 
    Document   : rank
    Created on : Feb 25, 2018, 9:27:23 PM
    Author     : TienNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bảng xếp hạng</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="<c:url value='/node_modules/bootstrap/dist/css/bootstrap.css'/>">
        <script src="<c:url value='/node_modules/jquery/dist/jquery.js'/>"></script>
        <script src="<c:url value='/node_modules/bootstrap/dist/js/bootstrap.js'/>"></script>
        <link rel="stylesheet" type="text/css" href="<c:url value='/fa-icon/web-fonts-with-css/css/fontawesome-all.css'/>">
        <script type="text/javascript" src="<c:url value='/fa-icon/svg-with-js/js/fontawesome-all.js'/>"></script>

        <link href="https://fonts.googleapis.com/css?family=Alegreya|Josefin+Sans|Open+Sans" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="<c:url value='./css/header.css' />">
        <link rel="stylesheet" type="text/css" href="<c:url value='./css/footer.css' />">
        <link rel="stylesheet" type="text/css" href="<c:url value='./css/rank.css' />">
        <script type="text/javascript" src="<c:url value='/js/1.js'/>"></script>
    </head>
    <body>
        <jsp:include page="/views/header.jsp" />
        <section id="section_rank">
            <div class="container">
                <div class="container-fluid">
                    <div class="col-md-8 col-lg-8 col-sm-12 col-xs-12">
                        <div class="div_rank">
                            <h2>Bảng xếp hạng</h2>
                            <hr>
                            <form action="rank" method="GET">
                                <div class="form-group">
                                    <label for="">Tìm kiếm : </label>
                                    <input type="text" class="form-control" id="tuKhoa" placeholder="Nhập Họ Tên" name="tuKhoa">
                                    <button type="submit" class="btn btn-primary btn_Submit"><span><img src="images/search.png"></span>Search</button>
                                </div>
                                <div class="rank_info">
                                    <br>
                                    <p style="color: red">${errorString}</p>
                                    <br>
                                    <% int i = 0;%>
                                    <table border="1">
                                        <tr>
                                            <th>Thứ Hạng</th>
                                            <th>Họ Tên</th>
                                            <th>Giới Tính</th>
                                            <th>Trường</th>
                                            <th>Điểm</th>
                                        </tr>
                                        <c:forEach items="${rank}" var="tv">
                                            <tr>
                                                <td><%=++i%></td>
                                                <td>${tv.hoTen}</td>
                                                <td>${tv.gioiTinh}</td>
                                                <td>${tv.truongHoc}</td>
                                                <td>${tv.point}</td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                            </form>
                        </div>
                        <div class="rank_page">
                            <ul class="pagination pagination-lg">
                                <li><a href="#">&laquo;</a></li>
                                <li><a href="#">1</a></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">4</a></li>
                                <li><a href="#">5</a></li>
                                <li><a href="#">&raquo;</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-4 col-lg-4 col-sm-12 col-xs-12">
                        <div class="person_info">
                            <div class="person_image">
                                <img src="${images}" class="img-responsive img-thumbnail">
                            </div>
                            <div class="person_detail">
                                <h2>Thong tin TOP</h2>
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
        <jsp:include page="/views/footer.jsp" />
    </body>
</html>

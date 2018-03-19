<%-- 
    Document   : result
    Created on : Mar 2, 2018, 9:03:57 PM
    Author     : TienNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kết Quả</title>
        <link rel="stylesheet" href="<c:url value='/node_modules/bootstrap/dist/css/bootstrap.css'/>">
        <script src="<c:url value='/node_modules/jquery/dist/jquery.js'/>"></script>
        <script src="<c:url value='/node_modules/bootstrap/dist/js/bootstrap.js'/>"></script>
        <link rel="stylesheet" type="text/css" href="<c:url value='/fa-icon/web-fonts-with-css/css/fontawesome-all.css'/>">
        <script type="text/javascript" src="<c:url value='/fa-icon/svg-with-js/js/fontawesome-all.js'/>"></script>

        <link rel="stylesheet" type="text/css" href=" <c:url value = '/css/header.css'/>">
        <link rel="stylesheet" type="text/css" href=" <c:url value = '/css/result.css'/>">
    </head>
    <body>
        <jsp:include page="/views/header.jsp"></jsp:include>
            <section id="section_result">
                <div class="container">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-3 col-lg-3 col-sm-12 col-xs-12 personal_ava">
                                <div class="img img-responsive img-thumbnail personal_img">
                                    <img src="${images}">
                                    <p style="color: red">ID : ${id}</p>
                            </div>
                            <h2>Nguyễn Văn Tèo</h2>
                            <div class="personal_bot">
                                <img src="images/star.png" class="img-responsive">
                            </div>
                        </div>
                        <div class="col-md-5 col-lg-5 col-sm-12 col-xs-12">
                            <div class="result_test">

                                <legend>Kết Quả Của Bạn</legend>
                                <form action="#" method="GET">
                                    <table border="0">
                                        <tr>
                                            <td>Số Câu :</td>
                                            <td>10</td>
                                        </tr>
                                        <tr>
                                            <td>Trả Lời Đúng :</td>
                                            <td>${dem}</td>
                                        </tr>
                                        <tr>
                                            <td>Điểm :</td>
                                            <td>${newPoint}</td>
                                        </tr>
                                        <tr>
                                            <td>Điểm cũ :</td>
                                            <td>${oldPoint}</td>
                                        </tr>
                                        <tr>
                                            <td>Điểm mới:</td>
                                            <td>${point}</td>
                                        </tr>
                                    </table>
                                    <a class="btn btn-primary" type="button" href="<%=request.getContextPath()%>/OnTap">
                                        <span><i class="fas fa-arrow-left"></i></span>
                                        Quay Lại
                                    </a>
                                </form>
                            </div>
                        </div>
                        <div class="col-md-4 col-lg-4 col-sm-12 col-xs-12">
                            <div class="result_comment">

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>

<%-- 
    Document   : OnTap
    Created on : Feb 28, 2018, 8:41:41 PM
    Author     : TienNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chọn bài</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="<c:url value='/node_modules/bootstrap/dist/css/bootstrap.css'/>">
        <script src="<c:url value='/node_modules/jquery/dist/jquery.js'/>"></script>
        <script src="<c:url value='/node_modules/bootstrap/dist/js/bootstrap.js'/>"></script>
        <link rel="stylesheet" type="text/css" href="<c:url value='/fa-icon/web-fonts-with-css/css/fontawesome-all.css'/>">
        <script type="text/javascript" src="<c:url value='/fa-icon/svg-with-js/js/fontawesome-all.js'/>"></script>

        <link rel="stylesheet" type="text/css" href=" <c:url value = '/css/OnTap.css'/>">
        <link rel="stylesheet" type="text/css" href=" <c:url value = '/css/login_1.css'/>">
    </head>
    <body>
        <jsp:include page="/views/header.jsp"></jsp:include>
        <h1>${errorString}</h1>
        <section style="padding: 80px;" class="baiThi">
            <div class="container">
                <p style="color: red; text-align: center">${errorString}</p>
                <div class="row">
                    <div class="col-md-4 col-lg-4 col-sm-12 col-xs-12" style="border: 1px solid black; width: 300px;">
                        <h3>Toán lớp 1</h3>
                        <img class="img img-responsive img-rounded" src="<c:url value='/images/toan1.jpg' />">
                        <a class="btn btn-info" href="<%=request.getContextPath()%>/lop1">Vào thi</a>
                    </div>

                    <div class="col-md-4 col-lg-4 col-sm-12 col-xs-12" style="border: 1px solid black; width: 300px;">
                        <h3>Toán lớp 2</h3>
                        <img class="img img-responsive img-rounded" src="<c:url value='/images/toan2.png' />">
                        <a class="btn btn-info" href="<%=request.getContextPath()%>/lop2">Vào thi</a>
                    </div>
                    <div class="col-md-4 col-lg-4 col-sm-12 col-xs-12" style="border: 1px solid black; width: 300px;">
                        <h3>Toán lớp 3</h3>
                        <img class="img img-responsive img-rounded" src="<c:url value='/images/toan3.png' />">
                        <a class="btn btn-info" href="<%=request.getContextPath()%>/lop3">Vào thi</a>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-4 col-lg-4 col-sm-12 col-xs-12" style="border: 1px solid black; width: 300px;">
                        <h3>Toán lớp 4</h3>
                        <img class="img img-responsive img-rounded" src="<c:url value='/images/toan4.png' />">
                        <a class="btn btn-info" href="<%=request.getContextPath()%>/lop4">Vào thi</a>
                    </div>
                    <div class="col-md-4 col-lg-4 col-sm-12 col-xs-12" style="border: 1px solid black; width: 300px;text-align: center">
                        <h3>Toán lớp 5</h3>
                        <img class="img img-responsive img-rounded" src="<c:url value='/images/toan5.png' />">
                        <a class="btn btn-info" href="<%=request.getContextPath()%>/lop5">Vào thi</a>
                    </div>

                    <div class="col-md-4 col-lg-4 col-sm-12 col-xs-12" style="border: 1px solid black; width: 300px;text-align: center">
                        <h3>Toán Tổng Hợp</h3>
                        <img class="img img-responsive img-rounded" src="<c:url value='/images/tonghop.png' />">
                        <a class="btn btn-info" href="<%=request.getContextPath()%>/lop6">Vào thi</a>
                    </div>
                </div>
            </div>
        </section>
        <script src="<c:url value = '/js/1.js'/>" type="text/javascript"></script>
    </body>
</html>

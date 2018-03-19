<%-- 
    Document   : personal
    Created on : Mar 1, 2018, 10:02:54 PM
    Author     : TienNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cá Nhân</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="<c:url value='/node_modules/bootstrap/dist/css/bootstrap.css'/>">
        <script src="<c:url value='/node_modules/jquery/dist/jquery.js'/>"></script>
        <script src="<c:url value='/node_modules/bootstrap/dist/js/bootstrap.js'/>"></script>
        <link rel="stylesheet" type="text/css" href="<c:url value='/fa-icon/web-fonts-with-css/css/fontawesome-all.css'/>">
        <script type="text/javascript" src="<c:url value='/fa-icon/svg-with-js/js/fontawesome-all.js'/>"></script>

        <link rel="stylesheet" type="text/css" href=" <c:url value = '/css/header.css'/>">
        <link rel="stylesheet" type="text/css" href=" <c:url value = '/css/personal.css'/>">
        <link rel="stylesheet" type="text/css" href=" <c:url value = '/css/footer.css'/>">

    </head>
    <body>
        <jsp:include page="/views/header.jsp"></jsp:include>
            <section id="section_personal">
                <div class="container">
                    <div class="container-fluid">
                        <div class="row">

                            <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                                <!--<div style="text-align: center">-->
                                <h2 style="color: red; text-align: center;">${errorUpdate}</h2>
                            <h2 style="color: red; text-align: center; visibility: hidden">${errorPass}</h2>
                            <!--</div>-->
                            <div class="personal_info">
                                <form action="<%=request.getContextPath()%>/Personal" method="POST">
                                    <div class="col-md-3 col-lg-3 col-sm-12 col-xs-12 personal_ava">
                                        <div class="img img-responsive img-thumbnail personal_img">
                                            <img src="${images}" id="showImage">

                                            <p style="color: red">ID-User : ${id}</p>
                                        </div>
                                        <input type="file" name="file" class="file_personal" id="inputFileToLoad" onchange="encodeImageFileAsURL();">
                                        <input type="text" name="base64" id="base64" readonly hidden>
                                        <div class="personal_bot">
                                            <img src="images/star_1.png" class="img-responsive">
                                        </div>
                                    </div>
                                    <div class="col-md-9 col-sm-12 col-lg-9 col-xs-12">
                                        <legend>Thông tin cá nhân</legend>

                                        <div class="form-group">
                                            <label for="">Họ Tên</label>
                                            <input type="text" class="form-control" name="fullName" value="${fullName}" required>
                                        </div>
                                        <div class="form-group" class="personal_sex">
                                            <label for="">Giới Tính</label>
                                            <input type="radio" name="sex" value="Nam" id="nam" ${checkNam}><span>Nam</span>
                                            <input type="radio" name="sex" value="Nữ" id="nu" ${checkNu}> <span>Nữ</span>
                                        </div>
                                        <div class="form-group">
                                            <label for="">Ngày Sinh</label>
                                            <input type="date" class="form-control" name="birthday" value="${birthday}">
                                        </div>
                                        <div class="form-group">
                                            <label for="">Trường Học</label>
                                            <input type="text" class="form-control" name="school" value="${school}" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="">Địa Chỉ</label>
                                            <input type="text" class="form-control" name="address" value="${address}">
                                        </div>
                                        <div class="form-group">
                                            <label for="">Tính Cách</label>
                                            <input type="text" class="form-control" name="character" value="${character}">
                                        </div>
                                        <div class="form-group">
                                            <label for="">Sở Thích</label>
                                            <input type="text" class="form-control" name="hobbies" value="${hobbies}" >
                                        </div>
                                        <div class="form-group">
                                            <label for="">Số điện thoại</label>
                                            <input type="text" class="form-control" name="phone" value="${phone}">
                                        </div>
                                        <div class="form-group">
                                            <label for="">Email</label>
                                            <input type="email" class="form-control" name="email" value="${email}">
                                        </div>
                                        <button type="submit" class="btn btn-primary">Cập Nhật Thông Tin</button>
                                    </div>
                                </form>
                            </div>
                            <div class="update_user">
                                <form action="<%=request.getContextPath()%>/updatePassword" method="POST" role="form">
                                    <legend>Thay đổi mật khẩu</legend>

                                    <div class="form-group">
                                        <label for="">Mật Khẩu Cũ</label>
                                        <input type="password" class="form-control" name="oldPassword" placeholder="Text Here...">
                                    </div>
                                    <div class="form-group">
                                        <label for="">Mật Khẩu Mới</label>
                                        <input type="password" class="form-control" name="newPassword" placeholder="Text Here...">
                                    </div>
                                    <button type="submit" class="btn btn-primary">Cập Nhật</button>
                                </form>
                            </div> 
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <jsp:include page="/views/footer.jsp"></jsp:include>
        <script type="text/javascript">
            function encodeImageFileAsURL() {

                var filesSelected = document.getElementById("inputFileToLoad").files;
                if (filesSelected.length > 0) {
                    var fileToLoad = filesSelected[0];

                    var fileReader = new FileReader();

                    fileReader.onload = function (fileLoadedEvent) {
                        var srcData = fileLoadedEvent.target.result; // <--- data: base64
                        document.getElementById("showImage").src = srcData;
                        document.getElementById("base64").value = srcData.toString();

                    }
                    fileReader.readAsDataURL(fileToLoad);
                }
            }
        </script>
    </body>
</html>

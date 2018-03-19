<%-- 
    Document   : BaiThi
    Created on : Feb 28, 2018, 9:30:12 PM
    Author     : TienNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${title}</title>
        <link rel="stylesheet" href="<c:url value='/node_modules/bootstrap/dist/css/bootstrap.css'/>">
        <script src="<c:url value='/node_modules/jquery/dist/jquery.js'/>"></script>
        <script src="<c:url value='/node_modules/bootstrap/dist/js/bootstrap.js'/>"></script>
        <link rel="stylesheet" type="text/css" href="<c:url value='/fa-icon/web-fonts-with-css/css/fontawesome-all.css'/>">
        <script type="text/javascript" src="<c:url value='/fa-icon/svg-with-js/js/fontawesome-all.js'/>"></script>

        <link rel="stylesheet" type="text/css" href=" <c:url value = '/css/header.css'/>">
        <link rel="stylesheet" type="text/css" href=" <c:url value = '/css/BaiThi.css'/>">
        <link rel="stylesheet" type="text/css" href=" <c:url value = '/css/footer.css'/>">
    </head>
    <body>
        <jsp:include page="/views/header.jsp"></jsp:include>

            <section id="section_BaiThi">
                <div class="container">
                    <div class="row row1">
                        <h2>Bài Thi Trắc Nghiệm Toán Lớp 1</h2>
                        <h3>Bạn sẽ có 15 phút tương đương 900 giây để hoàn thành 30 câu hỏi</h3>
                        <h4>Nếu sẵn sàng hãy bấm nút để vào thi</h4>
                    </div>
                    <div class="row row2">
                        <button class="btn btn-info" id="batDau">Bắt đầu</button>
                        <!--<h4>Thời gian : <span id="countdown">300</span><span> Giây</span></h4>-->
                    </div>
                <% int i = 0;%>
                <div class="row row3">
                    <div class="col-md-10 col-lg-10 col-sm-12 col-xs-12">
                        <form method="POST" action="<%=request.getContextPath()%>/lop1" style="visibility: hidden" id="formThi">
                            <table border = "0"> 
                                <c:forEach items="${lstToan}" var="ch">
                                    <br>
                                    <h3>Câu <%= ++i%></h3>
                                    <h4>${ch.cauHoi}</h4>
                                    <p>
                                        <span>
                                            <input type="radio" name="da${ch.ID}" value="1"> 
                                            <span>A.${ch.da_A}</span>
                                        </span>
                                        <span>
                                            <input type="radio" name="da${ch.ID}" value="2"> 
                                            <span>B.${ch.da_B}</span>
                                        </span>
                                        <span>
                                            <input type="radio" name="da${ch.ID}" value="3"> 
                                            <span>C.${ch.da_C}</span>
                                        </span>
                                        <span>
                                            <input type="radio" name="da${ch.ID}" value="4"> 
                                            <span>D.${ch.da_D}</span>
                                        </span>
                                    </p>
                                </c:forEach>
                            </table>
                            <input type="submit" value="Nộp Bài" id="nopBai" class="btn btn-success">
                            <span>
                                <a href="<%=request.getContextPath()%>/chonBaiThi" 
                                   class="btn btn-danger" id="huyBai" <!--onclick="sendForm()>"-->>Hủy Bài</a>
                            </span>
                        </form>
                    </div>
                    <div class="col-md-2 col-lg-2 col-sm-12 col-xs-12">
                        <div class="time">
                            <h4><br><br> <br><span id="countdown" style="visibility: hidden">900</span></h4>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <script type="text/javascript">
            $("button").click(function ()
            {
                $("form").removeAttr("style", "hidden");
                $("#countdown").removeAttr("style","hidden");
                var time = 900;
                var downloadTimer = setInterval(function ()
                {
                    time--;
                    document.getElementById("countdown").textContent = time;
                    if (time <= 0)
                    {
                        clearInterval(downloadTimer);
                        document.getElementById("formThi").submit();
                    }
                }, 1000);

            });

        </script>
        <jsp:include page="/views/footer.jsp"></jsp:include>
    </body>
</html>

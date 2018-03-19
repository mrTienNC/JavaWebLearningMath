<%-- 
    Document   : page-forget
    Created on : Mar 12, 2018, 6:11:57 PM
    Author     : TienNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Forget Password </title>
        <meta name="description" content="Sufee Admin - HTML5 Admin Template">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="apple-touch-icon" href="apple-icon.png">
        <link rel="shortcut icon" href="favicon.ico">

        <link rel="stylesheet" href="<c:url value='./assets/css/normalize.css' />">
        <link rel="stylesheet" href="<c:url value='./assets/css/bootstrap.min.css' />">
        <link rel="stylesheet" href=" <c:url value='./assets/css/font-awesome.min.css' />">
        <link rel="stylesheet" href="<c:url value = './assets/css/themify-icons.css '/>">
        <link rel="stylesheet" href="<c:url value = './assets/css/flag-icon.min.css ' />">
        <link rel="stylesheet" href="<c:url value = './assets/css/cs-skin-elastic.css'/>">
        <!-- <link rel="stylesheet" href="assets/css/bootstrap-select.less"> -->
        <link rel="stylesheet" href="<c:url value = './assets/scss/style.css'/>">
        <link href="<c:url value = './assets/css/lib/vector-map/jqvmap.min.css" rel="stylesheet'/>">

        <link href="<c:url value='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800'/>" rel='stylesheet' type='text/css'>

        <!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->

    </head>
    <body class="bg-dark">


        <div class="sufee-login d-flex align-content-center flex-wrap">
            <div class="container">
                <div class="login-content">
                    <div class="login-logo">
                        <a href="index.html">
                            <img class="align-content" src="images/logo.png" alt="">
                        </a>
                    </div>
                    <div class="login-form">
                        <form>
                            <div class="form-group">
                                <label>Email address</label>
                                <input type="email" class="form-control" placeholder="Email">
                            </div>
                            <button type="submit" class="btn btn-primary btn-flat m-b-15">Submit</button>

                        </form>
                    </div>
                </div>
            </div>
        </div>


        <!-- Right Panel -->
        <script src="<c:url value='./node_modules/jquery/dist/jquery.js'/>"></script>
        <script src="<c:url value='./assets/js/vendor/jquery-2.1.4.min.js'></c:url>"></script>
        <script src="<c:url value= 'https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js'/>"></script>
        <script src="<c:url value='./assets/js/plugins.js'/>"></script>
        <script src="<c:url value='./assets/js/main.js'/>"></script>
    </body>
</html>

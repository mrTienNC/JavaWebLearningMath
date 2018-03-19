<%-- 
    Document   : admin-login
    Created on : Mar 12, 2018, 9:21:41 PM
    Author     : TienNguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Admin </title>
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
                            <img class="align-content img-responsive" src="images/logo.png" alt="" style="width: 150px">
                        </a>
                    </div>
                    <div class="login-form">
                        <form action="AdminLogin" method="POST">
                            <p style="color: red">${errorString}</p>
                            <div class="form-group">
                                <label>Email address / Username</label>
                                <input type="text" class="form-control" placeholder="Email/Username" name="username">
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                <input type="password" class="form-control" placeholder="Password" name="password">
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="checkbox" value="Y"> Remember Me
                                </label>
                                <label class="pull-right">
                                    <a href="#">Forgotten Password?</a>
                                </label>

                            </div>
                            <button type="submit" class="btn btn-success btn-flat m-b-30 m-t-30">Sign in</button>
                            <div class="social-login-content">
                                <div class="social-button">
                                    <button type="button" class="btn social facebook btn-flat btn-addon mb-3"><i class="ti-facebook"></i>Sign in with facebook</button>
                                    <button type="button" class="btn social twitter btn-flat btn-addon mt-2"><i class="ti-twitter"></i>Sign in with twitter</button>
                                </div>
                            </div>
                            <div class="register-link m-t-15 text-center">
                                <p>Don't have account ? <a href="#"> Sign Up Here</a></p>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>


        <script src="<c:url value='./node_modules/jquery/dist/jquery.js'/>"></script>
        <script src="<c:url value='./assets/js/vendor/jquery-2.1.4.min.js'/>"></script>
        <script src="<c:url value='./assets/js/popper.min.js'/>"></script>
        <script src="<c:url value='./assets/js/plugins.js'/>"></script>
        <script src="<c:url value='./assets/js/main.js'/>"></script>


    </body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Kitty
  Date: 02/01/2019
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>${title}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="Mosaic Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design"/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!-- Bootstrap Core CSS -->
    <link href="resources/assets/css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <!-- Custom CSS -->
    <link href="resources/assets/css/style.css" rel='stylesheet' type='text/css'/>
    <!-- Graph CSS -->
    <link href="resources/assets/css/font-awesome.css" rel="stylesheet">
    <!-- jQuery -->
    <!-- lined-icons -->
    <link rel="stylesheet" href="resources/assets/css/icon-font.css" type='text/css'/>
    <!-- //lined-icons -->
    <!-- Meters graphs -->
    <script src="resources/assets/js/jquery-2.1.4.js"></script>

</head>
<!-- /w3layouts-agile -->
<body class="sticky-header left-side-collapsed" onload="initMap()">
<section>
    <!-- left side start-->
    <div class="left-side sticky-left-side">

        <!--logo and iconic logo start-->
        <div class="logo">
            <h1><a href="index.html">Mosai<span>c</span></a></h1>
        </div>
        <div class="logo-icon text-center">
            <a href="index.html">M </a>
        </div>
        <!-- /w3l-agile -->
        <!--logo and iconic logo end-->
        <div class="left-side sticky-left-side">

            <div class="logo">
                <h1><a href="index.html">Mosai<span>c</span></a></h1>
            </div>
            <div class="logo-icon text-center">
                <a href="index.html">M </a>
            </div>
        </div>

    </div>

    <div class="main-content">
        <div class="row">
            <div class="col-lg-4"></div>
            <div class="col-lg-4 ">
                <form action="/login" method="post" id="loginForm">
                    <fieldset id="body">
                        <fieldset>
                            <label for="email">Email Address</label>
                            <input type="text" name="email" id="email">
                        </fieldset>
                        <fieldset>
                            <label for="password">Password</label>
                            <input type="password" name="password" id="password">
                        </fieldset>
                        <input type="submit" id="login" value="Sign in">
                        <label for="checkbox"><input type="checkbox" id="checkbox"> <i>Remember
                            me</i></label>
                    </fieldset>
                    <span><a href="#">Forgot your password?</a></span>
                </form>
            </div>
            <div class="col-lg-4"></div>
        </div>
    </div>
</section>

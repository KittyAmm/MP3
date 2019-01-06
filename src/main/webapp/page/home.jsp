<%--
  Created by IntelliJ IDEA.
  User: Kitty
  Date: 02/01/2019
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>${title}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Mosaic Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- Bootstrap Core CSS -->
    <link href="resources/assets/css/bootstrap.css" rel= 'stylesheet' type='text/css' />
    <!-- Custom CSS -->
    <link href="resources/assets/css/style.css" rel='stylesheet' type='text/css' />
    <!-- Graph CSS -->
    <link href="resources/assets/css/font-awesome.css" rel="stylesheet">
    <!-- jQuery -->
    <!-- lined-icons -->
    <link rel="stylesheet" href="resources/assets/css/icon-font.css" type='text/css' />
    <!-- //lined-icons -->
    <!-- Meters graphs -->
    <script src="resources/assets/js/jquery-2.1.4.js"></script>


</head>
<!-- /w3layouts-agile -->
<body class="sticky-header left-side-collapsed"  onload="initMap()">
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
            <div class="left-side-inner">
                <ul class="nav nav-pills nav-stacked custom-nav">

                    <li class="active">
                        <a href="#">
                            <i class="lnr lnr-home"></i>
                            <span>Home</span></a></li>

                    <li><a href="">
                        <i class="lnr lnr-music-note"></i>
                        <span>Songs</span></a></li>

                    <li><a href=""><i class="lnr lnr-users"></i> <span>Artists</span></a></li>
                    <li><a href=""><i class="lnr lnr-bookmark"></i> <span>Albums</span></a></li>
                    <li><a href=""><i class="lnr lnr-book"></i><span>Genres</span></a></li>
                    <li><a href="/profil"><i class="lnr lnr-user"></i><span>Profil</span></a></li>
                </ul>
            </div>
        </div>

    </div>
    <!-- /w3layouts-agile -->
    <!-- app-->

    <!-- //app-->
    <!-- /w3l-agile -->
    <!-- signup -->
    <div class="modal fade" id="myModal5" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content modal-info">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body modal-spa">
                    <div class="sign-grids">
                        <div class="sign">
                            <div class="sign-right">
                                <form action="#" method="post">

                                    <h3>Create your account </h3>
                                    <input type="text" value="Name" onfocus="this.value = '';" onblur="if (this.value === '') {this.value = 'Name';}" required="">
                                    <input type="text" value="Mobile number" onfocus="this.value = '';" onblur="if (this.value === '') {this.value = 'Mobile number';}" required="">
                                    <input type="text" value="Email id" onfocus="this.value = '';" onblur="if (this.value === '') {this.value = 'Email id';}" required="">
                                    <input type="password" value="Password" onfocus="this.value = '';" onblur="if (this.value === '') {this.value = 'Password';}" required="">

                                    <input type="submit" value="CREATE ACCOUNT" >
                                </form>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- //signup -->
    <!-- /w3l-agile -->
    <!-- left side end-->
    <!-- main content start-->
    <div class="main-content">
        <!-- header-starts -->
        <div class="header-section">
            <!--toggle button start-->
            <a class="toggle-btn  menu-collapsed"><i class="fa fa-bars"></i></a>
            <!--toggle button end-->
            <!--notification menu start -->
            <div class="menu-right">
                <div class="profile_details">
                    <div class="col-md-4 serch-part">
                        <div id="sb-search" class="sb-search">
                            <form action="#" method="post">

                                <input class="sb-search-input" placeholder="Search" type="search" name="search" id="search">
                                <input class="sb-search-submit" type="submit" value="">
                                <span class="glyphicon-search"> </span>
                            </form>
                        </div>
                    </div>
                    <!-- search-scripts -->
                    <script src="resources/assets/js/classie.js"></script>
                    <script src="resources/assets/js/uisearch.js"></script>
                    <script>
                        new UISearch( document.getElementById( 'sb-search' ) );
                    </script>
                    <!-- //search-scripts -->
                    <!---->
                    <div class="col-md-4 player">
                        <script type="text/javascript">
                            $(function(){
                                $('#audio-player').mediaelementplayer({
                                    alwaysShowControls: true,
                                    features: ['playpause','progress','volume'],
                                    audioVolume: 'horizontal',
                                    iPadUseNativeControls: true,
                                    iPhoneUseNativeControls: true,
                                    AndroidUseNativeControls: true
                                });
                            });
                        </script>
                        <!--audio-->
                        <link rel="stylesheet" type="text/css" media="all" href="resources/assets/css/audio.css">
                        <script type="text/javascript" src="resources/assets/js/mediaelement-and-player.min.js"></script>
                        <!---->



                    </div>
                    <div class="col-md-4 login-pop">
                        <div id="loginpop"> <a href="#" id="loginButton"><span>Login <i class="arrow glyphicon glyphicon-chevron-right"></i></span></a><a class="top-sign" href="#" data-toggle="modal" data-target="#myModal5"><i class="fa fa-sign-in"></i></a>
                            <div id="loginBox">
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
                                        <label for="checkbox"><input type="checkbox" id="checkbox"> <i>Remember me</i></label>
                                    </fieldset>
                                    <span><a href="#">Forgot your password?</a></span>
                                </form>
                            </div>
                        </div>

                    </div>
                    <div class="clearfix"> </div>
                </div>
                <!-------->
            </div>
            <div class="clearfix"></div>
        </div>

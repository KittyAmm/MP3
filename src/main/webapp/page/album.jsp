<%--
  Created by IntelliJ IDEA.
  User: Kitty
  Date: 11/01/2019
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ALBUM</title>
</head>
<jsp:include page="page/home.jsp"/>
<section>
    <div class="left-side sticky-left-side">
        <!-- /w3l-agile -->
        <!-- left side end-->
        <!-- app-->

        <!-- main content start-->
        <div class="main-content">
            <!-- header-starts -->
            <div class="header-section">
                <!--toggle button start-->
                <a class="toggle-btn  menu-collapsed"><i class="fa fa-bars"></i></a>

                <div id="page-wrapper">
                    <div class="inner-content">
                        <div class="music-browse">
                            <!--albums-->
                            <!-- pop-up-box -->
                            <link href="../resources/assets/css/popuo-box.css" rel="stylesheet" type="text/css"
                                  media="all">


                            <div class="review-slider">
                                <div class="tittle-head">
                                    <h3 class="tittle">Albums <span class="new"> New</span></h3>
                                    <div class="clearfix"></div>
                                </div>
                                <ul id="flexiselDemo1">
                                    <li>
                                        <a href="#"><img src="../resources/assets/images/v1.jpg" alt=""/></a>
                                        <div class="slide-title"><h4>Adele21</h4></div>
                                        <div class="date-city">
                                            <h5>Jan-02-16</h5>
                                            <div class="buy-tickets">
                                                <a href="#">Voir chansons</a>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <a href="#"><img src="../resources/assets/images/v6.jpg" alt=""/></a>
                                        <div class="slide-title"><h4>Ellie Goluding </h4></div>
                                        <div class="date-city">
                                            <h5>Jan-02-16</h5>
                                            <div class="buy-tickets">
                                                <a href="#">Voir chansons</a>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                                <script type="text/javascript" src="../resources/assets/js/jquery.flexisel.js"></script>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="footer.jsp"/>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

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
    <!-- Custom CSS -->
    <link href="resources/assets/css/bootstrap.css" rel="stylesheet" type="text/css"/>
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
                <li class="menu-list"><a href=""><i class="lnr lnr-user"></i><span>Profil</span></a></li>
            </ul>
        </div>
    </div>

    <!-- signup -->
    <div class="modal fade" id="myModal5" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content modal-info">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body modal-spa">
                    <div class="sign-grids">
                        <div class="sign">
                            <div class="sign-right">
                                <form action="#" method="post">

                                    <h3>Create your account </h3>
                                    <input type="text" value="Name" onfocus="this.value = '';" onblur="if (this.value === '') {
                                                    this.value = 'Name';
                                                }" required="">
                                    <input type="text" value="Mobile number" onfocus="this.value = '';" onblur="if (this.value === '') {
                                                    this.value = 'Mobile number';}" required="">
                                    <input type="text" value="Email id" onfocus="this.value = '';" onblur="if (this.value === '') {
                                                    this.value = 'Email id';
                                                }" required="">
                                    <input type="password" value="Password" onfocus="this.value = '';" onblur="if (this.value === '') {
                                                    this.value = 'Password';
                                                }" required="">

                                    <input type="submit" value="CREATE ACCOUNT">
                                </form>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="main-content">
        <div class="header-section">
            <a class="toggle-btn  menu-collapsed"><i class="fa fa-bars"></i></a>
            <div class="menu-right">
                <div class="profile_details">
                    <div class="col-md-4 serch-part">
                        <div id="sb-search" class="sb-search">
                            <form action="#" method="post">

                                <input class="sb-search-input" placeholder="Search" type="search" name="search"
                                       id="search">
                                <input class="sb-search-submit" type="submit" value="">
                                <span class="sb-icon-search"> </span>
                            </form>
                        </div>
                    </div>
                    <script src="resources/assets/js/classie.js"></script>
                    <script src="resources/assets/js/uisearch.js"></script>
                    <script>
                        new UISearch(document.getElementById('sb-search'));
                    </script>
                    <!-- //search-scripts -->
                    <!---->
                    <div class="col-md-4 player">
                        <div class="audio-player">
                            <audio id="audio-player" controls="controls">
                                <source src="media/Blue Browne.ogg" type="audio/ogg"></source>
                                <source src="media/Blue Browne.mp3" type="audio/mpeg"></source>
                                <source src="media/Georgia.ogg" type="audio/ogg"></source>
                                <source src="media/Georgia.mp3" type="audio/mpeg"></source>
                            </audio>
                        </div>
                        <!---->
                        <script type="text/javascript">
                            $(function () {
                                $('#audio-player').mediaelementplayer({
                                    alwaysShowControls: true,
                                    features: ['playpause', 'progress', 'volume'],
                                    audioVolume: 'horizontal',
                                    iPadUseNativeControls: true,
                                    iPhoneUseNativeControls: true,
                                    AndroidUseNativeControls: true
                                });
                            });
                        </script>
                        <!--audio-->
                        <link rel="stylesheet" type="text/css" media="all" href="resources/assets/css/audio.css">
                        <script type="text/javascript"
                                src="resources/assets/js/mediaelement-and-player.min.js"></script>
                        <!---->


                        <!--//-->
                        <ul class="next-top">
                            <li><a class="ar" href="#"> <img src="resources/assets/images/arrow.png" alt=""/></a></li>
                            <li><a class="ar2" href="#"><img src="resources/assets/images/arrow2.png" alt=""/></a></li>

                        </ul>
                    </div>
                    <div class="col-md-4 login-pop">
                        <div id="loginpop"><a href="#" id="loginButton"><span>Login <i
                                class="arrow glyphicon glyphicon-chevron-right"></i></span></a><a class="top-sign"
                                                                                                  href="#"
                                                                                                  data-toggle="modal"
                                                                                                  data-target="#myModal5"><i
                                class="fa fa-sign-in"></i></a>
                            <div id="loginBox">
                                <form action="login" method="post" id="loginForm">
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
                        </div>

                    </div>
                    <div class="clearfix"></div>
                </div>
                <!-------->
            </div>
            <div class="clearfix"></div>
        </div>
        <!--notification menu end -->
        <!-- //header-ends -->
        <!-- /w3l-agileits -->
        <!-- //header-ends -->
        <div id="page-wrapper">
            <div class="inner-content">

                <div class="music-left">
                    <!--banner-section-->
                    <div class="banner-section">
                        <div class="banner">
                            <div class="callbacks_container">
                                <div class="col-md-4 serch-part">
                                    <div class="row">
                                        <form action="#" method="post">

                                            <input placeholder="Search" type="search" name="search">
                                            <button type="submit">Upload</button>

                                        </form>
                                        <label>Titre:
                                            <input value="" type="hidden"></label>
                                        <br>
                                        <label>Duree: <input value="" type="hidden"></label><br>
                                        <label>Artiste: <input value="" type="hidden"></label><br>
                                        <label>Album: <input value="" type="hidden"></label><br>
                                        <label>Genre: <input value="" type="hidden"></label><br>
                                        <label>Annee: <input value="" type="hidden"></label>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>

                    <div class="albums">
                        <div class="tittle-head">
                            <h3 class="tittle">NOUVEAUTE</h3>
                            <a href="index.html"><h4 class="tittle">See all</h4></a>
                            <div class="clearfix"></div>
                        </div>
                        <div class="col-md-3 content-grid">
                            <a class="play-icon popup-with-zoom-anim" href="#small-dialog"><img
                                    src="resources/assets/images/v1.jpg" title="allbum-name"></a>
                            <a class="button play-icon popup-with-zoom-anim" href="#small-dialog">Listen now</a>
                        </div>

                        <div class="clearfix"></div>
                    </div>

                    <div class="albums second">
                        <div class="tittle-head">
                            <h3 class="tittle">TELECHARGEMENT GRATUIT</h3>
                            <div class="clearfix"></div>
                        </div>
                        <div class="row">
                            <div class="col-md-3 content-grid">
                                <select>
                                    <option></option>
                                </select>
                            </div>
                            <div class="col-md-3 content-grid">
                                <button>TOUT ECOUTER</button>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 content-grid">
                                Ellie G. <i class="lnr lnr-film-play"></i>
                                <i class="lnr lnr-heart"></i>
                                <i class="lnr lnr-download"></i>

                            </div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <div class="music-right">
                    <div class="video-main">
                        <div class="video-record-list">
                            <div id="jp_container_1" class="jp-video jp-video-270p" role="application"
                                 aria-label="media player">
                                <div class="jp-type-playlist">
                                    <div id="jquery_jplayer_1" class="jp-jplayer" style="width: 480px; height: 270px;">
                                        <img id="jp_poster_0" src="video/play1.png"
                                             style="width: 480px; height: 270px; display: inline;">
                                        <video id="jp_video_0" preload="metadata"
                                               src="http://192.168.30.9/vijayaa/2015/Dec/mosaic/web/video/Ellie-Goulding.webm"
                                               title="1. Ellie-Goulding" style="width: 0px; height: 0px;"></video>
                                    </div>
                                    <div class="jp-gui">
                                        <div class="jp-video-play" style="display: block;">
                                            <button class="jp-video-play-icon" role="button" tabindex="0">play</button>
                                        </div>
                                        <div class="jp-interface">
                                            <div class="jp-progress">
                                                <div class="jp-seek-bar" style="width: 100%;">
                                                    <div class="jp-play-bar" style="width: 0%;"></div>
                                                </div>
                                            </div>
                                            <div class="jp-current-time" role="timer" aria-label="time">00:00</div>
                                            <div class="jp-duration" role="timer" aria-label="duration">00:18</div>
                                            <div class="jp-controls-holder">
                                                <div class="jp-controls">
                                                    <button class="jp-previous" role="button" tabindex="0">previous
                                                    </button>
                                                    <button class="jp-play" role="button" tabindex="0">play</button>
                                                </div>
                                                <div class="jp-volume-controls">
                                                    <button class="jp-mute" role="button" tabindex="0">mute</button>
                                                    <button class="jp-volume-max" role="button" tabindex="0">max
                                                        volume
                                                    </button>
                                                    <div class="jp-volume-bar">
                                                        <div class="jp-volume-bar-value" style="width: 100%;"></div>
                                                    </div>
                                                </div>
                                                <div class="jp-toggles">

                                                    <button class="jp-full-screen" role="button" tabindex="0">full
                                                        screen
                                                    </button>
                                                </div>
                                            </div>
                                            <h3>TOP</h3>
                                            <div class="jp-details" style="display: none;">
                                                <div class="jp-title" aria-label="title">1. Ellie-Goulding</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="jp-playlist">
                                        <ul style="display: block;">
                                            <li class="jp-playlist-current">
                                                <div><a href="javascript:;" class="jp-playlist-item-remove"
                                                        style="display: none;">×</a><a href="javascript:;"
                                                                                       class="jp-playlist-item jp-playlist-current"
                                                                                       tabindex="0">1.
                                                    Ellie-Goulding</a>
                                                </div>
                                            </li>

                                        </ul>
                                    </div>

                                    <h3>MEILLEURES ALBUMS</h3>
                                    <div class="jp-playlist">
                                        <ul style="display: block;">
                                            <li class="jp-playlist-current">
                                                <div><a href="javascript:;" class="jp-playlist-item-remove"
                                                        style="display: none;">×</a><a href="javascript:;"
                                                                                       class="jp-playlist-item jp-playlist-current"
                                                                                       tabindex="0">1.
                                                    Ellie-Goulding</a>
                                                </div>
                                            </li>

                                        </ul>
                                    </div>

                                    <h3>MEILLEURES ARTISTES</h3>
                                    <div class="jp-playlist">
                                        <ul style="display: block;">
                                            <li class="jp-playlist-current">
                                                <div><a href="javascript:;" class="jp-playlist-item-remove"
                                                        style="display: none;">×</a><a href="javascript:;"
                                                                                       class="jp-playlist-item jp-playlist-current"
                                                                                       tabindex="0">1.
                                                    Ellie-Goulding</a>
                                                </div>
                                            </li>

                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- script for play-list -->
                    <link href="resources/assets/css/jplayer.blue.monday.min.css" rel="stylesheet" type="text/css">
                    <script type="text/javascript" src="resources/assets/js/jquery.jplayer.min.js"></script>
                    <script type="text/javascript" src="resources/assets/js/jplayer.playlist.min.js"></script>
                    <script type="text/javascript">
                        //<![CDATA[
                        $(document).ready(function () {

                            new jPlayerPlaylist({
                                jPlayer: "#jquery_jplayer_1",
                                cssSelectorAncestor: "#jp_container_1"
                            }, [

                                {
                                    title: "1. Ellie-Goulding",
                                    artist: "",
                                    mp4: "video/Ellie-Goulding.mp4",
                                    ogv: "video/Ellie-Goulding.ogv",
                                    webmv: "video/Ellie-Goulding.webm",
                                    poster: "video/play1.png"
                                },
                                {
                                    title: "2. Mark-Ronson-Uptown",
                                    artist: "",
                                    mp4: "video/Mark-Ronson-Uptown.mp4",
                                    ogv: "video/Mark-Ronson-Uptown.ogv",
                                    webmv: "video/Mark-Ronson-Uptown.webm",
                                    poster: "video/play2.png"
                                },
                                {
                                    title: "3. Ellie-Goulding",
                                    artist: "",
                                    mp4: "video/Ellie-Goulding.mp4",
                                    ogv: "video/Ellie-Goulding.ogv",
                                    webmv: "video/Ellie-Goulding.webm",
                                    poster: "video/play1.png"
                                },
                                {
                                    title: "4. Maroon-Sugar",
                                    artist: "",
                                    mp4: "video/Maroon-Sugar.mp4",
                                    ogv: "video/Maroon-Sugar.ogv",
                                    webmv: "video/Maroon-Sugar.webm",
                                    poster: "video/play4.png"
                                },
                            ], {
                                swfPath: "../../dist/jplayer",
                                supplied: "webmv,ogv,mp4",
                                useStateClassSkin: true,
                                autoBlur: false,
                                smoothPlayBar: true,
                                keyEnabled: true
                            });

                        });
                        //]]>
                    </script>
                    <!-- //script for play-list -->


                    <script type="text/javascript">
                        $(window).load(function () {

                            $("#flexiselDemo1").flexisel({
                                visibleItems: 5,
                                animationSpeed: 1000,
                                autoPlay: true,
                                autoPlaySpeed: 3000,
                                pauseOnHover: false,
                                enableResponsiveBreakpoints: true,
                                responsiveBreakpoints: {
                                    portrait: {
                                        changePoint: 480,
                                        visibleItems: 2
                                    },
                                    landscape: {
                                        changePoint: 640,
                                        visibleItems: 3
                                    },
                                    tablet: {
                                        changePoint: 800,
                                        visibleItems: 4
                                    }
                                }
                            });
                        });
                    </script>
                    <script type="text/javascript" src="resources/assets/js/jquery.flexisel.js"></script>
                </div>
            </div>
            <div class="clearfix"></div>
            <!--body wrapper end-->
            <!-- /w3l-agile -->
        </div>
        <!--body wrapper end-->
        <div class="footer">

            <div class="footer-grid">
                <h3>Our Support</h3>
                <ul class="list1">
                    <li><a href="#">Advanced Search</a></li>
                </ul>
            </div>
            <div class="footer-grid footer-grid_last">
                <h3>About Us</h3>
                <p class="footer_desc">KBH's Music</p>
                <p class="f_text">Phone: &nbsp;&nbsp;&nbsp;00-250-2131</p>
                <p class="email">Email : &nbsp;<span><a href="mailto:mail@example.com">info(at)mailing.com</a></span>
                </p>
                <div class="search_footer">
                    <form>
                        <input type="text" placeholder="Email...." required="">
                        <input type="submit" value="Submit">
                    </form>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
    <!--footer section start-->
    <footer>
        <p>&copy 2018 MP3. All Rights Reserved | Design by KBH's Music.</p>
    </footer>
    <!--footer section end-->
    <!-- /w3l-agile -->
    <!-- main content end-->
</section>

<script src="resources/assets/js/jquery.nicescroll.js"></script>
<script src="resources/assets/js/scripts.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="resources/assets/js/bootstrap.js"></script>
</body>
</html>

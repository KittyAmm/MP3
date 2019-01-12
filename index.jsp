<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/page/home.jsp" %>
<div id="page-wrapper">
    <div class="inner-content">

        <div class="music-left">
            <div class="albums">
                <div class="tittle-head">
                    <h3 class="tittle">NOUVEAUTE</h3>
                    
                    <a href="index.jsp"><h4 class="tittle">See all</h4></a>
                    <div class="clearfix"></div>
                </div>
                <div class="col-md-6 content-grid">
                    


 <div class="row">
                        
    <div class="col-sm-6">
      <li> <a class="play-icon popup-with-zoom-anim" href="#small-dialog">
         <img src="resources/assets/images/v1.jpg" title="allbum-name"></a>
         <a class="button play-icon popup-with-zoom-anim" href="#small-dialog">Listen now</a>
      </li>
    </div>
    <div class="col-sm-6">
         <li> <a class="play-icon popup-with-zoom-anim" href="#small-dialog">
          <img src="resources/assets/images/v1.jpg" title="allbum-name"></a>
          <a class="button play-icon popup-with-zoom-anim" href="#small-dialog">Listen now</a>
         </li>
    </div>
         <div class="col-sm-6">
      <li> <a class="play-icon popup-with-zoom-anim" href="#small-dialog">
         <img src="resources/assets/images/v1.jpg" title="allbum-name"></a>
         <a class="button play-icon popup-with-zoom-anim" href="#small-dialog">Listen now</a>
      </li>
    </div>
    <div class="col-sm-6">
         <li> <a class="play-icon popup-with-zoom-anim" href="#small-dialog">
          <img src="resources/assets/images/v1.jpg" title="allbum-name"></a>
          <a class="button play-icon popup-with-zoom-anim" href="#small-dialog">Listen now</a>
         </li>
    </div>
 </div>
                        
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
                            <c:forEach items="${chansons}" var="chanson">
                                ${chanson.id}<i class="lnr lnr-film-play"></i>
                                <i class="lnr lnr-heart"></i>
                                <i class="lnr lnr-download"></i>
                            </c:forEach>
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
                                            <button class="jp-previous" role="button" tabindex="0">previous</button>
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
</div>
<%@ include file="/WEB-INF/page/footer.jsp" %>
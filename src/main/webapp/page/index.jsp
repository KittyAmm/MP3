<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="home.jsp"/>
<div id="page-wrapper">
    <div class="inner-content">

        <div class="music-left">
            <div class="albums">
                <div class="tittle-head">
                    <h3 class="tittle">NOUVEAUTE</h3>
                    <a href="index.html"><h4 class="tittle">See all</h4></a>
                    <div class="clearfix"></div>
                </div>
                <div class="col-md-3 content-grid">
                    <a class="play-icon popup-with-zoom-anim" href="#small-dialog"><img
                            src="../resources/assets/images/v1.jpg" title="allbum-name"></a>
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
                    <div class="col-md-12 content-grid">
                        <table class="table table-bordered table-responsive">
                            <tr>
                                <th>Titre</th>
                                <th>Lecture</th>
                                <th>Favoris</th>
                                <th>Telecharger</th>
                                <th>Ajouter Playlist</th>
                            </tr>
                            <c:forEach items="${chansons}" var="chanson">
                                <tr>
                                    <td>${chanson.titre}</td>
                                    <td><audio controls>
                                        <source src="resources/media/M.mp3" type="audio/mpeg">
                                    </audio></td>
                                    <td><input type="hidden" id="valeur" value="1"><i onclick="aimer(${chanson.id})"
                                                                                      class="lnr lnr-heart"
                                                                                      id="idson${chanson.id}"></i></td>
                                    <td><a href="/telecharger/${chanson.id}"><i class="lnr lnr-download"></i></a></td>
                                    <td><a href="/playlist/${chanson.id}"><i class="lnr lnr-music-note"></i></a></td>
                                </tr>
                            </c:forEach>
                        </table>
                            <nav>
                                <ul class="pagination">
                                        <li><a href="/pagination/1/5">1</a></li>
                                        <li><a href="/pagination/2">2</a></li>
                                        <li><a href="/pagination/3">3</a></li>
                                </ul>
                            </nav>
                        <div class="clearfix"></div>
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


                            </div>
                            <div class="jp-gui">
                                <div class="jp-interface">
                                    <div class="jp-progress">
                                        <div class="jp-seek-bar" style="width: 100%;">
                                            <div class="jp-play-bar" style="width: 0%;"></div>
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
                        </div>
                    </div>
                </div>
            </div>


            <!-- script for play-list -->
            <link href="../resources/assets/css/jplayer.blue.monday.min.css" rel="stylesheet" type="text/css">
            <script type="text/javascript" src="../resources/assets/js/jquery.jplayer.min.js"></script>
            <script type="text/javascript" src="../resources/assets/js/jplayer.playlist.min.js"></script>
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
                $(document).ready(function () {

                });

                function aimer(id) {
                    console.log(id);
                    var val = $("#valeur").val();
                    console.log(val);
                    $.ajax({
                        type: 'GET',
                        url: '/favoris/' + id,
                        dataType: 'html',
                        success: function (result) {
                            if (val) {
                                console.log(val);
                                if (result === "true") {
                                    $("#idson" + id).on('click').css("color", "red");
                                }
                            }
                            else {
                                $("#idson" + id).on('click').css("color", "black");
                            }

                            console.log(result);
                        },
                        error: function (result) {
                            console.log(result);
                        }
                    });
                }
            </script>
            <script type="text/javascript" src="../resources/assets/js/jquery.flexisel.js"></script>
            <script src="../resources/assets/js/jquery.nicescroll.js"></script>
            <script src="../resources/assets/js/scripts.js"></script>
            <!-- Bootstrap Core JavaScript -->
            <script src="../resources/assets/js/bootstrap.js"></script>
        </div>
    </div>
    <div class="clearfix"></div>
</div>
<jsp:include page="footer.jsp"/>
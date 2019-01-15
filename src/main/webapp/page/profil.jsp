<%--
  Created by IntelliJ IDEA.
  User: Kitty
  Date: 02/01/2019
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
    <link href="../resources/assets/css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <!-- Custom CSS -->
    <link href="../resources/assets/css/style.css" rel='stylesheet' type='text/css'/>
    <!-- Graph CSS -->
    <link href="../resources/assets/css/font-awesome.css" rel="stylesheet">
    <!-- jQuery -->
    <!-- lined-icons -->
    <link rel="stylesheet" href="../resources/assets/css/icon-font.css" type='text/css'/>
    <!-- //lined-icons -->
    <!-- Meters graphs -->
    <script src="../resources/assets/js/jquery-2.1.4.js"></script>

</head>
<!-- /w3layouts-agile -->
<body class="sticky-header left-side-collapsed">
<section>
    <jsp:include page="home.jsp"/>

    <div class="main-content">
        <div class="header-section">
            <a class="toggle-btn"></a>
            <div class="clearfix"></div>
        </div>
        <div id="page-wrapper">
            <!--/inner-content-->
            <div class="inner-content">
                <!--/typography-->
                <div class="tittle-head">
                    <h3 class="tittle">Profil: ${utilisateur.nomuser}</h3>
                    <div class="clearfix"></div>
                    Email: ${utilisateur.email}<br>
                    Date Naissance: ${utilisateur.birth}<br>
                    Sexe: ${utilisateur.sexe}
                </div>
                <div class="typography">
                    <div class="row">
                        <div class="col-md-4">
                            <p>STATISTIQUE</p>
                            <div class="list-group list-group-alternate">
                                <a href="#" class="list-group-item"><span class="badge">${upload}</span> <i
                                        class="ti ti-email"></i> Upload </a>
                                <a href="#" class="list-group-item"><span
                                        class="badge badge-primary">${telecharg}</span> <i
                                        class="ti ti-eye"></i> Telechargements </a>
                                <a href="#" class="list-group-item"><span class="badge">${playlist}</span> <i
                                        class="ti ti-headphone-alt"></i> Playlist </a>
                                <a href="#" class="list-group-item"><span class="badge badge-warning">${favori}</span>
                                    <i
                                            class="ti ti-bookmark"></i> Favoris </a>
                            </div>
                        </div>

                        <div class="col-md-4">
                            <p> Please select a file to upload :</p>
                            <form:form method="post" action="/fileUploadPage"
                                       enctype="multipart/form-data">
                                <input type="file" name="file"/><br>
                                <input type="submit" value="upload"/>
                                <c:if test="${not empty infoMp3}">
                                    <p>Titre: ${infoMp3.titre}</p>
                                    <p>Duree: ${infoMp3.duree}</p>
                                    <p>Artiste: ${infoMp3.artiste}</p>
                                    <p>Album: ${infoMp3.album}</p>
                                    <p>Genre: ${infoMp3.genre}</p>
                                    <p>Annee: ${infoMp3.annee}</p>
                                    <p>Publication: ${infoMp3.publish}</p>
                                    <p>Taille: ${infoMp3.taille}</p>
                                    <p>Description: ${infoMp3.description}</p>
                                    <p>Commentaire: ${infoMp3.comment}</p>
                                </c:if>
                            </form:form>
                            <c:if test="${not empty infoMp3}">
                                <form:form method="post" action="/saveInfoMp3">
                                    <input type="hidden" name="path" value="${infoMp3.path}">
                                    <input type="submit" value="save"/>
                                </form:form>
                            </c:if>
                        </div>
                        <div class="col-md-4">
                            <p>MES PLAYLISTS</p>
                            <table class="table table-bordered table-responsive">
                                <tr>
                                    <th>Titre</th>
                                    <th>Date Ajout</th>
                                    <th>Lecture</th>
                                </tr>
                                <c:if test="${not empty playlists}">
                                    <c:forEach items="${playlists}" var="playlist">
                                        <tr>
                                            <td>${playlist.titre}</td>
                                            <td>${playlist.dateajout}</td>
                                            <td>
                                                <audio controls>
                                                    <source src="${playlist.url()}" type="audio/mpeg">
                                                </audio>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:if>
                            </table>
                        </div>

                        <div class="clearfix"></div>
                    </div>
                    <div class="music-left">
                        <div class="albums second">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="albums second">
                                        <div class="tittle-head">
                                            <h3 class="tittle">NOS CHANSONS</h3>
                                            <div class="clearfix"></div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-3 content-grid">
                                                <select>
                                                    <option></option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6 content-grid">
                                                <table class="table table-bordered table-responsive">
                                                    <tr>
                                                        <th>Titre</th>
                                                        <th>Lecture</th>
                                                        <th>Favoris</th>
                                                        <th>Telecharger</th>
                                                        <th>Ajout PlayList</th>
                                                    </tr>
                                                    <c:forEach items="${chansons}" var="chanson">
                                                        <tr>
                                                            <td>${chanson.titre}</td>
                                                            <td>
                                                                <audio controls>
                                                                    <source src="${chanson.url()}" type="audio/mpeg">
                                                                </audio>
                                                            </td>
                                                            <td><i id="idson${chanson.id}" onclick="aimer(${chanson.id})"
                                                                   class="lnr lnr-heart"></i></td>
                                                            <td><a href="/telecharger/${chanson.id}/${chanson.titre}">
                                                                <i class="lnr lnr-download"></i></a></td>
                                                            <td><a class="lnr lnr-music-note"
                                                                   href="/playlist/${chanson.id}/${chanson.titre}"></a>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </table>
                                            </div>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
        <jsp:include page="footer.jsp"/>
    </div>
</section>
<script>
    function aimer(id) {
        console.log(id);
        $.ajax({
            type: 'GET',
            url: '/favoris/' + id,
            dataType: 'html',
            success: function (result) {
                if (result === "true") {
                    $("#idson" + id).css("color", "red");
                }
                console.log(result);
            },
            error: function (result) {
                console.log(result);
            }
        });
    }
</script>
<script src="resources/assets/js/jquery.nicescroll.js"></script>
<script src="resources/assets/js/scripts.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="resources/assets/js/bootstrap.js"></script>
</body>
</html>
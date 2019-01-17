<%--
  Created by IntelliJ IDEA.
  User: Kitty
  Date: 29/12/2018
  Time: 11:55
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
                <p>Synchroniser</p>
                <a href="/synchrone"><i class="fa fa-refresh fa-spin" style="font-size:24px"></i></a>
                <section>
                    <div class="col-md-6">
                        <p>STATISTIQUE</p>
                        <div class="list-group list-group-alternate">
                            <a href="#" class="list-group-item"><span class="badge badge-primary">${telecharg}</span> <i
                                    class="ti ti-eye"></i> Telechargements </a>
                            <a href="#" class="list-group-item"><span class="badge">${upload}</span> <i
                                    class="ti ti-headphone-alt"></i> Upload </a>
                            <a href="#" class="list-group-item"><span class="badge badge-warning">${favori}</span> <i
                                    class="ti ti-bookmark"></i> Favoris </a>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <form:form method="post" action="/uploadadmin"
                                   enctype="multipart/form-data">
                            Please select a file to upload :
                            <input type="file" name="file"/><br>
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
                            <input type="submit" value="upload"/>
                        </form:form>
                        <c:if test="${not empty infoMp3}">
                            <form:form method="post" action="/saveInfoadmin">
                                <input type="hidden" name="path" value="${infoMp3.path}">
                                <input type="submit" value="save"/>
                            </form:form>
                        </c:if>
                    </div>

                    <div class="col-md-6">
                        <p>NOS CHANSONS</p>
                        <div class="list-group list-group-alternate">
                            <table class="table table-bordered table-response">
                                <thead>
                                <tr>
                                    <th>Listes</th>
                                    <th>Lecture</th>
                                    <th>Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${chansons}" var="chanson">
                                    <tr>
                                        <td><code>${chanson.titre}</code></td>
                                        <td>
                                            <audio controls>
                                                <source src="${chanson.url()}" type="audio/mpeg">
                                            </audio>
                                        </td>
                                        <td>
                                            <a href="supprimer/${chanson.id}">Supprimer</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
            </div>
            <div class="clearfix"></div>
        </div>
        <jsp:include page="footer.jsp"/>
    </div>
</section>

<script src="/resources/assets/js/jquery.nicescroll.js"></script>
<script src="/resources/assets/js/scripts.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="/resources/assets/js/bootstrap.js"></script>
</body>
</html>
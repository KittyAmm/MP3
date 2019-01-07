<%--
  Created by IntelliJ IDEA.
  User: Kitty
  Date: 02/01/2019
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="home.jsp"/>

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

            <div class="grid_3 grid_5">
                <h3>HISTORIQUES</h3>
                <div class="col-md-6">
                    <p>FAVORIS<code>.MENSUEL</code></p>
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>FAVORIS</th>
                            <th>Nombre</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td><code>Titres</code></td>
                            <td><span class="badge badge-primary">1</span></td>
                        </tr>
                        <tr>
                            <td><code>Artistes</code></td>
                            <td><span class="badge badge-primary">1</span></td>
                        </tr>
                        <tr>
                            <td><code>Albums</code></td>
                            <td><span class="badge badge-success">22</span></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="col-md-6">
                    <p>STATISTIQUE<code>.MENSUEL</code></p>
                    <div class="list-group list-group-alternate">
                        <a href="#" class="list-group-item"><span class="badge">201</span> <i
                                class="ti ti-email"></i> Upload </a>
                        <a href="#" class="list-group-item"><span class="badge badge-primary">5021</span> <i
                                class="ti ti-eye"></i> Telechargements </a>
                        <a href="#" class="list-group-item"><span class="badge">14</span> <i
                                class="ti ti-headphone-alt"></i> Playlist </a>
                        <a href="#" class="list-group-item"><span class="badge badge-warning">14</span> <i
                                class="ti ti-bookmark"></i> Favoris </a>
                    </div>
                </div>

                <div class="col-md-6">
                    <form:form method="post" action="/fileUploadPage" modelAttribute="fileUpload"
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
                        <form:form method="post" action="/saveInfoMp3">
                            <input type="hidden" name="path" value="${infoMp3.path}">
                            <input type="submit" value="save"/>
                        </form:form>
                    </c:if>
                </div>
                <div class="col-md-6">
                    <p>MES PLAYLISTS</p>
                    <div class="list-group list-group-alternate">
                        <a href="#" class="list-group-item"><span class="badge badge-warning">14</span> <i
                                class="ti ti-bookmark"></i> Ellie G. </a>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>

<jsp:include page="footer.jsp"/>
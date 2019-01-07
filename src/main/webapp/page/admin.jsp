<%--
  Created by IntelliJ IDEA.
  User: Kitty
  Date: 29/12/2018
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
nahit

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/page/home.jsp"/>
<div id="page-wrapper">
    <div class="inner-content">
        <section>
            <div class="col-md-6">
                <p>STATISTIQUE<code>.MENSUEL</code></p>
                <div class="list-group list-group-alternate">
                    <a href="#" class="list-group-item"><span class="badge badge-primary">5021</span> <i
                            class="ti ti-eye"></i> Telechargements </a>
                    <a href="#" class="list-group-item"><span class="badge">14</span> <i
                            class="ti ti-headphone-alt"></i> Upload </a>
                    <a href="#" class="list-group-item"><span class="badge badge-warning">14</span> <i
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
                                <td><a href="#"><i class="lnr lnr-film-play"></i></a></td>
                                <td>
                                    <button>modifier</button>
                                    <button>supprimer</button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </section>
    </div>
</div>
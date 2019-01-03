<%--
  Created by IntelliJ IDEA.
  User: Kitty
  Date: 29/12/2018
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
nahit

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/page/home.jsp"/>
<div id="page-wrapper">
    <div class="inner-content">
<section>
<div class="col-md-6">
    <p>STATISTIQUE<code>.MENSUEL</code></p>
    <div class="list-group list-group-alternate">
        <a href="#" class="list-group-item"><span class="badge">201</span> <i class="ti ti-email"></i> Ecoutes </a>
        <a href="#" class="list-group-item"><span class="badge badge-primary">5021</span> <i class="ti ti-eye"></i> Telechargements </a>
        <a href="#" class="list-group-item"><span class="badge">14</span> <i class="ti ti-headphone-alt"></i> Upload </a>
        <a href="#" class="list-group-item"><span class="badge badge-warning">14</span> <i class="ti ti-bookmark"></i> Favoris </a>
    </div>
</div>

<div class="col-md-6">
    <form action="#" method="post">
        <input type="text" name="fichier" value="">
        <button>Upload</button>

    </form>
    <label>Titre:
        <input value="" type="hidden"></label>
    <br>
    <label>Duree: <input value="" type="hidden"></label><br>
    <label>Artiste: <input value="" type="hidden"></label><br>
    <label>Album: <input value="" type="hidden"></label><br>
    <label>Genre: <input value="" type="hidden"></label><br>
    <label>Annee: <input value="" type="hidden"></label>
    <br>
    <button>Sauvegarder</button>
    <button>Annuler</button>
</div>

    <div class="col-md-6">
        <p>NOS CHANSONS</p>
        <div class="list-group list-group-alternate">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>Listes</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><code>Ellie</code></td>
                    <td><button>modifier</button><button>supprimer</button></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</section>
    </div>
</div>
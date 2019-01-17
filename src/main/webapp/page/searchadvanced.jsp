<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kitty
  Date: 16/01/2019
  Time: 09:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="author" content="colorlib.com">
    <link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet"/>
    <link href="/resources/assets/css/main.css" rel="stylesheet"/>
</head>
<body>

<div class="s01">
    <form action="searchadvanced" method="get">

        <a href="/home">
            <fieldset>
                <legend>KBH's MUSIC</legend>
            </fieldset>
        </a>
        <div class="inner-form">
            <div class="input-field first-wrap">
                <input id="search" type="text" placeholder="Votre Chanson?" name="titre"/>
            </div>

            <div class="input-field second-wrap">
                <input id="location" type="text" placeholder="Artiste" name="artiste"/>
            </div>

            <div class="input-field third-wrap">
                <button class="btn-search" type="submit">Rechercher</button>
            </div>
        </div>
        <hr>
        <h2>RESULTATS DE VOTRE RECHERCHE</h2>
        <div class="tab-content">
            <table border="1">
                <tr>
                    <th>TITRE</th>
                    <th>ARTISTE</th>
                    <th>TAILLE</th>
                </tr>
                <c:forEach items="${val}" var="val">
                    <tr>
                        <td>${val.titre}</td>
                        <td>${val.artiste}</td>
                        <td>${val.duree}</td>
                    </tr>
                </c:forEach>
            </table>

        </div>

    </form>
</div>
</body>
</html>
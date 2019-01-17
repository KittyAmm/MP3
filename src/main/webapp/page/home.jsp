<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<div class="left-side sticky-left-side">

    <!--logo and iconic logo start-->
    <div class="logo">
        <h1><a href="index.html">Mosai<span>c</span></a></h1>
    </div>
    <div class="logo-icon text-center">
        <a href="index.html">M </a>
    </div>
    <!-- /w3l-agile -->
    <!--logo and iconic logo end-->
    <div class="left-side sticky-left-side">

        <div class="logo">
            <h1><a href="index.html">Mosai<span>c</span></a></h1>
        </div>
        <div class="logo-icon text-center">
            <a href="index.html">M </a>
        </div>


        <div class="left-side-inner">
            <ul class="nav nav-pills nav-stacked custom-nav">
                <%--<c:forEach items="${menus}" var="menu">--%>
                <%--<li class="active"><a href="${menu.lien}"><i class="${menu.class}"></i> <span>${menu.nom}</span></a></li>--%>
                <%--</c:forEach>--%>
                <li class="active">
                    <a href="/home">
                        <i class="lnr lnr-home"></i>
                        <span>Home</span></a></li>

                <li><a href="/chanson">
                    <i class="lnr lnr-music-note"></i>
                    <span>Songs</span></a></li>

                <li><a href="/artiste"><i class="lnr lnr-users"></i> <span>Artists</span></a></li>
                <li><a href="/album"><i class="lnr lnr-bookmark"></i> <span>Albums</span></a></li>
                <li><a href="/album"><i class="lnr lnr-book"></i><span>Genres</span></a></li>
                <li><a href="/profil"><i class="lnr lnr-user"></i><span>Profil</span></a></li>
            </ul>
        </div>
        <div class="col-md-4 serch-part">
            <div id="sb-search" class="sb-search">
                <form action="">
                    <input type="text" placeholder="Rechercher" name="search">
                    <button type="submit"><i class="fa fa-search"></i></button>
                </form>
            </div>
        </div>
    </div>

</div>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="home.jsp"/>
<div id="page-wrapper">
    <div class="inner-content">

        <div class="music-left">
            <div class="albums second">
                <div class="tittle-head">
                    <h3 class="tittle">NOS CHANSONS</h3>
                    <div class="clearfix"></div>
                </div>
                <div class="row">
                    <div class="col-md-3 content-grid">
                        <%--<select>
                            <option></option>
                        </select>--%>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <table class="table table-bordered table-responsive">
                            <tr>
                                <th>Titre</th>
                                <th>Lecture</th>
                            </tr>
                            <c:forEach items="${paginations}" var="chanson">
                                <tr>
                                    <td>${chanson.titre}</td>
                                    <td>
                                        <audio controls>
                                            <source src="${chanson.url()}" type="audio/mpeg">
                                        </audio>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                        <nav>
                            <ul class="pagination">
                                <c:forEach var="i" begin="1" end="${nbpage}">
                                    <li><a href="/pagination/${i}">${i}</a></li>
                                </c:forEach>
                            </ul>
                        </nav>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="music-right">
            <div class="albums">
                <div class="tittle-head">
                    <h3 class="tittle">NOUVEAUTE</h3>
                    <div class="clearfix"></div>
                </div>
                <div class="col-md-3 content-grid">
                    <a class="play-icon popup-with-zoom-anim" href="#small-dialog"><img
                            src="../resources/assets/images/v1.jpg" title="allbum-name"></a>
                    <a class="button play-icon popup-with-zoom-anim" href="#small-dialog">Listen now</a>
                </div>

                <div class="clearfix"></div>
            </div>
        </div>
    </div>
    <div class="clearfix"></div>
</div>
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
<jsp:include page="footer.jsp"/>
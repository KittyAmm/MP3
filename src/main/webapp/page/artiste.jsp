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
    <link href="/resources/assets/css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <!-- Custom CSS -->
    <link href="/resources/assets/css/style.css" rel='stylesheet' type='text/css'/>
    <!-- Graph CSS -->
    <link href="/resources/assets/css/font-awesome.css" rel="stylesheet">
    <!-- jQuery -->
    <!-- lined-icons -->
    <link rel="stylesheet" href="/resources/assets/css/icon-font.css" type='text/css'/>
    <!-- //lined-icons -->
    <!-- Meters graphs -->
    <script src="/resources/assets/js/jquery-2.1.4.js"></script>

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

                <div class="row">
                    <div class="col-md-12">
                        <table class="table table-bordered table-responsive">
                            <tr>
                                <th>chanson</th>
                                <th>Play</th>
                            </tr>
                            <c:forEach items="${chanson}" var="chanson">
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

                        <div class="clearfix"></div>
                    </div>
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
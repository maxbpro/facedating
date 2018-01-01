<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>




<%--<spring:url value="/resources/js/jquery/jquery.min.js" var="jquery"/>--%>
<%--<script type="text/javascript" src="${jquery}"></script>--%>



<!-- Js -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> <!-- jQuery Core -->

<!-- Bootstrap -->
<spring:url value="/resources/js/libs/bootstrap.min.js" var="bootstrapmin"/>
<script type="text/javascript" src="${bootstrapmin}"></script>


<!-- WayPoints -->
<spring:url value="/resources/js/libs/waypoints.js" var="waypoints"/>
<script type="text/javascript" src="${waypoints}"></script>


<!-- Waypoints for Header -->
<spring:url value="/resources/js/libs/waypoints-sticky.js" var="waypointssticky"/>
<script type="text/javascript" src="${waypointssticky}"></script>

<!-- Isotope Filter -->
<spring:url value="/resources/js/libs/jquery.isotope.js" var="isotope"/>
<script type="text/javascript" src="${isotope}"></script>

<!-- Fancybox -->
<spring:url value="/resources/js/libs/jquery.fancybox.pack.js" var="fancybox"/>
<script type="text/javascript" src="${fancybox}"></script>

<!-- Fancybox for Media -->
<spring:url value="/resources/js/libs/jquery.fancybox-media.js" var="media"/>
<script type="text/javascript" src="${media}"></script>

<!-- Tweet -->
<spring:url value="/resources/js/libs/jquery.tweet.js" var="tweet"/>
<script type="text/javascript" src="${tweet}"></script>

<!-- Contains: jPreloader, jQuery Easing, jQuery ScrollTo, jQuery One Page Navi -->
<spring:url value="/resources/js/libs/plugins.js" var="plugins"/>
<script type="text/javascript" src="${plugins}"></script>



<spring:url value="/resources/js/libs/modernizr.js" var="modernizr"/>
<script type="text/javascript" src="${modernizr}"></script>


<spring:url value="/resources/js/libs/placeholder.js" var="placeholder"/>
<script type="text/javascript" src="${placeholder}"></script>

<spring:url value="/resources/js/maskedinput/jquery.maskedinput.min.js" var="maskedinput"/>
<script type="text/javascript" src="${maskedinput}"></script>
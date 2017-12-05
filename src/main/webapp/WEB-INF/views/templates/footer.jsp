<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/resources/js/bootstrap/bootstrap.min.js" var="bootstrapJs"/>
<spring:url value="/resources/js/jquery/jquery.min.js" var="jquery"/>
<spring:url value="/resources/js/maskedinput/jquery.maskedinput.min.js" var="maskedinput"/>

<script type="text/javascript" src="${jquery}"></script>
<script type="text/javascript" src="${bootstrapJs}"></script>
<script type="text/javascript" src="${maskedinput}"></script>



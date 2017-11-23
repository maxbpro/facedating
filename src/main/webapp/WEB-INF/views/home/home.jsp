<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<jsp:include page="../templates/header.jsp"/>
<jsp:include page="../fragments/header.jsp"/>

<body>


<div class="container">




</div>





<jsp:include page="../fragments/footer.jsp"/>
<jsp:include page="../templates/footer.jsp"/>

<spring:url value="/resources/js/home.js" var="home"/>
<script type="text/javascript" src="${home}"></script>

</body>

</html>
<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>


<head>
    <jsp:include page="../templates/header.jsp"/>
    <jsp:include page="../fragments/header.jsp"/>
</head>

<body>


<div class="container">

    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert"
                    aria-label="Close">
                <span aria-hidden="true">×</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>

    <h1>Messages</h1>

</div>





<jsp:include page="../fragments/footer.jsp"/>
<jsp:include page="../templates/footer.jsp"/>


<spring:url value="/resources/js/bootstrap-datepicker.js" var="datepicker"/>
<script type="text/javascript" src="${datepicker}"></script>

<spring:url value="/resources/js/profile.js" var="profile"/>
<script type="text/javascript" src="${profile}"></script>


</body>

</html>
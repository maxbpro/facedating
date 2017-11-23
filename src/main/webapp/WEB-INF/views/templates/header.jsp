
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <title>HelloWorld page</title>

    <spring:url value="/resources/css/bootstrap.css" var="bootstrap"/>
    <spring:url value="/resources/css/custom/general.css" var="general"/>
    <link href="${bootstrap}" rel="stylesheet" />
    <link href="${general}" rel="stylesheet" />


</head>



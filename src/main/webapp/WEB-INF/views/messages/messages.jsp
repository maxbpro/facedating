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


    <spring:url value="/resources/css/custom/general.css" var="general"/>
    <link href="${general}" rel="stylesheet" />

    <spring:url value="/resources/css/main.css" var="shutter"/>
    <link href="${shutter}" rel="stylesheet" />

</head>

<body style="background-color: #2f3239">

<!-- This section is for Splash Screen -->
<div class="ole">
    <section id="jSplash">
        <div id="circle"></div>
    </section>
</div>
<!-- End of Splash Screen -->

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

    <div class="container">
        <div class="row page">
            <div class="span1">

                <c:forEach var="item" items="${users}" varStatus="status">

                    <a href="${pageContext.request.contextPath}/messages/${chats[status.index].id}"
                       class="chatperson">

                        <span class="chatimg">
                            <img src="${item.photoUrl}" style="padding-bottom: 20px" />
                        </span>
                    </a>

                </c:forEach>

            </div>
            <div style="position: relative" class="span11">
                <div class="chatbody" style="color: #FFFFFF;font-size: 20px;">

                    <table class="table">

                        <c:forEach var="item" items="${messages}">

                            <tr>

                                <c:choose>
                                    <c:when test="${item.answer eq true}">
                                        <td><img src="${otherPhoto}" class="img-responsive" style="width: 30px; height: 30px"/></td>
                                    </c:when>
                                    <c:otherwise>
                                        <td><img src="${myPhoto}" class="img-responsive" style="width: 30px; height: 30px" /></td>
                                    </c:otherwise>
                                </c:choose>

                                <td>${item.message}</td>
                                <td>
                                    <fmt:formatDate value="${item.createdAt}" pattern="hh:mm" />
                                </td>
                            </tr>

                        </c:forEach>

                    </table>

                </div>

                <div style="margin-top: 150px">

                    <form:form modelAttribute="postForm" action="/messages/${chatId}" id="contact-form" class="contact-form">

                        <div class="row">
                            <div class="span5">
                                <form:input path="message" id="contact_name" style="margin-top: 30px" type="text" placeholder="Enter some text..." />
                            </div>
                            <div class="span2">
                                <button class="submit">Send</button>
                            </div>
                        </div>

                    </form:form>

                </div>




            </div>
        </div>
    </div>

</div>





<jsp:include page="../fragments/footer.jsp"/>
<jsp:include page="../templates/footer.jsp"/>

<!-- Default JS -->
<spring:url value="/resources/js/libs/main_short.js" var="main"/>
<script type="text/javascript" src="${main}"></script>

<spring:url value="/resources/js/messages.js" var="messages"/>
<script type="text/javascript" src="${messages}"></script>


</body>

</html>
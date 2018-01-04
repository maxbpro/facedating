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


    <spring:url value="/resources/css/custom/home.css" var="home"/>
    <link href="${home}" rel="stylesheet" />


</head>

<body style="background-color: #2f3239">

<%--<!-- This section is for Splash Screen -->--%>
<%--<div class="ole">--%>
    <%--<section id="jSplash">--%>
        <%--<div id="circle"></div>--%>
    <%--</section>--%>
<%--</div>--%>
<%--<!-- End of Splash Screen -->--%>


<div class="container"  >

    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" style="margin-top: 30px" role="alert">
            <button type="button" class="close" data-dismiss="alert"
                    aria-label="Close">
                <span aria-hidden="true">×</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>

        <div class="container-fluid zero-pad div-content">

            <div class="row">

                <div  id="sceneView" >

                    <div class="box">
                        <div class="card">
                            <div class="left">
                                <img class="img-responsive"  id="img" alt=""/>
                            </div>

                            <div class="right">
                                <h1 id="userTitle" style="color: #DE5E60">

                                </h1>
                                <em id="professionTitle"></em>
                                <p id="descText" class="bio-text"></p>
                                <button class="btn-bio" id="btnOpen" >Open Profile</button>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <div class="offset3">
            <div id="contact-form">
                <button type="button" class="submit"  id="btnNext">Next Person</button>
            </div>
        </div>

</div>

    <jsp:include page="../fragments/footer.jsp"/>
    <jsp:include page="../templates/footer.jsp"/>


    <spring:url value="/resources/js/home.js" var="home"/>
    <script type="text/javascript" src="${home}"></script>

</body>

</html>
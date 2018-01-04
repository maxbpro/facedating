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

    <spring:url value="/resources/css/custom/profile.css" var="profile"/>
    <link href="${profile}" rel="stylesheet" />

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

    <div class="row" style="color: white">

        <div class="span3">
            <div class="profile" style="background-color: #26292E; padding: 20px; margin-top: 50px">
                <!-- SIDEBAR USERPIC -->
                <div class="profile-userpic text-center">
                    <img src="${photoUrl}" class="img-responsive" height="100px" width="100px" alt="">
                </div>
                <!-- END SIDEBAR USERPIC -->
                <!-- SIDEBAR USER TITLE -->
                <div class="profile-usertitle">
                    <div class="profile-usertitle-name">
                        ${name}
                    </div>
                    <div class="profile-usertitle-job">
                        ${username}
                    </div>
                </div>
                <!-- END SIDEBAR USER TITLE -->
                <!-- SIDEBAR BUTTONS -->
                <div class="profile-userbuttons">


                    <c:choose>
                        <c:when test="${isLiked == true}">
                            <a href="${pageContext.request.contextPath}/profile/removeLike/${senderId}"
                                    class="btn btn-danger btn-sm" id="btnLike">Dislike</a>
                        </c:when>
                        <c:otherwise>
                            <a href="${pageContext.request.contextPath}/profile/addLike/${senderId}"
                                    class="btn btn-success btn-sm" id="btnLike">Like</a>
                        </c:otherwise>
                    </c:choose>

                    <a class="btn btn-primary btn-sm" id="btnMessage" href="${pageContext.request.contextPath}/messages/chat/${senderId}" >Message</a>
                </div>
                <!-- END SIDEBAR BUTTONS -->
                <!-- SIDEBAR MENU -->
                <%--<div class="profile-usermenu">--%>
                    <%--<ul class="nav">--%>
                        <%--<li class="active">--%>
                            <%--<a href="#">--%>
                                <%--<i class="glyphicon glyphicon-home"></i>--%>
                                <%--Overview </a>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                            <%--<a href="#">--%>
                                <%--<i class="glyphicon glyphicon-user"></i>--%>
                                <%--Account Settings </a>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                            <%--<a href="#" target="_blank">--%>
                                <%--<i class="glyphicon glyphicon-ok"></i>--%>
                                <%--Tasks </a>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                            <%--<a href="#">--%>
                                <%--<i class="glyphicon glyphicon-flag"></i>--%>
                                <%--Help </a>--%>
                        <%--</li>--%>
                    <%--</ul>--%>
                <%--</div>--%>
                <!-- END MENU -->
            </div>
        </div>

        <div class="span9 silver" style="margin-top: 20px" >
            <div class="profile-content">

                <div class="col-md-8 col-xs-12 col-sm-6 col-lg-8"  >
                    <div class="container" >
                        <h2>${name}</h2>
                        <p>an    <b> ${profession}</b></p>
                    </div>

                    <div class=" col-md-9 col-lg-9 ">
                        <table class="table table-user-information">
                            <tbody>
                            <tr>
                                <td>Job:</td>
                                <td>${job}</td>
                            </tr>

                            <tr>
                                <td>Date of Birth</td>
                                <td>${birthdate}</td>
                            </tr>

                            <tr>
                            <tr>
                                <td>Gender</td>
                                <td>${gender}</td>
                            </tr>
                            <tr>
                                <td>Country</td>
                                <td>${country}</td>
                            </tr>
                            <tr>
                                <td>City</td>
                                <td>${city}</td>
                            </tr>
                            <tr>
                                <td>Email</td>
                                <td><a href="mailto:${email}">${email}</a></td>
                            </tr>
                            <td>Phone Number</td>
                            <td>${phoneNumber}<br>
                            </td>

                            </tr>

                            </tbody>
                        </table>


                    </div>


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

<spring:url value="/resources/js/profile.js" var="profile"/>
<script type="text/javascript" src="${profile}"></script>




</body>

</html>
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

    <spring:url value="/resources/css/custom/user.css" var="general"/>
    <link href="${general}" rel="stylesheet" />

</head>


<body style="background-color: #2f3239">

<!-- This section is for Splash Screen -->
<%--<div class="ole">--%>
    <%--<section id="jSplash">--%>
        <%--<div id="circle"></div>--%>
    <%--</section>--%>
<%--</div>--%>
<!-- End of Splash Screen -->

<div class="container">


    <spring:url value="/user/updatePhoto" var="photoUpdateUrl" />
    <spring:url value="/user/update" var="userUpdateUrl" />


    <div class="row page" style="margin-top: 50px">

        <!-- left column -->
        <div class="span4">

            <div class="image-wrap">
                <div class="hover-wrap">
                    <span class="overlay-img"></span>
                    <span class="overlay-text-thumb">Photo for comparing</span>
                </div>
                <img src="${userPhotoUrl}" id="img" class="avatar img-thumbnail" alt="avatar">
            </div>

            <div class="text-center">


            </div>

            <form id="contact-form"  method="post" action="${photoUpdateUrl}"
                       enctype="multipart/form-data">

                <div class="text-center">
                    <h6>Add a new photo into Gallery...</h6>
                    <input  type="file" name="inputFile" id="inputFile" class="text-center center-block well well-sm"/>
                </div>

                <button type="submit" class="submit">Update avatar</button>

            </form>

        </div>

        <!-- right column -->
        <div class="span8">


            <form:form id="contact-form" class="contact-form"  role="form" method="post" modelAttribute="userForm" action="${userUpdateUrl}">

                <c:if test="${msg ne null}">
                      
                    <div class="alert alert-info alert-dismissable">
                        <a class="panel-close close" data-dismiss="alert">×</a>
                        <i class="fa fa-coffee"></i>
                            ${msg}
                    </div>

                </c:if>


                <p class="contact-firstname">
                    <form:input path="firstName" class="form-control" id="firstName" placeholder="First Name"  type="text"/>
                    <form:errors path="firstName" />
                </p>

                <p class="contact-lastname">
                    <form:input path="lastName" class="form-control" id="lastName" placeholder="Last Name"  type="text"/>
                    <form:errors path="lastName" />
                </p>



                <p class="contact-email">
                    <form:input readonly="true" path="email" class="form-control" type="text" id="email" placeholder="Email"/>
                    <form:errors path="email" />
                </p>


                <p class="contact-username">
                    <form:input readonly="true" path="username" class="form-control" type="text" id="username" placeholder="username"/>
                    <form:errors path="username" />
                </p>


                <p class="contact-birthday">
                    <form:input class="form-control" path="birthdate" name="birthdate" placeholder="DD/MM/YYY"/>
                    <form:errors path="birthdate" class="control-label" />
                </p>


                <p class="contact-phone">
                    <form:input path="phoneNumber" class="form-control" type="text" id="phoneNumber" placeholder="phone number"/>
                    <form:errors path="phoneNumber" />
                </p>


                <p class="contact-profession">
                    <form:input path="profession" class="form-control" type="text" id="profession" placeholder="Profession"/>
                    <form:errors path="profession" />
                </p>


                <p class="contact-job">
                    <form:input path="job" class="form-control" type="text" id="job" placeholder="Job"/>
                    <form:errors path="job" />
                </p>


                <p class="contact-about">
                    <form:textarea path="about" class="form-control" type="text" id="about" placeholder="About me"/>
                    <form:errors path="about" />
                </p>



                <p class="contact-gender" style="margin-top: 50px" >
                    <form:select class="form-control"
                                 path="gender"  name="gender" items="${genderEnum}"/>
                    <form:errors path="gender" class="control-label" />
                </p>

                <p class="contact-country">
                    <form:select cssClass="form-control" path="countryId"  name="countryId">
                        <%--<form:option value="${countryId}">${countryTitle}</form:option>--%>
                        <form:option value="0">---select---</form:option>
                        <form:options items="${countries}" />
                    </form:select>

                </p>



                <c:choose>
                    <c:when test="${hasRegion}">

                        <p class="contact-region">
                            <form:select cssClass="form-control" path="regionId"  name="regionId">
                                <form:option value="0">---select---</form:option>
                                <form:options items="${regions}" />
                            </form:select>
                        </p>

                    </c:when>
                    <c:otherwise>

                        <p class="contact-region" style="display: none;">
                            <form:select cssClass="form-control" path="regionId"  name="regionId">
                                <form:option value="0">---select---</form:option>
                                <form:options items="${regions}" />
                            </form:select>
                        </p>

                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${hasCity}">

                        <p class="contact-city">
                            <form:select cssClass="form-control" path="cityId"  name="cityId">
                                <form:option value="0">---select---</form:option>
                                <form:options items="${cities}" />
                            </form:select>
                        </p>

                    </c:when>
                    <c:otherwise>

                        <p class="contact-city" style="display: none;">
                            <form:select cssClass="form-control" path="cityId"  name="cityId">
                                <form:option value="0">---select---</form:option>
                                <form:options items="${cities}" />
                            </form:select>
                        </p>

                    </c:otherwise>
                </c:choose>










                <button type="submit" class="submit">Update</button>



            </form:form>

        </div>


    </div>
</div>




<jsp:include page="../fragments/footer.jsp"/>
<jsp:include page="../templates/footer.jsp"/>

<!-- Default JS -->
<spring:url value="/resources/js/libs/main_short.js" var="main"/>
<script type="text/javascript" src="${main}"></script>

<spring:url value="/resources/js/user.js" var="user"/>
<script type="text/javascript" src="${user}"></script>


</body>

</html>
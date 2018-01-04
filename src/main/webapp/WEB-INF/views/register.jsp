<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
    <jsp:include page="./templates/header.jsp"/>
    <jsp:include page="./fragments/header_sign_up.jsp"/>

    <spring:url value="/resources/css/main.css" var="shutter"/>
    <link href="${shutter}" rel="stylesheet" />

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

    <form:form id="contact-form" class="contact-form" role="form" method="post"
               modelAttribute="userForm" action="/register"
               enctype="multipart/form-data">

        <div class="row page">

            <div class="span4 signup-form">

                <div class="text-center profile">
                    <img src="/resources/images/no_photo.jpg" id="img" height="200px" width="200px"
                         class="avatar img-circle img-thumbnail" alt="avatar">
                    <p >Upload a1 photo...</p>

                    <form:input type="file" path="inputFile" id="inputFile"/>
                    <form:errors path="inputFile" />
                </div>

            </div>

            <div class="span8">

                <c:if test="${msg ne null}">
                      
                    <div class="alert alert-danger alert-dismissable">
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
                    <form:input path="email" class="form-control" type="text" id="email" placeholder="Email"/>
                    <form:errors path="email" />
                </p>



                <p class="contact-username">
                    <form:input path="username" class="form-control" type="text" id="username" placeholder="Username"/>
                    <form:errors path="username" />
                </p>



                <p class="contact-password">
                    <form:password path="password" class="form-control"  id="password" placeholder="Password"/>
                    <form:errors path="password" />
                </p>

                <p class="contact-confirm-password">
                    <form:password path="confirmPassword"  class="form-control" id="confirmPassword" placeholder="Confirm Password"/>
                    <form:errors path="confirmPassword" />
                </p>

                <p class="contact-birthdate">
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
                    <form:select cssClass="form-control" path="gender"  name="gender" items="${genderEnum}"/>
                    <form:errors path="gender" class="control-label" />
                </p>



                <p class="contact-country">
                    <form:select cssClass="form-control" path="countryId"  name="countryId">
                        <form:option value="0">---select country---</form:option>
                        <form:options items="${countries}" />
                    </form:select>
                </p>



                <p id="regionBlock" class="contact-region" style="display: none;">
                    <form:select cssClass="form-control" path="regionId"  name="regionId">
                        <form:option value="0">---select region---</form:option>

                    </form:select>
                </p>

                <p id="cityBlock" class="contact-city" style="display: none;">
                    <form:select cssClass="form-control" path="cityId"  name="cityId">
                        <form:option value="0">---select city---</form:option>
                    </form:select>
                </p>




                <div class="form-group">
                    <label class="col-md-3 control-label"></label>
                    <div class="col-md-8">
                        <button type="submit" class="submit">Register</button>
                    </div>
                </div>


            </div>



        </div>





    </form:form>

</div>

    <jsp:include page="fragments/footer.jsp"/>
    <jsp:include page="templates/footer.jsp"/>

    <spring:url value="/resources/js/registration.js" var="registration"/>
    <script type="text/javascript" src="${registration}"></script>


    <!-- Default JS -->
    <spring:url value="/resources/js/libs/main_short.js" var="main"/>
    <script type="text/javascript" src="${main}"></script>

</body>

</html>
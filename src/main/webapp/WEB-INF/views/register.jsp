<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<jsp:include page="templates/header.jsp"/>
<jsp:include page="fragments/header.jsp"/>

<body>

    <div class="container">

        <div class="panel panel-default">

            <div class="panel-body">
                <form:form method="post" modelAttribute="userForm" action="/user/register" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="email">Email address</label>
                        <form:input path="email" type="email" class="form-control" id="email" placeholder="Email"/>
                        <form:errors path="email" />
                    </div>

                    <div class="form-group">
                        <label for="firstName">First Name</label>
                        <form:input path="firstName" type="text" class="form-control" id="firstName" placeholder="First Name"/>
                        <form:errors path="firstName" />
                    </div>

                    <div class="form-group">
                        <label for="lastName">Last Name</label>
                        <form:input path="lastName" type="text" class="form-control" id="lastName" placeholder="Last Name"/>
                        <form:errors path="lastName" />
                    </div>

                    <div class="form-group">
                        <label for="username">Username</label>
                        <form:input path="username" type="text" class="form-control" id="username" placeholder="username"/>
                        <form:errors path="username" />
                    </div>

                    <div class="form-group">
                        <label for="password">Password</label>
                        <form:password path="password"  class="form-control" id="password" placeholder="Password"/>
                        <form:errors path="password" />
                    </div>

                    <div class="form-group">
                        <label for="confirmPassword">Confirm Password</label>
                        <form:password path="confirmPassword"  class="form-control" id="confirmPassword" placeholder="Confirm Password"/>
                        <form:errors path="confirmPassword" />
                    </div>

                    <div class="form-group">
                        <label for="birthdate">Birthdate</label>
                        <form:input class="form-control" path="birthdate" name="birthdate" placeholder="DD/MM/YYY"/>
                        <form:errors path="birthdate" class="control-label" />

                    </div>

                    <div class="form-group">
                        <label for="gender">Gender</label>
                        <form:select cssClass="form-control" path="gender"  name="gender" items="${genderEnum}"/>
                        <form:errors path="gender" class="control-label" />
                    </div>

                    <div class="form-group">
                        <label for="countryId">Country</label>
                        <form:select cssClass="form-control" path="countryId"  name="countryId" items="${countries}"/>
                        <form:errors path="countryId" class="control-label" />
                    </div>

                    <div class="initiallyHidden form-group" id="regionBlock">
                        <label for="regionId">Region</label>
                        <form:select cssClass="form-control" path="regionId"  name="regionId" />
                        <form:errors path="regionId" class="control-label" />
                    </div>

                    <div class="initiallyHidden form-group" id="cityBlock">
                        <label for="cityId">City</label>
                        <form:select cssClass="form-control" path="cityId"  name="cityId" />
                        <form:errors path="cityId" class="control-label" />
                    </div>

                    <div class="form-group">
                        <label for="inputFile">Avatar image</label>
                        <form:input type="file" path="inputFile" id="inputFile"/>
                        <form:errors path="inputFile" />
                    </div>

                    <button type="submit" class="btn btn-default">Submit</button>
                </form:form>

            </div>


        </div>


    </div>


    <jsp:include page="fragments/footer.jsp"/>
    <jsp:include page="templates/footer.jsp"/>

    <spring:url value="/resources/js/bootstrap-datepicker.js" var="datepicker"/>
    <script type="text/javascript" src="${datepicker}"></script>

    <spring:url value="/resources/js/registration.js" var="registration"/>
    <script type="text/javascript" src="${registration}"></script>

</body>

</html>
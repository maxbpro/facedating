<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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

    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert"
                    aria-label="Close">
                <span aria-hidden="true">×</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>

    <h1>Profile</h1>

    <!-- Avatar -->

    <img alt="Avatar" class="img-responsive img-thumbnail" src="${user.photoUrl}" width="400" height="400">

    <spring:url value="/user/${user.id}/updatePhoto" var="photoUpdateUrl" />


    <form:form method="post" action="${photoUpdateUrl}" enctype="multipart/form-data">

        <div class="form-group">
            <input type="file" name="inputFile" id="inputFile"/>
            <button type="submit" class="btn-sm btn-primary">Update avatar</button>
        </div>

    </form:form>



    <!-- Fields -->

    <spring:url value="/user/${user.id}/update" var="actionUrl" />

    <form:form class="form-horizontal" method="post" modelAttribute="user" action="${actionUrl}">

        <spring:bind path="id">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">User Id</label>
                <div class="col-sm-10">
                    <form:input path="id" type="text" readonly="true" class="form-control" id="id"  />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="username">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Username</label>
                <div class="col-sm-10">
                    <form:input path="username" readonly="true" type="text" class="form-control" id="username" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="email">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Email</label>
                <div class="col-sm-10">
                    <form:input path="email" type="email" class="form-control"
                                id="email" placeholder="Email" />
                    <form:errors path="email" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="firstName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">First Name</label>
                <div class="col-sm-10">
                    <form:input path="firstName" type="text" class="form-control"
                                id="firstName" placeholder="First name" />
                    <form:errors path="firstName" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="lastName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Last Name</label>
                <div class="col-sm-10">
                    <form:input path="lastName" type="text" class="form-control"
                                id="lastName" placeholder="Last name" />
                    <form:errors path="lastName" class="control-label" />
                </div>
            </div>
        </spring:bind>


        <spring:bind path="birthdate">

            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Date</label>
                <div class="col-sm-10">
                    <form:input class="form-control" path="birthdate" name="birthdate" placeholder="DD/MM/YYY"/>
                    <form:errors path="birthdate" class="control-label" />
                </div>

            </div>

        </spring:bind>

        <spring:bind path="gender">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Gender</label>
                <div class="col-sm-10">

                    <form:select cssClass="form-control" path="gender"  name="gender" items="${genderEnum}"/>
                    <form:errors path="gender" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="countryId">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Country</label>
                <div class="col-sm-10">
                    <form:select cssClass="form-control" path="countryId"  name="countryId" items="${countries}"/>
                    <form:errors path="countryId" class="control-label" />
                </div>
            </div>
        </spring:bind>


        <spring:bind path="regionId">
            <div class="form-group ${status.error ? 'has-error' : ''}" id="regionBlock">
                <label class="col-sm-2 control-label">Region</label>
                <div class="col-sm-10">
                    <form:select cssClass="form-control" path="regionId"  name="regionId" />
                    <form:errors path="regionId" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="cityId">
            <div class="form-group ${status.error ? 'has-error' : ''}" id="cityBlock">
                <label class="col-sm-2 control-label">City</label>
                <div class="col-sm-10">
                    <form:select cssClass="form-control" path="cityId"  name="cityId" />
                    <form:errors path="cityId" class="control-label" />
                </div>
            </div>
        </spring:bind>


        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn-lg btn-primary pull-right">Update</button>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn-lg btn-primary pull-right">Change password</button>
            </div>
        </div>

    </form:form>

</div>





<jsp:include page="../fragments/footer.jsp"/>
<jsp:include page="../templates/footer.jsp"/>


<spring:url value="/resources/js/bootstrap-datepicker.js" var="datepicker"/>
<script type="text/javascript" src="${datepicker}"></script>

<spring:url value="/resources/js/profile.js" var="profile"/>
<script type="text/javascript" src="${profile}"></script>


</body>

</html>
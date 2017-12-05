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


<body>

<div class="container">


    <spring:url value="/user/updatePhoto" var="photoUpdateUrl" />
    <spring:url value="/user/update" var="userUpdateUrl" />

    <h1 class="page-header">My Profile</h1>
    <div class="row">

        <!-- left column -->
        <div class="col-md-4 col-sm-6 ">

            <div class="text-center">

                <img src="${userPhotoUrl}" id="img" class="avatar img-circle img-thumbnail" alt="avatar">

            </div>

            <form class="form-horizontal"  method="post" action="${photoUpdateUrl}"
                       enctype="multipart/form-data">

                <div class="text-center">
                    <h6>Add a new photo into Gallery...</h6>
                    <input  type="file" name="inputFile" id="inputFile" class="text-center center-block well well-sm"/>
                    <button type="submit" class="btn btn-success">Update avatar</button>
                </div>

            </form>

        </div>

        <!-- right column -->
        <div class="col-md-8 col-sm-6  personal-info">


            <form:form class="form-horizontal" role="form" method="post" modelAttribute="userForm" action="${userUpdateUrl}">

                <c:if test="${msg ne null}">
                      
                    <div class="alert alert-info alert-dismissable">
                        <a class="panel-close close" data-dismiss="alert">×</a>
                        <i class="fa fa-coffee"></i>
                            ${msg}
                    </div>

                </c:if>

                <div class="form-group">
                    <label class="col-lg-3 control-label required-field">First name:</label>
                    <div class="col-lg-8">
                        <form:input path="firstName" class="form-control" id="firstName" placeholder="First Name"  type="text"/>
                        <form:errors path="firstName" />
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-lg-3 control-label required-field">Last name:</label>
                    <div class="col-lg-8">
                        <form:input path="lastName" class="form-control" id="lastName" placeholder="Last Name"  type="text"/>
                        <form:errors path="lastName" />
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-3 control-label required-field">Email:</label>
                    <div class="col-lg-8">
                        <form:input readonly="true" path="email" class="form-control" type="text" id="email" placeholder="Email"/>
                        <form:errors path="email" />
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-3 control-label required-field ">Username:</label>
                    <div class="col-md-8">
                        <form:input readonly="true" path="username" class="form-control" type="text" id="username" placeholder="username"/>
                        <form:errors path="username" />
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-md-3 control-label required-field">Birthdate:</label>
                    <div class="col-md-8">
                        <form:input class="form-control" path="birthdate" name="birthdate" placeholder="DD/MM/YYY"/>
                        <form:errors path="birthdate" class="control-label" />
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-3 control-label">Phone number:</label>
                    <div class="col-md-8">
                        <form:input path="phoneNumber" class="form-control" type="text" id="phoneNumber" placeholder="phone number"/>
                        <form:errors path="phoneNumber" />
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-3 control-label">Gender:</label>
                    <div class="col-md-8">
                        <form:select cssClass="form-control" path="gender"  name="gender" items="${genderEnum}"/>
                        <form:errors path="gender" class="control-label" />
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-md-3 control-label">Country:</label>
                    <div class="col-md-8">
                        <form:select cssClass="form-control" path="countryId"  name="countryId">
                            <%--<form:option value="${countryId}">${countryTitle}</form:option>--%>
                            <form:option value="0">---select---</form:option>
                            <form:options items="${countries}" />
                        </form:select>

                        <form:errors path="countryId" class="control-label" />
                    </div>
                </div>

                <c:choose>
                    <c:when test="${hasRegion}">

                        <div class="form-group" id="regionBlock">
                            <label class="col-md-3 control-label">Region:</label>
                            <div class="col-md-8">

                                <form:select cssClass="form-control" path="regionId"  name="regionId">
                                    <form:option value="0">---select---</form:option>
                                    <form:options items="${regions}" />
                                </form:select>

                                <form:errors path="regionId" class="control-label" />
                            </div>
                        </div>

                    </c:when>
                    <c:otherwise>

                        <div class="initiallyHidden form-group" id="regionBlock">
                            <label class="col-md-3 control-label">Region:</label>
                            <div class="col-md-8">
                                <form:select cssClass="form-control" path="regionId"  name="regionId"/>
                                <form:errors path="regionId" class="control-label" />
                            </div>
                        </div>

                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${hasCity}">

                        <div class="form-group" id="cityBlock">
                            <label class="col-md-3 control-label">City:</label>
                            <div class="col-md-8">

                                <form:select cssClass="form-control" path="cityId"  name="cityId">
                                    <form:option value="0">---select---</form:option>
                                    <form:options items="${cities}" />
                                </form:select>

                                <form:errors path="cityId" class="control-label" />
                            </div>
                        </div>

                    </c:when>
                    <c:otherwise>

                        <div class="initiallyHidden form-group" id="cityBlock">
                            <label class="col-md-3 control-label">City:</label>
                            <div class="col-md-8">

                                <form:select cssClass="form-control" path="cityId"  name="cityId">
                                    <form:option value="0">---select---</form:option>

                                </form:select>

                                <form:errors path="cityId" class="control-label" />
                            </div>
                        </div>

                    </c:otherwise>
                </c:choose>







                <div class="form-group">
                    <label class="col-md-3 control-label">Profession:</label>
                    <div class="col-md-8">
                        <form:input path="profession" class="form-control" type="text" id="profession" placeholder="Profession"/>
                        <form:errors path="profession" />
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-3 control-label">Job:</label>
                    <div class="col-md-8">
                        <form:input path="job" class="form-control" type="text" id="job" placeholder="Job"/>
                        <form:errors path="job" />
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-3 control-label required-field ">About me:</label>
                    <div class="col-md-8">
                        <form:textarea path="about" class="form-control" type="text" id="about" placeholder="About me"/>
                        <form:errors path="about" />
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-md-3 control-label"></label>
                    <div class="col-md-8">
                        <button type="submit" class="btn btn-success">Update</button>
                    </div>
                </div>



            </form:form>

        </div>


    </div>
</div>




<jsp:include page="../fragments/footer.jsp"/>
<jsp:include page="../templates/footer.jsp"/>


<spring:url value="/resources/js/bootstrap-datepicker.js" var="datepicker"/>
<script type="text/javascript" src="${datepicker}"></script>

<spring:url value="/resources/js/user.js" var="user"/>
<script type="text/javascript" src="${user}"></script>


</body>

</html>
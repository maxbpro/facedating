<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
    <jsp:include page="./templates/header.jsp"/>
    <jsp:include page="./fragments/header.jsp"/>
</head>

<body>




<div class="container">


    <c:url value="/login" var="actionUrl"/>
    <c:url value="/register" var="registerUrl"/>

    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info" >
            <div class="panel-heading">
                <div class="panel-title">Sign In</div>
                <div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="#">Forgot password?</a></div>
            </div>



            <div style="padding-top:30px" class="panel-body" >

                <div>
                    <c:if test="${param.error ne null}">
                           <div class="alert alert-danger col-sm-12">Invalid username and password.</div>
                    </c:if>

                      <c:if test="${param.logout ne null}">
                       <div class="alert alert-danger col-sm-12">You have been logged out.</div>
                      </c:if> 
                </div>


                <form:form action="${actionUrl}" class="form-horizontal" method="post" role="form" >

                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input  name="username" id="username" type="text" class="form-control"  value="" placeholder="username">
                    </div>

                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input type="password" class="form-control" name="password" id="password" placeholder="password">
                    </div>



                    <div class="input-group">
                        <div class="checkbox">
                            <label>
                                <input id="login-remember" type="checkbox" name="remember-me"> Remember me
                            </label>
                        </div>
                    </div>


                    <div style="margin-top:10px" class="form-group">
                        <!-- Button -->

                        <div class="col-sm-12 controls">
                            <button type="submit" class="btn btn-success">Login</button>
                        </div>
                    </div>


                    <div class="form-group">
                        <div class="col-md-12 control">
                            <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                                Don't have an account!
                                <a href="${registerUrl}">
                                    Sign Up Here
                                </a>
                            </div>
                        </div>
                    </div>
                </form:form>



            </div>
        </div>
    </div>


</div>




<jsp:include page="fragments/footer.jsp"/>
<jsp:include page="templates/footer.jsp"/>


</body>

</html>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<jsp:include page="templates/header.jsp"/>
<jsp:include page="fragments/header.jsp"/>

<body>


<div class="container">


    <c:url value="/j_spring_security_check" var="actionUrl"/>
    <c:url value="/user/register" var="registerUrl"/>

    <form method="post" action="${actionUrl}">

        <div class="form-group">
            <label for="username">User name</label>
            <input type="username" class="form-control" name="username" id="username" placeholder="Username"/>
        </div>


        <div class="form-group">
            <label for="password">Password</label>
            <input type="password"  class="form-control" name="password" id="password" placeholder="Password"/>
        </div>


        <div class="checkbox">
            <label><input type="checkbox" name="rember-me" > Remember Me</label>
        </div>

        <button type="submit" class="btn btn-default">Login</button>

        <a href="${registerUrl}">Sign up</a>

        <div>
            <c:if test="${param.error ne null}">
                   <div class="alert-danger">Invalid username and password.</div>
                  </c:if>
              <c:if test="${param.logout ne null}">
               <div class="alert-normal">You have been logged out.</div>
              </c:if> 
        </div>

    </form>

</div>





<jsp:include page="fragments/footer.jsp"/>
<jsp:include page="templates/footer.jsp"/>


</body>

</html>
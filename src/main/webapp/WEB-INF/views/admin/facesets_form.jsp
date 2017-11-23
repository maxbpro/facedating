<%@ page session="false"%>
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

    <c:choose>
        <c:when test="${isUpdating}">
            <h1>Update User</h1>
        </c:when>
        <c:otherwise>
            <h1>Add User</h1>
        </c:otherwise>
    </c:choose>
    <br />

    <spring:url value="/admin/faceset" var="actionUrl" />

    <form:form class="form-horizontal" method="post" modelAttribute="facesetDetails" action="${actionUrl}">

        <c:if test="${isUpdating}">

            <spring:bind path="facesetToken">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">Faceset Token</label>
                    <div class="col-sm-10">
                        <form:input path="facesetToken" type="text" class="form-control disable"
                                    id="facesetToken" placeholder="facesetToken" />
                    </div>
                </div>
            </spring:bind>

        </c:if>

        <spring:bind path="displayName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Display Name</label>
                <div class="col-sm-10">
                    <form:input path="displayName" type="text" class="form-control"
                                id="displayName" placeholder="displayName" />
                    <form:errors path="displayName" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="userData">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">User Data</label>
                <div class="col-sm-10">
                    <form:input path="userData" type="text" class="form-control"
                                id="userData" placeholder="userData" />
                    <form:errors path="userData" class="control-label" />
                </div>
            </div>
        </spring:bind>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${isUpdating}">
                        <button type="submit" class="btn-lg btn-primary pull-right">Update</button>
                    </c:when>
                    <c:otherwise>
                        <button type="submit" class="btn-lg btn-primary pull-right">Add</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>

</div>





<jsp:include page="../fragments/footer.jsp"/>
<jsp:include page="../templates/footer.jsp"/>


</body>

</html>
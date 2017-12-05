<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>

<head>
    <jsp:include page="../templates/header.jsp"/>
    <jsp:include page="../fragments/header.jsp"/>
</head>

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

    <h1>Faceset Detail</h1>
    <br />

    <div class="row">
        <label class="col-sm-2">Faceset Token</label>
        <div class="col-sm-10">${facesetDetails.facesetToken}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Display Name</label>
        <div class="col-sm-10">${facesetDetails.displayName}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">User Data</label>
        <div class="col-sm-10">${facesetDetails.userData}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Face Count</label>
        <div class="col-sm-10">${facesetDetails.faceCount}</div>
    </div>

    <h1>Faces List</h1>
    <br />

    <table class="table table-striped">
        <thead>
        <tr>
            <th>#FaceToken</th>
            <th>Action</th>
        </tr>
        </thead>

        <c:forEach var="item" items="${faceTokens}">
            <tr>
                <td>${item}</td>

                <td>
                    <spring:url value="/users/${user.id}" var="userUrl" />
                    <spring:url value="/users/${user.id}/delete" var="deleteUrl" />
                    <spring:url value="/users/${user.id}/update" var="updateUrl" />

                    <button class="btn btn-info"
                            onclick="location.href='${userUrl}'">Query</button>
                    <button class="btn btn-primary"
                            onclick="location.href='${updateUrl}'">Update</button>
                    <button class="btn btn-danger"
                            onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>




<jsp:include page="../fragments/footer.jsp"/>
<jsp:include page="../templates/footer.jsp"/>


</body>

</html>
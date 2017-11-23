<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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

        <h1>All Facesets</h1>


        <table class="table table-striped">
            <thead>
            <tr>
                <th>#FacesetToken</th>
                <th>Display Name</th>
                <th>Action</th>
            </tr>
            </thead>

            <c:forEach var="item" items="${facesets}">
                <tr>
                    <td>${item.facesetToken}</td>
                    <td>${item.displayName}</td>

                    <td>
                        <spring:url value="/admin/faceset/${item.facesetToken}" var="facesetUrl" />
                        <spring:url value="/admin/faceset/${item.facesetToken}/delete" var="deleteUrl" />
                        <spring:url value="/admin/faceset/${item.facesetToken}/update" var="updateUrl" />

                        <button class="btn btn-info"
                                onclick="location.href='${facesetUrl}'">View</button>
                        <button class="btn btn-primary"
                                onclick="location.href='${updateUrl}'">Update</button>
                        <button class="btn btn-danger"
                                onclick="this.disabled=true;location.href='${deleteUrl}'">Delete</button>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </div>




    <jsp:include page="../fragments/footer.jsp"/>
    <jsp:include page="../templates/footer.jsp"/>


</body>

</html>
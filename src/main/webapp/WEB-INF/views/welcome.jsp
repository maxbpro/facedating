<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

    <jsp:include page="templates/header.jsp"/>

    <body>

    <div class="container">

        <div class="jumbotron">
            <h1>Greeting : ${greeting}!</h1>

        </div>


        <div class="container">
            <table id="tableClient" class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th class="col-sm-1" data-field="id">Id</th>
                    <th class="col-sm-3" data-field="email">Email</th>
                    <th class="col-sm-3" data-field="firstName">First Name</th>
                    <th class="col-sm-3" data-field="lastName">Last Name</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${pageInfo.content}" var="item">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.email}</td>
                            <td>${item.firstName}</td>
                            <td>${item.lastName}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </div>


    <c:url var="prevUrl" value="/pages/${currentIndex - 1}" />
    <c:url var="nextUrl" value="/pages/${currentIndex + 1}" />


    <div class="container">
        <ul class="pagination">
            <c:choose>
                <c:when test="${currentIndex == 1}">
                    <li class="page-item disabled"><a href="#">Previous</a></li>
                </c:when>
                <c:otherwise>
                    <li class="page-item"><a href="${prevUrl}">Previous</a></li>
                </c:otherwise>
            </c:choose>
            <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
                <c:url var="pageUrl" value="/pages/${i}" />
                <c:choose>
                    <c:when test="${i == currentIndex}">
                        <li class="page-item active"><a href="${pageUrl}"><c:out value="${i}" /></a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item"><a href="${pageUrl}"><c:out value="${i}" /></a></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:choose>
                <c:when test="${currentIndex == pageInfo.totalPages}">
                    <li class="page-item disabled"><a href="#">Next</a></li>
                </c:when>
                <c:otherwise>
                    <li class="page-item"><a href="${nextUrl}">Next</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>

    <jsp:include page="templates/footer.jsp"/>

    <spring:url value="/resources/js/test_ajax_table.js" var="myJs"/>
    <script type="text/javascript" src="${myJs}"></script>

    </body>

</html>
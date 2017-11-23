<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<nav class="navbar navbar-inverse ">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="${urlHome}">Soulmate</a>
        </div>
        <div id="navbar">
            <ul class="nav navbar-nav navbar-right">

                <c:if test="${not empty addTitle}">
                    <li class="active"><a href="${urlAdd}">${addTitle}</a></li>
                </c:if>

            </ul>
        </div>
    </div>
</nav>
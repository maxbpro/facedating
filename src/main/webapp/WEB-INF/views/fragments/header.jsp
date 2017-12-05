<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--<nav class="navbar navbar-inverse ">--%>
    <%--<div class="container">--%>
        <%--<div class="navbar-header">--%>
            <%--<a class="navbar-brand" href="${urlHome}">Soulmate</a>--%>
        <%--</div>--%>
        <%--<div id="navbar">--%>
            <%--<ul class="nav navbar-nav navbar-right">--%>

                <%--<c:if test="${not empty addTitle}">--%>
                    <%--<li class="active"><a href="${urlAdd}">${addTitle}</a></li>--%>
                <%--</c:if>--%>

            <%--</ul>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</nav>--%>


<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">

            <a class="navbar-brand" href="${pageContext.request.contextPath}/home">
                <img alt="Brand" src="/resources/images/logo.jpg" width="50" height="30">
            </a>


            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Soulmate</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <%--<li ><a href="#">Search <span class="sr-only">(current)</span></a></li>--%>


                    <c:choose>
                        <c:when test="${not empty searchActive}">
                            <li class="active"><a href="${pageContext.request.contextPath}/home">Search</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="${pageContext.request.contextPath}/home">Search</a></li>
                        </c:otherwise>
                    </c:choose>

                    <c:choose>
                        <c:when test="${not empty likesActive}">
                            <li class="active"><a href="${pageContext.request.contextPath}/likes">Likes</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="${pageContext.request.contextPath}/likes">Likes</a></li>
                        </c:otherwise>
                    </c:choose>

                    <c:choose>
                        <c:when test="${not empty messagesActive}">
                            <li class="active"><a href="${pageContext.request.contextPath}/messages">Messages</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="${pageContext.request.contextPath}/messages">Messages</a></li>
                        </c:otherwise>
                    </c:choose>

                    <c:choose>
                        <c:when test="${not empty profileActive}">
                            <li class="active"><a href="${pageContext.request.contextPath}/user">My Profile</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="${pageContext.request.contextPath}/user">My Profile</a></li>
                        </c:otherwise>
                    </c:choose>

            </ul>


            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Link</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/logout">Log out</a></li>
                    </ul>
                </li>
            </ul>

        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<header>
    <div class="sticky-nav">
        <a id="mobile-nav" class="menu-nav" href="#menu-nav"></a>

        <a href="#" ><img src="/resources/img/logo.png" class="img-responsive"
                          style="margin-left: 20px; margin-top: 15px" ></a>

        <nav id="menu">
            <ul id="menu-nav">

                <c:choose>
                    <c:when test="${not empty searchActive}">
                        <li class="current"><a class="external" href="${pageContext.request.contextPath}/home">Search</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a class="external" href="${pageContext.request.contextPath}/home">Search</a></li>
                    </c:otherwise>
                </c:choose>


                <c:choose>
                    <c:when test="${not empty likesActive}">
                        <li class="current"><a class="external" href="${pageContext.request.contextPath}/likes">Likes</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a class="external" href="${pageContext.request.contextPath}/likes">Likes</a></li>
                    </c:otherwise>
                </c:choose>


                <c:choose>
                    <c:when test="${not empty messagesActive}">
                        <li class="current"><a class="external" href="${pageContext.request.contextPath}/messages">Messages</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a class="external" href="${pageContext.request.contextPath}/messages">Messages</a></li>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${not empty profileActive}">
                        <li class="current"><a class="external" href="${pageContext.request.contextPath}/user">My Profile</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a class="external" href="${pageContext.request.contextPath}/user">My Profile</a></li>
                    </c:otherwise>
                </c:choose>

                <li><a class="external" href="${pageContext.request.contextPath}/logout">Log out</a></li>


            </ul>
        </nav>

    </div>
</header>



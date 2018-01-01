<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!-- Header -->
<header>
    <div class="sticky-nav">
        <a id="mobile-nav" class="menu-nav" href="#menu-nav"></a>

        <%--<div id="logo">--%>
            <%--<a id="goUp" href="#home-slider" title="Soulmate | Spring MVC">Soulmate</a>--%>
        <%--</div>--%>

        <a href="#" ><img src="/resources/img/logo.png" class="img-responsive"
                          style="margin-left: 20px; margin-top: 15px" ></a>

        <nav id="menu">
            <ul id="menu-nav">
                <li class="current"><a href="${pageContext.request.contextPath}/register">Sign up</a></li>
                <li><a href="${pageContext.request.contextPath}/login">Home</a></li>
            </ul>
        </nav>

    </div>
</header>
<!-- End Header -->



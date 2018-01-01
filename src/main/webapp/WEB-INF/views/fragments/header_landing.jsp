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
                <li class="current"><a href="#home-slider">Info</a></li>
                <li><a href="#about">About Us</a></li>
                <li><a href="#signin">Sign In</a></li>
                <li><a href="${pageContext.request.contextPath}/register">Sign Up</a></li>
                <li><a href="#contact">Contact</a></li>
            </ul>
        </nav>

    </div>
</header>
<!-- End Header -->



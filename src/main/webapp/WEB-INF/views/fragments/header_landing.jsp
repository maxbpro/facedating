<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!-- Header -->
<header>
    <div class="sticky-nav">
        <a id="mobile-nav" class="menu-nav" href="#menu-nav"></a>

        <%--<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">--%>
            <%--<span class="icon-bar"></span>--%>
            <%--<span class="icon-bar"></span>--%>
            <%--<span class="icon-bar"></span>--%>
        <%--</button>--%>

        <div class="navbar-header pull-left">
            <a class="logo navbar-brand" href="#/">
                <img src="/resources/img/logo.png" class="img-responsive" style="margin-left: 20px; margin-top: 15px" >
                <a class="navbar-brand" style="margin-top: 15px; margin-left: 10px; color: white" href="#">Soulmate</a>
            </a>
        </div>

        <nav id="menu">
            <ul id="menu-nav">
                <li class="current"><a href="#home-slider">Info</a></li>
                <li><a href="#about">About Me</a></li>
                <li><a href="#signin">Sign In</a></li>
                <li><a href="${pageContext.request.contextPath}/register">Sign Up</a></li>
                <li><a href="#contact">Contact</a></li>
            </ul>
        </nav>

    </div>
</header>
<!-- End Header -->



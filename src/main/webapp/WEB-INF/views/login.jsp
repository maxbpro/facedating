<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
    <jsp:include page="./templates/header.jsp"/>
    <jsp:include page="./fragments/header_landing.jsp"/>

    <!-- Supersized -->
    <spring:url value="/resources/css/supersized.css" var="supersized"/>
    <link href="${supersized}" rel="stylesheet" />

    <spring:url value="/resources/css/supersized.shutter.css" var="shutter"/>
    <link href="${shutter}" rel="stylesheet" />


    <spring:url value="/resources/css/main.css" var="shutter"/>
    <link href="${shutter}" rel="stylesheet" />

</head>

<body>

<!-- This section is for Splash Screen -->
<div class="ole">
    <section id="jSplash">
        <div id="circle"></div>
    </section>
</div>
<!-- End of Splash Screen -->

<!-- Homepage Slider -->
<div id="home-slider">
    <div class="overlay"></div>

    <div class="slider-text">
        <div id="slidecaption"></div>
    </div>

    <div class="control-nav">
        <a id="prevslide" class="load-item"><i class="font-icon-arrow-simple-left"></i></a>
        <a id="nextslide" class="load-item"><i class="font-icon-arrow-simple-right"></i></a>
        <ul id="slide-list"></ul>

        <a id="nextsection" href="#work"><i class="font-icon-arrow-simple-down"></i></a>
    </div>
</div>
<!-- End Homepage Slider -->

<!-- About Section -->
<div id="about" class="page-alternate">
    <div class="container">
        <!-- Title Page -->
        <div class="row">
            <div class="span12">
                <div class="title-page">
                    <h2 class="title">About Us</h2>
                    <h3 class="title-description">Learn About our Team &amp; Culture.</h3>
                </div>
            </div>
        </div>
        <!-- End Title Page -->

        <!-- People -->
        <div class="row">

            <!-- Start Profile -->
            <div class="span4 profile">
                <div class="image-wrap">
                    <div class="hover-wrap">
                        <span class="overlay-img"></span>
                        <span class="overlay-text-thumb">Front-end Developer</span>
                    </div>
                    <img src="/resources/img/profile/profile-00.jpg" alt="John Doe">
                </div>
                <h3 class="profile-name">Max Buyanov</h3>
                <p class="profile-description">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas ac augue at erat <a href="#">hendrerit dictum</a>.
                    Praesent porta, purus eget sagittis imperdiet, nulla mi ullamcorper metus, id hendrerit metus diam vitae est. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.</p>

                <div class="social">
                    <ul class="social-icons">
                        <li><a href="#"><i class="font-icon-social-twitter"></i></a></li>
                        <li><a href="#"><i class="font-icon-social-dribbble"></i></a></li>
                        <li><a href="#"><i class="font-icon-social-facebook"></i></a></li>
                    </ul>
                </div>
            </div>
            <!-- End Profile -->

            <!-- Start Profile -->
            <div class="span4 profile">
                <div class="image-wrap">
                    <div class="hover-wrap">
                        <span class="overlay-img"></span>
                        <span class="overlay-text-thumb">Back-end Developer</span>
                    </div>
                    <img src="/resources/img/profile/profile-01.jpg" alt="Jane Helf">
                </div>
                <h3 class="profile-name">Max Buyanov</h3>
                <p class="profile-description">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas ac augue at erat <a href="#">hendrerit dictum</a>.
                    Praesent porta, purus eget sagittis imperdiet, nulla mi ullamcorper metus, id hendrerit metus diam vitae est. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.</p>

                <div class="social">
                    <ul class="social-icons">
                        <li><a href="#"><i class="font-icon-social-twitter"></i></a></li>
                        <li><a href="#"><i class="font-icon-social-email"></i></a></li>
                    </ul>
                </div>
            </div>
            <!-- End Profile -->


        </div>
        <!-- End People -->
    </div>
</div>
<!-- End About Section -->

<!-- Sign in -->
<div id="signin" class="page">

    <div class="container">

        <!-- Title Page -->
        <div class="row">
            <div class="span12">
                <div class="title-page">
                    <h2 class="title">Sign in</h2>
                </div>
            </div>
        </div>
        <!-- End Title Page -->

        <div class="span12">

            <c:url value="/login" var="actionUrl"/>
            <c:url value="/register" var="registerUrl"/>

            <div>
                <c:if test="${param.error ne null}">
                       <div class="alert alert-danger col-sm-12">Invalid username and password.</div>
                </c:if>

                  <c:if test="${param.logout ne null}">
                   <div class="alert alert-danger col-sm-12">You have been logged out.</div>
                  </c:if> 
            </div>

            <form:form action="${actionUrl}" id="contact-form" method="post" role="form" class="contact-form">
                <p class="contact-name">
                    <input id="username" type="text" placeholder="Username" value="" name="username" />
                </p>
                <p class="contact-email">
                    <input id="password" type="password" placeholder="Password" value="" name="password" />
                </p>

                <%--<div class="checkbox signin-form">--%>
                    <%--<input id="login-remember" type="checkbox" name="remember-me"/>--%>
                    <%--<p>Remember me</p>--%>
                <%--</div>--%>


                <p class="contact-submit">
                    <button type="submit" id="contact-submit" class="submit">Login</button>
                </p>

                <div class="input-group">
                    <div class="signin-form">
                        <p>
                            Don't have an account! <a href="${registerUrl}"> Sign Up Here</a>
                        </p>
                    </div>
                </div>

                <div id="response">

                </div>
            </form:form>

        </div>

    </div>
</div>

<!-- Contact Section -->
<div id="contact" class="page">

    <div class="container">
        <!-- Title Page -->
        <div class="row">
            <div class="span12">
                <div class="title-page">
                    <h2 class="title">Get in Touch</h2>
                    <h3 class="title-description">We’re currently accepting new client projects. We look forward to serving you.</h3>
                </div>
            </div>
        </div>
        <!-- End Title Page -->

        <!-- Contact Form -->
        <div class="row">
            <div class="span9">

                <form:form action="/login/feedback" modelAttribute="feedbackModel" id="contact-form" class="contact-form">
                    <p class="contact-name">
                        <form:input path="name" id="contact_name" type="text" placeholder="Full Name" value="" name="name" />
                    </p>
                    <p class="contact-email">
                        <form:input path="email" id="contact_email" type="text" placeholder="Email Address" value="" name="email" />
                    </p>
                    <p class="contact-message">
                        <form:textarea path="message" id="contact_message" placeholder="Your Message" name="message" rows="15" cols="40"></form:textarea>
                    </p>
                    <p class="contact-submit">
                        <button type="submit" id="contact-submit2" class="submit">Send Your Email</button>
                    </p>

                </form:form>

            </div>

            <div class="span3">
                <div class="contact-details">
                    <h3>Contact Details</h3>
                    <ul>
                        <li><a href="#">maxbpro2009@gmail.com</a></li>
                        <li>(928) 444-1873</li>
                        <li>
                            Russia, Krasnodar
                            <br>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- End Contact Form -->

    </div>
</div>
<!-- End Contact Section -->



<jsp:include page="fragments/footer.jsp"/>
<jsp:include page="templates/footer.jsp"/>

<!-- Slider -->
<spring:url value="/resources/js/libs/supersized.3.2.7.min.js" var="supersized"/>
<script type="text/javascript" src="${supersized}"></script>

<%--<!-- Default JS -->--%>
<%--<spring:url value="/resources/js/libs/main.js" var="main"/>--%>
<%--<script type="text/javascript" src="${main}"></script>--%>

<!-- Default JS -->
<spring:url value="/resources/js/libs/main_short.js" var="main"/>
<script type="text/javascript" src="${main}"></script>

</body>

</html>
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
<%--<div class="ole">--%>
    <%--<section id="jSplash">--%>
        <%--<div id="circle"></div>--%>
    <%--</section>--%>
<%--</div>--%>
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
                    <h2 class="title">About Me</h2>
                    <h3 class="title-description">Information about a developer</h3>
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
                    <img src="${pageContext.request.contextPath}/resources/img/profile/profile-00.jpg">
                </div>
                <h3 class="profile-name">Max Buyanov</h3>
                <p class="profile-description"> Frontend skills:</p>
                <p class="profile-description"> F    - MVC Frameworks: Angular.js 1.x</p>
                <p class="profile-description"> F   - Javascript, jquery, ajax</p>
                <p class="profile-description"> F   - HTML5 and css3</p>
                <p class="profile-description"> F    - Adaptive layouts/framework - Bootstrap</p>

                <div class="social">
                    <ul class="social-icons">
                        <li><a href="https://twitter.com/MaxBpro"><i class="font-icon-social-twitter"></i></a></li>
                        <li><a href="https://www.facebook.com/maxb.pro"><i class="font-icon-social-facebook"></i></a></li>
                    </ul>
                </div>
            </div>
            <!-- End Profile -->

            <!-- Start Profile -->
            <div class="span4 profile">
                <div class="image-wrap">
                    <div class="hover-wrap">
                        <span class="overlay-img"></span>
                        <span class="overlay-text-thumb">Spring Developer</span>
                    </div>
                    <img src="${pageContext.request.contextPath}/resources/img/profile/profile-01.jpg">
                </div>
                <h3 class="profile-name">Max Buyanov</h3>
                <p class="profile-description">Knowledge related to Spring development: </p>
                <p class="profile-description">- Servlets, JSP </p>
                <p class="profile-description">- Build tools (Maven and Gradle) </p>
                <p class="profile-description">- Unit Testing Tools (JUnit, TestNG, Mockito) </p>
                <p class="profile-description"> - Spring Boot </p>
                <p class="profile-description"> - Hibernate, Spring Data </p>


                <div class="social">
                    <ul class="social-icons">
                        <li><a href="https://twitter.com/MaxBpro"><i class="font-icon-social-twitter"></i></a></li>
                        <li><a href="https://www.facebook.com/maxb.pro"><i class="font-icon-social-facebook"></i></a></li>
                    </ul>
                </div>
            </div>
            <!-- End Profile -->

            <!-- Start Profile -->
            <div class="span4 profile">
                <div class="image-wrap">
                    <div class="hover-wrap">
                        <span class="overlay-img"></span>
                        <span class="overlay-text-thumb">Mobile Developer</span>
                    </div>
                    <img src="${pageContext.request.contextPath}/resources/img/profile/profile-00.jpg" >
                </div>
                <h3 class="profile-name">Max Buyanov</h3>
                   <p class="profile-description">Tasks successfully coped:</p>
                    <p class="profile-description">- Network interaction</p>
                    <p class="profile-description">- Video/audio/photo editing</p>
                    <p class="profile-description">- Face detection and face recognition</p>
                    <p class="profile-description">- Navigation systems and trackers</p>

                <div class="social">
                    <ul class="social-icons">
                        <li><a href="https://twitter.com/MaxBpro"><i class="font-icon-social-twitter"></i></a></li>
                        <li><a href="https://www.facebook.com/maxb.pro"><i class="font-icon-social-facebook"></i></a></li>
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
                    <h3 class="title-description">Member login</h3>
                </div>
            </div>
        </div>
        <!-- End Title Page -->

        <div class="span12">

            <c:url value="/login" var="actionUrl"/>
            <c:url value="/register" var="registerUrl"/>

            <div>
                <c:if test="${error ne null}">
                       <div class="alert alert-danger col-sm-12">Invalid username and password.</div>
                </c:if>

                  <c:if test="${param.logout ne null}">
                   <div class="alert alert-danger col-sm-12">You have been logged out.</div>
                  </c:if> 
            </div>

            <form:form action="${actionUrl}" method="post" role="form" class="contact-form">
                <p class="contact-name">
                    <input id="username" type="text" placeholder="Username" value="" name="username" />
                </p>
                <p class="contact-email">
                    <input id="password" type="password" placeholder="Password" name="password" />
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
                    <h3 class="title-description">I'm currently accepting new client projects. I look forward to serving you.</h3>
                </div>
            </div>
        </div>
        <!-- End Title Page -->

        <!-- Contact Form -->
        <div class="row">
            <div class="span9">

                <div>
                    <c:if test="${result ne null}">
                           <div class="alert alert-success col-sm-12">Feedback has sent.</div>
                    </c:if>

                </div>

                <form:form action="/login/feedback" modelAttribute="feedbackModel" class="contact-form">
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
<spring:url value="/resources/js/libs/main.js" var="main"/>
<script type="text/javascript" src="${main}"></script>


</body>

</html>
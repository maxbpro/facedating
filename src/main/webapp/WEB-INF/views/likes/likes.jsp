<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>


<head>
    <jsp:include page="../templates/header.jsp"/>
    <jsp:include page="../fragments/header.jsp"/>
</head>

<body style="background-color: #2f3239">

<!-- This section is for Splash Screen -->
<div class="ole">
    <section id="jSplash">
        <div id="circle"></div>
    </section>
</div>
<!-- End of Splash Screen -->

<div class="container">

    <div class="container bg" id="sceneView">

        <div class="row page">

            <!-- Start Profile -->
            <div id="item1" class="span4 profile">
                <div class="image-wrap">
                    <div class="hover-wrap">
                        <span class="overlay-img"></span>
                        <span class="overlay-text-thumb">CTO/Founder</span>
                    </div>
                    <img id="img1" alt="John Doe">
                </div>
                <h3 class="profile-name">
                    <a id="userTitle1"></a>
                </h3>
                <p class="profile-description" id="aboutTitle1"/>

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
            <div id="item2" class="span4 profile">
                <div class="image-wrap">
                    <div class="hover-wrap">
                        <span class="overlay-img"></span>
                        <span class="overlay-text-thumb">Creative Director</span>
                    </div>
                    <img id="img2" alt="Jane Helf">
                </div>
                <h3 class="profile-name">
                    <a id="userTitle2"></a>
                </h3>
                <p class="profile-description" id="aboutTitle2"/>

                <div class="social">
                    <ul class="social-icons">
                        <li><a href="#"><i class="font-icon-social-twitter"></i></a></li>
                        <li><a href="#"><i class="font-icon-social-email"></i></a></li>
                    </ul>
                </div>
            </div>
            <!-- End Profile -->

            <!-- Start Profile -->
            <div id="item3" class="span4 profile">
                <div class="image-wrap">
                    <div class="hover-wrap">
                        <span class="overlay-img"></span>
                        <span class="overlay-text-thumb">Lead Designer</span>
                    </div>
                    <img id="img3" alt="Joshua Insanus">
                </div>
                <h3 class="profile-name">
                    <a id="userTitle3"></a>
                </h3>
                <p class="profile-description" id="aboutTitle3"/>
                <div class="social">
                    <ul class="social-icons">
                        <li><a href="#"><i class="font-icon-social-twitter"></i></a></li>
                        <li><a href="#"><i class="font-icon-social-linkedin"></i></a></li>
                        <li><a href="#"><i class="font-icon-social-google-plus"></i></a></li>
                        <li><a href="#"><i class="font-icon-social-vimeo"></i></a></li>
                    </ul>
                </div>
            </div>
            <!-- End Profile -->

        </div>


        <div class="row page">

            <!-- Start Profile -->
            <div id="item4" class="span4 profile">
                <div class="image-wrap">
                    <div class="hover-wrap">
                        <span class="overlay-img"></span>
                        <span class="overlay-text-thumb">CTO/Founder</span>
                    </div>
                    <img id="img4" alt="John Doe">
                </div>
                <h3 class="profile-name">
                    <a id="userTitle4"></a>
                </h3>
                <p class="profile-description" id="aboutTitle4"/>

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
            <div id="item5" class="span4 profile">
                <div class="image-wrap">
                    <div class="hover-wrap">
                        <span class="overlay-img"></span>
                        <span class="overlay-text-thumb">Creative Director</span>
                    </div>
                    <img id="img5" alt="Jane Helf">
                </div>
                <h3 class="profile-name">
                    <a id="userTitle5"></a>
                </h3>
                <p class="profile-description" id="aboutTitle5"/>

                <div class="social">
                    <ul class="social-icons">
                        <li><a href="#"><i class="font-icon-social-twitter"></i></a></li>
                        <li><a href="#"><i class="font-icon-social-email"></i></a></li>
                    </ul>
                </div>
            </div>
            <!-- End Profile -->

            <!-- Start Profile -->
            <div id="item6" class="span4 profile">
                <div class="image-wrap">
                    <div class="hover-wrap">
                        <span class="overlay-img"></span>
                        <span class="overlay-text-thumb">Lead Designer</span>
                    </div>
                    <img id="img6" alt="Joshua Insanus">
                </div>
                <h3 class="profile-name">
                    <a id="userTitle6"></a>
                </h3>
                <p class="profile-description" id="aboutTitle6"/>
                <div class="social">
                    <ul class="social-icons">
                        <li><a href="#"><i class="font-icon-social-twitter"></i></a></li>
                        <li><a href="#"><i class="font-icon-social-linkedin"></i></a></li>
                        <li><a href="#"><i class="font-icon-social-google-plus"></i></a></li>
                        <li><a href="#"><i class="font-icon-social-vimeo"></i></a></li>
                    </ul>
                </div>
            </div>
            <!-- End Profile -->

        </div>


    </div>


</div>





<jsp:include page="../fragments/footer.jsp"/>
<jsp:include page="../templates/footer.jsp"/>

<!-- Default JS -->
<spring:url value="/resources/js/libs/main_short.js" var="main"/>
<script type="text/javascript" src="${main}"></script>

<spring:url value="/resources/js/likes_page.js" var="likesPage"/>
<script type="text/javascript" src="${likesPage}"></script>


</body>

</html>
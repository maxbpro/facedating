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

    <spring:url value="/resources/css/custom/profile.css" var="profile"/>
    <link href="${profile}" rel="stylesheet" />

</head>

<body>


<div class="container">


    <div class="row">
        <div class="col-md-3">
            <div class="profile-sidebar">
                <!-- SIDEBAR USERPIC -->
                <div class="profile-userpic">
                    <img src="${photoUrl}" class="img-responsive" alt="">
                </div>
                <!-- END SIDEBAR USERPIC -->
                <!-- SIDEBAR USER TITLE -->
                <div class="profile-usertitle">
                    <div class="profile-usertitle-name">
                        ${name}
                    </div>
                    <div class="profile-usertitle-job">
                        ${username}
                    </div>
                </div>
                <!-- END SIDEBAR USER TITLE -->
                <!-- SIDEBAR BUTTONS -->
                <div class="profile-userbuttons">


                    <c:choose>
                        <c:when test="${isLiked == true}">
                            <button type="button" liked="true" likedId="${likedId}" class="btn btn-danger btn-sm" id="btnLike">Dislike</button>
                        </c:when>
                        <c:otherwise>
                            <button type="button" liked="false" class="btn btn-success btn-sm" id="btnLike">Like</button>
                        </c:otherwise>
                    </c:choose>

                    <a class="btn btn-primary btn-sm" id="btnMessage" href="${pageContext.request.contextPath}/messages/chat" >Message</a>
                </div>
                <!-- END SIDEBAR BUTTONS -->
                <!-- SIDEBAR MENU -->
                <%--<div class="profile-usermenu">--%>
                    <%--<ul class="nav">--%>
                        <%--<li class="active">--%>
                            <%--<a href="#">--%>
                                <%--<i class="glyphicon glyphicon-home"></i>--%>
                                <%--Overview </a>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                            <%--<a href="#">--%>
                                <%--<i class="glyphicon glyphicon-user"></i>--%>
                                <%--Account Settings </a>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                            <%--<a href="#" target="_blank">--%>
                                <%--<i class="glyphicon glyphicon-ok"></i>--%>
                                <%--Tasks </a>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                            <%--<a href="#">--%>
                                <%--<i class="glyphicon glyphicon-flag"></i>--%>
                                <%--Help </a>--%>
                        <%--</li>--%>
                    <%--</ul>--%>
                <%--</div>--%>
                <!-- END MENU -->
            </div>
        </div>
        <div class="col-md-9">
            <div class="profile-content">

                <div class="col-md-8 col-xs-12 col-sm-6 col-lg-8" >
                    <div class="container" >
                        <h2>${name}</h2>
                        <p>an   <b> ${profession}</b></p>
                    </div>
                    <hr>


                    <div class=" col-md-9 col-lg-9 ">
                        <table class="table table-user-information">
                            <tbody>
                            <tr>
                                <td>Job:</td>
                                <td>${job}</td>
                            </tr>

                            <tr>
                                <td>Date of Birth</td>
                                <td>${birthdate}</td>
                            </tr>

                            <tr>
                            <tr>
                                <td>Gender</td>
                                <td>${gender}</td>
                            </tr>
                            <tr>
                                <td>Country</td>
                                <td>${country}</td>
                            </tr>
                            <tr>
                                <td>City</td>
                                <td>${city}</td>
                            </tr>
                            <tr>
                                <td>Email</td>
                                <td><a href="mailto:${email}">${email}</a></td>
                            </tr>
                            <td>Phone Number</td>
                            <td>${phoneNumber}<br>
                            </td>

                            </tr>

                            </tbody>
                        </table>


                    </div>


                </div>
            </div>
        </div>
    </div>


    <div class="container">
        <div class="col-md-3">

        </div>

        <div class="col-md-9">

            <div class="gallery">
                <figure>
                    <img src="https://images.unsplash.com/photo-1448814100339-234df1d4005d?crop=entropy&fit=crop&fm=jpg&h=400&ixjsv=2.1.0&ixlib=rb-0.3.5&q=80&w=600" alt="" />
                    <figcaption>Daytona Beach <small>United States</small></figcaption>
                </figure>
                <figure>
                    <img src="https://images.unsplash.com/photo-1443890923422-7819ed4101c0?crop=entropy&fit=crop&fm=jpg&h=400&ixjsv=2.1.0&ixlib=rb-0.3.5&q=80&w=600" alt="" />
                    <figcaption>Териберка, gorod Severomorsk <small>Russia</small></figcaption>
                </figure>

                <figure>
                    <img src="https://images.unsplash.com/photo-1443890923422-7819ed4101c0?crop=entropy&fit=crop&fm=jpg&h=400&ixjsv=2.1.0&ixlib=rb-0.3.5&q=80&w=600" alt="" />
                    <figcaption>Териберка, gorod Severomorsk <small>Russia</small></figcaption>
                </figure>
            </div>

        </div>

    </div>




</div>



<jsp:include page="../fragments/footer.jsp"/>
<jsp:include page="../templates/footer.jsp"/>


<spring:url value="/resources/js/bootstrap-datepicker.js" var="datepicker"/>
<script type="text/javascript" src="${datepicker}"></script>

<spring:url value="/resources/js/profile.js" var="profile"/>
<script type="text/javascript" src="${profile}"></script>


<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" style="display:none;">
    <symbol id="close" viewBox="0 0 18 18">
        <path fill-rule="evenodd" clip-rule="evenodd" fill="#FFFFFF" d="M9,0.493C4.302,0.493,0.493,4.302,0.493,9S4.302,17.507,9,17.507
			S17.507,13.698,17.507,9S13.698,0.493,9,0.493z M12.491,11.491c0.292,0.296,0.292,0.773,0,1.068c-0.293,0.295-0.767,0.295-1.059,0
			l-2.435-2.457L6.564,12.56c-0.292,0.295-0.766,0.295-1.058,0c-0.292-0.295-0.292-0.772,0-1.068L7.94,9.035L5.435,6.507
			c-0.292-0.295-0.292-0.773,0-1.068c0.293-0.295,0.766-0.295,1.059,0l2.504,2.528l2.505-2.528c0.292-0.295,0.767-0.295,1.059,0
			s0.292,0.773,0,1.068l-2.505,2.528L12.491,11.491z"/>
    </symbol>
</svg>

<script src='//production-assets.codepen.io/assets/common/stopExecutionOnTimeout-b2a7b3fe212eaa732349046d8416e00a9dec26eb7fd347590fbced3ab38af52e.js'></script><script src='//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script >popup = {
    init: function(){
        $('figure').click(function(){
            popup.open($(this));
        });

        $(document).on('click', '.popup img', function(){
            return false;
        }).on('click', '.popup', function(){
            popup.close();
        })
    },
    open: function($figure) {
        $('.gallery').addClass('pop');
        $popup = $('<div class="popup" />').appendTo($('body'));
        $fig = $figure.clone().appendTo($('.popup'));
        $bg = $('<div class="bg" />').appendTo($('.popup'));
        $close = $('<div class="close"><svg><use xlink:href="#close"></use></svg></div>').appendTo($fig);
        $shadow = $('<div class="shadow" />').appendTo($fig);
        src = $('img', $fig).attr('src');
        $shadow.css({backgroundImage: 'url(' + src + ')'});
        $bg.css({backgroundImage: 'url(' + src + ')'});
        setTimeout(function(){
            $('.popup').addClass('pop');
        }, 10);
    },
    close: function(){
        $('.gallery, .popup').removeClass('pop');
        setTimeout(function(){
            $('.popup').remove()
        }, 100);
    }
}

popup.init()

//# sourceURL=pen.js
</script>

</body>

</html>
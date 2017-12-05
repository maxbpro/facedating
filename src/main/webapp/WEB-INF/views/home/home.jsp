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

    <spring:url value="/resources/css/custom/home.css" var="home"/>
    <link href="${home}" rel="stylesheet" />

    <spring:url value="/resources/css/rangeslider/nouislider.min.css" var="rangeslider"/>
    <link href="${rangeslider}" rel="stylesheet" />

</head>

<body>


<div class="container">

    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert"
                    aria-label="Close">
                <span aria-hidden="true">×</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>


        <div class="container-fluid zero-pad div-content">

            <div class="col-sm-3 zero-pad">

                <h1>Search</h1>

                <hr/>

                <form action="" method="post">

                    <div class="form-group">
                        <label>Gender</label>

                        <select name="gender" class="form-control input-sm"">
                            <c:forEach var = "item" items="${genderEnum}">
                                <option value = "${item.key}">${item.value}</option>
                            </c:forEach>
                        </select>

                    </div>

                    <div class="form-group">
                        <label>Age</label>
                        <div id="slider"/>
                    </div>



                </form>


            </div>

            <div class="col-sm-9" id="sceneView" >


                <button type="button" class="btn btn-success btn-lg" id="btnNext">Next Person</button>


                <div class="box">
                    <div class="card">
                        <div class="left"><img class="img-responsive"  id="img" src="https://wallpaperscraft.com/image/henry_cavill_actor_owl_photoshoot_111358_750x1334.jpg" alt=""/></div>
                        <div class="right">

                            <h1>
                                <a id="userTitle"></a>
                            </h1>
                            <em id="professionTitle"></em>
                            <p id="descText" class="bio-text"></p>
                            <button class="btn-bio" id="btnOpen" >Open Profile</button>
                        </div>
                    </div>
                </div>
            </div>


</div>





        <jsp:include page="../fragments/footer.jsp"/>
        <jsp:include page="../templates/footer.jsp"/>



        <spring:url value="/resources/js/home.js" var="home"/>
        <script type="text/javascript" src="${home}"></script>

        <spring:url value="/resources/js/rangeslider/nouislider.min.js" var="rangeslider"/>
        <script type="text/javascript" src="${rangeslider}"></script>

        <spring:url value="/resources/js/wNumb/wNumb.js" var="wNumb"/>
        <script type="text/javascript" src="${wNumb}"></script>



</body>

</html>
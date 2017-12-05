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

<body>


<div class="container">

    <div class="container bg" id="sceneView">

        <div class="row" id="row1">
            <div class="col-md-6" id="item1">
                <div class="well well-sm">
                    <div class="row">
                        <div class="col-xs-3 col-md-3 text-center">
                            <img id="img1" src="http://bootsnipp.com/apple-touch-icon-114x114-precomposed.png" alt="bootsnipp"
                                 class="img-rounded img-responsive" />
                        </div>
                        <div class="col-xs-9 col-md-9 section-box">
                            <h3>
                                <a id="userTitle1" >Bootsnipp</a>
                            </h3>
                            <p id="aboutTitle1"></p>
                            <hr />

                            <button type="submit" id="btnDislike1" class="btn-sm btn-danger">Dislike</button>

                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6" id="item2">
                <div class="well well-sm">
                    <div class="row">
                        <div class="col-xs-3 col-md-3 text-center">
                            <img  id="img2" src="http://bootsnipp.com/apple-touch-icon-114x114-precomposed.png" alt="bootsnipp"
                                 class="img-rounded img-responsive" />
                        </div>
                        <div class="col-xs-9 col-md-9 section-box">
                            <h3>
                                <a id="userTitle2"></a>
                            </h3>
                            <p id="aboutTitle2"></p>
                            <hr />

                            <button type="submit" id="btnDislike2" class="btn-sm btn-danger">Dislike</button>

                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row" id="row2">
            <div class="col-md-6" id="item3">
                <div class="well well-sm">
                    <div class="row">
                        <div class="col-xs-3 col-md-3 text-center">
                            <img id="img3" src="http://bootsnipp.com/apple-touch-icon-114x114-precomposed.png" alt="bootsnipp"
                                 class="img-rounded img-responsive" />
                        </div>
                        <div class="col-xs-9 col-md-9 section-box">
                            <h3>
                                <a id="userTitle3"></a>
                            </h3>
                            <p id="aboutTitle3"></p>
                            <hr />

                            <button type="submit" id="btnDislike3" class="btn-sm btn-danger">Dislike</button>

                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6" id="item4">
                <div class="well well-sm">
                    <div class="row">
                        <div class="col-xs-3 col-md-3 text-center">
                            <img id="img4" src="http://bootsnipp.com/apple-touch-icon-114x114-precomposed.png" alt="bootsnipp"
                                 class="img-rounded img-responsive" />
                        </div>
                        <div class="col-xs-9 col-md-9 section-box">
                            <h3>
                                <a id="userTitle4"></a>
                            </h3>
                            <p id="aboutTitle4"></p>
                            <hr />

                            <button type="submit" id="btnDislike4" class="btn-sm btn-danger">Dislike</button>

                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row" id="row3">
            <div class="col-md-6" id="item5">
                <div class="well well-sm">
                    <div class="row">
                        <div class="col-xs-3 col-md-3 text-center">
                            <img id="img5" src="http://bootsnipp.com/apple-touch-icon-114x114-precomposed.png" alt="bootsnipp"
                                 class="img-rounded img-responsive" />
                        </div>
                        <div class="col-xs-9 col-md-9 section-box">
                            <h3>
                                <a id="userTitle5"></a>
                            </h3>
                            <p id="aboutTitle5"></p>
                            <hr />

                            <button type="submit" id="btnDislike5" class="btn-sm btn-danger">Dislike</button>

                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6" id="item6">
                <div class="well well-sm">
                    <div class="row">
                        <div class="col-xs-3 col-md-3 text-center">
                            <img id="img6" src="http://bootsnipp.com/apple-touch-icon-114x114-precomposed.png" alt="bootsnipp"
                                 class="img-rounded img-responsive" />
                        </div>
                        <div class="col-xs-9 col-md-9 section-box">
                            <h3>
                                <a id="userTitle6"></a>
                            </h3>
                            <p id="aboutTitle6"></p>
                            <hr />

                            <button type="submit" id="btnDislike6" class="btn-sm btn-danger">Dislike</button>

                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>


</div>





<jsp:include page="../fragments/footer.jsp"/>
<jsp:include page="../templates/footer.jsp"/>


<spring:url value="/resources/js/likes_page.js" var="likesPage"/>
<script type="text/javascript" src="${likesPage}"></script>


</body>

</html>
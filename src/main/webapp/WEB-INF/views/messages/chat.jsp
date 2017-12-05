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

    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert"
                    aria-label="Close">
                <span aria-hidden="true">×</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>

    <h1>Chat</h1>

    <div class="container">
        <div class="row">
            <div class="col-sm-4">
                <a href="?msg=15" class="chatperson">
                    <span class="chatimg">
                        <img src="http://via.placeholder.com/50x50?text=A" alt="" />
                    </span>
                    <div class="namechat">
                        <div class="pname">Aperson name here</div>
                        <div class="lastmsg">sdk nskdfjnlssdf sdf ss fsdaf kjlsadjf nkksaddbhk jasddl sdf kjsdfoashf89f sdbfoi nkksaddbhk jasddl</div>
                    </div>
                </a><a href="?msg=16" class="chatperson">
                    <span class="chatimg">
                        <img src="http://via.placeholder.com/50x50?text=D" alt="" />
                    </span>
                <div class="namechat">
                    <div class="pname">D personname</div>
                    <div class="lastmsg">sdk nskdfjnlssdf sdf ss fsdaf kjlsadjf nkksaddbhk jasddl sdf kjsdfoashf89f sdbfoi nkksaddbhk jasddl</div>
                </div>
            </a><a href="?msg=17" class="chatperson">
                    <span class="chatimg">
                        <img src="http://via.placeholder.com/50x50?text=W" alt="" />
                    </span>
                <div class="namechat">
                    <div class="pname">WWW</div>
                    <div class="lastmsg">sdk nskdfjnlssdf sdf ss fsdaf kjlsadjf nkksaddbhk jasddl sdf kjsdfoashf89f sdbfoi nkksaddbhk jasddl</div>
                </div>
            </a>
            </div>
            <div class="col-sm-8">
                <div class="chatbody">

                    <table class="table">
                        <tr>
                            <td><img src="http://via.placeholder.com/50x50?text=A" /></td>
                            <td>sdk fnsdkjnsadjnlk anflkjasdnflk kjasndlkfjnsdfs adfjksd ofh saddf lsdnflksnadl fjnasdfl ajsndflkja nlnfsdjlnf aslnfd as</td>
                            <td>15:20</td>
                        </tr>

                        <tr>
                            <td><img src="http://via.placeholder.com/50x50?text=B" /></td>
                            <td>sdk fnsdkjnsadjnlk adfjksd ofh saddf lsdnflksnadl fjnasdfl ajsndflkja nlnfsdjlnf aslnfd as</td>
                            <td>15:20</td>
                        </tr>

                        <tr>
                            <td><img src="http://via.placeholder.com/50x50?text=A" /></td>
                            <td>sdk fnsdkjnsadjnlk anflkjasdnflk kjasndl sdflksnfl jsdkfjsafkjsnd fnsalddf sdjdknkfjnsdfs adfjksd ofh saddf lsdnflksnadl fjnasdfl ajsndflkja nlnfsdjlnf aslnfd as</td>
                            <td>15:20</td>
                        </tr>

                        <tr>
                            <td><img src="http://via.placeholder.com/50x50?text=B" /></td>
                            <td>sdk sf s aslnfd as</td>
                            <td>15:20</td>
                        </tr>

                        <tr>
                            <td><img src="http://via.placeholder.com/50x50?text=A" /></td>
                            <td>sdk fnsdkjnsadjnlk anflkjasdnflk c vlsndl v slkdknf sdkmnfkfsndf kasndfllk asnddlflkn sadfn  sadn sandf sadf sajdf sdf sdflksnfl jsdkfjsafkjsnd fnsalddf sdjdknkfjnsdfs adfjksd ofh saddf lsdnflksnadl fjnasdfl ajsndflkja nlnfsdjlnf aslnfd as</td>
                            <td>15:20</td>
                        </tr>
                    </table>

                </div>

                <div class="row">
                    <div class="col-xs-9">
                        <input type="text" placeholder="Yozing..." class="form-control" />
                    </div>
                    <div class="col-xs-3">
                        <button class="btn btn-info btn-block">Send</button>
                    </div>
                </div>

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


</body>

</html>
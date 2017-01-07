<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Title</title>
    <link href=<c:url value="/resources/css/bootstrap.css"/> rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/">Главная</a></li>

            </ul>
        </div><!--/.nav-collapse -->
    </div><!--/.container-fluid -->
</nav>

    <c:if test="${not empty message}">
        <div class="alert alert-success">
                ${message}
        </div>
    </c:if>

    <c:choose>
        <c:when test="${not empty listRequest}">
            <table  class="table table-striped">
                <thead>
                <tr>
                    <td>№ п/п</td>
                    <td>Имя</td>
                    <td>№ клиента</td>
                    <td></td>

                </tr>
                </thead>
                <c:forEach var="request" items="${listRequest}">
                    <tr>
                        <td>${request.id}</td>
                        <td>${request.friend}</td>
                        <td>${request.customerId}</td>
                        <td>



                                <f:form method="POST" modelAttribute="request" action="/seeRequest" data-toggle="validator" >

                                    <input type="hidden" id="id" name="id" value="${request.id}">
                                    <input type="hidden" id="customerId" name="customerId" value="${request.customerId}">
                                    <input type="hidden" id="friend" name="friend" value="${request.friend}">
                                    <div class="form-group col-xs-4">
                                        <button type="submit" class="btn btn-primary  btn-md">Регистрация</button>
                                    </div>
                                </f:form>








                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <br>
            <div class="alert alert-info">
                Ни одного друга не найдено
            </div>
        </c:otherwise>
    </c:choose>


<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src=<c:url value="/resources/js/bootstrap.min.js"/>></script>
</body>
</html>

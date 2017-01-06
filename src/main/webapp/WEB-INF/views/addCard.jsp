<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <link href=
          <c:url value="/resources/css/bootstrap.css"/> rel="stylesheet">
</head>
<body>
<div class="container">
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


    <f:form method="POST" modelAttribute="card" action="/addCard" data-toggle="validator">

        <c:if test="${not empty message}">
            <div class="alert alert-success">
                    ${message}
            </div>
        </c:if>

        <f:hidden path="invoceId"/>
        <h2>Добавить новую карту</h2>
        <div class="form-group col-xs-4">
            <label for="validOf" class="control-label col-xs-4">Срок (лет)</label>
            <input type="text" name="validOf" id="validOf" class="form-control" required="true"/>

            <label for="currency" class="control-label col-xs-4">Валюта</label>
            <select name="currency" id="currency" class="form-control" required="true">
                <c:forEach var="item" items="${curr}">
                    <option>
                        <c:out value="${item}"/>
                    </option>
                </c:forEach>
            </select>

            <br></br>
            <button type="submit" class="btn btn-primary  btn-md">Добавить</button>
        </div>

    </f:form>
</div>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src=<c:url value="/resources/js/bootstrap.min.js"/>></script>
</body>
</html>


<%--

<f:form method="POST" modelAttribute="card" action="/addCard">
    <table>
        <tr>
            <td>
                <f:hidden path="invoceId"/>
            </td>

        </tr>
        <tr>
            <td>
                <i>Valid_of:</i>
            </td>

            <td>
                <f:input path="validOf"/>
            </td>
        </tr>
        <tr>
            <td>
                <i>Currency:</i>
            </td>

            <td>
                <f:select path="currency">
                    <c:forEach var="item" items="${curr}">
                        <option>
                            <c:out value="${item}" />
                        </option>
                    </c:forEach>
                </f:select>

            </td>
        </tr>
        <tr>
            <td>
                <input type="submit"/>
            </td>
        </tr>
    </table>
</f:form>


--%>
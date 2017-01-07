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
                <a class="navbar-brand" href="/">Internet Bank</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/">Главная</a></li>

                </ul>
            </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
    </nav>

<f:form method="POST" commandName="addCustomer" action="addCustomer" data-toggle="validator" >

    <c:if test="${not empty message}">
        <div class="alert alert-success">
                ${message}
        </div>
    </c:if>

    <h2>Добавить клиента</h2>
        <div class="form-group col-xs-4">
            <label for="name" class="control-label col-xs-4">Имя:</label>
            <input type="text" name="name" id="name" class="form-control" required="true"/>

            <label for="login" class="control-label col-xs-4">Логин:</label>
            <input type="text"  pattern="[a-zA-Z0-9]+" minlength="3" maxlength="10" name="login" id="login" class="form-control" required="true"/>

            <label for="passw" class="control-label col-xs-4">Пароль:</label>
            <input type="password"  pattern="[a-zA-Z0-9]+" minlength="6" maxlength="10" name="passw" id="passw" class="form-control" required="true"/>

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

<f:form method="POST" commandName="addCustomer" action="addCustomer">
    <table>
        <tr>
            <td>
                <i>Name:</i>
            </td>
            <td>
                <f:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <i>Login:</i>
            </td>
            <td>
                <f:input path="login"/>
            </td>
        </tr>
        <tr>
            <td>
                <i>Password:</i>
            </td>
            <td>
                <f:password path="passw"/>
            </td>
        </tr>
        <tr>
            <td><input type="submit"/></td>
        </tr>
    </table>
</f:form>


--%>

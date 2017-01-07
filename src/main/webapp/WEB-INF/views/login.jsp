<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Simple Login Form</title>
    <meta charset="UTF-8" />
    <link href=<c:url value="/resources/css/bootstrap.css"/> rel="stylesheet">
    <link href=<c:url value="/resources/css/css-login/reset.css"/> rel="stylesheet">

</head>
<body>
<div class="container">

<f:form name="submitForm" method="POST" cssClass="form-signin">
        <h2 class="form-signin-heading">Пожалуйста, авторизуйтесь</h2>
        <label for="login" class="sr-only">Логин</label>
        <input type="text" name="login" id="login" class="form-control" placeholder="login" required autofocus>
        <label for="passw" class="sr-only">Password</label>
        <input type="password" name="passw" id="passw" class="form-control" placeholder="password" required>
        <br></br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
</f:form>

</div> <!-- /container -->


<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src=<c:url value="/resources/js/bootstrap.min.js"/>></script>
</body>
</html>


<%--


<f:form name="submitForm" method="POST" cssClass="box login">
    <fieldset class="boxBody">
        <label>Пожалуйста, авторизуйтесь</label>
        <input type="text" name="login" tabindex="1" placeholder="Имя пользователя" required>
        <input type="password" name="passw" tabindex="2" placeholder="Пароль" required>
    </fieldset>
    <footer>
        <input type="submit" class="btnLogin" value="Войти" tabindex="4">
    </footer>
</f:form>

--%>


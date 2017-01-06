<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Simple Login Form</title>
    <meta charset="UTF-8" />
    <link href=<c:url value="/resources/css/bootstrap.css"/> rel="stylesheet">
    <link  href=<c:url value="/resources/css/css-login/structure.css"/> rel="stylesheet">
    <link  href=<c:url value="/resources/css/css-login/reset.css"/> rel="stylesheet">
</head>
<body>
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


<script src=<c:url value="/resources/js/bootstrap.min.js"/>></script>
</body>
</html>



<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Simple Web Application</title>
</head>

<body>

<h2>Internet BANK. net cracker</h2>

<ul>
    //Работник
    <li><a href="<c:url value="/employed"/>">Enter for Employed</a></li>
    //Клиент
    <li><a href="<c:url value="/customer"/>">Enter for Customer</a></li>
</ul>

</body>
</html>

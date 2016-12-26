<%--
  Created by IntelliJ IDEA.
  User: Mihalych
  Date: 18.12.2016
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
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
    <li><a href="<c:url value="/customer"/>">for Customer</a></li>
    <li><a href="<c:url value="#"/>">for Employed</a>
</ul>

</body>
</html>

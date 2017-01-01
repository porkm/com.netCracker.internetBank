
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page to Customer</title>
</head>
<body>
<ul>
    <li><a href="<c:url value="/"/>">Home</a></li>
</ul>
<a href="<c:url value="/personal/${actionEmployed.id}"/>">Personal Area</a>
</body>
</html>
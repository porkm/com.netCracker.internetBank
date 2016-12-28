

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <li><a href="<c:url value="/"/>">Home</a></li>
    <li><a href="<c:url value="/addCustomer"/>">Add new customer</a></li>
</ul>

<table>
    <thead>
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Login</td>
        <td>Password</td>
        <td>Add new card<</td>
        <td>Add new credit</td>
        <td>See all request</td>

    </tr>
    </thead>
    <c:forEach items="${action}" var="actionEmployed">
    <tr>
        <td>${actionEmployed.id}</td>
        <td>${actionEmployed.name}</td>
        <td>${actionEmployed.login}</td>
        <td>${actionEmployed.passw}</td>

        <td><a href="<c:url value="/addCard/${actionEmployed.id}"/>">Add new card</a></td>
        <td><a href="<c:url value="/addCredit?id=${actionEmployed.id}"/>">Add one credit</a></td>
        <td><a href="<c:url value="#"/>">See all request</a></td>

        </tr>
    </c:forEach>
</table>


</body>
</html>



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
    <li><a href="<c:url value="/customer.html"/>">Add new customer</a></li>
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
    <c:forEach items="${action}" var="actionCustomer">
    <tr>
        <td>${actionCustomer.id}</td>
        <td>${actionCustomer.name}</td>
        <td>${actionCustomer.login}</td>
        <td>${actionCustomer.passw}</td>

        <td><a href="<c:url value="/addCard?id=${actionCustomer.id}"/>">Add new card</a></td>
        <td><a href="<c:url value="#"/>">See all credit</a></td>
        <td><a href="<c:url value="#"/>">See all request</a></td>

        </tr>
    </c:forEach>
</table>


</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: porkm
  Date: 29.12.2016
  Time: 1:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>list Invoices</title>
</head>
<body>

<a href="<c:url value="/addCard/${id}"/>">Add new card</a>
<table>
    <thead>
    <tr>
        <td>number</td>
        <td>validOf</td>
        <td>Currency</td>
        <td>Balance</td>
        <td>IdInvoices</td>

    </tr>
    </thead>
    <c:forEach items="${listCards}" var="card">
        <tr>
            <td>${card.number}</td>
            <td>${card.validOf}</td>
            <td>${card.currency}</td>
            <td>${card.balance}</td>
            <td>${card.invoceId}</td>

        </tr>

    </c:forEach>
</table>

</body>
</html>

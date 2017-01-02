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

<a href="<c:url value="/addCredit/${id}"/>">Add new credit</a>
<table>
    <thead>
    <tr>
        <td>id</td>
        <td>sumCredit</td>
        <td>percentRate</td>
        <td>dayOfPay</td>
        <td>pay</td>
        <td>overPay</td>
        <td>creditStart</td>
        <td>creditTerm</td>
        <td>customerId</td>
    </tr>
    </thead>
    <c:forEach items="${listCredit}" var="credit">
        <tr>
            <td>${credit.id}</td>
            <td>${credit.sumCredit}</td>
            <td>${credit.percentRate}</td>
            <td>${credit.dayOfPay}</td>
            <td>${credit.pay}</td>
            <td>${credit.overPay}</td>
            <td>${credit.creditStart}</td>
            <td>${credit.creditTerm}</td>
            <td>${credit.customerId}</td>
        </tr>

    </c:forEach>
</table>

</body>
</html>

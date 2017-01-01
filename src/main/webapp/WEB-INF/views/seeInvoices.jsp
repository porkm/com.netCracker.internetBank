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
<a href="<c:url value="/addNewInvoice/${customer.id}"/>">Add new Invoice</a>
<table>
    <thead>
    <tr>
        <td>Id</td>
        <td>Balance</td>
        <td>CustomerId</td>
        <td>Get list Card<</td>
    </tr>
    </thead>
    <c:forEach items="${action}" var="customer">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.balance}</td>
            <td>${customer.customerId}</td>

            <td><a href="<c:url value="/seeCard/${customer.id}"/>">See list card</a></td>


        </tr>
    </c:forEach>
</table>

</body>
</html>

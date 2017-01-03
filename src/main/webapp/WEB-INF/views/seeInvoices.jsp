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
<a href="<c:url value="/addInvoice/${id}"/>">Add new Invoice</a>
<table>
    <thead>
    <tr>
        <td>Id</td>
        <td>Balance</td>
        <td>CustomerId</td>
        <td>Get list Card<</td>
        <td>Make Transfer<</td>
    </tr>
    </thead>
    <c:forEach items="${listInvoices}" var="invoice">
        <tr>
            <td>${invoice.id}</td>
            <td>${invoice.balance}</td>
            <td>${invoice.customerId}</td>

            <td><a href="<c:url value="/seeCard/${invoice.id}"/>">See list card</a></td>

            <td><a href="<c:url value="/makeTransfer/${invoice.id}"/>">Make Transfer</a></td>


        </tr>
    </c:forEach>
</table>

</body>
</html>

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

<a href="<c:url value="/addCard/${action.get(0).invoceId}"/>">Add new card</a>
<table>
    <thead>
    <tr>
        <td>number</td>
        <td>valisOf</td>
        <td>IdInvoices</td>

    </tr>
    </thead>
    <c:forEach items="${action}" var="customer">
        <tr>
            <td>${customer.number}</td>
            <td>${customer.validOf}</td>
            <td>${customer.invoceId}</td>
        </tr>

    </c:forEach>
</table>

</body>
</html>

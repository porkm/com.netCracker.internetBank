

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>actionCustomer</title>
</head>
<body>
<ul>
    <li><a href="<c:url value="/"/>">Home</a></li>

</ul>

<ul>
    <li>
        <a href="<c:url value="/seeInvoices/${userId}"/>">See Invoices</a> <%--and here Make InvoiceUtil --%>
    </li>
    <li>
        <a href="<c:url value="/seeCredit/${userId}"/>">See Credit</a>
    </li>
    <li>
        <a href="<c:url value="/addFriend/${userId}"/>">Add friend</a>
    </li>
</ul>



</body>
</html>



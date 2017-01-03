

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

</ul>

<ul>
    <li>
        <a href="<c:url value="/seeInvoices/${user}"/>">See Invoices</a>
    </li>
    <li>
        <a href="<c:url value="/getTranfer/${user}"/>">Make Transfer</a>
    </li>
    <li>
        <a href="<c:url value="/seeCredit/${user}"/>">See Credit</a>
    </li>
    <li>
        <a href="<c:url value="/addFriend/${user}"/>">Add friend</a>
    </li>
</ul>



</body>
</html>

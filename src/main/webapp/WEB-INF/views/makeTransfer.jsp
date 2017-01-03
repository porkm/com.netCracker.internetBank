<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: porkm
  Date: 29.12.2016
  Time: 0:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Add new Customer</h1>
<f:form method="POST" modelAttribute="transferDTO" action="/makeTransfer">
    <table>
        <tr>
            <td>
                <i>to User (login) - toInvoiceId:</i>
            </td>
            <td>
                    <%-- Сделать выпадающий список --%>
                <f:input path="toInvoiceId"/>
            </td>
        </tr>
        <tr>
            <td>
                <i>Money :</i>
            </td>
            <td>
                <f:input path="money"/>
            </td>
        </tr>
        <tr>
            <td>
                <f:hidden path="fromInvoiceId"/>
            </td>
        </tr>
        <tr>
            <td><input type="submit"/></td>
        </tr>
    </table>
</f:form>
</body>
</html>

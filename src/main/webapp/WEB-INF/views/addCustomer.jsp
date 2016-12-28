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
<f:form method="POST" commandName="addCustomer" action="addCustomer">
    <table>
        <tr>
            <td>
                <i>Name:</i>
            </td>
            <td>
                <f:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <i>Login:</i>
            </td>
            <td>
                <f:input path="login"/>
            </td>
        </tr>
        <tr>
            <td>
                <i>Password:</i>
            </td>
            <td>
                <f:input path="passw"/>
            </td>
        </tr>
        <tr>
            <td><input type="submit"/></td>
        </tr>
    </table>
</f:form>
</body>
</html>

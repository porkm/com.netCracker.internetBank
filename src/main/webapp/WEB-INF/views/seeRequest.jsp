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
<f:form method="POST" modelAttribute="credit"   action="/addCredit">
    <table>
        <tr>
            <td>
                <i>SumCredit:</i>
            </td>
            <td>
                <f:input path="sumCredit"/>
            </td>
        </tr>
        <tr>
            <td>
                <i>dayOfPay</i>
            </td>
            <td>
                    <%--<f:input path="creditStart"/>--%>
                <input type="date" name="dayOfPay"/>
            </td>
        </tr>
        <tr>
            <td>
                <i>creditStart</i>
            </td>
            <td>
                    <%--<f:input path="creditStart"/>--%>
                <input type="date" name="creditStart"/>
            </td>
        </tr>
        <tr>
            <td>
                <i>CreditTerm:</i>
            </td>
            <td>
                <f:input path="creditTerm"/>
            </td>
        </tr>
        <tr>
            <td>
                <f:hidden path="customerId"/>
            </td>
        </tr>

        <tr>
            <td><input type="submit"/></td>
        </tr>
    </table>
</f:form>
</body>
</html>

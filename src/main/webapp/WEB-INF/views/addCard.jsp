<%--
  Created by IntelliJ IDEA.
  User: porkm
  Date: 27.12.2016
  Time: 1:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Add new Card</h1>
<f:form method="POST" modelAttribute="card" action="/addCard">
    <table>
        <tr>
            <td>
                <f:hidden path="invoceId"/>
            </td>

        </tr>
        <tr>
            <td>
                <i>Valid_of:</i>
            </td>

            <td>
                    <%--<f:input path="validOf"/>--%>

            </td>
        </tr>
        <tr>
            <td>
                <input type="submit"/>
            </td>
        </tr>
    </table>
</f:form>


</body>
</html>

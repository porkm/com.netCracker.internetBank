<%--
  Created by IntelliJ IDEA.
  User: porkm
  Date: 27.12.2016
  Time: 1:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
                <f:input path="validOf"/>
            </td>
        </tr>
        <tr>
            <td>
                <i>Currency:</i>
            </td>

            <td>
                <f:select path="currency">
                    <c:forEach var="item" items="${curr}">
                        <option>
                            <c:out value="${item}" />
                        </option>
                    </c:forEach>
                </f:select>

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

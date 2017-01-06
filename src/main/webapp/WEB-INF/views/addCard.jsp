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
    <link href= <c:url value="/resources/css/bootstrap.css"/> rel="stylesheet">
</head>
<body>

<h2>Добавить новую карту</h2>

<div class="container">
    <f:form method="POST" modelAttribute="card" data-toggle="validator" action="/addCard">
        <%--<c:if test ="${empty card}">--%>
        <%--<c:set var="card" value="add"/>--%>
        <%--</c:if>--%>
        <input type="hidden" id="invoceId" name="invoceId" value="${card.invoceId}">

        <div class="form-group col-xs-4">
            <label for="validOf" class="control-label col-xs-4">Срок(год)</label>
            <input type="text" pattern="^\d{1}" maxlength="1" name="validOf" id="validOf" class="form-control"
                   required="true"/>
            <label for="validOf" class="control-label col-xs-4">Валюта</label>
            <f:select path="currency" cssClass="form-control">
                <c:forEach var="item" items="${curr}">
                    <option>
                        <c:out value="${item}"/>
                    </option>
                </c:forEach>
            </f:select>

            <br></br>

            <button type="submit" class="btn btn-primary  btn-md">Добавить карту</button>
        </div>
    </f:form>

</div>

<script src=<c:url value="/resources/js/bootstrap.min.js"/>></script>
</body>
</html>


<%--

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


--%>
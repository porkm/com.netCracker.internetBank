<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>Title</title>

    <link href= <c:url value="/resources/css/bootstrap.css"/> rel="stylesheet">
</head>
<body>
<div class="container">
    <h2>Панель управления</h2>

    <!--Employees List-->
    <c:if test="${not empty message}">
        <div class="alert alert-success">
                ${message}
        </div>
    </c:if>


    <table class="table table-striped">
        <thead>
        <tr>
            <td>#</td>
            <td>Имя</td>
            <td>Логин</td>
            <td>Пароль</td>
            <td>Добавить карту<</td>
            <td>Добавить кредит</td>
            <td>Смотреть заявки</td>
        </tr>
        </thead>
        <c:forEach items="${customerList}" var="actionCustomer">
            <tr>
                <td>${actionCustomer.id}</td>
                <td>${actionCustomer.name}</td>
                <td>${actionCustomer.login}</td>
                <td><a href="<c:url value="/changePassw/${actionCustomer.id}"/>">Изменить</a></td>

                <td><a href="<c:url value="/seeInvoices/${actionCustomer.id}"/>">Счета</a></td>
                <td><a href="<c:url value="/seeCredit/${actionCustomer.id}"/>">Кредиты</a></td>
                <td><a href="<c:url value="/seeRequest/${actionCustomer.id}"/>">Заявки</a></td>

            </tr>
        </c:forEach>
    </table>

</div>
<script src=<c:url value="/resources/js/bootstrap.min.js"/>></script>
</body>

</html>

<%--
<body>
<ul>
    <li><a href="<c:url value="/"/>">Home</a></li>
    <li><a href="<c:url value="/addCustomer"/>">Add new customer</a></li>
</ul>




</body>
<table>
    <thead>
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Login</td>
        <td>Password</td>
        <td>Add new card<</td>
        <td>Add new credit</td>
        <td>See all request</td>

    </tr>
    </thead>
    <c:forEach items="${customerList}" var="actionCustomer">
        <tr>
            <td>${actionCustomer.id}</td>
            <td>${actionCustomer.name}</td>
            <td>${actionCustomer.login}</td>
            <td>${actionCustomer.passw}</td>

            <td><a href="<c:url value="/seeInvoices/${actionCustomer.id}"/>">See all Invoices</a></td>
            <td><a href="<c:url value="/seeCredit/${actionCustomer.id}"/>">See all credit</a></td>
            <td><a href="<c:url value="/seeRequest/${actionCustomer.id}"/>">See all request</a></td>

        </tr>
    </c:forEach>
</table>




--%>

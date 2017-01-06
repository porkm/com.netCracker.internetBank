<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <title>list Invoices</title>

    <link href= <c:url value="/resources/css/bootstrap.css"/> rel="stylesheet">

</head>

<body>

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="brand" href="#">Project name</a>
            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li class="active"><a href="#">Главная</a></li>
                    <li><a href="/actionEmployed">Работники</a></li>
                    <li><a href="/actionCustomer">Клиенты</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </div>
</div>

<div class="container">
    <h2>Список Кредитов</h2>

    <!--Employees List-->
    <c:if test="${not empty message}">
        <div class="alert alert-success">
                ${message}
        </div>
    </c:if>
        <c:choose>
            <c:when test="${not empty listCredit}">
                <table  class="table table-striped">
                    <thead>
                    <tr>
                        <td>#</td>
                        <td>Сумма кредита</td>
                        <td>Процентная ставка</td>
                        <td>День платежа</td>
                        <td>Платеж</td>
                        <td>Переплата</td>
                        <td>Начало кредита</td>
                        <td>Срок кредита</td>
                        <td>№ Клиент</td>
                    </tr>
                    </thead>
                    <c:forEach var="credit" items="${listCredit}">

                        <tr>
                            <td>${credit.id}</td>
                            <td>${credit.sumCredit}</td>
                            <td>${credit.percentRate}</td>
                            <td>${credit.dayOfPay}</td>
                            <td>${credit.pay}</td>
                            <td>${credit.overPay}</td>
                            <td>${credit.creditStart}</td>
                            <td>${credit.creditTerm}</td>
                            <td>${credit.customerId}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <br>
                <div class="alert alert-info">
                    Ни одного кредита не найдено
                </div>
            </c:otherwise>
        </c:choose>
    </form>
    <form action ="/addCredit/${id}">
        <br></br>
        <button type="submit" class="btn btn-primary  btn-md">Взять кредит</button>
    </form>
</div>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src=<c:url value="/resources/js/bootstrap.min.js"/>></script>
</body>

</html>


<%--


<body>

<a href="<c:url value="/addCredit/${id}"/>">Add new credit</a>
<table>
    <thead>
    <tr>
        <td>id</td>
        <td>sumCredit</td>
        <td>percentRate</td>
        <td>dayOfPay</td>
        <td>pay</td>
        <td>overPay</td>
        <td>creditStart</td>
        <td>creditTerm</td>
        <td>customerId</td>
    </tr>
    </thead>
    <c:forEach items="${listCredit}" var="credit">
        <tr>
            <td>${credit.id}</td>
            <td>${credit.sumCredit}</td>
            <td>${credit.percentRate}</td>
            <td>${credit.dayOfPay}</td>
            <td>${credit.pay}</td>
            <td>${credit.overPay}</td>
            <td>${credit.creditStart}</td>
            <td>${credit.creditTerm}</td>
            <td>${credit.customerId}</td>
        </tr>

    </c:forEach>
</table>

</body>

--%>
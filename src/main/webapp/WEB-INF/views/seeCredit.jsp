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

<div class="container">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/">Internet Bank</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/">Главная</a></li>

                </ul>
            </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
    </nav>

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
                        <td></td>
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
                            <td>
                                <c:if test="${not empty userId}">
                                    <form action ="/makeNextPay/${credit.id}">
                                        <br></br>
                                        <button type="submit" class="btn btn-primary  btn-md">Сделать платеж</button>
                                    </form>
                                </c:if>
                            </td>
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




    <c:choose>
        <c:when test="${empty userId}">

            <form action ="/addCredit/${id}">
                <br></br>
                <button type="submit" class="btn btn-primary  btn-md">Выдать кредит</button>
            </form>

        </c:when>
        <c:otherwise>

        </c:otherwise>
    </c:choose>










































</div>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src=<c:url value="/resources/js/bootstrap.min.js"/>></script>
</body>

</html>


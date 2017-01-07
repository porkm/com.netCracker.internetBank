<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <title>list Invoices</title>
    <link href=<c:url value="/resources/css/bootstrap.css"/> rel="stylesheet">
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

    <h2>Список кредитных карт</h2>

    <!--Employees List-->
    <c:if test="${not empty message}">
        <div class="alert alert-success">
                ${message}
        </div>
    </c:if>
    <c:choose>
        <c:when test="${not empty listCards}">
            <table  class="table table-striped">
                <thead>
                <tr>
                    <td>Номер карты</td>
                    <td>Срок действия</td>
                    <td>Валюта</td>
                    <td>Баланс</td>
                    <td>№ счета</td>
                </tr>
                </thead>
                <c:forEach var="card" items="${listCards}">

                    <tr>
                        <td>${card.number}</td>
                        <td>${card.validOf}</td>
                        <td>${card.currency}</td>
                        <td>${card.balance}</td>
                        <td>${card.invoceId}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <br>
            <div class="alert alert-info">
                Ни одной карты не найдено
            </div>
        </c:otherwise>
    </c:choose>
    </form>
    <form action ="/addCard/${id}">
        <br></br>
        <button type="submit" class="btn btn-primary  btn-md">Добавить карту</button>
    </form>
</div>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src=<c:url value="/resources/js/bootstrap.min.js"/>></script>

</body>
</html>



<%--


<table>
    <thead>
    <tr>
        <td>number</td>
        <td>validOf</td>
        <td>Currency</td>
        <td>Balance</td>
        <td>IdInvoices</td>

    </tr>
    </thead>
    <c:forEach items="${listCards}" var="card">
        <tr>
            <td>${card.number}</td>
            <td>${card.validOf}</td>
            <td>${card.currency}</td>
            <td>${card.balance}</td>
            <td>${card.invoceId}</td>

        </tr>

    </c:forEach>
</table>



--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Счета</title>
    <link  href=<c:url value="/resources/css/bootstrap.css"/> rel="stylesheet">

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
                <a class="navbar-brand" href="#">Project name</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/">Главная</a></li>

                </ul>
            </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
    </nav>

    <h2>Список счетов</h2>


    <!--List-->
    <c:if test="${not empty message}">
        <div class="alert alert-success">
                ${message}
        </div>
    </c:if>

        <c:choose>
            <c:when test="${not empty listInvoices}">
                <table  class="table table-striped">
                    <thead>
                    <tr>
                        <td>№п/п</td>
                        <td>Баланс</td>
                        <td>№ клиента</td>
                        <td>Смотреть</td>
                        <td>Действия</td>
                    </tr>
                    </thead>
                    <c:forEach var="invoice" items="${listInvoices}">
                        <tr>
                            <td>${invoice.id}</td>
                            <td>${invoice.balance}</td>
                            <td>${invoice.customerId}</td>
                            <td><a href="<c:url value="/seeCard/${invoice.id}"/>">Список карт</a></td>
                            <td><a href="<c:url value="/makeTransfer/${invoice.id}"/>">Перевести деньги</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <br>
            <div class="alert alert-info">
                Ни одного счета не найдено
            </div>
        </c:otherwise>
        </c:choose>
    <form action ="/addInvoice/${id}">
        <br></br>
        <button type="submit" class="btn btn-primary  btn-md">Добавить счет</button>
    </form>
</div>


<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src=<c:url value="/resources/js/bootstrap.min.js"/>></script>
</body>
</html>


<%--
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <fieldset>
                <legend>Employee Details</legend>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <td>№п/п</td>
                        <td>Баланс</td>
                        <td>№ клиента</td>
                        <td>Смотреть<</td>
                        <td>Действия<</td>
                    </tr>
                    </thead>
                    <c:forEach items="${listInvoices}" var="invoice">
                        <tr>
                            <td>${invoice.id}</td>
                            <td>${invoice.balance}</td>
                            <td>${invoice.customerId}</td>
                            <td><a href="<c:url value="/seeCard/${invoice.id}"/>">Список карт</a></td>
                            <td><a href="<c:url value="/makeTransfer/${invoice.id}"/>">Перевести деньги</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </fieldset>
        </div>
    </div>
</div>


--%>





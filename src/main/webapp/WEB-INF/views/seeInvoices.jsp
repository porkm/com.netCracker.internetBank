
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Список счетов</title>
    <link  href=<c:url value="/resources/css/bootstrap.css"/> rel="stylesheet">

    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/">Интернет банк</a>
            </div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li><a href="/">Главная</a></li>
                    <li class="active"><a href="/customer">Клиент</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </div>

</head>

<body>

<a href="<c:url value="/addInvoice/${id}"/>">Добавить новый счет</a>
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

</body>
</html>





<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Title</title>

    <link href= <c:url value="/resources/css/bootstrap.css"/> rel="stylesheet">
</head>
<body>

<div class="container">

    <!-- Static navbar -->
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
            <td>Добавить карту</td>
            <td>Добавить кредит</td>
        </tr>
        </thead>
        <c:forEach items="${customerList}" var="actionCustomer">
            <tr>
                <td>${actionCustomer.id}</td>
                <td>${actionCustomer.name}</td>
                <td>${actionCustomer.login}</td>


                <td><a href="<c:url value="/seeInvoices/${actionCustomer.id}"/>">Счета</a></td>
                <td><a href="<c:url value="/seeCredit/${actionCustomer.id}"/>">Кредиты</a></td>


            </tr>
        </c:forEach>
    </table>

    <form action ="/addCustomer">
        <br></br>
        <button type="submit" class="btn btn-primary  btn-md">Добавить клиента</button>
    </form>
    <br> </br>
    <form action ="/seeRequest">
        <button type="submit" class="btn btn-primary  btn-md">Смотреть заявки</button>
    </form>

</div>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src=<c:url value="/resources/js/bootstrap.min.js"/>></script>
</body>

</html>

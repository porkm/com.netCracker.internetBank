<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Title</title>
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
                <a class="navbar-brand" href="#">Project name</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/">Главная</a></li>

                </ul>
            </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
    </nav>

<f:form method="POST" modelAttribute="transferDTO" action="/makeTransfer" data-toggle="validator" >
        <c:if test="${not empty errorTransfer}">
            <div class="alert alert-success">
                    ${errorTransfer}
            </div>
        </c:if>


    <f:hidden path="fromInvoiceId"/>

        <div class="form-group col-xs-4">
            <label for="toInvoiceId" class="control-label col-xs-4">Введите номер счета</label>
            <input type="text" pattern="^\d+$" name="toInvoiceId" id="toInvoiceId" class="form-control"  required="true"/>



            <label for="money" class="control-label col-xs-4">Сумма для перевода(руб)</label>
            <input type="text"  pattern="^\d+$" name="money" id="money" class="form-control" required="true"/>


            <br></br>
            <button type="submit" class="btn btn-primary  btn-md">Перевести</button>
        </div>
</f:form>
</div>




<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src=<c:url value="/resources/js/bootstrap.min.js"/>></script>
</body>
</html>


<%--



<f:form method="POST" modelAttribute="transferDTO" action="/makeTransfer">
    <table>
        <tr>
            <td>
                <i>to User (login) - toInvoiceId:</i>
            </td>
            <td>

<f:input path="toInvoiceId"/>
</td>
</tr>
<tr>
    <td>
        <i>Money :</i>
    </td>
    <td>
        <f:input path="money"/>
    </td>
</tr>
<tr>
    <td>
        <f:hidden path="fromInvoiceId"/>
    </td>
</tr>
<tr>
    <td><input type="submit"/></td>
</tr>
</table>
<div style="color: red">${errorTransfer}</div>
</f:form>


--%>

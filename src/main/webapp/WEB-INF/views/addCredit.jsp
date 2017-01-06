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

<f:form method="POST" modelAttribute="credit"   action="/addCredit" >

    <c:if test="${not empty message}">
        <div class="alert alert-success">
                ${message}
        </div>
    </c:if>

    <f:hidden path="customerId"/>

        <h2>Взять кредит</h2>
        <div class="form-group col-xs-4">
            <label for="sumCredit" class="control-label col-xs-4">Сумма кредита:</label>
            <input type="text" pattern="\-?\d+(\.\d{0,})?" maxlength="10" name="sumCredit" id="sumCredit" class="form-control"  required="true"/>


            <label for="creditStart" class="control-label col-xs-4">Начало кредита</label>
            <input type="date"   name="creditStart"  id="creditStart" class="form-control"  placeholder="yyyy-MM-dd" required="true"/>

            <label for="dayOfPay" class="control-label col-xs-4">Дата платежа</label>
            <input type="date"   name="dayOfPay"  id="dayOfPay" class="form-control"  placeholder="yyyy-MM-dd" required="true"/>

            <label for="creditTerm" class="control-label col-xs-4">Срок кредита:</label>
            <input type="text" pattern="^\d+$" name="creditTerm" id="creditTerm" class="form-control"  required="true"/>


            <br></br>
            <button type="submit" class="btn btn-primary  btn-md">Оформить</button>
        </div>
</f:form>
</div>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src=<c:url value="/resources/js/bootstrap.min.js"/>></script>
</body>
</html>


<%--


<h1>Add new Customer</h1>
<f:form method="POST" modelAttribute="credit"   action="/addCredit">
    <table>
        <tr>
            <td>
                <i>SumCredit:</i>
            </td>
            <td>
                <f:input path="sumCredit"/>
            </td>
        </tr>
        <tr>
            <td>
                <i>dayOfPay</i>
            </td>
            <td>

<input type="date" name="dayOfPay"/>
</td>
</tr>
<tr>
    <td>
        <i>creditStart</i>
    </td>
    <td>

        <input type="date" name="creditStart"/>
    </td>
</tr>
<tr>
    <td>
        <i>CreditTerm:</i>
    </td>
    <td>
        <f:input path="creditTerm"/>
    </td>
</tr>
<tr>
    <td>
        <f:hidden path="customerId"/>
    </td>
</tr>

<tr>
    <td><input type="submit"/></td>
</tr>
</table>
</f:form>



--%>

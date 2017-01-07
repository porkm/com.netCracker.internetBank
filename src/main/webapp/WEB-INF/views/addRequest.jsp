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
                <a class="navbar-brand" href="/">Internet Bank</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/">Главная</a></li>

                </ul>
            </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
    </nav>


<f:form method="POST" modelAttribute="request" action="/addRequest" data-toggle="validator" >
    <c:if test="${not empty message}">
        <div class="alert alert-success">
                ${message}
        </div>
    </c:if>

    <f:hidden path="customerId"/>
    <h2>Зарегистрировать друга</h2>
    <div class="form-group col-xs-4">
        <label for="friend" class="control-label col-xs-4">Имя друга:</label>
        <input type="text" pattern="[a-zA-Z]+" minlength="3" maxlength="20" name="friend" id="friend" class="form-control" required="true"/>



        <br></br>
        <button type="submit" class="btn btn-primary  btn-md">Заявка</button>
    </div>
</f:form>
</div>



<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src=<c:url value="/resources/js/bootstrap.min.js"/>></script>
</body>
</html>


<%--



<f:form method="POST" modelAttribute="invoice" action="/addInvoice">
    <table>
        <tr>
            <td>
                <i>Balance:</i>
            </td>
            <td>
                <f:input path="balance"/>
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
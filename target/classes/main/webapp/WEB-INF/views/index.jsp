<%--
  Created by IntelliJ IDEA.
  User: Mihalych
  Date: 18.12.2016
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Index Page</title>
</head>

<body>
<spring:form method="post"  modelAttribute="userJSP" action="check-user">

    Name: <spring:input path="login"/>   <br/>
    Password: <spring:input path="passw"/>   <br/>
    <spring:button>Next Page</spring:button>

</spring:form>

</body>

</html>

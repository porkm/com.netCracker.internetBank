
<%--
  Created by IntelliJ IDEA.
  User: porkm
  Date: 28.12.2016
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" modelAttribute="userForm" action="${userActionUrl}">
    <form:input path="name" type="text" /> <!-- bind to user.name-->
    <form:errors path="name" />
</form:form>

</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
<c:url value="/add" var="var"/>
<form action="${var}" method="POST">
    <input type="hidden" name="id" value="${user.id}">

    <label for="username">Username</label>
    <input type="text" name="username" id="username">

    <label for="password">Password</label>
    <input type="password" name="password" id="password">

    <label for="age">Age</label>
    <input type="text" name="age" id="age">

    <input type="submit" value="Add user">
</form>
</body>
</html>
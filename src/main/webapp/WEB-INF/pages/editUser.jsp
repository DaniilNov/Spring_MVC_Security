<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<c:url value="/edit" var="var"/>
<form action="${var}" method="POST">
    <input type="hidden" name="id" value="${user.id}">

    <label for="username">Username</label>
    <input type="text" name="username" id="username" value="${user.username}">

    <label for="password">Password</label>
    <input type="text" name="password" id="password" value="${user.password}">

    <label for="age">Age</label>
    <input type="text" name="age" id="age" value="${user.age}">

    <input type="submit" value="Edit user">
</form>
</body>
</html>
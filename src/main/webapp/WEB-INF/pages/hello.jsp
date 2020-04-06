<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<%@page isELIgnored="false" %>
<html>
<body>
<div align="center">
<table border="1" cellpadding="5">
    <caption><h2>Users</h2></caption>
    <tr>
        <th>Ваше имя</th>
        <th>Ваш пароль</th>
        <th>Ваш возраст</th>
        <th>Ваша роль</th>



    <tr>
        <td>${user.username}</td>
        <td>${user.password}</td>
        <td>${user.age}</td>
        <td><c:forEach items="${user.roles}" var="role">${role.name}; </c:forEach></td>
    </tr>

    </tr>
</table>
<form action="/logout" method="post">
    <input type="submit" value="Выйти"/>
</form>
</div>
</body>
</html>

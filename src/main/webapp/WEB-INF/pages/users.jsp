<%@ page import="java.util.Locale" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Users</h2></caption>
        <tr>
            <th>Id</th>
            <th>Username</th>
            <th>Role</th>
            <th>Age</th>
            <th>Password</th>
            <th>Action</th>

            <c:forEach items="${listUsers}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td> <c:forEach items="${user.roles}" var="role">${role.name}; </c:forEach></td>
            <td>${user.age}</td>
            <td>${user.password}</td>
            <td>
                <a href="/users/edit/${user.id}">Edit</a>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <a href="/users/remove/${user.id}">Delete</a>
            </td>
        </tr>
        </c:forEach>
        </tr>
    </table>
    <h2>Add</h2>
    <c:url value="/users/add" var="add"/>
    <a href="${add}">Add new user</a>
</body>
</html>
</div>
<form action="/logout"  method="post">
    <input type="submit" value="Выйти"/>
</form>
</body>
</html>

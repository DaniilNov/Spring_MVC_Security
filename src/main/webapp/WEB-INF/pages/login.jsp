<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="/login">

    <div><label> User Name : <input type="text" name="j_username"/> </label></div>
    <div><label> Password: <input type="password" name="j_password"/> </label></div>
    <div><input type="submit" value="Sign In"/></div>
    <%--<input name="j_username"/>--%>
    <%--<input name="j_password"/>--%>
    <%--<input type="submit"/>--%>

</form>

<%--<h2>Регистрация</h2>--%>
<%--<c:url value="/registration" var="registration"/>--%>
<%--<a href="${registration}">Зарегистрироваться</a>--%>

</body>
</html>

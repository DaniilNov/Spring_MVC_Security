<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<body>
<h1>${mess}</h1>
<form action="/logout"  method="post">
    <input type="submit" value="Выйти"/>
</form>
</body>
</html>

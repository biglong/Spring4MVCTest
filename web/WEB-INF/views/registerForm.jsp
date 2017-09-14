<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: huangshaolong
  Date: 2017/9/7
  Time: 上午9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style/style.css" />">
</head>
<body>
    <H1>Register</H1>
    <form method="post">
        First Name: <input type="text" name="firstName" > <br/>
        Last Name: <input type="text" name="lastName" > <br/>
        Username: <input type="text" name="lastName" > <br/>
        Password: <input type="text" name="lastName" > <br/>
        <input type="submit" value="Register">
    </form>
</body>
</html>
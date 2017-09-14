<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: huangshaolong
  Date: 2017/9/7
  Time: 下午5:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
    <h1>Your Profile</h1>
    <c:out value="${spitter.username}"/> <<br/>
    <c:out value="${spitter.firstName}"/> <<br/>
    <c:out value="${spitter.lastName}"/> <<br/>
</body>
</html>

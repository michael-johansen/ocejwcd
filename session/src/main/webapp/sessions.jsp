<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<jsp:useBean id="user" class="java.lang.String" scope="session"/>
<c:choose>
    <c:when test="${empty user}">
        <h1>Please add your name</h1>
    </c:when>
    <c:otherwise>
        <h1>Hello, ${user}!</h1>
    </c:otherwise>
</c:choose>

<div>
    <form action="<c:url value="/" />" method="post">
        <label for="user">Username</label>
        <input id="user" name="user">
    </form>
</div>

<jsp:useBean id="sessionMap" class="java.util.Map" scope="application" />
<table>
    <thead>
    <tr>
        <th>Session</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${sessionMap}" var="sessionEntry">
        <tr>
            <td>${sessionEntry.key}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
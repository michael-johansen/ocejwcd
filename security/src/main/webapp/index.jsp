<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
</head>
<body>

Main page

<ul>
    <li>
        <a href="<c:url value="/secured/secureContent.jsp" />">Go to secured content.</a>

    </li>
    <li>
        <a href="<c:url value="/admin" />">Go to admin</a>
    </li>
</ul>

</body>
</html>
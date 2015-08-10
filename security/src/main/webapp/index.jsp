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

Test: ${pageContext.getAttribute("test") == null } <br>

<%
    request.setAttribute("none", "");
    request.setAttribute("x", "10");
    request.setAttribute("i", "01");
    session.setAttribute("v", "05");
%>

<c:catch>
    \${" " gt -1}: ${" " gt -1}
</c:catch>
<br>
\${ i le 1}: ${ i le 1} <br>
\${v lt 05}: ${v lt 05} <br>
\${none gt -1}: ${none gt -1} <br>
\${x ge v}: ${x ge v} <br>
\${requestScope['none'] eq 0}: ${requestScope['none'] eq 0} <br>
\${empty none}: ${empty none} <br>

<pre>
    1.18.3 Coerce A to Number type N
■ If A is null or "", return 0.
</pre>

</body>
</html>
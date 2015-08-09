<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<jsp:useBean id="exception" class="java.lang.Exception" scope="request" />
<pre>
<%
    PrintWriter printWriter = new PrintWriter(pageContext.getOut());
    exception.printStackTrace(printWriter);
%>
</pre>
</body>
</html>
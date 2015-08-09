<%@ page import="java.math.BigInteger" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    private Map<Integer, BigInteger> cache = new HashMap<Integer, BigInteger>();

    private BigInteger fibonacci(int number) {
        if (cache.containsKey(number)) return cache.get(number);
        if (number <= 0) throw new IllegalArgumentException("illegal number: " + number);
        if (number == 1 || number == 2) return BigInteger.ONE;
        BigInteger result = fibonacci(number - 2).add(fibonacci(number - 1));
        cache.put(number, result);
        return result;
    }
%>
<html>
<head>
    <title></title>
</head>
<body>

<ul>
    <%
        String number = pageContext.getRequest().getParameter("number");
        if (number == null) number = "20";
        for (int i = 1; i < Integer.parseInt(number); i++) {
    %>
    <li>
        <%= i %>: <%= fibonacci(i) %>
    </li>
    <%
        }
    %>
</ul>

</body>
</html>
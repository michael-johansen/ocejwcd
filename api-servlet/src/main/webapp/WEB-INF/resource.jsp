<%@ page contentType="application/json;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="resource" type="net.michaeljohansen.ocejwcd.ApiServlet.ApiResource" scope="request" />
{
    "self": "${resource.self}"<c:if test="${not empty resource.properties}">,</c:if>
    <c:forEach items="${resource.properties}" var="property" varStatus="propertyStatus" >
    "${property.key}": "${property.value}"<c:if test="${not propertyStatus.last}">,</c:if>
    </c:forEach>
}
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<jsp:useBean id="propertyMap" class="java.util.TreeMap" scope="request"/>

<h1>Properties</h1>

<form action="" method="post">
    <table>
        <tbody>
        <c:forEach items="${propertyMap}" var="propertyEntry">
            <tr>
                <td>${propertyEntry.key}</td>
                <td>${propertyEntry.value}</td>
                <td>
                    <button type="button" onclick="deleteProperty('${propertyEntry.key}')">Delete</button>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td><input name="key"></td>
            <td><input name="value"></td>
            <td><button type="submit">Submit</button></td>
        </tr>
        </tbody>
    </table>
</form>

<script>
    function deleteProperty(key) {
        var promise = new Promise(function (resolve, reject) {
            var xhr = new XMLHttpRequest();
            xhr.onload = function () {
                resolve(xhr);
            };
            xhr.onerror = reject;
            xhr.open("DELETE", "?key=" + key, true);
            xhr.send();
        });
        promise.then(function () {
            window.location.reload(true);
        })
    }
</script>

</body>
</html>
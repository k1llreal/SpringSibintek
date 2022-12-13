<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Get authors by id range</title>
</head>
<body>
<h3><a href="/">На главную</a></h3>
<h2>Authors by id range</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Surname</th>
    </tr>
    <c:forEach var="author" items="${authorsList}">
        <tr>
            <td>${author.id}</td>
            <td>${author.name}</td>
            <td>${author.surname}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

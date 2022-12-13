<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Books and Authors</title>
</head>
<body>
<h3><a href="/">На главную</a></h3>
<h2>Books</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Title</th>
    </tr>
    <c:forEach var="book" items="${booksList}">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
        </tr>
    </c:forEach>
</table>
<h2>Authors</h2>
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

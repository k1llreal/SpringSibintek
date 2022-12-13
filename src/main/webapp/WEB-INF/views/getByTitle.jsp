<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Get book result</title>
</head>
<body>
<h3><a href="/">На главную</a></h3>
<h2>Book result</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Title</th>
    </tr>
    <tr>
        <td>${book.id}</td>
        <td>${book.title}</td>
    </tr>
</table>
</body>
</html>

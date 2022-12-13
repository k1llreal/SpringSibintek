<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Main page</title>
</head>
<body>
<h3><a href="info">Полный список книг и авторов</a></h3>
<h2>Task 1</h2>
<b>Получение автора по имени.</b>
<form method="get" action="getByName">
    <input type="text" name="name"/>
    <input type="submit" value="Получить"/>
</form>
<b>Получение книги по названию.</b>
<form method="get" action="getByTitle">
    <input type="text" name="title"/>
    <input type="submit" value="Получить"/>
</form>
<h2>Task 2</h2>
<b>Получение авторов по диапазону id.</b>
<form method="get" action="getByRange">
    Введите диапазон:<br>
    от-><input type="number" name="first"/><br>
    до-><input type="number" name="last"/><br>
    <input type="submit" value="Получить"/>
</form>
<h2>Task 3</h2>
<b>Получение всех авторов из БД без повторений.</b>
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
<h2>Task 4</h2>
<b>Получение всех книг автора по его имени и фамилии.</b>
<form method="get" action="getAuthorBooks">
    Имя:    <input type="text" name="name"/>
    Фамилия:<input type="text" name="surname"/><br>
    <input type="submit" value="Получить"/>
</form>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <%@ include file="head.html" %>
    <%--user name: "${requestScope.get("user")}"--%>
    <div>
        user name:
        <text><c:out value="${requestScope.user.name}" default="Hello world"/></text>
        <a href="calculations?action=logout">выйти</a>
        <br>
        user id:
        <text><c:out value="${requestScope.user.id}" default="Hello world"/></text>
    </div>
</head>
<body>
<div class="w3-container w3-blue-grey w3-opacity w3-center">
    <h1>Страница с расчётами</h1>
    <h2>Создание, выгрузка, предварительный просмотр расчётов</h2>
</div>

<section class="w3-white-grey">
    <hr/>
    <a href="calculations?action=create&id=${requestScope.user.id}">Создать расчёт</a>
    <hr/>
    <button type="button" class="w3-btn w3-green w3-round-large w3-margin-bottom"
    <%--onclick="location.href='/registration'"--%>>Загрузить файл тарифа
    </button>
    <br><br>
</section>
<hr/>
<h3>Таблица расчётов</h3>
<table class="w3-table w3-blue-gray ui-icon-folder-collapsed">
    <thead>
    <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Total Price</th>
        <th>пометить для выгрузки</th>
        <th>предварительный просмотр</th>
        <th>удалить</th>
    </tr>
    </thead>
    <c:forEach items="${requestScope.calculationsList}" var="calc">
        <%--<tr data-calculationId="${calc.id}">--%>
        <td>${calc.dateTime.toLocalTime()}</td>
        <td>${calc.description}</td>
        <td>${calc.totalPrice}</td>
        <td>чекбокс</td>
        <td><a href="calculations?action=preview&id=${calc.id}">Update</a></td>
        <td><a href="calculations?action=delete&id=${calc.id}">Delete</a></td>
        <%--</tr>--%>
    </c:forEach>
</table>
<%--passs: = "${requestScope.get("pass")}"--%>
<hr/>
<div>
    <button type="button" class="w3-btn w3-green w3-round-large w3-margin-bottom"
    <%--onclick="location.href='/registration'"--%>>Выгрузить выделенные расчёты в *.xlsx
    </button>
</div>
<br>
<footer class="footer w3-bottom w3-fixed">
    <%@ include file="footer.html" %>
</footer>
</body>
</html>

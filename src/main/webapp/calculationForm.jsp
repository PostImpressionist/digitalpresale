<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<section>
    <h3><button type="button" class="w3-btn w3-green w3-round-large w3-margin-bottom" onclick="window.history.back()">
        Назад
    </button></h3>
    <hr>
    <h2>выбранное действие = ${param.action}</h2>
    <h3>Настройте параметры</h3>

    <jsp:useBean id="calc" type="digital.presale.model.Calculation" scope="request"/>
    <form method="post" action="calculations">
        <input type="hidden" name="id" value="${calc.id}">
        <dl>
            <dt>DateTime:</dt>
            <dd><input type="datetime-local" value="${calc.dateTime}" name="dateTime" required></dd>
        </dl>
        <dl>
            <dt>Description:</dt>
            <dd><input type="text" value="${calc.description}" size=40 name="description" required></dd>
        </dl>
        <%--<dl>
            <dt>Calories:</dt>
            <dd><input type="number" value="${calc.hardwareList}" name="hardwareList" required></dd>
        </dl>--%>
        <button type="submit">Save</button>
        <button onclick="window.history.back()" type="button">Cancel</button>
    </form>

    <button type="button"  class="w3-btn w3-green w3-round-large w3-margin-bottom" onclick="">
        создать новый расчёт
    </button>

</section>
</body>
</html>

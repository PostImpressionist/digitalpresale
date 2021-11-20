
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <%@ include file="head.html" %>
</head>
<body>
<div class="w3-container w3-blue-grey w3-opacity w3-center">
    <h1>Страница с расчётами</h1>
    <h2>Создание, выгрузка, предварительный просмотр расчётов</h2>
</div>
<%--<table >
    <thead>
    <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <c:forEach items="${requestScope.meals}" var="meal">
        <tr data-mealExcess="${meal.excess}">
            <td>
                    &lt;%&ndash;${meal.dateTime.toLocalDate()} ${meal.dateTime.toLocalTime()}&ndash;%&gt;
                    &lt;%&ndash;<%=TimeUtil.toString(meal.getDateTime())%>&ndash;%&gt;
                    &lt;%&ndash;${fn:replace(meal.dateTime, 'T', ' ')}&ndash;%&gt;
                    ${fn:formatDateTime(meal.dateTime)}
            </td>
            <td>${meal.description}</td>
            <td>${meal.calories}</td>
            <td><a href="meals?action=update&id=${meal.id}">Update</a></td>
            <td><a href="meals?action=delete&id=${meal.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>--%>

Email: <%= request.getParameter("email") %>
Password: <%= request.getParameter("pass") %>
<footer class="footer w3-bottom" >
    <%@ include file="footer.html" %>
</footer>
</body>
</html>

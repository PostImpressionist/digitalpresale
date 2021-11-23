<%--
  Created by IntelliJ IDEA.
  User: SESA292574
  Date: 23.11.21
  Time: 02:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="head.html" %>
    user name: "${requestScope.get("user")}"
</head>
<body>
Предварительный просмотр расчёта с возможностью редактирования или выгрузки в файл
<hr/>
"${requestScope.get("calculation")}"

</body>
</html>

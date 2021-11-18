<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>EcoCalc</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<%--шапка--%>
<div class="w3-container w3-blue-grey w3-opacity w3-center">
    <h1>Регистрация нового пользователя</h1>
</div>

<%--Форма регистрации--%>
<div class="w3-card-4" >
    <div class="w3-container w3-center w3-green">
        <h2>Введите свои данные</h2>
    </div>
    <form method="post" class="w3-selection w3-light-grey w3-padding">
        <label>Имя:
            <input type="text" name="name" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%" required><br />
        </label>
        <label>Адрес электронной почты:
            <input type="email" name="email" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%" required><br />
        </label>
        <label>Компания:
            <input type="text" name="company" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%" required><br />
        </label>
        <label>Должность:
            <input type="text" name="position" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%" required><br />
        </label>
        <label>Password:
            <input type="password" name="pass" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%" required><br />
        </label>
        <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Зарегистрироваться</button>
        <button type="button" class="w3-btn w3-green w3-round-large w3-margin-bottom" onclick="window.history.back()">Отмена</button>
    </form>
</div>

<%--назад на главную--%>

</body>
<footer>
    <%@ include file="footer.html" %>
</footer>
</html>

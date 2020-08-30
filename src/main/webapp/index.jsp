<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<body>
<h2>Servlet practise</h2>
<form action="./name" method="post">
    <label>Imię:
        <input type="text" name="name">
    </label><br>
    <input type="submit" value="Wyślij"><br>
    <a href="./namesList">Lista imion - servlet</a><br>
    <a href="./namesList.jsp">Lista imion - jsp</a>
</form>
</body>
</html>

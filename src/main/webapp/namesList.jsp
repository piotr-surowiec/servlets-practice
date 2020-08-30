<%@ page import="java.util.Map" %>
<%@ page import="pl.sda.servlets.model.NamesDB" %><%--
  Created by IntelliJ IDEA.
  User: Piotr-Msi
  Date: 2020-08-30
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Baza imion</title>
</head>
<body>
<%
    Map<String, Integer> femaleNames = NamesDB.getAllFemaleNames();
    Map<String, Integer> maleNames = NamesDB.getAllMaleNames();
    out.println("<h2>Imiona żeńskie:</h2><br>");
    for(Map.Entry<String, Integer> entry : NamesDB.getAllFemaleNames().entrySet()){
        out.println("Imię: " + entry.getKey() + " wpisano: " + entry.getValue() + " razy.<br>");
    }
    out.println("<hr>");
    out.println("<h2>Imiona męskie:</h2><br>");
    for(Map.Entry<String, Integer> entry : NamesDB.getAllMaleNames().entrySet()){
        out.println("Imię: " + entry.getKey() + " wpisano: " + entry.getValue() + " razy.<br>");
    }
%>
</body>
</html>

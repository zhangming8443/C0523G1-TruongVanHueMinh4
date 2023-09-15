<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 9/15/2023
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/sandwich/save" method="post">
    <input type="checkbox" name="property" value="Lettuce">Lettuce
    <input type="checkbox" name="property" value="Tomato">Tomato
    <input type="checkbox" name="property" value="Mustard">Mustard
    <input type="checkbox" name="property" value="Sprouts">Sprouts
    <button type="submit">Save</button>
</form>


<p>${property}</p>


</body>
</html>

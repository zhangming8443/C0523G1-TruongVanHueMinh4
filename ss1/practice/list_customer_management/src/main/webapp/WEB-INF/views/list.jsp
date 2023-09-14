<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            border: 1px solid #000;
        }

        th, td {
            border: 1px dotted #555;
        }
    </style>
</head>
<body>
<h1>Customer List</h1>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="c" items="${customerList}">
        <tr>
            <td>
                <c:out value="${c.getName()}"/>
            </td>
            <td>
                <a href="info.jsp?id=${c.getId()}">${c.getName()}</a>
            </td>
            <td>
                <c:out value="${c.getEmail()}"/>
            </td>
            <td>
                <c:out value="${c.getAddress()}"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

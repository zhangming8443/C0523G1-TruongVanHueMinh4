<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>

<body>

<h1>Settings</h1>

<table>
    <form:form modelAttribute="email" action="/email/update" method="post">
        <tr>
            <th>
                Languages:
            </th>

            <td>
                <form:select path="language" items="${language}"/>
            </td>
        </tr>

        <tr>
            <th>
                Page Size:
            </th>

            <td>
                Show
                <form:select path="pageSize" items="${pageSize}"/>
                emails per page
            </td>
        </tr>

        <tr>
            <th>
                Spams Filter:
            </th>

            <td>
                <form:checkbox value="true" path="spamFilter"/>
                Enable spams filter
            </td>
        </tr>

        <tr>
            <th>
                Signature:
            </th>

            <td>
                <form:textarea path="signature"/>
            </td>
        </tr>

        <tr>
            <td>

            </td>

            <td>
                <form:button>Update</form:button>
                <form:button>Close</form:button>
            </td>
        </tr>
    </form:form>

</table>
<c:if test="${message != null}">
    <p class="text text-success">${message}</p>
</c:if>

</body>

</html>

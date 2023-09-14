<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Dictionary</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Dictionary</h1>
    <form action="/look_up" method="post">
        <table class="table">
            <tr>
                <th>
                    <label for="english">English:</label>
                </th>
                <td>
                    <input required type="text" id="english" name="english">

                </td>
            </tr>
            <tr>
                <th>
                    <label>Vietnamese :</label>
                </th>
                <td>
                    <label>${result}</label>
                </td>
            </tr>
            <tr>
                <td>
                    <button type="submit">Translate</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Currency Conversion</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Currency Conversion</h1>
    <form action="/currency_conversion" method="post">
        <table class="table">
            <tr>
                <th>
                    <label for="rate">Rate:</label>
                </th>
                <td>
                    <input required type="number" id="rate" name="rate">

                </td>
            </tr>
            <tr>
                <th>
                    <label for="usd">USD:</label>
                </th>
                <td>
                    <input required type="number" id="usd" name="usd">
                </td>
            </tr>
            <tr>
                <td>
                    <button type="submit">Exchange</button>
                </td>
            </tr>
        </table>
    </form>
    <p>VND: ${vnd}</p>
</div>
</body>
</html>

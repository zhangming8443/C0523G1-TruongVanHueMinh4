<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
</form>
<div class="container">
    <h1>Calculator</h1>
    <form action="/calculator/calculate" method="get">
        <table class="table">
            <tr>
                <td>
                    <label for="number1">Number 1:</label>
                </td>
                <td>
                    <input required type="number" id="number1" name="number1">
                </td>
                <td>
                    <label for="number2">Number 2:</label>
                </td>
                <td>
                    <input required type="number" id="number2" name="number2">
                </td>
            </tr>
            <tr>
                <td>
                    <button type="submit" name="calculate" value="addition">Addition</button>
                </td>
                <td>
                    <button type="submit" name="calculate" value="subtraction">Subtraction</button>
                </td>
                <td>
                    <button type="submit" name="calculate" value="multiplication">Multiplication</button>

                </td>
                <td>
                    <button type="submit" name="calculate" value="division">Division</button>
                </td>
            </tr>
        </table>
        <p>${result}</p>
    </form>
</div>
</body>
</html>

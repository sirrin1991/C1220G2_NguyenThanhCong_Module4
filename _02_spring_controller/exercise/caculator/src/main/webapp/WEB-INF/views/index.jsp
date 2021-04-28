<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
    <h1>Calculator</h1>
    <form action="/calculator">
        <input type="number" name="firstNumber" value="${firstNumber}" placeholder="First number">
        <input type="number" name="secondNumber" value="${secondNumber}" placeholder="Second number"><br><br>
        <input type="submit" name="submit" value="Addition(+)">
        <input type="submit" name="submit" value="Subtraction(-)">
        <input type="submit" name="submit" value="Multiplication(X)">
        <input type="submit" name="submit" value="Division(/)">
    </form>

    <span>Result ${operation} : ${result}</span>
</body>
</html>

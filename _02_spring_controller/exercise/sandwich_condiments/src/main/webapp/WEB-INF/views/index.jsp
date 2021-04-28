<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <style>
        ul>li{
            display: inline-block;
        }
    </style>
</head>
<body>
    <h1>Sandwich Condiments</h1>
    <form action="/submitCondiments" method="post">
        <ul>
            <li>
                <input type="checkbox" name="lettuce" value="lettuce" id="lettuce">
                <label for="lettuce">Lettuce</label>
            </li>
            <li>
                <input type="checkbox" name="lettuce" value="tomato" id="tomato">
                <label for="tomato">Tomato</label>
            </li>
            <li>
                <input type="checkbox" name="lettuce" value="mustard" id="mustard">
                <label for="mustard">Mustard</label>
            </li>
            <li>
                <input type="checkbox" name="lettuce" value="sprouts" id="sprouts">
                <label for="sprouts">Sprouts</label>
            </li>

        </ul>
        <input type="submit" value="save"/>
    </form>
</body>
</html>

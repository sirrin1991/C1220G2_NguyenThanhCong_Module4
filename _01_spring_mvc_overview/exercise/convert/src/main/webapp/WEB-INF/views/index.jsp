<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Convert</title>
  </head>
  <body>
  <form action="/index" method="post">
      <label for="USD">USD</label><br><br>
      <input type="number" id="USD" name="usd"  value="${usd}"><br><br>
      <label for="VND">VND</label><br><br>
      <input type="number" id="VND" name="vnd" value="${result}" readonly><br><br>
      <input type="submit" value="CONVERT">
  </form>
  </body>
</html>

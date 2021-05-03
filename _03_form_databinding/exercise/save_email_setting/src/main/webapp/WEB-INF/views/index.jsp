<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
    <h2>Settings</h2>
    <form:form modelAttribute="emailSetting" action="/save" method="post">
        <table>
            <tr>
                <td colspan="2">Language :</td>
                <td colspan="5"><form:select path="language" items="${listLanguage}"/> </td>
            </tr>
            <tr>
                <td colspan="2">Page size : </td>
                <td colspan="5">Show <form:select path="pageSize" items="${listPageSize}"/> </td>
            </tr>
            <tr>
                <td colspan="2">Spams filter : </td>
                <td colspan="5"><form:checkbox path="spamFilter"/> Enable spams filter</td>
            </tr>
            <tr>
                <td colspan="2">Signature : </td>
                <td colspan="5"><form:textarea path="signature"/></td>
            </tr>
            <tr>
                <td colspan="2"></td>
                <td colspan="5">
                    <input type="submit" value="Update">
                    <input type="button" value="Cancel">
                </td>
            </tr>
        </table>
    </form:form>

</body>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Setting Information</title>
</head>
<body>
<h2>Setting information</h2>
<table>
    <tr>
        <td>Language : </td>
        <td>${emailSetting.language}</td>
    </tr>
    <tr>
        <td>Page size : </td>
        <td>${emailSetting.pageSize}</td>
    </tr>
    <tr>
        <td>Spam filter : </td>
        <td>${emailSetting.spamFilter}</td>
    </tr>
    <tr>
        <td>Signature : </td>
        <td>${emailSetting.signature}</td>
    </tr>
</table>
</body>
</html>

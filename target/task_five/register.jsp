<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Register</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

</head>
<body>
<center>
<h1>用户注册</h1>
    <p style="color:red">${exist}</p>
<hr>
<form action="/Register" method="post"> <%--action="/Register" method="post"--%>
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="name" /></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="pwd" name="pwd" /></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="注册"/>&nbsp;&nbsp;<button><a
                    href="/login">登录</a></button></td>
        </tr>
    </table>
</form>
</center>
</body>
</html>

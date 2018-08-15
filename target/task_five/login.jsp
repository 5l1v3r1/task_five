<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Login</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

</head>
<body>
<center>
<h1>用户登录</h1>
    <p style="color:red">${error}</p>
<hr>
<form name="" action="${pageContext.request.contextPath }/u/Login" method="post">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="name" /></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="pwd" /></td>
        </tr>

        <tr>
            <td colspan="3" align="center"><input type="submit" value="登录"/>
                &nbsp;&nbsp;<input type="button" value="注册" onclick="location.href='${pageContext.request.contextPath }/register'"/>
                &nbsp;&nbsp;<input type="button" value="主页" onclick="location.href='${pageContext.request.contextPath }/index'"/></td>
        </tr>
    </table>
</form>
</center>
</body>
</html>

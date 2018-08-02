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
    <script src="http://code.jquery.com/jquery-1.4.1.min.js"></script>
    <script src="http://code.jquery.com/jquery-1.4.1.js"></script>
    <script type="text/javascript">
        //首先要通过前台jquery ajax请求后台，并把这个参数传递到后台
        function send(){
            var phone = $('#phone').val();//那个text框里填的内容
            $.ajax({
                url: 'send',
                type: "POST",
                data: {//data就是参数，是json格式
                    phone : phone,
                    demo: 123
                },
                dataType: 'json',
                /*async: true,

                cache: true,*/
                success: function (args) {
                    //请求成功返回后执行的动作
                    alert(args);
                }/*,
                error: function () {
                        //请求失败后执行的动作
                        alert("args1");
                }*/
            });

        }


    </script>
</head>
<body>
<center>
<h1>用户注册</h1>
    <p style="color:red">${exist}</p>
<hr>
<form action="/task_five/Register" method="post"> <%--action="/Register" method="post"--%>
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
            <td>手机：</td>
            <td><input type="text" id="phone" /></td>

        </tr>

        <td><input type='button' value="获取验证码"  onclick="send()"/></td>
        <hr>
        <td><input type='text' name="key"/></td>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="注册"/>&nbsp;&nbsp;<button><a
                    href="/task_five/login">登录</a></button></td>
        </tr>
    </table>
</form>


</center>

</body>

</html>

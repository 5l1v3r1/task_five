<%--
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
    <script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="http://code.jquery.com/jquery-3.1.1.js"></script>
    <script>
        $(function(){
            $(".btn_email").click(function(){
                var disabled = $(".btn").attr("disabled");
                var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;  //邮箱
                if(disabled){
                    return false;
                }
                if($("#email").val() == ""&&regEmail.test($("#email").val())){
                    alert("请填写正确的eamil！");
                    return false;
                }
                var _inpdisabled = $(".inputCode_email");
                var url = '${pageContext.request.contextPath }/email';
                /*得到href的值*/
                $.ajax({
                    url: url, /*url也可以是json之类的文件等等*/
                    type: 'POST', /*DELETE、POST */
                    data:'email=' + $("#email").val(),
                    success: function (result) {
                        //判断result结果
                        if (result) {
                            console.log(result);
                            /* 放开Code 输入框 */
                            _inpdisabled.attr("disabled",false);
                            _inpdisabled.val("请输入邮箱验证码");
                            settime();
                        } else {
                            alert("email发送失败!,请检查email!!!")
                        }
                    }
                });
            });
            var countdown=120;
            var _get_code = $(".btn_email");
            function settime() {
                if (countdown == 0) {
                    _get_code.attr("disabled",false);
                    _get_code.val("获取验证码");
                    countdown = 60;
                    return false;
                } else {
                    $(".btn").attr("disabled", true);
                    _get_code.val("重新发送(" + countdown + ")");
                    countdown--;
                }
                setTimeout(function() {
                    settime();
                },1000);
            }
        })
    </script>
</head>
<body>
<center>
<h1>用户注册</h1>
    <p style="color:red">${exist}</p>
<hr>
<form action="/task_five/Register" method="post"> &lt;%&ndash;action="/Register" method="post"&ndash;%&gt;
    <table>

        <tr>
            <td>email：</td>
            <td><input type="text" id="email" value="请输入手机号码" name="email"
                       onfocus="if (this.value == '请输入手机号码') {this.value = '';}"
                       onblur="if (this.value == '') {this.value = '请输入手机号码';}">
            </td>
        </tr>
        <tr>
            <td>验证码：</td>
            <td><input disabled="disabled" id="code" class="inputCode" type="text" value="请先获取验证码" name="code"
                       onfocus="if (this.value == '请输入email验证码') {this.value = '';}"
                       onblur="if (this.value == '') {this.value = '请输入email验证码';}">
                <input class="btn_email" type="button" value="获取验证码">
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="注册"/>&nbsp;&nbsp;<button><a
                    href="/task_five/login">登录</a></button></td>
        </tr>
    </table>
</form>


</center>

</body>

</html>
--%>

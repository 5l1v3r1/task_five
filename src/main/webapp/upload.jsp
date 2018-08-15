<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="http://code.jquery.com/jquery-3.1.1.js"></script>
<script>
    function checkImgType(){
        var file=$("#file").val();
        if (file == "") {
            alert("请上传图片");
            return false;
        } else {
            if (!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test(file)) {
                alert("图片类型必须是.gif,jpeg,jpg,png中的一种");
                return false;
            }

        }
        return true;

    }
</script>
<body>
<p align="center">上传文件选择
    <%--<form action="/upload" method="post" enctype="multipart/form-data">
        　　文件名: <input type="file" name="upfile"/> <br/>
        　　<input type="submit" value="提交" />
    </form>--%>
<div>
    <p >${upload1}</p>
    <img style="width:100px;height: 100px;border-radius: 50px;"src="${upload}">
    <%--<c:if test="${itemsCustom.pic !=null}">
        &lt;%&ndash; "/pic"路径是绝对路径，不要加${pageContext.request.contextPath }/... &ndash;%&gt;
        <img src="/pic/${itemsCustom.pic}" width=100 height=100/>
        <br/>
    </c:if>--%>
</div>
<form action="${pageContext.request.contextPath }/upload " method="post" enctype="multipart/form-data" onsubmit="return checkImgType();"> <%--/${u.id}--%>
    <input type="file" name="file" size="1"  id="file">
    <input type="hidden" value="45" name="id">
    <input type="submit" value="提交">
</form>

</body>
</html>

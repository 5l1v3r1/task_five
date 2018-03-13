<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        var xmlhttp;
        function btnClick()
        {
            xmlhttp=null;
            if (window.XMLHttpRequest)
            {// code for Firefox, Opera, IE7, etc.
                xmlhttp=new XMLHttpRequest();
            }
            else if (window.ActiveXObject)
            {// code for IE6, IE5
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
            if (xmlhttp!=null)
            {
                xmlhttp.onreadystatechange=function () {
                    if (xmlhttp.readyState==4)
                    {// 4 = "loaded"
                        if (xmlhttp.status==200)
                        {// 200 = "OK"
                            console.log(xmlhttp.responseText);
                            document.getElementById('T1').innerHTML=xmlhttp.responseText;
                        }
                        else
                        {
                            alert("Problem retrieving data:" + xmlhttp.responseText);
                        }
                    }
                };
                xmlhttp.open("GET","/ajax",true);//http://47.94.14.145:8080/task_five
               // xmlhttp.open("GET","/ajax",true); //本地获取
                xmlhttp.send();
            }
            else
            {
                alert("Your browser does not support XMLHTTP.");
            }

        }

        function state_Change()
        {
            if (xmlhttp.readyState==4)
            {// 4 = "loaded"
                if (xmlhttp.status==200)
                {// 200 = "OK"
                    document.getElementById('T1').innerHTML=xmlhttp.responseText;
                }
                else
                {
                    alert("Problem retrieving data:" + xmlhttp.statusText);
                }
            }
        }

    </script>
</head>
<body>
<input type="button" value="点我控制台会打印" onclick="btnClick()">
<P id="T1"> </P>
</body>
</html>
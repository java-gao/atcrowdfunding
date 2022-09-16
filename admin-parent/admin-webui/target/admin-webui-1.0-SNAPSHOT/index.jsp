<%--
  Created by IntelliJ IDEA.
  User: chenhui
  Date: 2022/9/8
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="http://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/"/>
    <title>Title</title>
    <script type="text/javascript" src="jquery/jquery-2.1.1.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#btn1").click(function (){
                $.ajax({
                    "url":"send/array.html",
                    "type":"post",
                    "data":{"array":[5,8,12]},
                    "dataType":"text",
                    "success":function(response){
                        alert(response)
                    },
                    "error":function (response){
                        alert(response)
                    },
                });
            });
        });
    </script>

</head>
<body>
    <a href="test/ssm.html">测试SSM整合的环境</a>
    <br>
    <button id="btn1">test_request_body</button>
</body>
</html>

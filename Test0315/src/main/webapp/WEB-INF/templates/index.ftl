<#import "spring.ftl" as s />
<!DOCTYPE>
<html>
<head>
    <title>Test0315 首页</title>
    <script type="text/javascript" src="<@s.url '/resources/js/jquery-1.9.1.js'/>"></script>
    <script type="text/javascript">
        //将一个表单(登陆)的数据返回成JSON对象
        function getParams_index() {
            var params = {};
            $.extend(params, {
                susername: $("#susername").val().trim(),
                spassword: $("#spassword").val().trim()
            });
            return params;

        };
        //用户登陆
        $(function(){
            $("#login").click(function(){
                var userName=$("#susername").val().trim();
                var pwd=$("#spassword").val().trim();
                if(userName=="" || pwd==""){
                    alert("用户名或密码不能为空！");
                }else{
                    $.ajax({
                        url: "/test0315/login",
                        type: "POST",
                        dataType: "json",
                        data: {"tbusers":JSON.stringify(getParams_index())},
                        success: function (re) {
                            if(re!=-1){
                                alert("登陆成功!!!");
                                window.location.href="home";
                            }else{
                                alert("登陆失败,请重试!");
                            }
                        },
                        error: function (XMLHttpRequest,textStatus,errorThrown) {
                            alert(XMLHttpRequest.status+"/n"+XMLHttpRequest.readyState+"/n"+textStatus);
                        }
                    });
                }
            });
        });
    </script>
</head>
<body>
<h3>用户登陆</h3>
<form action="login" method="post" commandName="tbusers" role="form">
    <table border="0" cellpadding="5" cellspacing="5">
        <tr>
            <td align="right">用户名：</td>
            <td><input type="text" name="susername" id="susername"></td>
            <td></td>
        </tr>
        <tr>
            <td align="right">密码：</td>
            <td><input type="password" name="spassword" id="spassword"></td>
            <td></td>
        </tr>
        <tr>
            <td colspan="3">
                <div>
                    <span style="padding-left: 15px;"><input type="button" id="login" value="登陆"></span>
                    <span style="padding-left: 15px;"><input type="reset" value="重置" id="reset"></span>
                    <span style="padding-left: 15px;"><a href="toregist">前去注册</a></span>
                </div>
            </td>
        </tr>
    </table>
</form>

</body>
</html>

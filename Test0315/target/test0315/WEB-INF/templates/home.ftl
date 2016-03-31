<#import "spring.ftl" as s />
<!DOCTYPE>
<html>
<head>
    <title>Test0315 首页</title>
    <script type="text/javascript" src="<@s.url '/resources/js/jquery-1.9.1.js'/>"></script>
    <script type="text/javascript" src="<@s.url '/resources/js/ajaxfileupload.js'/>"></script>
    <script style="text/javascript">
        //生成随机guid数(参考网上)
        function getGuidGenerator() {
            var S4 = function () {
                return (((1 + Math.random()) * 0x10000) | 0).toString(16).substring(1);
            };
            return (S4() + S4() + "-" + S4() + "-" + S4() + "-" + S4() + "-" + S4() + S4() + S4());
        }

        //上传文件
        function fileUpLoad() {
            var susername = $("#susername").val();
            var fileName = $("#upFile1").val();//文件名
            fileName = fileName.split("\\");
            fileName = fileName[fileName.length - 1];
            var guid = getGuidGenerator();//唯一标识guid
            var data = {guid: guid};
            jQuery.ajaxSettings.traditional = true;
            //开始上传文件时显示一个图片,文件上传完成将图片隐藏
            //$("#loading").ajaxStart(function(){$(this).show();}).ajaxComplete(function(){$(this).hide();});
            //执行上传文件操作的函数
            $.ajaxFileUpload({
                url: '/test0315/fileUpLoad?uname=' + susername,
                secureuri: false,//安全协议,是否启用安全提交,默认为false
                fileElementId: 'upFile1',//文件选择框的id属性
                type: 'POST',
                dataType: 'json',//服务器返回的格式,可以是json或xml等
                data: data,
                async: false,
                error: function (data, status, e) {
                    alert('Operate Failed!');
                },
                success: function (da) {
                    if (da["result1"] == 1) {
                        alert("上传文件失败");
                    } else {
                        alert("上传文件成功");
                    }
                }
            });
        }

        //未登录或者登陆超时(session超时),跳转至登陆页面
        function exitIfTimeOut() {
            window.location = "/test0315";
        }
    </script>
</head>
<body>
<h3>用户主页</h3>
<#if !user??>

</#if>
<#if user??>
<form action="" method="post">
    <table border="0" cellpadding="5" cellspacing="5">
    <tr>
    <td align="right">用户名：</td>
    <td><input type="text" name="susername" id="susername" value="${user.susername}"></td>
            <td></td>
        </tr>
        <tr>
            <td align="right">文件名：</td>
            <td>
                <div id="fileUpLoad"><input type="file" name="upFile1" id="upFile1"></div>
            </td>
            <td></td>
        </tr>
        <tr>
            <td colspan="3">
                <div>
                    <span style="padding-left: 15px;"><input type="button" id="upload" value="上传"
                                                             onclick="fileUpLoad()"></span>
                    <span style="padding-left: 15px;"><input type="reset" value="重置"></span>
                    <span style="padding-left: 15px;"><a href="toregist">前去注册</a></span>
                </div>
            </td>
        </tr>
    </table>
</form>
</#if>
</body>
</html>

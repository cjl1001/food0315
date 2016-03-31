<#import "spring.ftl" as s />
<!DOCTYPE>
<html>
<head>
    <title>Test0315 首页</title>
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<@s.url '/resources/css/hint.css'/>">
    <!-- 直接使用QQ的省市区数据 -->
    <!--
    <script type="text/javascript" src="http://ip.qq.com/js/geo.js"></script>
    -->
    <script type="text/javascript" src="<@s.url '/resources/js/geo.js'/>"></script>
    <script type="text/javascript" src="<@s.url '/resources/js/jquery-1.9.1.js'/>"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        //这个函数是必须的，因为在geo.js里每次更改地址时会调用此函数
        function promptinfo() {
            var addressAll = document.getElementById('addressAll');
            var s1 = document.getElementById('s1');
            var s2 = document.getElementById('s2');
            var s3 = document.getElementById('s3');
            addressAll.value = s1.value + s2.value + s3.value;
        }
        function addressHint() {
            var s1 = document.getElementById('s1');
            var s2 = document.getElementById('s2');
            var s3 = document.getElementById('s3');
            /*台湾省下的3级菜单无选项*/
            if (s1.value == "省份" || s2.value == "地级市" || (s3.value == "市、县级市、县" && s1.value != "台湾省")) {
                alert("收货地址有误,请先选择收货地址!");
                $("#s4").blur();
                return false;
            } else {
                return true;
            }
        }
        //验证用户名
        function checkUserName() {
            var name = $("#susername").val().trim();
            var nameHint1 = $("#nameHint1");
            if (name == "") {
                nameHint1.css("color", "red");
                nameHint1.html("用户名不能为空");
            } else {
                $.post(
                        "/test0315/repeatName",
                        {"susername": name},
                        function (re) {
                            if (re["result"].length == 6) {
                                nameHint1.css("color", "green");
                                nameHint1.html("此用户名可以注册");
                            } else {
                                nameHint1.css("color", "red");
                                nameHint1.html("此用户名重复,不可使用");
                            }
                        }, "json"
                );
            }
        }
        //验证密码
        function checkPwd() {
            var pwd = $("#spassword").val().trim();
            if (pwd == "" || pwd.length < 3 || pwd.length > 12) {
                $("#pwdHint1").html("密码为3-12位字符");
                return false;
            } else {
                $("#pwdHint1").html("");
                return true;
            }
        }
        //再次确认密码
        function checkPwd2() {
            var pwd = $("#spassword").val().trim();
            var pwd2 = $("#spassword2").val().trim();
            if (pwd != pwd2) {
                $("#pwd2Hint1").html("两次密码输入不一致");
                return false;
            } else {
                $("#pwd2Hint1").html("");
                return true;
            }
        }
        //验证电话
        function checkTel() {
            var tel = $("#stel").val().trim();
            if (tel == "" || !/^1(3|4|5|8)[0-9]\d{8}$/.test(tel)) {
                $("#telHint1").html("电话号码填写有误");
                return false;
            } else {
                $("#telHint1").html("");
                return true
            }
        }
        //验证地址
        function checkAddress() {
            var adr = $("#s4").val().trim();
            if (adr == "") {
                $("#addressHint1").html("详细地址必填");
                return false;
            } else {
                $("#addressHint1").html("");
                return true;
            }
        }
        //注册用户
        function checkRegistSubmit() {
            var nameHint = $("#nameHint1").html().trim();
            if (nameHint != "此用户名可以注册" || !addressHint() || !checkPwd() || !checkPwd2() || !checkTel() || !checkAddress()) {
                alert("注册信息填写有误,请仔细确认!");
            } else {
                var userName = $("#susername").val().trim();
                var pwd = $("#spassword").val().trim();
                var tel = $("#stel").val().trim();
                var role = $("input[name='irolelevel']:checked").val();
                var ads = "";
                var s1 = $("#s1").val();
                var s2 = $("#s2").val();
                var s3 = $("#s3").val();
                var s4 = $("#s4").val();
                if (s1 == "台湾省" || s2 == s3) {
                    ads += s1 + s2 + s4;
                } else if (s1 == s2) {
                    ads += s1 + s3 + s4;
                } else {
                    ads += s1 + s2 + s3 + s4;
                }
                $.ajax({
                    url: "regist",
                    type: "POST",
                    dataType: "json",
                    data: {
                        "tbusers": JSON.stringify({
                            "susername": userName,
                            "spassword": pwd,
                            "stel": tel,
                            "irolelevel": role
                        })
                        , "tbaddress": JSON.stringify({"address": ads})
                    },
                    /*data: JSON.stringify(getParams_regist(userName,pwd,tel,role,ads)),*/
                    /*data:JSON.stringify({"susername": userName,"spassword": pwd, "stel": tel, "irolelevel": role,"address":ads}),*/
                    success: function (re) {
                        if (re.result == "用户注册成功") {
                            alert("注册成功,请登陆!");
                            window.location.href = "/test0315";
                        } else {
                            alert("注册失败!");
                        }
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        alert(XMLHttpRequest.status + "\n" + XMLHttpRequest.readyState + "\n" + textStatus);
                    }
                });
            }
        }

    </script>
</head>
<body onload="setup();preselect('湖北省');promptinfo();">
<h2 style="margin-left: 100px;">用户注册
    <small>填写注册信息</small>
</h2>
<form action="" method="post" role="form" class="form-horizontal">
    <div class="form-group">
        <label for="susername" class="col-sm-2 control-label">用户名：</label>
        <div class="col-sm-2 control-label"><input type="text" name="susername" id="susername" onblur="checkUserName()"/></div>
        <div class="col-sm-2 control-label"><span class="user_hint" id="nameHint1"></span></div>
    </div>
    <div class="form-group">
        <label for="spassword" class="col-sm-2 control-label">密码：</label>
        <div class="col-sm-2 control-label"><input type="password" name="spassword" id="spassword" onblur="checkPwd()"></div>
        <div class="col-sm-2 control-label"><span class="user_hint" id="pwdHint1"></span></div>
    </div>
    <div class="form-group">
        <label for="spassword2" class="col-sm-2 control-label">确认密码：</label>
        <div class="col-sm-2 control-label"><input type="password" name="spassword2" id="spassword2" onblur="checkPwd2()"></div>
        <div class="col-sm-2 control-label"><span class="user_hint" id="pwd2Hint1"></span></div>
    </div>
    <div class="form-group">
        <label for="stel" class="col-sm-2 control-label">电话：</label>
        <div class="col-sm-2 control-label"><input type="text" name="stel" id="stel" onblur="checkTel()"/></div>
        <div class="col-sm-2 control-label"><span class="user_hint" id="telHint1"></span></div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">用户身份：</label>
        <div class="col-sm-4 control-label">
            <div  style="float: left">
                <input type="radio" name="irolelevel" id="radio_0" value="0" checked="checked">
                <label for="radio_0" style="font-weight: normal">普通用户</label>
                <input type="radio" name="irolelevel" id="radio_1" value="1">
                <label for="radio_1" style="font-weight: normal">加盟商家</label>
            </div>
        </div>
        <div class="col-sm-6 control-label"><span class="user_hint" id="roleHint1"></span></div>
    </div>
    <div class="form-group">
        <label for="s1" class="col-sm-2 control-label">收货地址:</label>
        <div class="col-sm-6 control-label">
            <div style="float: left">
                <select class="select" name="province" id="s1" style="width: 80">
                    <option></option>
                </select>
                <select class="select" name="city" id="s2" style="width: 150">
                    <option></option>
                </select>
                <select class="select" name="town" id="s3" style="width: 120">
                    <option></option>
                </select>
                <input id="address" name="address" type="hidden" value=""/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <label for="s4" class="col-sm-2 control-label">详细地址:</label>
        <div class="col-sm-2 control-label"><input type="text" name="address4" id="s4" onfocus="addressHint()" onblur="checkAddress()"/></div>
        <div class="col-sm-2 control-label"><span class="user_hint" id="addressHint1"></span></div>
    </div>
    <div class="form-group">
        <div class="col-sm-1 control-label" style="margin-left: 90px;">
                    <span style="padding-left: 15px;"><input type="button" id="regist" value="注册"
                                                             class="btn btn-sm btn-success"
                                                             onclick="checkRegistSubmit()"></span></div>
        <div class="col-sm-1 control-label"><span style="padding-left: 15px;">
            <input type="reset" value="重置" class="btn btn-sm btn-success"></span></div>
        <div class="col-sm-2 control-label" style="text-align: left"><span style="padding-left: 15px;" class="btn btn-link"><a href="/test0315">前往登陆</a></span></div>
        </div>
    </div>
</form>
</body>
</html>
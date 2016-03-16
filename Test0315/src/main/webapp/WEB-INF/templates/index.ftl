<html>
<body>
<h1>Test0315 首页</h1>
<h3>出现此页，说明配置成功！！！！！！</h3>
<#if !userList?exists>
    userList为空；
</#if>
<#if userList?exists>
    <table border="1" cellpadding="5" cellspacing="0">
        <tr>
            <th>用户名</th><th>电话</th><th>积分</th>
        </tr>
    <#list userList as ul>
        <tr>
            <td>${ul.susername}</td><td>${ul.stel}</td><td>${ul.iuserpoint}</td>
        </tr>
    </#list>
    </table>
</#if>
</body>
</html>

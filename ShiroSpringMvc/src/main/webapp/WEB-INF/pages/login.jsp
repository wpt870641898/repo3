<%--
  Created by IntelliJ IDEA.
  User: wang
  Date: 2019/3/15
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="/login.html">
        用户名:<input type="text" name="username"/><br/>
        密码:<input type="password" name="password"/><br/>
        <input type="submit" value="提交"/>${error}
    </form>
</body>
</html>

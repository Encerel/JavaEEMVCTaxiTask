<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 10/21/2022
  Time: 12:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="controller" method="post">
    Login: <input type="text" name="email" placeholder="Enter email...">
    Password: <input type="password" name="password" placeholder="Enter password...">
    <button>SignIn</button>
    <input type="hidden" name="command" value="sign_in">
</form>
${message}
<form action="controller" method="post">
    <button>SignUp</button>
    <input type="hidden" name="command" value="to_sign_up">
</form>
</body>
</html>

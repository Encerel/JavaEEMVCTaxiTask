<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 10/21/2022
  Time: 3:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    SIGN_UP

<form action="controller" method="post">
    <div>
        Name: <input type="text" name="name" placeholder="Enter name...">
    </div>
    <div>
        Surname: <input type="text" name="surname" placeholder="Enter surname...">
    </div>
    <div>
        Email: <input type="text" name="email" placeholder="Enter email...">
    </div>
    <div>
        Password: <input type="password" name="password" placeholder="Enter password...">
    </div>
    <div>
        Confirmed password <input type="password" name="confirmed_password" placeholder="Confirm password...">
    </div>
    <div>
        <button>Sign Up</button>
    </div>

    <input type="hidden" name="command" value="sign_up">
</form>
${message}
</body>
</html>

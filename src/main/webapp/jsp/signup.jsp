<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:import url="fragment/header.jsp"/>

<div class="container">

    <div class="mx-auto" style="width: 400px;">

<form action="controller" method="post">
    <input type="hidden" name="command" value="sign_up">
    <div class="mb-3">
        <label for="exampleInputText1" class="form-label">Name</label>
        <input type="text" class="form-control" name="name" placeholder="Enter name..." id="exampleInputText1" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
        <label for="exampleInputText2" class="form-label">Surname name</label>
        <input type="text" class="form-control" name="surname" placeholder="Enter surname..." id="exampleInputText2" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
        <label for="exampleInputEmail" class="form-label">Email address</label>
        <input type="email" class="form-control" name="email" id="exampleInputEmail" placeholder="Enter email..." aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Password</label>
        <input type="password" class="form-control" name="password"  placeholder="Enter password..." id="exampleInputPassword1">
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword2" class="form-label">Confirmed password</label>
        <input type="password" class="form-control" name="confirmed_password"  placeholder="Confirm password..." id="exampleInputPassword2">
    </div>

    <button type="submit" class="btn btn-primary">Sign up</button>
</form>
${message}
    </div>
</div>

<c:import url="fragment/footer.jsp"/>
</body>
</html>

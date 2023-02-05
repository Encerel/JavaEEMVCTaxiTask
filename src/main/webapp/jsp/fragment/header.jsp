<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="ru">
<head>
    <!-- Обязательные метатеги -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Привет мир!</title>
</head>
<body>


<div class="navbar navbar-light bg-light align-items-center mb-5">
    <div class="container-fluid">
        <a class="navbar-brand">Taxi depot</a>

        <c:if test="${sessionScope.user == null}">
            <div class="d-flex" style="margin: 0;">
                <form  action="controller" method="post" style="margin: 0 10px;">
                    <input type="hidden" name="command" value="to_sign_in">
                    <button class="btn btn-outline-primary  align-items-center" style="margin: 0;" type="submit">Sign In</button>
                </form>
                <form action="controller" method="post" style="margin: 0;">
                    <button class="btn btn-outline-success  align-items-center" style="margin: 0;" type="submit">Sign Up</button>
                    <input type="hidden" name="command" value="to_sign_up">
                </form>
            </div>
        </c:if>
        <c:if test="${sessionScope.user != null}">
            <div class="d-flex" style="margin: 0;">
                <span style="margin: 0 10px 0 0; display: flex; align-items: center;">
                    Hello, ${sessionScope.user.name}
                </span>
                <form action="controller" method="post" style="margin: 0;">
                    <input type="hidden" name="command" value="log_out">
                    <button class="btn btn-outline-danger align-items-center" style="margin: 0;">Log Out</button>
                </form>
            </div>
        </c:if>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
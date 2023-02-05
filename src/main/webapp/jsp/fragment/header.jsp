<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <div class="d-flex" style="margin: 0;">
            <form style="margin: 0 5px;">
                <button class="btn btn-outline-primary  align-items-center" style="margin: 0;" type="submit">Sign In</button>
            </form>
            <form action="controller" method="post" style="margin: 0;">
                <button class="btn btn-outline-success  align-items-center" style="margin: 0;" type="submit">Sign Up</button>
                <input type="hidden" name="command" value="to_sign_up">
            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
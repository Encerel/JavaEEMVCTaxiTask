
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Hello, ${sessionScope.user.name}

<table>
    <tr>
        <th>id</th>
        <th>model</th>
        <th>speed</th>
        <th>fuel_consumption</th>
        <th>price</th>
    </tr>

    <c:forEach var="taxi" items="${sessionScope.taxi_list}">
    <tr>
        <td>${taxi.taxiId}</td>
        <td>${taxi.model}</td>
        <td>${taxi.speed}</td>
        <td>${taxi.fuelConsumption}</td>
        <td>${taxi.price}$</td>
    </tr>
    </c:forEach>

</table>

<c:if test="${sessionScope.user.role == 'ADMIN'}">
    <form action="controller" method="get">
        <input type="hidden" value="to_admin_page" name="command">
        <button>Go to the admin page</button>
    </form>
</c:if>

<form action="controller" method="post">
    <button>Exit</button>
    <input type="hidden" name="command" value="log_out">
</form>



</body>
</html>

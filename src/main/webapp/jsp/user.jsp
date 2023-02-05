
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:import url="fragment/header.jsp"/>

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

<c:import url="fragment/footer.jsp"/>
</body>
</html>

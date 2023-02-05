<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>


<c:import url="fragment/header.jsp"/>

<div class="container">

    <div class="mx-auto" style="width: 400px;">
        <h1 style="text-align: center">Admin page</h1>
        <h2 style="text-align: center">People</h2>
        <form action="controller" method="post" style="text-align: center">
            <button class="btn btn-primary">Check all users</button>
            <input type="hidden" name="command" value="find_all_users">
        </form>
    </div>


    <div class="mx-auto" style="width: 800px;">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>id</th>
                <th>name</th>
                <th>surname</th>
                <th>email</th>
                <th>role</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${sessionScope.user_list}">
                <tr>
                    <td>${user.userId}</td>
                    <td>${user.name}</td>
                    <td>${user.surname}</td>
                    <td>${user.email}</td>
                    <td>
                            ${user.role}$
                        <c:if test="${user.role ne 'ADMIN'}">
                        <form action="controller" method="post">
                            <button class="btn btn-primary">Make Admin</button>
                            <input type="hidden" value="change_user_role" name="command">
                            <input type="hidden" name="user_id" value="${user.userId}">
                        </form>
                         </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <hr/>

    <div class="mx-auto" style="width: 400px;">
        <h2 style="text-align: center">Cars</h2>
    </div>

    <div class="mx-auto" style="width: 800px;">
    <table class="table table-hover">
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


    <hr/>

    <form action="controller" method="post">
        <button class="btn btn-primary">Calculate taxis cost</button>
        <input type="hidden" name="command" value="cost_taxis">
        ${sessionScope.taxis_cost}
    </form>

        <hr/>
    <form action="controller" method="post">
        <button class="btn btn-primary">Sort by fuel_consumption</button>
        <input type="hidden" name="command" value="sort_by_fuel_consumption">
    </form>
    <hr/>
    <form action="controller" method="post">
        <button class="btn btn-primary">Sort by speed</button>
        <input type="number" min="0" name="lower_range" placeholder="Lower speed range" required>
        <input type="number" min="0" name="upper_range" placeholder="Upper speed range" required>
        <input type="hidden" name="command" value="sort_by_speed_range">
    </form>
    </div>
    ${message}
</div>

<c:import url="fragment/footer.jsp"/>
</body>
</html>

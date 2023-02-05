<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>


<c:import url="fragment/header.jsp"/>

<div class="container">
    <h1>Admin page</h1>
    <form action="controller" method="post">
        <button>Check all users</button>
        <input type="hidden" name="command" value="find_all_users">
    </form>

    <table>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>surname</th>
            <th>email</th>
            <th>role</th>
        </tr>

        <c:forEach var="user" items="${sessionScope.user_list}">
            <tr>
                <td>${user.userId}</td>
                <td>${user.name}</td>
                <td>${user.surname}</td>
                <td>${user.email}</td>
                <td>${user.role}$</td>
                <c:if test="${user.role ne 'ADMIN'}">
                    <td>
                        <form action="controller" method="post">
                            <button>Make Admin</button>
                            <input type="hidden" value="change_user_role" name="command">
                            <input type="hidden" name="user_id" value="${user.userId}">
                        </form>
                    </td>
                </c:if>

            </tr>
        </c:forEach>

    </table>

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
    <form action="controller" method="post">
        <button>Calculate taxis cost</button>
        <input type="hidden" name="command" value="cost_taxis">
        ${sessionScope.taxis_cost}
    </form>
    <form action="controller" method="post">
        <button>Sort by fuel_consumption</button>
        <input type="hidden" name="command" value="sort_by_fuel_consumption">
    </form>

    <form action="controller" method="post">
        <input type="number" min="0" name="lower_range" placeholder="Lower speed range" required>
        <input type="number" min="0" name="upper_range" placeholder="Upper speed range" required>
        <button>Sort by speed</button>
        <input type="hidden" name="command" value="sort_by_speed_range">
    </form>

${message}
</div>

<c:import url="fragment/footer.jsp"/>
</body>
</html>

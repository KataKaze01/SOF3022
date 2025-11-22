<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Flights Management - List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body class="bg-dark text-light pt-4 d-flex flex-column align-items-center">
<div class="container mt-4 mb-4" style="width: 90%;">
    <table class="table table-bordered table-dark table-striped table-hover align-middle">
        <thead>
            <tr class="text-center">
                <%-- Đổi cột theo Flights [cite: 27-32] --%>
                <th>No</th>
                <th>Flight ID</th>
                <th>Airline</th>
                <th>Departure City</th>
                <th>Arrival City</th>
                <th>Departure Time</th>
                <th>Arrival Time</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody class="text-center">
            <%-- Đổi items và var --%>
            <c:forEach var="f" items="${flights}" varStatus="st">
                <tr>
                    <td>${st.index + 1}</td>
                    <%-- Đổi các thuộc tính theo Flights --%>
                    <td>${f.flightID}</td>
                    <td>${f.airline}</td>
                    <td>${f.departureCity}</td>
                    <td>${f.arrivalCity}</td>
                    <td>
                        <fmt:formatDate value="${f.departureTime}" pattern="dd-MM-yyyy HH:mm" />
                    </td>
                    <td>
                        <fmt:formatDate value="${f.arrivalTime}" pattern="dd-MM-yyyy HH:mm" />
                    </td>
                    <td>
                        <%-- Đổi đường dẫn sang /flights và dùng flightID --%>
                        <a href="${pageContext.request.contextPath}/flights/edit/${f.flightID}" class="btn btn-sm btn-info me-1">Edit</a>

                        <%-- Form Xóa này không cần JS --%>
                        <form action="${pageContext.request.contextPath}/flights/delete" method="post" style="display:inline;">
                            <input type="hidden" name="id" value="${f.flightID}" />
                            <button type="submit" class="btn btn-sm btn-danger" onclick="return confirm('Bạn có chắc chắn muốn xóa chuyến bay này?')">
                                Remove
                            </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
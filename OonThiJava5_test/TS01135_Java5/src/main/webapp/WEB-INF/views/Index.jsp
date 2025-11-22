<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Flights Management - Index</title> <%-- Đổi Title --%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body class="bg-dark text-light pt-4">

<div class="container">
    <h1 class="text-center mb-4">Flights Management</h1> <%-- Đổi H1 --%>

    <%-- Đổi tên file include --%>
    <jsp:include page="FlightsForm.jsp" />

    <%-- Đổi tên file include --%>
    <jsp:include page="FlightsList.jsp" />
</div>

</body>
</html>

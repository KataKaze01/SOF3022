<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Movie Management - Index</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body class="bg-dark text-light pt-4">

<div class="container">
    <h1 class="text-center mb-4">🎬 Movie Management</h1>

    <%-- Include form --%>
    <jsp:include page="MoviesForm.jsp" />

    <%-- Include list --%>
    <jsp:include page="MoviesList.jsp" />
</div>

</body>
</html>

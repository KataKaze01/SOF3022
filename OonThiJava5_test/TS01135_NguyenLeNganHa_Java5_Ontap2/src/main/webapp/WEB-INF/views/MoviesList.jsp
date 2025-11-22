<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Movie Management - List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body class="bg-dark text-light pt-4 d-flex flex-column align-items-center">
<div class="container mt-4 mb-4" style="width: 90%;">
    <table class="table table-bordered table-dark table-striped table-hover align-middle">
        <thead>
            <tr class="text-center">
                <th>No</th>
                <th>ID</th>
                <th>Title</th>
                <th>Director</th>
                <th>Release Year</th>
                <th>Genre</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody class="text-center">
            <c:forEach var="m" items="${movies}" varStatus="st">
                <tr>
                    <td>${st.index + 1}</td>
                    <td>${m.movieID}</td>
                    <td>${m.title}</td>
                    <td>${m.director}</td>
                    <td>${m.releaseYear}</td>
                    <td>${m.genre}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/movies/edit/${m.movieID}" class="btn btn-sm btn-info me-1">Edit</a>

                        <form action="${pageContext.request.contextPath}/movies/delete" method="post" style="display:inline;">
                            <input type="hidden" name="id" value="${m.movieID}" />
                            <button type="submit" class="btn btn-sm btn-danger" onclick="return confirm('Bạn có chắc chắn muốn xóa movie này?')">
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

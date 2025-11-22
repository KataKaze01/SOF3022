<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>User Management - CRUD</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
    <style>
        body {
            background-color: #0f1c2e;
            color: white;
            font-family: 'Segoe UI', sans-serif;
            display: flex;
            flex-direction: column;
            align-items: center;
            padding-top: 30px;
        }
        .form-container {
            background-color: #14263d;
            border-radius: 15px;
            padding: 30px 40px;
            width: 450px;
            box-shadow: 0 0 15px rgba(255,255,255,0.1);
        }
        h2 {
            text-align: center;
            font-weight: bold;
        }
        input.form-control {
            margin-bottom: 10px;
            background-color: #eaeaea;
        }
        .btn-group button {
            margin-right: 8px;
            border-radius: 6px;
        }
        table {
            margin-top: 25px;
            width: 90%;
            background-color: #1c2f4d;
            color: #fff;
            text-align: center;
        }
        th, td {
            padding: 8px;
        }
        th {
            background-color: #223c66;
        }
        tr:nth-child(even) {
            background-color: #2c476d;
        }
    </style>
    <script>
            function clearForm() {
                // Xóa giá trị các ô input text
                document.getElementById('name').value = '';
                document.getElementById('email').value = '';
                document.getElementById('password').value = '';

                // Xóa ID ẩn (để form trở thành "Create" mới)
                document.getElementById('id').value = '';

                // Đặt lại radio button về 'User' (có giá trị 'false')
                document.querySelector('input[name="admin"][value="false"]').checked = true;
            }
        </script>
</head>
<body>

<div class="form-container">
    <h2>User Management – CRUD</h2>
    <p class="text-center">Fill in the data below.</p>

<form action="${pageContext.request.contextPath}/user/search" method="get">
    <input type="text" name="id" placeholder="Nhập ID">
    <input type="text" name="name" placeholder="Nhập tên người dùng">
    <button type="submit">Tìm kiếm</button>
</form>
<hr>

    <form:form modelAttribute="user" action="${pageContext.request.contextPath}/user/create" method="post">
        <form:hidden path="id"/>
        <form:input path="name" cssClass="form-control" placeholder="Full Name"/>
        <form:input path="email" cssClass="form-control" placeholder="E-mail Address"/>
        <form:password path="password" cssClass="form-control" placeholder="Password"/>

        <label>Role:</label>
        <form:radiobutton path="admin" value="true"/> Admin
        <form:radiobutton path="admin" value="false"/> User

<div class="btn-group mt-3">
    <button type="submit" class="btn btn-primary">Create</button>
    <button type="submit" formaction="${pageContext.request.contextPath}/user/update" class="btn btn-warning text-white">Update</button>
    <button type="submit" formaction="${pageContext.request.contextPath}/user/delete" class="btn btn-danger">Delete</button>

    <button type="button" class="btn btn-success" onclick="clearForm()">Reset</button>
</div>
    </form:form>
</div>

<table class="table table-bordered mt-4">
    <thead>
        <tr>
            <th>No</th>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Password</th>
            <th>Role</th>

            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="u" items="${users}" varStatus="st">
            <tr>
                <td>${st.index + 1}</td>
                <td>${u.id}</td>
                <td>${u.name}</td>
                <td>${u.email}</td>
                <td>${u.password}</td>
                <td><c:choose><c:when test="${u.admin}">Admin</c:when><c:otherwise>User</c:otherwise></c:choose></td>

                <td>
                    <a href="${pageContext.request.contextPath}/user/edit/${u.id}" class="btn btn-sm btn-info">Edit</a>

                    <form:form action="${pageContext.request.contextPath}/user/delete" method="post" style="display:inline; margin-left: 5px;">
                        <input type="hidden" name="id" value="${u.id}" />
                        <button type="submit" class="btn btn-sm btn-danger" onclick="return confirm('Bạn có chắc chắn muốn xóa user này?')">
                            Remove
                        </button>
                    </form:form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>

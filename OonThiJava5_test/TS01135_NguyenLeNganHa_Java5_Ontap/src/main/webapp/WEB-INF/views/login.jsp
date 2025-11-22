<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
</head>
<body>
<h2>Đăng nhập</h2>

<c:if test="${param.error != null}">
    <p style="color:red;">Sai tên đăng nhập hoặc mật khẩu!</p>
</c:if>

<c:if test="${param.logout != null}">
    <p style="color:green;">Đăng xuất thành công!</p>
</c:if>

<form action="${pageContext.request.contextPath}/doLogin" method="post">
    Username: <input type="text" name="username"/><br/>
    Password: <input type="password" name="password"/><br/>
    <button type="submit">Đăng nhập</button>
</form>

</body>
</html>

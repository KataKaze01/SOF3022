<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<%-- Container cho form --%>
<div class="container col-md-8 col-lg-6 col-xl-5 p-4 rounded bg-secondary bg-opacity-25 shadow mb-4">
    <h2 class="text-center fw-bold mb-3">Movie Management – CRUD</h2>
    <p class="text-center">Fill in the data below.</p>

    <%-- Form tìm kiếm (giữ nguyên) --%>
    <form action="${pageContext.request.contextPath}/movies/search" method="get" class="row g-2 mb-3 align-items-center">
        <div class="col">
            <input type="number" name="id" class="form-control form-control-sm" placeholder="Nhập Movie ID">
        </div>
        <div class="col">
             <input type="text" name="title" class="form-control form-control-sm" placeholder="Nhập Title">
        </div>
        <div class="col-auto">
             <button type="submit" class="btn btn-info btn-sm">Tìm kiếm</button>
        </div>
    </form>
    <hr/>

    <%-- Form chính (Create/Update) --%>
    <form:form modelAttribute="movie" id="movieForm" method="post" action="${pageContext.request.contextPath}/movies/create"> <%-- Thêm id="movieForm" --%>
        <form:hidden path="movieID" id="movieID"/> <%-- Giữ nguyên id="movieID" --%>
        <div class="mb-2">
            <form:input path="title" id="title" cssClass="form-control" placeholder="Title"/>
        </div>
        <div class="mb-2">
            <form:input path="director" id="director" cssClass="form-control" placeholder="Director"/>
        </div>
        <div class="mb-2">
            <form:input path="releaseYear" id="releaseYear" type="number" cssClass="form-control" placeholder="Release Year"/>
        </div>
        <div class="mb-2">
             <form:input path="genre" id="genre" cssClass="form-control" placeholder="Genre"/>
        </div>

        <div class="btn-group mt-3 d-flex justify-content-center">
            <button type="submit" class="btn btn-primary me-2">Create</button>
            <button type="button" onclick="submitUpdate()" class="btn btn-warning text-dark me-2">Update</button> <%-- Đổi type="submit" thành type="button" và gọi JS --%>
            <%-- Thêm lại nút Delete, dùng type="button" và gọi hàm JS mới --%>
            <button type="button" onclick="submitDelete()" class="btn btn-danger me-2">Delete</button>
            <button type="button" class="btn btn-success" onclick="clearForm()">Reset</button>
        </div>
    </form:form>

    <%-- Form ẩn dùng riêng cho việc Delete --%>
    <form id="deleteForm" action="${pageContext.request.contextPath}/movies/delete" method="post" style="display: none;">
        <input type="hidden" name="id" id="deleteMovieId"/>
    </form>
</div>

<script>
    function clearForm() {
        document.getElementById('movieForm').reset(); // Reset form chính
        document.getElementById('movieID').value = ''; // Đảm bảo ID ẩn bị xóa
         // Đặt lại action về create phòng trường hợp trước đó là update
        document.getElementById('movieForm').action = '${pageContext.request.contextPath}/movies/create';
        document.getElementById('title').focus();
    }

    function submitUpdate() {
        const form = document.getElementById('movieForm');
        form.action = '${pageContext.request.contextPath}/movies/update'; // Đặt action là update
        form.submit();
    }

    function submitDelete() {
        const movieId = document.getElementById('movieID').value;
        if (!movieId) {
            alert("Vui lòng chọn một movie để xóa (bằng cách nhấn Edit).");
            return;
        }
        if (confirm('Bạn có chắc chắn muốn xóa movie này?')) {
            // Đặt giá trị ID vào form ẩn
            document.getElementById('deleteMovieId').value = movieId;
            // Submit form ẩn
            document.getElementById('deleteForm').submit();
        }
    }
</script>
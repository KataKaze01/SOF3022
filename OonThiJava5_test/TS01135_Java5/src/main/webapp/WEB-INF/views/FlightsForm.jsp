<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<div class="container col-md-8 col-lg-6 col-xl-5 p-4 rounded bg-secondary bg-opacity-25 shadow mb-4">
    <h2 class="text-center fw-bold mb-3">Flights Management – CRUD</h2>
    <p class="text-center">Fill in the data below.</p>

    <%-- Form tìm kiếm --%>
    <form action="${pageContext.request.contextPath}/flights/search" method="get" class="row g-2 mb-3 align-items-center">
        <div class="col">
            <input type="number" name="id" class="form-control form-control-sm" placeholder="Nhập Flight ID">
        </div>
        <div class="col">
             <input type="text" name="airline" class="form-control form-control-sm" placeholder="Nhập Airline">
        </div>
        <div class="col-auto">
             <button type="submit" class="btn btn-info btn-sm">Tìm kiếm</button>
        </div>
    </form>
    <hr/>

    <%-- Form chính --%>
    <form:form modelAttribute="flight" id="flightForm" method="post" action="${pageContext.request.contextPath}/flights/create">

        <%--
            PDF yêu cầu nhập FlightID bằng tay, nên chúng ta dùng <form:input>
            Trường này cũng sẽ được dùng để gửi ID khi Update và Delete
        --%>
        <div class="mb-2">
             <label for="flightID" class="form-label">Flight ID</label>
            <form:input path="flightID" id="flightID" type="number" cssClass="form-control" placeholder="Flight ID"/>
        </div>

        <div class="mb-2">
            <form:input path="airline" id="airline" cssClass="form-control" placeholder="Airline"/>
        </div>
        <div class="mb-2">
            <form:input path="departureCity" id="departureCity" cssClass="form-control" placeholder="Departure City"/>
        </div>
        <div class="mb-2">
             <form:input path="arrivalCity" id="arrivalCity" cssClass="form-control" placeholder="Arrival City"/>
        </div>
        <div class="mb-2">
             <label for="departureTime" class="form-label">Departure Time</label>
             <form:input path="departureTime" id="departureTime" type="datetime-local" cssClass="form-control"/>
        </div>
         <div class="mb-2">
             <label for="arrivalTime" class="form-label">Arrival Time</label>
             <form:input path="arrivalTime" id="arrivalTime" type="datetime-local" cssClass="form-control"/>
        </div>

        <%-- *** ĐÃ THÊM LẠI NÚT DELETE (KHÔNG DÙNG JS) *** --%>
        <div class="btn-group mt-3 d-flex justify-content-center">

            <button type="submit" class="btn btn-primary me-2">Create</button>

            <button type="submit" class="btn btn-warning text-dark me-2"
                    formaction="${pageContext.request.contextPath}/flights/update">Update</button>

            <%-- Nút Delete này submit formaction đến /delete --%>
            <button type="submit" class="btn btn-danger me-2"
                    formaction="${pageContext.request.contextPath}/flights/delete">Delete</button>

            <a href="${pageContext.request.contextPath}/flights/reset" class="btn btn-success">Reset</a>
        </div>
    </form:form>

    <%-- Không cần form ẩn hoặc thẻ <script> --%>
</div>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css"
          integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">

    <title>MedLog- You lifetime exams logs</title>
</head>
<body style="padding: 10px;">
    <div>
    <h1>${doctor.name}</h1>
    <div class="border" style="margin: 10px; padding: 5px; width: fit-content;">
        <span style="max-width: 200px;">
            ${doctor.description}
        </span>
        <div>
            <span class="font-weight-bold">Member Since: </span> <span><fmt:formatDate pattern="dd/MM/yyyy" value="${doctor.memberSince.time}" /></span>
        </div>
    </div>

    <form action='<c:url value="/appointment/add"/>' method="post" enctype="multipart/form-data">
        <input type="hidden" value="${doctor.id }" name="doctorId" >

        <table class="table table-sm table-bordered table-striped" style="max-width: 33%;">
            <thead>
                <tr>
                    <th></th>
                    <th>Health Insurance</th>
                    <th>Consultation Price</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${doctor.appointmentPriceList}" var="price">
                    <tr>
                        <th style="text-align: center;">
                            <input type="radio" value="${price.value}" name="appointmentPrice" checked="checked" />
                        </th>
                        <th>${price.healthInsurance}</th>
                        <th>${price.value}</th>
                    </tr>
                </c:forEach>
            </tbody>
            <div>
                Appointment Date: <input type="text" name="appointmentDate" />
            </div>
        </table>

        <button type="submit" class="btn btn-primary" title="Schedule Appointment ${doctor.name}">Schedule Appointment</button>
    </form>
    </div>

</body>
</html>

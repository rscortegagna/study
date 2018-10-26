<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
    <title>MedLog- You lifetime exams logs</title>
</head>
<body>

    <tbody>
        <c:forEach items="${appointmentSchedule.appointments}" var="appointment">
            <tr>
                <td>${appointment.doctor.name}</td>
                <td>${appointment.appointmentPrice}</td>
                <td><span><fmt:formatDate pattern="dd/MM/yyyy" value="${appointment.date.time}" /></span></td>
            </tr>

        </c:forEach>

    </tbody>
</body>
</html>

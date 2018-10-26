<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
    <title>MedLog- You lifetime exams logs</title>
</head>
    <body style="padding: 10px;">
        <div>
            <a href="${s:mvcUrl('ASC#appointments').build() }">Appointments to Review (${appointmentSchedule.total})</a>
        </div>

        <h1> Doctor's List</h1>
        <div> ${success} </div>
        <table class="table table-sm" style="max-width: 75%;">
            <thead>
                <tr>
                    <td>Name</td>
                    <td>Description</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${doctors}" var="doctor">
                    <tr>
                        <td><a href="${s:mvcUrl('DC#details').arg(0,doctor.id).build()}">${doctor.name}</a></td>
                        <td>${doctor.description}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>

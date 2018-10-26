<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
    <title>MedLog- You lifetime exams logs</title>
</head>
    <body>
        <form:form action="${s:mvcUrl('DC#save').build()}" method="POST" commandName="doctors" enctype="multipart/form-data">
            <div>
                <label>Name: </label>
                <form:input path="name" />
                <form:errors path="name" />
            </div>

            <div>
                <label>Description: </label>
                <form:textarea rows="10" cols="20" path="description" />
                <form:errors path="description" />
            </div>

            <div>
                <label>Member Since: </label>
                <form:input type="text" path="memberSince" />
                <form:errors path="memberSince" />
            </div>

            <c:forEach items="${healthInsurances}" var="healthInsurance" varStatus="status">
                <div>
                    <label>${healthInsurance}</label>
                    <form:input path="appointmentPriceList[${status.index}].value" />
                    <form:hidden path="appointmentPriceList[${status.index}].healthInsurance" value="${healthInsurance}" />
                </div>
            </c:forEach>

            <div>
                <label>Doctor Photo</label>
                <input type="file" name="photo" />
            </div>

            <button type="submit">Save</button>
        </form:form>
    </body>
</html>

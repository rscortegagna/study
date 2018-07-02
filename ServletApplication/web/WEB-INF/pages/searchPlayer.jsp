<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
Search Result:
<ul>
    <c:forEach var="player" items="${players}">
        <li>${player.id}: ${player.name}</li>
    </c:forEach>
</ul>
</body>
</html>

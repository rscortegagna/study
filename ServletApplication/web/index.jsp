<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <body>
        <title>World Tennis Ranking</title>
        <h1>World Tennis Ranking</h1>
        <h2>
            <c:if test="${loggedUser!=null}">
                Logged in as ${loggedUser.email}<br/>
            </c:if>
        </h2>

        <h3>Add new Tennis Player</h3>
        <form action="wtr" method="post">
            <input type="hidden" name="task" value="NewPlayer" />
            Player Name: <input type="text" name="playerName"/>
            <input type="submit" value="Save"/>
        </form>

        <h3>Search Tennis Player</h3>
        <form action="wtr" method="post">
            <input type="hidden" name="task" value="SearchPlayer" />
            Player Name: <input type="text" name="filter"/>
            <input type="submit" value="Search"/>
        </form>

        <h3>Login</h3>
        <form action="login" method="post">
            Email: <input type="text" name="email"/>
            Password: <input type="text" name="password"/>
            <input type="submit" value="Login"/>
        </form>

        <form action="wtr" method="post">
            <input type="hidden" name="task" value="Logout" />
            <input type="submit" value="Logout" />
        </form>
    </body>
</html>
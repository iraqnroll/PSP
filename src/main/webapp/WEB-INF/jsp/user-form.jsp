<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>User</title>
    </head>
    <body>
        <header>
            <h1>Sukurti nauja vartotoja</h1>
        </header>

        <form:form method="post" action="create-user" modelAttribute="user">
            Vardas: <input type="text" name="name"><br/>
            Pavarde: <input type="text" name="surname"><br/>
            El. Pastas: <input type="text" name="eMail"><br/>
            Tel. Nr : <input type="text" name="phone"><br/>
            Adresas : <input type="text" name="address"><br/>
            Slaptazodis : <input type="text" name="password"><br/>
            <input type="submit" value="Sukurti"/>
        </form:form>

        <c:choose>
            <c:when test="${result == true}">
                <div>Sekmingai sukurtas naujas vartotojas</div>
                <div>${newUser}</div>
            </c:when>
            <c:when test="${result == false}">
                <div>Klaida : ${errors}</div>
            </c:when>
        </c:choose>

    </body>
</html>
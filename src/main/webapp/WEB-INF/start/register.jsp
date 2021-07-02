<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>BikeUp</title>
    <style><%@include file="/css/style.css"%></style>
</head>
<body>
<div class="logo_start">
    <img src="<c:url value='/images/193240896_311767273863710_3235863038840980410_n.png'/>" width="350" height="250" alt="logo"/>
</div>

<div class="mainR">
    <div class="container_start">
        <ul><h2>Regulamin aplikacji</h2> <br>
            <li><h3>Będę miły i uprzejmy dla wszystkich użytkowników,</h3></li>
            <li><h3>Będę obiektywnie oceniał użytkowników,</h3></li>
            <li><h3>Będę cechował się wysoką kulturą osobistą,</h3></li>
    </ul>
    </div>

    <div>
    </div>
    <div class="registry ">
        <form:form method="post" modelAttribute="userRegistry">

            <label>Login:<br/>
                <form:input  path="login" placeholder="Podaj login"/>
            </label><br/>
            <form:errors path="login"/>
            <br/>
            <label>Hasło:<br/>
                <form:input path="password" placeholder="Podaj hasło"/>
            </label><br/>
            <form:errors path="password"/>
            <br/>
            <label>Województwo<br>
                (można zmienić):<br/>
                <form:select path="province" >
                    <form:option value="0" label="Wybierz"/>
                            <form:options items="${allProvinces}" itemLabel="name" itemValue="id"/>
                </form:select>
            </label><br/>
            <form:errors path="province"/>
            <br/><br/>
            <form:checkbox path="loyalty"/> <span>Będę przestrzegał regulaminu korzystania z aplikacji.</span>
            <br/>
            <form:errors path="loyalty"/>
            <br/><br/>
            <form:button class="myButton"  type="submit">Zarejestruj</form:button> <input  class="myButton" type="button" value="Wróć" onclick="location.href='/'">
        </form:form>
    </div>
</div>

</body>
</html>
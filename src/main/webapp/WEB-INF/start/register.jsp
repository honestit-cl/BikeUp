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
        <ul><h2>Regulamin strony</h2> <br>
            <li><h3>Będę miły dla wszystkich użytkowników aplikacji.</h3></li>
    </ul>
    </div>

    <div>
    </div>
    <div class="registry ">
        <form:form method="post" modelAttribute="userRegistry">

            <label>Login:<br/>
                <form:input path="login"/>
            </label><br/>
            <form:errors path="login"/>
            <br/>
            <label>Hasło:<br/>
                <form:input path="password"/>
            </label><br/>
            <form:errors path="password"/>
            <br/>
            <label>Województwo:<br/>
                <form:select path="province" items="${allProvinces}" itemLabel="name" itemValue="id"/>
            </label><br/>
            <form:errors path="province"/>
            <br/><br/>
            <form:checkbox path="loyalty"/> <span>Będę przestrzegał regulaminu korzystania ze strony.</span>
            <br/>
            <form:errors path="loyalty"/>
            <br/><br/>
            <form:button type="submit">Zarejestruj</form:button>
        </form:form>
    </div>
</div>

</body>
</html>
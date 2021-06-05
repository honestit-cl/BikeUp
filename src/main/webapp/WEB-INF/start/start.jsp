<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>BikeUp</title>
    <style><%@include file="/css/style.css"%></style>
</head>
<body>
<div class="logo_start">
    <img src="<c:url value="/images/193240896_311767273863710_3235863038840980410_n.png"/>" width="350" height="250" alt="logo"/>
</div>
<div class="main">
    <div class="container_start">
        <h2>Witaj w BikeUp!</h2> <br>
        <h2>Znjadziesz tutaj partnerów do wspólych treningów, jak również będziesz mógł śledzić swoje postępy.</h2>
    </div>

    <div></div>
    <div class="container">
        <form action="/login" method="post" >
            <label>Logowanie</label>
            <div>
                <input type="text" id="login" name="login" placeholder="Podaj login">
            </div>
            <br>
            <div>
                <input type="password"  id="password" name="password" placeholder="Podaj hasło">
            </div>
            <br>
            <button type="submit">Zaloguj</button> <input type="button" value="Zarejestruj" onclick="location.href='/registry'">
        </form>
    </div>
</div>

</body>
</html>
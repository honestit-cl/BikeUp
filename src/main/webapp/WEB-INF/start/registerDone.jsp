<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>BikeUp</title>
    <style>
        <%@include file="/css/style.css" %>
    </style>
</head>
<body>
<div class="logo_start">
    <img src="<c:url value='/images/193240896_311767273863710_3235863038840980410_n.png'/>" width="350" height="250"
         alt="logo"/>
</div>
<div class="info">
    <span>
    Twoje konto zostało utworzone.<br/>
    Możesz już zacząć swoją przygodę :)<br/>
    <br/>
    </span>
    <input type="button" value="Strona główna" onclick="location.href='/'">
</div>
</body>
</html>
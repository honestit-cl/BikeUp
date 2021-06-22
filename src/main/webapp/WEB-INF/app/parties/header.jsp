<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>BikeUp</title>
    <style><%@include file="/css/appStyle.css"%></style>
    <script src="/scripts/script.js" defer></script>
</head>
<body>
<button class="hamburger">
        <span class="hamburger__box">
            <span class="hamburger__inner"></span>
        </span>
</button>
<div class="navigation">
    <ul class="navigation__list">
        <li><img src="<c:url value='/images/193240896_311767273863710_3235863038840980410_n.png'/>" width="180" height="120" alt="logo"/></li>
        <li class="navigation__item"><a href="/app/news">Bądź na bieżąco</a></li>
        <li class="navigation__item"><a href="/app/addTour">Dodaj nową trasę</a></li>
        <li class="navigation__item"><a href="">Wyszukaj trasy</a></li>
        <li class="navigation__item"><a href="">Twoje trasy</a></li>
        <li class="navigation__item"><a href="">Twój profil</a></li>
        <li class="navigation__item"><a href="/logout">Wyloguj</a></li>
        <li class="navigation__item"><span>Copyright BikeUp.pl</span></li>
    </ul>
</div>
<div class="mainApp">
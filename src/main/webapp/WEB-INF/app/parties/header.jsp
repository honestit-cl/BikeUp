<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BikeUp</title>
    <style><%@include file="/css/appStyle.css"%></style>
    <script src="/scripts/script.js" defer></script>
</head>
<body>
<button class="hamburger">
    <h3>MENU</h3>
        <span class="hamburger__box">
            <span class="hamburger__inner"></span>
        </span>
</button>
<div class="navigation">
    <ul class="navigation__list">
        <li><img src="<c:url value='/images/193240896_311767273863710_3235863038840980410_n.png'/>" width="180" height="120" alt="logo"/></li>
        <li class="navigation__item"><span class="panel">Witaj, ${logged} !</span></li>
        <li class="navigation__item"><a href="/app/news">Bądź na bieżąco</a></li>
        <li class="navigation__item"><a href="/app/success">Podziel się swoim sukcesem</a></li>
        <li class="navigation__item"><a href="/app/addTour">Dodaj nową trasę</a></li>
        <li class="navigation__item"><a href="/app/search">Wyszukaj trasy</a></li>
        <li class="navigation__item"><a href="/app/searchUser">Wyszukaj użytkownika</a></li>
        <li class="navigation__item"><a href="/app/tours">Twoje trasy</a></li>
        <li class="navigation__item"><a href="/app/points">Twoje punkty za trasy</a></li>
        <li class="navigation__item"><a href="/app/participation">Uczestnictwo w trasach</a></li>
        <li class="navigation__item"><a href="/app/profile">Twój profil</a></li>
        <li class="navigation__item"><a href="/app/rules">Zasady aplikacji</a></li>
        <li class="navigation__item"><a href="/logout">Wyloguj</a></li>
        <li class="navigation__item"><span class="panel">Copyright BikeUp.pl</span></li>
    </ul>
</div>
<div class="mainApp" style="overflow: auto">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/app/pageParts/header.jsp" %>
<h1>Potwierdzenie usunięcia wycieczki</h1><br/>
<form method="post" action="/app/tours/delete">
    <p>Czy na pewno chesz usunąć wycieczkę, która ma obyć się ${tour.date}?(id = ${tour.id})?</p>
    <p>Potwierdzasz tym samym że osoby które zostały zapisane na ta wycieczkę mają tego świadomość.</p>
    <p>
        <input type="hidden" name="id" value="${tour.id}"/>
        <br/>
        <button class="myButton" type="submit">Tak</button> <input class="myButton" type="button" value="Nie" onclick="location.href='/app/tours'">
    </p>
</form>
<%@ include file="/WEB-INF/app/pageParts/footer.jsp" %>
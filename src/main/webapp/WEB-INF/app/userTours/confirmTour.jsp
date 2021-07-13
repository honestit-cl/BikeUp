<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/app/parties/header.jsp" %>
<h1>Potwierdzenie odbycia się wycieczki</h1><br/>
<form method="post" action="/app/tours/confirmTour">
    <p>Czy na pewno chesz potwierdzić wycieczkę, która ma odbyła się ${tour.date}?(id = ${tour.id})?</p>
    <p>Potwierdzasz tym samym że wycieczka miała miejsce według ustalonych wytycznych.</p>
    <p>
        <input class="myButton" type="hidden" name="id" value="${tour.id}"/>
        <br/>
        <button class="myButton" type="submit">Tak</button> <input class="myButton" type="button" value="Nie" onclick="location.href='/app/tours'">
    </p>
</form>
<%@ include file="/WEB-INF/app/parties/footer.jsp" %>
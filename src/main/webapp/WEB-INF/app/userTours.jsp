<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/app/parties/header.jsp" %>
<h1>Twoje wycieczki</h1><br/>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Data</th>
        <th>Miasto</th>
        <th>Dystans</th>
        <th>Czas</th>
        <th>Status</th>
        <th>Potwierdzeni uczestnicy</th>
        <th>Dostępne akcje</th>
    </tr>
<%--    <c:forEach items="${allTours}" var="tour">--%>
<%--        <tr>--%>
<%--            <td>${tour.id}</td>--%>
<%--            <td>${tour.date}</td>--%>
<%--            <td>${tour.city.name}</td>--%>
<%--            <td>${tour.distance} km</td>--%>
<%--            <td>${tour.hours}</td>--%>
<%--            <td>${tour.active}</td>--%>
<%--            <td>${tour.realParticipants}/${tour.participants}</td>--%>
<%--            <td>--%>
<%--                <span><a href="">Usuń</a></span><br/>--%>
<%--                <span><a href="">Edytuj</a></span><br/>--%>
<%--                <span><a href="">Szczegóły</a></span><br/>--%>
<%--                <span><a href="">Potwierdź wykonanie</a></span><br/>--%>
<%--                <span><a href="">Potwierdź uczestników</a></span>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
</table>
<script src="/scripts/userTourList.js" defer></script>
<%@ include file="/WEB-INF/app/parties/footer.jsp" %>
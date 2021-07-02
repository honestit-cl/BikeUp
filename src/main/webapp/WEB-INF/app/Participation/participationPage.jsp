<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/app/parties/header.jsp" %>
<h1>Wycieczki w których uczestniczysz:</h1><br/>

<table border="1">
    <tr>
        <th>Id</th>
        <th>Data</th>
        <th>Miasto</th>
        <th>Dystans</th>
        <th>Czas</th>
        <th>Status</th>
        <th>Potwierdzeni uczestnicy</th>
        <th>Twój status</th>
        <th>Dostępne akcje</th>
    </tr>
    <c:forEach items="${tours}" var="tour">
        <tr>
            <td>${tour.key.id}</td>
            <td>${tour.key.date}</td>
            <td>${tour.key.city.name}</td>
            <td>${tour.key.distance}</td>
            <td>${tour.key.hours}</td>
            <td>${tour.key.active}</td>
            <td>${tour.key.realParticipants -1} / ${tour.key.participants}</td>
            <td>${tour.value}</td>
            <td><span><a href="/app/participation/details/${tour.key.id}">Szczegóły</a></span><br/>
                <c:if test="${tour.key.active == 'open'}">
                    <span><a href="/app/participation/singOut/${tour.key.id}">Wypisz się</a></span><br/>
                </c:if>
                <c:if test="${tour.key.active == 'closed'}">
                    <span><a href="/app/participation/addPointsList/${tour.key.id}">Przydziel punkty</a></span><br/>
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>
<%@ include file="/WEB-INF/app/parties/footer.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/app/pageParts/header.jsp" %>
<h1>Wycieczki w których uczestniczysz:</h1><br/>

<table border="1">
    <tr>
        <th>Id</th>
        <th>Data</th>
        <th>Dystans</th>
        <th>Czas</th>
        <th>Start wycieczki</th>
        <th>Meta wycieczki</th>
        <th>Status</th>
        <th>Potwierdzeni uczestnicy</th>
        <th>Twój status</th>
        <th>Dostępne akcje</th>
    </tr>
    <c:forEach items="${tours}" var="tour">
        <tr>
            <td>${tour.key.id}</td>
            <td>${tour.key.date}</td>
            <td>${tour.key.distance} km</td>
            <td>${tour.key.hours}</td>
            <td>${tour.key.startPostalCode}<br/>
                    ${tour.key.startPlace}</td>
            <td>${tour.key.endPostalCode}<br/>
                    ${tour.key.endPlace}</td>
            <td>${tour.key.active}</td>
            <td>${tour.key.realParticipants -1} / ${tour.key.participants}</td>
            <td>${tour.value}</td>
            <td><span><input type="button" value="Szczegóły" onclick="location.href='/app/participation/details/${tour.key.id}'"></span><br/>
                <c:if test="${tour.key.active == 'otwarta'}">
                    <span><input type="button" value="Wypisz się" onclick="location.href='/app/participation/singOut/${tour.key.id}'"></span><br/>
                </c:if>
                <c:if test="${tour.key.active == 'zamknięta'}">
                    <span><input type="button" value="Przydziel punkty" onclick="location.href='/app/participation/addPointsList/${tour.key.id}'"></span><br/>
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>
<%@ include file="/WEB-INF/app/pageParts/footer.jsp" %>

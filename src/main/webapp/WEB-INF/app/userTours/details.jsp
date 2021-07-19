<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/app/pageParts/header.jsp" %>
<h1>Szczegóły wycieczki</h1><br/>
<p>Id wycieczki: ${details.id}</p>
<table border="1">
    <tr>
        <th>Miejsce zbiórki</th>
        <th>Opis wycieczki</th>
        <th>Powrót</th>
        <th>Mapa</th>

    </tr>
    <tr>
        <td>${details.gatheringPlace}</td>
        <td>${details.description}</td>
        <td>${details.returning}</td>
        <td><c:if test="${details.mapLink != ''}"><a target="_blank" href="${details.mapLink}">Link</a>
        </c:if>
        </td>
    </tr>
</table>
<br/>
<br/>
<input type="button" class="myButton" value="Powrót" onclick="location.href='/app/tours'">
<%@ include file="/WEB-INF/app/pageParts/footer.jsp" %>
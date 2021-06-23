<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/app/parties/header.jsp" %>
<h1>Szczegoły wycieczki</h1><br/>
<h3> Id wycieczki: ${details.id}</h3>
<table border="1">
    <tr>
        <th>Miejsce startu</th>
        <th>Opis</th>
        <th>Odległość od miasta</th>
        <th>Mapa</th>

    </tr>
        <tr>
            <td>${details.start}</td>
            <td>${details.description}</td>
            <td>${details.howFar}</td>
            <td>${details.mapLink}</td>
        </tr>
</table><br/>
<input type="button" value="Powrót" onclick="location.href='/app/tours'">
<%@ include file="/WEB-INF/app/parties/footer.jsp" %>
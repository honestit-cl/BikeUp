<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/app/parties/header.jsp" %>
<h1>Szczegoły wycieczki</h1><br/>
<h4> Id wycieczki: ${details.id}</h4>
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
            <td><a target="_blank" href="${details.mapLink}">Link</a></td>
        </tr>
</table><br/>
<br/>
<input type="button" value="Powrót" class="myButton" onclick="location.href='/app/search'">
<iframe src="${details.mapLink}" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
<%@ include file="/WEB-INF/app/parties/footer.jsp" %>
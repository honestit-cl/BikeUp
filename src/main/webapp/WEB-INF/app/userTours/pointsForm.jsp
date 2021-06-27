<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/app/parties/header.jsp" %>
<h1>Przydziel punkty</h1><br/>
<p>Dodajesz właśnie ocenę dla użytkownika o loginie: ${user.username}</p>
<form:form action="/app/tours/addPointsConfirmed" method="post" modelAttribute="pointAdd">
    <form:hidden path="tourId" value="${pointAdd.tourId}"/>
    <form:hidden path="userIdToAdd" value="${pointAdd.userIdToAdd}"/>
    <label>Ilość punktów:<br/>
        <form:input  path="amount" placeholder="Ilość punktów"/>
    </label><br/>
    <form:errors path="amount"/>
    <br/>
    <label>Opis:<br/>
        <form:textarea rows="5" cols="40" path="description" placeholder="Dodaj opis"/>
    </label><br/>
    <form:errors path="description"/>
    <br/>
    <form:button type="submit">Dodaj</form:button>
</form:form>
<br/>
<br/>
<input type="button" class="myButton" value="Powrót" onclick="location.href='/app/tours/addPointsList/${pointAdd.tourId}'">
<%@ include file="/WEB-INF/app/parties/footer.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/app/parties/header.jsp" %>
<h1>Potwierdź uczestników</h1><br/>
<p>Uczestnicy wycieczki, która ma obyć się ${tour.date}.<br/>
Id wycieczki : ${tour.id}</p><br/>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Nazwa Użykownika</th>
        <th>Status</th>
        <th>Dostępne akcje</th>
    </tr>
    <c:forEach items="${members}" var="member">
        <tr>
            <th>${member.id}</th>
            <th>${member.user.username}</th>
            <th>${member.status}</th>
            <th><c:if test="${member.status == 'oczekujący'}">
                <c:if test="${tour.realParticipants -1 < tour.participants}">
                <input type="button" value="Potwierdź" onclick="location.href='/app/tours/setActive/${member.id}/${tour.id}'">
            </c:if>
            </c:if>
            </th>
        </tr>
    </c:forEach>
</table>
<br/>
<br/>
<input type="button" class="myButton" value="Powrót" onclick="location.href='/app/tours'">
<%@ include file="/WEB-INF/app/parties/footer.jsp" %>
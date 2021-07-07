<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/app/parties/header.jsp" %>
<h1>Przydziel punkty</h1><br/>
<p>Użytkownicy, którym możesz przydzielić punkty za trasę z dnia ${tour.date}.<br/>
    Id wycieczki : ${tour.id}</p><br/>

<table border="1">
    <tr>
        <th>Użytkownik</th>
        <th>Dostępne akcje</th>
    </tr>
    <c:forEach items="${members}" var="member">
        <c:if test="${member.status == 'aktywny'}">
        <tr>
            <th>${member.user.username}</th>
            <th><input type="button" value="Przydziel" onclick="location.href='/app/participation/addPoints/${member.user.id}/${tour.id}'"></th>
        </tr>
        </c:if>
    </c:forEach>
</table>
<br/>
<br/>
<input type="button" class="myButton" value="Powrót" onclick="location.href='/app/participation'">
<%@ include file="/WEB-INF/app/parties/footer.jsp" %>
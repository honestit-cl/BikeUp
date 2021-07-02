<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/app/parties/header.jsp" %>
<h1>Konto użytkownika ${user.username}</h1><br/>
<table border="1">
    <c:if test="${user.visibility == 'show'}">
    <tr>
        <td>Imie</td>
        <td>${user.firstName}</td>
    </tr>
    <tr>
        <td>Nazwisko</td>
        <td>${user.lastName}</td>
    </tr>
    <tr>
        <td>Wojewódźtwo</td>
        <td>${user.province.name}</td>
    </tr>
    <tr>
        <td>Punkty</td>
        <td>${user.points}</td>
    </tr>
    <tr>
        <td>Data zalożenia konta</td>
        <td>${user.creationDate}</td>
    </tr>
    </c:if>
</table><br/>
<br/>
<input type="button" value="Edytuj" class="myButton" onclick="location.href='/app/profile/edit'">
<%@ include file="/WEB-INF/app/parties/footer.jsp" %>
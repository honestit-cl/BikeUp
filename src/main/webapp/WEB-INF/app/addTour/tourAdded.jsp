<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/app/pageParts/header.jsp" %>
<h1>Dodawanie wycieczki</h1><br/>
<c:out value="${added}"/>
<p>Twoja wycieczka została pomyślnie dodana i powinna od razu pojawić się w Twoich trasach.</p>
<br/>
<br/>
<input type="button" class="myButton" value="Przejdź" onclick="location.href='/app/tours'">
<%@ include file="/WEB-INF/app/pageParts/footer.jsp" %>
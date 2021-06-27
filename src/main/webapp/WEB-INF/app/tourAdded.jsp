<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/app/parties/header.jsp" %>
<h1>Dodawanie wycieczki</h1><br/>
<c:out value="${added}"/>
<h2>Twoja wycieczka została pomyślnie dodana i powinna od razu pojawić się w Twoich trasach.</h2>
<br/>
<br/>
<input type="button" class="myButton" value="Powrót" onclick="location.href='/app/tours'">
<%@ include file="/WEB-INF/app/parties/footer.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/app/parties/header.jsp" %>
<h1>Dodawanie wycieczki</h1><br/>
<form method="get" action="/app/addTour/form">
    <p>Wybierz wojewódźtwo w którym odbędzie się trasa*:</p>
        <br/>
        <select name="id">
            <option value="0" label="Wybierz"></option>
            <c:forEach items="${allProvinces}" var="province">
            <option value="${province.id}">${province.name}</option>
            </c:forEach>
        </select>
    <br/>
    <br/>
    <span>
    * W przypadku nie wybrania województwa, ustawione zostaje zaznaczone podczas rejestracji.
</span><br/><br/>
    <button class="myButton" type="submit">Wybierz</button>
</form>
<script src="/scripts/dataScript.js" defer></script>
<%@ include file="/WEB-INF/app/parties/footer.jsp" %>
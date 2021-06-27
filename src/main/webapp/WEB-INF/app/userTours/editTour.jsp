<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/app/parties/header.jsp" %>
<h1>Edytuj wycieczkę</h1><br/>
<form:form method="post" action="/app/tours/edit" modelAttribute="tourEdit">
    <form:hidden path="tourId"/>
    <label>Szacowany dystans trasy:<br/>
        <form:input type="number" path="distance" placeholder="Liczba kilometrów"/>
    </label><br/>
    <form:errors path="distance"/>
    <br/>

    <label>Szacowany czas przebycia trasy:<br/>
        <form:select path="hours">
            <form:option value=" " label="Wybierz"/>
            <form:options items="${hours}"/>
        </form:select>
    </label><br/>
    <form:errors path="hours"/>
    <br/>

    <label>Data wycieczki:<br/>
        <form:input type="date" id="txtDate" required="Required" path="date" placeholder="Data wycieczki"/>
    </label><br/>
    <form:errors path="date"/>
    <br/>

    <label>Miejsce rozpoczecia/zakończenia trasy:*<br/>
        <form:input path="start" placeholder="Ulica,Skwer,Plac itd."/>
    </label><br/>
    <form:errors path="start"/>
    <br/>

    <label>Dodatkowy opis:<br/>
        <form:textarea rows="5" cols="40" path="description"
                       placeholder="Miejsce docelowe,przystanki,godzina spotkania/wyjazdu oraz wszystkie znaczące informacje"/>
    </label><br/>
    <form:errors path="description"/>
    <br/>

    <label>Odległość od zaznaczonego miasta:<br/>
        <form:select path="howFar">
            <form:option value=" " label="Wybierz"/>
            <form:options items="${kilometersAway}"/>
        </form:select>
    </label><br/>
    <form:errors path="howFar"/>
    <br/><br/>

    <label>Link do mapy trasy(GoogleMaps):<br/>
        <form:input path="link" placeholder="Link do trasy w Google Maps"/>
    </label><br/>
    <form:errors path="link"/>
    <br/><br/>
    <span>
   Pamiętaj, aby o każdej zmianie poinformować uczestników.<br/>
</span><br/><br/>
    <form:button type="submit">Edytuj trasę</form:button>
</form:form>
<script src="/scripts/dataScript.js" defer></script>
<%@ include file="/WEB-INF/app/parties/footer.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/app/pageParts/header.jsp" %>
<h1>Edytuj wycieczkę</h1><br/>
<form:form method="post" action="/app/tours/edit" modelAttribute="tourEdit">

    <form:hidden path="tourId"/>

    <label>Miejsce zbiórki:<br/>
        <form:input path="gatheringPlace" placeholder="Podaj miejsce zbiórki"/>
    </label><br/>
    <form:errors path="gatheringPlace"/>
    <br/>

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

    <label>Dodatkowy opis:<br/>
        <form:textarea rows="5" cols="40" path="description"
                       placeholder="Miejsce docelowe,przystanki,godzina spotkania/wyjazdu oraz wszystkie znaczące informacje"/>
    </label><br/>
    <form:errors path="description"/>
    <br/>

    <label>Powrót do mniejsca startu:<br/>
        <label for="yes">tak</label>
        <form:checkbox  id="yes" class="checkboxy" path="returning" value="tak"/>
        <label for="no">nie</label>
        <form:checkbox  id="no" class="checkboxy" path="returning" value="nie"/>
        <span></span>
    </label><br/>
    <form:errors path="returning"/>
    <br/>

    <label>Link do mapy trasy(GoogleMaps):<br/>
        <form:input path="link" placeholder="Link do trasy w Google Maps"/>
    </label><br/>
    <form:errors path="link"/>
    <br/><br/>
    <span>
   Pamiętaj, aby o każdej zmianie poinformować uczestników.<br/>
</span><br/><br/>
    <form:button class="myButton" type="submit">Edytuj trasę</form:button>
</form:form>
<script src="/scripts/editTourFormScript.js" defer></script>
<%@ include file="/WEB-INF/app/pageParts/footer.jsp" %>
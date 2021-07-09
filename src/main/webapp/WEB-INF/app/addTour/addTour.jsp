<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/app/parties/header.jsp" %>
<h1>Dodawanie wycieczki</h1><br/>
<form:form method="post" modelAttribute="tourAdd">

    <label>Data wycieczki:<br/>
        <form:input type="date" id="txtDate" required="Required" path="date" placeholder="Data wycieczki"/>
    </label><br/>
    <form:errors path="date"/>
    <br/>

    <label>Start wycieczki:<br/>
        <form:input path="startPost" placeholder="Podaj kod pocztowy"/>
        <form:input path="startPlace" placeholder="Podaj miejscowość"/>
    </label><br/>
    <form:errors path="startPost"/>
    <form:errors path="startPlace"/>
    <br/>

    <label>Meta wycieczki:<br/>
        <form:input path="endPost" placeholder="Podaj kod pocztowy"/>
        <form:input path="endPlace" placeholder="Podaj miejscowość"/>
    </label><br/>
    <form:errors path="endPost"/>
    <form:errors path="endPlace"/>
    <br/>

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
        <form:select path="hours" >
            <form:option value=" " label="Wybierz"/>
            <form:options items="${hours}"/>
        </form:select>
    </label><br/>
    <form:errors path="hours"/>
    <br/>

    <label>Opis trasy:<br/>
        <form:textarea rows="5" cols="40" path="description" placeholder="Przystanki,godzina spotkania/wyjazdu oraz wszystkie znaczące informacje"/>
    </label><br/>
    <form:errors path="description"/>
    <br/>

    <label>Powrót do miejsca startu:<br/>
        tak
        <form:checkbox path="returning" value="tak"/>
        nie
        <form:checkbox path="returning" value="nie"/>
         <span></span>
    </label><br/>
    <form:errors path="returning"/>
    <br/>

    <label>Maksymalna ilość dodatkowych uczestników:<br/>
        <form:input type="number" path="participants" placeholder="Liczba uczestników"/>
    </label><br/>
    <form:errors path="participants"/>
    <br/>

    <label>Opcjonalnie</br>
        Link do mapy trasy (GoogleMaps):<br/>
        <form:input path="link" placeholder="Link do trasy w Google Maps"/>
    </label><br/>
    <form:errors path="link"/>
    <br/>
    <br/>
    <form:button class="myButton" type="submit">Dodaj trasę</form:button>
</form:form>
<script src="/scripts/dataScript.js" defer></script>
<%@ include file="/WEB-INF/app/parties/footer.jsp" %>
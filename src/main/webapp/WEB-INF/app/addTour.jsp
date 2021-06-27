<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/app/parties/header.jsp" %>
<h1>Dodawanie wycieczki</h1><br/>
<form:form method="post" modelAttribute="tourAdd">
    <label>Maksymalna ilość dodatkowych uczestników:<br/>
        <form:input type="number" path="participants" placeholder="Liczba uczestników"/>
    </label><br/>
    <form:errors path="participants"/>
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
        <form:textarea rows="5" cols="40" path="description" placeholder="Miejsce docelowe,przystanki,godzina spotkania/wyjazdu oraz wszystkie znaczące informacje"/>
    </label><br/>
    <form:errors path="description"/>
    <br/>

    <label>Miasto:**<br/>
        <form:select path="cityId" >
            <form:option value="0" label="Wybierz"/>
            <form:options items="${allCities}" itemLabel="name" itemValue="id"/>
        </form:select>
    </label><br/>
    <form:errors path="cityId"/>
    <br/>

    <label>Odległość od zaznaczonego miasta:<br/>
        <form:select path="howFar" >
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
    * Jeśli miejsce zakończenia jest inne, zaznacz to dopisując je do Dodatkowego opisu.<br/>
    ** Miasta zostały dopasowane do Twojego aktualnego województwa. Aby je zmienić odwiedź stronę: Twój profil.
</span><br/><br/>
    <form:button class="myButton" type="submit">Dodaj trasę</form:button>
</form:form>
<script src="/scripts/dataScript.js" defer></script>
<%@ include file="/WEB-INF/app/parties/footer.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/app/parties/header.jsp" %>
<h1>Dodawanie wycieczki</h1><br/>
<form:form method="post" modelAttribute="tourAdd">
    <label>Maksymalna ilość uczestników:<br/>
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
        <form:input type="textarea" path="description" placeholder="Miejsce docelowe,przystanki,godzina spotkania/wyjazdu oraz wszystkie znaczące informacje"/>
    </label><br/>
    <form:errors path="description"/>
    <br/>

    <label>Miasto:<br/>
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
    <br/>

    <form:button type="submit">Dodaj trasę</form:button>
</form:form>
<%@ include file="/WEB-INF/app/parties/footer.jsp" %>
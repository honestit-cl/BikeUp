<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/app/parties/header.jsp" %>
<h1>Edycja profilu</h1><br/>

<form:form method="post" modelAttribute="userEdit">

    <label>Imię:<br/>
        <form:input  path="firstName" placeholder="Podaj swoje imię"/>
    </label><br/>
    <br/>
    <label>Nazwisko:<br/>
        <form:input path="lastName" placeholder="Podaj swoje nazwisko"/>
    </label><br/>
    <br/>
    <label>Pozwalam innym użytkownikom widzieć moje dane osobowe:<br/>
        <form:select path="visibility" >
        <form:option value="" label="Wybierz"/>
            <form:option value="hidden" label="Nie"/>
            <form:option value="show" label="Tak"/>
        </form:select>
    </label><br/>
    <br/>
    <br/>
    <form:button class="myButton" type="submit">Edutuj</form:button> <input type="button"  class="myButton" value="Wróć" onclick="location.href='/app/profile'">
</form:form>
<%@ include file="/WEB-INF/app/parties/footer.jsp" %>
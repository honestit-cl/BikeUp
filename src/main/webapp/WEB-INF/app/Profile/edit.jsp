<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/app/parties/header.jsp" %>
<h1>Edycja profilu</h1><br/>

<form:form method="post" modelAttribute="userEdit">

    <label>Imię:<br/>
        <form:input  path="firstName" placeholder="Podaj swoje imię."/>
    </label><br/>
    <br/>
    <label>Nazwisko:<br/>
        <form:input path="lastName" placeholder="Podaj swoje nazwisko."/>
    </label><br/>
    <br/>
    <label>Województwo<br><br/>
        <form:select path="province" >
            <form:option value="0" label="Wybierz"/>
            <form:options items="${allProvinces}" itemLabel="name" itemValue="id"/>
        </form:select>
    </label><br/>
    <form:errors path="province"/>
    <br/>
    <br/>
    <form:button type="submit">Edutuj</form:button><input type="button" value="Wróć" onclick="location.href='/app/profile'">
</form:form>
<%@ include file="/WEB-INF/app/parties/footer.jsp" %>
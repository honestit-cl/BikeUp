<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/app/parties/header.jsp" %>
<h1>Potwierdzenie wypisania się z wycieczki</h1><br/>
<form method="post" action="/app/participation/singOut">
    <p>Czy na pewno chesz wypisać się z wycieczki, która odbędzie się ${tour.date}?(id = ${tour.id})?</p>
    <p></p>
    <p>
        <input type="hidden" name="id" value="${tour.id}"/>
        <br/>
        <button class="myButton" type="submit">Tak</button> <input type="button"  class="myButton" value="Nie" onclick="location.href='/app/participation'">
    </p>
</form>
<%@ include file="/WEB-INF/app/parties/footer.jsp" %>
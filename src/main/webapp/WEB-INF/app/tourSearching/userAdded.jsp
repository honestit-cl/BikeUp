<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/app/pageParts/header.jsp" %>
<h1>Potwierdzenie dołaczenia do wycieczki</h1><br/>
<p>Zostałeś pomyślnie dodany do wycieczki.<br/>
    Będzie ona widoczna w zakładce - "Uczestnictwo w trasach".</p>
<br/>
<br/>
<input type="button" class="myButton" value="Powrót" onclick="location.href='/app/search'">
<%@ include file="/WEB-INF/app/pageParts/footer.jsp" %>
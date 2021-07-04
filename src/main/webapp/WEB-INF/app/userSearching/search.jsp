<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/app/parties/header.jsp" %>
<h1>Wyszukaj Użytkownika</h1>
<br/>
<input id="nameInput" type="text" placeholder="Wpisz nazwę użytkownika">
<br/>
<br/>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Nazwa użytkownika</th>
        <th>Dostępne akcje</th>
    </tr>
</table>
<script src="/scripts/userSearching.js" defer></script>
<%@ include file="/WEB-INF/app/parties/footer.jsp" %>
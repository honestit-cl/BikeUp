<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/app/pageParts/header.jsp" %>
<h1>Wyszukaj trasę</h1>
<br/>
<input id="tourInput" type="text" placeholder="Wpisz szukany atrybut trasy">
<br/>
<br/>
<table border="1" id="table">
<tbody>
</tbody>
</table>
<script src="/scripts/tourSearching.js" type="text/javascript" defer></script>
<%@ include file="/WEB-INF/app/pageParts/footer.jsp" %>
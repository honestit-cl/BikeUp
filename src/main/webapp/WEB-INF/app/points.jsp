<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/app/parties/header.jsp" %>
<h1>Twoje punkty</h1><br/>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Data</th>
        <th>Miasto</th>
        <th>Dystans</th>
        <th>Czas</th>
        <th>Status</th>
        <th>Potwierdzeni uczestnicy</th>
        <th>Dostępne akcje</th>
    </tr>
</table>
<%@ include file="/WEB-INF/app/parties/footer.jsp" %>
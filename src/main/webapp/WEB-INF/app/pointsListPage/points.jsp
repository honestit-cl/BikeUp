<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/app/pageParts/header.jsp" %>
<h1>Twoje punkty</h1><br/>
<div class="successButton">
    <input class="myButton startButton" type="button" value="Poprzednie lata" onclick="location.href=''">
</div>
<p>Punkty zdobyte w tym roku:</p>
<table border="1">
    <tr>
        <th>Id trasy</th>
        <th>Ilość</th>
        <th>Opis</th>
    </tr>
    <c:forEach items="${points}" var="point">
        <tr>
            <th>${point.tour.id}</th>
            <th>${point.amount}</th>
            <th>${point.description}</th>
        </tr>
    </c:forEach>
</table>
<%@ include file="/WEB-INF/app/pageParts/footer.jsp" %>
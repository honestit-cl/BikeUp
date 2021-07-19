<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/app/pageParts/header.jsp" %>
<h1>Przydziel punkty</h1>
<p>Punkty zostały pomyślnie przydzielone.</p><br/>
 <input type="button" class="myButton" value="Powrót" onclick="location.href='/app/tours/addPointsList/${tourId}'">
<%@ include file="/WEB-INF/app/pageParts/footer.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/app/parties/header.jsp" %>
<h1>Nie możesz ponownie dodać punktów temu użytkownikowi za tą trasę.</h1><br/>
 <input type="button" class="myButton" value="Powrót" onclick="location.href='/app/tours'">
<%@ include file="/WEB-INF/app/parties/footer.jsp" %>
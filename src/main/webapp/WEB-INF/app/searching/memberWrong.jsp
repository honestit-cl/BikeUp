<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/app/parties/header.jsp" %>
<h1>Potwierdzenie dołaczenia do wycieczki</h1><br/>
<p>Wysłałeś już prośbę o dodanie do tej wycieczki lub bieżesz już w niej udział.</p><br/>
<br/>
 <input type="button" class="myButton" value="Powrót" onclick="location.href='/app/search'">
<%@ include file="/WEB-INF/app/parties/footer.jsp" %>
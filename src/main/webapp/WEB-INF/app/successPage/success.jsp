<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/app/parties/header.jsp" %>
<h1>Sukcesy użytkowników</h1><br/>
<div class="successButton">
<input class="myButton startButton" type="button" value="Dodaj swój sukces" onclick="location.href=''">
</div>
<div>
    <p>Marek wjechał na Górę Żar:</p>
<img src="<c:url value='/images/203303792_345704563565009_2786490588948121582_n.jpg'/>" width="350" height="400"/>
</div>
<%@ include file="/WEB-INF/app/parties/footer.jsp" %>
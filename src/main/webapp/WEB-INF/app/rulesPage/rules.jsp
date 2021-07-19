<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/app/pageParts/header.jsp" %>
<h1>Zasady aplikacji</h1><br/>
<ul class="rules">
<li>Maksymalna liczba możliwych do przydzielenia punktów za trasę jest równa ilości pokonanych kilometrów.</li>
<br/>
<li>Możliwe poziomy:<br/> <br/>
    - poziom 0 - startowy,<br/> <br/>
    - poziom 1 - odblokowany po zdobyciu 50pkt, <br/> <br/>
    - poziom 2 - odblokowany po zdobyciu 500pkt,<br/> <br/>
    Kolejne poziomy są tajemnicą do czasu ich samodzielnego odblokowania :)
</li><br/>
    <li>Widoczność Twoich danych osobowych jest automatycznie zablokowana.<br/>
    Jeśli chcesz, aby Twoje dane były widoczne możesz to zmienić w Edycji profilu.</li>
    </ul>
<%@ include file="/WEB-INF/app/pageParts/footer.jsp" %>
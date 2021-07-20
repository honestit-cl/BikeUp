<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/app/pageParts/header.jsp" %>
<h1>Co u nas nowego?</h1><br/>
    <h4>Następna aktualizacja przyniesie ze sobą:</h4>
<ul class="rules">
    <li>Dodanie pogody zależnej od miejsca pobytu,</li><br/>
    <li>Lepsze wyszukiwanie tras,</li><br/>
    <li>Możliwość wysłania wiadomości do użytkownika,</li><br/>
    <li>Kominikaty o zmianie stanu trasy(nowe prośby o dołączenie do wycieczki, edycja wycieczki itd.)</li><br/>
    <li>Więcej ciekawostek,</li><br/>
    <li>Możliwość dodania swojego sukcesu,</li><br/>
    <li>Przegląd punktów z poprzednich lat,</li><br/>
    <li>Techniczne : <br/>
        - przyciski powrót(do poprzedniej strony, nie link)<br/>
        - zerowanie punktów wraz z nowym rokiem kalendarzowym<br/>
        - przy zmianie imienia i nazwiska nie przechodzi logowania(?)
    </li>
</ul>
<%@ include file="/WEB-INF/app/pageParts/footer.jsp" %>
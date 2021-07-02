<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</div>

<div class="clock" style="overflow: auto">
    <div class="clock-data">Mamy teraz:</div>
    <br/>
    <div>
        <script type="text/JavaScript" src="http://www.free4u.pl/data_godzina.php?co=godzina"></script>
    </div>
    <br/>
    <br/>
    <div>
        <script type="text/JavaScript" src="http://www.free4u.pl/data_godzina.php?co=data"></script>
    </div>
</div>
<div class="status" style="overflow: auto">
    <div class="clock-data">Ilość punktów: ${userPoints}<br/><br/>
        <c:forEach var="lev" items="${level}">
        Poziom: ${lev.key}<br/><br/>
            ${lev.value}</div
    </c:forEach>
    <br/>
</div>
<div class="weather" style="overflow: auto">
    <div class="clock-data">Pogoda<br/><br/>
        26 stopni<br/>
        Słonecznie<br/>
        Czyżby to idelane warunki na rower? :)
    </div>
    <br/>
</div>
<div class="anecdote" style="overflow: auto">
    <div class="clock-data">Czy wiesz że... ?<br/><br/>
        ${didUKnow}</div>
    <br/>
</div>
</body>
</html>
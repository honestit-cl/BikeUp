document.addEventListener('DOMContentLoaded', function () {

    function apiTourList() {

        return fetch(
            'http://localhost:8080/app/search/data',
            {
                headers: {
                    // 'Content-Type': 'application/json'
                }
            })
            .then(
                function (resp) {
                    if (!resp.ok) {
                        alert('Wystąpił błąd! Otwórz devtools i zakładkę Sieć/Network, i poszukaj przyczyny');
                    }
                    return resp.json();
                }
            );
    }

    function renderTour(tourId,startPlace,startPostalCode,endPlace,endPostalCode, date, distance, hours, active, realP, participants) {

        const section = document.createElement("tr");
        section.innerHTML = `        
            <td>${tourId}</td>
            <td>${date}</td>          
            <td>${distance} km</td>
            <td>${hours}</td>
            <td>${startPostalCode}<br/>
            ${startPlace}</td>
              <td>${endPostalCode}<br/>
            ${endPlace}</td>
            <td>${active}</td>
            <td>${realP-1}/${participants}</td>
            <td>
                <span>
                <input type="button" value="Szczegóły" onclick="location.href='/app/search/details/${tourId}'">                 
                </span><br/>
            </td> 
 `;

        if (active === 'otwarta') {
            document.querySelector("table").firstElementChild.after(section)
        }

        const link = document.createElement('span');
        if (active === 'otwarta' && realP-1<participants) {
            link.innerHTML = `
           <span>
           <input type="button" value="Dołącz" onclick="location.href='/app/search/confirmPart/${tourId}'">           
           </span><br/>
           `;
            section.lastElementChild.append(link);
        }
    }

    apiTourList().then(
        function (response) {
            response.forEach(
                (tour) => {
                    renderTour(tour.id, tour.startPlace,tour.startPostalCode,tour.endPlace,tour.endPostalCode,tour.date, tour.distance,tour.hours,tour.active,tour.realParticipants,tour.participants);
                }
            );
        }
    );
})
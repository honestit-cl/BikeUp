document.addEventListener('DOMContentLoaded', function () {

    function apiTourList() {

        return fetch(
            'http://localhost:8080/app/tours/data',
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
                <input type="button" value="Szczegóły" onClick="location.href='/app/tours/details/${tourId}'">
                </span><br/>
            </td> 
 `;

        if (active === 'otwarta') {
            document.querySelector("table").firstElementChild.after(section)
        } else {
            document.querySelector("table").append(section);
        }

        const link = document.createElement('span');
        if (active === 'otwarta') {
            link.innerHTML = `
           <span>
           <input type="button" value="Usuń" onClick="location.href='/app/tours/delete/${tourId}'"> 
           </span><br/>
           <span>
           <input type="button" value="Edytuj" onClick="location.href='/app/tours/edit/${tourId}'">              
           </span><br/>
           <span>
           <input type="button" value="Potwierdź wykonanie" onClick="location.href='/app/tours/confirmTour/${tourId}'">
           </span><br/>           
           <span>
           <input type="button" value="Potwierdź uczestników" onClick="location.href='/app/tours/confirmPart/${tourId}'">             
           </span><br/>
           `;
            section.lastElementChild.append(link);
        }

        const link2 = document.createElement('span');
        if (active === 'zamknięta') {
            link2.innerHTML = ` 
           <span>
           <input type="button" value="Przydziel punkty" onClick="location.href='/app/tours/addPointsList/${tourId}'"           
           </span><br/>
           `;
            section.lastElementChild.append(link2);
        }
    }

    apiTourList().then(
        function (response) {
            response.forEach(
                (tour) => {
                    renderTour(tour.id, tour.startPlace,tour.startPostalCode,tour.endPlace,tour.endPostalCode, tour.date, tour.distance,tour.hours,tour.active,tour.realParticipants,tour.participants);
                }
            );
        }
    );
})
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

    function renderTour(tourId, date, cityName, distance, hours, active, realP, participants) {

        // Tworzenie sekcji

        const section = document.createElement("tr");
        section.innerHTML = `        
            <td>${tourId}</td>
            <td>${date}</td>
            <td>${cityName}</td>
            <td>${distance} km</td>
            <td>${hours}</td>
            <td>${active}</td>
            <td>${realP-1}/${participants}</td>
            <td>
                <span><a href="/app/tours/details/${tourId}">Szczegóły</a></span><br/>
            </td> 
 `;

        // Dodawanie do drzewa w zależności od statusu

        if (active === 'open') {
            document.querySelector("table").firstElementChild.after(section)
        } else {
            document.querySelector("table").append(section);
        }

        // Dodawanie linkow gdy open

        const link = document.createElement('span');
        if (active === 'open') {
            link.innerHTML = `
           <span><a href="/app/tours/delete/${tourId}">Usuń</a></span><br/>
           <span><a href="/app/tours/edit/${tourId}">Edytuj</a></span><br/>
           <span><a href="/app/tours/confirmTour/${tourId}">Potwierdź wykonanie</a></span><br/>
           <span><a href="/app/tours/confirmPart/${tourId}">Potwierdź uczestników</a></span><br/>
           `;
            section.lastElementChild.append(link);
        }

        //Dodawanie linkow gdy closed

        const link2 = document.createElement('span');
        if (active === 'closed') {
            link2.innerHTML = ` 
           <span><a href="/app/tours/addPointsList/${tourId}">Przydziel punkty</a></span><br/>
           `;
            section.lastElementChild.append(link2);
        }
    }

    apiTourList().then(
        function (response) {
            response.forEach(
                (tour) => {
                    renderTour(tour.id, tour.date, tour.city.name,tour.distance,tour.hours,tour.active,tour.realParticipants,tour.participants);
                }
            );
        }
    );
})
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
                <span><a href="/app/search/details/${tourId}">Szczegóły</a></span><br/>
            </td> 
 `;

        // Dodawanie do drzewa w zależności od statusu

        if (active === 'open') {
            document.querySelector("table").firstElementChild.after(section)
        }

        // Dodawanie linkow gdy open

        const link = document.createElement('span');

        if (active === 'open' && realP<participants) {
            link.innerHTML = `
           <span><a href="/app/search/confirmPart/${tourId}">Dołącz</a></span><br/>
           `;
            section.lastElementChild.append(link);
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
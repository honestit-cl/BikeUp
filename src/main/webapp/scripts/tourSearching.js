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

function renderTour(tourId, startPlace, startPostalCode, endPlace, endPostalCode, date, distance, hours, active, realP, participants) {

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
            <td>${realP - 1}/${participants}</td>
            <td>
                <span>
                <input type="button" value="Szczegóły" onclick="location.href='/app/search/details/${tourId}'">                 
                </span><br/>
            </td> 
 `;

    if (active === 'otwarta') {
        document.querySelector("table tbody").append(section)
    }

    const link = document.createElement('span');
    if (active === 'otwarta' && realP - 1 < participants) {
        link.innerHTML = `
           <span>
           <input type="button" value="Dołącz" onclick="location.href='/app/search/confirmPart/${tourId}'">           
           </span><br/>
           `;
        section.lastElementChild.append(link);
    }
}

const head = document.createElement("tr");
head.innerHTML = `
    <tr>
        <th>Id</th>
        <th>Data</th>
        <th>Dystans</th>
        <th>Czas</th>
        <th>Start wycieczki</th>
        <th>Meta wycieczki</th>
        <th>Status</th>
        <th>Potwierdzeni uczestnicy</th>
        <th>Dostępne akcje</th>
    </tr>
`
document.querySelector("table").firstElementChild.before(head);

$(function () {
    apiTourList().then(
        function (response) {
            response.forEach(
                (tour) => {
                    renderTour(tour.id, tour.startPlace, tour.startPostalCode, tour.endPlace, tour.endPostalCode, tour.date, tour.distance, tour.hours, tour.active, tour.realParticipants, tour.participants);
                }
            );
        }
    ).then(function () {

            const $rows = $('#table tbody tr');
            $('#tourInput').keyup(function () {

                let val = '^(?=.*\\b' + $.trim($(this).val()).split(/\s+/).join('\\b)(?=.*\\b') + ').*$',
                    reg = RegExp(val, 'i'),
                    text;

                $rows.show().filter(function () {
                    text = $(this).text().replace(/\s+/g, ' ');
                    return !reg.test(text);
                }).hide();
            })
        }
    );
});
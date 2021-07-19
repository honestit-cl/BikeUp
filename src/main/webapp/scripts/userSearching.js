function apiUserList() {

    return fetch(
        'http://localhost:8080/app/searchUser/data',
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

function renderUser(userId, username) {

    const section = document.createElement("tr");
    section.innerHTML = `        
            <td >${userId}</td>
            <td>${username}</td>
            <td>
                <span>
                <input type="button" value="Zobacz profil" onclick="location.href='/app/searchUser/profile/${userId}'">               
                </span><br/>
            </td> 
 `;
    document.querySelector("table tbody").append(section)
}

const head = document.createElement("tr");
head.innerHTML = `
    <tr>
        <th>Id</th>
        <th>Nazwa użytkownika</th>
        <th>Dostępne akcje</th>
    </tr>
`
document.querySelector("table").firstElementChild.before(head);

$(function () {
    apiUserList().then(
        function (response) {
            response.forEach(
                (user) => {
                    renderUser(user.id, user.username);
                }
            );
        }
    ).then(function () {

            const $rows = $('#table tbody tr');
            $('#nameInput').keyup(function () {

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
})
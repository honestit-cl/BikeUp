document.addEventListener('DOMContentLoaded', function () {

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

        // Tworzenie sekcji

        const section = document.createElement("tr");
        section.innerHTML = `        
            <td >${userId}</td>
            <td>${username}</td>
            <td>
                <span data-name="${username}" class="">
                <input type="button" value="Zobacz profil" onclick="location.href='/app/searchUser/profile/${userId}'">               
                </span><br/>
            </td> 
 `;
        document.querySelector("table").firstElementChild.after(section)
    }

    apiUserList().then(
        function (response) {
            response.forEach(
                (user) => {
                    renderUser(user.id, user.username);
                }
            );
        }
    );

    const trs = document.querySelectorAll("tr");
    const input = document.querySelector("#nameInput");

    input.addEventListener("input", evt => {
        const val = input.value;

        trs.forEach(tr => {
            const name = tr.lastElementChild.lastElementChild.dataset.name;
            let notExist = true;

            if (name.includes(val)) {
                notExist = false;
            } if (notExist) {
                tr.display = 'none'
            }
        })
    })
})


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
        section.classList.add("section");
        section.innerHTML = `        
            <td>${userId}</td>
            <td data-name="${username}">${username}</td>
            <td>
                <span class=""><a href="/app/searchUser/profile/${userId}">Zobacz profil</a></span><br/>
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


    const sections = document.querySelectorAll(".section");
    const input = document.querySelector("#nameInput");

    input.addEventListener("keypress", evt => {
        const val = input.value;

        sections.forEach(section => {
            const name = section.dataset.name;
            let notExist = true;

            if (name.includes(val)) {
                notExist = false;
            }

            if (notExist) {
                section.display = 'none'
            }
        })
    })
})
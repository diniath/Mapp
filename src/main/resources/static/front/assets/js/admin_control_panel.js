// http://localhost:8080/company/dto
// http://localhost:8080/enrolledUser/dto

function showAlert() {
    alert("This is just the alpha version dawg...");
}

// function toJSON(response) {
//     return response.json();
// }

function handleErrors(error) {
    console.log('Please try again problem occered!')
}

fetch("companies.json").then(
    result => {
        result.json().then(
            data => {
                // console.log(data);
                if (data.length > 0) {
                    let temp = "";
                    data.forEach((u) => {
                        temp += "<tr>";
                        temp += "<td>" + u.id + "</td>";
                        temp += "<td>" + u.cname + "</td>";
                        temp += "<td>" + u.profile + "</td>";
                        temp += "<td>" + u.email + "</td>";
                        // temp += "<td>" + u.address + "</td>";
                        // temp += "<td>" + u.postalcode + "</td>";
                        temp += "<td>" + u.municipality + "</td>";
                        // temp += "<td>" + u.city + "</td>";
                        temp += "<td>" + u.telephone + "</td>";
                        temp += "<td>" + u.mobile + "</td>";
                        temp += "<td>" + u.vatnumber + "</td>";
                        // temp += "<td>" + u.iban + "</td>";
                        temp += "<td>" + u.representative + "</td>";
                        // temp += "<td> Company </td>";
                        // temp += `<td>
                        //     <a href="#" class="settings" id="edit" title="Edit" data-toggle="tooltip"><i
                        //             class="material-icons">&#xE8B8;</i></a>
                        //     <a href="#" class="delete" id="delete" title="Delete" data-toggle="tooltip"><i
                        //             class="material-icons">&#xE5C9;</i></a>
                        // </td><tr>`;
                    })
                    document.getElementById("data").innerHTML = temp;
                }
            }
        ).catch(handleErrors);
    }
)



fetch("enrolledUsers.json").then(
    result => {
        result.json().then(
            users => {
                // console.log(users);
                if (users.length > 0) {
                    let temp = "";
                    users.forEach((e) => {
                        temp += "<tr>";
                        temp += "<td>" + e.id + "</td>";
                        temp += "<td>" + e.fname + "</td>";
                        temp += "<td>" + e.lname + "</td>";
                        temp += "<td>" + e.email + "</td>";
                        temp += "<td>" + e.dateofbirth + "</td>";
                        // temp += "<td>" + e.address + "</td>";
                        // temp += "<td>" + e.postalcode + "</td>";
                        temp += "<td>" + e.municipality + "</td>";
                        temp += "<td>" + e.city + "</td>";
                        temp += "<td>" + e.telephone + "</td>";
                        temp += "<td>" + e.mobile + "</td>";
                        // temp += "<td> User </td>";
                        // temp += `<td>
                        //     <a href="#" class="settings" id="edit" title="Edit" data-toggle="tooltip"><i
                        //             class="material-icons">&#xE8B8;</i></a>
                        //     <a href="#" class="delete" id="delete" title="Delete" data-toggle="tooltip"><i
                        //             class="material-icons">&#xE5C9;</i></a>
                        // </td><tr>`;
                    })
                    document.getElementById("users").innerHTML = temp;
                }
            }
        ).catch(handleErrors);
    }
)

function createCompany() {
    const companyData = {

        "username": "kikiriki",
        "password": "psalidi4321",
        "cname": "Mind the Cut",
        "email": "mindthecut2@gmail.com",
        "postalcode": 12135,
        "address": "Σελήνης 12",
        "city": "Αθήνα",
        "municipality": "Περιστέρι",
        "telephone": "2106567893",
        "mobile": "6934256788",
        "vatnumber": "445124764",
        "vatservice": "ΔΟΥ Περιστερίου",
        "description": "Mind the Cut: the new barber's experience in Pigeon Town",
        "representative": "Αργύρης Δεμπεγιώτης Newton",
        "rating": 5,
        "iban": "GR16014010101002101047415",
        "imageUrl": { "id": 1 },
        "profile": "Barberi Shop"
    }

    fetch('', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(companyData),
    })
        .then((response) => response.json())
        .then((companyData) => {
            console.log('Success:', companyData);
        })
        .catch((error) => {
            console.log('Error:', error);
        });
}




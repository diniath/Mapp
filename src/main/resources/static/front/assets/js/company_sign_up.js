
function companySignUp() {

    const companyEmail = document.getElementById('companyEmail').value;
    const companyUsername = document.getElementById('companyUsername').value;
    const companyPassword = document.getElementById('companyPassword').value;
    const companyName = document.getElementById('companyName').value;
    const companyProfile = document.getElementById('companyProfile').value;
    const vatNumber = document.getElementById('vatNumber').value;
    const vatService = document.getElementById('vatService').value;
    const companyIban = document.getElementById('companyIban').value;
    const companyDescription = document.getElementById('companyDescription').value;
    const companyAddress = document.getElementById('companyAddress').value;
    const companyAddressCity = document.getElementById('companyAddressCity').value;
    const companyMunicipality = document.getElementById('companyMunicipality').value;
    const companyZip = document.getElementById('companyZip').value;
    const representativeName = document.getElementById('representativeName').value;
    const companyTelephone = document.getElementById('companyTelephone').value;
    const companyMobile = document.getElementById('companyMobile').value;

    let postCompanyData = {
        username: companyUsername,
        password: companyPassword,
        cname: companyName,
        email: companyEmail,
        postalcode: companyZip,
        address: companyAddress,
        city: companyAddressCity,
        municipality: companyMunicipality,
        telephone: companyTelephone,
        mobile: companyMobile,
        vatnumber: vatNumber,
        vatservice: vatService,
        description: companyDescription,
        representative: representativeName,
        rating: 5,
        iban: companyIban,
        imageUrl: { "id": 65 },
        profile: companyProfile,
        roleList: [{ "id": 2 }]
    }
    return JSON.stringify(postCompanyData);
}


const save = document.getElementById('js-form-update');

save.addEventListener('submit', (e) => {
    e.preventDefault();
    let companyToSign = companySignUp();
    authorizedFetch("POST", "http://localhost:8080/company", companyToSign);
});


// Post, Put  
function authorizedFetch(method, url, body) {
    let headers = {
        "Content-Type": "application/json",
        "Access-Control-Origin": "*"
    };
    fetch(url, {
        method: method,
        headers: headers,
        body: body
    })
        .then(toJSON)
        .then(function (response) {
            if (response.status == "200") {
                window.location.href = "index.html?"; 
                return response.json();
            }
        })
        .catch(handleErrors);
}

function toJSON(response) {
    return response.json();
}

function handleErrors(error) {
    alert = "ops something went wrong"
}


// function redirectAfterSignUp(response) {
//     if (response.status == "200") {
//         window.location.href = "index.html";
//     }
// }

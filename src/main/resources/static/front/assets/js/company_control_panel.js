function toJSON(response) {
    return response.json();
}

function handleErrors(error) {

}

function getCompanyById(data) {
    // const comp_uname = document.getElementById('company_user_name');
    // const comp_password = document.getElementById('company_password');
    const cname = document.getElementById('company_name');
    const vatnumber = document.getElementById('vat_number');
    const vatservice = document.getElementById('vat_service');
    const iban = document.getElementById('iban');
    const comp_descr = document.getElementById('company_description');
    const rep_name = document.getElementById('representative_name');
    const comp_email = document.getElementById('company_email');
    const comp_phone = document.getElementById('company_phone');
    const comp_mobile = document.getElementById('company_mobile');
    const comp_address = document.getElementById('company_address');
    const comp_city = document.getElementById('company_city');
    const comp_municipality = document.getElementById('company_municipality');
    const comp_zip = document.getElementById('company_zip');
    const headline_cname = document.getElementById('headline_cname');
    const profile = document.getElementById('profile');
    const headline_comp_city = document.getElementById('headline_comp_city');
    const companyLogoImg = document.getElementById('company_logo');
    const MyCompanyId = document.getElementById('MyCompanyId');

    // comp_uname.value = data.username;
    // comp_password.value = data.password;
    cname.value = data.cname;
    vatnumber.value = data.vatnumber;
    vatservice.value = data.vatservice;
    iban.value = data.iban;
    comp_descr.value = data.description;
    comp_email.value = data.email;
    representative_name.value = data.representative;
    comp_phone.value = data.telephone;
    comp_mobile.value = data.mobile;
    comp_address.value = data.address;
    comp_city.value = data.city;
    comp_municipality.value = data.municipality;
    comp_zip.value = data.postalCode;
    headline_cname.innerText = data.cname;
    profile.innerHTML = data.profile;
    headline_comp_city.innerText = data.city;
    companyLogoImg.innerHTML = '<img class="border border-1 border-black fmxh-200 fmxw-200 rounded-circle" src="' + data.imageUrl.url + '" alt=""/>';
    MyCompanyId.innerText = data.id;

}

// G E T 
function authorizedGet(url, methodToRun) {
    // let tokenElement = JSON.parse(localStorage.getItem('Authorization'));
    // let authorizedHeaders = { "Authorization": "Bearer " + tokenElement.jwt };
    fetch(url, {
        method: "GET",
        // headers: authorizedHeaders
    })
        .then(toJSON)
        .then(methodToRun)
        .catch(handleErrors);
}

const companyFromStorage = JSON.parse(localStorage.getItem('company'));
let url = "http://localhost:8080/company/dto/" + companyFromStorage.id;
authorizedGet(url, getCompanyById);



function update() {
    const saveBtn = document.getElementsByClassName('saveBtn');


}

function reset() {
    const resetBtn = document.getElementsByClassName('resetBtn')


}

function deleteService() {
    const deleteBtn = document.getElementById('deleteBtn')

}

// Services table
function handleErrors(error) {
    console.log('Please try again problem occured!')
}

fetch("service.json").then(
    result => {
        result.json().then(
            data => {


                console.log(data);
                if (data.length > 0) {
                    let temp = "";
                    let savedService = document.getElementById('saved-service');
                    let output = "";
                    data.forEach((u) => {
                        temp += "<tr class='align-top'>";
                        temp += "<td class='col-md-2 font-small'>" + u.profile + "</td>";
                        temp += "<td class='col-md-2 font-small'>" + u.description + "</td>";
                        temp += "<td class='col-md-2 font-small'>" + u.price + "</td>";
                        temp += "<td class='col-md-2 font-small'>" + u.duration + "</td>";

                        output += `<option value = ${u.id}> ${u.profile} </option>`;

                        console.log(savedService);
                    })
                    document.getElementById("data").innerHTML = temp;
                    savedService.innerHTML = output;
                }
            }
        ).catch(handleErrors);
    }
)

function postNewService() {

    const service = document.getElementById("service").value;
    const cost = document.getElementById("cost").value;
    const categories = document.getElementById("categories"); // <- edw theme to value!!
    const service_description = document.getElementById("service_description").value;
    const myCompanyId = document.getElementById("MyCompanyId").innerText;

    let postProductData = {
        profile: service,
        price: cost,
        rating: 5,
        duration: 1,
        status: true,
        company: { id: myCompanyId },
        description: service_description,
        subcategory: { id: 1 }, //{ id: categories.selectElement.options[categories.selectedIndex].value }
        imageUrlList: [
            {
                id: 67            },
            {
                id: 68            }
        ]
    }
    return JSON.stringify(postProductData);
}


const save = document.getElementById('js-form-update');

save.addEventListener('submit', (e) => {
    e.preventDefault();
    let newService = postNewService();
    authorizedFetch("POST", "http://localhost:8080/product", newService);
});



// Post, Put  
function authorizedFetch(method, url, body) {
    let headers = {
        "Content-Type": "application/json",
        "Access-Control-Origin": "*",
    };
    fetch(url, {
        method: method,
        headers: headers,
        body: body
    })
        .then(toJSON)
        .catch(handleErrors);
}

const disconnect = document.getElementById('js-disconnect');

disconnect.addEventListener('click', (e) => {
    e.preventDefault();
    localStorage.removeItem('company');
    window.location.href = "index.html";
});
function showAlert() {
    alert("This is just the alpha version dawg...");
}

// Getting variables 
const urlParams = new URLSearchParams(window.location.search);
const companyId = urlParams.get('company_id');
const resultURL = "http://localhost:8080/company/" + document.getElementById('company_id').innerText;

//fetch method 1 tranform to json
function toJSON(response) {
    return response.json();
}

//fetch method 2 for error handling
function handleErrors(error) {
    console.log('Please try again problem occured!');
}

// company function to create template of services cards
function renderProductMiniBox(service) {
    const renderedProductMiniBox = `
                <div class="card col-6">
                        <img style="object-position: 50% 50%; object-fit: fill;" src="${service.imageUrlList[0].url}" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">${service.profile}</h5>
                            <p class="card-text">${service.description}</p>
                            <div class="d-flex justify-content-between">
                                <div class="d-flex align-self-end">
                                    <span class="text-warning">
                                        <i class="${service.rating > 0 ? "fas fa-star text-warning" : "far fa-star text-warning"} h6"></i>
                                        <i class="${service.rating > 1 ? "fas fa-star text-warning" : "far fa-star text-warning"} h6"></i>
                                        <i class="${service.rating > 2 ? "fas fa-star text-warning" : "far fa-star text-warning"} h6"></i>
                                        <i class="${service.rating > 3 ? "fas fa-star text-warning" : "far fa-star text-warning"} h6"></i>
                                        <i class="${service.rating > 4 ? "fas fa-star text-warning" : "far fa-star text-warning"} h6"></i>
                                    </span>
                                    <span class="pl-2 h6">(${service.rating}/5)</span>
                                </div>
                                <div> Κλείσε ραντεβού
                                    <div class="h4">
                                        <a onclick="goToService(${service.id})" class="btn btn-warning w-100"><i
                                                class="fas fa-euro-sign h4"></i>
                                            <span class="h4">${service.price}</span> </a>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
    `;
    return renderedProductMiniBox;
}

// fetch method 3 to populate the company profile services cards based on data
function renderCompanyProfilePage(service) {

    let results = service;
    let output = "";
    for (let i = 0; i < results.length; i++) {
        output += renderProductMiniBox(results[i]);
    }
    document.querySelector('#product-cards').innerHTML = output;
}

fetch("service.json")
    .then(toJSON)
    .then(renderCompanyProfilePage)
    .catch(handleErrors);

// function to create template of reviews
function renderReviewMiniBox(reviews) {
    const renderedReviewMiniBox = `
    <div class=" d-flex justify-content-between p-1" >
                    <div class="h6" id="service_profile">PREPEI NA TO DOUME</div>
                    <div class="">
                        <i class="${service.productRating > 0 ? "fas fa-star" : "far fa-star"} h6"></i>
                        <i class="${reviews.productRating > 1 ? "fas fa-star" : "far fa-star"} h6"></i>
                        <i class="${reviews.productRating > 2 ? "fas fa-star" : "far fa-star"} h6"></i>
                        <i class="${reviews.productRating > 3 ? "fas fa-star" : "far fa-star"} h6"></i>
                        <i class="${reviews.productRating > 4 ? "fas fa-star" : "far fa-star"} h6"></i>
                    </div>
                </div>
                <div class="border-1 border rounded-lg border-black p-3 bg-white">
                    <div class="h6 text-italic font-weight-light" id="review_comment">${reviews.productComment}</div>
                    <hr>
                    <div class=" d-flex justify-content-between">
                        <div class="h6" id="enrolled_user_id">${reviews.username}</div>
                        <div class="h6" id="rating_date">${reviews.ratingDate}</div>
                    </div>
                </div>
    `;
    return renderedReviewMiniBox;
}

// fetch method 3 to populate the reviews section of the page
function renderReviews(reviews) {
    let results = reviews;
    console.log(reviews);
    let output = "";
    for (let i = 0; i < results.length; i++) {
        output += renderReviewMiniBox(results[i]);
    }
    // console.log(renderReviewMiniBox);
    document.querySelector('#review_box').innerHTML = output;
}

fetch("reviews.json")
    .then(toJSON)
    .then(renderReviews)
    .catch(handleErrors);

// populating the company profile section:

// gets the company's details
function getCompanyDetails(company) {
    const companyAddress = document.getElementById('companyAddress');
    const companyTelephone = document.getElementById('companyTelephone');
    const companyRep = document.getElementById('companyRep');
    const companyDescription = document.getElementById('companyDescription');
    const nameOfCompany = document.getElementById('nameOfCompany');
    const companyLogo = document.getElementById('companyLogo');
    const company_id = document.getElementById('company_id');
    const company_rating = document.getElementById('company_rating');
    const starsRating = document.getElementById('star-rating');
    const starsClass = "r" + company.rating;

    starsRating.classList.add(starsClass);
    company_rating.innerText = company.rating;
    company_id.innerText = company.id;
    companyLogo.innerHTML = '<img class="border border-1 border-black fmxh-100 fmxw-100 rounded-circle" src="' + company.imageUrl.url + '" alt="">"';
    nameOfCompany.innerText = company.cname;
    companyAddress.innerText = company.address + ', ' + company.municipality;
    companyTelephone.innerText = company.telephone;
    companyRep.innerText = company.representative;
    companyDescription.innerText = company.description;
}
// method to populate the details of the company
function renderCompanyDetails(company) {
    let results = company;
    let output = "";
    output += getCompanyDetails(results);
}

fetch("company.json")
    .then(toJSON)
    .then(renderCompanyDetails)
    .catch(handleErrors);

    function goToService(id) {
        window.location.replace("http://localhost:8080/front/service_profile.html?serviceId=" + id);
    }

   
    
    // G E T 
    // function authorizedGet(url, methodToRun) {
    //     let tokenElement = JSON.parse(localStorage.getItem('Authorization'));
    //     console.log(tokenElement);
    //     let authorizedHeaders = { "Authorization": "Bearer " + tokenElement.jwt };
    //     fetch(url, {
    //         method: "GET",
    //         headers: authorizedHeaders
    //     })
    //         .then(toJSON)
    //         .then(methodToRun)
    //         .catch(handleErrors);
    // }
    
    // const companyFromStorage = JSON.parse(localStorage.getItem('company'));
    // let url = "http://localhost:8080/company/dto/" + companyFromStorage.id;
    // authorizedGet(url, getUserById);    

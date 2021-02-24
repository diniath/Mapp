//fetch method 1 tranform to json
function toJSON(response) {
    return response.json();
}

//fetch method 2 for error handling
function handleErrors(error) {
    console.log('Please try again problem occured!');
}

// function to get the details of the service
function getServiceDetails(service) {
    const serviceTitle = document.getElementById('serviceTitle');
    const serviceDescription = document.getElementById('serviceDescription');
    const servicePrice = document.getElementById('servicePrice');
    const serviceId = document.getElementById('serviceId');

    serviceId.innerText = service.id;
    serviceTitle.innerText = service.profile;
    serviceDescription.innerText = service.description;
    servicePrice.innerText = service.price;
}

//those are not in the oneService.json. Where to get them?
// companyName

// function to populate the details of the service
function renderServiceDetails(service) {
    let results = service;
    let output = "";
    output += getServiceDetails(results);
    renderCarouselImages(service);
}

// fetch("oneService.json")
//     .then(toJSON)
//     .then(renderServiceDetails)
//     .catch(handleErrors);


// function to create the review template
function renderUserReviewsBox(review) {
    review = `
            <div class=" d-flex justify-content-between p-1">
                        <div class="h6">${review.productProfile}</div>
                        <div class="text-warning">
                            <span class="text-warning">
                                <i class="${review.productRating > 0 ? "fas fa-star" : "far fa-star"} h6"></i>
                                <i class="${review.productRating > 1 ? "fas fa-star" : "far fa-star"} h6"></i>
                                <i class="${review.productRating > 2 ? "fas fa-star" : "far fa-star"} h6"></i>
                                <i class="${review.productRating > 3 ? "fas fa-star" : "far fa-star"} h6"></i>
                                <i class="${review.productRating > 4 ? "fas fa-star" : "far fa-star"} h6"></i>
                            </span>
                        </div>
                    </div>
                    <div class="border-1 border rounded-lg border-black p-3 bg-white">
                        <div class="h6 text-italic font-weight-light">${review.productComment}</div>
                        <hr>
                        <div class=" d-flex justify-content-between">
                            <div class="h6">${review.username}</div>
                            <div class="h6">${review.ratingDate}</div>
                        </div>
                    </div>
            `;
    return review;
}

// render reviews area
function renderUserReviews(reviews) {

    let results = reviews;
    let output = "";
    for (let i = 0; i < results.length; i++) {
        output += renderUserReviewsBox(results[i]);
    }
    document.querySelector('#reviewsFromUsers').innerHTML = output;
}


// load product

function loadProductsFromFetch() {
    const urlParams = new URLSearchParams(window.location.search);
    const productId = urlParams.get('serviceId');
    const searchByUserIpnutUrl = "http://localhost:8080/product/" + productId;
    let urlReview = "http://localhost:8080/review/search/product/" + productId;
    fetchFast(searchByUserIpnutUrl, renderServiceDetails);
    fetchFast(urlReview, renderUserReviews);

    
}


loadProductsFromFetch();

function fetchFast(url, methodToRun) {
    fetch(url)
        .then(toJSON)
        .then(methodToRun)
        .catch(handleErrors);
}


// function createCarouselTemplate (service){
//     const carousel = `
//     <ol class="carousel-indicators">
//                 <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
//                 <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                
//             </ol>
//             <div class="carousel-inner">
//                 <div class="carousel-item active">
//                     <img class="d-block w-100 rounded"
//                         src="${service[0].imageUrlList[1].url}"
//                         alt="First slide">
//                 </div>
//                 <div class="carousel-item">
//                     <img class="d-block w-100 rounded"
//                         src="${service[1].imageUrlList[1].url}"
//                         alt="Second slide">
//                 </div>
                
//             </div>
//             <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
//                 <span class="carousel-control-prev-icon" aria-hidden="true"></span>
//                 <span class="sr-only">Προηγούμενο</span>
//             </a>
//             <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
//                 <span class="carousel-control-next-icon" aria-hidden="true"></span>
//                 <span class="sr-only">Επόμενο</span>
//             </a>
//     `;
//     return carousel;
    
// }

function renderCarouselImages(data){
    let results = document.querySelector('#serviceImage');
    let imageUrl = data.imageUrlList[0].url;
    results.innerHTML = `<img src="${imageUrl}"/>`
}


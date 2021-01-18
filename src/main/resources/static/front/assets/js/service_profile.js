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
}

fetch("oneService.json")
    .then(toJSON)
    .then(renderServiceDetails)
    .catch(handleErrors);


// function to create the review template
function renderUserReviewsBox(review) {
    review = `
            <div class=" d-flex justify-content-between p-1">
                        <div class="h6">${review.profile}</div>
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
    console.log(results);
}

fetch("reviews.json")
    .then(toJSON)
    .then(renderUserReviews)
    .catch(handleErrors);



function toJSON(response) {
    return response.json();
}

function handleErrors(error) {
    // alert('Please try again problem occered!')
}


// G E T 
function authorizedGet(url, methodToRun) {
    let tokenElement = JSON.parse(localStorage.getItem('Authorization'));
    console.log(tokenElement);
    let authorizedHeaders = { "Authorization": "Bearer " + tokenElement.jwt };
    fetch(url, {
        method: "GET",
        headers: authorizedHeaders
    })
        .then(toJSON)
        .then(methodToRun)
        .catch(handleErrors);
}

const userFromStorage = JSON.parse(localStorage.getItem('user'));
let url = "http://localhost:8080/enrolledUser/dto/" + userFromStorage.id;
authorizedGet(url, getUserById);

function getUserById(data) {

    const fname = document.getElementById('first_name');
    const lname = document.getElementById('last_name');
    const dob = document.getElementById('birthday');
    const email = document.getElementById('email');
    const telephone = document.getElementById('phone');
    const mobile = document.getElementById('mobile');
    const address = document.getElementById('address');
    const city = document.getElementById('city');
    const municipality = document.getElementById('municipality');
    const postalcode = document.getElementById('postalcode');
    const imageUrl = document.getElementById('profile-photo');
    const username = document.getElementById('username-sidebar');
    fname.value = data.fname;
    lname.value = data.lname;
    dob.value = data.dateofbirth;
    email.value = data.email;
    telephone.value = data.telephone;
    mobile.value = data.mobile;
    address.value = data.address;
    city.value = data.city;
    municipality.value = data.municipality;
    postalcode.value = data.postalcode;
    imageUrl.src = data.imageUrl.url;
    username.innerText = data.username;
    city.value = data.city;
}



function getUser() {

    const fnameUpdate = document.getElementById('first_name').value;
    const lnameUpdate = document.getElementById('last_name').value;
    const dobUpdate = document.getElementById('birthday').value;
    const emailUpdate = document.getElementById('email').value;
    const telephoneUpdate = document.getElementById('phone').value;
    const mobileUpdate = document.getElementById('mobile').value;
    const addressUpdate = document.getElementById('address').value;
    const cityUpdate = document.getElementById('city').value;
    const municipalityUpdate = document.getElementById('municipality').value;
    const postalcodeUpdate = document.getElementById('postalcode').value;
    const imageUrlUpdate = document.getElementById('profile-photo').value;
    const user = JSON.parse(localStorage.getItem('user'));
    const usernameUpdate = user.username;

    let userToUpdate = {
        username: usernameUpdate,
        fname: fnameUpdate,
        lname: lnameUpdate,
        email: emailUpdate,
        dateofbirth: dobUpdate,
        postalcode: postalcodeUpdate,
        address: addressUpdate,
        city: cityUpdate,
        municipality: municipalityUpdate,
        telephone: telephoneUpdate,
        mobile: mobileUpdate,
        imageUrl: { id: 0 }
    }

    return JSON.stringify(userToUpdate);
}

const save = document.getElementById('js-form-update');

save.addEventListener('submit', (e) => {
    e.preventDefault();
    const user = JSON.parse(localStorage.getItem('user'));
    let url = "http://localhost:8080/enrolledUser/dto/" + user.id;
    let userToUpdate = getUser();
    authorizedFetch("PUT", url, userToUpdate);
});


// Post, Put  
function authorizedFetch(method, url, body) {
    let tokenElement = JSON.parse(localStorage.getItem('Authorization'));
    console.log(tokenElement);
    let headers = {
        "Content-Type": "application/json",
        "Access-Control-Origin": "*",
        "Authorization": "Bearer " + tokenElement.jwt
    };
    fetch(url, {
        method: method,
        headers: headers,
        body: body
    })
        .then(toJSON)
        .catch(handleErrors);
}

function toJSON(response) {
    return response.json();
}





//==  ORDERS PREVIEW  =================================================================
function ordersTemplate(order) {
    const template = ` 
            <tr class="h6 font-weight-light" id="${order.orderingId}">
                <td class="col-2 text-center font-small"  id="order-no">${order.orderingId}</td>
                <td class="col-2 text-center font-small" id="order-date">${order.orderDate}</td>
                <td class="col-2 text-center font-small"  id="order-vendor">${order.companyProfile}
                </td>
                <td class="col-3 text-center font-small "  id="order-service">${order.productProfile}</td>
                <td class="col-md-2 text-center font-small" id="order-cost">${order.price}€</td>
                <td>
                   
                    <button
                        onclick="document.getElementById('ratingModal').style.display='block'"
                        class="btn btn-twitch"> <span class="h6 text-light">Αξιολόγιση</span>
                    </button>
                </td>
            </tr>`;

    return template;
}

function orderRating(data) {
    let orders = data;
    let output = "";
    for (let i = 0; i < orders.length; i++) {
        output += ordersTemplate(orders[i][0]);
    }
    document.querySelector('#ordersByUserId').innerHTML = output;


}

const urlOrdering = "http://localhost:8080/ordering/search/" + userFromStorage.id;

fetch(urlOrdering)
    .then(toJSON)
    .then(orderRating)
    .catch(handleErrors);




//==  RATING REVIEWS PREVIEW  =================================================================


function ratingTemplate(rating) {
    const template = ` 
                <tr>
                    <td class="col-md-2 font-small text-center" id="rating-vendor">${rating.companyProfile}</td>
                    <td class="col-md-2 font-small text-center" id="rating-date">${rating.ratingDate}</td>
                    <td class="col-md-2 font-small text-center" id="rating-service"> 
                        ${rating.productProfile}    
                    </td>
                    <td class="col-md-2 font-medium text-warning text-center r${rating.productRating}" id="rating-mark">
                    
                    </td>
                    <td class="col-md-2 font-small text-center" id="rating-text">
                        ${rating.productComment}
                    </td>
                </tr>`;

    return template;
}

function renderRating(data) {
    let rating = data;
    let output = "";
    for (let i = 0; i < rating.length; i++) {
        output += ratingTemplate(rating[i]);
    }
    document.querySelector('#ratingByUserId').innerHTML = output;


}

const urlReview = "http://localhost:8080/review/search/enrolledUser/" + userFromStorage.id;


fetch(urlReview)
    .then(toJSON)
    .then(renderRating)
    .catch(handleErrors);


const disconnect = document.getElementById('js-disconnect');

disconnect.addEventListener('click', (e) => {
    e.preventDefault();
    localStorage.removeItem('user');
    window.location.href = "index.html";
});
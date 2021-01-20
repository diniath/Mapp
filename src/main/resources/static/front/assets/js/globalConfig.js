//     S E A R C H 
fetch("http://localhost:8080/subcategory")
    .then(toJSON)
    .then(populateSearchOptions)
    .catch(handleErrors);

function toJSON(response) {
    return response.json();
}

function handleErrors(error) {
    alert = "ops something went wrong"
}

function populateSearchOptions(subcategoriesFromFetch) {
    let counter = 0;
    let output = "";
    const searchDatalist = document.getElementById('searchSubcategory-datalist');
    subcategoriesFromFetch.forEach(subcategory => {  // display unique values 

        if (counter < 10) {
            output += renderDatalistOptions(subcategory);
            counter++;
        }
    });
    searchDatalist.innerHTML = output;
}
function renderDatalistOptions(subCategory) {
    const template = `<option data-value="${subCategory.id}" value="${subCategory.description}">`
    return template;
}
// search with keyword
const search = document.getElementById('search-form');
search.addEventListener('submit', (e) => {
    e.preventDefault();
    const parameter = searchInput.value;
    document.getElementById('search-form').reset();
    window.location.href = "results.html?searchInput=" + parameter;
});
// search with datalist option 
const searchInput = document.getElementById('search');
searchInput.addEventListener('change', (e) => {
    e.preventDefault();
    var search = document.getElementById("search").value;
    var id = document.querySelector("#searchSubcategory-datalist option[value='" + search + "']").dataset.value;
    document.getElementById('search-form').reset();
    window.location.href = "results.html?subcategoryId=" + id;
});


//   L O G I N 

const loginBtn = document.getElementById('login-form');

loginBtn.addEventListener("submit", (e) => {
    e.preventDefault();
    let headers = {
        "Content-Type": "application/json",
        "Access-Control-Origin": "*"
    };

    let checkBox = document.getElementById('js-company-login');

    if (!checkBox.checked) {
        authenticate("http://localhost:8080/auth/user", headers);
    } else if (checkBox.checked) {
        authenticate("http://localhost:8080/auth/company", headers);
    }
});

function authenticate(url, headers) {
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    let data = { "username": username, "password": password };

    fetch(url, {
        method: "POST",
        headers: headers,
        body: JSON.stringify(data)
    })
        .then(function (response) {
            if (response.status == "200") {
                return response.json();
            } else {
                alert("Incorrect username or password");
            }
        })
        .then(function (data) {
            localStorage.setItem("Authorization", JSON.stringify(data));
            $('.close:visible').click();
            authorizedGet("http://localhost:8080/enrolledUser/search/" + username, storeUser);
            authorizedGet("http://localhost:8080/company/search/" + username, storeCompany);
        }).catch(handleErrors);
}


function handleErrors(error) {
    alert = "ops something went wrong";
}


// L O G I N   G E T 
function authorizedGet(url, methodToRun) {
    let tokenElement = JSON.parse(localStorage.getItem('Authorization'));
    let authorizedHeaders = { "Authorization": "Bearer " + tokenElement.jwt };
    fetch(url, {
        method: "GET",
        headers: authorizedHeaders
    })
        .then(toJSON)
        .then(methodToRun)
        .catch(handleErrors);
}

function storeUser(user) {
    if (user.status != "BAD_REQUEST") {
        localStorage.setItem('user', JSON.stringify(user));
        try {
            let company = localStorage.getItem('company');
            if (company) {
                localStorage.removeItem('company');
            }
        } catch (error) { console.log(error) }
    }
}

function storeCompany(company) {
    if (company.status != "BAD_REQUEST") {
        localStorage.setItem('company', JSON.stringify(company));
        try {
            let user = localStorage.getItem('user');
            if (user) {
                localStorage.removeItem('user');
            }
        } catch (error) { console.log(error) }
    }
}

// CART ===========================================================================


// const addToCart = document.getElementById('js-add-to-cart');

function addProductToCart() {
    try {
        let cart = JSON.parse(localStorage.getItem('cart'));
        cartForList = Array.from(cart);

    } catch (error) { console.log(error); }
    let temp = addToCartList();
    // temp.randomId ++;
    cartForList.push(temp);
    localStorage.setItem('cart', JSON.stringify(cartForList));
}

// addToCart.addEventListener("click", (e) => {
//     e.preventDefault();
//     try {
//         let cart = JSON.parse(localStorage.getItem('cart'));
//         console.log("*" + cart + "*");

//         cartForList = Array.from(cart);

//     } catch (error) { console.log(error); }
//     let temp = addToCartList();
//     // temp.randomId ++;
//     cartForList.push(temp);
//     localStorage.setItem('cart', JSON.stringify(cartForList));

// });


let cartForList = [];

function addToCartList() {
    const title = document.getElementById("serviceTitle").innerText;
    const price = document.getElementById("servicePrice").innerText;
    const appointment = document.getElementById("serviceDateTime").value;
    const date = appointment.substring(0, appointment.length - 6);
    const time = appointment.substr(appointment.length - 5);
    const serviceId = document.getElementById('serviceId').innerText;

    let random = Math.random();

    const tempObj = {
        id: serviceId,
        tilte: title,
        price: price,
        date: date,
        time: time,
        randomId: random,
        counter: random
    }

    return tempObj;
}

function checkOutCart() {

    localStorage.setItem('cart', JSON.stringify(cartForList));
    window.location.href = "http://localhost:8080/charge"
}


let cartServiceList = document.getElementById('cartServiceList').innerHTML;
let output = "";


function renderCartList(service) {
    const template = `
    <tr>
    
        <td class="test">
            <p class="m-0 p-0 h5">${service.tilte}</p>
            <p class="m-0 p-0 h6">${service.tilte}</p>
        </td>
        <td>
            <div class="m-0 p-0 ">
                <div> <i class="far fa-calendar-alt h4 "></i> <span class="h4">${service.date}</span></div>
                <div><i class="far fa-clock h6"></i> <span class="h6">${service.time}</span></div>
            </div>
        </td>
        <td>
            <div class="m-0 p-0"><i class="fas fa-euro-sign h5"> <span class="h5">${service.price}</span></i>
                <a class="btn" id="${service.randomId}" onclick='deleteBtn(${service.randomId})'><i class="fas fa-trash-alt h4"></i></a>
            </div>
        </td>
    </tr>`;


    return template;
}

$(document).ready(function () {
    $("#cartBtn").click(function () {
        $("#cart").slideToggle();
    });

    $("#cartBtn").click(function renderCart() {
        let output = "";
        let cartTotal = 0;
        for (let i = 0; i < cartForList.length; i++) {
            output += renderCartList(cartForList[i]);
        }
        document.querySelector('#cartServiceList').innerHTML = output;

        for (let i = 0; i < cartForList.length; i++) {
            cartTotal += parseInt(cartForList[i].price);
        }
        document.getElementById('cartTotal').innerText = cartTotal;
    });
});

function deleteBtn(randomId) {
    document.getElementById(randomId).closest('tr').remove();
    var removeIndex = cartForList.map(item => item.counter).indexOf(randomId);
    if (removeIndex > 1) {
        removeIndex && cartForList.splice(removeIndex, 1);
    } else {
        cartForList.shift();
    }
    let cartTotal = 0;
    for (let i = 0; i < cartForList.length; i++) {
        cartTotal += parseInt(cartForList[i].price);
    }
    document.getElementById('cartTotal').innerText = cartTotal;
    try {
        localStorage.removeItem('cart');
    } catch (error) { console.log(error); }
    localStorage.setItem('cart', JSON.stringify(cartForList));
}

$(document).ready(function () {
    $("#cartCloseBtn").click(function () {
        $("#cart").slideToggle();
    });
});


// SIGN IN MODAL ===========================================================================


// $(document).ready(function () {
//     $("#userModalBtn").click(function () {
//         $("#userModal").slideToggle();

//     });
// });

$(document).ready(function () {
    $("#userModalCloseBtn").click(function () {
        $("#userModal").slideToggle();

    });
});

$(document).ready(function () {
    $("#userModalBtn").click(function () {
        let user = {};
        let company = {};
        try {
            user = JSON.parse(localStorage.getItem('user'));
        }
        catch (exception_var) {
            catch_statements
        }
        try {
            company = JSON.parse(localStorage.getItem('company'));
        }
        catch (exception_var) {
            catch_statements
        }
        if (!user && !company) {
            $("#userModal").slideToggle();
        } else if (user) {
            window.location.href = "user_cp.html?";
        } else if (company) {
            window.location.href = "company_control_panel.html?";
        }
    });
});

// DATEPICKER ===========================================================================


$(document).ready(function () {

    $("#dtBox").DateTimePicker();

});


$('#myModal').on('shown.bs.modal', function () {
    $('#myInput').trigger('focus')
})



// RATING ===========================================================================

$("#review").rating({
    "value": 2,
    "click": function (e) {
        console.log(e);
        $("#starsInput").val(e.stars);
    }
});

$("#10starsReview").rating({
    "stars": 10,
    "click": function (e) {
        console.log(e);
        $("#10starsInput").val(e.stars);
    }
});

$("#customstarsReview").rating({
    "emptyStar": "far fa-play-circle",
    "filledStar": "fas fa-play-circle",
    "color": "#4c71ff",
    "click": function (e) {
        console.log(e);
        $("#customstarsInput").val(e.stars);
    }
});

$("#halfstarsReview").rating({
    "half": true,
    "click": function (e) {
        console.log(e);
        $("#halfstarsInput").val(e.stars);
    }
});

$("#unrealisticReview").rating({
    value: 3,
    stars: 7,
    emptyStar: "far fa-arrow-alt-circle-left",
    halfStar: "far fa-angry",
    filledStar: "fas fa-arrow-alt-circle-right",
    color: "#ff3ef9",
    half: true,
    click: function (e) {
        console.log(e);
        $("#unrealisticInput").val(e.stars);
    }
});




// function storeCartToDb() {
//     let carts = [];
//     try {
//         cart = JSON.parse(localStorage.getItem('cart'));
//     } catch (error) {
//         console.log(error);
//     }
//     carts.forEach(cart => {
//         let url = "http://localhost:8080/cart"
//         body = createOrderingFromCart(cart);
//         postCart(url, body);
//     });
// }

// function createOrderingFromCart(cart) {
//     let enrolleduser = {};
//     let userid = 11;
//     try {
//         enrolleduser = JSON.parse(localStorage.getItem('user'));
//     } catch (error) {
//         console.log(error);
//     }
//     if (enrolleduser) {
//         userid = enrolleduser.id;
//     }

//     const order = {
//         ordering: { orderdate: cart.date, paymentMethod: 'card', enrolledUser: { id: userid } },
//         product: { id: cart.id },
//         company: { id: 1 },
//         endDate: 18,
//         startDate: 19,
//         appointmentDate: cart.date
//     }
//     return JSON.stringify(order);
// }


// const sendCart = document.getElementById('submitButton');

// sendCart.addEventListener('submit', (e) => {
//     storeCartToDb();
// });
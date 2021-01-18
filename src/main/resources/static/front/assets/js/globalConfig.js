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
    let data = {"username": username, "password": password};

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
    let authorizedHeaders = {"Authorization": "Bearer " + tokenElement.jwt};
    fetch(url, {
        method: "GET",
        headers: authorizedHeaders})
            .then(toJSON)
            .then(methodToRun)
            .catch(handleErrors);
}

function storeUser(user) {
    if (user) {
        localStorage.setItem('user', JSON.stringify(user));
    }
}

function storeCompany(company) {
    if (company) {
        localStorage.setItem('company', JSON.stringify(company));
    }
}

// CART ===========================================================================

let cartList = [];

function addToCartList() {
    const title = document.getElementById("serviceTitle").innerText;
    const price = document.getElementById("servicePrice").innerText;
    const appointment = document.getElementById("serviceDateTime").value;
    const date = appointment.substring(0, appointment.length - 6);
    const time = appointment.substr(appointment.length - 5);

    const tempObj = {
        "id": Math.random(),
        "tilte": title,
        "price": price,
        "date": date,
        "time": time,
        "randomId": Math.random()
    };

    return cartList.push(tempObj);
}


function checkOutCart() {

    localStorage.setItem('cart', JSON.stringify(cartList));
    window.location.href = "charge.html" /*localhost:8080/*/
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
        for (let i = 0; i < cartList.length; i++) {
            output += renderCartList(cartList[i]);
        }
        document.querySelector('#cartServiceList').innerHTML = output;

        for (let i = 0; i < cartList.length; i++) {
            cartTotal += parseInt(cartList[i].price);
        }
        document.getElementById('cartTotal').innerText = cartTotal;
    });
});

function deleteBtn(id) {
    document.getElementById(id).closest('tr').remove();
    for (let i = 0; i < cartList.length; i++) {
        cartList.pop(cartList[i].randomId === id);
    }

    let cartTotal = 0;
    for (let i = 0; i < cartList.length; i++) {
        cartTotal += parseInt(cartList[i].price);
    }
    document.getElementById('cartTotal').innerText = cartTotal;
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

        let user = JSON.parse(localStorage.getItem('user'));
        let company = JSON.parse(localStorage.getItem('company'));
        if (!user || !company) {
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
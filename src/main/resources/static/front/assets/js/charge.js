let retrieveCartFromLocalStorage = localStorage.getItem("cart");
let checkedOutCart = JSON.parse(retrieveCartFromLocalStorage);

let totalCartBill = 0;

for (let i = 0; i < checkedOutCart.length; i++) {
    totalCartBill += parseInt(checkedOutCart[i].price);
}

document.getElementById("totalCartBill").innerText = totalCartBill;
$(function () {
    var API_KEY = $("#api-key").val();
    // Create a Stripe client.
    var stripe = Stripe(API_KEY);

    // Create an instance of Elements.
    var elements = stripe.elements();

    // Create an instance of the card Element.
    var card = elements.create("card");

    // Add an instance of the card Element into the `card-element` <div>.
    card.mount("#card-element");

    // Handle real-time validation errors from the card Element.
    card.addEventListener("change", function (event) {
        var displayError = document.getElementById("card-errors");
        if (event.error) {
            displayError.textContent = event.error.message;
        } else {
            displayError.textContent = "";
        }
    });

    // Handle form submission.
    var form = document.getElementById("payment-form");
    form.addEventListener("submit", function (event) {
        event.preventDefault();
        // handle payment
        handlePayments();
    });

    //handle card submission
    function handlePayments() {
        stripe.createToken(card).then(function (result) {
            if (result.error) {
                // Inform the user if there was an error.
                var errorElement = document.getElementById("card-errors");
                errorElement.textContent = result.error.message;
            } else {
                // Send the token to your server.
                let token = result.token.id;
                let email = $("#email").val();
                let cart = JSON.parse(localStorage.getItem("cart"));
                let sum = 0;
                const resulPaymentWindow = document.getElementById('modal-payment');

                cart.forEach((element) => {
                    sum += parseInt(element.price);
                });
                sum = sum * 100;
                $.post(
                    "/create-charge",
                    { email: email, token: token, total: sum },
                    function (data) {
                        if (data.status === true) {
                            resulPaymentWindow.innerHTML = `<div class="bg-warning text-white h2">Αποτέλεσμα πληρωμής</div>
                <div class="font-medium">Η πληρωμή σας έγινε δεκτή κωδικός πληρωμής:${data.details} </div>
                <a href="../front/index.html" class="btn btn-primary">Επιστροφή στην αρχική</a>`
                storeCartToDb(); // stores charge on DB
                           
                        } else {
                            resulPaymentWindow.innerHTML = `<div class="bg-warning text-white h2">Αποτέλεσμα πληρωμής</div>
                <div class="font-medium">Η πληρωμή σας δεν έγινε δεκτή κωδικός πληρωμής:${data.details} </div>
                <a href="../front/index.html" class="btn btn-primary">Επιστροφή στην αρχική</a>`
                            
                        }
                    },
                    "json"
                );
            }
        });
    }
});


function storeCartToDb() {
    let carts = [];
    let body =[];
    try {
        carts = JSON.parse(localStorage.getItem("cart"));        
    } catch (error) {
        console.log(error);
    }

    for (let i=0; i< carts.length; i++){
        body.push(createOrderingFromCart(carts[i]));       
    }
    let url = "http://localhost:8080/cart";
    postCart(url, JSON.stringify(body));  
}

function createOrderingFromCart(cart) {
    let enrolledUser = {};
    let userid = 11;
    try {
        enrolledUser = JSON.parse(localStorage.getItem('user'));
    } catch (error) {
        console.log(error);
    }
    if (enrolledUser) {
        userid = enrolledUser.id;
    }
        
    let unreveresedDAte = cart.date;    
    let postDate = unreveresedDAte.split("-").reverse().join("-");
    let today = new Date().toLocaleDateString();
    today = today.split("/").reverse().join("-");
    console.log(today);    
    const order = {         
        ordering: { orderdate: postDate , paymentMethod: 'card', enrolledUser: { id: userid } },
        product: { id: cart.id },
        company: { id: 1 },
        endDate: 18,
        startDate: 19,
        appointmentDate: postDate
    }    
    return order;
}

function postCart(url, body) {
    let headers = {
        "Content-Type": "application/json",
        "Access-Control-Origin": "*"
    };

    fetch(url, {
        method: "POST",
        headers: headers,
        body: body
    })
        .then(toJSON)
        .then(function (data) {

        }).catch(handleErrors);
}

function toJSON(response) {
    return response.json();
}
function handleErrors(error) {
    console.log(error);
}
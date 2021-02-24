
function userSignUp() {

    const userEmail = document.getElementById('userEmail').value;
    const userName = document.getElementById('userName').value;
    const userPassword = document.getElementById('userPassword').value;
    const userFName = document.getElementById('userFName').value;
    const userLName = document.getElementById('userLName').value;
    const userDOB = document.getElementById('userDOB').value;
    const userTelephone = document.getElementById('userTelephone').value;
    const userMobile = document.getElementById('userMobile').value;
    const userAddress = document.getElementById('userAddress').value;
    const userCity = document.getElementById('userCity').value;
    const userMunicipality = document.getElementById('userMunicipality').value;
    const postalcode = document.getElementById('postalcode').value;

    let postUserData = {
        username: userName,
        password: userPassword,
        fname: userFName,
        lname: userLName,
        email: userEmail,
        dateofbirth: userDOB,
        postalcode: postalcode,
        address: userAddress,
        city: userCity,
        municipality: userMunicipality,
        telephone: userTelephone,
        mobile: userMobile,
        imageUrl: { id: 66 },
        roleList: [{ id: 1 }]
    }
    return JSON.stringify(postUserData);
}


const save = document.getElementById('js-form-update');

save.addEventListener('submit', (e) => {
    e.preventDefault();
    let userToSign = userSignUp();
    storeUserToDatabase("POST", "http://localhost:8080/enrolledUser", userToSign);
});


// Post, Put  
function storeUserToDatabase(method, url, body) {
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
        .catch(handleErrors);
}

function toJSON(response) {
    return response.json();
}

function handleErrors(error) {
    alert = "ops something went wrong"
}


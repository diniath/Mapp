function fetchFast(url, methodToRun) {
    fetch(url)
        .then(toJSON)
        .then(methodToRun)
        .catch(handleErrors);
}
function handleErrors(error) {
    alert = "ops something went wrong"
}
function toJSON(response) {
    return response.json();
}

//                                        const productsBySubUrl = "./json/productBySubcategory.json";
const subUrl = "http://localhost:8080/subcategory";

//                                        fetchFast(productsBySubUrl, renderResultPage);
fetchFast(subUrl, populateSearchOptions);


function populateSearchOptions(subcategoriesFromFetch) {
    let counter = 0;
    let output = "";
    const searchDatalist = document.getElementById('searchSubcategory-datalist');
    subcategoriesFromFetch.forEach(subcategory => {

        if (counter < 10) {
            output += renderDatalistOptions(subcategory);
            counter++;
        }
    });
    searchDatalist.innerHTML = output;
}

function renderDatalistOptions(subcategory) {
    const template = `<option data-value="${subcategory.id}" value="${subcategory.description}">`
    return template;
}

function loadProductsFromFetch() {
    const urlParams = new URLSearchParams(window.location.search);
    const subcategoryId = urlParams.get('subcategoryId');
    const inputParam = urlParams.get('searchInput');
    const searchBySubcategoryURL = "http://localhost:8080/product/search/subcategory/" + subcategoryId;
    const searchByUserIpnutUrl = "http://localhost:8080/product/search/profile/" + inputParam;

    if (subcategoryId) {
        //                    filteredProductList = []; // empty the global productList
        fetchFast(searchBySubcategoryURL, renderResultPage);
    } else if (inputParam) {
        //                    filteredProductList = []; // empty the global productList
        fetchFast(searchByUserIpnutUrl, renderResultPage);
    }
}

loadProductsFromFetch();


function renderServiceMiniBox(service) {
    const renderServiceMiniBox = `
    <div class="card bg-white fmh-600 fmxw-350 fmxh-650 rounded m-1">
            <div class="w-100 fmxh-250 fmh-250 rounded">
                <img src="${service.imageUrlList[0].url}" class="rounded-top d-block w-100 h-100 image-responsive" alt="...">
            </div>
            <div class="fmh-300 card-body fmxh-300 w-100">

                <div>
                    <h5 class="d-block card-title truncate-text">${service.profile}</h5>
                </div>
                <div class="fmxh-150 overflow-auto py-1 h-100">
                    <p class="card-text overflow-hiden">${service.description}</p>
                </div>
                
                <div class="d-flex justify-content-between pt-4">
                    <div class="d-flex align-self-end p-0 m-0">
                        <span class="text-warning text-left align-bottom p-0 m-0">
                            <i class="${service.rating > 0 ? " fas fa-star text-warning" : "far fa-star text-warning"} h6"></i>
                            <i class="${service.rating > 1 ? " fas fa-star text-warning" : "far fa-star text-warning"} h6"></i>
                            <i class="${service.rating > 2 ? " fas fa-star text-warning" : "far fa-star text-warning"} h6"></i>
                            <i class="${service.rating > 3 ? " fas fa-star text-warning" : "far fa-star text-warning"} h6"></i>
                            <i class="${service.rating > 4 ? " fas fa-star text-warning" : "far fa-star text-warning"} h6"></i>
                        </span>
                        <span class="pl-2 h6">(${service.rating}/5)</span>
                    </div>
                    <div class="">
                        <div class="h4">
                            <a onclick="goToService(${service.id})" class="btn btn-warning w-100 mx-2"><i
                                    class="fas fa-euro-sign h4"></i>
                                <span class="h4">${service.price}</span> </a>
                        </div>
                    </div>
                </div>
            </div>

    </div>
`;
    return renderServiceMiniBox;
}


function renderResultPage(products, isFromFilter) {
    let results = filterProductsFromFetch(products);
    let output = "";
    for (let i = 0; i < results.length; i++) {
        output += renderServiceMiniBox(results[i]);
    }
    document.querySelector('#result-container').innerHTML = output;

    if ((filteredProductList === undefined || filteredProductList.length == 0) || (!isFromFilter)) { //checks if global productList is empty

        setSliderLimits(products); // adds min max to price range 
        filteredProductList = products; // adds products to global productList
    }
}


const input = document.getElementById('search');
input.addEventListener('change', (e) => {
    e.preventDefault();
    let search = document.getElementById("search").value;
    let id = document.querySelector("#searchSubcategory-datalist option[value='" + search + "']").dataset.value;
    const searchBySubcategoryURL = "http://localhost:8080/product/search/subcategory/" + id;
    document.getElementById('search-form').reset();
    fetchFast(searchBySubcategoryURL, renderResultPage);

});

const filters = document.getElementById('js-filter');

function setSliderLimits(products) {
    let min = products[0].price;
    let max = products[0].price;

    for (let i = 1; i < products.length; i++) {
        let value = products[i].price;
        if (value < min)
            min = value;
        if (value > max)
            max = value;
    }
    $('.js-price-slider').attr({ "max": max, "min": min, "value": max });
    $('.js-slider-value').text(max);
}

$('.js-price-slider').on('input', function (ev) {
    let currentValue = ev.target.value;
    $('.js-slider-value').text(currentValue);
    filterProducts(filteredProductList);
});

let filteredProductList = [];

function filterProducts(products) {
    let isFromFilter = new Boolean(true);
    renderResultPage(filterProductsFromFetch(products), isFromFilter);
}

function filterProductsFromFetch(products) {
    entriesFound = [];
    let isFromFilter = new Boolean(true);

    let ratings = [];
    $("input:checkbox[name=rating]:checked").each(function () {
        const rating = parseInt($(this).val());
        ratings.push(rating);
    });

    let maxPriceSelected = parseInt($('.js-price-slider').val());

    products.forEach(product => { // filters on global productList
        if ((product.price <= maxPriceSelected) && (ratings.includes(product.rating) || (ratings.length === 0))) {
            entriesFound.push(product);
        }
    });
    return entriesFound;
}

$('.js-filter').on('change', (e) => {
    const subcategoryId = e.target.value;
    const searchBySubcategoryURL = "http://localhost:8080/product/search/subcategory/" + subcategoryId;
    fetchFast(searchBySubcategoryURL, renderResultPage);
});

$('input[name=rating]').change(function () {
    if ($(this).is(':checked')) {
        filterProducts(filteredProductList);
    } else {
        filterProducts(filteredProductList);
    }
});

// search with keyword
const searchForm = document.getElementById('search-form');
searchForm.addEventListener('submit', (e) => {
    e.preventDefault();
    const parameter = searchInput.value;
    document.getElementById('search-form').reset();
    const searchByUserIpnutUrl = "http://localhost:8080/product/search/profile/" + parameter;
    fetchFast(searchByUserIpnutUrl, renderResultPage);
});

function goToService(id) {
    window.location.replace("http://localhost:8080/front/service_profile.html?serviceId=" + id);
}
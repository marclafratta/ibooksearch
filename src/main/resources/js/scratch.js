let myRequest = new Request('/search/Stephen King');

let myResponse; 

fetch(myRequest).then(function(response) {
    myResponse = response.json();
    return myResponse;
}).then(function(response) {
    console.log(typeof(response))
    console.log(response)
    console.log("jsjs" + response.resultCount)

    response.results.forEach(function (result) {
        console.log(result.trackName)
        buildElements(result)
    })
});

let buildElements = function (bookinfo){
    let row  = document.createElement('div')
    row.className = "row list-row";
    row.textContent = bookinfo.trackName
    let resultList = document.querySelector("#result-list")
    resultList.appendChild(row)
}
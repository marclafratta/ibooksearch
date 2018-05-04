let loadResults = function (searchTerm) {
    
    let myRequest = new Request(`/search/${searchTerm}`)

    // Empty search not valid
    if( searchTerm === ''){
        return
    }

    fetch(myRequest).then(function(response) {
        console.log(response.ok)
        console.log(typeof(response))
        console.log(response)
        
        clearResults()

        if(!response.ok)
        {
            document.querySelector(".no-results").style.display = '' 
        } else {
            return response.json()
        }
    }).then(function(responseJson){
        if(typeof(responseJson) != 'undefined'){
            console.log(responseJson)
            console.log("jsjs" + responseJson.resultCount)

            if (responseJson.length > 0){
                document.querySelector(".no-results").style.display = 'none'
            } else {
                document.querySelector(".no-results").style.display = ''
            }

            if (responseJson.length > 0){
                responseJson.forEach(function (result) {
                    console.log(result.trackName)
                    buildElement(result)
                })
            }
        }
    })
}

let buildElement = function (bookinfo){

    console.log(bookinfo)

    let row  = document.createElement('div')
    row.className = "row list-row";

    let firstCol = `<div class = "col-sm-2"><img class="cover-image" src=${bookinfo.artworkUrl}><br>
    <a float="right" class="btn btn-primary buy-button" href="${bookinfo.buyUrl}">Buy</a></div>`
    row.innerHTML += firstCol

    let publishDateObj = new Date(bookinfo.publishDate)
    let secondCol = `<div class = "col-sm-4"><h4>${bookinfo.title}</h4>
    <b>${bookinfo.author}</b><p>${bookinfo.genre}<br>${publishDateObj.toDateString()}<br>
    ${bookinfo.price}</p></div>`
    row.innerHTML += secondCol

    let thirdCol = `<div class = "col-sm-6">${bookinfo.description}</div>`
    row.innerHTML += thirdCol

    let resultList = document.querySelector("#result-list")
    resultList.appendChild(row)
}

let clearResults = function() {
    document.querySelector("#result-list").innerHTML = ''
}

let searchButton = document.querySelector("#search-button")
let searchInput = document.querySelector("#search-term")

searchButton.addEventListener('click', function (e) {
    console.log('click')
    loadResults(searchInput.value)
})

// prevent refresh on enter
document.addEventListener('keydown', function (e) {
    if (e.keyCode === 13) {
        e.preventDefault()
    }
})

searchInput.addEventListener('keyup', function (e) {
    if (e.keyCode === 13) {
        e.preventDefault()
        console.log("enter")
        loadResults(e.target.value)
    }
})

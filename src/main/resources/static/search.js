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

            if (responseJson.resultCount > 0){
                document.querySelector(".no-results").style.display = 'none'
            } else {
                document.querySelector(".no-results").style.display = ''
            }

            if (responseJson.resultCount > 0){
                responseJson.results.forEach(function (result) {
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

    let firstCol = `<div class = "col-sm-2"><img class="cover-image" src=${bookinfo.artworkUrl100}><br>
    <a float="right" class="btn btn-primary buy-button" href="${bookinfo.trackViewUrl}">Buy</a></div>`
    row.innerHTML += firstCol

    let releaseDateObj = new Date(bookinfo.releaseDate)
    let secondCol = `<div class = "col-sm-4"><h4>${bookinfo.trackName}</h4>
    <b>${bookinfo.artistName}</b><p>${bookinfo.genres[0]}<br>${releaseDateObj.toDateString()}<br>
    ${bookinfo.formattedPrice}</p></div>`
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

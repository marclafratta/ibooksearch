<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>iBooks Search</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
        crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    <link rel="icon" type="image/png" href="book-icon.png">
</head>

<body>

    <nav class="navbar navbar-expand-lg navbar-dark bg-secondary justify-content-between">
        <a class="navbar-brand" href="#">iBooks Search</a>

            <form class="form-inline my-2 my-lg-0">
                <input id = "search-term" type="search" placeholder="Search" class="form-control mr-sm-2">
                <button id = "search-button" type="button" class="btn btn-primary">Search</button>
            </form>

    </nav>

    <div class="container justify-center no-results">
        <div class="jumbotron">
            <h1 class="display-4">No results</h1>
        </div>
    </div>

    <div id = "result-list" class="container">
        <!--<div class="row list-row">
            <div class="col-sm-2" >
                <img src="https://is4-ssl.mzstatic.com/image/thumb/Publication128/v4/e2/08/d5/e208d53a-7e00-c378-2831-ca5dcf3d926d/source/100x100bb.jpg"
                    class="figure-img img-fluid rounded">
            </div>
            <div class="col-sm-5">book title</div>
            <div class="col-sm-5"><button type="button" float="right" class="btn btn-primary">bUy buy buy</button></div>
        </div>

        <div class="row list-row">
            <div class="col-sm-2">
                <img src="https://is4-ssl.mzstatic.com/image/thumb/Publication128/v4/e2/08/d5/e208d53a-7e00-c378-2831-ca5dcf3d926d/source/100x100bb.jpg"
                    class="figure-img img-fluid rounded">
            </div>
            <div class="col-sm-5">2nd book title</div>
            <div class="col-sm-5"><button type="button" float="right" class="btn btn-primary">bUy buy buy</button></div>

        </div>-->

    </div>


    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
        crossorigin="anonymous"></script>

    <script src="search.js"></script>
</body>

</html>
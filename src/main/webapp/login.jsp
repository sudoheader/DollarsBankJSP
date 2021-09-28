<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome To DollarsBank!</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
            crossorigin="anonymous"></script>
</head>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="#">Welcome to DollarsBank!</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText"
                aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="nav justify-content-end collapse navbar-collapse" id="navbarText">
        <span class="navbar-text">
            &#128231; dollarsbank@global.com
            &#128241; 1 202 555 0191 <!-- uses solid style -->
    </span>
        </div>
    </div>
</nav>
<body>
<div class="container">
    <div class="row">
        <div>
            <form action="hello-servlet" method="POST">
                <div class="row g-3">
                    <div class="col">
                        <input type="text" class="form-control" placeholder="Customer ID" aria-label="Customer ID">
                    </div>
                    <div class="col">
                        <input type="password" class="form-control" placeholder="Password" aria-label="Password">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

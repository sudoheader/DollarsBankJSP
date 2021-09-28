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

<body>

<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="#">Welcome to DollarsBank!</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText"
                    aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="nav justify-content-end collapse navbar-collapse" id="navbarText">
        <span class="navbar-text text-light">
            &#128231; dollarsbank@global.com
            &#128241; 1 202 555 0191 <!-- uses solid style -->
        </span>
            </div>
        </div>
    </nav>
</header>

<main role="main" class="container">
    <div class="row">
        <div>
            <form action="<%= request.getContextPath() %>/hello-servlet" method="POST">
                <div class="form-group">
                    <br/>
                </div>
                <h4>Customer Login</h4>
                <div>
                    <img style="float: right; max-height: 400px; width: auto;" src="2bill.jpg">
                </div>
                <div class="form-group col-md-3">
                    <label>Customer Id:</label>
                    <input type="text" name="customer_id" class="form-control" placeholder="ex. 12345678">
                </div>
                <div class="form-group col-md-3">
                    <label>Password:</label>
                    <input type="password" name="password" class="form-control" placeholder="ex. 1234">
                </div>
                <br/>
                <div class="form-group">
                    <button type="submit" class="btn btn-success">Submit</button>
                </div>
            </form>
        </div>
    </div>
</main>

<footer class="footer fixed-bottom d-block p-1 bg-dark">
    <div class="container">
        <span class="text-light"><p class="text-center">Copyright &copy; DollarsBank 2021</p></span>
    </div>
</footer>

</body>
</html>
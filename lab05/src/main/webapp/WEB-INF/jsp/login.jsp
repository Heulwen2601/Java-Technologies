<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<%
    Cookie[] cookies = request.getCookies();
    Boolean loggedIn = false;
    if (session.getAttribute("userId") != null) {
        loggedIn = true;
    }
    if (!loggedIn && cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userId")) {
                loggedIn = true;
                break;
            }
        }
    }
    if (loggedIn) {
        response.sendRedirect("/Lab05_war_exploded/products");
    }
%>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6 col-lg-5">
            <h3 class="text-center text-secondary mt-5 mb-3">User Login</h3>
            <form action="Login" method="post" class="border rounded w-100 mb-5 mx-auto px-3 pt-3 bg-light">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input id="username" type="text" name="username" class="form-control" placeholder="Username">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input id="password" type="password" name="password" class="form-control" placeholder="Password">
                </div>
                <div class="form-group">
                    <button type="submit" value="Submit" class="btn btn-success px-5">Login</button>
                </div>
                <div class="form-group">
                    <input type="checkbox" id="remember_password" name="rememberPassword" value="YES">
                    <label for="remember_password"> Remember username and password</label><br>
                </div>
            </form>

        </div>
    </div>
</div>

</body>
</html>

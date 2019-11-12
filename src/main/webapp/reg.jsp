<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>$Title$</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up Form</title>
    <link rel="stylesheet" href="normalize.css">
    <link href='https://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
    <link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="lib/animate/animate.min.css" rel="stylesheet">
    <link href="lib/ionicons/css/ionicons.min.css" rel="stylesheet">
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="lib/lightbox/css/lightbox.min.css" rel="stylesheet">

    <!-- Main Stylesheet File -->
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
<header id="header">


    <div class="container">

        <div class="logo float-left">
            <!-- Uncomment below if you prefer to use an image logo -->
            <h1 class="text-light"><a href="#intro" class="scrollto"><span>Shelter</span></a></h1>
            <!-- <a href="#header" class="scrollto"><img src="img/logo.png" alt="" class="img-fluid"></a> -->
        </div>

        <nav class="main-nav float-right d-none d-lg-block">
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="index.jsp">About Us</a></li>
                <li><a href="index.jsp">Our pets</a></li>
                <li class="active"><a href="reg.jsp">Sign up</a></li>
                <li><a href="index.jsp">Sign in</a></li>
            </ul>
        </nav><!-- .main-nav -->

    </div>
</header><!-- #header -->
<form action="" method="post" style="margin-top: 150px">

    <h1>Sign Up</h1>

    <fieldset>
        <legend><span class="number"></span>Your basic info</legend>
        <label for="name">Name:</label>
        <input type="text" id="name" name="user_name" placeholder="Ivan Petrov">

        <label for="mail">Email:</label>
        <input type="email" id="mail" name="user_email" placeholder="example@example.com">
  <%--      <%
            Errors error = new Errors();
            error.isEmail(request.getParameter("user_email"));
        %>--%>


        <label for="password1">Password:</label>
        <input type="password" id="password1" name="user_password">

        <label for="password2">Password replay:</label>
        <input type="password" id="password2" name="user_password2">
<%--

        <%
            error.isCorrectPasswords(request.getParameter("user_password"),request.getParameter("user_password2"));
        %>
--%>
</fieldset>


    <button type="submit">Sign Up</button>
</form>

</body>
</html>

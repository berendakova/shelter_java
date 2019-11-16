<%@ page import="utils.Errors" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Registration</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign In Form</title>
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
                <li class="active"><a href="reg.jsp">Registr</a></li>
                <li><a href="auth">Auth</a></li>
            </ul>
        </nav>

    </div>
</header>
<form action="" method="post" style="margin-top: 150px">

    <h1>Sign In</h1>

    <fieldset>
        <label for="name">Name:</label>
        <input type="text" id="name" name="user_name" placeholder="Ivan Petrov">

        <label for="mail">Email:</label>
        <input type="email" id="mail" name="user_email" placeholder="example@example.com">
        <c:if test="${status_email != null}">
            <c:if test="${status_email.equals('true')}">
                <p>OK </p>
            </c:if>
            <c:if test="${!status_email.equals('true')}">
                <p style="color: red">NOT CORRECT EMAIL</p>
            </c:if>
        </c:if>


        <label for="password1">Password:</label>
        <input type="password" id="password1" name="user_password">

        <label for="password2">Password replay:</label>
        <input type="password" id="password2" name="user_password2">

       <c:if test="${status_password != null}">
            <c:if test="${status_password.equals('false')}">
                <p style="  color: red">${status_password}</p>
            </c:if>
        </c:if>

</fieldset>


    <button type="submit">Sign In</button>
</form>

</body>
</html>

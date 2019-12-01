<%@ page import="utils.Errors" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta charset="utf-8">
    <title>Shelter</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicons --><%--
    <link href="img/favicon.png" rel="icon">
    <link href="img/apple-touch-icon.png" rel="apple-touch-icon">--%>

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,500,600,700,700i|Montserrat:300,400,500,600,700" rel="stylesheet">

    <!-- Bootstrap CSS File -->
    <link href="../lib/bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Libraries CSS Files -->
    <link href="../lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="../lib/animate/animate.min.css" rel="stylesheet">
    <link href="../lib/ionicons/css/ionicons.min.css" rel="stylesheet">
    <link href="../lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="../lib/lightbox/css/lightbox.min.css" rel="stylesheet">

    <!-- Main Stylesheet File -->
    <link href="../css/style.css" rel="stylesheet">

</head>

<body>
<jsp:include page="header.jsp"/>

<form method="post" style="margin-top: 250px">
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="pet_name">Name</label>
            <input type="text" class="form-control" id="pet_name" name ="pet_name" placeholder="Name">
        </div>
    </div>
    <div class="form-group">
        <label for="pet_description">Description</label>
        <input type="text" class="form-control" id="pet_description" name ="pet_description" placeholder="Text about pet">
    </div>
    <div class="form-group">
        <label for="pet_breed">Breed</label>
        <input type="text" class="form-control" id="pet_breed" name="pet_breed" placeholder="Unknown breed">
    </div>
    <div class="form-group">
        <label for="pet_disease">Disease</label>
        <input type="text" class="form-control" id="pet_disease" name="pet_disease" placeholder="Disease">
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="pet_img">IMG</label>
            <input type="text" class="form-control" id="pet_img" name = "pet_img">
        </div>
        <div class="form-group col-md-4">
            <label for="sex">Sex</label>
            <select id="sex" name ="sex" class="form-control">
                <option selected>Choose...</option>
                <option>girl</option>
                <option>boy</option>
            </select>
        </div>
        <div class="form-group col-md-2">

            <label for="pet_age">Age</label>
            <input type="text" class="form-control" id="pet_age" name ="pet_age" placeholder="1">
        </div>
    </div>

    <button type="submit" class="btn btn-primary">Add pet</button>
</form>
</body>
<script src="../lib/jquery/jquery.min.js"></script>
<script src="../lib/jquery/jquery-migrate.min.js"></script>
<script src="../lib/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="../lib/easing/easing.min.js"></script>
<script src="../lib/mobile-nav/mobile-nav.js"></script>
<script src="../lib/wow/wow.min.js"></script>
<script src="../lib/waypoints/waypoints.min.js"></script>
<script src="../lib/counterup/counterup.min.js"></script>
<script src="../lib/owlcarousel/owl.carousel.min.js"></script>
<script src="../lib/isotope/isotope.pkgd.min.js"></script>
<script src="../lib/lightbox/js/lightbox.min.js"></script>
<!-- Contact Form JavaScript File -->
<script src="../contactform/contactform.js"></script>

<!-- Template Main Javascript File -->
<script src="../js/main.js"></script>

</html>

<%@ page import="utils.Errors" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
<%--    <title>Registration</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up Form</title>
    <link rel="stylesheet" href="../normalize.css">
    <link href='https://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
    <link href="../lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="../lib/animate/animate.min.css" rel="stylesheet">
    <link href="../lib/ionicons/css/ionicons.min.css" rel="stylesheet">
    <link href="../lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="../lib/lightbox/css/lightbox.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"></script>
    &lt;%&ndash;    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>&ndash;%&gt;
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>
    <!-- Main Stylesheet File -->
    <link href="../css/style.css" rel="stylesheet">
</head>--%>
<head>
    <title>Registration</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign In Form</title>
    <link rel="stylesheet" href="../normalize.css">
    <link href='https://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
    <link href="../lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="../lib/animate/animate.min.css" rel="stylesheet">
    <link href="../lib/ionicons/css/ionicons.min.css" rel="stylesheet">
    <link href="../lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="../lib/lightbox/css/lightbox.min.css" rel="stylesheet">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"></script>
<%--    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>--%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>

    <!-- Main Stylesheet File -->
    <link href="../css/style.css" rel="stylesheet">
</head>
<body>

<jsp:include page="header.jsp"/>

<form method="post"style="margin-top: 150px">
<h1>Sign In</h1>

<fieldset>
    <label for="name">Name:</label>
    <input type="text" id="name" name="user_name" placeholder="Ivan Petrov">

    <label for="mail">Email:</label>
    <input type="email" id="mail" name="user_email" placeholder="example@example.com">

    <label for="password1">Password:</label>
    <input type="password" id="password1" name="user_password">

    <label for="password2">Password replay:</label>
    <input type="password" id="password2" name="user_password2">


    <select class="selectpicker" name="listRole" multiple data-live-search="true" style="margin-bottom: 100px">
        <option name="role1" type="role1">role1</option>
        <option name="role2" type="role2">role2</option>
        <option name="role3" type="role3">role3</option>
    </select>
    <br>
    <br>

    ${existUser}
    ${password_ans}
</fieldset>


<button type="submit" id="reg">Sign In</button>
</form>

<script>
    $(document).ready(function () {

        $("#reg").click(function () {
                var user_name = $('#name').val();
                var user_email = $('#mail').val();
                var user_password = $('#password1').val();
                var user_password2 = $('#password2').val();
                alert("HELLO, " + user_name);

                $.ajax({
                    type: 'POST',
                    url: '/reg',
                    data: {
                        "user_name": user_name,
                        "user_email": user_email,
                        "user_password": user_password,
                        "user_password2": user_password2
                    },
                    success: function (result) {
                    }
                });
            }
        );
    })

</script>
</body>
</html>

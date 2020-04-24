<%@ page import="utils.Errors" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Sign Up</title>
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

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.css"/>
    <!-- Main Stylesheet File -->
    <link href="../css/style.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>
<form action="/auth" method="post" style="margin-top: 150px">

    <h1>Sign Up</h1>

    <fieldset>

        <label for="mail">Email:</label>
        <input type="email" id="mail" name="user_email" placeholder="example@example.com">



        <label for="password1">Password:</label>
        <input type="password" id="password1" name="user_password">

        <c:if test="${not empty sms}">
            <p>${sms}</p>
        </c:if>


        <p><input name="remember" type="radio" value="remember"> remember me</p>

    ${notPas};

    </fieldset>


    <button type="submit">Sign Up</button>
</form>

</body>


</html>

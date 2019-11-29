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

<section id="intro" class="clearfix">
    <div class="container d-flex h-100">
        <div class="row justify-content-center align-self-center">
            <div class="col-md-6 intro-info order-md-first order-last">
                <h2>Save <br>the animal's life<span> and it will save your life </span></h2>
                <div>
                    <a href="#about" class="btn-get-started scrollto">I want save life</a>
                </div>
            </div>

            <div class="col-md-6 intro-img order-md-last order-first">
                <img src="../img/1dog-.jpg" alt="" class="img-fluid">
            </div>
        </div>

    </div>
</section><!-- #intro -->

<main id="main">

    <!--==========================
      About Us Section
    ============================-->
    <section id="about">

        <div class="container">
            <div class="row">

                <div class="col-lg-5 col-md-6">
                    <div class="about-img">
                        <img src="../img/about-img.jpg" alt="dog">
                    </div>
                </div>

                <div class="col-lg-7 col-md-6">
                    <div class="about-content">
                        <h2>About Us</h2>
                        <h3>The best thing that happened to a man is friendship with an animal</h3>
                        <p>This site is designed to support an animal shelter, you can take a cat or dog to your home</p>
                        <p>But this is a very responsible decision, it requires patience, an immense love for animals, so we have prepared tips for you</p>
                        <ul>
                            <li><i class="ion-android-checkmark-circle"></i> Discuss this decision with loved ones</li>
                            <li><i class="ion-android-checkmark-circle"></i> Go to the shelter and get to know the animal</li>
                            <li><i class="ion-android-checkmark-circle"></i> Be prepared that the animal needs a corner in the house/li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

    </section><!-- #about -->


    <!--==========================
    Our Pets
    ============================-->
    <section id="pets" class="section-bg">
        <div class="container">

            <header class="section-header" style="margin-top: 30px">
                <h3>Our pets</h3>
                <p>Here you can see our animals, affectionate dogs, beloved cats</p>
            </header>

            <div class="row">

                <div class="col-md-3 col-lg-6 wow bounceInUp" data-wow-duration="1.4s">
                    <div class="about-img">
                    <img src="../img/oo_p13.jpg" style="width:27em; height:17em;" alt="">
                    </div>
                </div>

                <div class="col-md-3 col-lg-6 wow bounceInUp" data-wow-duration="1.4s">
                    <div class="box">
                        <h4 class="title"><a href="">Jessy</a></h4>
                        <p class="description">Jessy was born in 2012, when she was a pappy, one family took her, so she spend all time this them, but some day they left her, now she live with us.
                        Jessy is kind, she loves children.</p>
                    </div>
                </div>

                <div class="col-md-3 col-lg-6 wow bounceInUp" data-wow-delay="0.1s" data-wow-duration="1.4s" style="margin-top: 30px" >
                    <div class="box">
                        <img src="../img/oo-p2.jpg" style="width:27em; height:17em;" alt="" >
                    </div>
                </div>
                <div class="col-md-3 col-lg-6 wow bounceInUp" data-wow-delay="0.1s" data-wow-duration="1.4s" style="margin-top: 30px">
                    <div class="box">
                        <h4 class="title"><a href="">Simka</a></h4>
                        <p class="description">Meet our beauty Simka. She has a difficult fate - she was found on the street,
                            with a wounded paw, but now she is completely healthy. Simka is a kind, affectionate, tender cat. She is about 4 years old. All vaccinations are done.</p>
                    </div>
                </div>

                <div class="col-md-6 col-lg-6 wow bounceInUp" data-wow-delay="0.2s" data-wow-duration="1.4s" style="margin-top: 30px">
                    <div class="box">
                        <img src="../img/oo-p8.jpg" style="width:27em; height:17em;" alt="">
                        <br>
                        <br>
                    </div>
                </div>
                <div class="col-md-3 col-lg-6 wow bounceInUp" data-wow-delay="0.2s" data-wow-duration="1.4s" style="margin-top: 30px" >
                    <div class="box">
                        <h4 class="title"><a href="">Nemo</a></h4>
                        <p class="description">Nemo is our smallest friend. He is only 4 months old, but he is already accustomed to the tray, vaccinated and sterilized. Playful, smart and very beautiful.
                        </p>
                        <br>
                        <br>
                    </div>
                </div>
                <a href="our_pets" class="btn-get-started scrollto">Look at all</a>
            </div>

        </div>
    </section><!-- #services -->

    <!--==========================
      Why Us Section
    ============================-->
    <section id="why-us" class="wow fadeIn">
        <div class="container-fluid">

            <header class="section-header">
                <h3>How much have we done?</h3>
                <p style="size: 30px">We are proud to be able to help so many people and animals find each other.</p>
            </header>

            <div class="row">

                <div class="col-lg-6">
                    <div class="why-us-img">
                        <img src="../img/how_____.jpg" alt="" class="img-fluid">
                    </div>
                </div>

                <div class="col-lg-6">
                    <div class="why-us-content">
                        <h3>Love the animal, appreciate it, walk with it, feed it, take care of it, scratch it behind the ear, kiss it on the nose, take care of its health, do not let it freeze
                            in the autumn evening, do not let it get lost in the winter morning, but let it enjoy its short life - to smell the sea, swim in the sunset light, find out what bugs,
                            spiders are, give chat with other animals - give him life, give a chance, and then he will become your closest friend that you cannot find among people
                        </h3>

                    </div>

                </div>

            </div>

        </div>

        <div class="container">
            <div class="row counters">

                <div class="col-lg-3 col-6 text-center">
                    <span data-toggle="counter-up">274</span>
                    <p>Cured animals</p>
                </div>

                <div class="col-lg-3 col-6 text-center">
                    <span data-toggle="counter-up">421</span>
                    <p>Animals at the moment</p>
                </div>

                <div class="col-lg-3 col-6 text-center">
                    <span data-toggle="counter-up">100,364</span>
                    <p>Collected with money donations</p>
                </div>

                <div class="col-lg-3 col-6 text-center">
                    <span data-toggle="counter-up">201</span>
                    <p>Animals coming home</p>
                </div>

            </div>

        </div>
    </section>

    <!--==========================
      Call To Action Section
    ============================-->
    <section id="call-to-action" class="wow fadeInUp">
        <div class="container">
            <div class="row">
                <div class="col-lg-9 text-center text-lg-left">
                    <h3 class="cta-title">Call To Action</h3>
                    <p class="cta-text"> Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                </div>
                <div class="col-lg-3 cta-btn-container text-center">
                    <a class="cta-btn align-middle" href="#">Call To Action</a>
                </div>
            </div>

        </div>
    </section><!-- #testimonials -->




</main>




<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>
<!-- Uncomment below i you want to use a preloader -->
<!-- <div id="preloader"></div> -->

<!-- JavaScript Libraries -->
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

</body>
</html>


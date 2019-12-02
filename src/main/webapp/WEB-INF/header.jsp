<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<header id="header">


    <div class="container">

        <div class="logo float-left">
            <!-- Uncomment below if you prefer to use an image logo -->
            <h1 class="text-light"><a href="#intro" class="scrollto"><span>Shelter</span></a></h1>
            <!-- <a href="#header" class="scrollto"><img src="img/logo.png" alt="" class="img-fluid"></a> -->
        </div>

        <nav class="main-nav float-right d-none d-lg-block">
            <ul>
                <li><a href="/shelter">Home</a></li>
                <li><a href="#about">About Us</a></li>

                <%--     <%
                         out.print("<li><a>" + request.getAttribute("user_name") + "</a></li>");
                     %>
                     <p>${user_name}</p>--%>
                <c:if test="${!log || log == null}">
                    <li ><a href="reg">Registr</a></li>
                    <li><a href="auth">Auth</a></li>
                </c:if>
                <c:if test="${log}">
                    <li><a href="/our_pets">Our pets</a></li>

                    <li><a href="/profile"> Hello, ${user_name}</a></li>
                    <li><a href="/logOut">Log Out</a></li>
                </c:if>
            </ul>
        </nav>
    </div>
</header>
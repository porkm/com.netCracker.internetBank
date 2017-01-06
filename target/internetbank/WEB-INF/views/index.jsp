
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Index</title>

    <!-- Bootstrap -->
    <link  href=<c:url value="/resources/css/bootstrap.css"/> rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<jsp:include page="header.jsp"/>

<div class="container">

    <div class="starter-template">
        <h1>Проект на JAVA. Spring MVC</h1>
        <p>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam at sem viverra, mollis turpis in, commodo neque. Curabitur dapibus tristique dolor. Cras eget libero tempus, pulvinar elit eget, hendrerit est. Phasellus a aliquam nibh. Sed velit enim, finibus sit amet lorem vel, mollis finibus nisl. Integer efficitur nunc quam, vel tristique neque auctor tincidunt. Integer dapibus ultrices enim, et interdum ipsum aliquam eu. Sed pretium purus semper ipsum pulvinar, non volutpat sapien sollicitudin. Donec iaculis porttitor urna, ac ultrices velit fermentum nec. Vivamus cursus pulvinar iaculis. Nam elit ligula, scelerisque ut justo id, gravida tempus augue. Etiam sapien lectus, finibus nec ipsum in, iaculis dapibus urna. Phasellus a velit iaculis orci pulvinar mattis ac in enim.
        </p>
        <p>
            Praesent feugiat mollis suscipit. Quisque hendrerit placerat odio, interdum sollicitudin odio fermentum sed. Nullam quis posuere metus, id porta metus. Aliquam erat volutpat. Sed maximus quis ex at ultricies. Donec blandit eros nec nisi tincidunt lobortis. Lorem ipsum dolor sit amet, consectetur adipiscing elit. In imperdiet iaculis accumsan. Proin aliquam sollicitudin leo eget maximus. Sed scelerisque eleifend purus pharetra finibus. Nulla mauris sapien, ornare sit amet erat non, laoreet iaculis lorem.
        </p>
    </div>

</div><!-- /.container -->

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src=<c:url value="/resources/js/bootstrap.min.js"/>></script>
</body>
</html>
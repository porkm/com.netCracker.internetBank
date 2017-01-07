<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html lang="ru">
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






<div class="container">

    <!-- Static navbar -->
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/">Internet Bank</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/">Главная</a></li>
                    <li><a href="/actionCustomer">Клиенты</a></li>
                    <li><a href="/actionEmployed">Работники</a></li>

                </ul>

            </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
    </nav>

    <!-- Main component for a primary marketing message or call to action -->
    <div class="jumbotron">
        <h1>Lorem ipsum</h1>
        <p>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent tincidunt libero eget dui aliquet, id viverra ex tempus. Integer porta posuere feugiat. Vestibulum egestas convallis libero. Nulla vitae accumsan ex. Donec vitae ligula ut orci aliquet fringilla. Nam vitae lorem ac est sollicitudin efficitur. Donec tristique quam pharetra, lobortis nisl eget, pellentesque leo. Cras lacinia, ligula at tempus semper, ligula metus sodales diam, ut dictum nisi lectus sed eros. Sed cursus tristique orci, at placerat leo porttitor tincidunt. Nulla eget neque pellentesque, malesuada nisi nec, gravida neque. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac ligula quam. Nunc dignissim metus ut vehicula sollicitudin. Morbi pretium eleifend eros. Proin eu elit sed lacus auctor vestibulum. Donec molestie nec mauris eget pulvinar.
        </p>

    </div>

</div> <!-- /container -->


<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src=<c:url value="/resources/js/bootstrap.min.js"/>></script>
</body>
</html>
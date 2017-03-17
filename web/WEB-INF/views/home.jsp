<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 04.03.2017
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Bootstrap 101 Template</title>

    <link href="<c:url value="/resources/css/magnific-popup.css" />" rel="stylesheet">
    <!-- Bootstrap -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <script src="<c:url value="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js" />"></script>
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <script src="<c:url value="https://oss.maxcdn.com/respond/1.4.2/respond.min.js" />"></script>
    <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js" />" ></script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">MyCloud</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
                <li><a href="#">Link</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
            </ul>
            <form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Link</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<div class="container bs-cont">
    <div class="row">
        <div class="col-md-8"></div>
        <div class="col-md-4">
            <a href=#form class="fpopup"><img src="<c:url value="/resources/img/addFile.png" />"></a>
            <a href=#secondform class="fpopup"><img src="<c:url value="/resources/img/addFolder.png" />"></a>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4">.col-md-4</div>
        <div class="col-md-4" id="list">
            <c:forEach items="${folders}" var="folder">
                <!-- Исправить-->
                <a href="" class="clickers"><img src="<c:url value="/resources/img/folder.png" />">${folder.name}</a></br>
            </c:forEach>
            <c:forEach items="${files}" var="file">
                <!-- Исправить-->
                <a href="" class="fileclick"><img src="<c:url value="/resources/img/file.png" />"> ${file.name}<br></a>
            </c:forEach>
        </div>

        <div class="col-md-4">.col-md-4</div>
    </div>
</div>
<div class="hidden">
     <form action=""  id="form"  enctype="multipart/form-data">
           <div class="form-group">
           <input id="file_v" type="file" />
           <div id="message_form"></div>
           <input type="submit"  id= "firstform" value="Отправить">
               </div>
       </form>

   </div>
<div class="hidden1">
<form action=""  id="secondform" >
    <div class="form-group">
        <input id="foldername" type="text" name="foldername"/>
        <input type="submit"  id= "folderform" value="Отправить">
    </div>
</form>
    </div>
   <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

<!-- Include all compiled plugins (below), or include individual files as needed -->
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.magnific-popup.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/home.js" />" ></script>
</body>

</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 19.02.2017
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/magnific-popup.css" />" rel="stylesheet">
    <!-- Bootstrap -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <script src="<c:url value="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js" />"></script>
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <script src="<c:url value="https://oss.maxcdn.com/respond/1.4.2/respond.min.js" />"></script>
    <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js" />" ></script>
</head>
<body>
<form action="/home" method="post">
    <div class="form-group">
        <label for="exampleInputEmail1">Nickname</label>
        <input type="text" class="form-control" id="exampleInputEmail1" placeholder="nickname" name="nickname">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
</form>
<div id="listd">
    <a href="" id="click1" ><img src="<c:url value="/resources/img/folder.png" />">first folder</a></br>
</div>

<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.magnific-popup.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/js/home.js" />" ></script>

</body>
</html>

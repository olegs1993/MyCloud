<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 10.02.2017
  Time: 3:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>


  <title>Starter Template for Bootstrap</title>

</head>

<body>


${a.name}
<a href="/downloadLogFile">sfsdfsdf</a>
<form method="POST" action="uploadFile" enctype="multipart/form-data">
File to upload: <input type="file" name="file"><br />

<input type="submit" value="Upload">
Press here to upload the file!
</form>

</body>
</html>

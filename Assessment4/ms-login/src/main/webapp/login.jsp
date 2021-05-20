<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>The Login Page</h1>
	<form action="/rest/login/callservice" method="post">
		 Username :<input type="text" name="t1"><br>
        Password :<input type="password" name="t2"><br><br />

        <button type="submit">Login</button>
	</form>
</body>
</html>
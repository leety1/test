<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	welcome to my ${serverName}
	<form action="/doLogin" method="POST">
		<input type="text" name = "id">
		<input type="password" name="pw">
		<input type="submit" value ="Login">
	</form>
	<input type="submit" value ="Sign Up Page" onClick="location.href='/signUp'";>
	<input type="submit" value ="Index Page" onClick="location.href='/index'";>
</body>
</html>
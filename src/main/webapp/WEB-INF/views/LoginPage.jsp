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
	<form action="@{/user}" method="POST">
		<input type="text" name = "name">
		<input type="password" name="password">
		<input type="role" name="role">
		<input type="submit" value ="Login">
	</form>
	<input type="submit" value ="Sign Up Page" onClick="location.href='/user'";>
	<input type="submit" value ="Index Page" onClick="location.href='/index'";>
	<input type="submit" value ="Chart Page" onClick="location.href='/Chart'";>
</body>
</html>
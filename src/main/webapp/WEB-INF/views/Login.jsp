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
	<form action="/login" method="POST">
		<input type="text" name = "username">
		<input type="password" name="password">
		<input type="submit" value ="Login">
	</form>

</body>
</html>
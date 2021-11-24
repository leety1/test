<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.io.PrintWriter" %>    
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	//스타일
	table{
		
	}
	table,td,th{
		border-collapse:collapse;
		border:1px solid black;
		margin-right:auto;
		margin-left:auto;
		width:500px;
	};
	
	@media (max-width:400px)
	.header{
		display:none;
	}
</style>
<meta charset="EUC-KR">
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" initial-scale="1">
</head>
<body>
	<h1> 패션 매거진 사이트</h1>
	<div class="Fa1">
	<img class="Fashion1" src="static/picture/1.jpg" width="600" height="400">
	</div>
	<div class ="Fa2">
	<img class="Fashion2" src="static/picture/2.jpg" width="600" height="400">
	</div>
	<div class ="Fa3">
	<img class="Fashion2" src="static/picture/3.jpg" width="600" height="400">
	</div>
	<div class ="Fa4">
	<img class="Fashion2" src="static/picture/4.jpg" width="600" height="400">
	</div>
	<div class="contents">
	<table>
	<!-- <tr>
		<th>Marvel's Movie
		<input type = "text" name = "movieName">
		</th>
		 
		<th>Pubishing Year
		<input type = "text" name = "movieYear">
		</th>
	</tr> -->
	
	<!-- <tr>
		<td>Eternels</td>
		<td>1957</td>
	</tr>
	<tr>
		<td>Spiderman</td>
		<td>1955</td>
	</tr> -->
	</table>
	</div>
	<div class="btn-group">
	<tr>
	<button id="givancy" class="givancy" style="width:60; height:40;" onclick="location='index2'">Givancy</button>
	</tr>
	
	</div>
</body>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script>
$("#givancy").on({
	click:function(){
	$.ajax({
		type:"GET",
		url:"index3",
		success: function(data){
			console.log(data);
			$('.string').html(data);
		}
	})
	}
});	
</script>
</html>
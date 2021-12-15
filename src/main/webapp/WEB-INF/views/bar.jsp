<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title>Canvas</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<style>
    body{padding: 5%;text-align: center;}
    canvas{border: 1px solid gray;border-radius: 3px;}
</style>
<body>
    <canvas width='400' height='400' id='canvas'></canvas>
</body>
<script>    
	const canvas = document.getElementById('canvas');
	const ctx = canvas.getContext('2d');
	
	var width = canvas.clientWidth;
	var height = canvas.clientHeight;
	
	var position = {
	    min_x : width * 0.1,
	    max_x : width * 0.9,
	    max_y : height * 0.9,
	    min_y : height * 0.1
	}
	
	var value = 80;
	var wid = 50;
	ctx.save();
	//시작, 시작, 넓이, 높이
	
	//시작점 x는 position에서 옆으로 띄울 최소값
	//시작점 y는 최대높이값에서 비율을 곱해서 나온 값
	//사각형의 넓이는 wid 값으로 고정
	//사각형의 높이는 최대 높이에서 비율을 곱해나온 값을 빼 준 값
	ctx.strokeRect(
	  position.min_x, 
	  position.max_y* ( 1-(value/100) ), 
	  wid, 
	  position.max_y - position.max_y* ( 1-(value/100) )
	);
</script> 
</html>


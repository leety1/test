<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<style>
	body{padding: 5%;text-align: center;}
	canvas{border: 1px solid gray;border-radius: 3px}
</style>
<body>
		<canvas id="canvas" height="450" width="600"></canvas>
</body>
<script>
	const canvas = document.getElementById('canvas');
	const ctx = canvas.getContext('2d');
	
	var position=[
			{x:50,y:50,width:50,height:50}
	];
	function areaSimple(){
		ctx.beginPath();
		position.forEach((element,idx)=>{
			ctx.fillRect(element.x,element.y,element.width,element.height);
		});
	}
	areaSimple();
	
	canvas.addEventListener('click',function(event){
		console.log(event);
	});
</script>
</html>



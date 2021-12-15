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
		<canvas id="canvas" height="800" width="500"></canvas>
		<input type="submit" value ="Chart2 Page" onClick="location.href='/Chart/bar'";>
</body>
<script>
	const canvas = document.getElementById('canvas');
	const ctx = canvas.getContext('2d');
	var num = 1; //������ų ����
	setInterval(() => {
	    ctx.save();  //�ʱ���� ����
	    ctx.clearRect(0,0,460,460);    
	    ctx.translate(100, 100);  // �߾��� �̵�
	    ctx.rotate((Math.PI / 180) * num);     //ȸ��
	    ctx.fillRect(-30,-30, 60, 60); // �簢�� �׸��� (�׸��� �簢���� ���� ũ�⸸ŭ�� ���ش�.)
	    ctx.restore();
	    num++;
	    if(num >=365){
	        num = 1;
	    }
	}, 10);
	ctx.save();
	ctx.rotate((Math.PI / 180)*15);
	ctx.fillStyle = 'green';
	ctx.fillRect(200, 200, 50, 30);  
	
	ctx.translate(100,100);   //�߾����� 100,100 �̵��Ѵ�. 
	ctx.fillStyle = 'blue'; 
	ctx.fillRect(0, 0, 30, 30);
	
	/* ctx.translate(-100,-100); */
	ctx.restore();
	
	ctx.fillStyle="yellow";
	ctx.fillRect(0,0,30,30);
</script>
</html>



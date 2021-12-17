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
	var web = null;
	window.onload = function(){
		web = new WebSocket("ws://localhost:8080/websocket");
	}
</script>

<script>    
    const canvas = document.getElementById('canvas');
    const ctx = canvas.getContext('2d');
   
    var width = canvas.clientWidth;
    var height = canvas.clientHeight;

    var position = {
        min_x : width * 0.1,
        max_x : width * 0.9,
        min_y : height * 0.1,
        max_y : height * 0.9
    }
    var wid = 50;

    var value = [90, 50, 60];
    function drawing(){
        var virtualVal = value.slice().map((arg)=>1); 
        var adder = 0;
        var interval = setInterval(() => {
            ctx.clearRect(0, 0, width, height);  //추가
            virtualVal.forEach( (data, idx) => {
                if(value[idx] > data){
                    var devide = idx / value.length ;
                    data++;
                    virtualVal[idx] = data;
                    ctx.strokeRect(position.min_x + position.max_x*devide, position.max_y* ( 1-(data/100) ), wid, position.max_y - position.max_y* ( 1-(data/100) ));
                } else {  //추가
                    var devide = idx / value.length ;
                    ctx.strokeRect(position.min_x + position.max_x*devide, position.max_y* ( 1-(data/100) ), wid, position.max_y - position.max_y* ( 1-(data/100) ));                
                }
            });  
            var chekcer = virtualVal.slice().map((arg)=>false);
            virtualVal.forEach( (data1, idx1) => {
                value.forEach( (data2, idx2) => {
                    if(data1 >= data2 && idx1 == idx2){
                        chekcer[idx1] = true;
                    }
                });
            }); 
            var breaker = true;
            chekcer.forEach( arg => {
                if(!arg){
                    breaker = false;
                }
            });     
            if(breaker){
                console.log(virtualVal);
                console.log('fin');
                clearInterval(interval);
                makeText()
            }
        }, 10);        
    }

    drawing();

    function makeText(){
        value.forEach((data, idx) =>{
            var devide = idx / value.length;
            var len = (wid/2) - ctx.measureText(data+'').width / 2;
            ctx.strokeText(data, position.min_x + position.max_x*devide + len, position.max_y + position.min_y/2);
        });        
    }
    
    function hoverDrawing(hoverIdx){
        ctx.clearRect(0,0,width, height);  //초기화
        value.forEach( (data, idx) => {
            ctx.save();  //정보저장
            if(idx == hoverIdx){   //대상인 경우
                ctx.strokeStyle = 'red';
            }
            var devide = idx / value.length;
            ctx.strokeRect(position.min_x + position.max_x*devide, position.max_y* ( 1-(data/100) ), wid, position.max_y - position.max_y* ( 1-(data/100) ));
            ctx.restore();
        });      
        makeText();  //텍스트 그리기
    }

    var drawed = false;
    canvas.addEventListener('mousemove', function (event) {
        var x1 = event.clientX - canvas.offsetLeft;
        var y1 = event.clientY - canvas.offsetTop;        
        var inn = isInsideRect(x1, y1);
        //console.log(inn);
        if (inn.result) {
            drawed = true;
            hoverDrawing(inn.index);
        } else {
            if(drawed) hoverDrawing(-1);
        }
    }); 

    function isInsideRect(x1, y1){
        var result = false;
        var index = -1;
        for(var i=0; i < value.length;i++){
            var data = value[i];
            var devide = i / value.length ;
            var start_x = position.min_x + position.max_x*devide;
            var end_x = start_x + wid;
            var start_y = position.max_y* ( 1-(data/100) );
            var end_y = position.max_y; 
            if(x1 >= start_x && x1 <= end_x){  
                if(y1 >= start_y && y1 <= end_y){
                    result = true;
                    index = i;    
                    break;
                }
            } 
        }
        return {result:result, index:index};
    }

    
</script>
</html>


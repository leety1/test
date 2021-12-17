<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv=“Content-Type” content=“text/html; charset=UTF-8”>
<title>웹소켓 테스트 페이지</title>

</head>
<body>
    <input id=“inputMsgBox” style=“width: 250px;” type=“text” onkeypress=“inputMsgBox_onkeypress()”>
    <input id=“sendButton” value=“Send” type=“button” onclick=“sendButton_onclick()”>
    <input id=“disconnectButton” value=“Disconnect” type=“button” onclick=“disconnectButton_onclick()”>
    <br/>
    <textarea id=“chatBoxArea” style=“width: 100%;” rows=“10” cols=“50” readonly=“readonly”></textarea>
</body>
<script>
	var web = null;
	window.onload = function(){
		web = new WebSocket("ws://localhost:8080/websocket");
	}
	function send(message) {
		web.send(JSON.stringify(message));
	}
	
	configuration = null;
	var peerConnection = new RTCPeerConnection(configuration);
	var dataChannel = peerConnection.createDataChannel("dataChannel", { reliable: true });
	
	dataChannel.onerror = function(error) {
	    console.log("Error:", error);
	};
	dataChannel.onclose = function() {
	    console.log("Data channel is closed");
	};
	
</script>

</html>
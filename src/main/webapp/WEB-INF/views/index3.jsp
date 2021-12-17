<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/extras/spring-security">

<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script>
var conn = new WebSocket('ws://localhost:8080/socket');
conn.onopen = function(){
	console.log("Success");
};

function send(message) {
    conn.send(JSON.stringify(message));
    var s = conn +"잘 됌";
    conn.send(s);
    console.log(s);
}
console.log(conn);
configuration = null;
var peerConnection = new RTCPeerConnection(configuration);
var dataChannel = peerConnection.createDataChannel("dataChannel", { reliable: true });
dataChannel.onerror = function(error) {
    console.log("Error:", error);
};
dataChannel.onclose = function() {
    console.log("Data channel is closed");
};
peerConnection.createOffer(function(offer) {
    send({
        event : "offer",
        data : offer
    });
    peerConnection.setLocalDescription(offer);
}, function(error) {
    // Handle error here
});

</script>
</html>
	




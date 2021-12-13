<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/extras/spring-security">

<th:block th:replace="~{/layout/basic :: setContent(~{this :: content})}">
    <th:block th:fragment="content">
    
        <div class="container">
            <div class="col-6">
                <label><b>채팅방</b></label>
            </div>
            <div>
                <div id="msgArea" class="col"></div>
                <div class="col-6">
                    <div class="input-group mb-3">
                        <input type="text" id="msg" class="form-control" aria-label="Recipient's username" aria-describedby="button-addon2">
                        <div class="input-group-append">
                            <button class="btn btn-outline-secondary" type="button" id="button-send">전송</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
    </th:block>
</th:block>

</html>
	
</body>
<script>
var conn = new WebSocket('ws://localhost:8080/socket');
conn.onopen = function(){
	console.log("Success");
};

function onOpen(evt) {
    var str = conn + ": 님이 입장하셨습니다.";
    conn.send(str);
}

function send(message) {
    conn.send(JSON.stringify(message));
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>
<style>
body {
	background: #e9e9e9;
	color: #9a9a9a;
	margin: 0;
}

.chat-background {
	background-color: white;
	width: 450px;
	height: 575px;
	bottom: 0;
	position: fixed;
	right: 24px;
}

#live-chat {
	bottom: 0;
	font-size: 20px;
	right: 24px;
	position: fixed;
	width: 450px;
}

#sendBtn {
	width: 45px;
	height: 45px;
	background-image: url('img/send2.png');
	background-size: cover;
	border-radius: 5px;
}

.chat-message {
	margin: 16px 0;
}

.chat-message img {
	border-radius: 50%;
	float: left;
}

.chat-message-content {
	
}

.chat-top {
	background-color: black;
	width: 450px;
	height: 100px;
	right: 24px;
	position: fixed;
	color: white;
	padding-top: 10px;
	top: 450px;
}

.green {
	background: #1a8a34;
	border-radius: 50%;
	content: "";
	display: inline-block;
	height: 8px;
	margin: 0 8px 0 0;
	width: 8px;
}

#messageArea {
	text-align: left;
}
</style>
</head>
<body>
	<div class="chat-top">
		<div class="green"></div>
		관리자
	</div>
	<div class="chat-background">

		<div id="live-chat">
			<div id="messageArea"></div>
			<input type="text" id="message"
				style="font-size: 20px; margin-bottom: 10px; padding-top: 10px;" />
			<input type="button" id="sendBtn" value="" />
		</div>
	</div>
</body>
<script type="text/javascript">
	$("#sendBtn").click(function() {
		sendMessage();
		$('#message').val('')
	});

	let sock = new SockJS("http://localhost:81/iot/echo/");
	sock.onmessage = onMessage;
	sock.onclose = onClose;
	// 메시지 전송
	function sendMessage() {
		sock.send($("#message").val());
	}
	// 서버로부터 메시지를 받았을 때
	function onMessage(msg) {
		
		var data = msg.data;
		str="<div class='chat-message'>";
		str+="<img src='img/main-logo.png' alt='' width='32' height='32' style='margin-left:20px;'>"
		str+="<div class='chat-message-content'>"
		str+="&nbsp;${username}  : &emsp;"+data
		str+="</div>"
		str+="</div>"
		$("#messageArea").append(str + "<br/>");
			
		
	}
	
/*     str = "<div class='col-6'>";
    str += "<div class='alert alert-secondary'>";
    str += "<b>" + writer + " : " + message + "</b>";
    str += "</div></div>";
    $("#msgArea").append(str); */
	// 서버와 연결을 끊었을 때
	function onClose(evt) {
		$("#messageArea").append("연결 끊김");

	}
</script>
</html>
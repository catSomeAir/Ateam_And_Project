<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/css/common.css" >
<link rel="stylesheet" href="resources/css/cs_list.css" >

<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.cs-wrap{
	width: 100%;
	display: flex;
	justify-content: center;
}

.cs-wrap-ul{
	width: 75%;
	display: flex;
	justify-content: space-between;
}

.cs-wrap-ul li{
	width: 30%;
	border-radius: 10px;
	height: 200px;
}

#qna_wrap-h{
	display: flex;
	justify-content: flex-start;
	width: 80%;
	text-align: left;
	height: 166px;
	margin: 0 10px;
	border: 3px solid #e8e8e8;
	border-radius: 20px;
}

.cs-li{
	display: inline-block;
    width: 25%;
    margin-top: 30px;
    vertical-align: top
}

.cs-wrap-ul li a{
	font-size: 22px;
	font-weight: bold;
}

.cs-btn{
	-webkit-appearance: none;
    border: 0;
    background: none;
    cursor: pointer;
    -webkit-tap-highlight-color: rgba(0,0,0,0);
    -webkit-tap-highlight-color: transparent;
    color: inherit;
    display: block;
    width: 100%;
    padding: 22px 21px;
    text-align: center;
    height: 160px;
    
}

.cs-spandiv{
	display: flex;
	height: 160px;
	justify-content: flex-start;
	flex-direction: column;
	font-size: 22px;
	font-weight: bold;
}

</style>

</head>
<body>
<h2>고객센터</h2>




<div class="cs-wrap">
	<ul class="cs-wrap-ul">	
		<li class="cs-li">
		
			<div id="qna_wrap-h">
				<button class="cs-btn" type="button" onclick='location="helplist.cs"'>
					<div class="cs-spandiv">
						<span class="cs-span">자주 묻는 도움말</span>
						<span style="margin-top: 15%; font-size: 15px; font-weight: normal;" class="cs-span">도움말 더보기</span>
					</div>	
				</button>
			</div>
		</li>
		<li class="cs-li">
		
			<div id="qna_wrap-h">
				<button class="cs-btn" type="button" onclick='location="list_web.ch"'>
					<div class="cs-spandiv">
						<span class="cs-span">채팅 서비스</span>
						<span style="margin-top: 15%; font-size: 15px; font-weight: normal;" class="cs-span">채팅 시작</span>
					</div>	
				</button>
			</div>
		</li>		<li class="cs-li">
		
			<div id="qna_wrap-h">
				<button class="cs-btn" type="button" onclick='location="list_web.qa"'>
					<div class="cs-spandiv">
						<span class="cs-span">1:1 문의</span>
						<span style="margin-top: 15%; font-size: 15px; font-weight: normal;" class="cs-span">문의하기</span>
					</div>	
				</button>
			</div>
		</li>
	</ul>
</div>


</body>
</html>
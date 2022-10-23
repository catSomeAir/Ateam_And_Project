<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<style>
	/* reset */
	html,body{width:100%;height:100%}
	body,p,h1,h2,h3,h4,h5,h6,ul,ol,li,dl,dt,dd,table,th,td,form,fieldset,legend,input,textarea,button,select{margin:0;padding:0}
	body,input,textarea,select,button,table{font-family:'Malgun Gothic',Dotum,AppleGothic,sans-serif;font-size:12px}
	img,fieldset{border:0}
	img{vertical-align: top}
	ul,ol{list-style:none}
	em,address{font-style:normal}
	a{text-decoration:none}
	a:hover,a:active,a:focus{text-decoration:underline}	

	/* style */
	.lst_type {
		width: 400px;
		border: 1px solid #888;
		margin: 10px auto;
		padding: 5px;
		*zoom: 1;
	}
	.lst_type:after {
		content: '';
		display: block;
		clear: both;
	}
	.lst_type li {
		float: left;
		width: 90px;
		margin: 5px;
	}
	.lst_type li a {
		display: block;
		color: #fff;
	}
	.lst_type li a .thumb {
		display: block;
	}
	.lst_type li a em {
		display: block;
		padding: 5px 0;
		background-color: #888;
		font-size: 11px;
		letter-spacing: -1px;
		line-height: 1.5;
	}

	</style>
<style type="text/css">
*{
	margin:0 auto;
	padding: 0;
}
li{
	list-style: none;
}
.clear{
	clear: both;
}
.box{
	margin: 30px;
	padding : 35px;
	box-sizing: content-box;
}
.box:hover{
	cursor: pointer;
}

.a{
color: #123456;
}
</style>
</head>
<body>
	<h3>이벤트</h3>



<section id="content_box" style="display: flex; align-content: center; ">
<div onclick="location.href='/pj_web/detail_web.ev'" class="box" >
	<h3>첫 제품등록 이벤트</h3>
	<p>포인트 적립과 다양한 선물까지!</p>
	<div class="clear"></div>

	<ul class="items">
		<li><img style="width:300px; " src="img/main_tab_home_new_banner1.png"></li>
		<li class="a"></br>(2022.10.27~2022.11.02)</li>
	</ul>
</div>
<div class="clear"></div>

<div class="box" >
	<h3>나의 설명서를 부탁해</h3>
	<p>설명서 요청시 포인트적립 2배</p>
	<div class="clear"></div>

	<ul class="items">
		<li><img style="width:300px; " src="img/main_tab_home_new_banner2.png"></li>
		<li class="a"></br>(2022.10.27~2022.11.02)</li>

	</ul>
</div>
<div class="clear"></div>

<div class="box">
	<h3>11월 빅이벤트</h3>
	<p>최다 도움을 주신 분들을 추천!</p>
	<div class="clear"></div>

	<ul class="items">
		<li><img style="width:300px; " src="img/main_tab_home_new_banner3.png"></li>
		<li class="a"></br>(2022.10.27~2022.11.02)</li>

	</ul>
</div>
<div class="clear"></div>
<div class="box">
	<h3>나의 설명서 공유이벤트</h3>
	<p>인증샷을 남기시면 추첨을 통한 포인트와 기프티콘이!</p>
	<div class="clear"></div>

	<ul class="items">
		<li><img style="width:300px; " src="img/main_tab_home_new_banner4.png"></li>
		<li class="a"></br>(2022.10.27~2022.11.02)</li>

	</ul>
</div>
<div class="clear"></div>
</section>




</body>

<script type="text/javascript">


</script>

</html>
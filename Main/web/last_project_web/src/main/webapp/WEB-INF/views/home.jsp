<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<link rel="stylesheet" href="css/home.css">
<script
	src='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/js/all.min.js'></script>
<title>나의 설명서</title>
</head>
<body>
<div class="first_page">
	<header>
		<div class="login_btn">로그인</div>
		<img class="img_custom" alt="카테고리 버튼" src="resources/images/btn.png">
	</header>

	<section class="center">
		<div id="backgroundImage" class="wrapper">
			<div class="font_h1 line_height">나의 설명서</div>
			<div class="font_h3 line_height">세상의 모든 설명서를 내 손안에</div>
			<div id="inputWrapper">
				<div class="fa-search">
					<i class="fas fa-search"></i>
				</div>
				<input id="input" type="search" autocomplete="off"
					spellcheck="false" role="combobox"
					placeholder=" 제품명,모델명,브랜드 등을 입력해주세요">
			</div>
		</div>
	</section>
	</div>
	<div class="next_page">
	<span>로그인</span> <span>회원가입</span><img class="img_custom" alt="카테고리 버튼" src="resources/images/btn.png">
	</div>
	<script type="text/javascript">
		window.onload = function(){
			var navHeight = document.getElementByI
			console.log(navHeight);
		}
	</script>
</body>
</html>

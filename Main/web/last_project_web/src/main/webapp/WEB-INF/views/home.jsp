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
<section class="first_page" id="firstP">
	<header>
		<div class="login_btn">로그인</div>   
		<img class="img_custom" alt="카테고리 버튼" src="resources/images/btn.png">
	</header>

	<div class="center">
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
	</div>
	</section>
	<section id="secondP">
	<div class="next_page">
	<div class="header">
	<span class="login_next_page">로그인</span> <span class="join_next_page">회원가입</span><img class ="cate_img_next_page" alt="카테고리 버튼" src="resources/images/btn.png">
	</div> 
	<!-- 여기는 검색창 조그만하게 나오는 그 부분 -->
	<div class="searchbar_background">
		<div id="backgroundImage" class="wrapper">
			<div class="">나의 설명서</div>
			<div class=" line_height">세상의 모든 설명서를 내 손안에</div>
			<div id="inputWrapper">
				<div class="fa-search">
					<i class="fas fa-search"></i>
				</div>
				<input id="input" type="search" autocomplete="off"
					spellcheck="false" role="combobox"
					placeholder=" 제품명,모델명,브랜드 등을 입력해주세요">
			</div>
		</div>
	</div>
	<!-- 검색 결과 보여주는 부분 -->
	<div>
	</div> 
	</div>
	</section>
	<script type="text/javascript">
	/* 스크롤 했을 때는 원래 화면이 안보이고 새로운 화면이 보이도록 display none과 display block 이용 */
		/* document.getElementById("firstP").style.display="none"; */
	</script>
</body>
</html>

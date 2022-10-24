<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>   
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>Bootstrap 4</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<style>
p {
	margin: 20px 0px;
}

.search {
	width: 150px;
	height: 60px;
	line-height: 60px;
	margin-right: 20px;
	color: white;
	background-color: #020E20;
	text-align: center;
}

.navbar {
	height: 60px;
	padding-left: 30px;
	padding-right: 30px;
}

.hero-header {
	height: 450px;
	background-image:
		url("https://bakey-api.codeit.kr/files/629/images/hero_header.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	background-position: center center;
}

.navbar #logo {
	line-height: 60px;
}

.navbar img {
	vertical-align: top;
	border: blanchedalmond 5px solid;
}

.navbar #menu {
	float: right;
	list-style-type: none;
	padding: 0;
	margin: 0;
}

.navbar #menu li {
	float: left;
	margin-left: 50px;
	line-height: 60px;
}

.navbar #menu li a {
	color: #545454;
	font-size: 13px;
	text-decoration: none;
}

.product-list {
	width: 735px;
	margin-left: auto;
	margin-right: auto;
}

.products h3 {
	font-size: 24px;
	color: #545454;
	margin-top: 60px;
	margin-bottom: 60px;
	text-align: center;
}

.product {
	display: block;
	width: 225px;
	text-align: center;
	text-decoration: none;
	color: black;
	float: left;
	margin-left: 10px;
	margin-right: 10px;
	margin-bottom: 30px;
}

.product-name {
	margin-top: 20px;
	margin-bottom: 4px;
}

.clearfix {
	clear: both;
}

.footer {
	text-align: center;
	margin-top: 40px;
	margin-bottom: 40px;
}

.footer a {
	margin-left: 10px;
	margin-right: 10px;
	text-decoration: none;
}
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	<br />
	<div
		style="font-family: 'Noto Sans KR', sans-serif; font-size: 22px; text-align: center; margin-bottom: 30px;">내가
		다운로드한 설명서</div>
	<br />
	<br />
	<section>
		<div style="display: flex; padding-left: 490px; margin-bottom: 50px;">
			<div class="search">제품명</div>
			<div class="search">모델코드</div>
			<div class="search">브랜드</div>
		</div>

		<div class="products">
			<div class="product-list">
			<c:forEach items="${downvo}" var='downvo'>
			<a href="#" class="product">
				 <img src="${downvo.filepath_1.replace('localhost','121.147.215.12:3302').replace('192.168.0.23','121.147.215.12:3302')}"
					width="225" height="225px">
					<div class="product-name">${downvo.model_name}</div>
					<div class="product-price">${downvo.model_code}</div>
				</a> 
			</c:forEach>
				<a href="#" class="product"> <img src="img/temp_model_img.jpg"
					width="225" height="225px">
					<div class="product-name">삼성 비스포크 냉장고</div>
					<div class="product-price">모델코드</div>
				</a> 
				<a href="#" class="product"> <img
					src="img/temp_model_img2.jpg.png" width="225" height="225px">
					<div class="product-name">삼성 양문형 냉장고</div>
					<div class="product-price">모델코드</div>
				</a> 
				<div class="clearfix"></div>
			</div>
	</section>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>
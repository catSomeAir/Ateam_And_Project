<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/def66b134a.js"
	crossorigin="anonymous"></script>
<style>
.box {
	width: 100px;
	height: 100px;
	border-radius: 70%;
	overflow: hidden;
	padding: 0;
}

.profile {
	width: 100%;
	height: 100%;
	object-fit: cover;
}
/* main color:: 020E20 */
</style>
</head>
<!-- 
<link rel="stylesheet" type="text/css" href="https://storage.clickn.co.kr//css/modules/module_builderProductA.css?v=20221005" />상품 디스플레이
<link rel="stylesheet" type="text/css" href="https://storage.clickn.co.kr//css/modules/module_builderProductB.css?v=20221005" />상품 문의
<link rel="stylesheet" type="text/css" href="https://storage.clickn.co.kr//css/modules/module_builderProductC.css?v=20221005" />상품 후기

<link href="https://fonts.googleapis.com/css2?family=Black+And+White+Picture&family=Black+Han+Sans&family=Cute+Font&family=Do+Hyeon&family=Dokdo&family=East+Sea+Dokdo&family=Gaegu:wght@400;700&family=Gamja+Flower&family=Gugi&family=Hi+Melody&family=Jua&family=Kirang+Haerang&family=Nanum+Brush+Script&family=Nanum+Gothic:wght@400;700&family=Nanum+Myeongjo:wght@400;700&family=Nanum+Pen+Script&family=Poor+Story&family=Single+Day&family=Song+Myung&family=Stylish&family=Sunflower:wght@300;700&family=Yeon+Sung&display=swap" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css2?family=Amatic+SC:wght@400;700&family=Archivo:wght@400;700&family=Exo:wght@200;400;700&family=Fauna+One&family=Fjalla+One&family=Graduate&family=Iceland&family=Inconsolata:wght@300;500;700&family=Italianno&family=Josefin+Sans:wght@200;400;700&family=Lato:wght@100;300;400;700&family=Libre+Baskerville:wght@400;700&family=Montserrat:wght@200;300;400;500;600;700&family=Nixie+One&family=Nunito:wght@200;400;700&family=Oswald:wght@200;400;500;700&family=Playfair+Display:wght@400;500;700&family=Poppins:wght@200;400;700&family=Raleway:wght@200;400;700&family=Roboto:wght@100;300;400;500;700&family=Simonetta:wght@400;900&family=Space+Mono:wght@400;700&family=Special+Elite&family=Stardos+Stencil:wght@400;700&family=Titan+One&family=Titillium+Web:wght@200;400;700&family=Trocchi&family=Ultra&family=Wellfleet&family=Abril+Fatface&family=Bodoni+Moda:wght@400;600;800&family=DM+Serif+Display&family=DM+Serif+Text&family=EB+Garamond:wght@400;500&family=Open+Sans:wght@300;400;700&family=Petit+Formal+Script&family=Quicksand:wght@300;700&family=Cinzel&family=Lobster&family=MonteCarlo&family=Shrikhand&display=swap" rel="stylesheet" /> -->
<link rel="stylesheet" type="text/css"
	href="https://storage.clickn.co.kr//css/modules/special_common.css?v=20221005">
<link rel="stylesheet" type="text/css"
	href="https://storage.clickn.co.kr//css/modules/module_mypage.css?v=20221005">

<body>

	<div class="skin_layout_container skin_layout_container2">
		<div class="front_main_area">
			<div id="skinMainWrap" class="skin_main_wrap">
				<div class="skin_main_container skin_main_container1">
					<div id="skinMainSection" class="skin_main_section">
						<div class="skin_block" data-module-id="module-mypage"
							data-module-type="special" data-is-empty="no"
							data-starting-normalblock="no">
							<div class='special_module' data-module-name="mypage_001"
								data-module-parents="mypage_001" data-content-type1="mypage"
								data-content-type2="mypage-type-A" data-background-color=''
								data-background-image='' data-background-image-options=''
								data-background-attachment='' data-background-filter=''>
								<div class='module_wrap' data-layout-fullsize='no'>
									<div class='module_container' data-padding-top='60'
										data-padding-bottom='60'>
										<div class="mypage"
											style="margin-left: 400px; margin-right: 400px;">
											<!-- 타이틀 -->
											<div>
												<p>
													<span
														style="font-size: 30px; color: #000; font-weight: 500; text-align: left">마이페이지</span>
												</p>
												<br /> <br /> <br />
											</div>
											<div
												style="display: inline; position: absolute; left: 100px;">
												<h3 style="font-size: 24px;">바로가기</h3>
												<ul
													style="background-color: none; width: 150px; list-style-type: none; margin: 0; padding: 0;">
													<li><a
														style="display: block; color: #000000; padding: 8px; text-align: center; text-decoration: none; font-weight: bold; font-size: 16px;">최근
															본 설명서</a></li>
													<li><a
														style="display: block; color: #000000; padding: 8px; text-align: center; text-decoration: none; font-weight: bold; font-size: 16px;">제품
															검색하기</a></li>
													<li><a
														style="display: block; color: #000000; padding: 8px; text-align: center; text-decoration: none; font-weight: bold; font-size: 16px;">
															공지사항 보기</a></li>
															
												</ul>
											</div>
											<div class="sub_content">
												<div></div>
												<div class="mypage_content">
													<div id="mypageMainContents" class="mypage main">
														<div class="sub_content">

															<!-- 모듈 별 html 시작 -->
															<!-- 주문 내역 -->
															<div class="content_header">
																<p class="content_title">
																	<span style="font-size: 22px;">내 프로필</span>
																</p>
																<div onclick="location='edit'">
																	<span
																		style="font-size: 15px; margin-bottom: 1px; color: gray;"
																		class="pointer">수정하기 &nbsp;</span> <i
																		class="fa-solid fa-chevron-right" style="color: gray;"></i>
																</div>
															</div>
															<div
																style="text-align: left; position: absolute; left: 50px;">
																<div style="display: flex;">

																	<div class="box"
																		style="background: #BDBDBD; position: relative; top: 10px; left: 930px;">
																		<img class="profile" src="img/profile.png">
																	</div>
																</div>
															</div>
															<br /> <br /> <br /> <br /> <br /> <br /> <br />
															<div class="content_wrap">
																<br />
																<div style="text-align: left;">
																	<span style="text-align: left; font-size: 20px;">이름</span>
																	<strong class="count" style="margin-left: 530px;">김한울</strong>
																</div>
																<br />
																<div style="text-align: left;">
																	<span style="text-align: left; font-size: 20px;">전화번호</span>
																	<strong class="count" style="margin-left: 460px;">010-0000-0000</strong>
																</div>
																<br />
																<div style="text-align: left;">
																	<span style="text-align: left; font-size: 20px;">이메일</span>
																	<strong class="count" style="margin-left: 470px;">abc@gmail.com</strong>
																</div>
															</div>
														</div>
														<!-- 포인트 -->
														<div class="content_header">
															<p class="content_title">
																<span style="font-size: 22px;">포인트</span>
															</p>
														</div>
														<div class="content_wrap">
															<br />
															<div style="display: flex;">
																<div style="text-align: left; font-size: 20px;">포인트
																</div>
																<strong style="margin-left: 500px; font-size: 20px;">300
																	P</strong>
															</div>
															<br />
															<div style="text-align: left;"
																onclick='location="point_list"'>
																<span style="text-align: left; font-size: 20px;"
																	class="pointer">포인트 사용내역</span> <i
																	class="fa-solid fa-chevron-right"
																	style="margin-left: 8px;"></i>
															</div>
															<br />
															<div style="text-align: left;"
																onclick='location="gifticon_list"'>
																<span style="text-align: left; font-size: 20px;"
																	class="pointer">기프티콘 사용내역</span> <i
																	class="fa-solid fa-chevron-right"
																	style="margin-left: 8px;"></i>
															</div>
															<br />

														</div>

														<!-- 내활동 -->
														<div class="content_header">
															<p class="content_title">
																<span style="font-size: 22px;">내 활동</span>
															</p>
														</div>
														<div class="content_wrap">
															<br />
															<div style="text-align: left;"
																onclick='location="bookmarked_list"'>
																<span style="text-align: left; font-size: 20px;"
																	class="pointer">내가 찜한 설명서</span> <i
																	class="fa-solid fa-chevron-right"
																	style="margin-left: 8px;"></i>
															</div>
															<br />
															<div style="text-align: left;"
																onclick='location="downloaded"'>
																<span style="text-align: left; font-size: 20px;"
																	class="pointer">다운로드한 설명서</span> <i
																	class="fa-solid fa-chevron-right"
																	style="margin-left: 8px;"></i>
															</div>
															<br />
															<div style="text-align: left;"
																onclick='location="mypost_list"'>
																<span style="font-size: 20px;" class="pointer">내가
																	쓴 의견</span> <i class="fa-solid fa-chevron-right"
																	style="margin-left: 8px;"></i>
															</div>
															<br />
															<div style="text-align: left;"
																onclick='location="myreply_list"'>
																<span style="font-size: 20px;" class="pointer">내가
																	쓴 답글</span> <i class="fa-solid fa-chevron-right"
																	style="margin-left: 8px;"></i>
															</div>
														</div>

														<br />
														<!-- 최근 주문 임시 행 -->
														<ul id="tmp-recently-order-row" class="tbody"
															style="display: none">
															<li class="item_date"></li>
															<li class="item_order"><a href="#none" class="prod">
																	<span class="thumb"><img
																		src="/images/products/noimage3.png" alt=""></span> <strong
																	class="tit"></strong>
															</a></li>
															<li class="item_order_no"></li>
															<li class="item_price txt_point_resp800"><strong
																class="no"></strong>원</li>
														</ul>


														<ul class="Hide dummyTbodyLayer">
															<li class="item_state"><span class=""></span></li>
															<li class="item_subject"><a href="#none"> <span
																	class="product_name"></span> <span></span>
															</a></li>
															<li class="item_date"></li>
														</ul>

														<div class="content_header">
															<p class="content_title">
																<span style="font-size: 22px;">1:1 문의</span>
															</p>
															<a href="/boards/mypage/qna" class="page_link"><span
																style="font-size: 14px;">전체보기</span></a>
														</div>
														<div class="content_wrap" id="mypage-qna-container">
															<form id="form-mypage-qna" onsubmit="return false">
															</form>
															<div class="list_board">
																<div class="no_item" style="display: none">작성한
																	문의글이 없습니다.</div>

																<ul class="thead" style="display: none">
																	<li class="item_state" style="width: 140px;">답변유무</li>
																	<li class="item_subject">제목</li>
																	<li class="item_date" style="width: 180px;">작성일자</li>
																</ul>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
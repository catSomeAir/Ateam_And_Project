<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="https://designskin36.clickn.co.kr/css/lib.css?v=20221005" />
<link rel="stylesheet" type="text/css" href="https://designskin36.clickn.co.kr/vendors/Slick/slick.css" />
<link rel="stylesheet" type="text/css" href="https://designskin36.clickn.co.kr/vendors/Swiper/swiper.min.css" />Swiper js
<link rel="stylesheet" type="text/css" href="https://designskin36.clickn.co.kr/vendors/Fontawesome/css/froala.css">Froala 에 Font Awesome 서비스하기 위함
<link rel="stylesheet" type="text/css" href="https://designskin36.clickn.co.kr/vendors/Fontawesome/css/all.min.css">Font Awesome
<link rel="stylesheet" type="text/css" href="https://designskin36.clickn.co.kr/vendors/Froala/css/froala_editor.pkgd.css" />Froala
<link rel="stylesheet" type="text/css" href="https://designskin36.clickn.co.kr/vendors/Datepicker/css/datepicker.css" />datapicker
<link rel="stylesheet" type="text/css" href="https://designskin36.clickn.co.kr/vendors/Dropzone/css/dropzone.min.css" />Dropzone
<link rel="stylesheet" type="text/css" href="https://designskin36.clickn.co.kr/css/animation.css?v=20221005" />
<link rel="stylesheet" type="text/css" href="https://designskin36.clickn.co.kr/css/skin_common.css?v=20221005" />

<link rel="stylesheet" type="text/css" href="https://storage.clickn.co.kr//css/modules/module_common.css?v=20221005" />
<link rel="stylesheet" type="text/css" href="https://storage.clickn.co.kr//css/modules/module_header.css?v=20221005" />
<link rel="stylesheet" type="text/css" href="https://storage.clickn.co.kr//css/modules/module_board.css?v=20221005" />
<link rel="stylesheet" type="text/css" href="https://storage.clickn.co.kr//css/modules/module_boardRecent.css?v=20221005" />
<link rel="stylesheet" type="text/css" href="https://storage.clickn.co.kr//css/modules/module_contents.css?v=20221005" />
<link rel="stylesheet" type="text/css" href="https://storage.clickn.co.kr//css/modules/module_form.css?v=20221005" />
<link rel="stylesheet" type="text/css" href="https://storage.clickn.co.kr//css/modules/module_image.css?v=20221005" />
<link rel="stylesheet" type="text/css" href="https://storage.clickn.co.kr//css/modules/module_layout.css?v=20221005" />
<link rel="stylesheet" type="text/css" href="https://storage.clickn.co.kr//css/modules/module_line.css?v=20221005" />
<link rel="stylesheet" type="text/css" href="https://storage.clickn.co.kr//css/modules/module_map.css?v=20221005" />
<link rel="stylesheet" type="text/css" href="https://storage.clickn.co.kr//css/modules/module_slide.css?v=20221005" />
<link rel="stylesheet" type="text/css" href="https://storage.clickn.co.kr//css/modules/module_text.css?v=20221005" />
<link rel="stylesheet" type="text/css" href="https://storage.clickn.co.kr//css/modules/module_video.css?v=20221005" />
<link rel="stylesheet" type="text/css" href="https://storage.clickn.co.kr//css/modules/module_gallery.css?v=20221005" />
<link rel="stylesheet" type="text/css" href="https://storage.clickn.co.kr//css/modules/module_table.css?v=20221005" />
<link rel="stylesheet" type="text/css" href="https://storage.clickn.co.kr//css/modules/module_footer.css?v=20221005" />
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
					<!-- ===================== Skin Main ===================== -->
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
										<div class="mypage" style="margin-left: 100px; margin-right: 50px;">
											<!-- 타이틀 -->
											<div class="title wow">
												<p>
													<span
														style="font-size: 30px; color: #000; font-weight: 500;">마이페이지</span>
												</p>
												<br/>
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
																
																	
																	<span style="font-size: 14px;" onclick="location='edit'">수정하기 </span>
															</div>
															<div class="content_wrap">
																<br/>
																<div style="text-align: left; font-size: 20px;">이름</div>
																<strong class="count">몰라</strong>

																<div style="text-align: left; font-size: 20px;">전화번호</div>
																<strong class="count">010-0000-0000</strong>

																<div style="text-align: left; font-size: 20px;">이메일</div>
																<strong class="count">abc@gmail.com</strong>
															</div>
															<!--// content_wrap -->

															<!-- 포인트 -->
															<div class="content_header">
																<p class="content_title">
																	<span style="font-size: 22px;">포인트</span>
																</p>
																<a href="https://designskin36.clickn.co.kr/mypages/orders"
																	class="page_link"><span style="font-size: 14px;">
																		더 보기</span></a>
															</div>
															<div class="content_wrap">
																<br/>
																<div style="text-align: left; font-size: 20px;">포인트</div>
         
																	<div style="text-align: left; font-size: 20px;" onclick='location="point_list"'>포인트 사용내역</div>
																	

																	<div style="text-align: left; font-size: 20px;" onclick='location="gifticon_list"'>기프티콘 사용내역</div>

																
															</div>

															<!-- 내활동 -->
															<div class="content_header">
																<p class="content_title">
																	<span style="font-size: 22px;">내 활동</span>
																</p>
																<a
																	href="https://designskin36.clickn.co.kr/mypages/productInquiries"
																	class="page_link"><span style="font-size: 14px;">전체보기</span></a>
															</div>
															<div class="content_wrap">
																<br/>
																<div style="text-align: left; font-size: 20px;" onclick='location="bookmarked_list"'>내가 찜한 설명서</div>
																<br/>
																<div style="text-align: left; font-size: 20px;" onclick='location="mypost_list"'>내가 쓴 의견</div>
																<br/>
																<div style="text-align: left; font-size: 20px;" onclick='location="myreply_list"'>내가 쓴 답글</div>
																<br/>
															</div>
															<!--// content_wrap -->

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



															<!-- 모듈 별 html 끝 -->

															<!-- 1:1 문의 -->
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
															<!--// content_wrap -->

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
					<!-- ===================== // Skin Main ===================== -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>
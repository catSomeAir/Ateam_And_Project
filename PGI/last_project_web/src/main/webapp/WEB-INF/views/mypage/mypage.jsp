<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	width: 30px;
	height: 30px;
	object-fit: cover;
}

.myprofile {
	width: 100%;
	height: 100%;
	object-fit: cover;
}
/* main color:: 020E20 */
</style>
</head>
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
											<!-- <div
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
											</div> -->
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
																		style="font-size: 15px; margin-bottom: 1px; color: gray; cursor: pointer;"
																		class="pointer">수정하기 &nbsp;</span> <i
																		class="fa-solid fa-chevron-right" style="color: gray;"></i>
																</div>
															</div>
															<div
																style="text-align: left; position: absolute; left: 50px;">
																<div style="display: flex;">

																	<div class="box"
																		style="background: white; position: relative; top: 10px; left: 930px;">
																		<c:if test='${empty loginInfo.filepath}'>
																			<i class="font-profile fa-regular fa-circle-user myprofile"></i>
																		</c:if>
																		<c:if test='${!empty loginInfo.filepath}'>
																			<img class='myprofile' src='${loginInfo.filepath}'>
																		</c:if>
							
																	</div>
																</div>
															</div>
															<br /> <br /> <br /> <br /> <br /> <br /> <br />
															<div class="content_wrap">
																<br />
																<div style="text-align: left;">
																	<span style="text-align: left; font-size: 20px;">이름</span>
																	<strong class="count" style="margin-left: 530px;">${loginInfo.name}</strong>
																</div>
																<br />
																<div style="text-align: left;">
																	<span style="text-align: left; font-size: 20px;">전화번호</span>
																	<strong class="count" style="margin-left: 470px;">${loginInfo.phone}</strong>
																</div>
																<br />
																<div style="text-align: left;">
																	<span style="text-align: left; font-size: 20px;">이메일</span>
																	<strong class="count" style="margin-left: 470px;">${loginInfo.email}</strong>
																</div>
															</div>
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
																onclick='location="mypost_list"'>
																<span style="font-size: 20px; cursor: pointer;"
																	class="pointer">내가 쓴 의견</span> <i
																	class="fa-solid fa-chevron-right"
																	style="margin-left: 8px;"></i>
															</div>
															<br />
															<div style="text-align: left;"
																onclick='location="myreply_list"'>
																<span style="font-size: 20px; cursor: pointer;"
																	class="pointer">내가 쓴 답글</span> <i
																	class="fa-solid fa-chevron-right"
																	style="margin-left: 8px;"></i>
															</div>
															<br />
															<div style="text-align: left;"
																onclick='location="bookmarked_list"'>
																<span
																	style="text-align: left; font-size: 20px; cursor: pointer;"
																	class="pointer">내가 찜한 설명서</span> <i
																	class="fa-solid fa-chevron-right"
																	style="margin-left: 8px;"></i>
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
																<strong style="margin-left: 500px; font-size: 20px;">&nbsp;${loginInfo.point}
																	&nbsp;P</strong>
															</div>
															<br />
															<div style="text-align: left;"
																onclick='location="point_list"'>
																<span
																	style="text-align: left; font-size: 20px; cursor: pointer;"
																	class="pointer">포인트 사용내역</span> <i
																	class="fa-solid fa-chevron-right"
																	style="margin-left: 8px;"></i>
															</div>
															<br />
															<div style="text-align: left;"
																onclick='location="gifticon_list"'>
																<span
																	style="text-align: left; font-size: 20px; cursor: pointer;"
																	class="pointer">기프티콘 사용내역</span> <i
																	class="fa-solid fa-chevron-right"
																	style="margin-left: 8px;"></i>
															</div>
															<br />

														</div>
														<br />


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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>   
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">

<meta name="csrf-token"
	content="3FkKu3KJVuvOKs6kDtTZGH5tdAg0QUENIWDKcERQ">

<!-- <meta property="og:title" content="Beauty Shop"> -->
<title>Beauty Shop</title>


<!-- <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="https://storage.clickn.co.kr//css/modules/module_builderProductA.css?v=20221006" />상품 디스플레이
<link rel="stylesheet" type="text/css" href="https://storage.clickn.co.kr//css/modules/module_builderProductB.css?v=20221006" />상품 문의 -->
<link rel="stylesheet" type="text/css"
	href="https://storage.clickn.co.kr//css/modules/module_builderProductC.css?v=20221006" />
<!-- 상품 후기 -->

<!-- <link href="https://fonts.googleapis.com/css2?family=Black+And+White+Picture&family=Black+Han+Sans&family=Cute+Font&family=Do+Hyeon&family=Dokdo&family=East+Sea+Dokdo&family=Gaegu:wght@400;700&family=Gamja+Flower&family=Gugi&family=Hi+Melody&family=Jua&family=Kirang+Haerang&family=Nanum+Brush+Script&family=Nanum+Gothic:wght@400;700&family=Nanum+Myeongjo:wght@400;700&family=Nanum+Pen+Script&family=Poor+Story&family=Single+Day&family=Song+Myung&family=Stylish&family=Sunflower:wght@300;700&family=Yeon+Sung&display=swap" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css2?family=Amatic+SC:wght@400;700&family=Archivo:wght@400;700&family=Exo:wght@200;400;700&family=Fauna+One&family=Fjalla+One&family=Graduate&family=Iceland&family=Inconsolata:wght@300;500;700&family=Italianno&family=Josefin+Sans:wght@200;400;700&family=Lato:wght@100;300;400;700&family=Libre+Baskerville:wght@400;700&family=Montserrat:wght@200;300;400;500;600;700&family=Nixie+One&family=Nunito:wght@200;400;700&family=Oswald:wght@200;400;500;700&family=Playfair+Display:wght@400;500;700&family=Poppins:wght@200;400;700&family=Raleway:wght@200;400;700&family=Roboto:wght@100;300;400;500;700&family=Simonetta:wght@400;900&family=Space+Mono:wght@400;700&family=Special+Elite&family=Stardos+Stencil:wght@400;700&family=Titan+One&family=Titillium+Web:wght@200;400;700&family=Trocchi&family=Ultra&family=Wellfleet&family=Abril+Fatface&family=Bodoni+Moda:wght@400;600;800&family=DM+Serif+Display&family=DM+Serif+Text&family=EB+Garamond:wght@400;500&family=Open+Sans:wght@300;400;700&family=Petit+Formal+Script&family=Quicksand:wght@300;700&family=Cinzel&family=Lobster&family=MonteCarlo&family=Shrikhand&display=swap" rel="stylesheet" />
 -->

<link rel="stylesheet" type="text/css"
	href="https://storage.clickn.co.kr//css/modules/special_common.css?v=20221006">
<link rel="stylesheet" type="text/css"
	href="https://storage.clickn.co.kr//css/modules/module_mypage.css?v=20221006">

<script>

	var MODULES_STORAGE_BASE_URI = "https:\/\/storage.clickn.co.kr\/";
</script>
<script src="https://designskin36.clickn.co.kr/lang/skin_js.js"></script>
<script
	src="https://designskin36.clickn.co.kr/lang/common.js?m=front&amp;g=common"></script>
<script
	src="https://designskin36.clickn.co.kr/vendors/Jquery/jquery.min.js"></script>
<script
	src="https://designskin36.clickn.co.kr/vendors/Twbs-pagination/jquery.twbsPagination.js"></script>
<script src="https://designskin36.clickn.co.kr/js/common.js?v=20221006"></script>
<script
	src="https://designskin36.clickn.co.kr/js/skin_ui_functions.js?v=20221006"></script>
<!-- 우선 순위 높아야하는 UI Functions -->

<script>
	var USER = "pgi0822"
</script>



</head>
<body>
	<div id="skinLayoutWrap" class="skin_layout_wrap"
		data-layout-type="type1" data-header-hidden="no"
		data-footer-hidden="no" data-header-flying="yes"
		data-header-floating="yes" data-header-util="no"
		data-header-selectmenu="yes" data-header-login="yes"
		data-header-bgcolor="#ffffff" data-header-brightness="light"
		data-header-utilcolor="" data-navigation-color=""
		data-navigation-font="Montserrat" data-navigation-fontsize="16"
		data-gnb-seq="3" data-wow-use="no" data-wow-ani="fadeInRight"
		data-shopping-my="yes" data-shopping-cart="yes"
		data-shopping-search="yes" data-shopping-menuorder="my-cart-search"
		data-mypage-menu="6">
		<div id="pageConfigHeader"
			class="skin_layout_container skin_layout_container1">

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
												<div class="mypage">
													<!-- 타이틀 -->
													<div class="title wow">
														<p>
															<span
																style="font-size: 30px; color: #000; font-weight: 500;">포인트</span>
														</p>
													</div>
													<strong style="font-size:2rem;">100P</strong>
													<br>
													<br/>
													<br/>
													<div style="font-size: 1.5rem;">적립 및 사용 내역</div>
													<div class="sub_content">
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
						<!-- ===================== // Skin Main ===================== -->
					</div>
				</div>
			</div>
		</div>
<form method='post' action='list.no'>
<input type='hidden' name='curPage' value='1'>
<div id='list-top' class='w-px1200'>
	<ul>
		<!-- 관리자로 로그인한 경우만 글쓰기 가능 -->
		<c:if test='${ loginInfo.admin eq "Y" }'>
		<li><a class='btn-fill' href='new.no'>글쓰기</a></li>
		</c:if>
	</ul>
</div>
</form>

<table class='tb-list w-px1200'>
<colgroup>
	<col width='100px'>
	<col width='100px'>
	<col>
	<col width='120px'>
</colgroup>
<tr><th>번호</th>
	<th>날짜</th>
	<th>내용</th>
	<th>포인트</th>
</tr>
<c:forEach items='${page.list}' var='vo'>
<tr><td>${vo.no}</td>
	<td class='left'>
	<c:forEach var='i' begin="1" end="${vo.indent}">
		${i eq vo.indent ? '&nbsp;&nbsp;<i class="font fa-regular fa-comment-dots"></i>' 
						 : '&nbsp;&nbsp;'  }
	</c:forEach>
	<td>${vo.name}</td>
	<td>${vo.writedate}</td>
	<td>${empty vo.filename ? '' : '<i class="font fa-solid fa-paperclip"></i>'}</td>
</tr>
</c:forEach>
</table>

<div class='btnSet'>
	<jsp:include page="/WEB-INF/views/include/page.jsp"/>
</div>

	<script
		src="https://designskin36.clickn.co.kr/js/skin_render_builderProductC.js?v=20221006"></script>
	<!-- 상품 후기 -->
	<script
		src="https://designskin36.clickn.co.kr/js/skin_ui.js?v=20221006"></script>
	<script
		src="https://storage.clickn.co.kr//js/modules/modules_ui.js?v=20221006"></script>


	<script src="/modules/js?m=members&js=login&v=20221006"></script>
	<script>
		var _IS_MYPAGE = true;
	</script>
	<!-- Mypage JS -->
	<script src="https://designskin36.clickn.co.kr/js/mypage.js?v=20221006"></script>
	<script
		src="https://designskin36.clickn.co.kr/lang/common.js?m=products&amp;sf=productReviews"></script>
	<script
		src="https://designskin36.clickn.co.kr/lang/list.js?m=products&amp;sf=productReviews"></script>
	<!-- Module JS -->
	<script
		src="/modules/js?m=products&js=skins/productReviews/mypage.list&v=20221006"></script>
	<script>
		$(document).ready(function() {
			var params = {
				'userInfo' : {
					"seq" : 1,
					"id" : "pgi0822",
					"name" : null
				}
			};
			productBoardReview.init(params);
		});
	</script>

</body>
</html>

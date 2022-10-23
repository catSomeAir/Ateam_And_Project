<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header>
	<div style="width: 100%; inline-block !important; overflow: hidden;">
	<div style="width: 100%; height: 180px; background-color: #020E20; display: flex; justify-content: center;">
		<div style="margin:auto !important; display: flex; justify-content: center !important; height: 100px; ;">
			<a href="<c:url value='/'/>" style="font-size: 36px; color: white; text-align: center; vertical-align: middle"><img src='img/temp2.png'></a>
<!-- 		</div> -->
	</div>
	</div>
	<div class="corroping" style=" padding: 10px 20px 10px 360px !important; display: flex;  justify-content:center; ; align-items: center; ">
	<div class='category' style="width: 100%">
		
		<ul>
			<li style="width:100% !important;"><a ${category eq 'no' ? 'class="active"' : ''}
				href='list_web.no'>공지사항</a></li>
			<li style="width:100% !important;"><a ${category eq 'my' ? 'class="active"' : ''}
				href='list_web.my'>마이페이지</a></li>
			<%-- <li><a ${category eq 'cu' ? 'class="active"' : ''} href='list.cu'>고객관리</a></li> --%>
			<li style="width:100% !important;"><a ${category eq 'ev' ? 'class="active"' : ''}
				href='list_web.ev'>이벤트</a></li>
			<li style="width:100% !important;"><a ${category eq 'cs' ? 'class="active"' : ''}
				href='list_web.cs'>고객센터</a></li>
			<li style="width:100% !important;"><a ${category eq 'qna' ? 'class="active"' : ''}
				href='list_web.ch'>채팅서비스</a></li>
			<li style="width:100% !important;"><a ${category eq 'ad' ? 'class="active"' : ''}
				href='list_web.ad'>관리자메뉴</a></li>
			
		</ul>
	</div>
<!-- 	<div style="margin-left: 300px"> -->
	<div style="width:42%; display: flex; flex-direction: row-reverse;" >
		<ul>
			<!-- 로그인하지 않은 경우 -->
			<c:if test='${empty loginInfo}'>
				<li><a class='btn-fill' href='login_web' style="margin-right: 4px">로그인</a></li>
				<li><a class='btn-fill' href='member_web'>회원가입</a></li>
			</c:if>
			<!-- 로그인한 경우 -->
			<c:if test='${not empty loginInfo}'>
				<li class='items-center'>
					<!-- 프로필이미지가 없는 경우 기본 이미지가 보이게 --> <c:if
						test='${empty loginInfo.filepath}'>
						<i class="font-profile fa-regular fa-circle-user"></i>
					</c:if> <c:if test='${!empty loginInfo.filepath}'>
						<img class='profile' src='${loginInfo.filepath.replace("localhost","121.147.215.12:3302").replace("192.168.0.33","121.147.215.12:3302")}'>
					</c:if> <span style="margin:0 6px;">${loginInfo.name} 님</span> <a class='btn-empty'
					href='password_web'>비밀번호변경</a> <a class='btn-fill' href='logout_web'>로그아웃</a>
				</li>
			</c:if>
		</ul>
	</div>
	</div>
	
</header>
<style>
.font-profile {
	font-size: 50px;
}

.profile {
	width: 50px;
	height: 50px;
	border-radius: 50%;
	border: 1px solid
}

  .corroping {
	border-bottom: 1px solid #ccc;
	display: flex;
	justify-content: center;
	/* width: calc(100% - 200px); */
	/* 	padding: 0 100px; */
	padding: 0px !important;
	margin: 0px !important;
	align-items: ;
} 

/* div.category ul {
	margin: 0px !important;
	padding: 0px !important;
} */

header div.category ul {
	display: flex;
	font-weight: bold;
	font-size: 19px
}

header div.category ul li:not(:last-child) {
	margin-right: 60px
}

header div.category ul li a:hover, header div.category ul li a.active {
	color: #5762a6;
}

header div ul {
	display: flex;
}

header div ul li:not(:last-child) {
	margin-right: 5px;
}

a {
	cursor: pointer;
}
</style>
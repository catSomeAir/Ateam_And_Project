<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<header>
<div class='category'>
	<ul>
		<li><a href="<c:url value='/'/>"><img src='img/hanul.logo.png'></a></li> 
		<li><a ${category eq 'cu' ? 'class="active"' : ''} href='list.no'>공지사항</a></li>
		<li><a ${category eq 'hr' ? 'class="active"' : ''} href='mypage'>마이페이지</a></li>
		<li><a ${category eq 'no' ? 'class="active"' : ''} href='list.no'>이벤트</a></li>
		<li><a ${category eq 'bo' ? 'class="active"' : ''} href='list.bo'>고객센터</a></li>
		<li><a ${category eq 'qna' ? 'class="active"' : ''} href='chat'>채팅서비스</a></li>
		<li><a ${category eq 'da' ? 'class="active"' : ''} href='list.da'>관리자 메뉴</a></li>
	</ul>
</div>
<div>
	<ul>
		<!-- 로그인하지 않은 경우 -->
		<c:if test='${empty loginInfo}'>
		<li><a class='btn-fill' href='login'>로그인</a></li>
		<li><a class='btn-fill' href='member'>회원가입</a></li>
		</c:if>
		<!-- 로그인한 경우 -->
		<c:if test='${not empty loginInfo}'>
		<li class='items-center'>
			<!-- 프로필이미지가 없는 경우 기본 이미지가 보이게 -->
			<c:if test='${empty loginInfo.profile}'>
			<i class="font-profile fa-regular fa-circle-user"></i>
			</c:if>
			<c:if test='${!empty loginInfo.profile}'>
			<img class='profile' src='${loginInfo.profile}'>
			</c:if>
			
			<span>${loginInfo.name} 님</span>	
			<a class='btn-empty' href='password'>비밀번호변경</a>
			<a class='btn-fill' href='logout'>로그아웃</a></li>
		</c:if>
	</ul>
</div>
</header>
<style>
.font-profile { font-size: 50px; }
.profile { width: 50px; height: 50px; border-radius: 50%; border: 1px solid }

header { 
	border-bottom:1px solid #ccc;
	display: flex; 
	justify-content: space-between;
	/* width: calc(100% - 200px); */
	padding: 0 100px;
	align-items: center;
}
header div.category ul { display: flex; font-weight: bold;  font-size:19px }
header div.category ul li:not(:last-child) { margin-right: 50px }
header div.category ul li a:hover
, header div.category ul li a.active { color: #0040ff; }
header div ul { display: flex; }
header div ul li:not(:last-child) { margin-right: 5px; }

a { cursor: pointer; }

</style>
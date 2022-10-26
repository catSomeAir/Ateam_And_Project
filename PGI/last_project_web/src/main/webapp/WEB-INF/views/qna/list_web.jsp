<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/common.css" >
<title>Insert title here</title>
<style>
.more { margin: 0 auto; display:flex; flex-direction: column; }
.more ul { display: flex; }
.more ul li:not(:first-child) { margin-left: 5px }

#qa-list-top{
	display: flex;
	width: 100%;
	justify-content: space-between;
}

#qa-list-top ul{
	width: 430px;
	height: 40px;
	display: flex;
	align-items: center;
	flex-direction: row;
	flex-wrap: nowrap;
	justify-content: center;
	border: 1px solid #d8d8d8;
	border-radius: 15px;
}	
.qa-btn-li{
	width: 100px;
	height: 40px;
	
}

.a-ain{
	width: 25%;
	height: 35px;
	padding: 6% 20%;
}


.dataTable-info{
	display: none !important;
}

.help-sc-input {
    border: 0px;
    /* border-bottom: 1px solid #d8d8d8; */
    padding: 0px;
}

.list-top-ul-login {
    display: none;
}
.btn-fill-ain-sc{
	text-align:center;
	/* border-radius: 17px; */
	background-color: #020E2000;
	color: #020E20;
	font-size: 20px;
	justify-content: center;
}

form {
    display: flex;
    width: 1200px;
    flex-direction: row;
    justify-content: flex-end;
}

div#help-wrap {
    width: 100%;
    display: flex;
    justify-content: center;
}

#title-tr{
	background-color: #d8d8d8;
}
#title-th{
	border: 0px 0px 1px 0px solid #d8d8d8;
}
.tr-wrap th, .tr-wrap td {
	border: 0px;
	/* background-color: #ffffff; */
	/* border-bottom: 1px solid #d8d8d8; */
}

.left a {
	margin-left: 20px;
}

#help-new-btn {
	border: 2px solid #d8d8d8;
	border-radius: 15px;
	width: 30px;
	height: 12px;
	
}

.qa-btn-li-new {
    width: 70px;
    height: 25px;
}



/* .list-ul-new{
	
	width: 100px;
	
}
 */
/* 박가인 */
a#help-new-btn {
    padding: 10px 12px;
}
</style>
</head>
<body>
<h3>문의글 목록</h3>
<div id="help-wrap">	
	<form method='post' action='list_web.qa' >

		<div id='qa-list-top'> 
			<!-- 로그인한 경우만 글쓰게 버튼 활성화 -->
			<c:if test="${not empty loginInfo}">
				<ul class="list-ul-new" style="border: 0px; width: 100px;">

					<li class="qa-btn-li-new">
						<a id="help-new-btn" class='btn-fill-ain-sc new' style=" font-size: 15px; color: #123; ">글쓰기</a>
					</li>
				</ul>
			</c:if>
			<ul class="list-top-ul">
				<li><select class='w-px100 help-sc-input' name='search'>
					<option value='all'  ${page.search eq 'all' ? 'selected' : ''} >전체</option>
					<option value='title'  ${page.search eq 'title' ? 'selected' : ''}>제목</option>
					<option value='writer'  ${page.search eq 'writer' ? 'selected' : ''}>작성자</option>
					</select>
				</li>
				<li><input type='text' name='keyword' value='${page.keyword}' class='w-px300 help-sc-input'></li>
				<li class="qa-btn-li" style="width: 33px; height: 30px;"><a style="width: 20px; height: 20px;"  class='btn-fill-ain-sc a-ain search'> <svg class="svg-inline--fa fa-magnifying-glass" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="magnifying-glass" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" data-fa-i2svg=""><path fill="currentColor" d="M500.3 443.7l-119.7-119.7c27.22-40.41 40.65-90.9 33.46-144.7C401.8 87.79 326.8 13.32 235.2 1.723C99.01-15.51-15.51 99.01 1.724 235.2c11.6 91.64 86.08 166.7 177.6 178.9c53.8 7.189 104.3-6.236 144.7-33.46l119.7 119.7c15.62 15.62 40.95 15.62 56.57 0C515.9 484.7 515.9 459.3 500.3 443.7zM79.1 208c0-70.58 57.42-128 128-128s128 57.42 128 128c0 70.58-57.42 128-128 128S79.1 278.6 79.1 208z"></path></svg></a></li>
			</ul>
		</div>
		<input type='hidden' name='id'>
		<input type='hidden' name='curPage' value='1'>
		<input type='hidden' name='read' value='0'>
	</form>
</div>
<table class='tb-list w-px1200'>
<tr id="title-tr" class="tr-wrap tr-title">
	<th id="title-th">제목</th>
	<th>작성일</th>
</tr>
<c:if test="${empty page.qnaList}">
<tr  class="tr-wrap">
	<td colspan='6'>질문과 답변 자료가 없습니다</td>
</c:if>

<c:forEach items="${page.qnaList}" var='vo'>
<tr class="tr-wrap">
	<td class='left ' style="width: 1000px !important;">
		<c:if test='${vo.open eq 1}'><i class="fa-solid fa-lock"></i></c:if>
		<c:choose>
			<c:when test='${loginInfo.email eq vo.writer or loginInfo.admin eq "Y"}'>
				<a onclick='detail(${vo.id})'>${vo.title}</a>
			</c:when>
			<c:otherwise>
				<c:if test='${vo.open eq 0}'>
					<a onclick='detail(${vo.id})'>${vo.title}</a>
				</c:if>
				<c:if test='${vo.open eq 1 and loginInfo.email ne vo.writer}'>비밀글입니다.</c:if>
			</c:otherwise>
		</c:choose>
	</td>
	<td>${vo.writedate}</td>
</tr>
</c:forEach>
</table>

<div class='btnSet'>
	<jsp:include page="/WEB-INF/views/include/page.jsp"/>
</div>
<script>
	$('[name=field]').val( ${field} ).prop( 'selected', true );
	$('[name=open][value=${open}]').prop( 'checked', true );
	
	$('.new').click(function(){
		if( ${empty loginInfo} ){
			alert('로그인 후 이용가능합니다');
			location.href='login_web'
		}else{
			location.href='new_web.qa'
		}
	});
	$('[name=pageList]').val( ${page.pageList} ).prop( 'selected', true );
	
	$('[name=pageList], [name=open], [name=field]').change(function(){
		$('form').submit();
	});
	
	$('.search').click(function(){
		$('form').submit();
	});
	
	function detail( id ){
		$('[name=id]').val( id );
		$('[name=read]').val( 1 );
		$('form').attr('action', 'detail_web.qa');
		$("form").submit();
	}
</script>
</body>
</html>








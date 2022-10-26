<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fm" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/css/common.css" >
<link rel="stylesheet" href="resources/css/cs_list.css" >
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#list-top-1 {
	display: flex;
	justify-content: center;
	flex-direction: column; 
	margin:0 auto;
}
h2{
	text-align: center;
	margin-top: 50px;
	margin-bottom: 100px;
}
</style>
</head>
<body>
<h2>자주 묻는 도움말</h2>

<form method='post' action='helplist.cs'>
<div id='list-top-1' class='w-px1200'>
	<div id="list_ul_wrap">
		<ul id="list_ul">
			 <li class="list_li">
				<select class='w-px100 search_select' name='search'>
				<option value='all'  ${page.search eq 'all' ? 'selected' : ''} >카테고리</option>
				<option value='title'  ${page.search eq 'cs_title' ? 'selected' : ''}>제목</option>
				<option value='content'  ${page.search eq 'cs_content' ? 'selected' : ''}>내용</option>
				<option value='t_c'  ${page.search eq 't_c' ? 'selected' : ''}>제목+내용</option>
				<option value='writer'  ${page.search eq 'cs_writer' ? 'selected' : ''}>작성자</option>
				</select>
			</li> 
			<li class="in_keyword"><input type='text' name='keyword' value='${page.keyword}' class='w-px300 search-input'></li>
			<li class="li_search"><a class='search'  onclick='$("form").submit()'>검색</a></li>
		</ul>
	</div>
	
	<div id="page_ul_wrap">
	
		<ul class="ul-in">
			<li>
				<select name='pageList' class='w-px100 page_lsit' >
				<c:forEach var='i' begin="1" end='6' >
				<option value='${10*i}'>${10*i}개씩</option>
	 			<%-- <option ${page.pageList eq 10*i ? 'selected' : ''} value='${10*i}'>${10*i}개씩</option> --%>
				</c:forEach>
				</select>
			</li>
	
			<!-- 로그인한 경우만 글쓰기 가능 - 관리자 권한있는 id만 가능하게 바꾸기-->
			<c:if test='${loginInfo.admin eq "Y"}'>
				<li id="cs_insert"><a class='cs-btn-fill' href='cs_new.cs'>글쓰기</a></li>
			</c:if>
		</ul>
	</div>
</div>
<input type='hidden' name='id'>
<input type='hidden' name='curPage' value='1'>
</form>


<ul class='grid w-px1200'>
	<c:forEach items="${page.list}" var='vo'>
	<li>
	<div><a onclick='detail(${vo.id})' href="detail_web.cs?id=${vo.id}"><span style="font-size: 20px; " >Q </span>${vo.cs_title}</a></div>
		<div>${vo.name}</div>
		<div>
		<fm:parseDate value="${vo.cs_writedate}" var="parseDateValue" pattern="yyyy-MM-dd"/>
		<fm:formatDate value="${parseDateValue}"  pattern="yyyy-MM-dd"/>
		</div>
	</li>
	</c:forEach>
</ul>

<div class='btnSet'>
	<jsp:include page="/WEB-INF/views/include/page.jsp"/>
</div>




<!-- 게시글 그리드 페이징 바로 하는 스크립트 -->
<script>
$('[name=pageList]').val( ${page.pageList} ).prop( 'selected', true );

$('[name=pageList]').change(function(){
	$('form').submit();
});
function detail( id ){
	$('[name=id]').val( id );
	$('form').attr('action', 'detail.cs');
	$("form").submit();
}

$('[name=field]').val( ${field} ).prop( 'selected', true );
$('[name=open][value=${open}]').prop( 'checked', true );

$('.new').click(function(){
	if( ${empty loginInfo} ){
		alert('로그인 후 이용가능합니다');
	}else{
		location.href='new.qna'
	}
});


$('[name=pageList], [name=open], [name=field]').change(function(){
	$('form').submit();
});

$('.search').click(function(){
	$('form').submit();
});

function detail( id ){
	$('[name=id]').val( id );
	$('[name=read]').val( 1 );
	$('form').attr('action', 'detail.qna');
	$("form").submit();
}

</script>
</body>
</html>
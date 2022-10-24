<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>방명록 목록</h3>
<form method='post' action='list.bo'>
<div id='list-top' class='w-px1200'>
	<ul>
		<li><select class='w-px100' name='search'>
			<option value='all'  ${page.search eq 'all' ? 'selected' : ''} >전체</option>
			<option value='title'  ${page.search eq 'title' ? 'selected' : ''}>제목</option>
			<option value='content'  ${page.search eq 'content' ? 'selected' : ''}>내용</option>
			<option value='t_c'  ${page.search eq 't_c' ? 'selected' : ''}>제목+내용</option>
			<option value='writer'  ${page.search eq 'writer' ? 'selected' : ''}>작성자</option>
			</select>
		</li>
		<li><input type='text' name='keyword' value='${page.keyword}' class='w-px300'></li>
		<li><a class='btn-fill search'>검색</a></li>
	</ul>

	<ul>
		<li>
			<select name='pageList' class='w-px100'>
			<c:forEach var='i' begin="1" end='6' >
			<option value='${10*i}'>${10*i}개씩</option>
<%-- 			<option ${page.pageList eq 10*i ? 'selected' : ''} value='${10*i}'>${10*i}개씩</option> --%>
			</c:forEach>
			</select>
		</li>
		<li><select name='viewType' class='w-px120'>
			<option value='list'>리스트형태</option>
			<option value='grid'>그리드형태</option>
			</select>
		</li>
		<!-- 로그인한 경우만 글쓰기 가능 -->
		<c:if test="${not empty loginInfo}">
		<li><a class='btn-fill' href='new.bo'>글쓰기</a></li>
		</c:if>	
	</ul>
</div>
<input type='hidden' name='id'>
<input type='hidden' name='curPage' value='1'>
</form>

<c:if test='${page.viewType eq "grid"}'>
<ul class='grid w-px1200'>
	<c:forEach items="${page.list}" var='vo'>
	<li><div><a onclick='detail(${vo.id})'>${vo.title}</a></div>
		<div>${vo.name}</div>
		<div>${vo.writedate}</div>
	</li>
	</c:forEach>
</ul>
</c:if>

<c:if test='${page.viewType eq "list"}'>
<table class='tb-list w-px1200'>
<colgroup>
	<col width='100px'>
	<col>
	<col width='120px'>
	<col width='120px'>
</colgroup>
<tr><th>번호</th>
	<th>제목</th>
	<th>작성자</th>
	<th>작성일자</th>
</tr>
<c:forEach items="${page.list}" var='vo'>
<tr><td>${vo.no}</td>
	<td class='left'><a onclick='detail(${vo.id})'>${vo.title}</a>
		${vo.filecnt eq 0 ? '' : '<i class="font-b fa-solid fa-paperclip"></i>'}</td>
	<td>${vo.name}</td>
	<td>${vo.writedate}</td>
</tr>
</c:forEach>
</table>
</c:if>

<div class='btnSet'>
	<jsp:include page="/WEB-INF/views/include/page.jsp"/>
</div>
<script>
$('[name=pageList]').val( ${page.pageList} ).prop( 'selected', true );
$('[name=viewType]').val( '${page.viewType}' ).prop( 'selected', true );

$('[name=pageList], [name=viewType]').change(function(){
	$('form').submit();
});

$('.search').click(function(){
	$('form').submit();
});

function detail( id ){
	$('[name=id]').val( id );
	$('form').attr('action', 'detail.bo');
	$("form").submit();
}
</script>
</body>
</html>








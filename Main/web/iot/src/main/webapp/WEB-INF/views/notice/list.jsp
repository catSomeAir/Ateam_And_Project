<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>공지사항</h3>

<form method='post' action='list.no'>
<input type='hidden' name='curPage' value='1'>
<div id='list-top' class='w-px1200'>
	<ul>
		<li>
			<select class='w-px100' name='search'>
			<option value='all' ${page.search eq 'all' ? 'selected' : ''}>전체</option>
			<option value='title' ${page.search eq 'title' ? 'selected' : ''}>제목</option>
			<option value='content' ${page.search eq 'content' ? 'selected' : ''}>내용</option>
			<option value='writer' ${page.search eq 'writer' ? 'selected' : ''}>작성자</option>
			<option value='t_c' ${page.search eq 't_c' ? 'selected' : ''}>제목+내용</option>
			</select>
		</li>
		<li><input type='text' name='keyword' class='w-px300' 
									value='${page.keyword}'></li>	
		<li><a class='btn-fill' onclick='$("form").submit()'>검색</a></li>
	</ul>
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
	<col>
	<col width='120px'>
	<col width='120px'>
	<col width='80px'>
</colgroup>
<tr><th>번호</th>
	<th>제목</th>
	<th>작성자</th>
	<th>작성일자</th>
	<th>첨부파일</th>
</tr>
<c:forEach items='${page.list}' var='vo'>
<tr><td>${vo.no}</td>
	<td class='left'>
	<c:forEach var='i' begin="1" end="${vo.indent}">
		${i eq vo.indent ? '&nbsp;&nbsp;<i class="font fa-regular fa-comment-dots"></i>' 
						 : '&nbsp;&nbsp;'  }
	</c:forEach>
		<a href='detail.no?id=${vo.id}'>${vo.title}</a></td>
	<td>${vo.name}</td>
	<td>${vo.writedate}</td>
	<td>${empty vo.filename ? '' : '<i class="font fa-solid fa-paperclip"></i>'}</td>
</tr>
</c:forEach>
</table>

<div class='btnSet'>
	<jsp:include page="/WEB-INF/views/include/page.jsp"/>
</div>

</body>
</html>
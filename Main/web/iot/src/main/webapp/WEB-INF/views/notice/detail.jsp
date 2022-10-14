<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix='fn'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table td { text-align: left }
</style>
</head>
<body>
<h3>공지글 안내</h3>
<table class='w-px1200'>
<tr><th class='w-px140'>제목</th>
	<td colspan='5'>${vo.title}</td>
</tr>
<tr><th>작성자</th>
	<td>${vo.name}</td>
	<th class='w-px140'>작성일자</th>
	<td class='w-px140'>${vo.writedate}</td>
	<th class='w-px100'>조회수</th>
	<td class='w-px100'>${vo.readcnt}</td>
</tr>
<tr><th>내용</th>
	<td colspan='5'>${fn: replace(vo.content, crlf, '<br>')}</td>
</tr>
<tr><th>첨부파일</th>
	<td colspan='5'>${vo.filename}
	<!-- 첨부파일이 있는 경우 다운로드가 보이게 -->
	<c:if test='${not empty vo.filename}'>
	<a href='download.no?id=${vo.id}'><i class="font-b fa-solid fa-file-arrow-down"></i></a>
	</c:if>
	</td>
</tr>
</table>

<div class='btnSet'>
<a class='btn-fill' href='list.no'>목록으로</a>
<!-- 관리자이면 수정/삭제 가능 -->
<%-- <c:if test='${loginInfo.admin eq "Y"}'> --%>
<!-- 로그인사용자 작성자인 경우 수정/삭제 가능  -->
<c:if test='${loginInfo.userid eq vo.writer}'>
<a class='btn-fill' href='modify.no?id=${vo.id}'>수정</a>
<a class='btn-fill remove'>삭제</a>
</c:if>
<!-- 로그인된 경우 답글쓰기 가능 -->
<c:if test='${!empty loginInfo}'>
<a class='btn-fill' href='reply.no?id=${vo.id}'>답글쓰기</a>
</c:if>
</div>

<script>
$('.remove').click(function(){
	if( confirm('정말 삭제?') ){
		location='delete.no?id=${vo.id}';
	}
});
</script>

</body>
</html>
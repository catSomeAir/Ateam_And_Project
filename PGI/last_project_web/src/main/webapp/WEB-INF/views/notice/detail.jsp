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
<tr><th style="width:14px">제목</th>
	<td colspan='3'>${vo.title}</td>
</tr>
<tr>
	<th style="width:14px">작성일자</th>
	<td style="width:14px">${vo.today}</td>
	
</tr>
<tr><th>내용</th>
	<td colspan='3'>${fn: replace(vo.content, crlf, '<br>')}</td>
</tr>

</table>

<div class='btnSet'>
<a class='btn-fill' href='list_web.no'>목록으로</a>
<!-- 관리자이면 수정/삭제 가능 -->
<%-- <c:if test='${loginInfo.admin eq "Y"}'> --%>
<!-- 로그인사용자 작성자인 경우 수정/삭제 가능  -->
<c:if test='${loginInfo.userid eq vo.writer}'>
<a class='btn-fill' href='modify_web.no?id=${vo.id}'>수정</a>
<a class='btn-fill remove'>삭제</a>
</c:if>

</div>

<script>
$('.remove').click(function(){
	if( confirm('정말 삭제하시겠습니까?') ){
		location='delete_web.no?id=${vo.id}';
	}
});
</script>

</body>
</html>
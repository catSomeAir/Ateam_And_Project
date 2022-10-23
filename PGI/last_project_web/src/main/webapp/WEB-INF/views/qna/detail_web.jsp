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
.caption { text-align: left; width:1200px; margin: 10px auto; font-size: 18px; font-weight: bold }
.caption:not(:first-child) { margin-top: 30px }
</style>
</head>
<body>
<h3>문의글 상세 내용</h3>
<div class='caption'></div>
<table class='w-px1200'>
<tr><th class='w-px140'>문의한 회원</th>
	<td>${vo.name}</td>
</tr>
</table>

<div class='caption'><span>문의 내용</span></div>
<table class='w-px1200'>
<tr><th class='w-px140'>제목</th>
	<td>${vo.title}</td>
</tr>
<tr><th>분야</th>
	<td>${vo.field_title}</td>
</tr>
<tr><th>내용</th>
	<td colspan='5'>${fn: replace(vo.content, crlf, '<br>')}</td>
</tr>
</table>

<div class='btnSet'>
<a class='btn-fill' id='list_web'>목록으로</a>
<!-- 로그인사용자 작성자인 경우 수정/삭제 가능  -->
<c:if test='${loginInfo.email eq vo.writer}'>
<!-- 답글이 있어 처리가 완료된 경우 수정불가 -->
<c:if test='${vo.answer eq null}'>
<a class='btn-fill' id='modify_web'>수정</a>
</c:if>
<a class='btn-fill' id='remove_web'>삭제</a>
</c:if>
</div>

<!-- 답글이 있고 일반회원으로 로그인한 경우 -->
<c:if test='${vo.answer ne null  and loginInfo.admin ne "Y"}'>
	<div class='caption'><span>답변 내용</span></div>
	<table class='w-px1200'>
	<tr><th class='w-px140'>답변자</th>
		<td>${vo.answer.name}</td>
	</tr>
	<tr><th>답변일자</th>
		<td>${vo.answer.writedate}</td>
	</tr>
	<tr><th>답변내용</th>
		<td>${fn:replace(vo.answer.content, crlf, '<br>')}</td>
	</tr>
	</table>
</c:if>


<!-- 관리자로 로그인된 경우 답글쓰기 가능 -->
<form method='post'>
<c:if test='${loginInfo.admin eq "Y"}'>
	<div class='caption'><span>답변 내용</span></div>
	<table class='w-px1200'>
	<tr><th class='w-px140'>답변자</th>
		<td>${loginInfo.name}</td>
	</tr>
	<tr><th>답변내용</th>
		<td><textarea class='full chk' 
		name='content' title='답변내용'><c:if test='${vo.answer ne null}'>${vo.answer.content}</c:if></textarea></td>
	</tr>
	</table>
	<div class='btnSet'>
		<a class='btn-fill' id='save'>저장</a>
		<a class='btn-fill' id='cancel'>취소</a>
	</div>	
</c:if>

<input type='hidden' name='id' value='${vo.id}'>
<input type='hidden' name='qna_id' value='${vo.id}'>
<input type='hidden' name='writer' value='${loginInfo.userid}'>
<input type='hidden' name='curPage' value='${page.curPage}'>
<input type='hidden' name='pageList' value='${page.pageList}'>
<input type='hidden' name='search' value='${page.search}'>
<input type='hidden' name='keyword' value='${page.keyword}'>
</form>

<script>
// 질문수정/삭제
$('#list_web, #modify_web').click(function(){
	$('form').attr('action',  $(this).attr("id") + '.qa');
	$('form').submit();
});
$('#remove_web').click(function(){
	if( confirm('정말 삭제?') ){
		$('form').attr('action', 'delete_web.qa');
		$('form').submit();
	}
});

// 답글저장/취소
$('#cancel').click(function(){
	$('form').attr('action',  'list_web.qa');
	$('form').submit();
});
$('#save').click(function(){
	$('[name=id]').val('${vo.answer eq null ? vo.id : vo.answer.id}');
	$('form').attr('action',  'answer_${vo.answer eq null ? "insert" : "update"}.qa');
	if( emptyCheck() ) $('form').submit();
});
</script>

</body>
</html>
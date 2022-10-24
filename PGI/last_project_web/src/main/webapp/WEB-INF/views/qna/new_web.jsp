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
<h3>1:1 문의하기</h3>
<form method='post' action='insert_web.qa' enctype='multipart/form-data'>
<input type='hidden' name='writer' value='${loginInfo.email}'>
<table class='w-px1200'>
<tr><th class='w-px140'>제목</th>
	<td><input type='text' class='full chk' name='title' title='제목'></td>
</tr>
<tr><th>분야</th>
	<td><select class='w-pct100' name='field'>
		<option value='0'>질문분야를 선택해주세요</option>
		<c:forEach items="${fields}" var='f'>
		<option value='${f.id}'>${f.title}</option>
		</c:forEach>
		</select>
	</td>
</tr>
<tr><th>공개여부</th>
	<td class='left'>
		<label><input type='radio' name='open' value='0'>공개</label>
		<label><input type='radio' name='open' value='1' checked>비공개</label>
	</td>
</tr>
<tr><th>내용</th>
	<td><textarea class='full chk' name='content' title='내용'></textarea></td>
</tr>

</table>
</form>

<div class='btnSet'>
	<a class='btn-fill save'>저장</a>
	<a class='btn-empty cancel'>취소</a>
</div>

<script>
$('.save').click(function(){
	if( emptyCheck() ){
		if( $('[name=field] option:selected').val()==0 ){
			alert( $('[name=field] option:selected').text() );
			$('[name=field]').focus();
		}else{
			$('form').submit();
		}
	}
});
$('.cancel').click(function(){
	location="list.qna";
});
</script>

</body>
</html>
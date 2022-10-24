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
<h3>방명록 수정</h3>
<form method='post' action='update.bo' enctype='multipart/form-data'>
<input type='hidden' name='writer' value='${loginInfo.userid}'>
<table class='w-px1200'>
<tr><th class='w-px140'>제목</th>
	<td><input type='text' class='full chk' value='${vo.title}' name='title' title='제목'></td>
</tr>
<tr><th>내용</th>
	<td><textarea class='full chk' name='content' title='내용'>${vo.content}</textarea></td>
</tr>
<tr><th>첨부파일</th>
	<td class='left'>
		<c:forEach items="${vo.fileInfo}" var='f'>
		<div class='items-center' data-id='${f.id}'>
			<label>
				<input type='file' name='file' class='attach-file'>
				<a><i class="font fa-solid fa-file-circle-plus"></i></a>
			</label>
			<span class='file-name'>${f.filename}</span>
			<a class='delete-file' style='display:inline'><i class="font-r fa-regular fa-trash-can"></i></a>
		</div>
		</c:forEach>
		<div class='items-center'>
			<label>
				<input type='file' name='file' class='attach-file'>
				<a><i class="font fa-solid fa-file-circle-plus"></i></a>
			</label>
			<span class='file-name'></span>
			<a class='delete-file'><i class="font-r fa-regular fa-trash-can"></i></a>
		</div>		
</tr>
</table>
<input type='hidden' name='id' value='${vo.id}'>
<input type='hidden' name='removed'>
</form>

<div class='btnSet'>
	<a class='btn-fill save'>저장</a>
	<a class='btn-empty cancel'>취소</a>
</div>

<script>
$('.cancel').click(function(){
	//history.go(-1);
	$('form').attr('action', 'detail.bo');
	$('form').submit();
});

$('.save').click(function(){
	if( emptyCheck() ) $('form').submit();	
});
</script>
</body>
</html>
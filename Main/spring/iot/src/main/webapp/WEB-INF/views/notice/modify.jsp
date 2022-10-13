<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>공지사항 수정</h3>
<form method='post' action='update.no' enctype='multipart/form-data'>
<input type='hidden' name='id' value='${vo.id}'>
<table class='w-px1200'>
<tr><th class='w-px140'>제목</th>
	<td><input type='text' class='full chk' name='title' title='제목' 
										value='${vo.title}'></td>
</tr>
<tr><th>내용</th>
	<td><textarea class='full chk' name='content' title='내용'>${vo.content}</textarea></td>
</tr>
<tr><th>첨부파일</th>
	<td class='left'>
		<label>
			<input type='file' name='file' multiple  id='attach-file'>
			<a><i class="font fa-solid fa-file-circle-plus"></i></a>
		</label>
		<span id='file-name'>${vo.filename}</span>
		<a id='delete-file' 
			style='display:${empty vo.filename ? "none" : "inline"}'><i class="font-r fa-regular fa-trash-can"></i></a>
	</td>
</tr>
</table>
<input type='hidden' name='filename'>
</form>

<div class='btnSet'>
	<a class='btn-fill' onclick="update()">저장</a>
	<a class='btn-empty' onclick='history.go(-1)'>취소</a>
</div>

<script>
function update(){
	if( emptyCheck() ){ 
		$('[name=filename]').val(  $('#file-name').text() );
		$('form').submit();
	}
}
</script>
</body>
</html>




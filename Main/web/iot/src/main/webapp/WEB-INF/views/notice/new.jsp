<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>공지사항 글쓰기</h3>
<form method='post' action='insert.no' enctype='multipart/form-data'>
<input type='hidden' name='writer' value='${loginInfo.userid}'>
<table class='w-px1200'>
<tr><th class='w-px140'>제목</th>
	<td><input type='text' class='full chk' name='title' title='제목'></td>
</tr>
<tr><th>내용</th>
	<td><textarea class='full chk' name='content' title='내용'></textarea></td>
</tr>
<tr><th>첨부파일</th>
	<td class='left'>
		<label>
			<input type='file' name='file' id='attach-file'>
			<a><i class="font fa-solid fa-file-circle-plus"></i></a>
		</label>
		<span id='file-name'></span>
		<a id='delete-file'><i class="font-r fa-regular fa-trash-can"></i></a>
	</td>
</tr>
</table>
</form>

<div class='btnSet'>
	<a class='btn-fill' onclick="if( emptyCheck() ) $('form').submit()">저장</a>
	<a class='btn-empty' onclick='location="list.no"'>취소</a>
</div>

</body>
</html>
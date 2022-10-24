<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h3{
	text-align: center;
}
table{
	width: 100%
}
textarea {	height: 300px; }

input {
	outline: none;
	border: none;
	border-bottom: 1px solid #d8d8d8;
	margin-bottom: 1%;
	height: 1%;
}

.new_inp{
	width: 80%;
}

.btn_wrap{
	display: flex;
	justify-content: center;
}

button:last-child{
	margin-left: 1%;
}
</style>
</head>
<body>
<h3>고객센터 자주 찾는 질문 글쓰기</h3>
<form method='post' action='insert.cs'>
<input type='hidden' name='cs_writer' value='${loginInfo.userid}'>
<table class='w-px1200'>
<tr class="new_wrap"><th class='w-px140'>제목</th>
	<td><input type='text' class='full chk new_inp' name='cs_title' title='제목'></td>
</tr>
<tr class="new_wrap"><th>내용</th>
	<td><textarea class='full chk new_inp' name='cs_content' title='내용'></textarea></td>
</tr>
<!-- <tr><th>첨부파일</th>
	<td class='left'>
		<div class='items-center'>
			<label>
				<input type='file' name='file' class='attach-file'>
				<a><i class="font fa-solid fa-file-circle-plus"></i></a>
			</label>
			<span class='file-name'></span>
			<a class='delete-file'><i class="font-r fa-regular fa-trash-can"></i></a>
		</div>
</tr> -->
</table>
<div class='btnSet btn_wrap'>
	<button type="submit" class='btn-fill' >저장</button>
	<button type="button" class='btn-empty' onclick='location="list_web.cs"'>취소</button> 
</div>
</form>

</body>
</html>
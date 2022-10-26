<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.new-table th, .new-table td {
	border: 0px !important;
}
.new-input {
    outline: none;
    border: 0px;
    background-color: #f1f1f1;
    border-radius: 15px;
}
.new-select {
    border-style: none;
    width: 200px;
}

</style>
</head>
<body>
<h3>1:1 문의하기</h3>
<form method='post' action='insert_web.qa' enctype='multipart/form-data'>
<input type='hidden' name='writer' value='${loginInfo.email}'>
<table class='w-px1200 new-table'>
<tr>
	<td class='w-px140'><input type='text' class='full chk new-input' name='title' title='제목' placeholder="제목" style="color: #d8d8d8;"></td>
</tr>
<tr>
	<td><select class='w-pct100' name='field'>
		<option value='0'>카테고리</option>
		<c:forEach items="${fields}" var='f'>
		<option value='${f.id}'>${f.title}</option>
		</c:forEach>
		</select>
	</td>
</tr>
<tr>
	<td class='left'>
		<label><input type='radio' name='open' value='0'>공개</label>
		<label><input type='radio' name='open' value='1' checked>비공개</label>
	</td>
</tr>
<tr>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>고객정보수정</h3>
<form method='post' action='update.cu'>
<input type='hidden' name='id' value='${vo.id}'>
<table class='w-px600'>
<tr><th class='w-px140'>고객명</th>
	<td>${vo.name}</td>
</tr>
<tr><th>성별</th>
	<td><label><input type='radio' name='gender' 
				${vo.gender eq '남' ? 'checked' : ''} value='남'>남</label>
		<label><input type='radio' name='gender' 
				<c:if test='${vo.gender eq "여"}'>checked</c:if> value='여'>여</label>
	</td>
</tr>
<tr><th>이메일</th>
	<td><input type='text' name='email' value='${vo.email}'></td>
</tr>
<tr><th>전화번호</th>
	<td><input type='text' name='phone' maxlength="13" value='${vo.phone}'></td>
</tr>
</table>
</form>
<div class='btnSet'>
	<a class='btn-fill' onclick='$("form").submit()'>저장</a>
	<a class='btn-empty' href='javascript:history.go(-1)'>취소</a>
<%-- 	<a class='btn-empty' href='detail.cu?id=${vo.id}'>취소</a> --%>
</div>
</body>
</html>
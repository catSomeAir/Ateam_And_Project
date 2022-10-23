<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table tr td { text-align: left; }
</style>
</head>
<body>
<h3>신입사원등록</h3>
<form method='post' action='insert.hr'>
<table class='w-px600'>
<tr><th class='w-px140'>성명</th>
	<td><input type='text' class='w-px140' name='last_name' placeholder="성">
		<input type='text' class='w-px140' name='first_name' placeholder="명">
	</td>
</tr>
<tr><th>부서명</th>
	<td><select name='department_id' class='w-px300'>
			<option value='-1'>소속없음</option>
			<c:forEach items='${departments}' var='d'>
			<option value='${d.department_id}'>${d.department_name}</option>
			</c:forEach>
		</select>
	</td>
</tr>
<tr><th>업무</th>
	<td><select name='job_id' class='w-px300'>
			<c:forEach items='${jobs}' var='j'>
			<option value='${j.job_id}'>${j.job_title}</option>
			</c:forEach>
		</select>
	</td>
</tr>
<tr><th>매니저</th>
	<td><select name='manager_id' class='w-px300'>
			<option value='-1'>관리자선택</option>
			<c:forEach items='${managers}' var='m'>
			<option value='${m.employee_id}'>${m.name}</option>
			</c:forEach>
		</select>
	</td>
</tr>
<tr><th>이메일</th>
	<td><input type='text' name='email'></td>
</tr>
<tr><th>전화번호</th>
	<td><input type='text' name='phone_number'></td>
</tr>
<tr><th>급여</th>
	<td><input type='text' name='salary'></td>
</tr>
<tr><th>입사일자</th>
	<td><input type='text' name='hire_date' class='date'></td>
</tr>
</table>
</form>
<div class='btnSet'>
	<a class='btn-fill' onclick="$('form').submit()">저장</a>
	<a class='btn-empty' onclick='location="list.hr"'>취소</a>
</div>

<script>
var today = new Date();
var range = today.getFullYear()-50 + ':' + today.getFullYear();
$(function(){
	$('.date').datepicker({
		maxDate: today,
		yearRange: range,
	});
	$('[name=hire_date]').val( $.datepicker.formatDate('yy-mm-dd', today) );
});
</script>
</body>
</html>
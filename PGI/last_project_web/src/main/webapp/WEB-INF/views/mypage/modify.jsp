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
<h3>사원정보 수정</h3>
<form method='post' action='update.hr'>
<table class='w-px600'>
<tr><th class='w-px140'>사번</th>
	<td>${vo.employee_id}</td>
</tr>
<tr><th>성명</th>
	<td><input type='text' name='last_name' class='w-px120' value='${vo.last_name}'>
		<input type='text' name='first_name' class='w-px120' value='${vo.first_name}'>
	</td>
</tr>
<tr><th>부서명</th>
	<td><select name='department_id' class='w-px200'>
			<option value='-1'>소속없음</option>
			<c:forEach items="${departments}" var="d">
			<option ${d.department_id eq vo.department_id ? 'selected' : ''}  
				value='${d.department_id}'>${d.department_name}</option>
			</c:forEach>
		</select>
	</td>
</tr>
<tr><th>업무제목</th>
	<td><select class='w-px200' name='job_id'>
			<c:forEach items='${jobs}' var='j'>
			<option ${vo.job_id eq j.job_id ? 'selected' : ''} value='${j.job_id}'>${j.job_title}</option>
			</c:forEach>
		</select>
	</td>
</tr>
<tr><th>이메일</th>
	<td><input type='text' name='email' value='${vo.email}'></td>
</tr>
<tr><th>전화번호</th>
	<td><input type='text' name='phone_number' value='${vo.phone_number}'></td>
</tr>
<tr><th>급여</th>
	<td><input type='text' name='salary' value='${vo.salary}'></td>
</tr>
<tr><th>입사일자</th>
	<td><input type='text' name='hire_date' class='date' value='${vo.hire_date}'></td>
</tr>
</table>
<input type='hidden' name='employee_id' value='${vo.employee_id}'>
</form>
<div class='btnSet'>
	<a class='btn-fill' onclick='$("form").submit()'>저장</a>
	<a class='btn-empty' href='detail.hr?id=${vo.employee_id}'>취소</a>
</div>

<script type="text/javascript">
$(function(){
	$('.date').datepicker();
	$.datepicker.setDefaults( { maxDate:new Date() } );
})

</script>
</body>
</html>
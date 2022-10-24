<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>사원정보</h3>
<table class='w-px600'>
<tr><th class='w-px140'>사번</th>
	<td>${vo.employee_id}</td>
</tr>
<tr><th>성명</th>
	<td>${vo.last_name} ${vo.first_name}</td>
</tr>
<tr><th>부서명</th>
	<td>${vo.department_name}</td>
</tr>
<tr><th>업무제목</th>
	<td>${vo.job_title }</td>
</tr>
<tr><th>이메일</th>
	<td>${vo.email }</td>
</tr>
<tr><th>전화번호</th>
	<td>${vo.phone_number }</td>
</tr>
<tr><th>급여</th>
	<td><fmt:formatNumber value='${vo.salary }'/> </td>
</tr>
<tr><th>입사일자</th>
	<td>${vo.hire_date }</td>
</tr>
</table>
<div class='btnSet'>
	<a href='list.hr' class='btn-fill'>사원목록</a>
	<a href='modify.hr?id=${vo.employee_id}' class='btn-fill'>정보수정</a>
	<a onclick="if( confirm('사원 [${vo.last_name} ${vo.first_name}] 삭제?') ) href='delete.hr?id=${vo.employee_id}'" class='btn-fill'>정보삭제</a>
</div>

</body>
</html>
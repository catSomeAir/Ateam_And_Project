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
<h3>고객목록</h3>

<div id='list-top'>
<ul><li><a class='btn-fill' href='new.cu'>신규고객</a></li>
</ul>
</div>

<table class='w-px600 tb-list'>
<thead>
	<tr><th class='w-px140'>고객명</th><th>전화번호</th></tr>
</thead>
<tbody>
<c:forEach items="${list}" var="vo">
	<tr>
		<td><a href='detail.cu?id=${vo.id}'>${vo.name}</a></td>
		<td>${vo.phone}</td>
	</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>
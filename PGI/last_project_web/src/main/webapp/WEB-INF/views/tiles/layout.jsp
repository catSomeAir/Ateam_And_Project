<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix='tiles' %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix='c'%>

<c:choose>
	<c:when test="${category eq 'no'}"><c:set var='title' value='- 공지사항'/></c:when>
	<c:when test="${category eq 'my'}"><c:set var='title' value='- 마이페이지'/></c:when>
	<c:when test="${category eq 'ev'}"><c:set var='title' value='- 이벤트'/></c:when>
	<%-- <c:when test="${category eq 'hr'}"><c:set var='title' value='- 사원관리'/></c:when> --%>
	<c:when test="${category eq 'cs'}"><c:set var='title' value='- 고객센터'/></c:when>
	<c:when test="${category eq 'ch'}"><c:set var='title' value='- 채팅서비스'/></c:when>
	<c:when test="${category eq 'ad'}"><c:set var='title' value='- 관리자메뉴'/></c:when>

<%-- 	<c:when test="${category eq 'bo'}"><c:set var='title' value='- 방명록'/></c:when>
	<c:when test="${category eq 'da'}"><c:set var='title' value='- 공공데이터'/></c:when>
	<c:when test="${category eq 'vi'}"><c:set var='title' value='- 시각화'/></c:when>
 --%>	
 <c:when test="${category eq 'join'}"><c:set var='title' value='- 회원가입'/></c:when>
</c:choose>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 설명서 ${title}</title>
<link rel='stylesheet' type='text/css' 
	href='css/common.css?<%=new java.util.Date()%>'>
<link rel='stylesheet' type='text/css' href='css/member.css?<%=new java.util.Date()%>'>
	
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css'>
<link rel='icon' type='image/x-icon' href='img/hanul.ico'>
	
<script src='https://code.jquery.com/jquery-3.6.0.min.js'></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/js/all.min.js'></script>
<script src='js/common.js?<%=new java.util.Date()%>'></script>
</head>
<body>
<tiles:insertAttribute name='header'/>
<div id='container'>
<tiles:insertAttribute name='container' ignore="true"/>
</div>
<tiles:insertAttribute name='footer'/>

</body>
</html>
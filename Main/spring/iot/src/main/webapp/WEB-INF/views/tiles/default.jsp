<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
<c:when test="${category eq 'login'}"><c:set var='title' value='- 로그인'/></c:when>
</c:choose>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지능형 IoT ${title}</title>
<link rel='icon' type='image/x-icon' href='img/hanul.ico'>
<link rel='stylesheet' type='text/css' href='css/common.css?<%=new java.util.Date()%>'>
<link rel='stylesheet' type='text/css' href='css/member.css?<%=new java.util.Date()%>'>

<script type='text/javascript' src='https://code.jquery.com/jquery-3.6.0.min.js'></script>
<script type='text/javascript' src='js/common.js?<%=new java.util.Date()%>'></script>
</head>
<body>
<div id='container'>
<tiles:insertAttribute name='container'/>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/common.css" >
<title>Insert title here</title>
<style>
.more { margin: 0 auto; display:flex; flex-direction: column; }
.more ul { display: flex; }
.more ul li:not(:first-child) { margin-left: 5px }

#qa-list-top{
	display: flex;
}

#qa-list-top ul{
	display: flex;
}	
.qa-btn-li{
	width: 8%;
	height: 40px;
	
}

.a-ain{
	width: 25%;
	height: 35px;
	padding: 6% 20%;
}


.dataTable-info{
	display: none !important;
}

</style>
</head>
<body>
<h3>문의글 목록</h3>
<div id="help-wrap">	
	<form method='post' action='list_web.qa' >
		<div class='w-pct100 more'>
			<ul>
				<li>
					<select class='w-px200' name='field'>
					<option value='0'>구분</option>
					<c:forEach items="${fields}" var='f'>
					<option value='${f.id}'>${f.title}</option>
					</c:forEach>
					</select>
				</li>
			</ul>
		</div>
		<div id='qa-list-top'>
			<ul class="list-top-ul">
				<li><select class='w-px100' name='search'>
					<option value='all'  ${page.search eq 'all' ? 'selected' : ''} >전체</option>
					<option value='title'  ${page.search eq 'title' ? 'selected' : ''}>제목</option>
					<option value='writer'  ${page.search eq 'writer' ? 'selected' : ''}>작성자</option>
					</select>
				</li>
				<li><input type='text' name='keyword' value='${page.keyword}' class='w-px300'></li>
				<li class="qa-btn-li"><a style="width: 20%; height: 35px;"  class='btn-fill-ain a-ain search'>검색</a></li>
			</ul>
			<ul class="list-top-ul">
				<li>
					<select name='pageList' class='w-px100'>
					<c:forEach var='i' begin="1" end='5' >
						<option value='${10*i}'>${10*i}개씩</option>
					</c:forEach>
					</select>
				</li>
				<!-- 로그인한 경우만 글쓰게 버튼 활성화 -->
				<c:if test="${not empty loginInfo}">
					<li class="qa-btn-li">
						<a style="width: 20%; height: 35px;"  class='btn-fill-ain a-ain new' >글쓰기</a>
					</li>
				</c:if>
			</ul>
		</div>
		<input type='hidden' name='id'>
		<input type='hidden' name='curPage' value='1'>
		<input type='hidden' name='read' value='0'>
	</form>
</div>
<table class='tb-list w-px1200'>
<colgroup>
	<col width='100px'>
	<col>
	<col width='80px'>
	<col width='120px'>
	<col width='120px'>
	<col width='80px'>
</colgroup>
<tr><th>번호</th>
	<th>제목</th>
	<th>처리상태</th>
	<th>작성자</th>
	<th>작성일자</th>
	<th>조회수</th>
</tr>
<c:if test="${empty page.qnaList}">
<tr><td colspan='6'>질문과 답변 자료가 없습니다</td>
</c:if>

<c:forEach items="${page.qnaList}" var='vo'>
<tr><td>${vo.no}</td>
	<td class='left'>
		<c:if test='${vo.open eq 1}'><i class="fa-solid fa-lock"></i></c:if>
		<c:choose>
			<c:when test='${loginInfo.email eq vo.writer or loginInfo.admin eq "Y"}'>
				<a onclick='detail(${vo.id})'>${vo.title}</a>
			</c:when>
			<c:otherwise>
				<c:if test='${vo.open eq 0}'>
					<a onclick='detail(${vo.id})'>${vo.title}</a>
				</c:if>
				<c:if test='${vo.open eq 1}'>${vo.title}</c:if>
			</c:otherwise>
		</c:choose>
	</td>
	<td>${vo.status}</td>
	<td>${vo.name}</td>
	<td>${vo.writedate}</td>
	<td>${vo.readcnt}</td>
</tr>
</c:forEach>
</table>

<div class='btnSet'>
	<jsp:include page="/WEB-INF/views/include/page.jsp"/>
</div>
<script>
	$('[name=field]').val( ${field} ).prop( 'selected', true );
	$('[name=open][value=${open}]').prop( 'checked', true );
	
	$('.new').click(function(){
		if( ${empty loginInfo} ){
			alert('로그인 후 이용가능합니다');
			location.href='login_web'
		}else{
			location.href='new_web.qa'
		}
	});
	$('[name=pageList]').val( ${page.pageList} ).prop( 'selected', true );
	
	$('[name=pageList], [name=open], [name=field]').change(function(){
		$('form').submit();
	});
	
	$('.search').click(function(){
		$('form').submit();
	});
	
	function detail( id ){
		$('[name=id]').val( id );
		$('[name=read]').val( 1 );
		$('form').attr('action', 'detail_web.qa');
		$("form").submit();
	}
</script>
</body>
</html>








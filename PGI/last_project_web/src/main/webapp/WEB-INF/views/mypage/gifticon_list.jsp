<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
  background: #f5f5f5
}

table {
   border: 1px #a39485 solid; 
  font-size: .9em;
  box-shadow: 0 2px 5px rgba(0,0,0,.25);
  width: 80%;
  border-collapse: collapse;
  border-radius: 5px;
  overflow: hidden;
}

th {
  text-align: center;
}
  
thead {
  font-weight: bold;
  color: #fff;
  background: #73685d;
}
  
 td, th {
  padding: 1em .5em;
  vertical-align: middle;
}
  
 td {
  border-bottom: 1px solid rgba(0,0,0,.1);
  background: #fff;
}

a {
  color: #73685d;
}
  
 @media all and (max-width: 768px) {
    
  table, thead, tbody, th, td, tr {
    display: block;
  }
  
  th {
    text-align: right;
  }
  
  table {
    position: relative; 
    padding-bottom: 0;
    border: none;
    box-shadow: 0 0 10px rgba(0,0,0,.2);
  }
  
  thead {
    float: left;
    white-space: nowrap;
  }
  
  tbody {
    overflow-x: auto;
    overflow-y: hidden;
    position: relative;
    white-space: nowrap;
  }
  
  tr {
    display: inline-block;
    vertical-align: top;
  }
  
  th {
    border-bottom: 1px solid #a39485;
     border-left: 1px solid #e5e5e5;
  }
  
  td {
    border-bottom: 1px solid #e5e5e5;
    border-left: 1px solid #e5e5e5;
  }
  
   th:first-child, td:first-child {
    border-left: none;
  }
</style>
</head>
<body>
<h3 style="font-size:2rem;">기프티콘 사용 내역</h3>
<br/>
<form method='post' action='list.no'>
<input type='hidden' name='curPage' value='1'>
<div id='list-top' class='w-px1200'>
	<ul>
		<!-- 관리자로 로그인한 경우만 글쓰기 가능 -->
		<c:if test='${ loginInfo.admin eq "Y" }'>
		<li><a class='btn-fill' href='new.no'>글쓰기</a></li>
		</c:if>
	</ul>
</div>
</form>
<table class='tb-list w-px1200'>
<colgroup>
	<col width='100px'>
	<col>
	<col width='120px'>
</colgroup>
<tr><th>번호</th>
	<th>사용 내역</th>
	<th>사용일자</th>
</tr>
<c:forEach items='${page.list}' var='vo'>
<tr><td>${vo.no}</td>
	<td class='left'>
	<c:forEach var='i' begin="1" end="${vo.indent}">
		${i eq vo.indent ? '&nbsp;&nbsp;<i class="font fa-regular fa-comment-dots"></i>' 
						 : '&nbsp;&nbsp;'  }
	</c:forEach>
		<a href='detail.no?id=${vo.id}'>${vo.title}</a></td>
	<td>${vo.name}</td>
	<td>${vo.writedate}</td>
	<td>${empty vo.filename ? '' : '<i class="font fa-solid fa-paperclip"></i>'}</td>
</tr>
</c:forEach>
</table>
<div class='btnSet'>
	<jsp:include page="/WEB-INF/views/include/page.jsp"/>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix='fn' %>  
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/css/common.css" >
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table th, table td{
	border: 0px;
}
h3{
	text-align: center;
}
/* li 태그 ● 없애기 */
li {
	list-style: none;
}

/* input 테두리 없애기 */
input:focus {
	outline: none;
}

input {
	border: 0px; 
	border-bottom: 1px solid #d8d8d8;
}
#list_ul_wrap{
	display: flex;
	justify-content: center;
	width: 100%;
}

#list_ul {
	padding: 1%;
	border: 1px solid #ebebeb;
	border-radius: 50px;
	display: flex;
	width: 40%;
	justify-content: space-evenly;
}

#list_li{
	border: 0px;
}

table th {
	padding: 15px 25px;
}

#cs_detail_wrap {
	display: flex;
	flex-direction: column;
	align-content: flex-start;
	align-items: center;
	flex-wrap: nowrap;
	justify-content: center;
}

#cs_t_wrap{
	width: 90%;
	height: 20%;
	margin-top: 5%;
	justify-content: center;
}

#cs_title{
	width: 80%;
	font-size: 150%;
	margin: 0 auto;
	margin-bottom: 5%;
}

#cs_c_wrap{
	width: 90%;
	height: 100%;
	justify-content: center;
	margin-top: 5%;
}

#cs_con{
	width: 80%;
	margin: 0 auto;
	font-size: 120%;
	text-align: left;
}

</style>
</head>
<body>
<div id="list_ul_wrap">
		<ul id="list_ul">
			 <li class="list_li">
				<select class='w-px100 search_select' name='search'>
				<option value='all'  ${page.search eq 'all' ? 'selected' : ''} >카테고리</option>
				<option value='title'  ${page.search eq 'cs_title' ? 'selected' : ''}>제목</option>
				<option value='content'  ${page.search eq 'cs_content' ? 'selected' : ''}>내용</option>
				<option value='t_c'  ${page.search eq 't_c' ? 'selected' : ''}>제목+내용</option>
				<option value='writer'  ${page.search eq 'cs_writer' ? 'selected' : ''}>작성자</option>
				</select>
			</li> 
			<li class="in_keyword"><input type='text' name='keyword' value='${page.keyword}' class='w-px300 search-input'></li>
			<li class="li_search"><a class='search'  onclick='$("form").submit()'>검색</a></li>
		</ul>
	</div>
	<div id="cs_detail_wrap">
		<ul id="cs_t_wrap"> 
			<li id="cs_title">${vo.cs_title}</li>
			<li id="cs_con">${vo.cs_content}</li>
		</ul>
	</div>
<div class='btnSet'>
	<a class='btn-fill list'>목록</a>
	
</div>
<form method='post' action='list.cs'>
	<input type='hidden' name='curPage' value='${page.curPage}' >
	<input type='hidden' name=search value='${page.search}' >
	<input type='hidden' name=pageList value='${page.pageList}' >
	<input type='hidden' name='keyword' value='${page.keyword}' >
	<input type='hidden' name='id' value='${vo.id}' >
</form>

<script>

//목록화면으로
$('.list').click(function(){
	$('form').submit();
});

//수정화면으로
$('.change').click(function(){
	$('form').attr('action', 'modify.cs');
	$('form').submit();
});

//삭제
$('.remove').click(function(){
	if( confirm('정말 삭제?') ){
		$('form').attr('action', 'delete.cs');
		$('form').submit();
	}
});

</script>
</body>
</html>
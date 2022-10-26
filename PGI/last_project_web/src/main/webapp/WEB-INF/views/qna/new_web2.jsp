<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

#new-outwrap{
	display: flex;
	width: 100%;
	flex-direction: column;
	flex-wrap: nowrap;
	justify-content: center;
	align-items: center;
}

#new-inwrap{
	display: flex;
	flex-direction: column;
	flex-wrap: nowrap;
	justify-content: center;
	align-items: center;
	width: 1200px;
}

#new-div{
	display: flex;
	justify-content: space-between;
	width: 1200px;
	background-color: #f1f1f1;
	height: 42px;
	align-items: center;
	color: #595858;
	border-radius: 10px;
}
.new-ul {
	border: 0px !important;
}
.new-input {
    outline: none;
    border: 0px;
    background-color: #ffffff00;
    /* border-radius: 15px; */
    width: 750px;
    color: #000000;
}
input{
	color: #123;
}
input::placeholder{
	color: #a1a1a1;
	font-size: 16px;
}
.new-select {
    border-style: none;
    width: 160px;
    color:  #595858;
    text-align: center;
}

.new-ul-catg{
	display: flex;
}
.new-ul-li{
	width: 1200px;
}

.li-title{
	width: 800px;

}

.new-li-catg{
	width: 200px;
}
.new-select{
	border: 0px !important;
	background-color: #ffffff00;
}

.new-txt{
	width: 1160px;
	border: 0px;
	background-color: #f1f1f1;
	border-radius: 10px;
	padding: 20px;
	padding-left: 20px;
	
}
</style>
</head>
<body>
<h3>1:1 문의하기</h3>
<form method='post' action='insert_web.qa' enctype='multipart/form-data'>
<input type='hidden' name='writer' value='${loginInfo.email}'>
<div id="new-outwrap">
	<div id="new-inwrap">
		<div id="new-div">
		<ul class='new-ul'>
			<li class='li-title'>
				<input type='text' class='full chk new-input' name='title' title='제목' placeholder="제목" style="color: #000000;">
			</li>
		</ul>
		<ul class='w-px400 new-ul-catg'>
			<li class='new-li-catg'>
				<select class='w-pct100 new-select' name='field'>
				<option value='0'>카테고리</option>
				<c:forEach items="${fields}" var='f'>
				<option value='${f.id}'>${f.title}</option>
				</c:forEach>
				</select>
			</li>
			<li class='left' style="width: 400px;">
				<label><input type='radio' name='open' value='0'>공개</label>
				<label><input type='radio' name='open' value='1' checked>비공개</label>
			</li>
		</ul>
		</div>
		<ul>
			<li class="new-ul-li">
				<textarea class='full chk new-txt' name='content' title='내용'></textarea>
			</li>
		</ul>
	</div>
</div>
</form>

<div class='btnSet'>
	<a class='btn-fill save'>저장</a>
	<a class='btn-empty cancel'>취소</a>
</div>

<script>
$('.save').click(function(){
	if( emptyCheck() ){
		if( $('[name=field] option:selected').val()==0 ){
			alert( $('[name=field] option:selected').text() );
			$('[name=field]').focus();
		}else{
			$('form').submit();
		}
	}
});
$('.cancel').click(function(){
	location="list.qna";
});
</script>

</body>
</html>
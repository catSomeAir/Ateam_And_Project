<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix='fn' %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table td { text-align: left }
#comment { width: 97%; height: 60px; margin-top: 5px}
</style>
</head>
<body>
<h3>방명록 안내</h3>
<table class='w-px1200'>
<tr><th class='w-px140'>제목</th>
	<td colspan='5'>${vo.title}</td>
</tr>
<tr><th>작성자</th>
	<td>${vo.name}</td>
	<th class='w-px120'>작성일자</th>
	<td class='w-px120'>${vo.writedate}</td>
	<th class='w-px120'>조회수</th>
	<td class='w-px100'>${vo.readcnt}</td>
</tr>
<tr><th>내용</th>
	<td colspan='5'>${fn: replace(vo.content, crlf, '<br>')}</td>
</tr>
<tr><th>첨부파일</th>
	<td colspan='5'>
		<c:forEach items="${vo.fileInfo}" var='f'>
		<div class='items-center'>
			<span>${f.filename}</span>
			<a class='preview'></a>
			<a href='download.bo?id=${f.id}'>
				<i class="font-b fa-solid fa-file-arrow-down"></i></a>
		</div>
		</c:forEach>
	</td>
</tr>
</table>

<div class='btnSet'>
	<a class='btn-fill list'>목록</a>
	<!-- 로그인한 사용자가 작성한 글에 대해 수정/삭제 가능 -->
	<c:if test='${loginInfo.userid eq vo.writer}'>
	<a class='btn-fill change'>수정</a>
	<a class='btn-fill remove'>삭제</a>
	</c:if>
</div>

<div class='w-px600' style='margin: 0 auto'>
	<div id='comment-regist'>
		<div style='display: flex; justify-content: space-between;'>
			<span>댓글작성</span>
			<a class='btn-fill-s regist'>댓글등록</a>
		</div>
		<textarea id='comment'></textarea>
	</div>
</div>
<div id='comment-list' class="w-px600 left" style='margin: 0 auto'></div>

<div id='popup-background'></div>
<div id='popup' class='center'></div>

<form method='post' action='list.bo'>
	<input type='hidden' name='curPage' value='${page.curPage}' >
	<input type='hidden' name=search value='${page.search}' >
	<input type='hidden' name=pageList value='${page.pageList}' >
	<input type='hidden' name=viewType value='${page.viewType}' >
	<input type='hidden' name='keyword' value='${page.keyword}' >
	<input type='hidden' name='id' value='${vo.id}' >
</form>

<script>

//댓글등록
$('.regist').click(function(){
	if( ${empty loginInfo} ){
		alert('댓글을 등록하려면 로그인하세요');
	}else if( $('#comment').val()==''  ){
		alert('댓글을 입력하세요');
		$('#comment').focus();
	}else{
		$.ajax({
			url: 'board/comment/insert',
			data: { board_id:${vo.id}, content:$('#comment').val()
										, writer:'${loginInfo.userid}' },
			success: function( response ){
				if( response ){
					alert('댓글이 저장되었습니다');
					$('#comment').val('');
					comment_list();
				}else
					alert('댓글 저장 실패ㅠㅠ');
				
			},error: function(req, text){
				alert(text+':'+req.status);
			}
		});		
	}
});

comment_list();

//댓글목록조회
function comment_list(){
	$.ajax({
		url:'board/comment/list/${vo.id}',
// 		data: { board_id:${vo.id} },
		success: function( response ){
			$('#comment-list').html( response );
			
		},error: function(req,text){
			alert(text+':'+req.status);
		}
	});
}



$(document).on('click', '.preview img', function(){
	$('#popup, #popup-background').css('display', 'block');
	//클릭한 이미지를 복제해서 popup 안에 넣기
	$('#popup').append( $(this).clone() );
});

$('#popup-background').click(function(){
	$('#popup, #popup-background').css('display', 'none');
	//$('#popup img').remove();  //복제해 보여졌던 태그 삭제
	$('#popup').empty();	  //popup 내부를 비우기
});

//목록화면으로
$('.list').click(function(){
	$('form').submit();
});
//수정화면으로
$('.change').click(function(){
	$('form').attr('action', 'modify.bo');
	$('form').submit();
});
//삭제
$('.remove').click(function(){
	if( confirm('정말 삭제?') ){
		$('form').attr('action', 'delete.bo');
		$('form').submit();
	}
});

$(window).resize(function(){
	center( $('#popup'), $('#popup-background') );
});
$(window).scroll(function(){
	center( $('#popup'), $('#popup-background') );
})


var files = [];
<c:forEach items="${vo.fileInfo}" var='f'>
files.push( new Array( '${f.filename}', '${f.filepath}' ) );
</c:forEach>
for(var i=0; i<files.length; i++){
	if( isImage( files[i][0] ) ){
		$('.preview').eq(i).append( '<img src="'+ files[i][1] +'">' );
	}
}











</script>



</body>
</html>
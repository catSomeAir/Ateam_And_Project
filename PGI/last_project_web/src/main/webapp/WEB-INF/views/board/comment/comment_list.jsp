<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix='fn'%>
<style>
.view { width:100%; margin-top: 5px;  }
.modify { width: 100%; display: none; margin-top: 5px; padding:0;  }
</style>

<c:forEach items='${list}' var='vo' varStatus='status'>
${status.first ? '<hr>' : ''}
<div data-id='${vo.id}'>${vo.name} [ ${vo.writedate} ]
	<!-- 로그인한 사용자가 작성한 댓글에 대해서는 수정/삭제 가능 -->
	<c:if test='${loginInfo.userid eq vo.writer}'>
	<span style='float: right;'>
		<a class='btn-fill-s btn-modify-save'>수정</a>
		<a class='btn-fill-s btn-delete-cancel'>삭제</a>
	</span>
	</c:if>
	<div class='view'>${fn: replace(  fn:replace(vo.content, lf, '<br>')  , crlf, '<br>')}</div>
	<textarea class='modify'></textarea>
</div>
<hr>
</c:forEach>

<script>
$('.btn-delete-cancel').click(function(){
	var $div = $(this).closest('div');
	if( $(this).text()=='취소' ){
		display( $div, true ); //보기상태
	}else{
		if( confirm('정말 삭제?') ){
			$.ajax({
				url: 'board/comment/delete/'+ $div.data('id'),
				success: function(){
					comment_list();
				}
			});
		}
	}
});

$('.btn-modify-save').click(function(){
	var $div = $(this).closest('div');
	if( $(this).text()=='수정' ){
		$div.children('.modify').val( $div.children('.view').html()
													.replace( /<br>/g, '\n' ) );
		$div.children('.modify').css('height', $div.children('.view').height()-2.5 );
		
		display( $div, false ); //수정상태
		
	}else{
		
		var comment
		= JSON.stringify({ id: $div.data('id')
					, content: $div.children('.modify').val() });
		$.ajax({
			type: 'post',
			contentType: 'application/json',
			url: 'board/comment/update',
			//data: { id: $div.data('id'), content: $div.children('.modify').val() },
			data: comment,
			success: function( response ){
				alert( "댓글변경 " + response );
				comment_list();
				
			},error: function(req,text){
				alert(text+':'+req.status);
			}
		});
		
	}
});

function display( $div, status ){
	$div.children('.view').css('display', status ? 'block' : 'none');
	$div.children('.modify').css('display', status ? 'none' : 'block');
	//수정상태 - 저장/취소버튼
	$div.find('.btn-modify-save').text( status ? '수정' : '저장' );
	$div.find('.btn-delete-cancel').text( status ? '삭제' : '취소' );
	//보기상태 - 수정/삭제버튼
	
	
}



</script>



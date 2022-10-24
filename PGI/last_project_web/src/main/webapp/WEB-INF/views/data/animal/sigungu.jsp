<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<li>
	<select id='sigungu' class='w-px140'>
		<option value=''>시군구선택</option>
		<c:forEach items='${list.item}' var='vo'>
		<option value='${vo.orgCd}'>${vo.orgdownNm}</option>
		</c:forEach>
	</select>
</li>
<script>
$('#sigungu').change(function(){
	animal_shelter();
	animal_list( 1 );
});
function animal_shelter(){
	$('#shelter').closest('li').remove(); //이전 보호소태그 삭제
	if( $('#sigungu').val()=='' ) return; 
	
	$.ajax({
		url: 'data/animal/shelter',
		data: { sido:$('#sido').val(), sigungu:$('#sigungu').val()  },
		success: function( response ){
			$('#sigungu').closest('li').after( response );			
		}
	});
	
	
}
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<li>    
	<select id='sido' class='w-px160'>
		<option value=''>시도선택</option>
		<c:forEach items='${list.item}' var='vo'>
		<option value='${vo.orgCd}'>${vo.orgdownNm}</option>
		</c:forEach>
	</select>
</li>
<script>
$('#sido').change(function(){
	animal_sigungu();
	animal_list( 1 );
});
function animal_sigungu(){
	$('#sigungu').closest('li').remove(); //이전 시군구태그 삭제
	$('#shelter').closest('li').remove(); //이전 보호소태그 삭제
	//시도선택 을 클릭한 경우는 해당 시군구가 없으므로 조회하지 않는다
	if( $('#sido').val()=='' ) return;
	
	$.ajax({
		url: 'data/animal/sigungu',
		data: { sido: $('#sido').val() },
		success: function( response ){
			$('#sido').closest('li').after( response );
		}
	});
}
</script>
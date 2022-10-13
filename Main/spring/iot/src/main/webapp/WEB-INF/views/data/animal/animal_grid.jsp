<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<ul class='grid animal'>
<c:if test='${empty list.item}'>
	<li style='width:100%; height:40px !important; padding-top:7px; margin-right:0;'>해당 유기동물이 없습니다</li>
</c:if>

<c:forEach items='${list.item}' var='vo'>
	<li
		data-popfile='${vo.popfile}'
		data-sexcd='${vo.sexCd}'
		data-age='${vo.age}'
		data-weight='${vo.weight}'
		data-colorcd='${vo.colorCd}'
		data-happendt='${vo.happenDt}'
		data-specialmark='${vo.specialMark}'
		data-happenplace='${vo.happenPlace}'
		data-processstate='${vo.processState}'
		data-carenm='${vo.careNm}'
		data-careaddr='${vo.careAddr}'
		data-caretel='${vo.careTel}'
	>
		<div class='info'>
			<div><img src='${vo.popfile}'></div>
			<div>
				<span>${vo.age}</span>
				<span>${vo.sexCd}</span>
			</div>
			<div>${vo.weight}</div>
			<div>${vo.colorCd}</div>
			<div>${vo.processState}</div>
		</div>
		<div class='care'>
			<span>${vo.careNm}</span>
			<span>${vo.happenDt}</span>
		</div>
	</li>
</c:forEach>
</ul>
<script>
makePage(${list.count}, ${pageNo});
</script>
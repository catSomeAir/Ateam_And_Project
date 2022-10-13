<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>     
<!DOCTYPE html>
<div class='page-list'>
	<!-- 첫블럭이 아닌 경우 -->
	<c:if test='${page.curBlock gt 1}'>
	<!-- 첫 페이지 -->
	<a onclick='page(1)'><i class="fa-solid fa-angles-left"></i></a>
	<!-- 이전 블럭 -->
	<a onclick='page(${page.beginPage-page.blockPage})'><i class="fa-solid fa-angle-left"></i></a>
	</c:if>

	<c:forEach var='no' begin='${page.beginPage}' end='${page.endPage}'>
	<c:choose>
		<c:when test="${page.curPage eq no}"><span>${ no }</span></c:when>
	 	<c:otherwise><a onclick='page( ${no} )'>${ no }</a></c:otherwise>
	</c:choose>
	</c:forEach>
	
	<!-- 마지막블럭이 아닌 경우 -->
	<c:if test='${page.curBlock lt page.totalBlock}'>
	<!-- 다음블럭 -->
	<a onclick='page(${page.endPage+1})'><i class="fa-solid fa-angle-right"></i></a>
	<!-- 마지막페이지 -->
	<a onclick='page(${page.totalPage})'><i class="fa-solid fa-angles-right"></i></a>
	</c:if>
</div>

<script>
function page(no){
	$('[name=curPage]').val( no );
	$('form').submit();
}
</script>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>

<head>
<title>Home</title>

<!-- 검색창  -->
<style type="text/css">
@import url(https://fonts.googleapis.com/css?family=Open+Sans);

body {
	background: #f2f2f2;
	font-family: 'Open Sans', sans-serif;
}

.ellipsis {
  width: 200px;
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
}

.search {
 width: 100%;
  position: relative;
  display: flex;
}

.searchTerm {
  width: 100%;
  border: 3px solid #020E20;
  border-right: none;
  padding: 5px;
  height: 20px;
  border-radius: 5px 0 0 5px;
  outline: none;
  color: #9DBFAF;
}

.searchTerm:focus {
	color: #020E20;
}

.searchButton {
  width: 40px;
  height: 36px;
  border: 1px solid #020E20;
  background: #020E20;
  text-align: center;
  color: #fff;
  border-radius: 0 5px 5px 0;
  cursor: pointer;
  font-size: 20px;
}

/*Resize the wrap to see the search bar change!*/
.wrap {
	margin: 0px auto;
	width: 30%;
	/*   position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%); */
}
</style>

<!-- 목록  -->
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

body {
	background-color: #FFFFFF;
	font: normal 13px/1.5 Georgia, Serif;
	color: #333;
}

.wrapper {
	width: 1375px;
	margin: 20px auto;
	padding: 20px;
}

h1 {
	display: inline-block;
	background-color: #333;
	color: #fff;
	font-size: 20px;
	font-weight: normal;
	text-transform: uppercase;
	padding: 4px 20px;
	float: left;
}

.clear {
	clear: both;
}

.items {
	display: block;
	margin: 20px 0;
}

.item {
	background-color: #fff;
	float: left;
	margin: 0 10px 10px 0;
	width: 205px;
	padding: 10px;
	height: 360px;
}

.item img {
	display: block;
	margin: auto;
}

h2 {
	font-size: 16px;
	display: block;
	border-bottom: 1px solid #ccc;
	margin: 0 0 10px 0;
	padding: 0 0 5px 0;
}

button {
	border: 1px solid #722A1B;
	padding: 4px 14px;
	background-color: #fff;
	color: #020E20;
	text-transform: uppercase;
	float: right;
	margin: 5px 0;
	font-weight: bold;
	cursor: pointer;
}

span {
	float: right;
}

.shopping-cart {
	display: inline-block;
	background:
		url('http://cdn1.iconfinder.com/data/icons/jigsoar-icons/24/_cart.png')
		no-repeat 0 0;
	width: 24px;
	height: 24px;
	margin: 0 10px 0 0;
}
.wrapper h1{
cursor: pointer !important;
}
.wrapper h1:visited {
	background: #a9a9a9 !important;
}
</style>

<script type="text/javascript">
	$(document).ready(function() {
		$('#list').click(function(event) {
			event.preventDefault();
			$('#products .item').addClass('list-group-item');
		});
		$('#grid').click(function(event) {
			event.preventDefault();
			$('#products .item').removeClass('list-group-item');
			$('#products .item').addClass('grid-group-item');
		});
	});
</script>


</head>
<!--

<c:forEach items='${page.list}' var='vo'>
<tr><td>${vo.id}</td>
	<td class='left'>
	<c:forEach var='i' begin="1" end="${vo.indent}">
		${i eq vo.indent ? '&nbsp;&nbsp;<i class="font fa-regular fa-comment-dots"></i>' 
						 : '&nbsp;&nbsp;'  }
	</c:forEach>
		<a href='detail_web.no?id=${vo.id}'>${vo.title}</a></td>

	<td>${vo.today}</td>
	
</tr>
</c:forEach>

  -->

<body style="padding: 0px">
	<section>
		<div class="title">
		
		</div>
		<div class="title">
			<div class="wrap">
				<form action="search_text">
					<div class="search">
						<input type="text" name="search_text" class="searchTerm" style="margin-top: 5px;"
							placeholder="찾으시는 제품을 검색해주세요.">
						<button type="submit" class="searchButton">
							<i class="fa fa-search"></i>
						</button>
					</div>
				</form>
			</div>
		</div>
	</section>

	<!-- wrapper -->
	<div class="wrapper" sty>
		<h1 style="width: 100px;">전체</h1><h1 style="width: 100px; background-color: #e9e9e9; color: #020e20;">제품명</h1><h1 style="width: 100px;  background-color: #e9e9e9; color: #020e20;">모델코드</h1>
		<!-- <span><i class="shopping-cart"></i></span> -->

		<div class="clear"></div>
		<!-- items -->
		<div class="items">
			<!-- single item -->
			<c:forEach items='${list}' var='vo'>
				<div class="item" style="margin:20px; overflow: hidden; text-overflow: ellipsis;">
					<p style="text-align: left; margin:8px; border-bottom: 1px solid #ccc;">${vo.category_name}</p>
					<img
						style="margin:14px 0; width:200; height: 200px;" src="${vo.filepath.replace('localhost','121.147.215.12:3302')}"
						alt="item" />
					<h2 style="width: 200px !important; text-overflow:ellipsis; overflow: hidden !important; white-space:nowrap;">${vo.brand_name } ${vo.model_name}</h2>
					<p style="margin-top: 5px">${vo.model_code }</p>
					</br>
					<button onclick="location.href='/pj_web/detail_web.mo?model_code=${vo.model_code}'" class="add-to-cart" type="button" style="margin-right:62px !important; color: #053f81; border: 1px solid #053f81;">상세보기</button>
				</div>
			</c:forEach>
			<!-- 
			<div class="item">
				<img
					src="http://img.tjskl.org.cn/pic/z2577d9d-200x200-1/pinarello_lungavita_2010_single_speed_bike.jpg"
					alt="item" />
				<h2>Item 1</h2>

				<p>
					Price: <em>$449</em>
				</p>
				<button class="add-to-cart" type="button">Add to cart</button>
			</div>

			<div class="item">
				<img
					src="http://img1.exportersindia.com/product_images/bc-small/dir_55/1620613/cannondale-jekyll-1-2011-mountain-bike-309779.jpg"
					alt="item" />
				<h2>Item 1</h2>

				<p>
					Price: <em>$449</em>
				</p>
				<button class="add-to-cart" type="button">Add to cart</button>
			</div>
			single item
			<div class="item">
				<img
					src="http://img1.exportersindia.com/product_images/bc-small/dir_55/1620613/cannondale-jekyll-1-2011-mountain-bike-309779.jpg"
					alt="item" />
				<h2>Item 1</h2>

				<p>
					Price: <em>$449</em>
				</p>
				<button class="add-to-cart" type="button">Add to cart</button>
			</div>
			<div class="item">
				<img
					src="http://img1.exportersindia.com/product_images/bc-small/dir_55/1620613/cannondale-jekyll-1-2011-mountain-bike-309779.jpg"
					alt="item" />
				<h2>Item 1</h2>

				<p>
					Price: <em>$449</em>
				</p>
				<button class="add-to-cart" type="button">Add to cart</button>
			</div>
			<div class="item">
				<img
					src="http://img1.exportersindia.com/product_images/bc-small/dir_55/1620613/cannondale-jekyll-1-2011-mountain-bike-309779.jpg"
					alt="item" />
				<h2>Item 1</h2>

				<p>
					Price: <em>$449</em>
				</p>
				<button class="add-to-cart" type="button">Add to cart</button>
			</div> -->
		
	</div>
	<!-- items -->
	</div>
	<!-- wrapper -->


</body>
<script type="text/javascript">
function detail( model_code ){
	location.href='/pj_web/detail_web?model_code='+model_code;
}
</script>
</html>

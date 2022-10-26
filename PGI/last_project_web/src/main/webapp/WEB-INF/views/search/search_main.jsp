<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.searchTerm{
  width: 80%;
  border: 3px solid #020E20;
  border-right: none;
  padding: 5px;
  height: 20px;
  border-radius: 5px 0 0 5px;
  outline: none;
  color: #9DBFAF;
}


</style>
</head>
<body>
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
</body>
</html>
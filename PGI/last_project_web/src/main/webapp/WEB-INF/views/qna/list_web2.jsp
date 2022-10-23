<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Dashboard - SB Admin</title>

<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" />
<link href="css/styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js"
	crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
		<!-- Navbar Brand-->
		<a class="navbar-brand ps-3" href="index.html">Start Bootstrap</a>
		<!-- Sidebar Toggle-->
		<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0"
			id="sidebarToggle" href="#!">
			<i class="fas fa-bars"></i>
		</button>
		<!-- Navbar Search-->
		<form
			class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
			<div class="input-group">
				<input class="form-control" type="text" placeholder="Search for..."
					aria-label="Search for..." aria-describedby="btnNavbarSearch" />
				<button class="btn btn-primary" id="btnNavbarSearch" type="button">
					<i class="fas fa-search"></i>
				</button>
			</div>
		</form>
		<!-- Navbar-->
		<ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
				role="button" data-bs-toggle="dropdown" aria-expanded="false"><i
					class="fas fa-user fa-fw"></i></a>
				<ul class="dropdown-menu dropdown-menu-end"
					aria-labelledby="navbarDropdown">
					<li><a class="dropdown-item" href="#!">Settings</a></li>
					<li><a class="dropdown-item" href="#!">Activity Log</a></li>
					<li><hr class="dropdown-divider" /></li>
					<li><a class="dropdown-item" href="#!">Logout</a></li>
				</ul></li>
		</ul>
	</nav>
	<div id="layoutSidenav">
		<div id="layoutSidenav_content">
			<main>

				<div class="container-fluid px-4">
					<div class="card mb-4">
						<div class="card-header">
							<!-- <i class="fas fa-table me-1"></i> -->
							<h3>문의글 목록</h3>
						</div>
						<form method='post' action='list_web.qa'>
							<div
								style="height: 35px; display: flex; flex-direction: row; justify-content: flex-end; align-items: center; padding: 16px 16px 0px 16px;">
								<!-- 로그인한 경우만 글쓰게 버튼 활성화 -->
								<c:if test="${not empty loginInfo}">
									<li class="qa-btn-li" style="list-style: none;"><a
										style="text-decoration: none; border: 1px solid #d8d8d8; border-radius: 6px; padding: 6px 20px; background-color: #020E20; color: #ffffff;"
										class='new'>글쓰기</a></li>
								</c:if>
							</div>
							<input type='hidden' name='id'> <input type='hidden'
								name='curPage' value='1'> <input type='hidden'
								name='read' value='0'>
						</form>
						<div class="card-body">

							<table id="datatablesSimple">
								<thead>
									<tr>
										<th>번호</th>
										<th>제목</th>
										<th>처리상태</th>
										<th>작성자</th>
										<th>작성일자</th>
										<th>조회수</th>
									</tr>
								</thead>
								<tbody>
									<c:if test="${empty page.qnaList}">
										<tr>
											<td colspan='6'>질문과 답변 자료가 없습니다</td>
									</c:if>

									<c:forEach items="${page.qnaList}" var='vo'>
										<tr>
											<td>${vo.no}</td>
											<td class='left'><c:if test='${vo.open eq 1}'>
													<i class="fa-solid fa-lock"></i>
												</c:if> <c:choose>
													<c:when
														test='${loginInfo.email eq vo.writer or loginInfo.admin eq "Y"}'>
														<a onclick='detail(${vo.id})'>${vo.title}</a>
													</c:when>
													<c:otherwise>
														<c:if test='${vo.open eq 0}'>
															<a onclick='detail(${vo.id})'>${vo.title}</a>
														</c:if>
														<c:if test='${vo.open eq 1}'>${vo.title}</c:if>
													</c:otherwise>
												</c:choose></td>
											<td>${vo.status}</td>
											<td>${vo.name}</td>
											<td>${vo.writedate}</td>
											<td>${vo.readcnt}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>

			</main>

			<footer class="py-4 bg-light mt-auto">
				<div class="container-fluid px-4">
					<div
						class="d-flex align-items-center justify-content-between small">
						<div class="text-muted">Copyright &copy; Your Website 2022</div>
						<div>
							<a href="#">Privacy Policy</a> &middot; <a href="#">Terms
								&amp; Conditions</a>
						</div>
					</div>
				</div>
			</footer>
		</div>
	</div>

	<script>
		$('[name=field]').val( ${field} ).prop( 'selected', true );
		$('[name=open][value=${open}]').prop( 'checked', true );
		
		$('.new').click(function(){
			if( ${empty loginInfo} ){
				alert('로그인 후 이용가능합니다');
				location.href='login_web'
			}else{
				location.href='new_web.qa'
			}
		});
		$('[name=pageList]').val( ${page.pageList} ).prop( 'selected', true );
		
		$('[name=pageList], [name=open], [name=field]').change(function(){
			$('form').submit();
		});
		
		$('.search').click(function(){
			$('form').submit();
		});
		
		function detail( id ){
			$('[name=id]').val( id );
			$('[name=read]').val( 1 );
			$('form').attr('action', 'detail_web.qa');
 			$("form").submit();
		}
</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
		crossorigin="anonymous"></script>
	<script src="assets/demo/chart-area-demo.js"></script>
	<script src="assets/demo/chart-bar-demo.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
		crossorigin="anonymous"></script>
	<script src="js/datatables-simple-demo.js"></script>
</body>
</html>








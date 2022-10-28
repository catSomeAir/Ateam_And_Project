<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 설명서 - 회원가입</title>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css'>
<link rel='icon' type='image/x-icon' href='img/hanul.ico'>
<script src='https://code.jquery.com/jquery-3.6.0.min.js'></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script
	src='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/js/all.min.js'></script>
<script src='js/common.js?Fri Oct 14 16:53:24 KST 2022'></script>
<link rel="stylesheet" type="text/css" href="css/edit_table.css" />
</head>
<body>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	background-color: #FFF;
	margin: 0;
	padding: 0;
	font-family: Verdana, Geneva, Tahoma, sans-serif;
	text-align: left !important;
}
#form-container {
	height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
}
#form-inner-container {
	background-color: white;
	max-width: 80%;
	border-radius: 8px;
	box-shadow: 0 0 20px gainsboro;
}
#sign-up-container, #sign-in-container {
	margin-top: 10px;
	padding: 40px 80px;
	width: 600px;
	display: inline-block;
}
form input {
	display: block;
	margin-bottom: 13px;
	border: 1px solid #E5E9F5;
	background-color: #F6F7FA;
	padding: 8px;
	margin-top: 10px;
	border-radius: 10px;
	width: 100%;
}
#form-controls {
	margin-bottom: 20px;
}
h3 {
	color: #020E20;
	font-size: 150%;
	font-weight: 500;
}
label {
	color: #7369AB;
}
::placeholder {
	color: #C0C7DB;
	font-size: larger;
	letter-spacing: 1.2px;
}
#form-controls button {
	border: none;
	font-size: 120%;
}
#form-controls button:hover {
	cursor: pointer;
}
.edit_btn{
	padding: 16px 65px;
	background-color: #020E20;
	border-radius: 10px;
	color: white;
}
.edit_btn:hover {
	background-color: #ff6678;
}
.cancel_btn {
	padding: 16px 0 16px 35px;
	background-color: transparent;
	color: #020E20;
}
#terms {
	width: 30px;
	height: 30px;
	appearance: none;
	border: 2px solid #7369AB;
	border-radius: 4px;
	position: relative;
}
#terms:checked:after {
	content: '\2713';
	color: #7369AB;
	font-size: 24px;
	position: absolute;
	top: 0;
	left: 3px;
}
.myprofile {
	width: 100px !important;
	height: 100px !important;
	object-fit: cover;
}
.box {
	width: 100px;
	height: 100px;
	border-radius: 70%;
	overflow: hidden;
	padding: 0;
	display: inline-block;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	<br />
	<br />
	<form method='post' action='edit_myprofile'
		enctype='multipart/form-data'>
		<div id="form-container">
			<div id="form-inner-container">
				<div id="sign-up-container">
					<br />
					<h3>회원 정보 수정</h3>
					<div>프로필이미지</div>
					<br /> 
					<label>
					 <input type='file' name='file' id='attach-file' accept="image/*"> 
					 	<div class="box">
						<img class="myprofile" src="${loginInfo.filepath }"> 
						</div>
						<a style="width: 100px; height: 80px; padding: 8px 20px 8px 20px; border: 1px solid gray;">사진변경</a>
					</label> <span id='preview'></span> <a id='delete-file'><i
						class="fa-solid fa-trash" style="margin-left: 5px"></i></a>
						<div style="margin-top: 20px;">이메일</div>
						<input type='text' name='email' class='chk'
							value="${loginInfo.email }" readonly>
						<br />
					<div >닉네임
						<div style="text-align: center;">
							<input type='text' name='name' title='이름' autofocus>
						</div>
						<br />
						
						<div>
							<span style="color: red;">*</span>비밀번호
						</div>
						<input type='password' name='pw' class='need' id="pw">
						<!-- <div class='valid'>비밀번호를 입력하세요(영문대/소문자,숫자 모두 포함)</div>  -->
						<br />
						<div>
							<span style="color: red;">*</span>비밀번호확인
						</div>
						<input type='password' name='pw_chk' class='need' id="pw_chk">
						<!--  <div class='valid'>비밀번호를 다시 입력하세요</div>  -->
						<br />
						<div>
							<div>휴대전화</div>
							<input type='text' name='phone' maxlength="13">
						</div>
						<br />
						<div id="form-controls">
							<button type="button"  class="edit_btn" onclick="if( necessary() ) { $('form').submit(); }"
							>수정</button>
							<button type="button" class="cancel_btn" id="toggleSignIn" onclick="history.go(-1)">취소</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
	<!-- Lottie animation -->
	<div id="animation-container">
		<lottie-player
			src="https://assets3.lottiefiles.com/packages/lf20_aesgckiv.json"
			background="transparent" speed="1"
			style="width: 520px; height: 520px;" loop autoplay></lottie-player>
	</div>

	<script
		src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<!-- 	<script src='js/member.js?Fri Oct 14 16:53:24 KST 2022'></script> -->
	<script>

		
		//입력항목에 입력되어 있는지 여부 반환하는 함수
		function necessary(){
			var need = true;
			$('input.need').each(function(){
				if( $(this).val()=='' ){
					alert( '입력하세요!' );
					$(this).focus();
					need = false;
					return need;
				}
			});
			return need; 
		}
		//아이다,비번,비번확인,이메일태그의 입력상태가 invalid 하면 form submit 불가
		function tagIsInvalid(tag) {
			var status = member.tag_status(tag);
			if (status.code == 'invalid') {
				alert('회원가입 불가\n' + status.desc);
				tag.focus();
				return true;
			} else
				return false;
		}
		//아이디 중복확인
		function id_check() {
			//올바른 아이디 입력값 상태인지 확인
			var $id = $('[name=userid]');
			if ($id.hasClass('chked'))
				return; //중복확인이 되어 있다면 다시 중복확인 불필요
			var status = member.tag_status($id);
			if (status.code == 'invalid') {
				alert('아이디 중복확인 불필요\n' + status.desc);
				$id.focus();
				return;
			}
			//DB에 입력한 아이디가 있다면 사용할 수 없는 아이디
			$.ajax({
				url : 'id_check',
				data : {
					userid : $id.val()
				},
				success : function(response) {
					//존재하는 경우: true, 아니면 false
					response = member.id_check(response);
					$id.siblings('div').text(response.desc).removeClass()
							.addClass(response.code);
					$id.addClass('chked');
				},
				error : function(req, status) {
					alert(status + ':' + req.status);
				}
			});
		}
		$('.date').change(function() {
			$('#delete').css('display', 'inline');
		});
		$("#delete").click(function() {
			$('.date').val('');
			$(this).css('display', 'none');
		});
		//생년월일을 특정 날짜(만13세)까지만 선택할 수 있도록 제한
		var today = new Date();
		var endday = new Date(today.getFullYear() - 13, today.getMonth(), today
				.getDate() - 1);
		var range = today.getFullYear() - 100 + ':' + endday.getFullYear();
		$('.date').datepicker({
			maxDate : endday,
			yearRange : range,
		});
	</script>
	<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
</body>
</html>
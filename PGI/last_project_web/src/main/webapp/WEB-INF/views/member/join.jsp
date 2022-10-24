<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <style>
#naver {
	background: url('img/naver.png') no-repeat center; background-size: cover;
}
#kakao {
	background: url('img/kakao.png') no-repeat center; background-size: cover;
}

</style> -->

<style type="text/css">
@import url('https://fonts.googleapis.com/css?family=Montserrat:400,800');

* {
  box-sizing: border-box;
}

body {
  background: #f6f5f7;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  font-family: 'Montserrat', sans-serif;
  height: 100vh;
  margin: -20px 0 50px;
}

h1 {
  font-weight: bold;
  margin: 0;
}

h2 {
  text-align: center;
}

p {
  font-size: 14px;
  font-weight: 100;
  line-height: 20px;
  letter-spacing: 0.5px;
  margin: 20px 0 30px;
}

span {
  font-size: 12px;
}

a {
  color: #333;
  font-size: 14px;
  text-decoration: none;
  margin: 15px 0;
}

button {
  border-radius: 20px;
  border: 1px solid #020E20;
  background-color: #020E20;
  color: #FFFFFF;
  font-size: 12px;
  font-weight: bold;
  padding: 12px 45px;
  letter-spacing: 1px;
  text-transform: uppercase;
  transition: transform 80ms ease-in;
}

button:active {
  transform: scale(0.95);
}

button:focus {
  outline: none;
}

button.ghost {
  background-color: transparent;
  border-color: #FFFFFF;
}

form {
  background-color: #FFFFFF;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  padding: 0 50px;
  height: 100%;
  text-align: center;
}

input {
  background-color: #eee;
  border: none;
  padding: 12px 15px;
  margin: 8px 0;
  width: 100%;
}

.container {
  background-color: #fff;
  border-radius: 10px;
    box-shadow: 0 14px 28px rgba(0,0,0,0.25), 
      0 10px 10px rgba(0,0,0,0.22);
  position: relative;
  overflow: hidden;
  width: 768px;
  max-width: 100%;
  min-height: 480px;
}

.form-container {
  position: absolute;
  top: 0;
  height: 100%;
  transition: all 0.6s ease-in-out;
}

.sign-in-container {
  left: 0;
  width: 50%;
  z-index: 2;
}

.container.right-panel-active .sign-in-container {
  transform: translateX(100%);
}

.sign-up-container {
  left: 0;
  width: 50%;
  opacity: 0;
  z-index: 1;
}

.container.right-panel-active .sign-up-container {
  transform: translateX(100%);
  opacity: 1;
  z-index: 5;
  animation: show 0.6s;
}

@keyframes show {
  0%, 49.99% {
    opacity: 0;
    z-index: 1;
  }
  
  50%, 100% {
    opacity: 1;
    z-index: 5;
  }
}

.overlay-container {
  position: absolute;
  top: 0;
  left: 50%;
  width: 50%;
  height: 100%;
  overflow: hidden;
  transition: transform 0.6s ease-in-out;
  z-index: 100;
}

.container.right-panel-active .overlay-container{
  transform: translateX(-100%);
}

.overlay {
  background: #FF416C;
  background: -webkit-linear-gradient(to right, #FF4B2B, #FF416C);
  background: linear-gradient(to right, #020E20, #123456);
  background-repeat: no-repeat;
  background-size: cover;
  background-position: 0 0;
  color: #FFFFFF;
  position: relative;
  left: -100%;
  height: 100%;
  width: 200%;
    transform: translateX(0);
  transition: transform 0.6s ease-in-out;
}

.container.right-panel-active .overlay {
    transform: translateX(50%);
}

.overlay-panel {
  position: absolute;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  padding: 0 40px;
  text-align: center;
  top: 0;
  height: 100%;
  width: 50%;
  transform: translateX(0);
  transition: transform 0.6s ease-in-out;
}

.overlay-left {
  transform: translateX(-20%);
}

.container.right-panel-active .overlay-left {
  transform: translateX(0);
}

.overlay-right {
  right: 0;
  transform: translateX(0);
}

.container.right-panel-active .overlay-right {
  transform: translateX(20%);
}

.social-container {
  margin: 20px 0;
}

.social-container a {
  border: 1px solid #DDDDDD;
  border-radius: 50%;
  display: inline-flex;
  justify-content: center;
  align-items: center;
  margin: 0 5px;
  height: 40px;
  width: 40px;
}

footer {
    background-color: #222;
    color: #fff;
    font-size: 14px;
    bottom: 0;
    position: fixed;
    left: 0;
    right: 0;
    text-align: center;
    z-index: 999;
}

footer p {
    margin: 10px 0;
}

footer i {
    color: red;
}

footer a {
    color: #3c97bf;
    text-decoration: none;
}
</style>
<script type="text/javascript">
const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

/* signUpButton.addEventListener('click', () => {
  container.classList.add("right-panel-active");
});
 */
 document.addEventListener('click', buttonactive);
 function buttonactive(){
	 container.classList.add("right-panel-active");
 }
/* signInButton.addEventListener('click', () => {
  container.classList.remove("right-panel-active");
}); */
document.addEventListener('click', button_active);
function button_active(){
	 container.classList.remove("right-panel-active");
}
</script>
</head>
<body>
 <h2>로그인</h2>
<div class="container" id="container">
  <div class="form-container sign-up-container">
    <form action="#">
      <h1>Create Account</h1>
      <div class="social-container">
        <a href="#" class="social"><img alt="s" src="img/hanul.logo.png"> </a>
        <a href="#" class="social"><i class="fa-brands fa-google-plus-g"></i></a>
        <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
      </div>
      <span>or use your email for registration</span>
      <input type="text" placeholder="Name" />
      <input type="email" placeholder="Email" />
      <input type="password" placeholder="Password" />
      <button>Sign Up</button>
    </form>
  </div>
  <div class="form-container sign-in-container">
    <form action="#">
      <h1>Sign in</h1>
      <div class="social-container">
        <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
        <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
        <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
      </div>
      <span>or use your account</span>
      <input type="email" placeholder="Email" />
      <input type="password" placeholder="Password" />
      <a href="#">Forgot your password?</a>
      <button>Sign In</button>
    </form>
  </div>
  <div class="overlay-container">
    <div class="overlay">
      <div class="overlay-panel overlay-left">
        <h1>Welcome Back!</h1>
        <p>To keep connected with us please login with your personal info</p>
        <button class="ghost" id="signIn">Sign In</button>
      </div>
      <div class="overlay-panel overlay-right">
        <h1>나만의 설명서!</h1>
        <p>Enter your personal details and start journey with us</p>
        <button class="ghost" id="signUp">Sign Up</button>
      </div>
    </div>
  </div>
</div>
 
</body>
</html>

<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table tr td { text-align: left }
[name=address] { margin-top: 3px }
p { width:600px; text-align: right; margin: 10px auto; color:#ff0000; }
form table th span { color:#ff0000; margin-right:5px  }
</style>
</head>
<body>

<h3>회원가입</h3>
<p>*는 필수입력항목입니다</p>
<!--  
파일첨부시
1. form 태그의 method='post'
2. enctype='multipart/form-data'
-->
<form method='post' action='join' enctype='multipart/form-data'>
<table class='w-px600'>
<tr><th class='w-px140'><span>*</span>성명</th>
	<td><input type='text' name='name' title='이름' autofocus></td>
</tr>
<tr><th><span>*</span>아이디</th>
	<td><input type='text' name='userid' class='chk'>
		<a class='btn-fill' onclick='id_check()'>아이디 중복확인</a>
		<div class='valid'>아이디를 입력하세요(영문소문자,숫자만)</div>
	</td>
</tr>
<tr><th><span>*</span>비밀번호</th>
	<td><input type='password' name='userpw' class='chk'>
		<div class='valid'>비밀번호를 입력하세요(영문대/소문자,숫자 모두 포함)</div>
	</td>
</tr>
<tr><th><span>*</span>비밀번호확인</th>
	<td><input type='password' name='userpw_ck' class='chk'>
		<div class='valid'>비밀번호를 다시 입력하세요</div>
	</td>
</tr>
<tr><th><span>*</span>성별</th>
	<td>
		<label>
			<input type='radio' name='gender' value='남' checked>남
		</label>
		<label>
			<input type='radio' name='gender' value='여'>여
		</label>
	</td>
</tr>
<tr><th><span>*</span>이메일</th>
	<td><input type='text' name='email' class='chk'>
		<div class='valid'>이메일을 입력하세요</div>
	</td>
</tr>
<tr><th>프로필이미지</th>
	<td><div class='items-center'>
			<label>
				<input type='file' name='file' id='attach-file' accept="image/*">
				<a><i class="font-b fa-regular fa-address-card"></i></a>
			</label>
			<span id='preview'></span>
			<a id='delete-file'><i class="font-r fa-regular fa-trash-can"></i></a>
		</div>
	</td>
</tr>
<tr><th>생년월일</th>
	<td><input type='text' name='birth' class='date' readonly>
		<a id='delete'><i class="font-r fa-regular fa-calendar-xmark"></i></a>
	</td>
</tr>
<tr><th>전화번호</th>
	<td><input type='text' name='phone' maxlength="13"></td>
</tr>
<tr><th>주소</th>
	<td><a class='btn-fill' onclick='post()'>우편번호찾기</a>
		<input type='text' name='post' class='w-px60' readonly>
		<input type='text' name='address' class='full' readonly>
		<input type='text' name='address' class='full'>
	</td>
</tr>
</table>
</form>

<div class='btnSet'>
<a class='btn-fill' onclick='join()'>회원가입</a>
<a class='btn-empty' href='<c:url value="/"/>'>취소</a>
</div>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src='js/member.js?<%=new java.util.Date()%>'></script>

<script>
//회원가입처리
function join(){
	if( $('[name=name]').val()=='' ){
		//alert($('[name=name]').attr('title')+ '을 입력하세요');
		var title = $('[name=name]').closest('tr').children('th').text();
		alert( title + '을 입력하세요');
		$('[name=name]').focus();
		return;
	}
	
	if( $('[name=userid]').hasClass('chked') ){
	//중복확인 한 경우
		//이미 사용중인 경우
		if( $('[name=userid]').siblings('div').hasClass('invalid') ){
			alert('회원가입 불가\n' + member.userid.unusable.desc);
			$('[name=userid]').focus();
			return;
		}
		
	}else{
	//중복확인 하지 않은 경우
		//유효하지 않은 입력값
		if( tagIsInvalid( $('[name=userid]') ) ) return;  
		else{
		//아이디중복확인을 해야하는 경우
			alert('회원가입 불가\n' + member.userid.valid.desc);
			$('[name=userid]').focus();
			return;
		}
	}
	
	
	if( tagIsInvalid( $('[name=userpw]') ) ) return;
	if( tagIsInvalid( $('[name=userpw_ck]') ) ) return;
	if( tagIsInvalid( $('[name=email]') ) ) return;
	
	$('form').submit();
}

//아이다,비번,비번확인,이메일태그의 입력상태가 invalid 하면 form submit 불가
function tagIsInvalid( tag ){
	var status = member.tag_status( tag );
	if( status.code=='invalid' ){
		alert( '회원가입 불가\n' + status.desc );
		tag.focus();
		return true;
	}else
		return false;
}

//아이디 중복확인
function id_check(){
	//올바른 아이디 입력값 상태인지 확인
	var $id = $('[name=userid]');
	if( $id.hasClass('chked') ) return;	//중복확인이 되어 있다면 다시 중복확인 불필요
	
	var status = member.tag_status( $id );
	if( status.code=='invalid' ) {
		alert('아이디 중복확인 불필요\n' + status.desc );
		$id.focus();
		return;
	}
	
	//DB에 입력한 아이디가 있다면 사용할 수 없는 아이디
	$.ajax({
		url: 'id_check',
		data: { userid:$id.val() },
		success: function(response){
			//존재하는 경우: true, 아니면 false
			response = member.id_check( response );
			$id.siblings('div').text( response.desc )
						.removeClass().addClass( response.code );
			$id.addClass('chked');
		},error: function(req,status){
			alert(status+':'+req.status);
		}
	});
}

$('.chk').keyup(function(e){
	//아이디를 중복확인한 후 다시 입력한다면 중복확인하지 않은 상태
	if( $(this).hasClass('chked') ) $(this).removeClass('chked');
	//아이디태그에 엔터 키 입력인 경우는 아이디 중복확인
	if( $(this).attr('name')=='userid' && e.keyCode==13 ){
		id_check();
	}else{
		var status = member.tag_status( $(this) );
		$(this).siblings('div').text( status.desc )
				.removeClass().addClass( status.code );
	}
});


$('.date').change(function(){
	$('#delete').css( 'display', 'inline' );
});
$("#delete").click(function(){
	$('.date').val('');
	$(this).css( 'display', 'none' );
});

//생년월일을 특정 날짜(만13세)까지만 선택할 수 있도록 제한
var today = new Date();
var endday = new Date( today.getFullYear()-13, today.getMonth(),  today.getDate()-1 );
var range = today.getFullYear()-100 + ':' + endday.getFullYear(); 
$('.date').datepicker({
	maxDate: endday,
	yearRange: range,
});

function post(){
	new daum.Postcode({
        oncomplete: function(data) {
        	console.log( data )
        	var address
        	= data.userSelectedType=='R' ? data.roadAddress : data.jibunAddress;
        	if( data.buildingName!='' ) address += " ("+data.buildingName+")";
        	$('[name=address]').eq(0).val( address );
        	$('[name=post]').val( data.zonecode );
        }
    }).open();
	
}
</script>

</body>
</html> --%>
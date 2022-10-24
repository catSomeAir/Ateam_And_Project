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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.css">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.js"></script>

<script src='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/js/all.min.js'></script>
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css'>
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

signUpButton.addEventListener('click', () => {
  container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
  container.classList.remove("right-panel-active");
});
</script>
</head>
<body>
<%-- <div class='center'>
	<a href='<c:url value="/"/>'><img src='img/hanul.logo.png'></a>
	<div class='box'>
	<ul>
		<li><input type='text' id='id' class='chk' placeholder='아이디'></li>
		<li><input type='password' id='pw' class='chk' placeholder='비밀번호'></li>
		<li><input type='button' value='로그인' onclick='login()'></li>
		<li><hr></li>
		<li><input type='button' id='naver' onclick='location="naverlogin"'></li>
		<li><input type='button' id='kakao' onclick='location="kakaologin"'></li>
	</ul>
	</div>
	<div><a href='findPw'>비밀번호찾기</a></div>
</div>
<script>
$('#pw').keypress(function(e){
	if( e.keyCode==13 ){
		login();
	}
});

function login(){
	if( ! emptyCheck() ) return;
	
	$.ajax({
		url: 'iotlogin',
		data: { id:$('#id').val(), pw:$('#pw').val() },
		success: function( response ){
			if( response ) location='<c:url value="/"/>';
			else{
				alert('아이디나 비밀번호가 일치하지 않습니다!');
				$('#id').focus();
			}
		}
	});
	
	
}

</script>
 --%>
 
 <h2>로그인</h2>
 <img alt="" src="img/social_g">
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
      <!-- <input type="text" class='chk'  placeholder="Name" /> -->
      <input type="email" id="join_email" name="email" class='chk'  placeholder="Email" />
      <input type="password" id="join_pw" name="pw"  class='chk'  placeholder="Password" />

      <button>Sign Up</button>
    </form>
    
    
    
  </div>
  <div class="form-container sign-in-container">
    <form onsubmit="return login()">
      <h1>Sign in</h1>
      <div class="social-container">
        <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
        <a href="#" class="social"><i class="fa-solid fa-n"></i></a>
        <a href="#" class="social"><i class="fa-sharp fa-solid fa-k"></i></a>
      </div>
      <span>or use your account</span>
      <input type="email" id="email" name="email" class='chk'  placeholder="Email" />
      <input type="password" id="pw" name="pw"  class='chk'  placeholder="Password" />
      <a href="#">Forgot your password?</a>
      <button onclick="login() !important">Sign In</button>
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
 <script type="text/javascript">

 $('#pw').keypress(function(e){
 	if( e.keyCode==13 ){
 		login();
 	}
 });

 function login(){
 	
 	
 	$.ajax({
 		url: 'login_in_web',
 		data: { email:$('#email').val(), pw:$('#pw').val() },
 		success: function( response ){
 			if( response ){
 				
 				location='<c:url value="/"/>';
 			}
 			else{
 				alert('아이디나 비밀번호가 일치하지 않습니다!');
 				$('#email').focus();
 			}
 		}
 	});
 	
 	
 }

 </script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<title>Insert title here</title>

<link rel="stylesheet" href="resources/css/login.css" >
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.css">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.js"></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/js/all.min.js'></script>

<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css'>

<style type="text/css">
@import url('https://fonts.googleapis.com/css?family=Montserrat:400,800');
</style>
<!-- <script src="https://apis.google.com/js/platform.js" async defer></script> -->
</head>
<body>

 <h2>로그인</h2>
 <!-- <img alt="" src="img/social_g"> -->
<div class="container" id="container">
  <div class="form-container sign-in-container">
<!--     <form onsubmit="login()"> -->
    <form>
      <h1>Sign in</h1>
      <div class="social-container">
        <a onclick="location='naverlogin'" class="social"><i class="fa-solid fa-n"></i></a>
        <a onclick="location='kakaologin'" class="social"><i class="fa-sharp fa-solid fa-k"></i></a>
   
      </div>
      
      <span>or use your account</span>
      <input type="email" id="email" name="email" class='chk'  placeholder="Email" />
      <input type="password" id="pw" name="pw"  class='chk'  placeholder="Password" autocomplete="off" />
      <a href="#">Forgot your password?</a>
      <button type="submit"   id="signIn" onclick="login()">Sign In</button>
<!--       <button type="button">Sign In</button> -->
    </form>
  </div>
  <div class="overlay-container">
    <div class="overlay">
      <div class="overlay-panel overlay-left">
      </div>
      <div class="overlay-panel overlay-right">
        <h1>나만의 설명서!</h1>
        
        <p>Enter your personal details and start journey with us</p>
        <button class="ghost" id="signUp"  onclick="location='member_web'">Sign Up</button>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript">
const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

/* console.log('t1: ', document.getElementById('signUp'));
console.log('t2: ', signUpButton);

setTimeout(function(){
	console.log('ts1: ', document.getElementById('signUp'));
	console.log('ts2: ', signUpButton);	
}, 1000); */

signUpButton.addEventListener('click', () => {
  container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
  container.classList.remove("right-panel-active");
});
</script>
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
	<!-- <mata name="google-signin-scope" content="profile email">
	<meta name="google-signin-client_id" content="307319882668-0c4hg8eq8liert8dhumrmohkkpbrvhf7.apps.googleusercontent.com">
	<script src="https://apis.google.com/js/platform.js" async defer></script>구글 로그인 api - hai
	<script>
	window.onload = function () {
	    google.accounts.id.initialize({
	      client_id: '307319882668-0c4hg8eq8liert8dhumrmohkkpbrvhf7.apps.googleusercontent.com',
	      callback: handleCredentialResponse
	    });
	    // google.accounts.id.prompt();
	    // One Tap 기능을 사용하지 않기 때문에 주석처리하였다.
	  };
	  window.onload = function () {
			// 생략...
		    google.accounts.id.renderButton(
		      document.getElementById("buttonG"),
		      { theme: "outline", size: "small" }  // customization attributes
		    );
		  }
	function onSignIn(googleUser) {
	  var profile = googleUser.getBasicProfile();
	  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
	  console.log('Name: ' + profile.getName());
	  console.log('Image URL: ' + profile.getImageUrl());
	  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
	}
	
	</script> -->
	
	
	   <!--   <a onclick="location='googlelogin'" class="social"><i class="fab fa-google-plus-g"></i></a> -->
<!--         <a id="buttonG" onclick="onSignIn()" class="social"><i class="fab fa-google-plus-g"></i></a> -->
        <!-- <a data-onsuccess="onSignIn" class="social"><i class="fab fa-google-plus-g"></i></a> -->
        
          <!-- <div type="icon" id="buttonG" onclick="onSignIn();"></div> --><!-- 구글 로그인버튼 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/css/join_web.css" >
<meta charset="UTF-8">
<title>Insert title here</title>

</head>

<body>

<div id="join-wrap">	
	<h3>회원가입</h3>
	<!--  
	파일첨부시
	1. form 태그의 method='post'
	2. enctype='multipart/form-data'
	-->
	<div id="in-wrap">
		<form method='post' action='join_web' >
		<table class='w-px500'>
		
		<tr id="email-tr"><th><span>*</span>이메일</th>
			<td id="email-td"><input type='text' name='email' id="email" class='chk' autofocus oninput = "checkEmail()" >
				<span class="email_ok">사용 가능한 이메일입니다</span>
				<span class="email_already">이메일을 다시 입력해주세요</span>
			</td>
		</tr>
		<tr class="pw-tr"><th><span>*</span>비밀번호</th>
			<td><input type='password' name='pw' id="pw" class='chk'>
				<div class='valid pw-cmt'>비밀번호를 입력하세요(영문대/소문자,숫자 모두 포함)</div>
			</td>
		</tr>
		<tr class="pw-tr"><th><span>*</span>비밀번호확인</th>
			<td><input type='password' name='pw_ck' class='chk'>
				<div class='valid pw-cmt'>비밀번호를 다시 입력하세요</div>
			</td>
		</tr>
		<tr class="etc-tr"><th>성명</th>
			<td><input class="join_input" type='text' name='name' title='이름'></td>
		</tr>
		<tr class="etc-tr"><th>전화번호</th>
			<td><input  class="join_input" type='text' name='phone' maxlength="13"></td>
		</tr>
		
		</table>
		</form>
	</div>
	<div class='btnSet-ain'>
	<a style="width: 130px; height: 35px;" class='btn-fill-ain' onclick='join()'>회원가입</a>
	<a class='btn-empty-ain' style="width: 130px; height: 35px;" href='<c:url value="/"/>'>취소</a>
	</div>
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
	
	 if( $('[name=email]').hasClass('chked') ){
	//중복확인 한 경우
		//이미 사용중인 경우
		if( $('[name=email]').siblings('div').hasClass('invalid') ){
			alert('회원가입 불가\n' + member.userid.unusable.desc);
			$('[name=email]').focus();
			return;
		}
		
	}else{
	//중복확인 하지 않은 경우
		//유효하지 않은 입력값
		if( tagIsInvalid( $('[name=email]') ) ) return;  
		else{
		//아이디중복확인을 해야하는 경우
			alert('회원가입 불가\n' + member.userid.valid.desc);
			$('[name=email]').focus();
			return;
		}
	} 
	
	if( tagIsInvalid( $('[name=pw]') ) ) return;
	if( tagIsInvalid( $('[name=pw_ck]') ) ) return;
	if( tagIsInvalid( $('[name=email]') ) ) return;
	
	$('form').submit();
}

//아이디,비번,비번확인,이메일태그의 입력상태가 invalid 하면 form submit 불가
function tagIsInvalid( tag ){
	var status = member.tag_status( tag );
	if( status.code=='invalid' ){
		alert( '회원가입 불가\n' + status.desc );
		tag.focus();
		return true;
	}else
		return false;
}


   
	  $('.chk').keyup(function(e){
	  	//아이디를 중복확인한 후 다시 입력한다면 중복확인하지 않은 상태
	  	if( $(this).hasClass('chked') ) $(this).removeClass('chked');
	  	//아이디태그에 엔터 키 입력인 경우는 아이디 중복확인
	  	if( $(this).attr('name')=='email' && e.keyCode==13 ){
	  		email_check();
	  	}else{
	  		var status = member.tag_status( $(this) );
	  		console.log('status:', status);
	  		console.log('this:', $(this));
	  		
	  		setTimeout(function() {
	  			console.log('tag_status2:', member.tag_status( $(this) ));
	  		}, 500);
	  		$(this).siblings('div').text( status.desc )
	  				.removeClass().addClass( status.code );
	  	}
	  	
	  	if( $(this).attr('name')=='pw_ck' ){
	  		var pw = $('input[name=pw]').val();
	  		var pw_ck = $('input[name=pw_ck]').val();
	  		if( pw === pw_ck){
	  		/* $(this).siblings('div').text( "사용가능한 비밀번호입니다" ); */
	  		var status = member.tag_status( $(this) );
  			$(this).siblings('div').text( status.desc )
  					.removeClass().addClass( status.code );
	  		 }else{
	  			var status = member.tag_status( $(this) );
	  			$(this).siblings('div').text( status.desc )
	  					.removeClass().addClass( status.code );
	  		 }
	  	}
	  });

	  function checkEmail(){
		    var email = $('#email').val(); //id 값이 email인 값을 email에 저장
		    var reg = /^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;
		    	if ( reg.test($("#email").val()) ){
			    
				    $.ajax({
				        url:'/pj_web/email_check', //Controller에서 요청 받을 주소
				        type:'post', //POST 방식으로 전달
				        data:{email:email},
				    
				        success:function(cnt){ //컨트롤러에서 넘어온 cnt값을 받는다 
				        	if(cnt == 0){ //cnt가 1이 아니면(=0일 경우) -> 사용 가능한 아이디 
				        		 if( email.substring((email.length-4)) == ".com" ){ 
					                $('.email_already').css("display", "none");
					        		$('.email_ok').css("display","inline-block");
					        		$('#email').addClass('chked');//
					        		
					        		 $('#pw').focus();
				        	    	
				        	    }else{
				        	    	$('.email_already').css("display","inline-block");
				                    $('.email_ok').css("display", "none");
				                    $("#email").focus();
				        	    }
				                
				            } else { // cnt가 1일 경우 -> 이미 존재하는 아이디
				                $('.email_already').css("display","inline-block");
				                $('.email_ok').css("display", "none");
				                /* alert("이메일를 다시 입력해주세요"); */
				                $("#email").focus();
				            }
				        },
				        
				        error:function(){
				            alert("에러코드:505 관리자에게 문의주세요");
				        }
				    });
		    	}else{
		    	    $('.email_already').css("display","inline-block");
		            $('.email_ok').css("display", "none");
		            /* alert("이메일를 다시 입력해주세요"); */
		            /* $('#email').val(''); */
		            $("#email").focus();
		    		
		    	}
		};
$('.date').change(function(){
	$('#delete').css( 'display', 'inline' );
});
$("#delete").click(function(){
	$('.date').val('');
	$(this).css( 'display', 'none' );
});


</script>

</body>
</html>
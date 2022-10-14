<%@ page language="java" contentType="text/html; charset=UTF-8"
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
</html>
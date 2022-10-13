/**
 * 회원정보의 유효성 판단처리
 */
var member = {
	//키보드입력시 입력값 태그별 상태확인
	tag_status: function( tag ){
		var name = tag.attr('name');
		if( name=='userpw' )  return this.userpw_status( tag.val() );
		else if( name=='userpw_ck' ) return this.userpw_ck_status( tag.val() );
		else if( name=='userid' )  return this.userid_status( tag.val() );
		else if( name=='email' )	return this.email_status( tag.val() );
	},
	
	//이메일 입력값 상태확인: 이메일형식
	email_status: function(email){
		var reg = /^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;		
		if( email=='' )					return this.common.empty;
		else if( reg.test(email) )		return this.email.valid;
		else							return this.email.invalid;
	},
	
	email: {
		valid: { code:'valid', desc:'유효한 이메일' },
		invalid: { code:'invalid', desc:'유효하지 않은 이메일' }
	},
	
	//아이디 입력값 상태확인: 영문 소문자,숫자
	userid_status: function(id){
		var reg = /[^a-z0-9]/g;
		if( id=='' )						return this.common.empty;
		else if( id.match(this.space) )		return this.common.space;
		else if( reg.test(id) )				return this.userid.invalid;
		else if( id.length<5 )				return this.common.min;
		else if( id.length>10 )				return this.common.max;
		else								return this.userid.valid;
	},
	
	//아이디 중복확인 상태확인
	id_check: function(usable) {
		//존재하는 경우: true -> 이미사용중, 아니면 false -> 사용가능
		if( usable )		return this.userid.unusable;
		else				return this.userid.usable;
	},
	
	userid: {
		usable: { code:'valid', desc:'사용가능한 아이디' },
		unusable: { code:'invalid', desc:'이미 사용중인 아이디' },
		invalid: { code:'invalid', desc:'아이디는 영문 소문자,숫자만 입력' },
		valid: { code:'valid', desc:'아이디 중복확인하세요' }
	},
	
	//비밀번호확인 입력값 상태확인: 비밀번호와 입력값이 동일한지
	userpw_ck_status: function(pw_ck){
		if( pw_ck=='' )								return this.common.empty;
		else if( pw_ck==$('[name=userpw]').val() ) 	return this.userpw.equal;
		else									return this.userpw.notEqual;
	},
	
	//비밀번호입력값 상태확인: 영문 대.소문자, 숫자를 모두 포함
	userpw_status: function( pw ){
		var reg = /[^a-zA-Z0-9]/g, upper=/[A-Z]/g, lower=/[a-z]/g, digit=/[0-9]/g;
		if( pw=='' )						return this.common.empty;
		else if( pw.match(this.space) )		return this.common.space;
		else if( reg.test(pw) )				return this.userpw.invalid;
		else if( pw.length<5 )				return this.common.min;
		else if( pw.length>10 )				return this.common.max;
		else if( !upper.test(pw) || !lower.test(pw) || !digit.test(pw) )			
											return this.userpw.lack;
		else								return this.userpw.valid;
	},
	
	//비밀번호관련 상태값
	userpw: {
		equal: { code:'valid', desc:'비밀번호가 일치' },
		notEqual: { code:'invalid', desc:'비밀번호가 일치하지 않습니다' },
		valid: { code:'valid', desc:'사용가능한 비밀번호' },
		invalid: { code:'invalid', desc:'영문 대/소문자,숫자만 입력' },
		lack: { code:'invalid', desc:'영문 대/소문자,숫자를 모두 포함'}
	},
	
	space: /\s/g,
	
	//공통사용 상태값
	common: {
		empty: { code:'invalid', desc:'입력하세요' },
		space: { code:'invalid', desc:'공백없이 입력하세요' },
		min: { code:'invalid', desc:'5자이상 입력하세요' },
		max: { code:'invalid', desc:'10자이내 입력하세요' }
	}
} 
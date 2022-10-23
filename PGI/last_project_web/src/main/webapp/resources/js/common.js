/**
 *  공통 함수
 */
$(function(){
	
	//달력 날짜관련 기본 설정
	$.datepicker.setDefaults({
		dateFormat: 'yy-mm-dd',
		changeYear: true,
		changeMonth: true,
		showMonthAfterYear: true,
		monthNamesShort: ['1월','2월','3월','4월','5월','6월'
							,'7월','8월','9월','10월','11월','12월'],
		dayNamesMin: ['일','월','화','수','목','금','토']
	});
	
	//파일선택 첨부하기
	$('#attach-file').change(function(){
		var filename = '';
		for(var idx=0; idx<this.files.length; idx++){
    		filename += (filename=='' ? '' : ',') + this.files[idx].name
    	}

		var attached = this.files[0];
		//console.log(attached )
		//선택한 파일이 있는 경우에만 처리
		if( attached ){
			$('#file-name').text( filename );		//선택한 파일명 보이게
			$('#delete-file').css('display', 'inline'); //삭제버튼 보이게
			//이미지 보여질 태그가 있는 경우에 처리
			if( $('#preview').length > 0 ){
				//선택한 파일이 이미지파일인 경우 보여지게
				if( isImage(attached.name) ){
					//이미지태그를 만들어 처리
					$('#preview').html( '<img>' );
					//선택할 파일정보를 읽어서 이미지태그의 src로 지정
					var reader = new FileReader();
					reader.onload = function( e ){
						$('#preview img').attr('src', e.target.result );
					}
					reader.readAsDataURL( attached );
				}else{
					$('#preview').html('');					
				}
			}
		}else{
			$('#delete-file').css('display', 'none');
			$('#preview').html('');		
		}
	});
	
	
	$('#delete-file').click(function(){
		$('#file-name').text(''); //선택한 파일명 없애기
		$('#attach-file').val(''); //실제 첨부된 파일정보 삭제
		$(this).css('display', 'none'); //삭제버튼 안보이게
		$('#preview').html(''); //보여지고 있는 이미지태그 없애기
	});
	
	
});

function loading(is){
	$('.loading').css('display', is ? 'block' : 'none');
}


$(document).on( 'change', '.attach-file', function(){
		var attached = this.files[0];
		var $div = $(this).closest('div');
		//선택한 파일 있는 경우
		if( attached ){
			//바꿔 첨부함으로써 DB에서 삭제할 파일정보(id) 관리
			var removed = $('[name=removed]').val();
			var id = $div.data('id');
			if( id ) removed += (removed=='' ? '' : ',' ) + id;
			$('[name=removed]').val( removed );
			//삭제할 태그의 data 속성을 삭제
			$div.removeAttr('data-id');
			console.log( $('[name=removed]').val() );
			
			//원래 선택된 파일이 없던 경우만 태그복제
			if( $div.children('.file-name').text()=='' ){
				copyFileTag();
			}
			
			$div.children('.file-name').text( attached.name );		//선택한 파일명 보이게
			$div.children('.delete-file').css('display', 'inline'); //삭제버튼 보이게
		}else{
			$div.remove();
		}
		
		
}).on( 'click', '.delete-file', function(){
	//삭제한 파일정보(id) 관리
	var removed = $('[name=removed]').val();
	var id = $(this).closest('div').data('id');
	if( id ) removed += (removed=='' ? '' : ',' ) + id;
	$('[name=removed]').val( removed );
	console.log( removed );
	
	$(this).closest('div').remove();

}); 
	
	

//파일선택첨부 태그 복제하기
function copyFileTag(){
	var $item = $('td div.items-center').last();
	$item.after( $item.clone() );
	
	//복제해 만든 태그에 대해
	$item = $('td div.items-center').last();
	$item.find('.attach-file').val('');    // file정보 삭제
	$item.children('.file-name').text(''); // 파일명 삭제
	$item.children('.delete-file').css('display', 'none'); // 삭제버튼 안보이게
}



//popup 태그가 브라우저의 가운데 위치하게 처리
function center(tag, back){
	var width = Math.max( $(window).width(), $('body').prop('scrollWidth') );
	var height = Math.max( $(window).height(), $('body').prop('scrollHeight') );
	back.css( { 'width':width, 'height':height  } );
	
	var left = ($(window).width() - tag.width())/2 + $(window).scrollLeft();
	var top = ($(window).height() - tag.height())/2 + $(window).scrollTop();
	tag.removeClass('center').css( { 'left':left, 'top':top, 'position':'absolute' } );
}



//이미지 파일인지 확인
function isImage(filename){
	//abc.txt, abc.pdf, abd.jpg, abc.PNG
	var ext = filename.substring( filename.lastIndexOf('.')+1 ).toLowerCase();
	//이미지에 해당하는 확장자
	var imgs = [ 'jpg', 'jpeg', 'gif', 'png', 'bmp', 'webp' ];
	if( imgs.indexOf(ext) == -1 ) 	return false;
	else							return true;
}


//입력항목 입력여부 확인
function emptyCheck(){
	var ok = true;
	$('.chk').each(function(){
		if( $(this).val()=='' ){
			var item = $(this).attr('placeholder');
			item = item ? item : $(this).attr('title');
			alert(item + ' 입력하세요!');
			$(this).focus();
			ok = false;
			return ok;
		}	
	});
	return ok;
}










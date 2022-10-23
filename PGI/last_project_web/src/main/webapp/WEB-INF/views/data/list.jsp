<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.pharmacy, .animal, #list-top { width: 1200px }
#popup { width: 800px;	height: 600px; }
.marker { font-size: 16px; font-weight: bold; color:#ff0000; }
.list-view, .grid-view { border: 1px solid #b0b0b0;  padding:3px 6px; }
.common a.on { color: #3367d6; }
.common a.off { color: #b0b0b0; }
ul.pharmacy li div:first-child { height: 25px; }
ul.pharmacy li div:last-child { font-size: 14px; }

table.animal img { width: 100px; height: 100px;}

ul.animal img { width: 100%; height: 100%; }
ul.animal li { display: flex; flex-direction: column; }
ul.animal .info { 
	display: grid;
    grid-template-columns: 2.5fr 3fr;
    grid-column-gap: 8px;
    height: 105px !important;
    padding-bottom: 0;
}
ul.animal .info div {
	padding: 0 !important;
	white-space: nowrap; overflow: hidden; text-overflow: ellipsis;
}
ul.animal .info div:first-child {
	height: 100px;
    grid-row: 1/5;
}
ul.animal .info div:nth-child(2) {
    display: flex;
    justify-content: space-between;
}
ul.animal .care {
    font-size: 15px;
    display: flex;
    justify-content: space-between;
    height: 35px;
}



</style>
</head>
<body>
<h3>공공데이터</h3>
<div class='btnSet option'>
	<a>약국조회</a>
	<a>유기동물조회</a>
</div>
<div id='list-top'>
	<ul class='animal-top'></ul>
	<ul class='common'>
		<li><select class='w-px100' id='pageList'>
			<option value='10'>10개씩</option>
			<option value='20'>20개씩</option>
			<option value='30'>30개씩</option>
			</select>
		</li>
		<li class='list-view'><a class='on'><i class="font fa-regular fa-rectangle-list"></i></a></li>
		<li class='grid-view'><a class='off'><i class="font fa-solid fa-table-cells"></i></a></li>
	</ul>
</div>
<div id='data-list'></div>
<div class='btnSet'>
	<div class='page-list'></div>
</div>
<div class='loading center'><img src='img/loading_book_navy.gif'></div>
<div id='popup-background'></div>
<div id='popup' class='center'></div>

<!-- <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAWIDq81BxfQQDXd_Vj1mnMfHU8xTw5KOE"> -->
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCsrerDHJrp9Wu09Ij7MUELxCTPiYfxfBI"></script>
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=295364ba6aaf47ea28434befac53e135"></script>
<script src='js/animal.js?<%=new java.util.Date()%>'></script>
<script>
$(window).resize(function(){
	center( $('#popup'), $('#popup-background') );
});
$(window).scroll(function(){
	center( $('#popup'), $('#popup-background') );
})

var viewType = 'list';
$('.list-view, .grid-view').click(function(){
	//현재 뷰형태와 다른 뷰를 클릭했을때만 처리
	if( ! $(this).hasClass(viewType + '-view') ){
		viewType = viewType == 'list' ? 'grid' : 'list';
		$(this).children('a').removeClass().addClass('on');
		$(this).siblings('li').children('a').removeClass().addClass('off');
		
		if( $('.pharmacy').length>0 ){
			if( viewType=='grid') 	pharmacy_grid_view( $('.pharmacy tbody tr') );
			else  					pharmacy_list_view( $('.pharmacy li') );
			
		}else{
			if( viewType=='grid') 	animal_grid_view( $('.animal tbody') );
			else  					animal_list_view( $('.animal li') );
			
		}
	}
});

//약국 그리드보기 -> 목록보기
function pharmacy_list_view( item, api ){
	var tag 
	= '<table class="tb-list pharmacy">'
	+ '<thead><tr><th class="w-px300">약국명</th><th class="w-px160">전화번호</th><th>주소</th></tr>'
	+ '</thead>'
	+ '<tbody>'
	+ '</tbody>'
	+ '</table>';
	$('#data-list').html( tag );

	tag = '';
	if( api ){
		//공공데이터포털에서 api를 요청해 받아온 데이터로 목록형태를 표현
		item.each(function(){
			tag += '<tr><td><a class="show" data-x='+ this.XPos 
					+ ' data-y='+ this.YPos +'>'+ this.yadmNm +'</a></td>'
				+ '<td>'+ (this.telno ? this.telno : '-') +'</td>'
				+ '<td class="left">'+ this.addr +'</td>'
				+ '</tr>';
		});
	}else{
		//그리드형태의 보기를 목록형태의 보기로 변경
		item.each(function(){
			var $div = $(this).children('div'), $a = $(this).find('a.show');
			tag += '<tr><td><a class="show" data-x='+ $a.data('x') 
										+ ' data-y='+ $a.data('y') +'>'+ $div.eq(0).text() +'</a></td>'
				+ '<td>'+ $div.eq(1).text() +'</td>'
				+ '<td class="left">'+ $div.eq(2).text() +'</td>'
				+ '</tr>';
		});
	}
	$('#data-list table tbody').append( tag );
}

//약국 목록보기 -> 그리드보기
function pharmacy_grid_view( item, api ){
	var tag = '<ul class="grid pharmacy"></ul>';
	$('#data-list').html( tag );
	
	tag = '';
	if( api ){
		//공공데이터포털에서 api를 요청해 응답받을 데이터로 그리드형태의 표현
		item.each(function(){
			tag += '<li>'
				+  '    <div><a class="show" data-x='+ this.XPos 
										 + ' data-y=' + this.YPos + ' >'+ this.yadmNm +'</a></div>'
				+  '    <div>'+ (this.telno ? this.telno : '-') +'</div>'
				+  '    <div>'+ this.addr +'</div>'
				+  '</li>';
		});		
		
	}else{
		//목록형태보기를 그리드형태보기로 변경
		item.each(function(){
			var $td = $(this).children('td'), $a = $(this).find('a.show');
			tag += '<li>'
				+  '    <div><a class="show" data-x='+ $a.data('x')
										 + ' data-y=' + $a.data('y') + ' >'+ $td.eq(0).text() +'</a></div>'
				+  '    <div>'+ $td.eq(1).text() +'</div>'
				+  '    <div>'+ $td.eq(2).text() +'</div>'
				+  '</li>';
		});
	}
	$('#data-list ul').append( tag );
}

$('#popup-background').click( function(){
	$('#popup').empty();
	$('#popup, #popup-background').css('display', 'none');
});

$(function(){
	$('.option a').eq(1).trigger('click'); //클릭이벤트 강제발생
});

$('#pageList').change(function(){
	pageList = $(this).val();
	if( $('.pharmacy').length>0 ) 		pharmacy_list(1);	
	else if( $('.animal').length>0 ) 	animal_list(1);	
});

$('.option a').click(function(){
	$('.option a').removeClass();
	$(this).addClass('btn-fill'); //선택한 버튼
	$('.option a').not( $(this) ).addClass('btn-empty'); //선택되지 않은 모든 버튼
	var idx = $(this).index();
	if( idx==0 )			pharmacy_list( 1 );
	else if( idx==1 )		animal_list( 1 );
});

//약국정보조회
function pharmacy_list( page ){
	$('.animal-top').empty();
	//$('.page-list').html('');
	$('.page-list').empty();
	loading(true);
	
	$.ajax({
		url: 'data/pharmacy',
		data: { pageNo: page, rows: pageList },
		success: function( response ){
			console.log( response );
			if( viewType=='list')	pharmacy_list_view( $(response.item), true );
			else					pharmacy_grid_view( $(response.item), true );

			makePage(response.count, page);
			loading(false);
			
		},error: function(req, text){
			alert(text+':'+req.status);
			loading(false);
		}
	});
}


var pageList = 10, blockPage = 10; //페이지당 보여질 목록수, 블럭당 보여질 페이지수
function makePage(totalList, curPage){
	var totalPage = Math.ceil(totalList / pageList); //총페이지수 : 4.0, 4.1, 4.5, 4.8 ->5
	var totalBlock = Math.ceil(totalPage / blockPage); //총블럭수
	var curBlock = Math.ceil(curPage / blockPage); //현재블럭번호
	var endPage = curBlock * blockPage; //끝 페이지번호
	var beginPage = endPage - (blockPage-1); //시작 페이지번호
	if( endPage > totalPage ) endPage = totalPage;
	
	var tag = '';
	
	if( curBlock > 1 ){
		tag += '<a data-page=1><i class="fa-solid fa-angles-left"></i></a>'
			+  '<a data-page='+ (beginPage-blockPage) +'><i class="fa-solid fa-angle-left"></i></a>';
	}
	
	for(var no=beginPage; no<=endPage; no++){
		if(no==curPage) tag += '<span>'+ no +'</span>';
		else			tag += '<a data-page='+ no + '>'+ no +'</a>';
	}
	
	if( curBlock < totalBlock ){
		tag += '<a data-page='+ (endPage+1) +'><i class="fa-solid fa-angle-right"></i></a>'
			 + '<a data-page='+ totalPage +'><i class="fa-solid fa-angles-right"></i></a>';	
	}
	
	$('.page-list').html( tag );
}

$(document).on('click', '.page-list a', function(){
	//페이지번호 선택
	if( $('.pharmacy').length>0 )		pharmacy_list( $(this).data('page') );
	else if( $('.animal').length>0 )	animal_list( $(this).data('page') );
	
}).on('click', '.show', function(){
	//약국명 클릭
	//위경도값이 없는 경우 위치를 지도에 띄울수 없다
	if( $(this).data('x') =='undefined' || $(this).data('y') =='undefined' ){
		alert('위경도가 없어 위치를 표시할 수 없습니다');
	}else{
		//showGoogleMap( $(this) );	
		showKakaoMap( $(this) );	
	}
	
}).on('click', '.animal img', function(){
	$('#popup, #popup-background').css('display', 'block');
	$('#popup').html( $(this).clone() );
})
;

//카카오맵지도에 약국위치표시
function showKakaoMap( show ){
	$('#popup, #popup-background').css('display', 'block');
	var xy = new kakao.maps.LatLng( Number(show.data('y')), Number(show.data('x')) );
	var container = document.getElementById('popup'); //지도를 담을 영역의 DOM 레퍼런스
	var options = { //지도를 생성할 때 필요한 기본 옵션
		center: xy, 		//지도의 중심좌표.
		level: 3 			//지도의 레벨(확대, 축소 정도)
	};

	var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
	// 마커를 생성합니다
	var marker = new kakao.maps.Marker({
	    position: xy
	});
	// 마커가 지도 위에 표시되도록 설정합니다
	marker.setMap(map);
	
	// 인포윈도우를 생성합니다
	var infowindow = new kakao.maps.InfoWindow({
	    position : xy, 
	    content : '<div style="padding:10px" class="marker">'+ show.text() +'</div>' 
	});
	// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
	infowindow.open(map, marker); 
}

//구글맵지도에 약국위치표시
function showGoogleMap( show ){
	$('#popup, #popup-background').css('display', 'block');
	
	//위경도 위치
  	const xy = { lat: Number(show.data('y')), lng: Number(show.data('x')) };
	// The map, centered at 선택된 약국
	const map = new google.maps.Map(document.getElementById("popup"), {
	    zoom: 15,
	    center: xy,
 	});
	// The marker, positioned at 선택된 약국
  	const marker = new google.maps.Marker({
	    position: xy,
	    map: map,
	    title: show.text(),
  	});
	
	const infowindow = new google.maps.InfoWindow({
  	    content: '<div class="marker">'+ show.text() +'</div>',
  	});
	infowindow.open({
	    anchor: marker,
	    map,
    });
}
</script>
</body>
</html>
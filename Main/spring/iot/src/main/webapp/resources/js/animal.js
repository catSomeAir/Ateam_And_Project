/**
 * 유기동물 관련처리
 */
 
//축종태그작성
function animal_type(){
//	축종코드
// - 개 : 417000
// - 고양이 : 422400
// - 기타 : 429900
//
	var tag
	= '<li>'
	+ '<select class="w-px100" id="upkind">'
	+ '<option value="">축종선택</option>'
	+ '<option value="417000">개</option>'
	+ '<option value="422400">고양이</option>'
	+ '<option value="429900">기타</option>'
	+ '</select>'
	+ '</li>';
	$('.animal-top').append( tag );	
} 

//리스트보기형태를 그리드보기형태로 변경
function animal_grid_view( item ){
	var tag = "<ul class='grid animal'></ul>";
	$('#data-list').html( tag );
	
	tag = '';
	
	if( item.length==0 ){
		tag = "<li style='width:100%; height:40px !important; padding-top:7px; margin-right:0;'>해당 유기동물이 없습니다</li>";
	}else{
	
		//tbody 가 10개
		item.each(function(){
			var animal = new Object();
			var $tr = $(this).children('tr'); //tbody안에 tr이 4개
			$tr.each(function(idx){
				var $td = $(this).children('td');
				if( idx==0 ){
					animal.popfile = $td.find('img').attr('src');
					animal.sexcd = $td.eq(1).text();
					animal.age = $td.eq(2).text();
					animal.weight = $td.eq(3).text();
					animal.colorcd = $td.eq(4).text();
					animal.happendt = $td.eq(5).text();
				}else if( idx==1 ){
					animal.specialmark = $td.eq(0).text();
				}else if( idx==2 ){
					animal.happenplace = $td.eq(0).text();
					animal.processstate = $td.eq(1).text();
				}else if( idx==3 ){
					animal.carenm = $td.eq(0).text();
					animal.careaddr = $td.eq(1).text();
					animal.caretel = $td.eq(2).text();
				}			
			});
			tag 
			+= "<li"
			 + " data-popfile='"+ animal.popfile +"' " 
			 + " data-sexcd='"+ animal.sexcd +"' " 
			 + " data-age='"+ animal.age +"' " 
			 + " data-weight='"+ animal.weight +"' " 
			 + " data-colorcd='"+ animal.colorcd +"' " 
			 + " data-happendt='"+ animal.happendt +"' " 
			 + " data-specialmark='"+ animal.specialmark +"' " 
			 + " data-happenplace='"+ animal.happenplace +"' " 
			 + " data-processstate='"+ animal.processstate +"' " 
			 + " data-carenm='"+ animal.carenm +"' " 
			 + " data-careaddr='"+ animal.careaddr +"' " 
			 + " data-caretel='"+ animal.caretel +"' " 
			 + ">"
			 + "	<div class='info'>"
			 + "		<div><img src='"+ animal.popfile  +"'></div>"
			 + "		<div>"
			 + "			<span>"+ animal.age +"</span>"
			 + "			<span>"+ animal.sexcd +"</span>"
			 + "		</div>"
			 + "		<div>"+ animal.weight +"</div>"
			 + "		<div>"+ animal.colorcd +"</div>"
			 + "		<div>"+ animal.processstate +"</div>"
			 + "	</div>"
			 + "	<div class='care'>"
			 + "		<span>"+ animal.carenm +"</span>"
			 + "		<span>"+ animal.happendt +"</span>"
			 + "	</div>"
		     + "</li>"		
		});
	}
	$('#data-list ul').append( tag );
} 

//그리드보기형태를 리스트보기형태로 변경
function animal_list_view( item ){
	var tag = '';
	
	if( item.find('div.info').length==0 ){
		tag = '<table class="tb-list animal">'
			+ '<thead><tr><td>해당 유기동물이 없습니다</td></tr></thead>'
			+ '</table>';
	}else{
	
		item.each(function(){ //li 10개
			tag += '<table class="tb-list animal">'
				+  "<colgroup>"
				+  "	<col width='100px'>"
				+  "	<col width='100px'><col width='80px'>"
				+  "	<col width='60px'><col width='120px'>"
				+  "	<col width='60px'><col width='100px'>"
				+  "	<col width='60px'><col>"
				+  "	<col width='100px'><col width='120px'>"
				+  "</colgroup>"
				+  "<tr>"
				+  "	<td rowspan='3'><img src='"+ $(this).data('popfile') +"'></td>"
				+  "	<th>성별</th>"
				+  "	<td>"+ $(this).data('sexcd') +"</td>"
				+  "	<th>나이</th>"
				+  "	<td>"+ $(this).data('age') +"</td>"
				+  "	<th>체중</th>"
				+  "	<td>"+ $(this).data('weight') +"</td>"
				+  "	<th>색상</th>"
				+  "	<td>"+ $(this).data('colorcd') +"</td>"
				+  "	<th>접수일자</th>"
				+  "	<td>"+ $(this).data('happendt') +"</td>"
				+  "</tr>"
				+  "	<tr><th>특징</th>"
				+  "	<td colspan='9' class='left'>"+ $(this).data('specialmark') +"</td>"
				+  "</tr>"
				+  "<tr><th>발견장소</th>"
				+  "	<td colspan='8' class='left'>"+ $(this).data('happenplace') +"</td>"
				+  "	<td>"+ $(this).data('processstate') +"</td>"
				+  "</tr>"
				+  "<tr>"
				+  "	<td colspan='2'>"+ $(this).data('carenm') +"</td>"
				+  "	<td colspan='7' class='left'>"+ $(this).data('careaddr') +"</td>"
				+  "	<td colspan='2'>"+ $(this).data('caretel') +"</td>"
				+  "</tr>"
				+  '</table>';
		});
	}
	$('#data-list').html( tag );
}
	
	
//시도조회
function animal_sido(){
	$.ajax({
		url: 'data/animal/sido',
		success: function( response ){
			$('.animal-top').prepend( response );
			animal_type();
		}
	});
}

$(document).on('change', '#upkind', function(){
	animal_kind(); 	//축종에 따른 품종 조회
	animal_list(1);
});

//축종에 따른 품종 조회
function animal_kind(){
	$('#kind').closest('li').remove();
	if( $('#upkind').val()=='' ) return;  //축종선택하지 않은경우 품종조회불가
	
	$.ajax({
		url: 'data/animal/kind',
		data: { upkind: $('#upkind').val() },
		success: function( response ){
			$('#upkind').closest('li').after( response );
		}
	});
}
	
//유기동물정보조회
function animal_list( page ){
	if( $('#sido').length==0 ) animal_sido();
	
	loading(true);
	$('#data-list').empty();
	$('.page-list').empty();
	
	var animal = new Object();
	animal.pageNo = page;
	animal.rows = pageList;
	animal.viewType = viewType;
	animal.sido = $('#sido').length>0 ? $('#sido').val() : ''; //시도
	animal.sigungu = $('#sigungu').length>0 ? $('#sigungu').val() : '';//시군구
	animal.shelter = $('#shelter').length>0 ? $('#shelter').val() : '';//보호소
	animal.upkind = $('#upkind').length>0 ? $('#upkind').val() : '';//축종
	animal.kind = $('#kind').length>0 ? $('#kind').val() : '';//품종
	
	$.ajax({
		url: 'data/animal/list',
		//data: { pageNo: page, rows: pageList },
		data: JSON.stringify(animal),
		type: 'post',
		contentType: 'application/json',
		success: function(response){
			//console.log( response );
			$('#data-list').html( response );
			loading(false);
			
		},error: function(req,text){
			alert(text+':'+req.status);
			loading(false);
		}
	});
	
}
	
	